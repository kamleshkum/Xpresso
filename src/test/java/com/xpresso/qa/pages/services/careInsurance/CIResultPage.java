package com.xpresso.qa.pages.services.careInsurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CIResultPage {

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

  WebDriver driver;
  WebDriverWait wait;
  Actions action;
  public CIResultPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver,this);
    wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    action = new Actions(driver);
  }

  public void clickAddButton(){
    wait.until(ExpectedConditions.visibilityOf(addButton));
    addButton.click();
  }

  public void goToCareInsurance() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='topbar']")));
    action.moveToElement(services).perform();
    //wait.until(ExpectedConditions.visibilityOfElementLocated(services)).click();
    action.moveToElement(insurance).perform();
    wait.until(ExpectedConditions.visibilityOf(careInsurance)).click();
  }

}
