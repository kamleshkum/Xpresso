package com.xpresso.qa.testcases.helpdesk;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.authenticate.AuthenticationPage;
import com.xpresso.qa.pages.helpdesk.ListComplaintPage;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;

@Listeners(com.xpresso.qa.extentReportListner.ExtentReport.class)
public class CspListComplaintTest extends TestBase {

	LoginPage Lginpage;
	HomePage Hmpage;
	ListComplaintPage ListCmplntPage;
	AuthenticationPage authPage;

	@BeforeMethod
	public void setup() {
		Browserintialize(prop.getProperty("browser"), prop.getProperty("Xpressourl"));
		Lginpage = new LoginPage();
		Hmpage = new HomePage();
		ListCmplntPage = new ListComplaintPage();
		authPage = new AuthenticationPage();
	}

	@Test (priority=0,groups= {"Sanity"})
	public void SearchWithDefaultValue_WithinValidaterange() {
		loger.info("Enter CSP code, Passwor and Captcha");
		Lginpage.login(prop.getProperty("CSP"), prop.getProperty("password"), prop.getProperty("captcha"));
		loger.info("Enter OTP");
		Lginpage.Login_With_OTP(prop.getProperty("OTP"));
		loger.info("Click on HelpDesk");
		Hmpage.ClickonHELPDESK();
		loger.info("Click on List Complaint");
		ListCmplntPage.ClickonListComplaint();
		loger.info("Authentication Validation");
		authPage.ValidateAuthentication();
		loger.info("Select Date in From Calendar");
		ListCmplntPage.SelectDateInFromCalend("2024", "Jan", "1");
		loger.info("Select Date in To Calendar");
		ListCmplntPage.SelectDateInToCalend("2024", "Jan", "26");
		ListCmplntPage.ClickonViewButton();
		ListCmplntPage.GridDataVerify();

	}

	@AfterMethod()
	public void CloseBrowser() {
		TearDown();
	}

}
