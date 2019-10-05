package performanceTesting;

import Utilities.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import models.MyBody;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.function.Function;

import static io.restassured.RestAssured.given;

public class PerformanceTesting {
    @Before

    public void waitM(){
        RestAssuredConfig newConfig = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000)
                        .setParam(CoreConnectionPNames.SO_TIMEOUT, 1000));


    }



    @Test
    public void getMethod(){


        String expectedBody= "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";
        String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        int expectedId = 1;
        int expectedUserId = 1;
        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
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



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}