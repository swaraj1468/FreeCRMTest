package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage; //variable for login page at class level
	HomePage homepage;   //variable for home page 
	public LoginPageTest() throws IOException {
		super();//it will call super class constructor from test  base which we have extented
		           //and all the properties will be initialized
		           
		
	}
	@BeforeMethod
	public void SetUp() throws IOException
	{
		initialization();
		 loginpage= new LoginPage();//creating an object for login page class
		 
		
		 }
	@Test(priority=1)
	public void loginPageTitleTest(){
		String loginpageTitle = loginpage.validateloginpageTitle();
		Assert.assertEquals(loginpageTitle, "#1 Free CRM software in the cloud for sales and service");
		
		
		
			
		}
	@Test(priority=2)
	public void CRMLogoImageTest(){
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag); 
		
	}
	@Test(priority=3)
	public void loginTest() throws IOException{
	
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//it will return home page class object  ,it will store home page class object 
		//
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
