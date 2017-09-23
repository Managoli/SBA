package com.cognizant.cleartrip.Utilits;


public class Constant {
	
	// Input file path and sheet name 
	public static String testFilePath = "D:/SELENIUM-WORKSPACE/ClearTripSBA/src/com/cognizant/cleartrip/TestData/TestData.xls";
	public static String sheetName = "Sheet1";
	public static String urlSheet = "Sheet2";
	public static String chromeBrowser = "D:/Softwares/chromedriver_win32/chromedriver.exe";
	public static String fireFoxBrowser = "D:/Softwares/geckodriver-v0.9.0-win64/geckodriver.exe";
	public static String cleartripURL = "http://www.cleartrip.com";
	public static String search = ExcelUtils.getCellData(5,0);
	
	// Home page Xpth and ID.
	
	public static String hotelTabXpath = "//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[2]/a[1]";
	public static String searchTextID = "Tags";
	public static String searchFieldID = "wgSelectChoosen";
	public static String checkInDateID = "CheckInDate";
	public static String checkoutDateID = "CheckOutDate";
	
}
