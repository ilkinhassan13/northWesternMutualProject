package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjectClasses.HomePage;
import pageObjectClasses.ShoppingCartPage;

public class AddingNewItemAndCheckingoutSteps {

    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @Given("User on a main page")
    public void user_on_a_main_page() {
        Assert.assertTrue(homePage.productsText.getText().equals("Products"));

    }

    @When("User adds an item and  clicks on add to cart")
    public void user_adds_an_item_and_clicks_on_add_to_cart() {
        homePage.anotherItem.click();

    }

    @When("User clicks on cart and User appears on cart page")
    public void user_clicks_on_cart_and_User_appears_on_cart_page() {
        homePage.shoppingCart.click();
        Assert.assertTrue(shoppingCartPage.shoppinfCartText.getText().equals("Your Cart"));
    }

    @Then("User click on checkout button")
    public void user_click_on_checkout_button() {
        shoppingCartPage.checkout.click();

    }

}
