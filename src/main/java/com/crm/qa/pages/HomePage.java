package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase  {

//td[contains(text(),'contacts')]

	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Taskslink;
	public HomePage() throws IOException //constructor to initialize the page objects
	{
		
		PageFactory.initElements(driver, this);
	}
	//Actions(different features available in home page
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifycorrectusername()
	{
		//driver.switchTo().frame("mainpanel");
	return	usernamelabel.isDisplayed();
	
	}
	public ContactsPage clickOnContactslink() throws IOException {
		
		contactslink.click();
		return new ContactsPage();
	}
	public void clickonnewcontactlink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactslink.click();
		
		
	}
	
	public DealsPage clickOnDealslink(){
		
		Dealslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTaskPage(){
   // we are clicking on task page it should return 
	//task page object ,so return new TaskPage(); and return type is task page
		Taskslink.click();
		return new TaskPage();
	}
	
	
	
	
	
	
	
	
			
		
	
	
	
}
