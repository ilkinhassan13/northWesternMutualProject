package stepDefinition;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

   // @Before(order = 1)              // will run before each scenario
    @Before
    public void setup1(){
        System.out.println("This is hooks setup method");
    }

    //@Before(order = 2)
    public void setup2(){
        System.out.println("This is Hooks setup for google");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Hooks clean up");
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.callDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        Driver.quitDriver();
    }


}
