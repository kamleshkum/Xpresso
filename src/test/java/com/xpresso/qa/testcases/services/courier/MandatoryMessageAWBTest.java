package com.xpresso.qa.testcases.services.courier;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.careInsurance.DbClass;
import com.xpresso.qa.pages.services.courier.AddAWB;
import com.xpresso.qa.pages.services.courier.CustomerRateCalculator;
import com.xpresso.qa.utilites.ExcelUtility;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MandatoryMessageAWBTest extends TestBase {

  private static final DecimalFormat df = new DecimalFormat("0.00");
  HomePage homePage;
  LoginPage loginPage;
  CustomerRateCalculator customerRateCalculator;
  SoftAssert softAssert;
  AddAWB addAWB;
  DbClass dbClass;
  ExcelUtility excelUtility;
  // Specify the path to your Excel file
  String excelFilePath = "C:\\Users\\rohit.mathur\\IdeaProjects\\Lending\\src\\TestData\\Xpresso_TestData.xlsx";

  @BeforeMethod
  public void custCalc() {
    Browserintialize(prop.getProperty("browser"), prop.getProperty("urlUAT"));
    homePage = new HomePage();
    loginPage = new LoginPage();
    customerRateCalculator = new CustomerRateCalculator();
    softAssert = new SoftAssert();
    addAWB = new AddAWB();
    loginPage.login("CSP238096", "roinet@1234", "sddds");
    loginPage.Login_With_OTP("222111");
    homePage.goToCourierService();
    dbClass = new DbClass();
    excelUtility = new ExcelUtility(excelFilePath);
  }

  @Test
  public void goToCService() throws SQLException, IOException {
    String parent = driver.getWindowHandle();
    Set<String> s = driver.getWindowHandles();
    int getCourierId;

// Now iterate using Iterator
    Iterator<String> I1 = s.iterator();

    while (I1.hasNext()) {
      String child_window = I1.next();
      if (!parent.equals(child_window)) {
        driver.switchTo().window(child_window);
        System.out.println(driver.switchTo().window(child_window).getTitle());
        String sheetName = "CourierService";
        String packageTypeNonDox = excelUtility.getCellData(sheetName, 2, 1);
        String serviceTypeSurface = excelUtility.getCellData(sheetName, 4, 1);
        String collectYear = excelUtility.getCellData(sheetName, 5, 1);
        String collectMonth = excelUtility.getCellData(sheetName, 6, 1);
        String collectDate = excelUtility.getCellData(sheetName, 7, 1);
        String formCityPinCode = excelUtility.getCellData(sheetName, 8, 1);
        String toCityPincode = excelUtility.getCellData(sheetName, 9, 1);
        String shipmentValue = excelUtility.getCellData(sheetName, 10, 1);
        customerRateCalculator.selectPackageType(packageTypeNonDox);
        customerRateCalculator.selectServiceType(serviceTypeSurface);
        customerRateCalculator.selectCollectDate(collectYear, collectMonth, collectDate);
        customerRateCalculator.enterFromCityDetail(formCityPinCode);
        customerRateCalculator.enterToCityDetail(toCityPincode);
        customerRateCalculator.enterShipmentValue(shipmentValue);

        Random random = new Random();
        double randomLength = Double.parseDouble(df.format(random.nextDouble(99.00) + 1.00)); // Generates a number between 1 and 99
        double randomWidth = Double.parseDouble(df.format(random.nextDouble(80.00) + 1.00));
        double randomHeight = Double.parseDouble(df.format(random.nextDouble(70.00) + 1.00));
        double randomWeight = Double.parseDouble(df.format(random.nextDouble(60.00) + 1.00));
        System.out.println("Random Number: " + randomLength);
        double actWeight = customerRateCalculator.enterMultipleProducts(randomLength, randomWidth, randomHeight, randomWeight, 8);

        System.out.println("act weight: " + actWeight);
        customerRateCalculator.clickCheckRate();
        customerRateCalculator.clickCreateAwb();
        addAWB.clickSubmit();
        Map<String, String> errorCheckResult = addAWB.mandatorymessageCheck();
        softAssert.assertEquals("Pick Up Request is Required",errorCheckResult.get("pickupRequest"),"pickup request does not match");
        softAssert.assertEquals("Booking Date is Required",errorCheckResult.get("bookingDate"),"booking date message does not match");
        softAssert.assertEquals("Booking Time is required",errorCheckResult.get("bookingTime"),"booking time message does not match");
        softAssert.assertEquals("Content Required",errorCheckResult.get("content"),"content message does not match");
        softAssert.assertEquals("Company Name required",errorCheckResult.get("shipperCompanyName"), "shipper company name message does not match");
        softAssert.assertEquals("Person Name Required",errorCheckResult.get("shipperName"),"shipper name message does not match");
        softAssert.assertEquals("Address1 required",errorCheckResult.get("shipperAddress1"),"shipper address 1 message does not match");
        softAssert.assertEquals("Address2 required",errorCheckResult.get("shipperAddress2"),"shipper address 2 message does not match");
        softAssert.assertEquals("State Required",errorCheckResult.get("shipperState"),"shipper state message does not match");
        softAssert.assertEquals("Email Required",errorCheckResult.get("shipperEmail"),"shipper email message does not match");
        softAssert.assertEquals("Company Name required",errorCheckResult.get("consigneeCompanyName"),"consignee company name message does not match");
        softAssert.assertEquals("Person Name Required",errorCheckResult.get("consigneeName"),"consignee name message does not match");
        softAssert.assertEquals("Address1 required",errorCheckResult.get("consigneeAddress1"),"consignee address 1 message does not match");
        softAssert.assertEquals("Address2 required",errorCheckResult.get("consigneeAddress2"),"consignee address 2 message does not match");
        softAssert.assertEquals("State Required",errorCheckResult.get("consigneeState"),"consignee state message does not match");
        softAssert.assertEquals("Email Required",errorCheckResult.get("consigneeEmail"),"consignee email message does not match");
        softAssert.assertAll();
      }
    }
  }
}
