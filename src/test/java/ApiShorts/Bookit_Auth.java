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
public class Bookit_Auth {
    String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNDAiLCJhdWQiOiJzdHVkZW50LXRlYW0tbGVhZGVyIn0.xNvdQRyrYMb3Ec5QByHwXowBo3zPK2jQQS1eJ2RYIto";
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("bkt_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void test1(){


        Response response = given().header("Authorization", accessToken)
                .when().get("/api/campuses");

                assertEquals(response.statusCode(),200);
                response.prettyPrint();


    }


}
