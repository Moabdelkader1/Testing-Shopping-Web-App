package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
            features = "src/test/resources/features", // path to your feature files
            glue = "stepDefinitions",
            plugin = {
                    "pretty",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", // Allure plugin
                    "html:target/cucumber-reports.html",
                    "json:target/cucumber-reports/cucumber.json"
            }
    )
    public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }


