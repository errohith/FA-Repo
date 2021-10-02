package weekOne;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingWorkTypeGroup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options =  new ChromeOptions();
		//Disable Notifications  
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//Launch Browser 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login 
		driver.findElement(By.id("username")).sendKeys("fullstack@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		//Click toggle menu  
		driver.findElement(By.xpath("//div[@class ='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() = 'View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Work Type Groups");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		Thread.sleep(1000);
		
		List<WebElement> myList=driver.findElements(By.xpath("//a[@data-refid='recordId']"));

	    //myList contains all the web elements
	    //if you want to get all elements text into array list
	    List<String> all_elements_text=new ArrayList<>();

	    for(int i=0; i<myList.size(); i++){

	        //loading text of each element in to array all_elements_text
	        String Text;
			all_elements_text.add((Text = myList.get(i).getText()));
	        System.out.println(Text);
//	        System.out.println(myList.get(i).getText());

	    }
	    Collections.sort(all_elements_text);
	    
		WebElement element = driver.findElement(By.xpath("//span[text()='Work Type Group Name']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		List<WebElement> myList1=driver.findElements(By.xpath("//a[@data-refid='recordId']"));

	    //myList contains all the web elements
	    //if you want to get all elements text into array list
	    List<String> all_elements_text1=new ArrayList<>();

	    for(int i=0; i<myList1.size(); i++){

	        //loading text of each element in to array all_elements_text
	        String Text1;
			all_elements_text1.add((Text1 = myList1.get(i).getText()));
	        System.out.println(Text1);
//	        System.out.println(myList.get(i).getText());

	    }
	    
	    if (all_elements_text.equals(all_elements_text1))
	    {
	    	System.out.println("Sorted Ascending");
	    }
	    else
	    {
	    	System.out.println("Not Sorted Ascending");
	    }
		WebElement sortingField = driver.findElement(By.xpath("//span[text()='Sorted Ascending']"));
		String field = sortingField.getText();
		System.out.println(field);
		String Expected = "Sorted Ascending";

		if (field.contains(Expected))
				{
			System.out.println("Verfied");
		}
		else
		{
			System.out.println("Not Verifed");
		}
		
		driver.close();
	

	}

}
