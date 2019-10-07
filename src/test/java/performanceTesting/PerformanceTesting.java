package performanceTesting;

import Utilities.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.MyBody;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PerformanceTesting {
    @Before
    public void waitApi() throws InterruptedException {
        Thread.sleep(3000);
    }
     @Test
    public void firstGetRequest(){

       Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
       long millis=RestAssured.get(Config.getProperty("urlApi") + "/posts/1").time();

         System.out.println("Status code - " + response.statusCode());
         System.out.println("Running time for Get request - " + millis + " milliseconds" );
       Assert.assertTrue(15000>millis);
    }



    @Test()
    public void secondPostRequest(){
        String expectedBody= "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";
        String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        int expectedId = 1;
        int expectedUserId = 1;
        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
        long millis = RestAssured.get(Config.getProperty("urlApi") + "/posts/1").time();
        //System.out.println(response.asString());
        Assert.assertTrue(response.statusCode()==200);

        ObjectMapper mapper = new ObjectMapper();

        try {
            MyBody body = mapper.readValue(response.asString(), MyBody.class);

            String actualTitle=body.getTitle();
            String actualBody=body.getBody();
            int actualId=body.getId();
            int actualUserId=body.getUserId();
            Assert.assertTrue(actualBody.equals(expectedBody) && actualTitle.equals(expectedTitle)
                    && actualId == expectedId && actualUserId == expectedUserId);

            System.out.println("Status code - " + response.statusCode());



        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Running time for Post request - " + millis + " milliseconds" );
        Assert.assertTrue(15000>millis);


    }
    @Test
    public void thirdPutRequest(){


        MyBody myBody = new MyBody();

        myBody.setTitle("Teacher");
        myBody.setBody("James Bond");
        myBody.setUserId(3454543);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(myBody)
                .when().put(Config.getProperty("urlApi") +"/posts/1");

        long millis = RestAssured.given().contentType(ContentType.JSON).body(myBody)
                .when().put(Config.getProperty("urlApi") +"/posts/1").time();


        System.out.println("Status code - " + response.statusCode());

        System.out.println("Running time for Put request - " + millis + " milliseconds" );
        Assert.assertTrue(15000>millis);

    }
    @Test
    public void wFourthDeleteRequest(){
        Response response = RestAssured.delete(Config.getProperty("urlApi") +"/posts/1");
        long millis = RestAssured.delete(Config.getProperty("urlApi") +"/posts/1").time();

        System.out.println("Status code - " + response.statusCode());

        Assert.assertTrue(response.statusCode() == 200);

        System.out.println("Running time for Delete request - " + millis + " milliseconds" );
        Assert.assertTrue(15000>millis);
}

}