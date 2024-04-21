package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue= "stepdefinations",
		monochrome= true,
		dryRun = true
		)
public class TestNGrunner extends AbstractTestNGCucumberTests {

}
