package Day8;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpartanBasicAuth {

    @Test
    public void test1(){
            given()
                    .accept(ContentType.JSON)
                    .and()
                    .auth().basic("admin","admin")
            .when()
                    .get("http://54.236.23.180:8000/api/spartans")
            .then().log().all()
                    .statusCode(200);
    }


}