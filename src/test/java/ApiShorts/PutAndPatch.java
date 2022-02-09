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
public class PutAndPatch {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void PUTRequest(){

        Map<String,Object> putMap=new HashMap<>();
        putMap.put("name","Byz");
        putMap.put("gender","Female");
        putMap.put("phone",12121212112L);

        given().contentType(ContentType.JSON)
                .and().pathParam("id", 101)
                .and().body(putMap)
                .when().put("/api/spartans/{id}")
                .then().assertThat().statusCode(204);


    }
    @Test
    public void PatchRequest(){

        Map<String,Object> patchMap=new HashMap<>();
        patchMap.put("name","Zey");


        given().contentType(ContentType.JSON)
                .and().pathParam("id", 101)
                .and().body(patchMap)
                .when().patch("/api/spartans/{id}")
                .then().assertThat().statusCode(204);


    }

}
