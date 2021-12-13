package weekTwo;

import org.testng.annotations.Test;
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

import io.github.bonigarcia.wdm.WebDriverManager;
@Test 
public class ReleasePDFdown {
	   
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[text()='Download SalesforceA']")).click();
		WebElement AppStore = driver.findElement(By.xpath("//span[text()=': Release Notes']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(AppStore).pause(3000).click(AppStore).perform();
		Thread.sleep(5000);
		Set<String> String1 = driver.getWindowHandles();
		List<String> list = new ArrayList<>(String1);
		list.addAll(list);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//input[@aria-haspopup='listbox']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-item-id='input-30-4']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@title='Open PDF']")).click();
		Set<String> String2 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<>(String2);
		list.addAll(list1);
		driver.switchTo().window(list.get(1));
		driver.close();
	}
		
}




		