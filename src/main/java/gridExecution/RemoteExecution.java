package gridExecution;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteExecution {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\ROHITH\\Desktop\\Full Stack Automation\\FS Workspace\\FSClass\\drivers\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANY);
		dc.setBrowserName("chrome");
		ChromeOptions options =  new ChromeOptions();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub/"),dc);
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Salesforce Automation by Gopi");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		Thread.sleep(3000);
		
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		
		String profilename = Nameone.getText();
		
		System.out.println(profilename);
		
		String Expected = "Salesforce Automation by Gopi";

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

