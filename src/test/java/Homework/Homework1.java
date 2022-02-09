package Homework;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Homework1 {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("hr_api_url");
    }

//    Q1:
//            - Given accept type is Json
//- Path param value- US
//- When users sends request to /countries
//- Then status code is 200
//            - And Content - Type is Json
//- And country_id is US
//- And Country_name is United States of America
//- And Region_id is

    @Test
    public void test1(){


        Response response = given().pathParam("id", "US")
                .when().log().all().get("/countries/{id}");
        assertEquals(response.statusCode(),200);

        assertEquals(response.contentType(),"application/json");

        JsonPath jsonPath=response.jsonPath();
        int regionId = jsonPath.getInt("region_id");
        String countryId = jsonPath.getString("country_id");
        String countryName = jsonPath.getString("country_name");
        assertEquals(countryId,"US");
        assertEquals(regionId,2);
        assertEquals(countryName,"United States of America");




    }

//    Q2:
//            - Given accept type is Json
//- Query param value - q={"department_id":80}
//- When users sends request to /employees
//- Then status code is 200
//            - And Content - Type is Json
//- And all job_ids start with 'SA'
//            - And all department_ids are 80
//            - Count is 25

    @Test
    public void test2() {


        Response response = given().queryParam("q", "{\"department_id\":80}")
                .when().log().all().get("/employees");
        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");


        List<Object> JobIds = response.path("items.job_id");
        for (Object JobId : JobIds) {
            assertTrue(JobId.toString().contains("SA"));

        }

        List<Object> departmentIds = response.path("items.department_id");
        for (Object departmentId : departmentIds) {
            assertEquals(departmentId, 80);;

        }
        JsonPath jsonPath=response.jsonPath();

        //int count = jsonPath.getInt("items.count");
        int count2 =  response.path("count");

        assertEquals(count2,25);



    }


//    Q3:
//            - Given accept type is Json
//-Query param value q= region_id 3
//            - When users sends request to /countries
//- Then status code is 200
//            - And all regions_id is 3
//            - And count is 6
//            - And hasMore is false
//            - And Country_name are;
//    Australia,China,India,Japan,Malaysia,Singapore

    @Test
    public void test3() {


        Response response = given().queryParam("q", "{\"region_id\":3}")
                .when().log().all().get("/countries");
        assertEquals(response.statusCode(), 200);

        assertEquals(response.contentType(), "application/json");


        List<Object> reqionIds = response.path("items.region_id");
        for (Object reqionId : reqionIds) {
            assertEquals(reqionId, 3);;

        }



        int count =  response.path("count");

        assertEquals(count,6);

        boolean hasMore=response.path("hasMore");
        assertEquals(hasMore,false);

        List<Object> countrynames = response.path("items.country_name");
        for (Object countryname : countrynames) {
            List<Object> expectedcountryname=new ArrayList<>();
            expectedcountryname.add("Australia");
            expectedcountryname.add("China");
            expectedcountryname.add("India");
            expectedcountryname.add("Japan");
            expectedcountryname.add("Malaysia");
            expectedcountryname.add("Singapore");
            System.out.println("expectedcountryname = " + expectedcountryname);
            System.out.println("countryname = " + countryname);

            for (int i = 0; i <expectedcountryname.size() ; i++) {
                //Assert.assertTrue(countryname.toString().contains(expectedcountryname.toString()));
                Assert.assertTrue(expectedcountryname.toString().contains(countrynames.toString()));

            }

        }




    }

    }
