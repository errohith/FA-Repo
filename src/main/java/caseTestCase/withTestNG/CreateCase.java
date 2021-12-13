package caseTestCase.withTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass1.BaseClass;

public class CreateCase extends BaseClass {
	@BeforeClass
	public void setdata() {
		FileName = "CreateCase";
	}

	@Test(dataProvider = "getData")
	public void CreateNewCase(String workgroup, String SearchText, String Disc, String Verify)
			throws InterruptedException {
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(workgroup);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[text()='More']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//a[@role='menuitem']//span[text()='Cases']"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@placeholder='Search Contacts...']")).sendKeys(SearchText);// Excel
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='Status']//following::div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Escalated']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[text()='Case Origin']//following::a[@class='select'])[1]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Email']")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//textarea[@class=' textarea'])[1]")).sendKeys(Disc);// Excel

		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@title='Save']")).click();

		Thread.sleep(1000);

		WebElement VerifyName = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));

		String profilename = VerifyName.getText();

		System.out.println(profilename);

		if (profilename.contains(Verify)) {
			System.out.println("Verfied");
		} else {
			System.out.println("Not Verifed");
		}

	}
}
