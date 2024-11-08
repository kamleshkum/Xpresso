package com.xpresso.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.AddComplaintPage;
import com.xpresso.qa.pages.AuthenticationPage;
import com.xpresso.qa.pages.HomePage;
import com.xpresso.qa.pages.LoginPage;
import com.xpresso.qa.utilites.Testutil;

@Listeners(com.xpresso.qa.ExtentReportListner.ExtentReport.class)
public class Helpdesk_CspAddComplaintTest extends TestBase {

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

	@Test(priority = 0, groups= {"Sanity"})
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

	@Test(priority = 1,groups= {"Sanity"})
	public void ValidateWithBlank_ApplicationType() {
		loger.info("Enter csp id, password and captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on HELPDESK");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on Add complaint");
		CmplntPage.ClickOnAddCmplaintTab();
		loger.info("Click on Advance button config page");
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

	@Test(priority = 2, enabled = false)
	public void ValidateWithBlank_CategoryType() {
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		Hmpage.ClickonHELPDESK();
		CmplntPage.ClickOnAddCmplaintTab();

		CmplntPage.SelectAppType("XPRESSO");
		CmplntPage.EnterDescription("Testing from IT Team");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankCatgryType();
		Assert.assertEquals(mssge, "Category Type is required");

	}

	@Test(priority = 3, enabled = false)
	public void ValidateWithBlank_SubCategoryType() {
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		Hmpage.ClickonHELPDESK();
		CmplntPage.ClickOnAddCmplaintTab();
	
		CmplntPage.SelectAppType("XPRESSO");
		
		CmplntPage.SelectCtgryType("Aadhar Pay");
		CmplntPage.EnterDescription("Testing from IT Team");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankSubCatgryType();
		Assert.assertEquals(mssge, "Sub Category is required");

	}

	@Test(priority = 4, enabled = false)
	public void AddNewComplaint_BlankTxID() {
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		Hmpage.ClickonHELPDESK();
		CmplntPage.ClickOnAddCmplaintTab();
	
		CmplntPage.SelectAppType("XPRESSO");
		
		CmplntPage.SelectCtgryType("Aadhar Pay");
	
		CmplntPage.SelectSubCtgryType("Transaction Issue Related Query");
		CmplntPage.EnterDescription("Testing from IT Team");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankTxId();
		Assert.assertEquals(mssge, "Transaction Id is required");

	}

	@Test(priority = 5, enabled = false)
	public void ValidateWithBlank_ComplaintDsc() {
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		Hmpage.ClickonHELPDESK();
		CmplntPage.ClickOnAddCmplaintTab();
		
		CmplntPage.SelectAppType("XPRESSO");
	
		CmplntPage.SelectCtgryType("Aadhar Pay");
		
		CmplntPage.SelectSubCtgryType("Transaction Issue Related Query");
		CmplntPage.Enter_TransactionID("12342");
		CmplntPage.ClickonSaveBttn();
		String mssge = CmplntPage.GetErrorMssge_BlankComplaintDesc();
		Assert.assertEquals(mssge, "Description is required");

	}

	@Test(enabled = false)
	public void AddNewComplaint_InvalidTxID() {

	}

	@AfterMethod (groups= {"Sanity"})
	public void CloseBrowser() {
		TearDown();
	}

}
