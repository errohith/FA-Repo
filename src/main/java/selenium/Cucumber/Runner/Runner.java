package selenium.Cucumber.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\ROHITH\\Desktop\\Full Stack Automation\\FS Workspace\\FSClass\\src\\main\\java\\selenium\\Cucumber\\features\\Login.feature",
				glue = "selenium\\Cucumber\\stepDefinition")
public class Runner extends AbstractTestNGCucumberTests {

}
