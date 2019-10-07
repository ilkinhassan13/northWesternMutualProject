package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {



    WebDriver driver;

    public HomePage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className ="product_sort_container")
    public WebElement sortSelect;

    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    public WebElement itemFirst;

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    public WebElement itemSecond;

    @FindBy(xpath = "//div[3]//div[3]//button[1]")
    public WebElement itemThird;


    @FindBy(xpath= "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    public WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    public WebElement anotherItem;

    @FindBy(xpath = "//div[@class='pricebar']/div")
    public List< WebElement> listOfPrices;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public  List <WebElement> listOfItems;

    @FindBy(xpath ="//div[@class='product_label']")
    public WebElement productsText;

    @FindBy(xpath ="(//div[@class='inventory_item_name'])[1]")
    public WebElement anotherItemText;

}
