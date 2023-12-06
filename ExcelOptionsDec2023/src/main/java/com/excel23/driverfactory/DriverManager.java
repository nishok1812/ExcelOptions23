package com.excel23.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.excel23.utility.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
private static WebDriver driver=null;
private static final Logger LOG=LogManager.getLogger(DriverManager.class);

	
	public static WebDriver launchBrowser() {
		try {
			String browser_Name = CommonUtils.BROWSER;
			switch (browser_Name) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				LOG.info("Launching browser:" +browser_Name);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				LOG.info("Launching browser:" +browser_Name);
				break;
				
			case "safari":
				System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
				SafariOptions options = new SafariOptions();
				options.setCapability("pageLoadStrategy", "normal");
				driver = new SafariDriver(options);
				LOG.info("Launching browser:" +browser_Name);
				break;
			
				
			default:
				WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			LOG.info("Launching browser:" +browser_Name);
			break;
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	

}
