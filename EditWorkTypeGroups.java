package weekOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditWorkTypeGroups {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =  new ChromeOptions();
		//Disable Notifications  
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//Launch Browser 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login 
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		//Click toggle menu  
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search this list...\"]")).sendKeys("Salesforce Automation by Rohith");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='listviewSearchTooltip-110']")).click();
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::textarea")).sendKeys("automation");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2[contains(@class,'Title')]/following-sibling::div//span[text()='Group Type']/parent::span/following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[text()='Capacity']")).click();
		driver.findElement(By.xpath("//div[@class=\"button-container slds-text-align_right forceRecordEditActions\"]//following-sibling::button[@title='Save']")).click();
		
		Thread.sleep(3000);
		
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		
		String profilename = Nameone.getText();
		
		System.out.println(profilename);
		
		String Expected = "Salesforce Automation by Rohith";

			if (profilename.contains(Expected))
					{
				System.out.println("Verfied");
			}
			else
			{
				System.out.println("Not Verifed");
			}
		driver.close();
	
	}
	}

