package customerServiceTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleplaystoreloadedtodownloadSalesForceA {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	
	public static void main(String[] args) {


		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

			// Webdriver Setup
			WebDriverManager.chromedriver().setup();

			// ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			// Create Chrome Driver Object
			driver = new ChromeDriver(option);

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;
			

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();

			// 1) Launch the app
			driver.navigate().to("https://www.salesforce.com/");
			
			//2) Click Login
			driver.findElement(By.xpath("//div[@aria-label='Login']")).click();
			
			//3) Login with the credentials
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			//4) Click on the sliding icon until "Download SalesForceA" is displayed
			while(!driver.findElement(By.xpath("//span[text()='Download SalesforceA']")).isDisplayed()) {
				driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]")).click();
			}
			
			//5) Click on Google Play link
			driver.findElement(By.xpath("//button[@title='Google Play']")).click();
			
			//6) Navigate to the Google Play window 
			Set<String> String1 = driver.getWindowHandles();
			List<String> list = new ArrayList<>(String1);
			list.addAll(list);
			driver.switchTo().window(list.get(1));
			System.out.println(driver.getTitle());
			
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			
			//7) Verify that SalesForceA is displayed with enabled Install button
			Set<String> String2 = driver.getWindowHandles();
			List<String> list1 = new ArrayList<>(String2);
			list1.addAll(list1);
			driver.switchTo().window(list1.get(1));
			System.out.println(driver.getTitle());
			
			Assert.assertEquals(driver.findElement(By.xpath("//h1[@class='AHFaub']/span")).getText(),"SalesforceA");
			Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label='Install']")).isEnabled());
					
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//Close the driver
			driver.quit();		
		}
	}
}
