package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='cart_contents_container']//div[3]//div[2]//div[2]//button[1]")
    public WebElement removeFirst;

    @FindBy(xpath = "//div[4]//div[2]//div[2]//button[1]")
    public WebElement removeSecond;

    @FindBy(xpath = "//div[5]//div[2]//div[2]//button[1]")
    public WebElement removeThird;

    @FindBy(xpath = "//a[@class='btn_secondary']")
    public WebElement continueShopping;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    public WebElement checkout;

    @FindBy(xpath = "//div[@class='cart_item']/div/a/div")
    public List<WebElement> itemNames;

    @FindBy(xpath = "//div[@class='subheader']")
    public WebElement shoppinfCartText;
}
