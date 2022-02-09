package ApiShorts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class JsonToCollections {
//    {
//        "id": 10,
//            "name": "Lorenza",
//            "gender": "Female",
//            "phone": 3312820936
//    }
@BeforeClass
public void beforeclass() {
    baseURI = ConfigurationReader.get("spartan_api_url");
    // RestAssured.baseURI="http://34.234.78.164:8000";
}
    @Test
    public void test1() {


        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");

       Map<String,Object> spartanMap=response.body().as(Map.class);
        assertEquals(spartanMap.get("id").toString(),"10");
        assertEquals(spartanMap.get("name").toString(),"Lorenza");
        assertEquals(spartanMap.get("gender").toString(),"Female");
        assertEquals(spartanMap.get("phone").toString(),"3312820936");



    }
    @Test
    public void test2() {


        Response response = given().accept(ContentType.JSON)
                .and().when().get("/api/spartans");

        List<Map<String,Object>> listOfSpartan=response.body().as(List.class);

        assertEquals(listOfSpartan.get(0).get("id").toString(),"105");
        assertEquals(listOfSpartan.get(0).get("name").toString(),"Ozg");
        assertEquals(listOfSpartan.get(0).get("gender").toString(),"Male");
        assertEquals(listOfSpartan.get(0).get("phone").toString(),"8877445596");

        int counter;
        for (Map<String,Object> map:listOfSpartan
             ) {
            System.out.println("map = " + map);

        }



    }
}
