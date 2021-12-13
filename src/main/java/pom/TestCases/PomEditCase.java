package pom.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.PomCaseHomePage;
import pages.PomEditScreen;

public class PomEditCase extends BaseClass {
	
	@BeforeClass
	public void setdata() {
		FileName = "CreateCase";
	}

	@Test(dataProvider = "getData")
	public void creatCase(String PriorityDropDown, String SearchCase, String workgroup, String SearchText,String Disc,String Verify,String StatusDropDown, String OrginDropDown) throws InterruptedException {
		PomCaseHomePage Home = new PomCaseHomePage();
		PomEditScreen  Edit = new PomEditScreen();
		Home .HomePageAction()
		.ViewAllButton()
		.EnterWorkgroupName(workgroup)
		.ClickWorkgroupName()
		.ClickCase()
		.GotoCreateCase();
		Edit.SearchCase(SearchCase)
		.ToolTipClick()
		.ClickEdit()
		.SelectPriorityDropDown()
		.SelectValueInPriorityDropDown(PriorityDropDown);
	}
}
