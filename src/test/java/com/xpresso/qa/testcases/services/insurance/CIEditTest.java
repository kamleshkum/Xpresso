package com.xpresso.qa.testcases.services.insurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.careInsurance.CIMainPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIMobileOTPPOM2;
import com.xpresso.qa.pages.services.careInsurance.CIResultPage2;
import com.xpresso.qa.pages.services.careInsurance.DbClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CIEditTest extends TestBase {

    // TestUtility u=new TestUtility();
    int max = 99999999;
    int min = 10000000;
    String mobilenumber;
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
    CIMainPOM2 ciMainPOM;
    SoftAssert softAssert;
    CIResultPage2 ciResultPage;
    CIMobileOTPPOM2 ciMobileOTPPOM;
    DbClass dbClass;
    String premAmt;
    WebDriver webDriver;
    // CIPOM cipom;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(groups = { "Sanity" })
    public void enterFirstPart() throws SQLException, InterruptedException {
	int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
	mobilenumber = "6" + randomWithMathRandom + "6";
	// Initialize the WebDriver for each test
	Browserintialize("chrome", "https://uatxpro.roinet.in/Login.aspx");
	// usernameUser=CSP248877
	// passwordUser=roinet@1234
	// String usernameAdmin = getProperty("usernameCSP");
	// String passwordAdmin = getProperty("passwordAdmin");
	// cipom=new CIPOM(driver);
	loginPage = new LoginPage();
	homePage = new HomePage();
	ciMainPOM = new CIMainPOM2();
	ciResultPage = new CIResultPage2();
	ciMobileOTPPOM = new CIMobileOTPPOM2();
	softAssert = new SoftAssert();
	dbClass = new DbClass();
	loginPage.login("CSP221853", "roinet@1234", "sddds");
	loginPage.Login_With_OTP("222111");
	System.out.println("this is the mobile number: " + mobilenumber);
	ciResultPage.goToCareInsurance();
	ciResultPage.clickAddButton();
	ciMobileOTPPOM.entermobileotp(mobilenumber);

	String query = "select * from lt_logotp where mobile='" + mobilenumber + "'";
	Reporter.log("this is query: " + query);
	try (ResultSet resultSet = dbClass.executeQuery(query)) {
	    while (resultSet.next()) {
		int getOtp = resultSet.getInt("otp");
		System.out.println("this is otp: " + getOtp);
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
	}
    }

    @Test(priority = 1, testName = "Edit With 50K and 2 Members",groups = { "Sanity" })
    public void editWithFiftyThousandTwoMembers() throws SQLException {
	editDetails("50K", "2");
    }

    @Test(priority = 2, testName = "Edit With 50K and 3 Members",groups = { "Sanity" })
    public void editWithFiftyThousandThreeMembers() throws SQLException {
	editDetails("50K", "3");
    }

    @Test(priority = 3, testName = "Edit With 50K and 4 Members",groups = { "Sanity" })
    public void editWithFiftyThousandFourMembers() throws SQLException {
	editDetails("50K", "4");
    }

    @Test(priority = 4, testName = "Edit With 50K and 5 Members",groups = { "Sanity" })
    public void editWithFiftyThousandFiveMembers() throws SQLException {
	editDetails("50K", "5");
    }

    @Test(priority = 5, testName = "Edit With 50K and 6 Members",groups = { "Sanity" })
    public void editWithFiftyThousandSixMembers() throws SQLException {
	editDetails("50K", "6");
    }

    @Test(priority = 6, testName = "Edit With 1L and 2 Members",groups = { "Sanity" })
    public void editWithOneLakhTwoMembers() throws SQLException {
	editDetails("1L", "2");
    }

    @Test(priority = 7, testName = "Edit With 1L and 3 Members",groups = { "Sanity" })
    public void editWithOneLakhThreeMembers() throws SQLException {
	editDetails("1L", "3");
    }

    public void editDetails(String sumIns, String numbermembers) throws SQLException {
	ciResultPage.resultView();
	// String propNumberBEdit=propnumberbeforeedit();
	String proposalnoBeforeEdit = propnumberbeforeedit();
	/*
	 * String proposalnoBeforeEdit = ""; String proposalNumberBeforeEdit =
	 * "select top 1 * from tm_careinsuranceproposerdetails where channelid=398921 order by createddate desc"
	 * ; try { try (ResultSet resultSet =
	 * dbClass.executeQuery(proposalNumberBeforeEdit)) { while (resultSet.next()) {
	 * proposalnoBeforeEdit = resultSet.getString("proposalno");
	 * System.out.println("prop number: " + proposalnoBeforeEdit); } }
	 */
	try {
	    System.out.println("prop number after while loop: " + proposalnoBeforeEdit);
	    // System.out.println("prop number in try block: "+propNumberBEdit);
	    ciMainPOM.searchproposalno(proposalnoBeforeEdit);
	} catch (Exception e) {
	    ciMainPOM.resultView();
	    /*
	     * try (ResultSet resultSet = dbClass.executeQuery(proposalNumberBeforeEdit)) {
	     * while (resultSet.next()) {
	     * System.out.println("proposal number in the catch "+proposalnoBeforeEdit);
	     * proposalnoBeforeEdit = resultSet.getString("proposalno");
	     * System.out.println("prop number in the catch: " + proposalnoBeforeEdit); } }
	     */
	    System.out.println("proposal number in catch block: " + proposalnoBeforeEdit);
	    ciMainPOM.searchproposalno(proposalnoBeforeEdit);
	}
	ciMainPOM.clickEditButton();
	ciMainPOM.enterFirstPart("Family Floater", sumIns, numbermembers, InsuPeriod, InsuProduct, InsuType,
		nomineeName, nRelation);
	int members = Integer.parseInt(numbermembers);
	if (members >= 2) {

	    addInsuredDetails(spouseyear, spousemonth, spousedate, spousegend, spouserel, spousetit, "Rohit", "Mathur");
	}
	for (int i = 3; i <= members; i++) {
	    // Generate new random indices for each iteration
	    addInsuredDetails(childyear, childmonth, childdate, childgend, childrel, childtit, "heuocc", "cuisc");
	}
	ciMainPOM.clickCalculatePremiumButton();
	ciMainPOM.paymentPopUp();
//   dbClass = new DbClass();
	String query = "select top 1* from lt_logotp where mobile='" + mobilenumber + "'";
	Reporter.log("this is query: " + query);
	ResultSet resultSet = dbClass.executeQuery(query);
	while (resultSet.next()) {
	    int getOtp = resultSet.getInt("otp");
	    Reporter.log("this is otp: " + getOtp);
	    ciMainPOM.enterOtpPayment(getOtp);
	}
	String polNumber = ciMainPOM.getPolicyNumber();
	System.out.println("policy number: " + polNumber);
	ciResultPage.resultView();
	// String propNumberAfterEdit=propnumberbeforeedit();
	String proposalnoAfterEdit = propnumberbeforeedit();
	/*
	 * String proposalnoAfterEdit = ""; String proposalNumberAfterEdit =
	 * "select top 1 * from tm_careinsuranceproposerdetails where channelid=398921 order by createddate desc"
	 * ;
	 * 
	 * try (ResultSet resultSet1 = dbClass.executeQuery(proposalNumberAfterEdit)) {
	 * while (resultSet1.next()) { proposalnoAfterEdit =
	 * resultSet1.getString("proposalno");
	 * System.out.println("prop number checking after edit: " +
	 * proposalnoAfterEdit); } }
	 */
	System.out.println("prop number after edit: " + proposalnoAfterEdit);
	ciResultPage.searchproposalno(proposalnoAfterEdit);
	String coverType = ciResultPage.coverTypeVerify();
	softAssert.assertEquals(coverType, "FAMILYFLOATER", "cover type does not match");
	softAssert.assertAll();

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

    public String propnumberbeforeedit() throws SQLException {
	String proposalnoBeforeEdit = "";
	String proposalNumberBeforeEdit = "select top 1 * from tm_careinsuranceproposerdetails where channelid=398921 order by createddate desc";

	try (ResultSet resultSet = dbClass.executeQuery(proposalNumberBeforeEdit)) {
	    while (resultSet.next()) {
		proposalnoBeforeEdit = resultSet.getString("proposalno");
		System.out.println("prop number: " + proposalnoBeforeEdit);
	    }
	}
	System.out.println("prop number after while loop: " + proposalnoBeforeEdit);
	return proposalnoBeforeEdit;
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

    @AfterMethod
    public void quit() {
	driver.close();
    }
    /*
     * @AfterClass public void afterClass() { // Quit the WebDriver after all tests
     * are done if (driverUAT != null) { driverUAT.quit(); // This will ensure the
     * driver is only quit once after all tests }
     */
}
