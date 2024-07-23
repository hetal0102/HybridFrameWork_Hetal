package com.hr.base;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hr.dataprovider.ConfigReader;
import com.hr.factory.BrowserFactory;


public class Base 
{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.out.println("LOG:INFO - Starting Browser - Running Before Method ");
		
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browserName"), ConfigReader.getProperty("appURLQA")+"/login");

	
	}
	@AfterMethod
	public void tearDown() {
		System.out.println("LOG:INFO - Closing Browser - Running After Method ");
		BrowserFactory.closeBrowser(driver);
		System.out.println("LOG:INFO - Session Closed");
	}
	
	
}
