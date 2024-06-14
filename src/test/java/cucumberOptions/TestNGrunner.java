package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//		features = "src/Test/java/features/",   // Run all feature files
//		features = "src/Test/java/features/customer.feature",   // Run only single feature file
		features = {"src/Test/java/features/customer.feature"}, //"src/Test/java/features//scenario_1.feature"},   //Run only specific feature files
		glue= "stepdefinations",
		monochrome= true,
		/*tags = // "@sanity", // only under sanity tag scenario will execute
		       // "@sanity and not @regression",  // only execute under @sanity
			    "@sanity or @regression",      // either @sanity or @regression will run
			   //"@sanity and @regression",     // run only @sanity @regression tags(those have both tags)*/
		dryRun = false,
		plugin={"pretty","html:target/practies.html"//,"json:target/pacties.json","rerun:target/practiesFaild.txt"
				}
		)
public class TestNGrunner extends AbstractTestNGCucumberTests {

}
