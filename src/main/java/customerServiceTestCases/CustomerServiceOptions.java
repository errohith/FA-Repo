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


public class CustomerServiceOptions {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static Actions action;

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
			
			//Window Handling
			Set<String> String1 = driver.getWindowHandles();
			List<String> list = new ArrayList<>(String1);
			list.addAll(list);
			driver.switchTo().window(list.get(1));
			System.out.println(driver.getTitle());
			
			
			//5) MouseHover on Products and Select Service 
			WebElement productMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
			WebElement serviceMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > div > div > div > div:nth-child(1) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span\")");
			action= new Actions(driver);
			action.moveToElement(productMenu).moveToElement(serviceMenu).click().build().perform();
			
			//6) Verify the tabs displayed in the page
			wait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")"));
			productMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
			WebElement resourcesMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
			WebElement supportMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_59 > button > span:nth-child(1)\")");
			WebElement companyMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_75 > button > span:nth-child(1)\")");
			WebElement covid19Menu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_116 > button > span:nth-child(1)\")");

			//Assertion
			Assert.assertEquals(productMenu.getText(),"Products");
			Assert.assertEquals(resourcesMenu.getText(), "Resources");
			Assert.assertEquals(supportMenu.getText(), "Support");
			Assert.assertEquals(companyMenu.getText(), "Company");
			Assert.assertEquals(covid19Menu.getText(), "COVID-19");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			//Close the driver
			driver.quit();		
		}
	}

}
