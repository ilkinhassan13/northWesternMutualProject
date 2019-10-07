package runnerPackage;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberreports", "json:target/report.json"},
        features = "/Users/ilkinhasanov/spr/src/test/resources",
        glue = "stepDefinition",
        tags = "@sauceDemo",
        dryRun = false




)
public class RunnerClass {

}