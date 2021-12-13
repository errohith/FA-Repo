package pages;

import org.openqa.selenium.By;

import baseClass.BaseClass;

public class PomDeleteScreen extends BaseClass {

	public PomDeleteScreen ClickDelete() throws InterruptedException {
		getDriver().findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(1000);
		return this;
	}
		
	public PomVerifyScreen DeleteButton() throws InterruptedException {
		getDriver().findElement(By.xpath("//Span[text()='Delete']")).click();
		Thread.sleep(3000);
		return new PomVerifyScreen();
		
		}

}
