package com.xpresso.qa.testcases.services.insurance;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.careInsurance.CIMainPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIMobileOTPPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIResultPage2;
import com.xpresso.qa.pages.services.careInsurance.DbClass;

public class CIFormValidationTest extends TestBase {

    CIResultPage2 ciResultPage;
    CIMobileOTPPOM2 ciMobileOTPPOM;
    CIMainPOM2 ciMainPOM;
    SoftAssert softAssert;
	LoginPage loginPage;
	HomePage homePage;

    // Specify the path to your Excel file
    String excelFilePath = "C:\\Users\\rohit.mathur\\Roinet\\Xpresso\\src\\test\\java\\com\\xpresso\\qa\\testdata\\Xpresso_TestData.xlsx";

    // Instantiate the ExcelUtility class

	int max = 99999999;
	int min = 10000000;
	String mobilenumber;
    @BeforeClass(groups = { "Sanity" })
    public void initiate() throws InterruptedException {
		Browserintialize("chrome", "https://uatxpro.roinet.in/Login.aspx");
		loginPage=new LoginPage();
		homePage = new HomePage();
	/*Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
	lginPage = new LoginPage();
	hmPage = new HomePage();
	cmplntPage = new AddComplaintPage();
	util = new Testutil();
	authpge = new AuthenticationPage();*/
	// cipom=new CIPOM(driverUAT);
	ciMainPOM = new CIMainPOM2();
	// ciMandatoryMsgPOM=new CIMandatoryMsgPOM(driverUAT);
	ciResultPage = new CIResultPage2();
	ciMobileOTPPOM = new CIMobileOTPPOM2();

	softAssert = new SoftAssert();
		loginPage.login("CSP221853", "roinet@1234", "sddds");
		loginPage.Login_With_OTP("222111");
	//excelUtility = new ExcelUtility(excelFilePath);

    }

    @Test(priority = 1, groups = { "Sanity" })
    public void ciBasicDetailformValidation() throws SQLException, InterruptedException {
	int max = 99999999;
	int min = 10000000;
	int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
	String mobilenumber = "8" + randomWithMathRandom + "7";
	/*loger.info("Enter csp id, password and captcha");
	lginPage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
	loger.info("Enter OTP");
	lginPage.Login_With_OTP(prop.getProperty("OTP"));
	loger.info("Click on Help Desk module");*/
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

    @Test(priority = 3, groups = { "Sanity" })
    public void ciformValidationProposerFirstPart() {
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

    @Test(priority = 4, groups = { "Sanity" })
    public void ciformValidationProposerPerPart() {
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

    @Test(priority = 5, groups = { "Sanity" })
    public void ciformValidationProposerCommPart() {
	Reporter.log("proposer part");
	String[] proposerCommunicationMesssage = ciMainPOM.ProposerMandatoryCommunicationAddress();
	softAssert.assertEquals("Address Line1 is required", proposerCommunicationMesssage[0]);
	softAssert.assertEquals("State is required", proposerCommunicationMesssage[1]);
	softAssert.assertEquals("City is required", proposerCommunicationMesssage[2]);
	softAssert.assertEquals("Pin Code is required", proposerCommunicationMesssage[3]);
	softAssert.assertEquals("Please enter valid Email Address", proposerCommunicationMesssage[4]);
	softAssert.assertAll();

    }

    @Test(priority = 6, groups = { "Sanity" })
    public void ciformValidationInsuredFirstPart() {
	ciMainPOM.goToHomeAction();
	try {
	   /* // Example 1: Get the row count of a specific sheet
	    String sheetName = "CareInsurance";
	    String cTypeValue = excelUtility.getCellData(sheetName, 16, 1);
	    String sumInsured = excelUtility.getCellData(sheetName, 17, 1);
	    String insurancePeriod = excelUtility.getCellData(sheetName, 18, 1);
	    String numberMember = excelUtility.getCellData(sheetName, 19, 1);
	    String insuranceProduct = excelUtility.getCellData(sheetName, 20, 1);
	    String insuranceType = excelUtility.getCellData(sheetName, 21, 1);
	    String nomineeName = excelUtility.getCellData(sheetName, 22, 1);
	    String nomineeRel = excelUtility.getCellData(sheetName, 23, 1);

	    String year = excelUtility.getCellData(sheetName, 1, 1);
	    String month = excelUtility.getCellData(sheetName, 2, 1);
	    String date = excelUtility.getCellData(sheetName, 3, 1);
	    String firstname = excelUtility.getCellData(sheetName, 4, 1);
	    String lastname = excelUtility.getCellData(sheetName, 5, 1);
	    String title = excelUtility.getCellData(sheetName, 6, 1);
	    String gend = excelUtility.getCellData(sheetName, 7, 1);
	    String rel = excelUtility.getCellData(sheetName, 8, 1);

	    String add1 = excelUtility.getCellData(sheetName, 9, 1);
	    String add2 = excelUtility.getCellData(sheetName, 10, 1);
	    String area = excelUtility.getCellData(sheetName, 11, 1);
	    String pstate = excelUtility.getCellData(sheetName, 12, 1);
	    String pcity = excelUtility.getCellData(sheetName, 13, 1);
	    String ppincode = excelUtility.getCellData(sheetName, 14, 1);
	    String propEmail = excelUtility.getCellData(sheetName, 15, 1);*/

	    ciMainPOM.enterFirstPart("Individual", "50K", "1", "1Y", "Group Care 360°(ROINET)-GMC",
		    "Health Insurance", "Rohit", "BROTHER");
	    ciMainPOM.proposerDetailEnter("1990", "Jul", "3", "Rohit", "dicu", "Male", "SELF", "Mr.");
	    ciMainPOM.enterProposerPermanentAddress("poipoo ouwep pipi pi", "add2", "area", "DELHI &", "Gurgaon", "122012", "cdicu@cdc.in");
	} catch (Exception e) {
	    System.out.println("check this error because of excel upload" + e.getMessage());

	}

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

    @Test(priority = 7, groups = { "Sanity" })
    public void ciformValidationInsuredPerPart() {
	Reporter.log("insured premanent address part");
	String[] insuredPermanentMessage = ciMainPOM.InsuredMandatoryPermanentAddress();
	softAssert.assertEquals("Address Line1 is required", insuredPermanentMessage[0]);
	softAssert.assertEquals("State is required", insuredPermanentMessage[1]);
	softAssert.assertEquals("City is required", insuredPermanentMessage[2]);
	softAssert.assertEquals("Pin Code is required", insuredPermanentMessage[3]);
	softAssert.assertAll();

    }

    @Test(priority = 8, groups = { "Sanity" })
    public void ciformValidationInsuredCommPart() {
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
