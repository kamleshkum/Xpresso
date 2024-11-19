package com.xpresso.qa.pages.services.careInsurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CIMobileOTPPOM {

  //Care Insurance Enter Mobile and Otp and check for mandatory messages
  @FindBy(id = "mobleNumber11")
  private WebElement mobilenumber;

  @FindBy(id = "otpNumber")
  private WebElement OtpCI;

  @FindBy(xpath = "//div[@class='col-md-6 text-end']//button[contains(.,'Submit')]")
  private WebElement submitButton;

  @FindBy(xpath = "//div[@class='invalid-feedback' and contains(.,' Please Enter Valid Contact Number ')]")
  private WebElement mobilemandatory;

  @FindBy(xpath = "//div[@class='invalid-feedback' and contains(.,' Please enter valid OTP ')]")
  private WebElement otpmandatory;

  @FindBy(xpath = "//div[@class='invalid-feedback checkRed' and contains(.,' You must agree to the terms and conditions. ')]")
  private WebElement checkboxmandatory;

  @FindBy(id = "flexCheckDefault12345")
  private WebElement selectCheckbox;

  @FindBy(xpath = "//div[@class='col-md-3']//span[@class='optSend']")
  private WebElement sendotp;

WebDriver driver;
WebDriverWait wait;
  public CIMobileOTPPOM(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver,this);
    wait=new WebDriverWait(driver, Duration.ofSeconds(60));
  }

  public void entermobileotp(String mobile) {
    mobilenumber.sendKeys(mobile);
    sendotp.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']//p")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']//p")));

  }

  public void enterOtp(int otp) {
    wait.until(ExpectedConditions.visibilityOf(OtpCI));
    OtpCI.sendKeys("" + otp);
    selectCheckbox.click();
    submitButton.click();
  }
}
