package ApiShorts;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.*;

public class PathAndQueryParam {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void pathParamTest1() {
        Response response = given().accept(ContentType.JSON).pathParam("id", 500)
                .when().get("/api/spartans/{id}");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),404);
        assertTrue(response.body().asString().contains("Not Found"));

    }
    @Test
    public void QueryParam1() {
        Response response = given().accept(ContentType.JSON).queryParam("gender","Female")
                .queryParam("nameContains","J")
                .when().get("/api/spartans/search");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Jaimie"));
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male"));


    }
    @Test
    public void QueryParam2() {

        Map<String,Object> paramsMap=new HashMap<>();
        paramsMap.put("gender","Famale");
        paramsMap.put("nameContains","J");


        Response response = given().accept(ContentType.JSON)
                .queryParams(paramsMap)
                .when().get("/api/spartans/search");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);
        assertTrue(response.body().asString().contains("Janette"));
        assertTrue(response.body().asString().contains("Female"));
        assertFalse(response.body().asString().contains("Male"));


    }

}
