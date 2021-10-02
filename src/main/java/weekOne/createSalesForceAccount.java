package weekOne;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createSalesForceAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Initialize Driver 
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
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		WebElement element = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
//		driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Date todaydate = new Date();
		SimpleDateFormat formatt = new SimpleDateFormat("m/dd/yyyy");
		String today = formatt.format(todaydate);		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys(today);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Rohith");
			
		driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div//input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@title=\"Needs Analysis\"]")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		driver.findElement(By.xpath("//input[@placeholder=\"Search this list...\"]")).sendKeys("Salesforce Automation by Rohith");
		
		Thread.sleep(3000);
		
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
//		WebElement Nameone = driver.findElement(By.xpath("//slot[@name='primaryField']"));
		
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

	}
	
	}
