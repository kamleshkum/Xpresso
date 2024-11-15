package com.xpresso.qa.pages.channel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xpresso.qa.base.TestBase;

public class GoldLoanLeadPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Generate Gold Loan Lead')]")
	WebElement GoldLoanhomePage;

	@FindBy(xpath = "//div[@id ='ContentPlaceHolder1_pnlAdd']/div[1]")
	WebElement PagetHeading;
	
	@FindBy(xpath = "//input[@value='Add']")
	WebElement Addbutton;

	@FindBy(xpath="//input[@value='INDIAGIFTSGOLD']")
	WebElement INDIAGIFTSGOLD;
	
	@FindBy(xpath="//select[@id='ContentPlaceHolder1_ddlPrefix']")
	WebElement PreFix;
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtName']")
	WebElement NameField;
	
	
	@FindBy(xpath="//input[@id='ContentPlaceHolder1_txtMobileNo']")
	WebElement MobileField;
	
	@FindBy(xpath="//input[@value='Send OTP']")
	WebElement SendOTPBttn;
	
	public GoldLoanLeadPage() {
		PageFactory.initElements(driver, this);

	}

	public void clickonGoldLoan() {
		GoldLoanhomePage.click();
	}

	public void ClickOnAddButton() {
		Addbutton.click();

	}

	public String verifyPageHeading() {
		return PagetHeading.getText();
	}

	//Click on INDIAGIFTSGOLD radio button
	public void ClickOnINDIAGIFTSGOLD() {
		INDIAGIFTSGOLD.click();
	}
	
	//Return Webelement Prefix
	public WebElement PreFix() {
		return PreFix;
	}
	
	public void PassName(String AnyName ) {
		NameField.sendKeys(AnyName);
	}
	
	public void PassMobile(String AnyMob ) {
		MobileField.sendKeys(AnyMob);
	}
	
	public void ClickonSendOTPBttn() {
		SendOTPBttn.click();
		
	}
}