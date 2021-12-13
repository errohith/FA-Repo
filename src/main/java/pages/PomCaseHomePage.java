package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

public class PomCaseHomePage extends BaseClass {
	
	public PomCaseHomePage HomePageAction() {

		getDriver().findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		return this;
	}

	public PomCaseHomePage ViewAllButton() {

		getDriver().findElement(By.xpath("//button[text() = 'View All']")).click();
		return this;
	}

	public PomCaseHomePage EnterWorkgroupName(String workgroup) throws InterruptedException {
		getDriver().findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		return this;
	}

	public PomCaseHomePage ClickWorkgroupName() throws InterruptedException {
		getDriver().findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
			Thread.sleep(3000);
			return this;
			}

	public PomCaseHomePage ClickCase() throws InterruptedException {
		WebElement element = getDriver().findElement(By.xpath("//span[text()='More']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		return this;
		}
			
	public PomCreateScreen GotoCreateCase() throws InterruptedException {
		
		
		WebElement element1 = getDriver().findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		
		return new PomCreateScreen();
	}

}
