package com.hr.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class CustomeDataProviders 
{

	@DataProvider(name="loginTestData")
	public static Object[][] generateTestDataFromExcel()
	{
		Reporter.log("Preparing Data From Excel", true);
		
		Object [][]arr= ExcelReader.getDataFromExcel("LoginCredentials");
		
		Reporter.log("Test Data Prepared", true);
		
		return arr;
	}
	
	
	@DataProvider(name="SignUpTestData")
	public static Object[][] generateTestDataFromExcelForSignUp()
	{
		Reporter.log("Preparing Data From Excel", true);
		
		Object [][]arr= ExcelReader.getDataFromExcel("SignUpDetails");
		
		Reporter.log("Test Data Prepared", true);
		
		return arr;
	}
	
}
