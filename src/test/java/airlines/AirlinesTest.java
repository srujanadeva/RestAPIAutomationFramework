package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirlinesTest {

    @Test
    public void createAirline(){
        Response response = RestAssured.given().log().all()
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"_id\":\"666777888\",\n" +
                        "    \"name\": \"Kodigehalli Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Kodigehalli\",\n" +
                        "    \"head_quaters\": \"BB Nagar, Sri Lanka\",\n" +
                        "    \"website\": \"www.kghalliairways.com\",\n" +
                        "    \"established\": \"1980\"\n" +
                        "}")
                .post()
                    .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }
}
