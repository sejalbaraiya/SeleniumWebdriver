import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {

	WebDriver driver;

	@Test
	public void amazonItem() {
		//Search the item, select the item
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[6]/div/span/div/div")).click();
		// Quantity selection	
		driver.findElement(By.xpath("//*[@id=\"quantity\"]/option[2]")).click();
	}
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.ca/");

	}


	@AfterMethod
	public void tearDown() throws Exception {
		if(driver!= null) {
			driver.quit();
		}

	}
}
