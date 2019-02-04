package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; // class variable
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException //constructor(its name would be same as class name)
	{
		try {
			prop = new Properties();
			FileInputStream ip = new  FileInputStream("D:/Java_Tutorials/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		}
	public static void initialization() throws IOException
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/swaraj/Downloads/chromedriver_win32/chromedriver.exe");
			driver= new ChromeDriver();
			}else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/swaraj/Downloads/geckodriver-v0.20.1-win64");
			driver= new FirefoxDriver();
				}
		 e_driver=new EventFiringWebDriver(driver);
		 eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
