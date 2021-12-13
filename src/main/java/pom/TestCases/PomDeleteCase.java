package pom.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.PomCaseHomePage;
import pages.PomDeleteScreen;
import pages.PomEditScreen;

public class PomDeleteCase extends BaseClass {
	
	@BeforeClass
	public void setdata() {
		FileName = "DeleteCase";
	}

	@Test(dataProvider = "getData")
	public void creatCase(String SearchCase, String workgroup,String Verify) throws InterruptedException {
		PomCaseHomePage Home = new PomCaseHomePage();
		PomEditScreen  Edit = new PomEditScreen();
		PomDeleteScreen  Delete = new PomDeleteScreen();
		Home.HomePageAction()
		.ViewAllButton()
		.EnterWorkgroupName(workgroup)
		.ClickWorkgroupName()
		.ClickCase()
		.GotoCreateCase();
		Edit.SearchCase(SearchCase)
		.ToolTipClick();
		Delete.ClickDelete()
		.DeleteButton()
		.Verify(Verify);
		}
}
