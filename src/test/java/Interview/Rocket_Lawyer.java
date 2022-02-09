package Interview;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Rocket_Lawyer {
    public class UkHistoricalData {
        @Before
        public void before() {
            RestAssured.baseURI = "https://api.apify.com/v2/datasets/K1mXdufnpvr53AFk6/items";
        }

        @Test
        public void shouldValidateCaseData() {

            Response response = given().accept(ContentType.JSON)
                    .and().queryParam("format", "json")
                    .and().queryParam("clean", "1")
                    .when().get();
            JsonPath jsonPath = response.jsonPath();
            List<HashMap> values = jsonPath.getList("findAll {it.lastUpdatedAtApify == '2020-03-22T22:05:00.000Z'}");
            System.out.println(values);
            assertThat(Integer.parseInt(values.get(0).get("totalInfected").toString()), is(5683));
            assertThat(Integer.parseInt(values.get(0).get("england").toString()), greaterThan(4000));
            assertThat(Integer.parseInt(values.get(0).get("dailyConfirmed").toString()), greaterThan(700));

        }
    }

}
