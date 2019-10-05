package sauceDemo;


import Utilities.Config;
import Utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjectClasses.HomePage;

public class Calculator {
    String widthA="5";
    String widthB= "4";
    String lengthA= "3";
    String lengthB = "3";


   @Test
    public  void calculate()  {

         Driver.callDriver().get(Config.getProperty("url"));
        HomePage hp = new HomePage();
        JavascriptExecutor js = (JavascriptExecutor)Driver.callDriver();
        js.executeScript("window.scrollBy(0,1000);");

        hp.meterButton.click();
        hp.widthA.clear();
        hp.lengthA.clear();
        hp.widthB.clear();
        hp.lengthB.clear();
        hp.widthA.sendKeys(widthA);
        hp.lengthA.sendKeys(lengthA);
        hp.widthB.sendKeys(widthB);
        hp.lengthB.sendKeys(lengthB);
        hp.calculate.click();


        WebDriverWait wait = new WebDriverWait(Driver.callDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(hp.totalArea));

       double widthADouble = Double.parseDouble(widthA);
       double lengthADouble = Double.parseDouble(lengthA);
       double widthBDouble = Double.parseDouble(widthB);
       double lengthBDouble = Double.parseDouble(lengthB);
       double area1 = widthADouble * lengthADouble;
       double area2 = widthBDouble * lengthBDouble;

        double totalArea = area1+area2;
        double wastage = totalArea * 0.10 + totalArea;

        String totalAreaString =  hp.totalArea.getText().substring(0,2);
        String wastageString = hp.wastage.getText().substring(0,4);

        double expectedTotalArea = Double.parseDouble(totalAreaString);
        double expectedWastage = Double.parseDouble(wastageString);

        Assert.assertEquals(totalArea, expectedTotalArea);
        Assert.assertEquals(wastage, expectedWastage);




    }


}
