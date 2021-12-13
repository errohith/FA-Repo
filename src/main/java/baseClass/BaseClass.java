package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import readExcel.ExcelRead;

public class BaseClass {

//	public WebDriver driver;
//	public ChromeDriver driver;
	public String FileName ;
	public WebDriverWait wait;

	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	@Parameters({"url","UserName","PassWord","Browser"})
	@BeforeMethod(alwaysRun = true)
	public void precondition(@Optional("https://login.salesforce.com/")String url, @Optional("fullstack@testleaf.com")String Uname, @Optional("SelBootcamp$123")String PWD, @Optional("Chrome")String BrowserName) throws InterruptedException {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options =  new ChromeOptions();
			//Disable Notifications  
			options.addArguments("--disable-notifications");
			driver.set(new ChromeDriver(options));
//			driver = new ChromeDriver(options);
			
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			option.addPreference("dom.push.enabled", false);
			// Create Firefox Driver Object
			driver.set(new FirefoxDriver(option));
//			driver = new FirefoxDriver(option);
		}
		else if(BrowserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
				
		//Launch Browser 
		getDriver().get(url);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login 
		getDriver().findElement(By.id("username")).sendKeys(Uname);
		getDriver().findElement(By.id("password")).sendKeys(PWD);
		getDriver().findElement(By.id("Login")).click();

	}


	@DataProvider(name = "getData")
	public String[][] sendData() throws IOException{
		return ExcelRead.readExcel(FileName);
	}
	
	@AfterMethod(alwaysRun = true)
	public void postcondition() {

		getDriver().close();

	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
}



