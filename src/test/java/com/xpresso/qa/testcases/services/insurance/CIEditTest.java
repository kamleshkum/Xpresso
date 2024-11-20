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
import com.xpresso.qa.pages.services.careInsurance.CIMainPOM;
import com.xpresso.qa.pages.services.careInsurance.CIMobileOTPPOM;
import com.xpresso.qa.pages.services.careInsurance.CIResultPage;
import com.xpresso.qa.pages.services.careInsurance.DbClass;
import com.xpresso.qa.utilites.ExcelUtility;
import com.xpresso.qa.utilites.Testutil;

public class CIEditTest extends TestBase {
    int max = 99999999;
    int min = 10000000;
    int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
    String mobilenumber = "6" + randomWithMathRandom + "6";
    // TestUtility u=new TestUtility();
    // String mobileNumber=u.randomMobileNumber();
    String coverType = "Individual";
    String[] sinsure = { "50K", "1L", "3L", "5L" };
    Random random = new Random();
    int sinsuIndex = random.nextInt(sinsure.length);
    String sumInsured = "50K";
    String nRelation = "MOTHER";
    String numberOfMembers = "1";
    String editNumberMember = "2";
    int numberOfMembersCompare = 1;
    String InsuPeriod = "1Y";
    int insuPeriodCompare = 1;
    String InsuProduct = "Group Care 360°(ROINET)-GMC";
    String InsuType = "Health Insurance";
    String nomineeName = "Rohit";
    String[] nomineeRelation = { "MOTHER", "SON", "DAUGHTER", "WIFE", "HUSBAND", "BROTHER", "FATHER", "GRAND FATHER",
	    "GRAND MOTHER", "MOTHER-IN-LAW", "SISTER-IN-LAW", "BROTHER-IN-LAW" };// "MOTHER","SON", "DAUGHTER", "WIFE",
										 // "HUSBAND", "BROTHER", "FATHER",
										 // "GRAND FATHER", "GRAND
										 // MOTHER","MOTHER-IN-LAW",
										 // "SISTER-IN-LAW","BROTHER-IN-LAW"
    int nomineeRelIndex = random.nextInt(nomineeRelation.length);

    String year = "1990";
    String month = "Jul";
    String date = "3";
    String fname = "iyu";
    String lname = "trtyt";
    String gend = "Male";
    String genderDB = "M";
    String rel = "SELF";
    String tit = "Mr.";
    String add1 = "poipoo ouwep pipi pi";
    String add2 = "trteyr erwerwiiu uiuiuiui";
    String area = "trte rtertert rtrwwwt";
    String state = "DELHI &";
    String city = "Gurgaon";
    String pincode = "122012";
    String propEmail = "pouipi@cwewrc.in";
    String dateCompare = "03/07/1990";
    String dateCompareDB = "1990-07-03";
    String stateCompare = "DELHI & NCR";
    String spouseyear = "1990";
    String spousemonth = "Jul";
    String spousedate = "3";
    String childyear = "2016";
    String childmonth = "Jul";
    String childdate = "3";
    String spousegend = "Female";
    String spouserel = "Spouse";
    String spousetit = "Ms.";
    String childgend = "Male";
    String childrel = "Son";
    String childtit = "Mr.";
    String proposerpermanentadd1 = "IOIU IOY YR IO UP";
    String proposerpermanentadd2 = "ATER IOAYUEUW POQ TU";
    String proposerpermanentarea = "IOY IOUPIO UPOAR";
    String proposerpermanentstate = "DELHI &";
    String proposerpermanentcity = "Gurgaon";
    String proposerpermanentpincode = "122012";
    String proposerEmail = "pouipi@cwewrc.in";
    
    CIResultPage ciResultPage;
    CIMobileOTPPOM ciMobileOTPPOM;
    CIMainPOM ciMainPOM;
    SoftAssert softAssert;
    LoginPage lginPage;
    HomePage hmPage;
    AddComplaintPage cmplntPage;
    Testutil util;
    AuthenticationPage authpge;
    @BeforeClass
    public void initiate() {

	Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
	lginPage = new LoginPage();
	hmPage = new HomePage();
	cmplntPage = new AddComplaintPage();
	util = new Testutil();
	authpge = new AuthenticationPage();
	// cipom=new CIPOM(driverUAT);
	ciMainPOM = new CIMainPOM(driver);
	// ciMandatoryMsgPOM=new CIMandatoryMsgPOM(driverUAT);
	ciResultPage = new CIResultPage(driver);
	ciMobileOTPPOM = new CIMobileOTPPOM(driver);
	softAssert = new SoftAssert();
	

    }

    /*
     * @Test(priority = 1, testName = "Navigate to Care Insurance Page") public void
     * CImain() throws SQLException { cipom.careInsurance();
     * Reporter.log("random number: " + mobilenumber);
     * cipom.entermobileotp(mobilenumber); DbClass dbClass = new DbClass(); String
     * query = "select * from lt_logotp where mobile='" + mobilenumber + "'";
     * Reporter.log("this is query: " + query); try (ResultSet resultSet =
     * dbClass.executeQuery(query)) { while (resultSet.next()) { int getOtp =
     * resultSet.getInt("otp"); Reporter.log("this is otp: " + getOtp);
     * cipom.enterOtp(getOtp); } }
     * 
     * }
     */

