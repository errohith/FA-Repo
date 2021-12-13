package customerServiceTestCases;

import java.io.IOException;
import java.time.Duration;

import java.util.LinkedHashMap;

import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.*;

public class S011072_DownloadPDF {
	
	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static Map<String,Object> prefs;
	public static String downloadPath="C:\\Users\\velsp\\eclipse-workspace\\FullStackAutomationPgm\\downloadPDF";
	
	public static void main(String[] args) {


		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

			// Webdriver Setup
			WebDriverManager.chromedriver().setup();

			// ChromeOption Setup
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			prefs = new LinkedHashMap<String,Object>();
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.default_directory", downloadPath);
			prefs.put("plugins.always_open_pdf_externally", true);
			option.setExperimentalOption("prefs", prefs);
			
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
			
			//4) Click on the sliding icon until "View Release Notes" is displayed
			while(!driver.findElement(By.xpath("//span[text()='View Release Notes']")).isDisplayed()) {
				driver.findElement(By.xpath("//button[contains(@class,'rightArrowButton')]")).click();
			}
			
			//5) Click on Get Started link
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Salesforce release')]/parent::div/following-sibling::div/button")));
			
			//6) Navigate to Release Notes new Window
			driver.switchTo().window(Util.getLastWindow(driver));
			
			//7) Select Summer 20 release notes from the dropdown
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='combobox' and @name='releaseVersionPicker']")));
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.titleContains("Salesforce Winter ’22 Release Notes"));
			driver.findElement(By.xpath("//input[@role='combobox' and @name=\"releaseVersionPicker\"]")).click();
			driver.findElement(By.xpath("//span[@title=\"Summer '20\"]")).click();		
			
			//8) Click on the Download Summer 20 release notes link and Download the Release Notes
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Open PDF']")).click();
			
			//9) Verify the downloaded release notes pdf 
			while (Util.getDownloadedFileName().contains("crdownload")) {
				Thread.sleep(50);
				Util.getDownloadedFileName();
			}
			Assert.assertEquals(Util.getDownloadedFileName(), "salesforce_summer20_release_notes.pdf");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//Close the driver
			//driver.quit();		
		}
	}
}
