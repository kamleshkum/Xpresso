package com.xpresso.qa.testcases.services.insurance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.authenticate.AuthenticationPage;
import com.xpresso.qa.pages.helpdesk.AddComplaintPage;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.careInsurance.DbClass;
import com.xpresso.qa.utilites.Testutil;

import com.xpresso.qa.pages.services.careInsurance.CIMainPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIMobileOTPPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIResultPage2;

public class CalculatePremiumErrorMessageTest extends TestBase {

    int max = 99999999;
    int min = 10000000;
    int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
    String mobilenumber = "6" + randomWithMathRandom + "6";

    String coverType = "Individual";
    String[] sinsure = { "50K", "1L", "3L", "5L" };
    Random random = new Random();
    int sinsuIndex = random.nextInt(sinsure.length);
    String numberOfMembers = "1";
    String InsuPeriod = "1Y";
    String InsuProduct = "Group Care 360°(ROINET)-GMC";
    String InsuType = "Health Insurance";
    String nomineeName = "Rohit";
    String[] nomineeRelation = { "BROTHER", "FATHER", "GRAND FATHER", "GRAND MOTHER", "BROTHER-IN-LAW", "MOTHER-IN-LAW",
	    "SISTER-IN-LAW", "MOTHER", "SISTER", "SON", "DAUGHTER", "WIFE", "HUSBAND" };
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
    CIMainPOM2 ciMainPOM;
    SoftAssert softAssert;
    CIResultPage2 ciResultPage;
    CIMobileOTPPOM2 ciMobileOTPPOM;
    LoginPage Lginpage;
    HomePage Hmpage;
    AddComplaintPage CmplntPage;
    Testutil util;
    AuthenticationPage authpge;

    @BeforeClass(groups = { "Sanity" })
    public void initiate() throws SQLException {
	// pomData.enterCredentials();
	Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
	ciMainPOM = new CIMainPOM2();
	ciResultPage = new CIResultPage2();
	ciMobileOTPPOM = new CIMobileOTPPOM2();
	softAssert = new SoftAssert();
	Lginpage = new LoginPage();
	Hmpage = new HomePage();
	CmplntPage = new AddComplaintPage();
	util = new Testutil();
    }

    @Test(priority = 1, testName = "gender mismatch error message verify", groups = { "Sanity" })
    public void calculatePremiumError() throws SQLException, InterruptedException {
	loger.info("Enter csp id, password and captcha");
	Lginpage.login("CSP221853", prop.getProperty("password"), prop.getProperty("captcha"));
	loger.info("Enter OTP");
	Lginpage.Login_With_OTP(prop.getProperty("OTP"));
	System.out.println("this is the mobile number: " + mobilenumber);
	ciResultPage.goToCareInsurance();
	ciResultPage.clickAddButton();
	ciMobileOTPPOM.entermobileotp(mobilenumber);
	DbClass dbClass = new DbClass();
	String query = "select * from lt_logotp where mobile='" + mobilenumber + "'";
	Reporter.log("this is query: " + query);
	try (ResultSet resultSet = dbClass.executeQuery(query)) {
	    while (resultSet.next()) {
		int getOtp = resultSet.getInt("otp");
		Reporter.log("this is otp: " + getOtp);
		ciMobileOTPPOM.enterOtp(getOtp);
		ciMobileOTPPOM.selectCheckbox();
		ciMobileOTPPOM.clickSubmit();
	    }
	}
	ciMainPOM.enterFirstPart(coverType, sinsure[sinsuIndex], numberOfMembers, InsuPeriod, InsuProduct, InsuType,
		nomineeName, nomineeRelation[nomineeRelIndex]);
	ciMainPOM.proposerDetailEnter(year, month, date, fname, lname, gend, rel, tit);
	ciMainPOM.enterProposerPermanentAddress(add1, add2, area, state, city, pincode, propEmail);
	ciMainPOM.ProposercheckboxPermCommSame();
	ciMainPOM.openInsuredBlock();
	ciMainPOM.addInsured();
	ciMainPOM.clickCalculatePremiumButton();
	// {*} Gender and title mismatch.
	String genderMsg = ciMainPOM.genderMismatch();
	softAssert.assertEquals("{*} Gender and title mismatch.", genderMsg, "gender message does not match");
	softAssert.assertAll();
    }

    /*
     * @AfterMethod(groups = { "Sanity" }) public void CloseBrowser() { TearDown();
     * }
     */
}
