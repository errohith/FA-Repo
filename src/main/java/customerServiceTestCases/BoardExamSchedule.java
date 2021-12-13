package customerServiceTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BoardExamSchedule {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static Actions action;
	static String expectedList[] = {"Application Architect","B2B Solution Architect","B2C Solution Architect","B2C Commerce Architect","Heroku Architecture Designer","System Architect","Technical Architect"};

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
			
			//4) Click on Learn More link in Mobile Publisher
			driver.findElement(By.xpath("//span[text()='Mobile Publisher']/ancestor::div[@class='tileTitle']/following-sibling::div[@class='tileNavButton']//button[@title='Learn More']")).click();
			
			//5) Navigate to  Create and publish custom-branded mobile apps.
			Set<String> String1 = driver.getWindowHandles();
			List<String> list = new ArrayList<>(String1);
			list.addAll(list);
			driver.switchTo().window(list.get(1));
			System.out.println(driver.getTitle());
			
			wait.until(ExpectedConditions.titleContains("Create and Publish Custom-Branded Mobile Apps"));
			Assert.assertEquals(driver.getTitle(),"Create and Publish Custom-Branded Mobile Apps - Salesforce.com");
			
			//5) Mouse hover on resources and select SalesForce Certification   
			WebElement resourcesMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
			WebElement sfCertSubMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > div > div > div > div:nth-child(2) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span:nth-child(1)\")");
			action= new Actions(driver);
			action.moveToElement(resourcesMenu).moveToElement(sfCertSubMenu).click().build().perform();
			
			//6) Navigate to  Certification-Administrator Overview 
			Set<String> String2 = driver.getWindowHandles();
			List<String> list2 = new ArrayList<>(String2);
			list2.addAll(list2);
			driver.switchTo().window(list.get(1));
			System.out.println(driver.getTitle());
			
			wait.until(ExpectedConditions.titleContains("Certification - Administrator Overview"));
			Assert.assertEquals(driver.getTitle(), "Certification - Administrator Overview");
			
			//7) Select Salesforce Architect
			driver.findElement(By.xpath("//div[text()='Salesforce Architect']")).click();
			
			//8) Verify the Page tile after selecting Architect
			Assert.assertEquals(driver.getTitle(), "Certification - Architect Overview");
			
			//9) Verify the Certifications listed for Architect
			driver.findElement(By.xpath("//div[@class='cs-card tile']//a[contains(@href,'credentials') and (@class)]")).click();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//Close the driver
			//driver.quit();		
		}
	}
}
