package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stepDefinitions.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		glue = "stepDefinitions", 
		plugin = { "pretty",
		"json:target/cucumber-report.json", // JSON Report
		"html:target/cucumber-html-report/index.html" // HTML Report
},
		monochrome = true // Makes console output more readable

)
public class TestRunner {
	@AfterClass
	public static void closeBrowser() {
		Hooks.closeBrowser(); // Closes WebDriver at the end of all scenarios
	}
}
