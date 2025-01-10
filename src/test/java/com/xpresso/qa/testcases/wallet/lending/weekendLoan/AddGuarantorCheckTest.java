package com.xpresso.qa.testcases.wallet.lending.weekendLoan;



import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.wallet.lending.weekendLoan.AddWeekendLoanPage;
import com.xpresso.qa.pages.wallet.lending.weekendLoan.WeekendLoanResultPage;
import com.xpresso.qa.utilites.DbMTEST;
import com.xpresso.qa.utilites.ExcelUtility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AddGuarantorCheckTest extends TestBase {
  HomePage homePage;
  LoginPage loginPage;

  SoftAssert softAssert;
  Actions action;
  ExcelUtility excelUtil;
  DbMTEST dbMTEST;
  WeekendLoanResultPage weekendLoanResultPage;
  AddWeekendLoanPage addWeekendLoanPage;
  String loanNumber="";
  @BeforeMethod
  public void setup() throws IOException {
    String excelPath = "C:\\Users\\rohit.mathur\\IdeaProjects\\Lending\\src\\LoanLending\\Data\\LongTermData.xlsx";
    Browserintialize("chrome", "https://uatxpresso.roinet.in/Login.aspx");
    excelUtil = new ExcelUtility(excelPath);
    weekendLoanResultPage=new WeekendLoanResultPage();
    addWeekendLoanPage=new AddWeekendLoanPage();
    homePage = new HomePage();
    loginPage = new LoginPage();

    softAssert = new SoftAssert();
    loginPage.login("MONA.SHARMA", "roinet@1234", "KMJKN");
    loginPage.Login_With_OTP("222111");
    homePage.ClickonWALLET();
    homePage.goToWeekendLoan();
    action = new Actions(driver);
    dbMTEST = new DbMTEST();
    File file = new File("loanNumberWithoutGuarantor.txt");


    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      // Read the loan number from the file
      loanNumber = reader.readLine(); // Assuming the loan number is on the first line
      System.out.println("Loan number read from file: " + loanNumber);
    } catch (IOException e) {
      e.printStackTrace();
    }
    weekendLoanResultPage.enterLoanNumber(loanNumber);
    weekendLoanResultPage.selectLoanStatus("--All--");
    weekendLoanResultPage.clickViewButton();
    weekendLoanResultPage.btnViewDetails();
  }

  @Test(priority = 1,testName = "make guarantor mandatory.")
  public void makeGuarantorMandatory(){
    addWeekendLoanPage.checkMandatoryGuarantor();
    addWeekendLoanPage.clickSaveButton();
    acceptAlert();
  }

  @AfterMethod
  public void quit(){
    driver.quit();

  }
}
