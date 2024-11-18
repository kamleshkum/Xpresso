package com.xpresso.qa.ExtentReportListner;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.xpresso.qa.utilites.Testutil;

public class ExtentReport implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the Report
	public ExtentReports extent; // populate common info
	public ExtentTest test; // Creating test case entries in the report and update status of the test
							// methods.
	String repName;

	// When start execution of the code
	public void onStart(ITestContext context) {

		// SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// Date dt=new Date();
		// String currentdatetime=df.format(dt);

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Get date and time

		repName = "Test-Report" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// Specify
																			// location
																			// of report
		sparkReporter.config().setDocumentTitle("Xpresso Automation Report"); // Title of the report
		sparkReporter.config().setReportName("Xpresso Functional Testing"); // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "Xpresso");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("os", "Windows");
		extent.setSystemInfo("Browser Name", "Chrome");

		// String os=context.getCurrentXmlTest().getParameter("os");
		// extent.setSystemInfo("Operating system", os);

		// String brser=context.getCurrentXmlTest().getParameter("browser");
		// extent.setSystemInfo("Running Browser", brser);

		List<String> Includedgroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!Includedgroups.isEmpty()) {
			extent.setSystemInfo("Groups", Includedgroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // Create New entry in the report
		test.assignCategory(result.getMethod().getGroups());// to display groups in report
		test.log(Status.PASS, " Test Case PASSED is: " + result.getName()); // update status

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // Create New entry in the report
		test.assignCategory(result.getMethod().getGroups());// to display groups in report
		
		test.log(Status.FAIL, " Test Case FAILED is: " + result.getName()); // update status
		test.log(Status.INFO, " Reason of Test Case Fail is: " + result.getThrowable().getMessage()); // update reason of fail
		
		// Attachment screenshot on Failure
		try {
			String ImagePath=new Testutil().captureScreen(result.getName());
			test.addScreenCaptureFromPath(ImagePath);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); // Create New entry in the report
		test.assignCategory(result.getMethod().getGroups());// to display groups in report
		test.log(Status.SKIP, " Test Case SKIPPED is: " + result.getName()); // update status
		test.log(Status.INFO, " Reason of Test Case SKIPPED is: " + result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+ repName;
		File ExtentReport=new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(ExtentReport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
	
	}
