import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/swaraj/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.freecrm.com");
		
	driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[1]")).sendKeys("swaraj");
	driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[2]")).sendKeys("swaraj");
	driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).click();


	}

}
