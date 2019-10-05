package apiTesting;

import Utilities.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class DeleteRequest {


    @Test

    public  void deleteBody(){

        Response response = RestAssured.delete(Config.getProperty("urlApi") +"/posts/1");
        System.out.println(response.statusCode());

        Assert.assertTrue(response.statusCode() == 200);
    }
    }

