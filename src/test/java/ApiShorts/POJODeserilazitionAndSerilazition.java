package ApiShorts;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class POJODeserilazitionAndSerilazition {
    @BeforeClass
    public void beforeclass() {
        baseURI = ConfigurationReader.get("spartan_api_url");
        // RestAssured.baseURI="http://34.234.78.164:8000";
    }
    @Test
    public void test1() {


        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .and().when().get("/api/spartans/{id}");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        Spartan spartan1=response.body().as(Spartan.class);
        System.out.println("spartan1.toString() = " + spartan1.toString());



       assertEquals(spartan1.getId(),15);
        assertEquals(spartan1.getName(),"Meta");
       assertEquals(spartan1.getGender(),"Female");
      assertEquals(spartan1.getPhone(),1938695106l);



    }
    @Test
    public void gsonExample() {

        Gson gson=new Gson();

        String myJsonBody="{  \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106}";
        //deserialization

        Spartan spartanMeta=gson.fromJson(myJsonBody,Spartan.class);
        System.out.println(spartanMeta.toString());


        //serialization
        Spartan spartan=new Spartan(101,"Mike","Male",212111212l);
        String jsonbody=gson.toJson(spartan);
        System.out.println(jsonbody);

        String jsonbody2=gson.toJson(spartanMeta);
        System.out.println(jsonbody2);


//        Response response = given().accept(ContentType.JSON)
//                .pathParam("id", 15)
//                .and().when().get("/api/spartans/{id}");
//
//        System.out.println("response.prettyPrint() = " + response.prettyPrint());
//
//        Spartan spartan1=response.body().as(Spartan.class);
//        System.out.println("spartan1.toString() = " + spartan1.toString());



//        assertEquals(spartan1.getId(),15);
//        assertEquals(spartan1.getName(),"Meta");
//        assertEquals(spartan1.getGender(),"Female");
//        assertEquals(spartan1.getPhone(),1938695106l);



    }
}
