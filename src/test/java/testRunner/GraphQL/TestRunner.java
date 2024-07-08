package testRunner.GraphQL;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features   = "src/test/java/features/GraphQL",
        glue       = "stepDefinitions/GraphQL",
        tags       = "@regression",
        plugin     = {"pretty", "html:src/test/resources/reports/GraphQL-cucumber-report.html"},
        monochrome = true
)

public class TestRunner {
    // This class will run all the GraphQL feature files in the features folder with tag regression and generate a report
}