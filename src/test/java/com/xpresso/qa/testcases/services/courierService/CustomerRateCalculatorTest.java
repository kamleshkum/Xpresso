package com.xpresso.qa.testcases.services.courierService;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.pages.home.HomePage;
import com.xpresso.qa.pages.login.LoginPage;
import com.xpresso.qa.pages.services.careInsurance.DbClass;
import com.xpresso.qa.pages.services.courierService.AddAWB;
import com.xpresso.qa.pages.services.courierService.CustomerRateCalculator;
import com.xpresso.qa.utilites.ExcelUtility;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CustomerRateCalculatorTest extends TestBase {
  private static final DecimalFormat df = new DecimalFormat("0.00");
  HomePage homePage;
  LoginPage loginPage;
  CustomerRateCalculator customerRateCalculator;
  SoftAssert softAssert;
  AddAWB addAWB;
  DbClass dbClass;
  ExcelUtility excelUtility;
  // Specify the path to your Excel file
  String excelFilePath = "C:\\Users\\rohit.mathur\\Roinet\\Xpresso\\src\\test\\java\\com\\xpresso\\qa\\testdata\\Xpresso_TestData.xlsx";

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
        String shipperCompanyName = excelUtility.getCellData(sheetName, 11, 1);
        String shipperName = excelUtility.getCellData(sheetName, 12, 1);
        String shipperAddress1 = excelUtility.getCellData(sheetName, 13, 1);
        String shipperAddress2 = excelUtility.getCellData(sheetName, 14, 1);
        String shipperAddress3 = excelUtility.getCellData(sheetName, 15, 1);
        String shipperState = excelUtility.getCellData(sheetName, 16, 1);
        String shipperContactNumber = excelUtility.getCellData(sheetName, 17, 1);
        String shipperEmail = excelUtility.getCellData(sheetName, 18, 1);
        String shipperGstType = excelUtility.getCellData(sheetName, 19, 1);
        String shipperGstNumber = excelUtility.getCellData(sheetName, 20, 1);
        String consigneeCompanyName = excelUtility.getCellData(sheetName, 21, 1);
        String consigneeName = excelUtility.getCellData(sheetName, 22, 1);
        String consigneeAddress1 = excelUtility.getCellData(sheetName, 23, 1);
        String consigneeAddress2 = excelUtility.getCellData(sheetName, 24, 1);
        String consigneeAddress3 = excelUtility.getCellData(sheetName, 25, 1);
        String consigneeState = excelUtility.getCellData(sheetName, 26, 1);
        String consigneeContactNumber = excelUtility.getCellData(sheetName, 27, 1);
        String consigneeEmail = excelUtility.getCellData(sheetName, 28, 1);
        String consigneeGstType = excelUtility.getCellData(sheetName, 29, 1);
        String consigneeGstNumber = excelUtility.getCellData(sheetName, 30, 1);
        String bookingYear = excelUtility.getCellData(sheetName, 31, 1);
        String bookingMonth = excelUtility.getCellData(sheetName, 32, 1);
        String bookingDate = excelUtility.getCellData(sheetName, 33, 1);
        String bookingHour = excelUtility.getCellData(sheetName, 34, 1);
        String bookingMinute = excelUtility.getCellData(sheetName, 35, 1);
        String bookingSecond = excelUtility.getCellData(sheetName, 36, 1);
        String invoiceNumber = excelUtility.getCellData(sheetName, 37, 1);
        String content = excelUtility.getCellData(sheetName, 38, 1);
        String contactNumber = excelUtility.getCellData(sheetName, 39, 1);
        String otp = excelUtility.getCellData(sheetName, 40, 1);


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

        double compweight = customerRateCalculator.compareActualWeight();
        softAssert.assertEquals(actWeight, compweight, "weight is not equal");
        softAssert.assertAll();
        customerRateCalculator.clickCreateAwb();
        addAWB.enterShipperDetail(shipperCompanyName, shipperName, shipperAddress1, shipperAddress2, shipperAddress3
              , shipperState, shipperContactNumber, shipperEmail, shipperGstType, shipperGstNumber);
        addAWB.enterConsigneeDetails(consigneeCompanyName, consigneeName, consigneeAddress1, consigneeAddress2, consigneeAddress3
              , consigneeState, consigneeContactNumber, consigneeEmail, consigneeGstType, consigneeGstNumber);
        addAWB.selectPickup();
        addAWB.bookingDate(bookingYear, bookingMonth, bookingDate);
        addAWB.enterBookingTime(bookingHour, bookingMinute, bookingSecond);
        addAWB.enterinvoicenumber(invoiceNumber);
        addAWB.enterContent(content);
        addAWB.clickSubmit();
        addAWB.otpPopUp(contactNumber, otp);


        Map<String, Object> errorCheckResult = addAWB.checkError();
        String message = (String) errorCheckResult.get("message");
        Boolean status = (Boolean) errorCheckResult.get("status");

        System.out.println("Message: " + message);
        System.out.println("Status: " + status);
        System.out.println("checking the error: " + status);
        if (status) {
          softAssert.assertEquals(false, true, "failed because of this message: " + message + " ");
          softAssert.assertAll();
        } else {
          softAssert.assertEquals(true, true);
          softAssert.assertAll();
        }


        String query = "select top 1* from tm_courieritemratedetails where channelid=426431 order by createddate desc";
        ResultSet resultSet = dbClass.executeQuery(query);
        while (resultSet.next()) {
          getCourierId = resultSet.getInt("courierid");
          String origincode = resultSet.getString("origincode");
          String destinationcode = resultSet.getString("destinationcode");
          String productcode = resultSet.getString("productcode");
          String servicetype = resultSet.getString("servicetype");
          String bookingdate = resultSet.getString("bookingdate");
          String bookingtime = resultSet.getString("bookingtime");
          String collectdate = resultSet.getString("collectdate");
          String shipmentcontent = resultSet.getString("shipmentcontent");
          String remark = resultSet.getString("remark");
          String entrytype = resultSet.getString("entrytype");
          String apiservicecode = resultSet.getString("apiservicecode");
          String shipmentvalue = resultSet.getString("shipmentvalue");
          String shippername = resultSet.getString("shippername");
          String shippercompanyname = resultSet.getString("shippercompanyname");
          String shipperphonenumber = resultSet.getString("shipperphonenumber");
          String shipperemailaddress = resultSet.getString("shipperemailaddress");
          String shipperaddressline1 = resultSet.getString("shipperaddressline1");
          String shipperaddressline2 = resultSet.getString("shipperaddressline2");
          String shipperaddressline3 = resultSet.getString("shipperaddressline3");
          String shippercity = resultSet.getString("shippercity");
          String shipperstate = resultSet.getString("shipperstate");
          String shippercountry = resultSet.getString("shippercountry");
          String shipperzipcode = resultSet.getString("shipperzipcode");
          String shippergstintype = resultSet.getString("shippergstintype");
          String shippergstinno = resultSet.getString("shippergstinno");
          String consigneename = resultSet.getString("consigneename");
          String consigneecompanyname = resultSet.getString("consigneecompanyname");
          String consigneecontactno = resultSet.getString("consigneecontactno");
          String consigneeemail = resultSet.getString("consigneeemail");
          String consigneeaddressline1 = resultSet.getString("consigneeaddressline1");
          String consigneeaddressline2 = resultSet.getString("consigneeaddressline2");
          String consigneeaddressline3 = resultSet.getString("consigneeaddressline3");
          String consigneecity = resultSet.getString("consigneecity");
          String consigneestate = resultSet.getString("consigneestate");
          String consigneecountry = resultSet.getString("consigneecountry");
          String consigneezipcode = resultSet.getString("consigneezipcode");
          String consigneegstintype = resultSet.getString("consigneegstintype");
          String consigneegstinno = resultSet.getString("consigneegstinno");
          String pickupaddressname = resultSet.getString("pickupaddressname");
          String pickupaddresscode = resultSet.getString("pickupaddresscode");
          String pickupaddresscontactno = resultSet.getString("pickupaddresscontactno");
          String pickupaddressemail = resultSet.getString("pickupaddressemail");
          String pickupaddressaddressline1 = resultSet.getString("pickupaddressaddressline1");
          String pickupaddressaddressline2 = resultSet.getString("pickupaddressaddressline2");
          String pickupaddressaddressline3 = resultSet.getString("pickupaddressaddressline3");
          String pickupaddresscity = resultSet.getString("pickupaddresscity");
          String pickupaddressstate = resultSet.getString("pickupaddressstate");
          String pickupaddresscountry = resultSet.getString("pickupaddresscountry");
          String pickupaddresszipcode = resultSet.getString("pickupaddresszipcode");
          String pickupaddressgstintype = resultSet.getString("pickupaddressgstintype");
          String pickupaddressgstinno = resultSet.getString("pickupaddressgstinno");
          String pickuprequest = resultSet.getString("pickuprequest");
          String rateservicecode = resultSet.getString("rateservicecode");
          String rateinternalapiservicecode = resultSet.getString("rateinternalapiservicecode");
          String weight = resultSet.getString("weight");
          String othercharges = resultSet.getString("othercharges");
          String rate = resultSet.getString("rate");
          String fsc = resultSet.getString("fsc");
          String igst = resultSet.getString("igst");
          String cgst = resultSet.getString("cgst");
          String sgst = resultSet.getString("sgst");
          String totalrate = resultSet.getString("totalrate");
          String perkg = resultSet.getString("perkg");
          String rateid = resultSet.getString("rateid");
          String vendorlogofile = resultSet.getString("vendorlogofile");
          String docketid = resultSet.getString("docketid");
          String awbno = resultSet.getString("awbno");
          String forwordingno = resultSet.getString("forwordingno");
          String entrynumber = resultSet.getString("entrynumber");
          String remoteareacharges = resultSet.getString("remoteareacharges");
          String createddate = resultSet.getString("createddate");
          String createdby = resultSet.getString("createdby");
          String transactionid = resultSet.getString("transactionid");
          String freight = resultSet.getString("freight");
          String gst = resultSet.getString("gst");
          String iscancelLed = resultSet.getString("iscancelLed");
          //String invoiceno = resultSet.getString("invoiceno");

          System.out.println("Courier Id: " + getCourierId);
          System.out.println("Origin Code: " + origincode);
          System.out.println("Destination code: " + destinationcode);
          System.out.println("Product Code: " + productcode);
          System.out.println("Service Type: " + servicetype);

          System.out.println("Booking Date: " + bookingdate);
          System.out.println("Booking Time: " + bookingtime);
          System.out.println("Collect Date: " + collectdate);
          System.out.println("Shipment Content: " + shipmentcontent);
          System.out.println("Remark: " + remark);
          System.out.println("Entry Type: " + entrytype);
          System.out.println("API Service Code: " + apiservicecode);
          System.out.println("Shipment Value: " + shipmentvalue);
          System.out.println("Shipper Name: " + shippername);
          System.out.println("Shipper Company Name: " + shippercompanyname);
          System.out.println("Shipper Phone Number: " + shipperphonenumber);
          System.out.println("Shipper Email Address: " + shipperemailaddress);
          System.out.println("Shipper Address Line 1: " + shipperaddressline1);
          System.out.println("Shipper Address Line 2: " + shipperaddressline2);
          System.out.println("Shipper Address Line 3: " + shipperaddressline3);
          System.out.println("Shipper City: " + shippercity);
          System.out.println("Shipper State: " + shipperstate);
          System.out.println("Shipper Country: " + shippercountry);
          System.out.println("Shipper Zip Code: " + shipperzipcode);
          System.out.println("Shipper GSTIN Type: " + shippergstintype);
          System.out.println("Shipper GSTIN No: " + shippergstinno);
          System.out.println("Consignee Name: " + consigneename);
          System.out.println("Consignee Company Name: " + consigneecompanyname);
          System.out.println("Consignee Contact No: " + consigneecontactno);
          System.out.println("Consignee Email: " + consigneeemail);
          System.out.println("Consignee Address Line 1: " + consigneeaddressline1);
          System.out.println("Consignee Address Line 2: " + consigneeaddressline2);
          System.out.println("Consignee Address Line 3: " + consigneeaddressline3);
          System.out.println("Consignee City: " + consigneecity);
          System.out.println("Consignee State: " + consigneestate);
          System.out.println("Consignee Country: " + consigneecountry);
          System.out.println("Consignee Zip Code: " + consigneezipcode);
          System.out.println("Consignee GSTIN Type: " + consigneegstintype);
          System.out.println("Consignee GSTIN No: " + consigneegstinno);
          System.out.println("Pickup Address Name: " + pickupaddressname);
          System.out.println("Pickup Address Code: " + pickupaddresscode);
          System.out.println("Pickup Address Contact No: " + pickupaddresscontactno);
          System.out.println("Pickup Address Email: " + pickupaddressemail);
          System.out.println("Pickup Address Line 1: " + pickupaddressaddressline1);
          System.out.println("Pickup Address Line 2: " + pickupaddressaddressline2);
          System.out.println("Pickup Address Line 3: " + pickupaddressaddressline3);
          System.out.println("Pickup Address City: " + pickupaddresscity);
          System.out.println("Pickup Address State: " + pickupaddressstate);
          System.out.println("Pickup Address Country: " + pickupaddresscountry);
          System.out.println("Pickup Address Zip Code: " + pickupaddresszipcode);
          System.out.println("Pickup Address GSTIN Type: " + pickupaddressgstintype);
          System.out.println("Pickup Address GSTIN No: " + pickupaddressgstinno);
          System.out.println("Pickup Request: " + pickuprequest);
          System.out.println("Rate Service Code: " + rateservicecode);
          System.out.println("Rate Internal API Service Code: " + rateinternalapiservicecode);
          System.out.println("Weight: " + weight);
          System.out.println("Other Charges: " + othercharges);
          System.out.println("Rate: " + rate);
          System.out.println("FSC: " + fsc);
          System.out.println("IGST: " + igst);
          System.out.println("CGST: " + cgst);
          System.out.println("SGST: " + sgst);
          System.out.println("Total Rate: " + totalrate);
          System.out.println("Per KG: " + perkg);
          System.out.println("Rate ID: " + rateid);
          System.out.println("Vendor Logo File: " + vendorlogofile);
          System.out.println("Docket ID: " + docketid);
          System.out.println("AWB No: " + awbno);
          System.out.println("Forwarding No: " + forwordingno);
          System.out.println("Entry Number: " + entrynumber);
          System.out.println("Remote Area Charges: " + remoteareacharges);
          System.out.println("Created Date: " + createddate);
          System.out.println("Created By: " + createdby);
          System.out.println("Transaction ID: " + transactionid);
          System.out.println("Freight: " + freight);
          System.out.println("GST: " + gst);
          System.out.println("Is Cancelled: " + iscancelLed);
          //System.out.println("Invoice No: " + invoiceno);
          softAssert.assertEquals(formCityPinCode, origincode, "origin code does not match");
          softAssert.assertEquals(toCityPincode, destinationcode, "destination pincode does not match");
          softAssert.assertEquals(content, shipmentcontent, "shipment content does not match");
          softAssert.assertEquals(shipmentValue+".00", shipmentvalue, "shipment value does not match");
          softAssert.assertEquals(shipperName, shippername, "shipper name does not match");
          softAssert.assertEquals(shipperCompanyName, shippercompanyname, "shipper company name does not match");
          softAssert.assertEquals(shipperContactNumber, shipperphonenumber, "shipper phone number does not match");
          softAssert.assertEquals(shipperEmail, shipperemailaddress, "shipper email does not match");
          softAssert.assertEquals(shipperAddress1, shipperaddressline1, "shipper address line 1 does not match");
          softAssert.assertEquals(shipperAddress2, shipperaddressline2, "shipper address line 2 does not match");
          softAssert.assertEquals(shipperAddress3, shipperaddressline3, "shipper address line 3 does not match");
          softAssert.assertEquals("GURUGRAM", shippercity, "shipper city does not match");
          softAssert.assertEquals(shipperState, shipperstate, "shipper state does not match");
          softAssert.assertEquals("IN", shippercountry, "shipper country does not match");
          softAssert.assertEquals(formCityPinCode, shipperzipcode, "shipper zip code does not match");
          softAssert.assertEquals("Others", shippergstintype, "shipper gstin type does not match");
          softAssert.assertEquals(shipperGstNumber, shippergstinno, "shipper gstin number does not match");
          softAssert.assertEquals(consigneeName, consigneename, "consignee name does not match");
          softAssert.assertEquals(consigneeCompanyName, consigneecompanyname, "consignee company name does not match");
          softAssert.assertEquals(consigneeEmail, consigneeemail, "consignee email does not match");
          softAssert.assertEquals(consigneeAddress1, consigneeaddressline1, "consignee address line 1 does not match");
          softAssert.assertEquals(consigneeAddress2, consigneeaddressline2, "consignee address line 2 does not match");
          softAssert.assertEquals(consigneeAddress3, consigneeaddressline3, "consignee address line 3 does not match");
          softAssert.assertEquals("PUNE", consigneecity, "consignee city does not match");
          softAssert.assertEquals(consigneeState, consigneestate, "consignee state does not match");
          softAssert.assertEquals("IN", consigneecountry, "consignee country does not match");
          softAssert.assertEquals(toCityPincode, consigneezipcode, "consignee zip code does not match");
          softAssert.assertEquals("Others", consigneegstintype, "consignee gst type does not match");
          softAssert.assertEquals(consigneeGstNumber, consigneegstinno, "consignee gst number does not match");
          softAssert.assertEquals(shipperName, pickupaddressname, "pick up address name does not match");
          softAssert.assertEquals(shipperCompanyName, pickupaddresscode, "pick up address code does not match");
          softAssert.assertEquals(shipperContactNumber, pickupaddresscontactno, "pick up address contact number");
          softAssert.assertEquals(shipperEmail, pickupaddressemail, "pick up address email does not match");
          softAssert.assertEquals(shipperAddress1, pickupaddressaddressline1, "pick up address line 1 does not match");
          softAssert.assertEquals(shipperAddress2, pickupaddressaddressline2, "pick up address line 2 does not match");
          softAssert.assertEquals(shipperAddress3, pickupaddressaddressline3, "pick up address line 3 does not match");
          softAssert.assertAll();

        }

      }


    }
  }
}
