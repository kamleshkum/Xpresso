package com.xpresso.qa.testcases.helpdesk;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.authenticate.AuthenticationPage;
import com.xpresso.qa.pages.helpdesk.AddComplaintPage;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.utilites.Testutil;

@Listeners(com.xpresso.qa.ExtentReportListner.ExtentReport.class)
public class CspAddComplaintTest extends TestBase {

	LoginPage Lginpage;
	HomePage Hmpage;
	AddComplaintPage CmplntPage;
	Testutil util;
	AuthenticationPage authpge;

	@BeforeMethod(groups= {"Sanity"})
	public void setup() {
		Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
		Lginpage = new LoginPage();
		Hmpage = new HomePage();
		CmplntPage = new AddComplaintPage();
		util = new Testutil();
		authpge = new AuthenticationPage();

	}

	@Test(priority = 0, groups= {"Sanity"}, enabled=false)
	public void AddnewComplaintWithoutTXID() throws InterruptedException {
		loger.info("Enter csp id, password and captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk module");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint tab");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type");
		CmplntPage.SelectAppType("Xpresso");
		loger.info("Select Category type ");
		CmplntPage.SelectCtgryType("Aadhar Pay");
		loger.info("Select Sub Category type ");
		CmplntPage.SelectSubCtgryType("Transaction Issue Related Query");
		loger.info("Enter Description ");
		CmplntPage.EnterDescription("Testing from IT Team");
		loger.info("Click on Save button ");
		CmplntPage.ClickonSaveBttn();
		String actulerrmsg=CmplntPage.GetErrorMssge_BlankTxId();
		Assert.assertEquals(actulerrmsg, "Please Enter Valid Transaction Id");
	}

	@Test(priority = 1,groups= {"Sanity"},enabled=false)
	public void ValidateWithBlank_ApplicationType() {
		loger.info("Enter csp id, password and captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on HELPDESK");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add complaint");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Enter Description");
		CmplntPage.EnterDescription("Testing from IT Team");
		loger.info("Click on Save Button");
		CmplntPage.ClickonSaveBttn();
		loger.info("Assert with proper Verification Message");
		String mssge = CmplntPage.GetErrorMssge_BlankApplType();
		Assert.assertEquals(mssge, "Application Type is required");

	}

	@Test(priority = 2, groups= {"Sanity"},enabled=false)
	public void ValidateWithBlank_CategoryType() {
		loger.info("Enter CSP id, Password and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint Tab");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type as Xpresso");
		CmplntPage.SelectAppType("XPRESSO");
		loger.info("Enter Description");
		CmplntPage.EnterDescription("Testing from IT Team");
		loger.info("Clic on Save button");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankCatgryType();
		Assert.assertEquals(mssge, "Category Type is required");

	}

	@Test(priority = 3, groups={"Sanity"},enabled=false)
	public void ValidateWithBlank_SubCategoryType() {
		loger.info("Enter CSP id, Password and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint Tab");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type as Xpresso");
		CmplntPage.SelectAppType("XPRESSO");
		loger.info("Select Category type as Aadhar Pay");
		CmplntPage.SelectCtgryType("Aadhar Pay");
		loger.info("Enter description");
		CmplntPage.EnterDescription("Testing from IT Team");
		loger.info("Click on Save Button");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankSubCatgryType();
		Assert.assertEquals(mssge, "Sub Category is required");

	}


	@Test(priority = 4, groups= {"Sanity"},enabled=false)
	public void ValidateWithBlank_ComplaintDesc() {
		loger.info("Enter CSP id, Password and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type as XPRESSO");
		CmplntPage.SelectAppType("XPRESSO");
		loger.info("Select Category type as Aadhar Pay ");
		CmplntPage.SelectCtgryType("Aadhar Pay");
		loger.info("Select Sub Category Commissions Issue Related Query");
		CmplntPage.SelectSubCtgryType("Commissions Related Query");
		loger.info("Click on Save button");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankComplaintDesc();
		Assert.assertEquals(mssge, "Description is required");

	}

	@Test(priority = 5, groups= {"Sanity"},enabled=false)
	public void AddNewComplaint_InvalidTxID() {
		loger.info("Enter CSP id, Password and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type as XPRESSO");
		CmplntPage.SelectAppType("XPRESSO");
		loger.info("Select Category type as Aadhar Pay ");
		CmplntPage.SelectCtgryType("Aadhar Pay");
		loger.info("Select Sub Category Transaction Issue Related Query");
		CmplntPage.SelectSubCtgryType("Transaction Issue Related Query");
		loger.info("Enter Transaction ID");
		CmplntPage.Enter_TransactionID("12342");
		loger.info("Enter Description");
		CmplntPage.EnterDescription("Generating complaint for Testing");
		loger.info("Click on Save button");
		CmplntPage.ClickonSaveBttn();
		String alerMssge= CmplntPage.GetErrorMssge_InvalidTxID();
		Assert.assertEquals(alerMssge, "{*} Invalid Transaction Id");
		

	}
	@Test(priority = 6, groups= {"Sanity"})
	public void AddNewComlntwth_ValidData() {
		loger.info("Enter CSP id, Password and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on Help Desk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add Complaint");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Validate Authentication page");
		authpge.ValidateAuthentication();
		loger.info("Select Application type as XPRESSO");
		CmplntPage.SelectAppType("XPRESSO");
		loger.info("Select Category type as Aadhar Pay ");
		CmplntPage.SelectCtgryType("Aadhar Pay");
		loger.info("Select Sub Category as Commissions Issue Related Query");
		CmplntPage.SelectSubCtgryType("Commissions Related Query");
		CmplntPage.EnterDescription("Testing from IT Team");
		loger.info("Click on Save button");
		CmplntPage.ClickonSaveBttn();
		String SuesMssge=CmplntPage.GetSucessMssge_AddComplaint();
		System.out.println(SuesMssge);
		String arr[]=SuesMssge.split(".");
		System.out.println(arr);
		Assert.assertEquals("Our customer care will revert on your complaint soon", SuesMssge);
		//Your Complaint Id [1422511] saved successfully. Our customer care will revert on your complaint soon.
	}

	@AfterMethod (groups= {"Sanity"})
	public void CloseBrowser() {
		TearDown();
	}

}
