package com.xpresso.qa.testcases.wallet.lending.weekendLoan;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.wallet.lending.weekendLoan.AddWeekendLoanPage;
import com.xpresso.qa.pages.wallet.lending.weekendLoan.WeekendLoanResultPage;
import com.xpresso.qa.utilites.DbMTEST;
import com.xpresso.qa.utilites.ExcelUtility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApproveWeekendLoanAdminTest  extends TestBase {

  HomePage homePage;
  LoginPage loginPage;

  SoftAssert softAssert;
  Actions action;
  ExcelUtility excelUtil;
  DbMTEST dbMTEST;
  WeekendLoanResultPage weekendLoanResultPage;
  AddWeekendLoanPage addWeekendLoanPage;

  Map<String, String> loan = new HashMap<>();
  @BeforeClass
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
  }

@Test(priority = 1,testName = "open loan detail on grid page")
  public void openLoan(){
    weekendLoanResultPage.enterLoanNumber("ROIE05418");
    weekendLoanResultPage.clickViewButton();
    weekendLoanResultPage.btnViewDetails();

  }
}
