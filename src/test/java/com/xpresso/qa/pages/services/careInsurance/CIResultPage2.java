package com.xpresso.qa.pages.services.careInsurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xpresso.qa.base.TestBase;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class CIResultPage2 extends TestBase {

  @FindBy(xpath = "//button[contains(.,'Add')]")
  private WebElement addButton;

  @FindBy(xpath = "//div[@class='title_new' and contains(.,'Care Insurance')]")
  private WebElement careTitle;

  @FindBy(xpath = "//li//a[contains(., 'SERVICES ')]")
  private WebElement services;

  @FindBy(xpath = "//a[contains(., 'INSURANCE')]")
  private WebElement insurance;

  @FindBy(xpath = "//a[contains(., 'Care Insurance')]")
  private WebElement careInsurance;

  @FindBy(xpath = "//table[@class='table table-striped table-bordered table-resizable']//tr[1]//td[8]")
  private WebElement coverType;
  @FindBy(id="searchBar2")
  private WebElement searchBar;
  @FindBy(xpath="//button[contains(.,'View')]")
  private WebElement resultView;
public WebDriverWait wait;
  public Actions action;
  public CIResultPage2() {
    PageFactory.initElements(driver,this);
    wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    action = new Actions(driver);
  }
  public void resultView() {
    wait.until(ExpectedConditions.visibilityOf(resultView)).click();
    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(.,'No records found')]")));
  }

  public void searchproposalno(String proposalno) {
    wait.until(ExpectedConditions.visibilityOf(searchBar));
    searchBar.sendKeys(proposalno);
  }
  public String coverTypeVerify(){
    wait.until(ExpectedConditions.visibilityOf(coverType));
    return coverType.getText();
  }
  public void clickAddButton(){
    wait.until(ExpectedConditions.visibilityOf(addButton));
    addButton.click();
  }

  public void goToCareInsurance() throws InterruptedException {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='topbar']")));

    try{
     wait.until(ExpectedConditions.visibilityOf(services));
      action.moveToElement(services).perform();
      //wait.until(ExpectedConditions.visibilityOfElementLocated(services)).click();
      wait.until(ExpectedConditions.elementToBeClickable(insurance));
      action.moveToElement(insurance).perform();
      wait.until(ExpectedConditions.elementToBeClickable(careInsurance)).click();
//      wait.until(ExpectedConditions.visibilityOf(careInsurance)).click();
    } catch(Exception ite){
      ite.printStackTrace();
      // Print the cause of the InvocationTargetException
      Throwable cause = ite.getCause();
      cause.printStackTrace();
      System.out.println("Root cause: " + cause.getMessage());
    }


  }

}
