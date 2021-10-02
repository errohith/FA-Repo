package weekTwo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdministratorCertifications {

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
	}

}
