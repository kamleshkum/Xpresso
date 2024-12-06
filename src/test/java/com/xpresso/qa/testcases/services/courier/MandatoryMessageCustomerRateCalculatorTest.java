package com.xpresso.qa.testcases.services.courier;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.courier.CustomerRateCalculator;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MandatoryMessageCustomerRateCalculatorTest extends TestBase {

  private static final DecimalFormat df = new DecimalFormat("0.00");
  HomePage homePage;
  LoginPage loginPage;
  CustomerRateCalculator customerRateCalculator;
  SoftAssert softAssert;



  @BeforeMethod
  public void custCalc() {
    Browserintialize(prop.getProperty("browser"), prop.getProperty("urlUAT"));
    homePage = new HomePage();
    loginPage = new LoginPage();
    customerRateCalculator = new CustomerRateCalculator();
    softAssert = new SoftAssert();
    loginPage.login("CSP238096", "roinet@1234", "sddds");
    loginPage.Login_With_OTP("222111");
    homePage.goToCourierService();

  }

  @Test
  public void goToCService() throws SQLException, IOException {
    String parent = driver.getWindowHandle();
    Set<String> s = driver.getWindowHandles();

// Now iterate using Iterator
    Iterator<String> I1 = s.iterator();

    while (I1.hasNext()) {
      String child_window = I1.next();
      if (!parent.equals(child_window)) {
        driver.switchTo().window(child_window);
        System.out.println(driver.switchTo().window(child_window).getTitle());
        customerRateCalculator.clickCheckRate();
        Map<String, String> errorCheckResult = customerRateCalculator.mandatorymessageCheck();
        softAssert.assertEquals("Package Type is Required",errorCheckResult.get("packageType"),"product message does not match");
        softAssert.assertEquals("Service Type is Required",errorCheckResult.get("service"),"service message does not match");
        softAssert.assertEquals("Collect Date is required",errorCheckResult.get("collectDate"),"collect date message does not match");
        softAssert.assertEquals("From Pin Code Required",errorCheckResult.get("fromPinCode"),"from pincode does not match");
        softAssert.assertEquals("From City required",errorCheckResult.get("fromCity"), "from city does not match");
        softAssert.assertEquals("To Pin Code Required",errorCheckResult.get("toPincode"),"to pincode does not match");
        softAssert.assertEquals("To City required",errorCheckResult.get("toCity"),"to city does not match");
        softAssert.assertEquals("Shipment Value required",errorCheckResult.get("shipValue"),"ship value does not match");
        softAssert.assertEquals("Length Required",errorCheckResult.get("length"),"length does not match");
        softAssert.assertEquals("Width Required",errorCheckResult.get("width"),"width does not match");
        softAssert.assertEquals("Height Required",errorCheckResult.get("height"),"height does not match");
        softAssert.assertEquals("Weight Required",errorCheckResult.get("weight"),"weight does not match");
        softAssert.assertAll();

      }
    }
  }
}
