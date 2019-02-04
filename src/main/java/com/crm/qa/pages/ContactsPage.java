package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	@FindBy(id="first_name")
	WebElement Firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
		}
public boolean contactslabelverify(){
	return contactslabel.isDisplayed();
}
public void selectcontactsByname(String name){
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	
}
	public void createnewcontact(String title,String fname,String Lname,String cmp){
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		Firstname.sendKeys(fname);
		lastname.sendKeys(Lname);
		company.sendKeys(cmp);
		SaveBtn.click();
		
	}
	
	
}
