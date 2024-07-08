package testRunner.REST;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features   = "src/test/java/features/REST",
        glue       = "stepDefinitions/REST",
        tags       = "@regression",
        plugin     = {"pretty", "html:src/test/resources/reports/REST-cucumber-report.html"},
        monochrome = true
)

public class TestRunner {
    // This class will run all the REST feature files in the features folder with tag regression and generate a report
}