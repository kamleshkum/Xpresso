package com.xpresso.qa.pages.services.careInsurance;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CIMainPOM2 extends TestBase {

  //Care First Part Fields
  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[1]//input")
  private WebElement coverType;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[1]//span[@class='ng-arrow-wrapper']")
  private WebElement coverTypeArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[2]//input")
  private WebElement sumInsured;

  @FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']")
  private WebElement dropDownWait;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[2]//span[@class='ng-arrow-wrapper']")
  private WebElement sumInsuredArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[3]//input")
  private WebElement numberOfMembers;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[3]//span[@class='ng-arrow-wrapper']")
  private WebElement numberOfMembersArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[4]//input")
  private WebElement period;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[4]//span[@class='ng-arrow-wrapper']")
  private WebElement periodArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[5]//input")
  private WebElement product;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[5]//span[@class='ng-arrow-wrapper']")
  private WebElement productArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[6]//input")
  private WebElement insuranceType;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[6]//span[@class='ng-arrow-wrapper']")
  private WebElement insuranceTypeArrow;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[7]//input")
  private WebElement nomineeName;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[8]//input")
  private WebElement nomineeRelation;

  @FindBy(xpath = "//div[@class='row mt-1']//div[@class='row']/div[8]//span[@class='ng-arrow-wrapper']")
  private WebElement nomineeRelationArrow;

  //FIRST PART MANDATORY MESSAGE//
  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[1]//div[@class='invalid-feedback']")
  private WebElement coverTypeMan;

  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[2]//div[@class='invalid-feedback']")
  private WebElement sumInsuredMan;

  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[3]//div[@class='invalid-feedback']")
  private WebElement numberMemberMan;

  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[4]//div[@class='invalid-feedback']")
  private WebElement periodMan;

  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[5]//div[@class='invalid-feedback']")
  private WebElement productMan;

  @FindBy(xpath = "//div[@class='row mt-1']/form/div/div[6]//div[@class='invalid-feedback']")
  private WebElement insuranceTypeMan;

  //Proposer FIRST PART
  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='d-flex position-relative']//button")
  private WebElement calendarButtonProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//input[@id='firstName11']")
  private WebElement firstNameProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//input[@id='lastName12']")
  private WebElement lastNameProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[4]//input")
  private WebElement genderProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[4]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement genderArrowProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[5]//input")
  private WebElement relationProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[5]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement relationArrowProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[6]//input")
  private WebElement titleProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[6]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement titleArrowProposer;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//input[@formcontrolname='emailId']")
  private WebElement proposerEmail;


  //Proposer Permanent  Address
  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[8]//input")
  private WebElement proposerPermanentAddressLine1;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[9]//input")
  private WebElement proposerPermanentAddressLine2;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[10]//input")
  private WebElement proposerPermannentAddressArea;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[11]//input")
  private WebElement proposerPermanentState;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[11]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement proposerPermanentStateArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[12]//input")
  private WebElement proposerPermanentCity;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[12]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement proposerPermanentCityArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[13]//input")
  private WebElement proposerPermanentPinCode;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='cutomCheck']//input")
  private WebElement proposercheckbox;

  //Propose Comm Address
  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[16]//input")
  private WebElement proposerCommunicationAddressLine1;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[17]//input")
  private WebElement proposerCommunicationAddressLine2;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[18]//input")
  private WebElement proposerCommunicationtAddressArea;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[19]//input")
  private WebElement proposerCommunicationState;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[19]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement proposerCommunicationStateArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[20]//input")
  private WebElement proposerCommunicationCity;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[20]//ng-select//span[@class='ng-arrow-wrapper']")
  private WebElement proposerCommunicationCityArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[21]//input")
  private WebElement proposerCommunicationPinCode;

  //PROPOSER FIRST PART MANDATORY MESSAGE//
  @FindBy(xpath = "//button[contains(.,'Proposer Detail')]")
  private WebElement proposerDetailButton;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[1]//div[@class='text-danger']")
  private WebElement proposerDobMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[2]//div[@class='text-danger']")
  private WebElement proposerFirstNameMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[3]//div[@class='text-danger']")
  private WebElement proposerLastNameMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[4]//div[@class='invalid-feedback']")
  private WebElement proposerGenderMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[5]//div[@class='invalid-feedback']")
  private WebElement proposerRelationMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[6]//div[@class='invalid-feedback']")
  private WebElement proposerTitleMan;

  //PROPOSER PERMANENT ADDRESS PART MANDATORY MESSAGE//
  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[8]//div[@class='invalid-feedback']")
  private WebElement proposerPerAddLine1Man;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[11]//div[@class='invalid-feedback']")
  private WebElement proposerPerStateMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[12]//div[@class='invalid-feedback']")
  private WebElement proposerPerCityMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[13]//div[@class='invalid-feedback']")
  private WebElement proposerPerPincodeMan;

  //PROPOSER COMMUNICATION ADDRESS PART MANDATORY MESSAGE//
  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[16]//div[@class='invalid-feedback']")
  private WebElement proposerCommAddLine1Man;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[19]//div[@class='invalid-feedback']")
  private WebElement proposerCommStateMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[20]//div[@class='invalid-feedback']")
  private WebElement proposerCommCityMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[21]//div[@class='invalid-feedback']")
  private WebElement proposerCommPincodeMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[1]//div[@class='row pt-2']/div[23]//div[@class='invalid-feedback']")
  private WebElement proposerEmailMan;

  //Insured FIRST PART
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='d-flex position-relative']//button")
  private WebElement calendarButtonInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@id='firstName15']")
  private WebElement firstNameInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@id='lastName15']")
  private WebElement lastNameInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='genderId']//input")
  private WebElement genderInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='genderId']//span[@class='ng-arrow-wrapper']")
  private WebElement genderArrowInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='insuredRelationId']//input")
  private WebElement relationInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='insuredRelationId']//span[@class='ng-arrow-wrapper']")
  private WebElement relationArrowInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='titleId']//input")
  private WebElement titleInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='titleId']//span[@class='ng-arrow-wrapper']")
  private WebElement titleArrowInsured;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='emailId']")
  private WebElement insuredEmail;

  //Insured Detail Get
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[1]//input")
  private WebElement insuredDOBGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='firstName']")
  private WebElement insuredFnameGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='lastName']")
  private WebElement insuredLnameGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[4]//input")
  private WebElement insuredGender;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='genderId']//span[@class='ng-value-label']")
  private WebElement insuredGenderGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[5]//input")
  private WebElement insuredRelation;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='insuredRelationId']//span[@class='ng-value-label']")
  private WebElement insuredRelationGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[6]//input")
  private WebElement insuredTitle;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='titleId']//span[@class='ng-value-label']")
  private WebElement insuredTitleGet;


  //Insured Permanent Address
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='permanentAddressLine1']")
  private WebElement insuredPermanentAddressLine1;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='permanentAddressLine2']")
  private WebElement insuredPermanentAddressLine2;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='permanentArea']")
  private WebElement insuredPermannentAddressArea;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentState']//input")
  private WebElement insuredPermanentState;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentState']//span[@class='ng-value-label']")
  private WebElement insuredPermanentStateGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentState']//span[@class='ng-arrow-wrapper']")
  private WebElement insuredPermanentStateArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentCity']//input")
  private WebElement insuredPermanentCity;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentCity']//span[@class='ng-value-label']")
  private WebElement insuredPermanentCityGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='permanentCity']//span[@class='ng-arrow-wrapper']")
  private WebElement insuredPermanentCityArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='permanentPinCode']")
  private WebElement insuredPermanentPinCode;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='cutomCheck']//input[@formcontrolname='redidenceAddress']")
  private WebElement insuredCheckbox;


  //Insured Comm Address
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='communicationAddressLine1']")
  private WebElement insuredCommunicationAddressLine1;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='communicationAddressLine2']")
  private WebElement insuredCommunicationAddressLine2;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='communicationArea']")
  private WebElement insuredCommunicationAddressArea;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationState']//input")
  private WebElement insuredCommunicationState;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationState']//span[@class='ng-arrow-wrapper']")
  private WebElement insuredCommunicationStateArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationState']//span[@class='ng-value-label']")
  private WebElement insuredCommunicationStateGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationCity']//input")
  private WebElement insuredCommunicationCity;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationCity']//span[@class='ng-arrow-wrapper']")
  private WebElement insuredCommunicationCityArrow;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//ng-select[@formcontrolname='communicationCity']//span[@class='ng-value-label']")
  private WebElement insuredCommunicationCityGet;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='communicationPinCode']")
  private WebElement insuredCommunicationPincode;

  @FindBy(xpath="//div[@id='accordionExample']/div[2]//div[@class='cutomCheck']//input[@formcontrolname='redidenceAddress']")
  private WebElement insuredcheckbox;



  //INSURED FIRST PART MANDATORY MESSAGE//
  @FindBy(xpath = "//button[contains(.,'Insured Detail')]")
  private WebElement InsuredDetailButton;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[1]//div[@class='text-danger']")
  private WebElement insuredDobMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[2]//div[@class='text-danger']")
  private WebElement insuredFirstNameMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[3]//div[@class='text-danger']")
  private WebElement insuredLastNameMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[4]//div[@class='invalid-feedback']")
  private WebElement insuredGenderMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[6]//div[@class='invalid-feedback']")
  private WebElement insuredTitleMan;

  //INSURED PERMANENT ADDRESS PART MANDATORY MESSAGE//
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[9]//div[@class='invalid-feedback']")
  private WebElement insuredPerAddLine1Man;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[5]//div[@class='invalid-feedback']")
  private WebElement insuredRelationMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[12]//div[@class='invalid-feedback']")
  private WebElement insuredPerStateMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[13]//div[@class='invalid-feedback']")
  private WebElement insuredPerCityMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[14]//div[@class='invalid-feedback']")
  private WebElement insuredPerPincodeMan;

  //INSURED COMMUNICATION ADDRESS PART MANDATORY MESSAGE//
  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[17]//div[@class='invalid-feedback']")
  private WebElement insuredCommAddLine1Man;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[20]//div[@class='invalid-feedback']")
  private WebElement insuredCommStateMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[21]//div[@class='invalid-feedback']")
  private WebElement insuredCommCityMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[22]//div[@class='invalid-feedback']")
  private WebElement insuredCommPincodeMan;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//div[@class='row pt-2']/div[25]//div[@class='invalid-feedback']")
  private WebElement insuredEmailMan;

  //Add Insured Button
  @FindBy(xpath = "//button[contains(.,'Add')]")
  private WebElement addInsured;

  //Calculate Premium Button

  @FindBy(xpath = "//button[contains(.,'Calculate Premium')]")
  private WebElement calculatePremiumButton;


  //Gender Mismatch error message

  @FindBy(xpath = "//p[contains(.,'{*} Gender and title mismatch.')]")
  private WebElement genderMismatchMessage;

  @FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']")
  private WebElement arrowWait;

  @FindBy(xpath = "//div[@id='accordionExample']/div[2]//input[@formcontrolname='mobileNo']")
  private WebElement insuredContact;

  //Calculate Premium
  @FindBy(xpath = "//button[contains(.,'Calculate Premium')]")
  private WebElement premiumCalculate;

  @FindBy(xpath="//button[contains(.,'Close')]")
  private WebElement premiumClose;

  @FindBy(xpath="//button[contains(.,'View')]")
  private WebElement resultView;

  @FindBy(id="searchBar2")
  private WebElement searchBar;

  @FindBy(xpath="//button[@class='btn btn-outline-primary btnvh fa fa-edit']")
  private WebElement editButton;


  @FindBy(xpath="//h3[@class='modalHed']/b")
  private WebElement premiumAmount;

  // Payment Pop up
  @FindBy(id = "flexCheckDefault12")
  private WebElement firstCheckboxPayment;

  @FindBy(id = "flexCheckDefault")
  private WebElement secondCheckboxPayment;

  @FindBy(xpath = "//span[@class='optSend']")
  private WebElement paymentOtp;

  @FindBy(xpath = "//button[contains(.,'Submit')]")
  private WebElement paymentSubmitButton;

  @FindBy(xpath = "//button[text()='Close']")
  private WebElement paymentPopUpClose;

  @FindBy (xpath="//p[contains(.,'Your Policy Generated Successfully with policy no')]")
  private WebElement policyNumber;


  WebDriverWait wait;
  Actions action;
  SoftAssert softAssert;
  TestUtility testUtility;

  public CIMainPOM2() {

    PageFactory.initElements(driver,this);
    wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    action=new Actions(driver);
  }
  public void premiumpopupClose() {
    wait.until(ExpectedConditions.visibilityOf(premiumClose));
    premiumClose.click();
  }

  public void paymentPopUp() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-header']")));
    firstCheckboxPayment.click();
    secondCheckboxPayment.click();
    paymentOtp.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']//p")));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alert alert-dismissable bg-success custom-toastbar-alert text-white']//p")));
  }
  public void enterOtpPayment(int otp) {
    driver.findElement(By.xpath("//input[@formcontrolname='mobileOTP']")).sendKeys("" + otp);
    paymentSubmitButton.click();

  }

  public String getPolicyNumber() {
    try {
      wait.until(ExpectedConditions.visibilityOf(policyNumber));
      String pnumber = policyNumber.getText().trim();
// Regular expression to find the policy number
      String regex = "(\\d+)";

      // Create a pattern object
      Pattern pattern = Pattern.compile(regex);

      // Create a matcher object
      Matcher matcher = pattern.matcher(pnumber);

      if (matcher.find()) {
        String policyNo = matcher.group(1);
        System.out.println("Extracted Policy Number: " + policyNo);
        if(policyNo.isEmpty()){
          Reporter.log("policy is generated with the pop up but there is no policy number in it. Check log for more info.");
          softAssert.assertEquals(true,false);
          softAssert.assertAll();
        }
        else{
          wait.until(ExpectedConditions.invisibilityOf(policyNumber));
          return matcher.group(1);
        }

      } else {

        System.out.println("Policy number not found in the string.");
        wait.until(ExpectedConditions.invisibilityOf(policyNumber));
        return null;
      }
    } catch (TimeoutException timeoutException) {
      Reporter.log("time out exception because the policy is not created. " + timeoutException.getMessage());
      return null;
    }

    return  null;}
  public void resultView() {
    wait.until(ExpectedConditions.visibilityOf(resultView)).click();
  }

  public void searchproposalno(String proposalno) {
    searchBar.sendKeys(proposalno);
  }
  public String getPremiumAmount() {
    String premAmt="";
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert.bg-danger.custom-toastbar-alert p")));
      String errorText = driver.findElement(By.cssSelector("div.alert.bg-danger.custom-toastbar-alert p")).getText();
      Reporter.log("error text is: " + errorText);
      Reporter.log("Payment pop not opened up.");
    } catch (Exception e) {
      Reporter.log("checking in the catch block about the pop up.");
      wait.until(ExpectedConditions.visibilityOf(premiumAmount));
      premAmt = premiumAmount.getText();
      return premAmt;
    }
    return premAmt;
  }
  public void enterInsuredPermanentAddress(String ipadd1, String ipadd2, String iparea, String ipstate, String ipcity, String ippincode, String icontact, String ipemail) {
    insuredPermanentAddressLine1.sendKeys(ipadd1);
    insuredPermanentAddressLine2.sendKeys(ipadd2);
    insuredPermannentAddressArea.sendKeys(iparea);

    action.moveToElement(insuredPermanentStateArrow).perform();
    insuredPermanentStateArrow.click();
    wait.until(ExpectedConditions.visibilityOf(arrowWait));
    insuredPermanentState.sendKeys(ipstate);
    action.sendKeys(Keys.ENTER).perform();

    action.moveToElement(insuredPermanentCityArrow).perform();
    wait.until(ExpectedConditions.visibilityOf(insuredPermanentCityArrow)).click();
    wait.until(ExpectedConditions.visibilityOf(arrowWait));
    insuredPermanentCity.sendKeys(ipcity);
    action.sendKeys(Keys.ENTER).perform();
    insuredPermanentPinCode.sendKeys(ippincode);
    insuredContact.sendKeys(icontact);
    insuredEmail.sendKeys(ipemail);
  }
  public void enterInsuredDetails(String year, String month, String date, String ifname, String ilname,
                                  String igend, String irel, String itit) {

    action.moveToElement(calendarButtonInsured).perform();
    calendarButtonInsured.click();
    Select selectYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
    Select selectMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
    selectYear.selectByVisibleText(year);
    selectMonth.selectByVisibleText(month);
    driver.findElement(By.xpath("//div[@class='btn-light' and text()='" + date + "']")).click();
    firstNameInsured.sendKeys(ifname);
    lastNameInsured.sendKeys(ilname);

    action.moveToElement(genderArrowInsured).perform();
    genderArrowInsured.click();
    genderInsured.sendKeys(igend);
    action.sendKeys(Keys.ENTER).build().perform();

    action.moveToElement(relationArrowInsured).perform();
    relationArrowInsured.click();
    relationInsured.sendKeys(irel);
    action.sendKeys(Keys.ENTER).build().perform();
    titleArrowInsured.click();
    titleInsured.sendKeys(itit);
    action.sendKeys(Keys.ENTER).build().perform();
  }

  public void clickCalculatePremiumButton() {
    //wait.until(ExpectedConditions.visibilityOfElementLocated(proposerDetailButton)).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    //action.sendKeys(Keys.END).perform();
    wait.until(ExpectedConditions.visibilityOf(premiumCalculate));
    action.moveToElement(premiumCalculate).click().perform();
  }

  public void calculatePremiumClick(){
    action.moveToElement(premiumCalculate).click().perform();
  }
  public void clickEditButton() {
    wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();

  }

  public String[] firstPartMandatoryVerify() {
    action.sendKeys(Keys.HOME).perform();
    String actualCtype = coverTypeMan.getText().trim();
    String actualSinsured = sumInsuredMan.getText().trim();
    String actualNumMem = numberMemberMan.getText().trim();
    String actualPeriod = periodMan.getText().trim();
    String actualProduct = productMan.getText().trim();
    String actualInsuranceType = insuranceTypeMan.getText().trim();
    return new String[] { actualCtype, actualSinsured, actualNumMem, actualPeriod, actualProduct, actualInsuranceType };
  }

  public String[] ProposerMandatoryFirstPartVerify() {

    // wait.until(ExpectedConditions.visibilityOfElementLocated(proposerDetailButton)).click();
    action.sendKeys(Keys.HOME).perform();

    action.moveToElement(proposerDobMan).perform();
    wait.until(ExpectedConditions.visibilityOf(proposerDobMan));
    String actualDob = proposerDobMan.getText().trim();
    Reporter.log("actual dob: " + actualDob);
    String actualfname =proposerFirstNameMan.getText().trim();
    Reporter.log("actual first name: " + actualfname);
    String actuallname = proposerLastNameMan.getText().trim();
    Reporter.log("actual last name: " + actuallname);
    String actualgender = proposerGenderMan.getText().trim();
    Reporter.log("actual gender: " + actualgender);
    String actualRelation = proposerRelationMan.getText().trim();
    Reporter.log("actual relation: " + actualRelation);
    String actualTitle = proposerTitleMan.getText().trim();
    Reporter.log("actual title: " + actualTitle);
    return new String[]{actualDob,actualfname,actuallname,actualgender,actualRelation,actualTitle};
  }
  public void goToHomeAction() {
    System.out.println("entering the home key");
    action.sendKeys(Keys.HOME).perform();
    wait.until(ExpectedConditions.visibilityOf(coverTypeArrow));
    action.moveToElement(coverTypeArrow).perform();

  }
  public String[] ProposerMandatoryPermanentAddress() {
    action.scrollByAmount(0,150).perform();
    WebElement percity = proposerPerCityMan;
    action.moveToElement(percity).perform();
    String actualPerAdd1 = proposerPerAddLine1Man.getText().trim();
    System.out.println("proposer actual per add1: " + actualPerAdd1);
    String actualPerState = proposerPerStateMan.getText().trim();
    System.out.println("proposer actual per state: " + actualPerState);
    String actualPerCity = proposerPerCityMan.getText().trim();
    System.out.println("proposer actual per city: " + actualPerCity);
    String actualPerPincode = proposerPerPincodeMan.getText().trim();
    System.out.println("proposer actual per pincode: " + actualPerPincode);
    return new String[] {actualPerAdd1,actualPerState,actualPerCity,actualPerPincode};
  }

  public void enterFirstPart(String cType, String sInsured, String numberMember
        , String InsurancePeriod,
                             String InsuranceProduct, String Itype, String nName,
                             String nRelation) {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='title_new']")));
      wait.until(ExpectedConditions.visibilityOf(coverTypeArrow));
      coverTypeArrow.click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-option-label' and text()='Individual']")));
      coverType.sendKeys(cType);
      action.sendKeys(Keys.ENTER).perform();
      String indiText = driver.findElement(By.xpath("//span[@class='ng-value-label' and text()='Individual']")).getText().trim();
      Reporter.log("this is the text " + indiText);

    } catch (Exception e) {
      Reporter.log("enter not hit: " + e.getMessage());
    }
    try {
      sumInsuredArrow.click();
      wait.until(ExpectedConditions.visibilityOf(dropDownWait));
      sumInsured.sendKeys(sInsured);
      action.sendKeys(Keys.ENTER).perform();
    } catch (Exception e) {
      Reporter.log("enter not hit: " + e.getMessage());
    }

    numberOfMembersArrow.click();
    wait.until(ExpectedConditions.visibilityOf(dropDownWait));

    numberOfMembers.sendKeys(numberMember);
    action.sendKeys(Keys.ENTER).perform();

    periodArrow.click();
    wait.until(ExpectedConditions.visibilityOf(dropDownWait));

    period.sendKeys(InsurancePeriod);
    action.sendKeys(Keys.ENTER).perform();

    productArrow.click();
    wait.until(ExpectedConditions.visibilityOf(dropDownWait));

    product.sendKeys(InsuranceProduct);
    action.sendKeys(Keys.ENTER).perform();

    insuranceTypeArrow.click();
    wait.until(ExpectedConditions.visibilityOf(dropDownWait));
    insuranceType.sendKeys(Itype);
    action.sendKeys(Keys.ENTER).perform();

    nomineeName.sendKeys(nName);


    nomineeRelationArrow.click();
    wait.until(ExpectedConditions.visibilityOf(dropDownWait));
    driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']//span[text()='" + nRelation + "']")).click();
    //driver.findElement(nomineeRelation).sendKeys(nRelation);
    //action.sendKeys(Keys.ENTER).build().perform();

  }

  public void proposerDetailEnter(String year, String month, String date
        , String fname, String lname, String gend, String rel, String tit) {

    action.moveToElement(calendarButtonProposer).perform();
    calendarButtonProposer.click();
    Select selectYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));

    Select selectMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));

    selectYear.selectByVisibleText(year);
    selectMonth.selectByVisibleText(month);

    driver.findElement(By.xpath("//div[@class='btn-light' and text()='" + date + "']")).click();
    try {
      String indiText = driver.findElement(By.xpath("//span[@class='ng-value-label' and text()='Individual']")).getText().trim();
      Reporter.log("this is the text " + indiText);

    } catch (Exception e) {
      Reporter.log("text not captured " + e.getMessage());
    }
    firstNameProposer.sendKeys(fname);
    lastNameProposer.sendKeys(lname);
    genderArrowProposer.click();
    genderProposer.sendKeys(gend);
    action.sendKeys(Keys.ENTER).build().perform();
    relationArrowProposer.click();
    relationProposer.sendKeys(rel);
    action.sendKeys(Keys.ENTER).build().perform();

    titleArrowProposer.click();
    titleProposer.sendKeys(tit);
    action.sendKeys(Keys.ENTER).build().perform();
  }
  public void enterProposerPermanentAddress(String add1, String add2, String area,
                                            String state, String city,
                                            String pincode, String propEmail) {
    proposerPermanentAddressLine1.sendKeys(add1);
    proposerPermanentAddressLine2.sendKeys(add2);
    proposerPermannentAddressArea.sendKeys(area);
    try {

      action.moveToElement(proposerPermanentStateArrow).perform();
      proposerPermanentStateArrow.click();
      wait.until(ExpectedConditions.visibilityOf(arrowWait));
      proposerPermanentState.sendKeys(state);
      action.sendKeys(Keys.ENTER).build().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordionExample']/div[1]//div[11]//span[@class='ng-value-label' and text()='DELHI & NCR']")));

    } catch (Exception e) {
      Reporter.log("enter not hit address " + e.getMessage());
    }
    try {

      action.moveToElement(proposerPermanentCityArrow).perform();
      proposerPermanentCityArrow.click();
      wait.until(ExpectedConditions.visibilityOf(arrowWait));
      proposerPermanentCity.sendKeys(city);
      action.sendKeys(Keys.ENTER).build().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordionExample']/div[1]//div[12]//span[@class='ng-value-label' and text()='Gurgaon']")));
    } catch (Exception e) {
      Reporter.log("enter not hit address " + e.getMessage());
    }

    proposerPermanentPinCode.sendKeys(pincode);

    proposerEmail.sendKeys(propEmail);
  }

  public void ProposercheckboxPermCommSame() {

    action.moveToElement(proposercheckbox).perform();
   proposercheckbox.click();
  }

  public void openInsuredBlock() {

    action.moveToElement(InsuredDetailButton).perform();
    InsuredDetailButton.click();
  }

  public void addInsured() {
    wait.until(ExpectedConditions.visibilityOf(addInsured));
    action.moveToElement(addInsured).click().perform();
    //addInsured.click();
  }
  public void InsuredcheckboxPermCommSame() {
    action.moveToElement(insuredcheckbox).perform();
    insuredcheckbox.click();
  }
  public String[] ProposerMandatoryCommunicationAddress() {

    action.moveToElement(proposerCommCityMan).perform();
    String actualCommAdd1 = proposerCommAddLine1Man.getText().trim();
    String actualCommState = proposerCommStateMan.getText().trim();
    String actualCommCity =proposerCommCityMan.getText().trim();
    String actualCommPincode = proposerCommPincodeMan.getText().trim();
    String actualCommEmail = proposerEmailMan.getText().trim();
    return new String[]{actualCommAdd1,actualCommState,actualCommCity,actualCommPincode,actualCommEmail};

  }
  public String[] InsuredMandatoryFirstPartVerify() {
    action.moveToElement(proposerDetailButton).perform();
    proposerDetailButton.click();
    wait.until(ExpectedConditions.visibilityOf(insuredDobMan));
    String actualDob = insuredDobMan.getText().trim();
    Reporter.log("actual dob: " + actualDob);
    String actualfname = insuredFirstNameMan.getText().trim();
    Reporter.log("actual first name: " + actualfname);
    String actuallname = insuredLastNameMan.getText().trim();
    Reporter.log("actual last name: " + actuallname);
    String actualgender = insuredGenderMan.getText().trim();
    Reporter.log("actual gender: " + actualgender);
    String actualRelation = insuredRelationMan.getText().trim();
    Reporter.log("actual relation: " + actualRelation);
    String actualTitle = insuredTitleMan.getText().trim();
    Reporter.log("actual title: " + actualTitle);
    return new String[]{actualDob,actualfname,actuallname,actualgender,actualRelation,actualTitle};

  }

  public String [] InsuredMandatoryPermanentAddress() {

    action.moveToElement(insuredCommCityMan).perform();
    String actualPerAdd1 = insuredPerAddLine1Man.getText().trim();
    String actualPerState = insuredPerStateMan.getText().trim();
    String actualPerCity = insuredPerCityMan.getText().trim();
    String actualPerPincode = insuredPerPincodeMan.getText().trim();
    return new String[]{actualPerAdd1,actualPerState,actualPerCity,actualPerPincode};

  }

  public String[] InsuredMandatoryCommunicationAddress() {

    action.moveToElement(insuredCommCityMan).perform();
    String actualCommAdd1 = insuredCommAddLine1Man.getText().trim();
    String actualCommState = insuredCommStateMan.getText().trim();
    String actualCommCity = insuredCommCityMan.getText().trim();
    String actualCommPincode = insuredCommPincodeMan.getText().trim();
    String actualEmail = insuredEmailMan.getText().trim();
    return new String[]{actualCommAdd1,actualCommState,actualCommCity,actualCommPincode,actualEmail};

  }
  public String genderMismatch() {
    wait.until(ExpectedConditions.visibilityOf(genderMismatchMessage));
    String genderMsg = genderMismatchMessage.getText().trim();
    return genderMsg;

  }


}
