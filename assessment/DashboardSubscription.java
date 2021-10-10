package assessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardSubscription {
	
	static JavascriptExecutor js;
	static WebDriverWait wait;
	static String dashboardName="Rohith_WorkOut";
	static String actualText;
	static String resultText;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =  new ChromeOptions();
		//Disable Notifications  
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//Launch Browser 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login 
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		//Click toggle menu  
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales Console");
		driver.findElement(By.xpath("//p[@title='(Lightning Experience) Lets sales reps work with multiple records on one screen']")).click();
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		WebElement Closed = driver.findElement(By.xpath("//span[text()='Closed']/following-sibling::span[@data-aura-class='uiOutputText']"));
		String value1 =Closed.getText();
		int Convert = Integer.parseInt(value1);
		System.out.println(Convert);
		WebElement Opened = driver.findElement(By.xpath("//span[text()='Open (>70%)']/following-sibling::span[@data-aura-class='uiOutputText']"));
		String value2 = Opened.getText();
		System.out.println(value2);
		int Convert2 = Integer.parseInt(value2);
		int add = Convert + Convert2; 
		if (add < 10000)
		{
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-m-left--x-small editGoal slds-button_icon-bare homeGoalSetting']")).click();
			driver.findElement(By.xpath("//input[@aria-describedby='currencyCode']")).sendKeys("10000");
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']")).click();
			WebElement closeWindo = driver.findElement(By.xpath("//button[@title='Close this window']"));
			closeWindo.click();
			driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
			driver.findElement(By.xpath("//span[text()='Dashboards']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
			Thread.sleep(1000);
			WebElement FrameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
			driver.switchTo().frame(FrameEle);
			WebElement Dname = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
			Dname.sendKeys("Rohith_Workout");
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys("Workout Created"); 
			driver.findElement(By.id("submitBtn")).click();
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//button[text()='Done']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);			
			driver.findElement(By.xpath("//button[text()='Subscribe']")).click();			
			driver.findElement(By.xpath("//span[text()='Daily']")).click();			
			WebElement Source = driver.findElement(By.xpath("//select[@id='time']"));
			Select Drop1 = new Select(Source);
			Drop1.selectByValue("10:00 AM");
			driver.findElement(By.xpath("//button[@title='Save']")).click();			
			WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
			
			String profilename = Nameone.getText();			
			System.out.println(profilename);			
			String Expected = "You started a dashboard subscription.";
				if (profilename.contains(Expected))
						{
					System.out.println("Verfied");
				}
				else
				{
					System.out.println("Not Verifed");
				}
				
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']")).click();
			driver.findElement(By.xpath("(//a[@class=\"slds-nav-vertical__action\"])[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@class=\"search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input\"]")).sendKeys("Rohith_Workout");
			Thread.sleep(2000);
			WebElement tableElement = driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/th//a[contains(@title,'"+dashboardName+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(tableElement));
			List<WebElement> tdElements = driver.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td"));
			driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td["+(tdElements.size())+"]//button")).click();
			driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Delete']")).click();
					
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
							
			Assert.assertEquals(actualText,"Dashboard was deleted.");
			
				
			resultText=driver.findElement(By.xpath("//span[@class='emptyMessageTitle']")).getText();
			Assert.assertEquals(resultText,"No results found");
			}
							
			
		}
		
		
	}


