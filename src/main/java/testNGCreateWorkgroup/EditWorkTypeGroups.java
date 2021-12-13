package testNGCreateWorkgroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class EditWorkTypeGroups extends BaseClass {
	@BeforeClass(alwaysRun = true)
	public void setdata() {
		FileName = "EditWork";
	}
	@Test(dataProvider = "getData" , /*invocationCount = 2 enabled = true, dependsOnMethods = {"testNGClass.CreateWorkTypeGroups.CreateWorkType"}, */ dependsOnGroups = "Smoke", groups = "Sanity")
	public void eidtWorkType(String workgroup, String Name, String Description , String Verify) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='tooltip']")).click();
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following-sibling::textarea")).sendKeys(Description);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2[contains(@class,'Title')]/following-sibling::div//span[text()='Group Type']/parent::span/following-sibling::div//a")).click();
		driver.findElement(By.xpath("//a[text()='Capacity']")).click();
		driver.findElement(By.xpath("//div[@class=\"button-container slds-text-align_right forceRecordEditActions\"]//following-sibling::button[@title='Save']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		
		String profilename = Nameone.getText();
		
		System.out.println(profilename);
		
		Assert.assertEquals(profilename,Verify);
	
	}
	}

