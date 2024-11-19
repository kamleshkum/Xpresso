package com.xpresso.qa.utilites;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xpresso.qa.base.TestBase;

public class Testutil extends TestBase {

	public Alert alert;
	static JavascriptExecutor js;

	
   // Explicit Wait Element Visible
	public void ExplictWait_ElementVisiblity(int duartion, WebElement loactor) {
		WebDriverWait  WebWait=new WebDriverWait(driver,Duration.ofSeconds(duartion));
		WebWait.until(ExpectedConditions.visibilityOf(loactor));
	}
	
	// Explicit Wait Element Clickable 
		public void ExplictWait_ElementClickable(int duartion, WebElement loactor) {
			WebDriverWait  WebWait=new WebDriverWait(driver,Duration.ofSeconds(duartion));
			WebWait.until(ExpectedConditions.elementToBeClickable(loactor));
		}
	
	// Explicit wait for Alert present
		
		public void ExplictWait_AlertPresent(int duartion) {
			
			WebDriverWait  WebWait=new WebDriverWait(driver,Duration.ofSeconds(duartion));
			WebWait.until(ExpectedConditions.alertIsPresent());
		}
	
	

	// Get Text from Alert pop-up
	public String GetAlertTextt() {
		try {
			alert = driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alert.getText();
	}

	// Accept Alert Pop-up
	public void AcceptAlertPopup() {
		alert = driver.switchTo().alert();
		alert.accept();
	}

	// Reject Alert Pop-up
	public void RejectAlertPopup() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// Switch to Frame by Index
	public void SwitchtoFramebyIndex(int index) {
		driver.switchTo().frame(index);
	}

	// Switch to Frame by Name or ID.
	public void SwitchtoFramebyNameorID(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch to Frame by Webelement.
	public void SwitchtoFramebyWebelement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch to child windows and Get current url
	public String SwitchtoChildWindow_GetURl() {
		String ParentID = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		Iterator<String> it = Allwindows.iterator();
		while (it.hasNext()) {
			String childwindow = it.next();
			if (!childwindow.equalsIgnoreCase(ParentID)) {
				driver.switchTo().window(childwindow);

			}
		}
		return driver.getCurrentUrl();

	}

	// Switch to child windows and Get current page title
	public String SwitchtoChildWindow_GetPagetitle() {
		String ParentID = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();
		Iterator<String> it = Allwindows.iterator();
		while (it.hasNext()) {
			String childwindow = it.next();
			if (!childwindow.equalsIgnoreCase(ParentID)) {
				driver.switchTo().window(childwindow);

			}
		}
		return driver.getTitle();

	}


	public static void GetCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String str = formatter.format(date);
		System.out.println(str);
		Calendar clndr = Calendar.getInstance();
		clndr.setTime(date);
		// Date after 55YRs
		clndr.add(Calendar.YEAR, -55);
		Date updateDate = clndr.getTime();
		String back = formatter.format(updateDate);
		System.out.println(back);
		String[] words = back.split("\\s");
		for (String s : words) {

			System.out.println(s);
		}
	}

	public void SelectfromDropDownbyVisibleTEXT(WebElement xpath, String text) {

		Select sel = new Select(xpath);
		sel.selectByVisibleText(text);

	}
	
	public void DisplayDropDownnData(WebElement elemnt) {
		Select sel = new Select(elemnt);
		List<WebElement> lt1 = sel.getOptions();
		int Size = lt1.size();
		for (int i = 0; i <= Size - 1; i++) {
			System.out.println(lt1.get(i).getText());
		}
	}

	

	public void SrollDown(int pixel) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,pixel)");
	}

	public void SrollDownUntilElemntVisible(WebElement Element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	
	public String captureScreen(String tName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String tagetFilePath = System.getProperty("user.dir") + "\\\\screenshots\\" + tName + "-" + timeStamp + ".png";
		
		File targetFile = new File(tagetFilePath);
		
		SourceFile.renameTo(targetFile);
		
		return tagetFilePath;

	}
	
	
}
