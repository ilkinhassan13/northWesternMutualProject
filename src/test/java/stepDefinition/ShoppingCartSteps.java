package stepDefinition;

import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectClasses.HomePage;
import pageObjectClasses.ShoppingCartPage;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSteps {

    HomePage homePage = new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @When("User adds the items to the cart")
    public void user_adds_the_items_to_the_cart() throws Exception{

        homePage.itemFirst.click();
       WebDriverWait wait1 = new WebDriverWait(Driver.callDriver(), 10);
       wait1.until(ExpectedConditions.visibilityOf(homePage.itemSecond));
        homePage.itemSecond.click();
        WebDriverWait wait2 = new WebDriverWait(Driver.callDriver(), 10);
        wait2.until(ExpectedConditions.visibilityOf(homePage.itemThird));
        homePage.itemThird.click();
        WebDriverWait wait3 = new WebDriverWait(Driver.callDriver(), 10);
        wait3.until(ExpectedConditions.visibilityOf(homePage.shoppingCart));
        homePage.shoppingCart.click();

    }

    @Then("User should be able to see all the added items on the cart")
    public void user_should_be_able_to_see_all_the_added_items_on_the_cart() {

        List<WebElement> lists = shoppingCartPage.itemNames;

        for(int i =0 ; i<lists.size()-1 ; i++){
            Assert.assertEquals(homePage.listOfItems.get(i).getText(),(lists.get(i).getText()));

        }

    }

}
