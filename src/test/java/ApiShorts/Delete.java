package ApiShorts;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class Delete {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void Delete(){



        given().contentType(ContentType.JSON)
                .and().pathParam("id", 193)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(204);

        given().contentType(ContentType.JSON)
                .and().pathParam("id", 193)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(404);


    }


}
