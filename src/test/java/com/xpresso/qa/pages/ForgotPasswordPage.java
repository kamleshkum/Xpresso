package com.xpresso.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xpresso.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	@FindBy(id="txtUserCode")
	WebElement UserCode;
	
	@FindBy(id="txtEmail")
	WebElement UserEmail;
	
	@FindBy(id="txtCaptcha")
	WebElement CaptchaField;
	
	@FindBy(id="btnSubmit")
	WebElement Submitbuttn;
	
	@FindBy(id="btnCancel")
	WebElement CancelButtn;
	
	public void EnterUsrCode(String usr) {
		UserCode.sendKeys(usr);
	}
	
	public void EnterUsrEmail(String email) {
		UserEmail.sendKeys(email);
	}
	
	public void ClickonSubmit() {
		Submitbuttn.click();
	
	}
	
	public void ClickonCancel() {
		CancelButtn.click();
	
	}
	
	public void SubmitdDetails(String usr,String email) {
		UserCode.sendKeys(usr);
		UserEmail.sendKeys(email);
		Submitbuttn.click();
	
	}
	
	
	
	
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	
}
