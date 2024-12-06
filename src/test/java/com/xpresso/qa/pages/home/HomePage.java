package com.xpresso.qa.pages.home;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xpresso.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//h2[normalize-space()='WELCOME TO Silver PARTNER']")
	WebElement HeadingPartnrType;

	@FindBy(xpath = "//p[contains(text(),'Santosh')]")
	WebElement Logedusername;

	@FindBy(xpath = "//span[@id='lblAvailLimit']")
	WebElement AvailaibleBalance;
	
	@FindBy(xpath = "//img[@id='Img']")
	WebElement XpressoImage;
	
	@FindBy(xpath = "//img[@id='imgPerformance']")
	WebElement performance;
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	WebElement Home;
	
	@FindBy(xpath="//i[@class='fa fa-user-circle-o']")
	WebElement UsrInfo;
	
	@FindBy(xpath = "//a[text()='CHANNEL']")
	WebElement Channel;
	
	@FindBy(xpath="//a[text()='Covid Widow']")
	WebElement CovidWidowTab;

	@FindBy(xpath = "//a[text()='WALLET']")
	WebElement WALLET;

	 @FindBy(xpath = "//a[contains(.,'SERVICES ')]")
	  WebElement SERVICES;

	@FindBy(xpath = "//a[text()='PAN CARD']")
	WebElement PANCARD;

	@FindBy(xpath = "//*[contains(text(),'HELPDESK ')]")
	WebElement HELPDESK;

	@FindBy(xpath = "//a[text()='MIS']")
	WebElement MIS;

	@FindBy(xpath = "//a[text()='DOCUMENT CENTER']")
	WebElement DOCUMENTCENTER;
	
	@FindBy(xpath = "//div[@class='supporting']/ul/li[1]")
	WebElement FarudAdvisory;
	
	@FindBy(xpath = "//div[@class='supporting']/ul/li[2]")
	WebElement CSpBusinessProfile;
	
	@FindBy(xpath = "//div[@class='supporting']/ul/li[3]")
	WebElement DownldYesBankIcard;
	
	
	@FindBy(xpath = "//div[@class='supporting']/ul/li[4]")
	WebElement DownldYesBankCertificate;
	
	@FindBy(xpath="//ul[@id='Menu2_Menuid']/li[1]/ul/li[4]")
	WebElement GoladLoanLead;
	
	@FindBy(xpath = "//a[contains(.,'Courier Service')]")
        WebElement courierService;
	
	 Actions actions;
	  WebDriverWait wait;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		  wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		  actions=new Actions(driver);
	}

	public String verifypagetitle() {
		return driver.getTitle();
	}
	
	

	public String verifyUserName() {
		return Logedusername.getText();

	}

	public String verifyBalance() {
		return AvailaibleBalance.getText();

	}
	public void goToCourierService(){
	    wait.until(ExpectedConditions.visibilityOf(SERVICES));
	    actions.moveToElement(SERVICES).perform();
	    actions.moveToElement(courierService).click().perform();


	  }
	
	public void ClickXpressoImge() {
		XpressoImage.click();

	}
	
	public void ClickonPerformnace() {
		performance.click();

	}
	
	public void ClickonHome() {
		Home.click();

	}

	public void ClickonChannel() {
		Channel.click();
	}

	public void ClickCovidWidowTab() {
		Channel.click();
		CovidWidowTab.click();
	}
	
	public void ClickonWALLET() {
		WALLET.click();
	}

	public void ClickonServices() {
		SERVICES.click();
	}

	public void ClickonPANCARD() {
		PANCARD.click();
	}

	public void ClickonHELPDESK() {
		HELPDESK.click();
	}

	public void ClickonMIS() {
		MIS.click();
	}

	public void ClickonDOCUMENTCENTER() {
		DOCUMENTCENTER.click();
	}
	
	public void ClickonAdvisoryLink() {
		FarudAdvisory.click();
	}
	
	public void ClickonCSpBusinessProfile() {
		CSpBusinessProfile.click();
	}
	
	public void ClickonDownldYesBankIcard() {
		DownldYesBankIcard.click();
	}
	
	public void ClickonDownldYesBankCertificated() {
		DownldYesBankCertificate.click();
	}
	
	//Click on Gold Loan Lead
	public void ClickonGoldLoanLead(){
		Channel.click();
		GoladLoanLead.click();
		
	}
	
	
	//Unwanted pop-up coming on hom page so added this method
	@FindBy(xpath="//i[@class='fa fa-close']")
	WebElement UnwabtedWindow;
	
	public void closeUnwantedWindow() {
		UnwabtedWindow.click();
	}
}
