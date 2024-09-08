package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features = "src/test/resources/features", // path to your feature files
            glue = "stepDefinitions"
    )
    public class TestRunner extends AbstractTestNGCucumberTests {

    }

