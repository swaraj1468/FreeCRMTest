package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase 
{
LoginPage loginpage;
	
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="Contacts";
	public ContactsPageTest() throws IOException{
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		 loginpage= new LoginPage();//creating an object for login page class
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil= new TestUtil();
		 contactspage=new ContactsPage();
		 testutil.switchToframe();
		 contactspage= homepage.clickOnContactslink();
		
		 }
	@Test(priority=1)
	public void contactspagelabel(){
		
		Assert.assertTrue(contactspage.contactslabelverify(),"contactslabelmissing");
	}
	@Test(priority=2)
	public void SelectContacts() {
		contactspage.selectcontactsByname("panjala chinna");
		
		contactspage.selectcontactsByname("xyz abc");
		
	}
	@DataProvider
	public Object[][] getCRMTestdata() throws EncryptedDocumentException, IOException{
		Object data[][]=testutil.getTestData(sheetname);
		return data;
	}
//	@Test(priority=3)
//	public void validatecreatenewcontact(){
//		 homepage.clickonnewcontactlink();
//		contactspage.createnewcontact("Mr.", "raj", "rajj", "careergaruda");
//	}
	@Test(priority=3,dataProvider="getCRMTestdata")
	public void validatecreatenewcontact(String Title,String Firstname,String Lastname,String company){
		 homepage.clickonnewcontactlink();
		contactspage.createnewcontact(Title, Firstname, Lastname, company);
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
