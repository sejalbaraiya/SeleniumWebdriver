import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	WebDriver driver;
	String emailID= "sejal.baraiya@gmail.com";
	String newPassword = "";
	String messege= " Important Message!";
	String errorMessege = " There was a problem\r\n" + "Enter the characters as they are shown in the image. ";
	String messegeAprrove= "To continue, approve the notification sent to:";
	@Test
	public void amazonItem() {
		//Search the item, select the item
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("headphones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[6]/div/span/div/div")).click();
		// Quantity selection	
		driver.findElement(By.xpath("//*[@id=\"quantity\"]/option[2]")).click();
		//Add to cart selection
		driver.findElement(By.cssSelector("input[name='submit.add-to-cart'][title='Add to Shopping Cart']")).click();
		//No thanks for coverage
		driver.findElement(By.cssSelector("input[type='submit'][class='a-button-input']")).click();
		//Sign in 
		WebElement loginEmail= driver.findElement(By.id("ap_email"));
		loginEmail.sendKeys(emailID);
		driver.findElement(By.id("continue")).click();
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys(newPassword);
		driver.findElement(By.cssSelector("input[type='checkbox'][name='rememberMe'][value='true']")).click();	
		WebElement btnSignIn= driver.findElement(By.id("signInSubmit"));
		btnSignIn.click();
		// master card selected and press continue 
		
		WebElement msgApprove = driver.findElement(By.xpath("//*[@id=\"body\"]/div/div/div[2]"));
		msgApprove.isDisplayed();
		
		
		WebElement clickRefreshPage = driver.findElement(By.xpath("//*[@id=\"body\"]/div/div/div[6]/div/a"));
		clickRefreshPage.isDisplayed();
		
		driver.navigate().refresh();
//		clickRefreshPage.click();
		
		//waitForPageLoad();
		
//		WebElement btnContinueCard= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name = 'ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'] [type= 'submit']")));
//		WebElement btnContinueCard= driver.findElement(By.xpath("//*[@id=\"pp-Vc2xF3-56\"]/span/input"));
		
//		WebElement continueBtn= driver.findElement(By.xpath("//*[@id=\"pp-4nJmwR-46\"]/div[2]"));
		
//		continueBtn.click();
		
//		String actualURL= "https://www.amazon.ca/";
//		String expectedURL= driver.getCurrentUrl();
//		Assert.assertEquals(expectedURL,actualURL);

		
		//WebElement errorMessege= driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]"));
		//String error = errorMessege.getText();
		
//		Assert.assertEquals(errorMessege, messege);
		
//		driver.findElement(By.id("auth-fpp-link-bottom")).click();

		//Input the email for send the password reset link
//		driver.findElement(By.cssSelector("input[name='email'][value='sejal.baraiya@gmail.com']"));

		//Assert.assertEquals(loginID,emailID);
//		driver.findElement(By.id("continue")).click();

		//Again come to sign in and now password we need OTP 
//		driver.findElement(By.xpath("//*[@id=\"cvf-page-content\"]/div/div/div[1]/form/div[2]/input")).sendKeys("165102");

//		driver.findElement(By.xpath("//*[@id=\"a-autoid-0\"]/span/input")).click();

		// After OTP page  Password page 
//		driver.findElement(By.id("ap_password")).sendKeys(newPassword);


//		driver.findElement(By.id("signInSubmit")).click();
		
		//Print the money total
		//		String totalMoney= driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		//		System.out.println("The total of your items:"+totalMoney);

	}

	public void waitForPageLoad() {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
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
