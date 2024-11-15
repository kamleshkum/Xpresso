package com.xpresso.qa.pages.authenticate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xpresso.qa.base.TestBase;

public class AuthenticationPage extends TestBase {

	@FindBy(xpath = "//div[@class='nav-wrapper']/button[3]")
	WebElement AdvancedBttn;

	@FindBy(xpath = "//a[text()='Proceed to uat.xpresso.roinet.in (unsafe)']")
	WebElement link;

	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}

	public void ValidateAuthentication() {

		AdvancedBttn.click();
		link.click();

	}

	

}
