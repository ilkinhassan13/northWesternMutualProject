package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogINPage {

    WebDriver driver;

    public LogINPage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//input[@class='btn_action']")
    public WebElement submit;



}
