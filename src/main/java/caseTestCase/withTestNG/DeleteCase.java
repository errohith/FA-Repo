package caseTestCase.withTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class DeleteCase extends BaseClass {
	@BeforeClass
	public void setdata() {
		FileName = "DeleteCase";
	}	
	@Test(dataProvider = "getData")
	public void CreateNewCase(String workgroup,String SearchCase, String Verify) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//span[text()='More']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		WebElement element1= driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(SearchCase);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='tooltip']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//Span[text()='Delete']")).click();
		Thread.sleep(3000);
		
		WebElement status = driver.findElement(By.xpath("//span[text()='No items to display.']"));//Excel

		Thread.sleep(1000);
		
		String verifyStatus = status.getText();
		
		Assert.assertEquals(verifyStatus,Verify);
		
		
	}
}
