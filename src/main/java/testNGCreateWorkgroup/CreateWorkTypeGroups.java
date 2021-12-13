package testNGCreateWorkgroup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class CreateWorkTypeGroups extends BaseClass {
	
	@BeforeClass(alwaysRun = true)
	public void setdata() {
		FileName = "CreateWork";
	}
	@Test(dataProvider = "getData" , /*invocationCount = 2*/ enabled = true, alwaysRun = true, groups = "Smoke")
	public void CreateWorkType(String workgroup, String Name, String Verify) throws InterruptedException {

		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(Name);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		Thread.sleep(3000);
		
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		
		String profilename = Nameone.getText();
		
		System.out.println(profilename);
		
		Assert.assertEquals(profilename,Verify);	
		
		}
			
	}

