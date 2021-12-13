package caseTestCase.withTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class EditCase extends BaseClass {
	@BeforeClass
	public void setdata() {
		FileName = "EditCase";
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
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[text()='Status']//following::div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Priority']//following::div[@class='uiMenu'])[1]")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Low']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Case Origin']//following::a[@class='select'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Phone']")).click();

		Thread.sleep(1000);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//span[text()='SLA Violation']//following::a[@class='select'])[7]"))));
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();

		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).click();	
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).clear();
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(SearchCase);
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[@role='tooltip']")).click();
//		Thread.sleep(3000);
		
		WebElement status = driver.findElement(By.xpath("//span[text()='Working']"));

		Thread.sleep(1000);
		
		String verifyStatus = status.getText();
		
		Assert.assertEquals(verifyStatus,Verify);
		
	}
}
