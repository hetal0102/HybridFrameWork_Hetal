package com.hr.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hr.base.Base;
import com.hr.dataprovider.CustomeDataProviders;
import com.hr.pages.HomePage;
import com.hr.pages.LoginPage;
import com.hr.pages.SingUpPage;

public class LoginTest extends Base{

	LoginPage login;
	@Test(dataProvider = "loginTestData",dataProviderClass =CustomeDataProviders.class )
	
	public void validLoginTest(String username, String password)
	{
		
		 login =new LoginPage(driver);
		HomePage home=login.loginToApplication(username, password);
		Assert.assertTrue(home.isWelcomeMsgDisplayed());
		
	}
	
	@Test
	public void verifyNewLink() {
		 login=new LoginPage(driver);
		
		Assert.assertTrue(login.isLinkVisible());
	}
	
	@Test
	public void clickOnSignUpLink() 
	{
		login=new LoginPage(driver);
		SingUpPage signUp=login.clickOnSignUp();
		
		
	}

}
