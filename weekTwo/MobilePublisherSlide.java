package weekTwo;

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

public class MobilePublisherSlide {

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
		Thread.sleep(1000);
		//Click Mobile Publisher menu  
		WebElement LearnMore = driver.findElement(By.xpath("//button[@title='Learn More']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(LearnMore).pause(3000).click(LearnMore).perform();
		Thread.sleep(5000);
		Set<String> String1 = driver.getWindowHandles();
		List<String> list = new ArrayList<>(String1);
		list.addAll(list);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
//		WebElement element = driver.findElement(By.xpath("//button[contains(@class,'child-menu')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement search = (WebElement) executor.executeScript("document.querySelector('#c360-hgf-nav').shadowRoot.querySelector('header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button')");
//		executor.executeScript("arguments[0].click();", element);
		String Test = (String) executor.executeScript("arguments[0].getAttribute();", search);
		System.out.println(Test);
		
		driver.close();
	

	}

}