    @Test(priority = 1, testName = "filling first part")
    public void enterFirstPart() throws SQLException {
	System.out.println("this is the mobile number: " + mobilenumber);
	loger.info("Enter csp id, password and captcha");
	lginPage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
	loger.info("Enter OTP");
	lginPage.Login_With_OTP(prop.getProperty("OTP"));
	loger.info("Click on Help Desk module");
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
	    }
	}
	ciMainPOM.enterFirstPart(coverType, sinsure[sinsuIndex], numberOfMembers, InsuPeriod, InsuProduct, InsuType,
		nomineeName, nomineeRelation[nomineeRelIndex]);
    }

    @Test(priority = 2, testName = "filling proposer detail")
    public void enterProposerDetail() {
	ciMainPOM.proposerDetailEnter(year, month, date, fname, lname, gend, rel, tit);
	ciMainPOM.enterProposerPermanentAddress(add1, add2, area, state, city, pincode, propEmail);
	ciMainPOM.ProposercheckboxPermCommSame();
	ciMainPOM.openInsuredBlock();
	ciMainPOM.addInsured();
    }

    String premAmt;

    @Test(priority = 3, testName = "premium pop up open and close")
    public void calculatePremium() throws SQLException {
	ciMainPOM.calculatePremiumClick();
	premAmt = ciMainPOM.getPremiumAmount();
	System.out.println("premium amount checking: " + premAmt);
	boolean b = premAmt.isEmpty();
	if (premAmt.isEmpty()) {
	    Reporter.log(
		    "No action taken because  payment block is not opened. Hence policy is not generated. Check log for more information.");
	    softAssert.assertEquals(true, false);
	    softAssert.assertAll();
	} else {
	    ciMainPOM.premiumpopupClose();
	    ciMainPOM.resultView();
	    String proposalno = "";
	    try {
		DbClass dbClass = new DbClass();
		String query = "select top 1* from tm_careinsuranceproposerdetails where channelid=398921 order by createddate desc";
		try (ResultSet resultSet = dbClass.executeQuery(query)) {
		    while (resultSet.next()) {
			proposalno = resultSet.getString("proposalno");
			System.out.println("prop number: " + proposalno);
		    }
		}
		ciMainPOM.searchproposalno(proposalno);
	    } catch (Exception e) {
		ciMainPOM.resultView();
		DbClass dbClass = new DbClass();
		String query = "select top 1* from tm_careinsuranceproposerdetails where channelid=398921 order by createddate desc";
		try (ResultSet resultSet = dbClass.executeQuery(query)) {
		    while (resultSet.next()) {
			proposalno = resultSet.getString("proposalno");
			System.out.println("prop number: " + proposalno);
		    }
		}
		ciMainPOM.searchproposalno(proposalno);
	    }
	}
    }

    @Test(priority = 4)
    public void clickEdit() {
	ciMainPOM.clickEditButton();
    }

    @Test(priority = 5)
    public void editBasicDetails() throws SQLException {
	ciMainPOM.enterFirstPart("Family Floater", "50K", editNumberMember, InsuPeriod, InsuProduct, InsuType,
		nomineeName, nRelation);
	int members = Integer.parseInt(editNumberMember);
	if (members >= 2) {

	    addInsuredDetails(spouseyear, spousemonth, spousedate, spousegend, spouserel, spousetit, "Rohit", "Mathur");
	}
	for (int i = 3; i <= members; i++) {
	    // Generate new random indices for each iteration
	    addInsuredDetails(childyear, childmonth, childdate, childgend, childrel, childtit, "heuocc", "cuisc");
	}
	ciMainPOM.calculatePremiumClick();
	ciMainPOM.paymentPopUp();
	DbClass dbClass = new DbClass();
	String query = "select top 1* from lt_logotp where mobile='" + mobilenumber + "'";
	Reporter.log("this is query: " + query);
	ResultSet resultSet = dbClass.executeQuery(query);
	while (resultSet.next()) {
	    int getOtp = resultSet.getInt("otp");
	    Reporter.log("this is otp: " + getOtp);
	    ciMainPOM.enterOtpPayment(getOtp);
	}
	ciMainPOM.resultView();
    }

    private void addInsuredDetails(String year, String month, String date, String gender, String relation, String title,
	    String firstName, String LastName) {
	waitForElementAndPerform(
		() -> ciMainPOM.enterInsuredDetails(year, month, date, firstName, LastName, gender, relation, title));
	waitForElementAndPerform(() -> ciMainPOM.enterInsuredPermanentAddress(proposerpermanentadd1,
		proposerpermanentadd2, proposerpermanentarea, proposerpermanentstate, proposerpermanentcity,
		proposerpermanentpincode, mobilenumber, proposerEmail));
	ciMainPOM.InsuredcheckboxPermCommSame();
	ciMainPOM.addInsured();

    }

    // Helper method to wait for an action and perform it
    private void waitForElementAndPerform(Runnable action) {
	try {
	    action.run();
	} catch (Exception e) {
	    // Log the exception or handle as needed
	    Reporter.log("Error while performing action: " + e.getMessage());
	}
    }

    /*
     * @AfterTest public void quit(){ driverUAT.quit(); }
     */
}
