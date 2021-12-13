package testNGCreateWorkgroup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class DeleteWorkTypeGroups extends BaseClass {
	@BeforeClass
	public void setdata() {
		FileName = "DeleteCase";
	}
	@Test(dataProvider = "getData" /*, invocationCount = 10 enabled = true , dependsOnMethods = {"/FSClass/src/main/java/testNGClass/CreateWorkTypeGroups.java"}*/)
	public void deleteworktype(String workgroup, String Name, String Verify) throws InterruptedException {
		//Click toggle menu  
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Name);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='listviewSearchTooltip-110']")).click();
		driver.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//Span[text()='Delete']")).click();
		Thread.sleep(3000);
		WebElement Nameone = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String profilename = Nameone.getText();
		System.out.println(profilename);
//		String Expected = "Salesforce Automation by Gopi";

			if (profilename.contains(Verify))
					{
				System.out.println("Verfied");
			}
			else
			{
				System.out.println("Not Verifed");
			}
	
	
	}
	}

