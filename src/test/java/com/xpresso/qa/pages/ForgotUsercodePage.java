package com.xpresso.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xpresso.qa.base.TestBase;

public class ForgotUsercodePage extends TestBase{
	
	
	@FindBy(xpath="//h5[contains(text(),'Forgot User Code')]")
	WebElement ForgotUsrheading;
	
	@FindBy(id="ddlUserType")
	WebElement UsrtypeField;
	
	@FindBy(id="rblValidateType_0")
	WebElement Emailradio;
	
	@FindBy(id="rblValidateType_1")
	WebElement Mbileradio;
	
	@FindBy(id="txtForgotUsercode_EmailMobile")
	WebElement EnterMobileField;
	
	@FindBy(id="btnForgotUserCodeSubmit")
	WebElement Submitbuttn;
	
	@FindBy(id="btnForgotUserCodeCancel")
	WebElement Cancelbuttn;
	
	public ForgotUsercodePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String GetForgtUsrcodeHeading() {
		return ForgotUsrheading.getText();
	}
	
	public void ClickonUSrType() {
		UsrtypeField.click();
	}
	
	public void Clickon_Mbileradio() {
		Mbileradio.click();
		
	}
	
	public void Clickon_EMAILradio() {
		Emailradio.click();
		
	}
	
	public void EnterEmail_Mobile(String EmiMob){
		
		EnterMobileField.sendKeys(EmiMob);
	}
	
	public void ClickonCancel() {
		Cancelbuttn.click();
	}
	public void ClickonSubmit() {
		Submitbuttn.click();
	}
}
