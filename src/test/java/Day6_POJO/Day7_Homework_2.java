package Day6_POJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Day7_Homework_2 {
    //Homework-2
    //-Create one mackaroo api for name,gender,phone
    //send get request to retrieve random info from that api
    //use those info to send post request to spartan
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

        String hrurl = "https://api.mockaroo.com/api/f7c38a10?count=10&key=2af362a0";

        @Test
        public void test1() {
            //List<Map<String,Object>> queryData = DBUtils.getRowList("hrurl");

           Response response = RestAssured.get(hrurl);
            JsonPath jsonPath = response.jsonPath();
            long phone = jsonPath.getLong("phone");
            String gender = jsonPath.getString("gender");
            String name = jsonPath.getString("name");




//
//            //print the status code
//            System.out.println(responses.statusCode());
//
//            //print the json body
//            responses.prettyPrint();
//            Gson gson=new Gson();
//            String myJsonData="[\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Jocko\",\n" +
//                    "        \"phone\": \"6816771809\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Randall\",\n" +
//                    "        \"phone\": \"7269295671\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Female\",\n" +
//                    "        \"name\": \"Tommy\",\n" +
//                    "        \"phone\": \"8402248234\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Gelya\",\n" +
//                    "        \"phone\": \"4159164072\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Female\",\n" +
//                    "        \"name\": \"Lizzie\",\n" +
//                    "        \"phone\": \"5047396963\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Heindrick\",\n" +
//                    "        \"phone\": \"9285133914\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Female\",\n" +
//                    "        \"name\": \"Cord\",\n" +
//                    "        \"phone\": \"9337069362\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Cilka\",\n" +
//                    "        \"phone\": \"8226412408\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Female\",\n" +
//                    "        \"name\": \"Arlyn\",\n" +
//                    "        \"phone\": \"1291083498\"\n" +
//                    "    },\n" +
//                    "    {\n" +
//                    "        \"gender\": \"Male\",\n" +
//                    "        \"name\": \"Hercule\",\n" +
//                    "        \"phone\": \"1314649186\"\n" +
//                    "    }\n" +
//                    "]";
//
//
//
//            Response response = given().log().all()
//                    .accept(ContentType.JSON)
//                    .and()
//                    .contentType(ContentType.JSON)
//                    .and()
//                    .body(myJsonData)
//                    .when()
//                    .post("/api/spartans");
//            Assert.assertEquals(response.path("success"), "A Spartan is Born!");


        }
    @Test
    public void fakeApi(){
        for (int i = 1; i<=5;i++){
            Response mackaro = given().accept(ContentType.JSON)
                    .and().queryParam("key", "cb05c6d0")
                    .when().get("https://my.api.mockaroo.com/spartan.json");



            Response post = given().log().all()
                    .contentType(ContentType.JSON).and()
                    .and().body(mackaro.as(HashMap.class))
                    .when().post("/api/spartans");
            post.prettyPrint();


        }
    }
}
