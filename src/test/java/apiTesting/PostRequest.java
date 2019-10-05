package apiTesting;

import Utilities.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.MyBody;
import org.junit.Before;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class PostRequest {




    @Test

     public void getTest(){
        MyBody body=new MyBody();

        body.setTitle("Student");
        body.setBody("Ilkin");
        body.setUserId(3454543);




        Response response = given().contentType(ContentType.JSON).body(body).when().post(Config.getProperty("urlApi") +"/posts").
                then().assertThat().statusCode(201).and().contentType(ContentType.JSON).
                extract().response();


//        Response response = RestAssured.given().
//                contentType(ContentType.JSON).body(body).when().post(Config.getProperty("urlApi")+"/posts");
//
     System.out.println("STATUS CODE: "+response.statusCode());
      System.out.println(response.asString());

    }



//        System.out.println(response.statusCode());
//        System.out.println(response.asString());

}