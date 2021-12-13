package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;

public class PomVerifyScreen extends BaseClass {
	
	public PomVerifyScreen Verify(String Verify) throws InterruptedException {

		WebElement VerifyName = getDriver().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));

		String profilename = VerifyName.getText();

		System.out.println(profilename);

		if (profilename.contains(Verify)) {
			System.out.println("Verfied");
		} else {
			System.out.println("Not Verifed");
		}

		Thread.sleep(2000);
		return this;
	}

}
