package weekTwo;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
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

public class Customer_Service_Options {
	
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

			
			driver.navigate().to("https://www.salesforce.com/");
			
		
			driver.findElement(By.xpath("//div[@aria-label='Login']")).click();
			
			
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			
			driver.findElement(By.xpath("//span[text()='Mobile Publisher']/ancestor::div[@class='tileTitle']/following-sibling::div[@class='tileNavButton']//button[@title='Learn More']")).click();
			
			Set<String> String1 = driver.getWindowHandles();
			List<String> list = new ArrayList<>(String1);
			list.addAll(list);
			driver.switchTo().window(list.get(1));
			System.out.println(driver.getTitle());
			
			 
			WebElement productMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
			WebElement serviceMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > div > div > div > div:nth-child(1) > ul > li > div.sub-nav > ul > li:nth-child(3) > a > span\")");
			action= new Actions(driver);
			action.moveToElement(productMenu).moveToElement(serviceMenu).click().build().perform();
			
		
			wait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")"));
			productMenu=(WebElement)js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button > span:nth-child(1)\")");
			WebElement resourcesMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_33 > button > span:nth-child(1)\")");
			WebElement supportMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_59 > button > span:nth-child(1)\")");
			WebElement companyMenu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_75 > button > span:nth-child(1)\")");
			WebElement covid19Menu=(WebElement) js.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_116 > button > span:nth-child(1)\")");

		
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
