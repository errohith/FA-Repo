package selenium.Cucumber.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass{
	
	public ChromeDriver driver;
	public ChromeOptions option = new ChromeOptions();
	public JavascriptExecutor js;
	public WebDriverWait wait;
	
	@Given("Launch the Browser")
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		option.addArguments("--disable-notifications");
		driver= new ChromeDriver(option);
		js = (JavascriptExecutor) driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Given("Launch the Salesforce application with URL {string}")
	public void LaunchURL(String url) {
		driver.get(url);
	}
	@When("Enter the {string} and {string}")
	public void enterUsernameAndPassword(String uName,String Password) {
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("Login")));
		driver.findElement(By.id("Login")).click();
	}
	@Then("Salesforce Home page should be opened successfully")
	public void verifHomePageTitle() {
		wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		Assert.assertEquals(driver.getTitle(),"Home | Salesforce");
	}
	@And("Close the Browser")
	public void closeBrowser() {
		driver.quit();

	}
}
