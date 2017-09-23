package com.cognizant.cleartrip.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.cognizant.cleartrip.Utilits.Constant;
import com.cognizant.cleartrip.Utilits.ExcelUtils;


public class SelectBrowsers {
	
	public static WebDriver setBrowserType(WebDriver driver) throws Exception{
		
		ExcelUtils.setExcelFile(Constant.testFilePath, Constant.sheetName);
		String browserType = ExcelUtils.getCellData(1, 1);
		/*System.out.println(Constant.testFilePath);
		System.out.println(browserType);*/
		
		// Setting the browser type based on the Test data in Excel sheet.
		switch(browserType){
		
			case "One" : {
				System.setProperty("webdriver.Mozila.driver", Constant.fireFoxBrowser );
				driver = new FirefoxDriver();
				return driver;
			}
			case "Two" :{
				System.setProperty("webdriver.chrome.driver", Constant.chromeBrowser );
				driver = new ChromeDriver();
				return driver;
			}
			case "Three" :{
				driver = new InternetExplorerDriver();
				return driver;
			}
			case "Four" :{
				driver = new SafariDriver();
				return driver;
			}
			default : return driver;
		}
	}
}
