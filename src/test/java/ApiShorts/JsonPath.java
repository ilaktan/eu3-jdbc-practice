package ApiShorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class JsonPath {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }

    @Test
    public void JsonPath() {




        Response response = given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);

        assertEquals(response.jsonPath().getInt("id"),10);
        assertEquals(response.jsonPath().getString("name"),"Lorenza");
        assertEquals(response.jsonPath().getString("gender"),"Female");
        assertEquals(response.jsonPath().getLong("phone"),3312820936l);


    }
}