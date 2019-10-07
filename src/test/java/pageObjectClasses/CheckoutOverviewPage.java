package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {


    WebDriver driver;

    public CheckoutOverviewPage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public WebElement inventoryItemName;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    public WebElement finishButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public WebElement itemPriceText;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    public  WebElement totalPriceText;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement finalText;


}
