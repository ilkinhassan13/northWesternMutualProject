package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjectClasses.HomePage;
import pageObjectClasses.ShoppingCartPage;

public class ShoppingCartSteps2 {


    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    HomePage homePage = new HomePage();

    @Given("User on cart page")
    public void user_on_cart_page() {
        Assert.assertTrue(shoppingCartPage.shoppinfCartText.getText().equals("Your Cart"));



    }

    @When("User removes all items from the cart")
    public void user_removes_all_items_from_the_cart() {
        shoppingCartPage.removeFirst.click();
        shoppingCartPage.removeSecond.click();
        shoppingCartPage.removeThird.click();


    }

    @When("User clicks on continue shopping")
    public void user_clicks_on_continue_shopping() {
        shoppingCartPage.continueShopping.click();

    }

    @Then("User should appear on a main page")
    public void user_should_appear_on_a_main_page() {


        Assert.assertTrue(homePage.productsText.getText().equals("Products"));

    }


}
