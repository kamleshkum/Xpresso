package com.xpresso.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public Logger loger;

	public TestBase() {

		loger = LogManager.getLogger(this.getClass());

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:/Users/rohit.mathur/Roinet/Xpresso/src/main/resources/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public static void Browserintialize(String browsername, String url) {

		if (browsername.equalsIgnoreCase("chrome")) {
		    
		    ChromeOptions chromeOptions = new ChromeOptions();
		    chromeOptions.addArguments("--ignore-certificate-errors");
			driver = new ChromeDriver(chromeOptions);

		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}

	public static void TearDown() {

		driver.close();
	}

}
