package com.crm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//fage factory---OR
	
	@FindBy(name="username" ) // this is equals to driver.findelementby
	WebElement username;   // then  we have to define variable WebElement username  
	
	@FindBy(name="password" )
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']" )
	WebElement loginBtn;
	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]") 
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']") 
	WebElement crmLogo;
	
	//initializing the page objects
	public LoginPage() throws IOException {
		//super keyword will call test base class constructor we need to call both constructor and class 
		
		PageFactory.initElements(driver, this);
// Initialize the element with help of page factory
// all the above elements will be initialized by this driver and
// this represents this class u can also give page class name		
		
	}
	//Actions(different features available in login page
	public  String validateloginpageTitle()
	{
		return driver.getTitle();
		
	}
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pw) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		
		
		loginBtn.click();  //after clicking login btn it will return to homepage class object
		return new HomePage(); // home page is landing page for loginpage, so we have to return homepage() class object
	}

}
