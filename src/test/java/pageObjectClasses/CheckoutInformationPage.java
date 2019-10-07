package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {


    WebDriver driver;

    public CheckoutInformationPage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement checkOutFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement checkOutLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement checkOutPostalCode;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    public WebElement checkOutContinue;

    @FindBy(xpath = "//div[@class='subheader']")
    public WebElement informationText;

}
