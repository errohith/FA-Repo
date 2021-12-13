package pages;

import org.openqa.selenium.By;
import baseClass.BaseClass;

public class PomCreateScreen extends BaseClass {
	
	
	public PomCreateScreen ClickNewButton() throws InterruptedException {

		getDriver().findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen SearchKey(String SearchText) throws InterruptedException {

		getDriver().findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']//input[@placeholder='Search Contacts...']")).sendKeys(SearchText);// Excel
		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen ClickSearchValue() throws InterruptedException {

		getDriver().findElement(By.xpath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")).click();

		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen SelectStatusDropDown() throws InterruptedException {

		getDriver().findElement(By.xpath("//label[text()='Status']//following::div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']")).click();

		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen SelectValueInStatusDropDown(String StatusDropDown) throws InterruptedException {

		getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+ StatusDropDown +"']")).click();

		Thread.sleep(2000);
		return this;
	}

	public PomCreateScreen SelectCaseOrgineDropDown() throws InterruptedException {

		getDriver().findElement(By.xpath("(//span[text()='Case Origin']//following::a[@class='select'])[1]")).click();

		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen SelectValueInCaseOrgine(String OrginDropDown) throws InterruptedException {

		getDriver().findElement(By.xpath("//a[text()='"+OrginDropDown+"']")).click();

		Thread.sleep(2000);
		return this;
	}
	
	public PomCreateScreen EnterDec(String Disc) throws InterruptedException {

		getDriver().findElement(By.xpath("(//textarea[@class=' textarea'])[1]")).sendKeys(Disc);// Excel

		Thread.sleep(1000);
		return this;
	}
	
	public PomVerifyScreen ClickSave() throws InterruptedException {

		getDriver().findElement(By.xpath("//button[@title='Save']")).click();

		Thread.sleep(1000);
		return new PomVerifyScreen();
	}
}
