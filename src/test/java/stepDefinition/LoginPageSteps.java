package stepDefinition;

import Utilities.Config;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import pageObjectClasses.HomePage;
import pageObjectClasses.LogINPage;

public class LoginPageSteps {

    LogINPage logINPage = new LogINPage();
    HomePage homePage = new HomePage();




    @Given("User is on Saucedemo LoginPage")
    public void user_is_on_Saucedemo_LoginPage() {
        Driver.callDriver().get(Config.getProperty("urlUI"));

    }

    @When("User types {string} in the username field")
    public void user_types_in_the_username_field(String string) {
        logINPage.userName.sendKeys(Config.getProperty("usernameUI"));

    }

    @When("User types {string} on the password field")
    public void user_types_on_the_password_field(String string) {
        logINPage.password.sendKeys(Config.getProperty("passwordUI"));
    }

    @When("User click the Login button")
    public void user_click_the_Login_button() {
        logINPage.submit.click();

    }

    @Then("User should be able to see Products on main page of SauceDemo")
    public void user_should_be_able_to_see_Products_on_main_page_of_SauceDemo() {

        Assert.assertTrue(homePage.productsText.getText().equals("Products"));


    }



}
