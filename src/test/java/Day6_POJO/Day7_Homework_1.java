package Day6_POJO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;


import java.math.BigDecimal;

import static io.restassured.RestAssured.*;

import utilities.ConfigurationReader;
import utilities.ExcelUtil;


public class Day7_Homework_1 {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }
    @DataProvider
    public Object[][] userData() {
        ExcelUtil spartans = new ExcelUtil("/Users/ilhanaltan/IdeaProjects/eu3-jdbc-practice/src/test/resources/MOCK_DATA.xlsx", "data");
        String[][] dataArray = spartans.getDataArrayWithoutFirstRow();
        return dataArray;

    }
    //Optional homeworks
    //Homework-1
    //1-Create csv file from mackaroo website, which includes name,gender,phone
    //2-Download excel file
    //3- using testng data provider and apache poi create data driven posting from spartan

    @Test(dataProvider ="userData")
    public void test1(String name, String gender, String phone) {
        BigDecimal phoneNum = new BigDecimal(phone);
        Spartan spartanEU = new Spartan();
        spartanEU.setName(name);
        spartanEU.setGender(gender);
        spartanEU.setPhone(phoneNum.longValue());
        System.out.println("spartanEU = " + spartanEU);
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(spartanEU)
                .when()
                .post("/api/spartans");
        Assert.assertEquals(response.path("success"), "A Spartan is Born!");
    }
}
