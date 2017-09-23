package com.cognizant.cleartrip.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;

import com.cognizant.cleartrip.Utilits.Constant;
import com.cognizant.cleartrip.Utilits.ExcelUtils;


public class HomePage {
	WebDriver driver;
	public static WebElement element;
	
	public static WebElement clickHotelTab(WebDriver driver) throws InterruptedException{
		
		element = driver.findElement(By.xpath(Constant.hotelTabXpath));
		Log.info("Element is returned to HomePageTest object");
		return element;
	}
	
	public static WebElement searchHotels(WebDriver driver){
		
		element = driver.findElement(By.id(Constant.searchTextID));
		return element;
		
	}
	
	public static WebElement searchTextEnter(WebDriver driver){
		
		return element =driver.findElement(By.id(Constant.searchFieldID));
	}
	public static WebElement selectCheckInDate(WebDriver driver){
		
		return element = driver.findElement(By.id(Constant.checkInDateID));
		}
	public static WebElement selectCheckOutDate(WebDriver driver){
		
		return element = driver.findElement(By.id(Constant.checkoutDateID));
		}

}
