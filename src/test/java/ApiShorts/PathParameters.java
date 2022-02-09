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

public class PathParameters {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void pathParam1() {



        Response response = given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);

        assertEquals(response.path("id").toString(),"10");
        assertEquals(response.path("name").toString(),"Lorenza");
        assertEquals(response.path("gender").toString(),"Female");
        assertEquals(response.path("phone").toString(),3312820936l);



    }
    @Test
    public void pathParam2() {



        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.statusCode(),200);

        assertEquals(response.path("id[0]").toString(),"105");
        assertEquals(response.path("name[0]").toString(),"Ozg");
        assertEquals(response.path("gender[0]").toString(),"Male");
        assertEquals(response.path("phone[0]").toString(),"8877445596");

        List<String> names = response.path("name");
        System.out.println(names);


    }
}
