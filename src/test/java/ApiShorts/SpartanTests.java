package ApiShorts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

//spartan_api_url

public class SpartanTests {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";


    }

    @Test
    public void viewSpartanTest1() {
        Response response = RestAssured.get("/api/spartans");
       assertEquals(response.getStatusCode(), 200);
      assertTrue(response.body().asString().contains("Ozg"));
      assertEquals(response.contentType(), "application/json");


        //RestAssured.given().accept(ContentType.JSON);


    }

    @Test
    public void viewSpartanTest2() {
        Response response = RestAssured.given().accept(ContentType.JSON).pathParam("id", 18)
                .when().get("/api/spartans/{id}");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Allen"));

    }

}
