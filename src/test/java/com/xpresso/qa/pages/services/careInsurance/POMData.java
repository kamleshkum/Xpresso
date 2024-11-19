package com.xpresso.qa.pages.services.careInsurance;

import org.openqa.selenium.WebDriver;



public class POMData {
  protected WebDriver driverUAT;
  protected CIPOM cipom;

  protected BaseClassUAT baseClassUAT;
  String usernameAdmin, passwordAdmin;

  public void enterCredentials(){
    cipom=new CIPOM(driverUAT);
    //usernameAdmin = baseClassUAT.getProperty("usernameCSP");
    //passwordAdmin = baseClassUAT.getProperty("passwordAdmin");
    cipom.enterCredentials("usernameAdmim", "uicsd", "sddds");
    cipom.enterOTP("222111");
  }
}
