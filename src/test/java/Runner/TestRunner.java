package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "C:\\SynechronAssignment\\SynechronAssignment\\src\\test\\java\\Features\\amexuioperations.feature", 
		glue = {"StepDefinitions"}, 
		dryRun = false, 
		plugin = {"html:target/cucumber-report.html"}
		)

public class TestRunner {

}
