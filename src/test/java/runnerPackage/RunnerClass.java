package runnerPackage;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberreports", "json:target/report.json"},
        features = "/Users/ilkinhasanov/spr/src/test/resources/features",
        glue = "stepDefinition",
        tags = "@calculator",
        dryRun = false
)
public class RunnerClass {

}