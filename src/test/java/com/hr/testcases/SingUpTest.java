package com.hr.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hr.base.Base;
import com.hr.dataprovider.CustomeDataProviders;
import com.hr.pages.LoginPage;
import com.hr.pages.SingUpPage;


public class SingUpTest extends Base
{
	
	SingUpPage signUp;
	
	@Test(dataProvider = "SignUpTestData", dataProviderClass = CustomeDataProviders.class)
	public void signUp(String name,String password, String emailId) 
	{
		 signUp=new SingUpPage(driver);
		
		LoginPage login=signUp.userFillUpSingUpDetails(name, emailId, password);
		
	}
	@Test
	public void userVerifyNumberOFCheckBox() 
	{
		
		signUp=new SingUpPage(driver);
		
		LoginPage login=signUp.verifyNumberOFCheckBoxPresent();
		userNavigateBackToLoginPage();
		
		
	}
	
	@Test
	public LoginPage userNavigateBackToLoginPage()
	{
		signUp=new SingUpPage(driver);
		LoginPage login=signUp.navigateBackToLoginPage();
		
		return login;
	}
		
	}
	
	


