package com.hr.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hr.utility.Utility;

public class SingUpPage

{
	WebDriver driver;
	
	public SingUpPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	private By signUpName=By.xpath("//input[@id='name']");
	private By signUpEmailID=By.xpath("//input[@id='email']");
	private By signUpPassword=By.xpath("//input[@id='password']");
	private By selectInterests=By.xpath("//div[@class='interest-div']");
	private By numberOfCheckbox=By.xpath("//input[@type='checkbox']");
	private By selectGenderMale=By.xpath("//input[@id='gender1']");
	private By selectGenderFemale=By.xpath("//input[@id='gender2']");
	private By selectState=By.xpath("//select[@id='state']");
	private By selectHobbies=By.xpath("//select[@id='hobbies']");
	private By clickOnSignUp=By.xpath("//button[@class='submit-btn']");
	
	
	
	
	
	public LoginPage userFillUpSingUpDetails(String name,String emailId,String password)
	{
		
		Utility.getElement(driver, signUpName).sendKeys(name);
		Utility.getElement(driver, signUpEmailID).sendKeys(emailId);
		Utility.getElement(driver, signUpPassword).sendKeys(password);
		
	
		Utility.selectByVisibleText(driver.findElement(selectInterests), "GCP");
		Utility.selectByValue(driver.findElement(selectGenderMale), "Male");
		Utility.selectByVisibleText(driver.findElement(selectState), "Gujarat");
		Utility.selectByVisibleText(driver.findElement(selectHobbies), "Playing");
		
		Utility.clickElement(driver, clickOnSignUp);
		
		LoginPage login= PageFactory.initElements(driver, LoginPage.class);;
		
		return login;

	}
	
	// verified NumberOfCheckBoxSize is greater than >5
	public LoginPage verifyNumberOFCheckBoxPresent() 
	{
		
		Utility.clickElement(driver, Utility.getElement(driver, clickOnSignUp));
		List<WebElement>checkbox=driver.findElements(numberOfCheckbox);
		
		Assert.assertTrue(checkbox.size()>5, "number of checkbox is < 5");
		

		LoginPage login=new LoginPage(driver);
		
		return login;
		
		
	}
	
	public LoginPage navigateBackToLoginPage() 
	{
		LoginPage login=new LoginPage(driver);
		driver.navigate().back();
		return login;
		
	}
	
	 

}
