package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features/placeValidations.feature",
		glue = "StepDefinations",stepNotifications = true,
		plugin = {"pretty","html:target/cucumber.html","json:target/jsonReports/cucumber.json","junit:target/cucumber.xml"})

public class TestRunner {
//,tags = "@DeletPlace"
}
