package CareInsurance.Test;

import CareInsurance.Main.BaseClassUAT;
import CareInsurance.Main.CIPOM;
import CareInsurance.Main.DbClass;
import CareInsurance.Main.POMData;
import CareInsurance.Main.TestUtility;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.helpdesk.AddComplaintPage;
import com.xpresso.qa.pages.authenticate.AuthenticationPage;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.utilites.Testutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

@Listeners(com.xpresso.qa.ExtentReportListner.ExtentReport.class)
public class CalculatePremiumErrorMessageTest1 extends TestBase {
  TestUtility u=new TestUtility();
  String usernameAdmin;
  String passwordAdmin;
  int max = 99999999;
  int min = 10000000;
  int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
  String mobilenumber = "6" + randomWithMathRandom + "6";
  String mobileNumber=u.randomMobileNumber();
  String coverType = "Individual";
  String[] sinsure = {"50K", "1L", "3L", "5L"};
  Random random = new Random();
  int sinsuIndex = random.nextInt(sinsure.length);
  String numberOfMembers = "1";
  String InsuPeriod = "1Y";
  String InsuProduct = "Group Care 360°(ROINET)-GMC";
  String InsuType = "Health Insurance";
  String nomineeName = "Rohit";
  String[] nomineeRelation = {"BROTHER", "FATHER", "GRAND FATHER", "GRAND MOTHER", "BROTHER-IN-LAW",
        "MOTHER-IN-LAW", "SISTER-IN-LAW", "MOTHER", "SISTER", "SON", "DAUGHTER", "WIFE", "HUSBAND"};
  int nomineeRelIndex = random.nextInt(nomineeRelation.length);
  String year = "1990";
  String month = "Jul";
  String date = "3";
  String fname = "iyu";
  String lname = "trtyt";
  String gend = "Male";
  String rel = "SELF";
  String tit = "Ms.";
  String add1 = "poipoo ouwep pipi pi";
  String add2 = "trteyr erwerwiiu uiuiuiui";
  String area = "trte rtertert rtrwwwt";
  String state = "DELHI &";
  String city = "Gurgaon";
  String pincode = "122012";
  String propEmail = "pouipi@cwewrc.in";
  
  LoginPage Lginpage;
	HomePage Hmpage;
	AddComplaintPage CmplntPage;
	Testutil util;
	AuthenticationPage authpge;
	CIPOM cipom;
	
  @BeforeClass(groups= {"Sanity"})
  public void setup() throws SQLException {
      Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
	Lginpage = new LoginPage();
	Hmpage = new HomePage();
	CmplntPage = new AddComplaintPage();
	util = new Testutil();
	cipom=new CIPOM(driver);
	authpge = new AuthenticationPage();
  }

 
  
  @Test(priority = 1, testName = "gender mismatch error message verify",groups= {"Sanity"})
  public void calculatePremiumError() throws SQLException {
    System.out.println("this is the mobile number: "+mobileNumber);
    loger.info("Enter csp id, password and captcha");
	Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
	loger.info("Enter OTP");
	Lginpage.Login_With_OTP(prop.getProperty("OTP"));
	loger.info("Click on Help Desk module");
	cipom.careInsurance();
	    Reporter.log("random number: " + mobilenumber);
	    cipom.entermobileotp(mobilenumber);
	    DbClass dbClass = new DbClass();
	    String query = "select * from lt_logotp where mobile='" + mobilenumber + "'";
	    Reporter.log("this is query: " + query);
	    try (ResultSet resultSet = dbClass.executeQuery(query)) {
	      while (resultSet.next()) {
	        int getOtp = resultSet.getInt("otp");
	        Reporter.log("this is otp: " + getOtp);
	        cipom.enterOtp(getOtp);
	      }
	    }
    cipom.enterFirstPart(coverType, sinsure[sinsuIndex], numberOfMembers, InsuPeriod
          , InsuProduct, InsuType, nomineeName, nomineeRelation[nomineeRelIndex]);
    cipom.proposerDetailEnter(year, month, date, fname, lname, gend, rel, tit);
    cipom.enterProposerPermanentAddress(add1, add2, area, state,
          city, pincode, propEmail);
    cipom.ProposercheckboxPermCommSame();
    cipom.openInsuredBlock();
    cipom.addInsured();
    cipom.calculatePremiumClick();
    cipom.genderMismatch("{*} Gender and title mismatch..");
  }

	/*
	 * @AfterTest public void quit(){ driverUAT.quit(); }
	 */
}
