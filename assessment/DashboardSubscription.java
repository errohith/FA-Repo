package assessment;

import java.io.IOException;
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

	static ChromeOptions option;
	static ChromeDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	static int openAmt,ClosedAmt;
	static WebElement ddbutton;
	static String dashboardName="Rohith_Workout";
	static String description="Rohith testing";
	static String actualText;
	public static void main(String[] args) {
		
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		}catch (IOException e) {
			e.printStackTrace();
		}
			
			WebDriverManager.chromedriver().setup();

			
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			
			driver = new ChromeDriver(option);

			// Create JavascriptExecutor instance and assign driver object
			js = (JavascriptExecutor) driver;
			

			// Wait Setup
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Maximize window
			driver.manage().window().maximize();
				
			//1. Login to https://login.salesforce.com
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
			driver.findElement(By.id("Login")).click();
			
			//2. Click on toggle menu button from the left corner
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']")));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			
			//3. Click view All 
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			
			//4. Click Service Console from App Launcher
			driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Service Console']")).click();
			
			//5. Select Home from the DropDown
			CloseTab();
			if(!(driver.findElement(By.xpath("//div[contains(@class,'selectedListItem')]/a")).getText().equalsIgnoreCase("Home"))) {
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				ddbutton=driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Home']"));
				js.executeScript("arguments[0].scrollIntoView();", ddbutton);
				js.executeScript("arguments[0].click();", ddbutton);
			}
			
			//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='metricLabel' and text()='Closed']/following-sibling::span"), "$"));
			ClosedAmt=Integer.parseInt(driver.findElement(By.xpath("//span[@class='metricLabel' and text()='Closed']/following-sibling::span")).getText().split("\\$")[1]);
			openAmt=Integer.parseInt(driver.findElement(By.xpath("//span[@class='metricLabel' and contains(text(),'Open')]/following-sibling::span")).getText().split("\\$")[1]);
			if((openAmt+ClosedAmt)<10000) {
				driver.findElement(By.xpath("//button[@title='Edit Goal']")).click();
				driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).clear();
				driver.findElement(By.xpath("//span[@id='currencyCode']/following-sibling::input")).sendKeys("10000");
				driver.findElement(By.xpath("//span[contains(@class,'label bBody') and text()='Save']")).click();
			}
			
			//7. Select Dashboards from DropDown
			CloseTab();
			driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
			ddbutton=driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Dashboards']"));
			js.executeScript("arguments[0].scrollIntoView();", ddbutton);
			js.executeScript("arguments[0].click();", ddbutton);
			
			//8. Click on New Dashboard
			driver.findElement(By.xpath("//a[@title='New Dashboard']/div")).click();
			
			//9. Enter the Dashboard name as "YourName_Workout"
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys(dashboardName);
			
			//10. Enter Description as Testing and Click on Create
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).clear();
			driver.findElement(By.xpath("//input[@id='dashboardDescriptionInput']")).sendKeys(description);
			driver.findElement(By.id("submitBtn")).click();
			driver.switchTo().defaultContent();
			
			  try { 
				  Thread.sleep(5000); 
				  } catch (InterruptedException e) {
			  e.printStackTrace(); 
			  }
			 
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Done']")));
			driver.findElement(By.xpath("//button[text()='Done']")).click();
			driver.switchTo().defaultContent();
			
			//12. Verify the Dashboard is Created
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			actualText=driver.findElement(By.xpath("//h1/span[text()='Dashboard']/following-sibling::span")).getText();
			Assert.assertEquals(actualText, dashboardName);
			
			//13. Click on Subscribe
			driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
			driver.switchTo().defaultContent();
			
			//14. Select Frequency as "Daily"
			driver.findElement(By.xpath("//input[@id='daily']/following-sibling::span")).click();
			
			//15. Time as 10:00 AM
			WebElement dropdown=driver.findElement(By.xpath("//select[contains(@class,'select')]"));
			Select options=new Select(dropdown);
			options.selectByValue("10");
			
			//16. Click on Save
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			
			//17. Verify "You started Dashboard Subscription" message displayed or not
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'You')]")));
			actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'You')]")).getText();
			Assert.assertEquals(actualText,"You started a dashboard subscription.");
			
			//18. Close the "YourName_Workout" tab
			CloseTab();
			
			//19. Click on Private Dashboards
			driver.findElement(By.xpath("//div[@class='folderSidebar']//a[@title='Private Dashboards']")).click();
			
			//20. Verify the newly created Dashboard available
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search private')]")).sendKeys(dashboardName);
			Assert.assertEquals(driver.findElement(By.xpath("//table[@role='grid']/tbody//th//span[@class='highlightSearchText']")).getText(), dashboardName);
			
			//21. Click on dropdown for the item
			WebElement tableElement = driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/th//a[contains(@title,'"+dashboardName+"')]"));
			wait.until(ExpectedConditions.elementToBeClickable(tableElement));
			List<WebElement> tdElements = driver.findElements(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td"));
			driver.findElement(By.xpath("//table[contains(@class,'slds-table_edit')]/tbody/tr[1]/td["+(tdElements.size())+"]//button")).click();
			
			//22. Select Delete
			driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Delete']")).click();
			
			//23. Confirm the Delete
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Dashboard')]")));
			actualText=driver.findElement(By.xpath("//span[contains(@class,'toastMessage') and contains(text(),'Dashboard')]")).getText();
			Assert.assertEquals(actualText,"Dashboard was deleted.");
			
			//24. Verify the item is not available under Private Dashboard folder
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search private')]")).clear();
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search private')]")).sendKeys(dashboardName);
			actualText=driver.findElement(By.xpath("//span[@class='emptyMessageTitle']")).getText();
			Assert.assertEquals(actualText,"No results found");

			driver.quit();
	}
	public static void CloseTab() {
		List<WebElement> listItem = driver.findElements(By.xpath("//ul[contains(@class,'tabBarItems slds-grid') and @role='presentation']/li[contains(@class,'oneConsoleTabItem')]//button[contains(@title,'Close')]"));
		if(listItem.size()>0) {
			for (WebElement item : listItem) {
				item.click();	
			}
		}
	}

}
