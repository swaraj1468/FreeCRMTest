package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest() throws IOException {
		super();//to call base class constructor 
	}
	
	//test cases should be separated -- independent to each other.
	//before each  test case launch the browser and login
	//@test execute the test case
	//after each test case ---close the browser
		@BeforeMethod
		public void setUp() throws IOException
		{
			initialization();
			 loginpage= new LoginPage();//creating an object for login page class
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			testutil= new TestUtil();
			 contactspage=new ContactsPage();
			 }
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homepageTitle = homepage.verifyHomePageTitle();
			Assert.assertEquals(homepageTitle, "CRMPRO","HOME PAGE TITLE NOT MATCHED");
		}
		@Test(priority=2) 
		public void verifycorrectusernameTest(){
			testutil.switchToframe();
			Assert.assertTrue(homepage.verifycorrectusername());
			
	}
		@Test(priority=3)
		public void verifycontactslinktest() throws IOException
		{
			testutil.switchToframe();
			contactspage=homepage.clickOnContactslink();	
			
		}
		@AfterMethod
		public void teardown(){
			driver.quit();
		}
//		@Test
//		public void clickoncontactslinkTest()
//		{
//			homepage.clickOnContactslink();
//		}
		
		
					}


