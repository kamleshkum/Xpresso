package com.xpresso.qa.testcases.services.insurance;

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
import com.xpresso.qa.utilites.Testutil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormValidationNew extends TestBase {

    int max = 99999999;
    int min = 10000000;

    int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
    String mobilenumber = "7" + randomWithMathRandom + "7";
    String year = "1993";
    String month = "Sep";
    String date = "12";
    String firstname = "cdcdc";
    String lastname = "scdsdcf";
    String title = "Mr.";
    String gend = "Male";
    String rel = "SELF";
    String add1 = "adsda";
    String add2 = "eyoe";
    String area = "oioydos";
    String pstate = "Delhi &";
    String pcity = "Gurgaon";
    String ppincode = "122012";
    String propEmail = "acdo@cdoicuc.in";
    String cType = "Family Floater";
    String sInsu = "50K";
    String InsurancePeriod = "1Y";
    String nMember = "2";
    String InsuranceProduct = "Group Care 360°(ROINET)-GMC";
    String Itype = "Health Insurance";
    String nName = "sioc";
    String nRelation = "SON";
    CIResultPage ciResultPage;
    CIMobileOTPPOM ciMobileOTPPOM;
    CIMainPOM ciMainPOM;
    SoftAssert softAssert;
    LoginPage Lginpage;
    HomePage Hmpage;
    AddComplaintPage CmplntPage;
    Testutil util;
    AuthenticationPage authpge;

    @BeforeClass
    public void initiate() throws SQLException {
	Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
	Lginpage = new LoginPage();
	Hmpage = new HomePage();
	CmplntPage = new AddComplaintPage();
	util = new Testutil();
	authpge = new AuthenticationPage();
	// cipom=new CIPOM(driverUAT);
	ciMainPOM = new CIMainPOM(driver);
	// ciMandatoryMsgPOM=new CIMandatoryMsgPOM(driverUAT);
	ciResultPage = new CIResultPage(driver);
	ciMobileOTPPOM = new CIMobileOTPPOM(driver);
	softAssert = new SoftAssert();
	
	
    }

    @Test(priority = 1)
    public void CIformValidationFirstPart() throws SQLException {
	loger.info("Enter csp id, password and captcha");
	Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
	loger.info("Enter OTP");
	Lginpage.Login_With_OTP(prop.getProperty("OTP"));
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
	ciMainPOM.clickCalculatePremiumButton();
	String[] firstPartMandatoryMessages = ciMainPOM.firstPartMandatoryVerify();
	softAssert.assertEquals("Cover type is required", firstPartMandatoryMessages[0],
		"Cover type message does not match because Expected: Cover type is required but Actual: "
			+ firstPartMandatoryMessages[0]);
	softAssert.assertEquals("Sum Insured is required", firstPartMandatoryMessages[1],
		"Sum Insured message does not match because Expected: Sum Insured is required but Actual:"
			+ firstPartMandatoryMessages[1]);
	softAssert.assertEquals("No. of Members is required", firstPartMandatoryMessages[2],
		"Number of members message does not match because Expected: No. of Members is required but Actual:  "
			+ firstPartMandatoryMessages[2]);
	softAssert.assertEquals("Period is required", firstPartMandatoryMessages[3],
		"Period message does not match because Expected: Period is required but Actual: "
			+ firstPartMandatoryMessages[3]);
	softAssert.assertEquals("Products is required", firstPartMandatoryMessages[4],
		"Product message does not match because Expected: Products is required but Actual: "
			+ firstPartMandatoryMessages[4]);
	softAssert.assertEquals("Insurance Type is required", firstPartMandatoryMessages[5],
		"Insurance type message does not match because Expected: Insurance Type is required but Actual: "
			+ firstPartMandatoryMessages[5]);
	softAssert.assertAll();
    }

    @Test(priority = 3)
    public void CIformValidationProposerFirstPart() {
	Reporter.log("proposer part");
	String[] proposerFirstPartMandateVerify = ciMainPOM.ProposerMandatoryFirstPartVerify();

	softAssert.assertEquals("DOB is required", proposerFirstPartMandateVerify[0],
		"DOB proposer message does not match. Expected: DOB is required. Actual: "
			+ proposerFirstPartMandateVerify[0]);
	softAssert.assertEquals("Please enter valid First Name", proposerFirstPartMandateVerify[1],
		"First Name proposer message does not match. Expected: Please enter valid First Name. Actual: "
			+ proposerFirstPartMandateVerify[1]);
	softAssert.assertEquals("Please enter valid Last Name", proposerFirstPartMandateVerify[2],
		"Last Name proposer message does not match. Expected: Please enter valid Last Name. Actual: "
			+ proposerFirstPartMandateVerify[2]);
	softAssert.assertEquals("Gender is required", proposerFirstPartMandateVerify[3],
		"Gender message does not match. Expected: Gender is required. Actual: "
			+ proposerFirstPartMandateVerify[3]);
	softAssert.assertEquals("Relation is required", proposerFirstPartMandateVerify[4],
		"Relation message does not match. Expected: Relation is required. Actual: "
			+ proposerFirstPartMandateVerify[4]);
	softAssert.assertEquals("Title is required", proposerFirstPartMandateVerify[5],
		"Title message does not match. Expected: Title is required. Actual: "
			+ proposerFirstPartMandateVerify[5]);
	softAssert.assertAll();

    }

    @Test(priority = 4)
    public void CIformValidationProposerPerPart() {
	Reporter.log("proposer part");
	String[] proposerPermanentMessage = ciMainPOM.ProposerMandatoryPermanentAddress();
	softAssert.assertEquals("Address Line1 is required", proposerPermanentMessage[0],
		"proposer address line message does not match. Expected: Address Line1 is required. Actual: "
			+ proposerPermanentMessage[0]);
	softAssert.assertEquals("State is required", proposerPermanentMessage[1],
		"proposer state message does not match. Expected: State is required. Actual:"
			+ proposerPermanentMessage[1]);
	softAssert.assertEquals("City is required", proposerPermanentMessage[2],
		"propose city message does not match. Expected: City is required. Actual: "
			+ proposerPermanentMessage[2]);
	softAssert.assertEquals("Pin Code is required", proposerPermanentMessage[3],
		"proposer pincode message does not match. Expected: Pin Code is required. Actual: "
			+ proposerPermanentMessage[3]);
	softAssert.assertAll();
    }

    @Test(priority = 5)
    public void CIformValidationProposerCommPart() {
	Reporter.log("proposer part");
	String[] proposerCommunicationMesssage = ciMainPOM.ProposerMandatoryCommunicationAddress();
	softAssert.assertEquals("Address Line1 is required", proposerCommunicationMesssage[0]);
	softAssert.assertEquals("State is required", proposerCommunicationMesssage[1]);
	softAssert.assertEquals("City is required", proposerCommunicationMesssage[2]);
	softAssert.assertEquals("Pin Code is required", proposerCommunicationMesssage[3]);
	softAssert.assertEquals("Please enter valid Email Address", proposerCommunicationMesssage[4]);
	softAssert.assertAll();

    }

    @Test(priority = 6)
    public void CIformValidationInsuredFirstPart() {
	ciMainPOM.goToHomeAction();
	ciMainPOM.enterFirstPart(cType, sInsu, nMember, InsurancePeriod, InsuranceProduct, Itype, nName, nRelation);
	ciMainPOM.proposerDetailEnter(year, month, date, firstname, lastname, gend, rel, title);
	ciMainPOM.enterProposerPermanentAddress(add1, add2, area, pstate, pcity, ppincode, propEmail);
	ciMainPOM.ProposercheckboxPermCommSame();
	ciMainPOM.openInsuredBlock();
	ciMainPOM.addInsured();
	ciMainPOM.addInsured();
	Reporter.log("insured part");
	String[] insuredFirstPart = ciMainPOM.InsuredMandatoryFirstPartVerify();
	softAssert.assertEquals("DOB is required", insuredFirstPart[0]);
	softAssert.assertEquals("Please enter valid First Name", insuredFirstPart[1]);
	softAssert.assertEquals("Please enter valid Last Name", insuredFirstPart[2]);
	softAssert.assertEquals("Gender is required", insuredFirstPart[3]);
	softAssert.assertEquals("Relation is required", insuredFirstPart[4]);
	softAssert.assertEquals("Title is required", insuredFirstPart[5]);
	softAssert.assertAll();

    }

    @Test(priority = 7)
    public void CIformValidationInsuredPerPart() {
	Reporter.log("insured premanent address part");
	String[] insuredPermanentMessage = ciMainPOM.InsuredMandatoryPermanentAddress();
	softAssert.assertEquals("Address Line1 is required", insuredPermanentMessage[0]);
	softAssert.assertEquals("State is required", insuredPermanentMessage[1]);
	softAssert.assertEquals("City is required", insuredPermanentMessage[2]);
	softAssert.assertEquals("Pin Code is required", insuredPermanentMessage[3]);
	softAssert.assertAll();

    }

    @Test(priority = 8)
    public void CIformValidationInsuredCommPart() {
	Reporter.log("insured comm part");
	String[] insuredCommunicationMessage = ciMainPOM.InsuredMandatoryCommunicationAddress();
	softAssert.assertEquals("Address Line1 is required", insuredCommunicationMessage[0]);
	softAssert.assertEquals("State is required", insuredCommunicationMessage[1]);
	softAssert.assertEquals("City is required", insuredCommunicationMessage[2]);
	softAssert.assertEquals("Pin Code is required", insuredCommunicationMessage[3]);
	softAssert.assertEquals("Please enter valid Email Address", insuredCommunicationMessage[4]);
	softAssert.assertAll();

    }
}
