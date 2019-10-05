package pageObjectClasses;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(){
        driver= Driver.callDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "calculate-mt")
    public WebElement meterButton;

    @FindBy(id = "wth-m1")
    public WebElement widthA;

    @FindBy(id = "len-m1")
    public WebElement lengthA;

    @FindBy(id = "wth-m2")
    public WebElement widthB;

    @FindBy(id = "len-m2")
    public WebElement lengthB;

    @FindBy(id = "SubmitAndCalculate")
    public WebElement calculate;

    @FindBy(id = "totarea-res")
    public WebElement totalArea;

    @FindBy(id = "totarea-res-10-perc")
    public WebElement wastage;

}
