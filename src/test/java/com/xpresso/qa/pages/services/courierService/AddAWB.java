package com.xpresso.qa.pages.services.courierService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xpresso.qa.base.TestBase;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddAWB extends TestBase{

  //shipperCompName
  @FindBy(xpath = "//input[@formcontrolname='shipperCompanyName']")
  WebElement shipperCompName;

  //shipperName
  @FindBy(xpath = "//input[@formcontrolname='shipperName']")
  WebElement shipperName;

  //shipperAddressLine1
  @FindBy(xpath = "//input[@formcontrolname='shipperAddressLine1']")
  WebElement shipperAddressLine1;

  //shipperAddressLine2
  @FindBy(xpath = "//input[@formcontrolname='shipperAddressLine2']")
  WebElement shipperAddressLine2;

  //shipperAddressLine3
  @FindBy(xpath = "//input[@formcontrolname='shipperAddressLine3']")
  WebElement shipperAddressLine3;

  //shipperState
  @FindBy(xpath = "//input[@formcontrolname='shipperState']")
  WebElement shipperState;

  //shipperPhoneNumber
  @FindBy(xpath = "//input[@formcontrolname='shipperPhoneNumber']")
  WebElement shipperPhoneNumber;

  //shipperEmailAddress
  @FindBy(xpath = "//input[@formcontrolname='shipperEmailAddress']")
  WebElement shipperEmailAddress;

  //shipperGstinType
  @FindBy(xpath = "//input[@formcontrolname='shipperGstinType']")
  WebElement shipperGstinType;

  //shipperGstinNo
  @FindBy(xpath = "//input[@formcontrolname='shipperGstinNo']")
  WebElement shipperGstinNo;

  //consigneeCompanyName
  @FindBy(xpath = "//input[@formcontrolname='consigneeCompanyName']")
  WebElement consigneeCompanyName;

  //consigneeName
  @FindBy(xpath = "//input[@formcontrolname='consigneeName']")
  WebElement consigneeName;

  //consigneeAddressLine1
  @FindBy(xpath = "//input[@formcontrolname='consigneeAddressLine1']")
  WebElement consigneeAddressLine1;

  //consigneeAddressLine2
  @FindBy(xpath = "//input[@formcontrolname='consigneeAddressLine2']")
  WebElement consigneeAddressLine2;

  //consigneeAddressLine3
  @FindBy(xpath = "//input[@formcontrolname='consigneeAddressLine3']")
  WebElement consigneeAddressLine3;

  //consigneeState
  @FindBy(xpath = "//input[@formcontrolname='consigneeState']")
  WebElement consigneeState;

  //consigneeContactNo
  @FindBy(xpath = "//input[@formcontrolname='consigneeContactNo']")
  WebElement consigneeContactNo;

  //consigneeEmail
  @FindBy(xpath = "//input[@formcontrolname='consigneeEmail']")
  WebElement consigneeEmail;

  //consigneeGstinType
  @FindBy(xpath = "//input[@formcontrolname='consigneeGstinType']")
  WebElement consigneeGstinType;

  //consigneeGstinNo
  @FindBy(xpath = "//input[@formcontrolname='consigneeGstinNo']")
  WebElement consigneeGstinNo;

  @FindBy(xpath = "//div[@class='radioBox d-flex gap-3']//div[1]/input")
  WebElement selectYesPickup;
  //bookingTime
  @FindBy(xpath = "//input[@formcontrolname='bookingTime']")
  WebElement bookingTime;

  //shipmentInvoiceNo
  @FindBy(xpath = "//input[@formcontrolname='shipmentInvoiceNo']")
  WebElement shipmentInvoiceNo;

  //shipmentContent
  @FindBy(xpath = "//input[@formcontrolname='shipmentContent']")
  WebElement shipmentContent;

  @FindBy(xpath = "//div[@class='col-12 text-end mt-3 mb-4']//button[contains(.,'Submit')]")
  WebElement submitButton;

  //mobile
  @FindBy(xpath = "//input[@formcontrolname='mobile']")
  WebElement mobile;

  @FindBy(xpath = "//span[@class='optSend']")
  WebElement sendOTP;
  //mobileOTP
  @FindBy(xpath = "//input[@formcontrolname='mobileOTP']")
  WebElement mobileOTP;

  @FindBy(xpath = "//div[@class='modal-footer']//button[contains(.,'Submit')]")
  WebElement paymentConfirmSubmit;

  @FindBy(xpath = "//div[@class='selectFixed w-100']//button")
  WebElement bookingDateCalendarButton;

  @FindAll(@FindBy(xpath = "//div[@class='text-danger']"))
  List<WebElement> mandatoryMessgage;
  WebDriverWait wait;
  Actions action;

  public AddAWB() {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    action = new Actions(driver);
  }

  public void enterShipperDetail(String cName, String pName, String add1, String add2, String add3
        , String state, String cNumber, String email, String gstType, String gstNo) {
    wait.until(ExpectedConditions.visibilityOf(shipperCompName));
    action.moveToElement(shipperCompName).perform();
    shipperCompName.sendKeys(cName);
    shipperName.sendKeys(pName);
    shipperAddressLine1.sendKeys(add1);
    shipperAddressLine2.sendKeys(add2);
    shipperAddressLine3.sendKeys(add3);
    shipperState.sendKeys(state);
    shipperPhoneNumber.sendKeys(cNumber);
    shipperEmailAddress.sendKeys(email);
    shipperGstinType.sendKeys(gstType);
    shipperGstinNo.sendKeys(gstNo);
  }

  public void enterConsigneeDetails(String cName, String pName, String add1, String add2, String add3
        , String state, String cNumber, String email, String gstType, String gstNo) {
    wait.until(ExpectedConditions.visibilityOf(consigneeCompanyName));
    action.moveToElement(consigneeCompanyName).perform();
    consigneeCompanyName.sendKeys(cName);
    consigneeName.sendKeys(pName);
    consigneeAddressLine1.sendKeys(add1);
    consigneeAddressLine2.sendKeys(add2);
    consigneeAddressLine3.sendKeys(add3);
    consigneeState.sendKeys(state);
    consigneeContactNo.sendKeys(cNumber);
    consigneeEmail.sendKeys(email);
    consigneeGstinType.sendKeys(gstType);
    consigneeGstinNo.sendKeys(gstNo);

  }

  public void selectPickup() {
    selectYesPickup.click();
  }

  public void enterBookingTime(String h, String m, String s) {
    action.moveToElement(bookingTime).perform();
    bookingTime.sendKeys(h, m, s);
  }

  public void enterinvoicenumber(String invNumber) {
    shipmentInvoiceNo.sendKeys(invNumber);
  }

  public void enterContent(String content) {
    shipmentContent.sendKeys(content);
  }

  public void clickSubmit() {
    wait.until(ExpectedConditions.visibilityOf(submitButton));
    action.moveToElement(submitButton).perform();
    submitButton.click();
  }

  public void bookingDate(String year, String month, String date) {
    bookingDateCalendarButton.click();
    Select selectYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));

    Select selectMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
    selectYear.selectByVisibleText(year);
    selectMonth.selectByVisibleText(month);
    driver.findElement(By.xpath("//div[@class='btn-light' and text()='" + date + "']")).click();
  }

  public void otpPopUp(String mob, String otp) {
    wait.until(ExpectedConditions.visibilityOf(mobile));
    mobile.sendKeys(mob);
    sendOTP.click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']")));
    mobileOTP.sendKeys(otp);
    paymentConfirmSubmit.click();
    // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
  }

  public Map<String, Object> checkError() {
    String str = "";
    boolean b;
    Map<String, Object> result = new HashMap<>();
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-danger custom-toastbar-alert text-white']//p")));
      str = driver.findElement(By.xpath("//div[@class='alert alert-dismissable bg-danger custom-toastbar-alert text-white']//p")).getText();
      System.out.println("error text is: " + str);
      b = true;

    } catch (Exception e) {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']//p")));
      str = driver.findElement(By.xpath("//div[@class='alert alert-dismissable bg-danger custom-toastbar-alert text-white']//p")).getText();
      System.out.println("this is successful: " + str);
      b = false;
    }
    // Storing both the string and boolean in a Map
    result.put("message", str);
    result.put("status", b);

    return result;
  }
  public Map<String, String> mandatorymessageCheck() {
    Map<String, String> messages = new HashMap<>();
    System.out.println("mandate size" + mandatoryMessgage.size());
    String pickupRequest = mandatoryMessgage.get(0).getText();
    String bookingDate = mandatoryMessgage.get(1).getText();
    String bookingTime = mandatoryMessgage.get(2).getText();
    String content = mandatoryMessgage.get(3).getText();
    String shipperCompanyName = mandatoryMessgage.get(4).getText();
    String shipperName = mandatoryMessgage.get(5).getText();
    String shipperAddress1 = mandatoryMessgage.get(6).getText();
    String shipperAddress2 = mandatoryMessgage.get(7).getText();
    String shipperState = mandatoryMessgage.get(8).getText();
    String shipperEmail = mandatoryMessgage.get(9).getText();
    String consigneeCompanyName = mandatoryMessgage.get(10).getText();
    String consigneeName = mandatoryMessgage.get(11).getText();
    String consigneeAddress1 = mandatoryMessgage.get(12).getText();
    String consigneeAddress2 = mandatoryMessgage.get(13).getText();
    String consigneeState = mandatoryMessgage.get(14).getText();
    String consigneeEmail = mandatoryMessgage.get(15).getText();


    messages.put("pickupRequest", pickupRequest);
    messages.put("bookingDate", bookingDate);
    messages.put("bookingTime", bookingTime);
    messages.put("content", content);
    messages.put("shipperCompanyName", shipperCompanyName);
    messages.put("shipperName", shipperName);
    messages.put("shipperAddress1", shipperAddress1);
    messages.put("shipperAddress2", shipperAddress2);
    messages.put("shipperState", shipperState);
    messages.put("shipperEmail", shipperEmail);
    messages.put("consigneeCompanyName", consigneeCompanyName);
    messages.put("consigneeName", consigneeName);
    messages.put("consigneeAddress1", consigneeAddress1);
    messages.put("consigneeAddress2", consigneeAddress2);
    messages.put("consigneeState", consigneeState);
    messages.put("consigneeEmail", consigneeEmail);


    return messages;

  }
}
