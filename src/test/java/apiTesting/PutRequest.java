package apiTesting;

import Utilities.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.MyBody;
import org.junit.Test;

public class PutRequest {



    @Test

    public void updateBody (){

        MyBody myBody = new MyBody();

        myBody.setTitle("Teacher");
        myBody.setBody("James Bond");
        myBody.setUserId(3454543);

        Response response = RestAssured.given().contentType(ContentType.JSON).body(myBody)
                .when().put(Config.getProperty("urlApi") +"/posts/1");

        System.out.println(response.statusCode());
        System.out.println(response.asString());


    }

}

