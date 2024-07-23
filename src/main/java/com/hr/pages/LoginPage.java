package com.hr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.hr.utility.Utility;

public class LoginPage 
{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	private By username=By.xpath("//input[contains(@placeholder,'Enter Email')]");
	private By Password=By.xpath("//input[@id='password1']");
	private By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	private By createNewUser=By.xpath("//a[normalize-space()='New user? Signup']");
	
	public boolean isLinkVisible() {
		
		
		boolean status=Utility.getElement(driver, createNewUser).isDisplayed();
		
		return status;
	}
	public HomePage loginToApplication(String uname,String pass) {
		
		
		Utility.getElement(driver, username).sendKeys(uname);
		
		
		Utility.getElement(driver, Password).sendKeys(pass);
		
		Utility.clickElement(driver, Utility.getElement(driver, loginButton));
	
		HomePage home=new HomePage(driver);
		
		return home;
		
		
	}
	
	public SingUpPage clickOnSignUp() {
		Utility.clickElement(driver, Utility.getElement(driver, createNewUser));
		
		SingUpPage SingUp=new SingUpPage(driver);
		return SingUp;
	}
	
	
	
}
