package runner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/Features", // path to your feature files
            glue = "stepDefinitions"// package where your step definitions are locat
    )
    public class TestRunner {
        // This class is used as a holder for the above annotations
    }


