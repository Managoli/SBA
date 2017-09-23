package com.cognizant.cleartrip.Tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cognizant.cleartrip.Actions.SelectBrowsers;
import com.cognizant.cleartrip.PageObjects.HomePage;
import com.cognizant.cleartrip.Utilits.Constant;
import com.cognizant.cleartrip.Utilits.ExcelUtils;

public class HomePageTest {
	public static WebDriver driver;
	public static WebElement element;
	
	@BeforeTest
	public void setBrowserTypeTest() throws Exception{
		driver = SelectBrowsers.setBrowserType(driver);
		driver.get(Constant.cleartripURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void clickHotelTabTest() throws Exception{
		
		
		element = HomePage.clickHotelTab(driver);
		element.click();
		Log.info("Title of the page after clicking hotel tab : "+driver.getTitle());
		
	}
	@Test
	public void searchTextTest() throws InterruptedException{
		//Thread.sleep(1000);
		element = HomePage.searchHotels(driver);
		String search = ExcelUtils.getCellData(5,0);
		System.out.println("Search Text is :"+search);
		element.sendKeys(search);
	//	Thread.sleep(1000);
		//element.click();
		Thread.sleep(1000);
		Log.info("Title of the page after search text : "+driver.getTitle());
		
	}
	@Test
	public void selectWhereTest() throws InterruptedException{
		element = HomePage.searchTextEnter(driver);
		/*Select fruits = new Select(element);
		List <WebElement> elementCount = fruits.getOptions();*/
		if(!element.isSelected()){
			element = HomePage.searchHotels(driver);
			element.clear();
			String search = ExcelUtils.getCellData(5,1);
			System.out.println("test123"+search);
			element.sendKeys(search, Keys.ENTER);
		}
		Thread.sleep(1000);
	}
	@Test
	public void selectDates() throws InterruptedException{
		element = HomePage.selectCheckInDate(driver);
		element.sendKeys("26",Keys.ENTER);
		Thread.sleep(1000);
		element = HomePage.selectCheckOutDate(driver);
		element.sendKeys("27",Keys.ENTER);
		
	}
	
	@AfterTest
	public void closeApplicationTest(){
		driver.quit();
	}

}
