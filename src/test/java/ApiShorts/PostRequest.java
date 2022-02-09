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
public class PostRequest {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public  void PostWithString(){

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"gender\": \"Female\",\n" +
                        "  \"name\": \"Zel\",\n" +
                        "  \"phone\": 7575759898\n" +
                        "}")
                .when().post("/api/spartans/");

        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json");

        assertEquals(response.path("success"),"A Spartan is Born!");

        JsonPath json=response.jsonPath();

        assertEquals(json.getString("data.name"),"Zel");
        assertEquals(json.getString("data.gender"),"Female");
        assertEquals(json.getString("data.phone"),"7575759898");


    }
    @Test
    public  void PostMethodWithMap(){

        Map<String,Object> requestMap=new HashMap<>();
        requestMap.put("name","ZelMAP");
        requestMap.put("gender","Female");
        requestMap.put("phone",7575758998L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(requestMap)
                .when().post("/api/spartans/");
        assertEquals(response.statusCode(),201);
        response.prettyPrint();


    }
    @Test
    public void PostWithPojo(){

        Spartan spartan=new Spartan();
        spartan.setName("ZelPOJO");
        spartan.setGender("Female");
        spartan.setPhone(7584896969L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(spartan)
                .when().post("/api/spartans/");
        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json");
        response.prettyPrint();

        Response response2 = given().accept(ContentType.JSON)
                .pathParam("id", 189)
                .and().when().get("/api/spartans/{id}");

        Spartan spartanResponse=response2.body().as(Spartan.class);
        System.out.println(spartanResponse.toString());


    }


}
