package stepDefinition;

import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjectClasses.HomePage;

import java.util.List;

public class HomePageSortItemsSteps {

    HomePage homePage = new HomePage();

    @Given("User is on Saucedemo Mainpage")
    public void user_is_on_Saucedemo_Mainpage() {
        Assert.assertTrue(homePage.productsText.getText().equals("Products"));

    }

    @When("User sort the item from low to high price")
    public void user_sort_the_item_from_low_to_high_price() {
        Select select = new Select( homePage.sortSelect);
        select.selectByValue("lohi");

    }

    @Then("User should be able to see Products in the sorted order")
    public void user_should_be_able_to_see_Products_in_the_sorted_order() {

        List <WebElement> lists = homePage.listOfPrices;

        for(int i =0; i<lists.size()-1; i++){

            Assert.assertTrue("Sort funtionality did not pass", ( Double.parseDouble(lists.get(i).getText().substring(1))<=Double.parseDouble(lists.get(i+1).getText().substring(1))));
        }



    }
}
