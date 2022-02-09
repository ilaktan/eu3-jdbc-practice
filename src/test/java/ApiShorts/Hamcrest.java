package ApiShorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Hamcrest {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void JsonPath() {




       given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}")
       .then().statusCode(200)
       .assertThat().contentType("application/json")
       .and().assertThat().body("id", Matchers.equalTo(10)
               ,"name",Matchers.equalTo("Lorenza")
               ,"gender",Matchers.equalTo("Female")
               ,"phone",Matchers.equalTo(3312820936l));




    }
}
