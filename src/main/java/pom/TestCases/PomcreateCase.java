package pom.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.PomCaseHomePage;

public class PomcreateCase extends BaseClass {
	@BeforeClass
	public void setdata() {
		FileName = "CreateCase";
	}

	@Test(dataProvider = "getData")
	public void creatCase(String workgroup, String SearchText,String Disc,String Verify, String StatusDropDown, String OrginDropDown) throws InterruptedException {
		PomCaseHomePage Home = new PomCaseHomePage();
		Home.HomePageAction()
		.ViewAllButton()
		.EnterWorkgroupName(workgroup)
		.ClickWorkgroupName()
		.ClickCase()
		.GotoCreateCase()
		.ClickNewButton()
		.SearchKey(SearchText)
		.ClickSearchValue()
		.SelectStatusDropDown()
		.SelectValueInStatusDropDown(StatusDropDown)
		.SelectCaseOrgineDropDown()
		.SelectValueInCaseOrgine(OrginDropDown)
		.EnterDec(Disc)
		.ClickSave()
		.Verify(Verify);
		}
}
