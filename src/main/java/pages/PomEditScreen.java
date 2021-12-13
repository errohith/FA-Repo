package pages;

import org.openqa.selenium.By;

import baseClass.BaseClass;

public class PomEditScreen extends BaseClass {

	public PomEditScreen SearchCase(String SearchCase) throws InterruptedException {

		getDriver().findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(SearchCase);
		Thread.sleep(3000);
		return this;
	}
	
	public PomEditScreen ToolTipClick() throws InterruptedException {

		getDriver().findElement(By.xpath("//div[@role='tooltip']")).click();
		Thread.sleep(3000);
		return this;
	}
	public PomEditScreen ClickEdit() throws InterruptedException {
		getDriver().findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(1000);
		return this;
	}
		
		public PomEditScreen SelectPriorityDropDown() throws InterruptedException {

			getDriver().findElement(By.xpath("//label[text()='Status']//following::div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']")).click();

			Thread.sleep(2000);
			return this;
		}
		
		public PomEditScreen SelectValueInPriorityDropDown(String PriorityDropDown) throws InterruptedException {

			getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+ PriorityDropDown +"']")).click();

			Thread.sleep(2000);
			return this;
		}
	}

