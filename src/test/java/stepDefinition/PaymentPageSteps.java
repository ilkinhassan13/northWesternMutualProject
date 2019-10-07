package stepDefinition;

import Utilities.Config;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectClasses.CheckoutInformationPage;
import pageObjectClasses.CheckoutOverviewPage;
import pageObjectClasses.HomePage;

public class PaymentPageSteps {


    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    HomePage homePage= new HomePage();

    @Given("User on Your Information page")
    public void user_on_Your_Information_page() {
        Assert.assertTrue(checkoutInformationPage.informationText.getText().equals("Checkout: Your Information"));

    }

    @When("User filles up all info and clicks on continue button")
    public void user_filles_up_all_info_and_clicks_on_continue_button() {
        checkoutInformationPage.checkOutFirstName.sendKeys(Config.getProperty("firstName"));
        checkoutInformationPage.checkOutLastName.sendKeys(Config.getProperty("lastName"));
        checkoutInformationPage.checkOutPostalCode.sendKeys(Config.getProperty("postalCode"));
        checkoutInformationPage.checkOutContinue.click();

    }

    @Then("Item name and total price should match with chosen item")
    public void item_name_and_total_price_should_match_with_chosen_item() {

       Assert.assertTrue(homePage.anotherItemText.getText().equals(checkoutOverviewPage.inventoryItemName.getText()));
       double itemprice = Double.parseDouble(checkoutOverviewPage.itemPriceText.getText().substring(1)); //29.99
       double result=(itemprice+ (itemprice*8.01)/100);
       String actual=String.valueOf(result).substring(0,5);
       Assert.assertEquals(actual, checkoutOverviewPage.totalPriceText.getText().substring(8));

    }

    @Then("User should be navigated to the new page with confirmation")
    public void user_should_be_navigated_to_the_new_page_with_confirmation() {
        checkoutOverviewPage.finishButton.click();
        Assert.assertTrue(checkoutOverviewPage.finalText.getText().equals("THANK YOU FOR YOUR ORDER"));


    }

}
