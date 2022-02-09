package Homework;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework2 {
//    SPARTAN API
//    Q1:
//    Given accept type is json
//    And path param id is 20
//    When user sends a get request to "/spartans/{id}"
//    Then status code is 200
//    And content-type is "application/json;char"
//    And response header contains Date
//    And Transfer-Encoding is chunked
//    And response payload values match the following:
//    id is 20,
//    name is "Lothario",
//    gender is "Male",
//    phone is 7551551687
@BeforeClass
public void beforeclass(){
    baseURI= ConfigurationReader.get("spartan_api_url");
}

    @Test
    public void test1(){


        Response response = given().pathParam("id", "20")
                .when().log().all().get("/api/spartans/{id}");
        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");


        String TransferEncoding = response.getHeader("Transfer-Encoding");
        assertEquals(TransferEncoding,"chunked");
        //header("Date",notNullValue()

        given().accept(ContentType.JSON).and().header("Date",notNullValue());


        JsonPath jsonPath=response.jsonPath();
        int idJson = jsonPath.getInt("id");
        String nameJson = jsonPath.getString("name");
        String gender = jsonPath.getString("gender");
        long phone = jsonPath.getLong("phone");

        //print the values
        System.out.println("idJson = " + idJson);
        System.out.println("nameJson = " + nameJson);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //verification
        assertEquals(idJson,20);
        assertEquals(nameJson,"Lothario");
        assertEquals(gender,"Male");
        assertEquals(phone,7551551687l);




    }
    @Test
    public void test2(){

//        Q2:
//        Given accept type is json
//        And query param gender = Female
//        And queary param nameContains = r
//        When user sends a get request to "/spartans/search"
//        Then status code is 200
//        And content-type is "application/json;char"
//        And all genders are Female
//        And all names contains r
//        And size is 20
//        And totalPages is 1
//        And sorted is false
        Response response = given().queryParam("gender", "Female").queryParam("nameContains","r")
                .when().log().all().get("/api/spartans/search");
        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");

        List<Object> genders = response.path("content.gender");
        for (Object gender : genders) {
            assertEquals(gender, "Female");;

        }

        List<Object> names = response.path("content.name");
        for (Object name : names) {
            System.out.println("name = " + name);
            assertTrue(name.toString().toUpperCase(Locale.ROOT).toLowerCase(Locale.ROOT).contains("r"));



        }






    }
}
