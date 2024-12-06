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

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CustomerRateCalculator extends TestBase {

  private static final DecimalFormat df = new DecimalFormat("0.00");
  @FindBy(xpath = "//ng-select[@formcontrolname='packageTypeId']//span[@class='ng-arrow-wrapper']")
  WebElement packageTypeArrow;
  @FindBy(xpath = "//div[contains(@class,'ng-dropdown-panel-items')]//div//span")
  List<WebElement> packageTypeOptions;
  @FindBy(xpath = "//ng-select[@formcontrolname='serviceTypeId']//span[@class='ng-arrow-wrapper']")
  WebElement serviceTypeArrow;
  @FindBy(xpath = "//div[@class='d-flex position-relative']//button")
  WebElement calendarButton;
  @FindBy(xpath = "//input[@formcontrolname='originPinCode']")
  WebElement fromPincode;
  @FindBy(xpath = "//input[@formcontrolname='destinationPinCode']")
  WebElement toPincode;
  @FindBy(xpath = "//div[@class='row mt-3']/div[1]//button")
  WebElement fromSearchButton;
  @FindBy(xpath = "//div[@class='row mt-3']/div[2]//button")
  WebElement toSearchButton;
  @FindBy(xpath = "//input[@formcontrolname='shipmentValue']")
  WebElement enterShipmentValue;
  @FindBy(xpath = "//input[@formcontrolname='length']")
  WebElement enterLength;
  @FindBy(xpath = "//input[@formcontrolname='width']")
  WebElement enterBreadth;
  @FindBy(xpath = "//input[@formcontrolname='height']")
  WebElement enterHeight;
  @FindBy(xpath = "//input[@formcontrolname='weight']")
  WebElement enterWeight;
  @FindBy(xpath = "//button[contains(.,'New')]")
  WebElement newButton;
  @FindBy(xpath = "//tbody[@formarrayname='dimensions']")
  WebElement productTable;
  @FindBy(xpath = ".//input[@formcontrolname='length']")
  WebElement length;
  @FindBy(xpath = "//button[text()='Check Rates']")
  WebElement checkRate;
  @FindBy(xpath = "//button[contains(.,'CREATE AWB')]")
  WebElement createAwb;
  @FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr[2]//td[4]")
  WebElement weightCompare;
  @FindBy(xpath = "//table[@class='table table-striped table-bordered']")
  WebElement logisticsTable;
  @FindAll(@FindBy(xpath = "//div[@class='text-danger']"))
  List<WebElement> mandatoryMessgage;
  WebDriverWait wait;
  Actions action;

  public CustomerRateCalculator() {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    action = new Actions(driver);
  }

  public void selectPackageType(String packType) {
    packageTypeArrow.click();
    wait.until(ExpectedConditions.visibilityOfAllElements(packageTypeOptions));
    // Iterate through the list of package type options and click the matching one
    for (WebElement option : packageTypeOptions) {
      String optionText = option.getText().trim();  // Ensure we remove extra spaces or newlines
      try {
        if (optionText.equalsIgnoreCase(packType.trim())) {
          wait.until(ExpectedConditions.elementToBeClickable(option));
          option.click(); // Click the matching option
          break; // Exit the loop once the option is found
        }
      } catch (Exception e) {
        System.out.println("element not clickable: " + e.getMessage());
      }
    }
  }

  public void selectServiceType(String servType) {
    serviceTypeArrow.click();
    wait.until(ExpectedConditions.visibilityOfAllElements(packageTypeOptions));
    // Iterate through the list of package type options and click the matching one
    for (WebElement option : packageTypeOptions) {
      String optionText = option.getText().trim();  // Ensure we remove extra spaces or newlines
      try {
        if (optionText.equalsIgnoreCase(servType.trim())) {
          wait.until(ExpectedConditions.elementToBeClickable(option));
          option.click(); // Click the matching option
          break; // Exit the loop once the option is found
        }
      } catch (Exception e) {
        System.out.println("element not clickable: " + e.getMessage());
      }
    }
  }

  public void selectCollectDate(String year, String month, String date) {
    calendarButton.click();
    Select selectYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));

    Select selectMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
    selectYear.selectByVisibleText(year);
    selectMonth.selectByVisibleText(month);
    driver.findElement(By.xpath("//div[@class='btn-light' and text()='" + date + "']")).click();
  }

  public void enterFromCityDetail(String fromP) {
    //fromPincode.clear();
    fromPincode.sendKeys(fromP);
    fromSearchButton.click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));
  }

  public void enterToCityDetail(String toP) {
    //wait.until(ExpectedConditions.visibilityOf(toPincode));
    // toPincode.clear();
    toPincode.sendKeys(toP);
    toSearchButton.click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='progressbar']")));

  }

  public void enterShipmentValue(String shipValue) {
    enterShipmentValue.sendKeys(shipValue);
  }

  public void enterSingleProduct(double l, double b, double h, double w) {
    enterLength.sendKeys("" + l);
    enterBreadth.sendKeys("" + b);
    enterHeight.sendKeys("" + h);
    enterWeight.sendKeys("" + w);

  }

  public double enterMultipleProducts(double l, double b, double h, double w, int numberofProducts) {
    enterSingleProduct(l, b, h, w);
    action.moveToElement(newButton).perform();
    newButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@formarrayname='dimensions']//tr")));
    double actualWeight = w;
    // int numberofProducts=8;
    for (int i = 3; i < numberofProducts; i++) {
      // Get all the rows in the table (this ensures we get the correct rows)
      List<WebElement> rows = productTable.findElements(By.xpath(".//tr"));
      System.out.println("row size: " + rows.size());// Using relative XPath

      // Check if the row exists
      if (i == rows.size()) {
        WebElement productDimensions = rows.get(i - 1); // i-1 because list is 0-indexed

        Random random = new Random();
        double max = 100.00;
        double min = 10.00;
        double randomLength = Double.parseDouble(df.format(random.nextDouble(max - min) + min)); // Generates a number between 1 and 99
        double randomWidth = Double.parseDouble(df.format(random.nextDouble(max - min) + min));
        double randomHeight = Double.parseDouble(df.format(random.nextDouble(max - min) + min));
        double randomWeight = Double.parseDouble(df.format(random.nextDouble(max - min) + min));
        actualWeight += randomWeight;
        // Fill in the values for length, width, height, and weight
        productDimensions.findElement(By.xpath(".//input[@formcontrolname='length']")).sendKeys("" + randomLength);
        productDimensions.findElement(By.xpath(".//input[@formcontrolname='width']")).sendKeys("" + randomWidth);
        productDimensions.findElement(By.xpath(".//input[@formcontrolname='height']")).sendKeys("" + randomHeight);
        productDimensions.findElement(By.xpath(".//input[@formcontrolname='weight']")).sendKeys("" + randomWeight);

        // Click the new button to add another row
        if (i < numberofProducts - 1) { // Only click the new button if we haven't reached the last row yet
          newButton.click();
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@formarrayname='dimensions']//tr[" + (i + 1) + "]")));
        }
      }
    }
    System.out.println("Actual Weight: " + Double.parseDouble(df.format(actualWeight)));
    return Double.parseDouble(df.format(actualWeight));
  }

  public void clickCheckRate() {
    action.moveToElement(checkRate).click().perform();
  }

  public void clickCreateAwb() {
    action.moveToElement(createAwb).click().perform();
  }

  public double compareActualWeight() {
    wait.until(ExpectedConditions.visibilityOf(logisticsTable));
    action.moveToElement(weightCompare).perform();
    String actualWt = weightCompare.getText();
    double weight = Double.parseDouble(actualWt);
    return Double.parseDouble(df.format(weight));
  }

  public Map<String, String> mandatorymessageCheck() {
    Map<String, String> messages = new HashMap<>();
    System.out.println("mandate size" + mandatoryMessgage.size());
    String packageType = mandatoryMessgage.get(0).getText();
    String service = mandatoryMessgage.get(1).getText();
    String collectDate = mandatoryMessgage.get(2).getText();
    String fromPinCode = mandatoryMessgage.get(3).getText();
    String fromCity = mandatoryMessgage.get(4).getText();
    String toPincode = mandatoryMessgage.get(5).getText();
    String toCity = mandatoryMessgage.get(6).getText();
    String shipValue = mandatoryMessgage.get(7).getText();
    String length = mandatoryMessgage.get(8).getText();
    String width = mandatoryMessgage.get(9).getText();
    String height = mandatoryMessgage.get(10).getText();
    String weight = mandatoryMessgage.get(11).getText();
    messages.put("packageType", packageType);
    messages.put("service", service);
    messages.put("collectDate", collectDate);
    messages.put("fromPinCode", fromPinCode);
    messages.put("fromCity", fromCity);
    messages.put("toPincode", toPincode);
    messages.put("toCity", toCity);
    messages.put("shipValue", shipValue);
    messages.put("length", length);
    messages.put("width", width);
    messages.put("height", height);
    messages.put("weight", weight);


    return messages;

  }
}

