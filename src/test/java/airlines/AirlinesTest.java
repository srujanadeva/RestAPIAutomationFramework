package airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlinesTest {

    @Test
    public void createAirline() throws IOException {

        Map<String, String> data = JsonUtils.getJsonDataAsMap("/qa/airlinesApiData.json");
        String endPoint = data.get("createAirLineEndpoint");
        //String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String, Object> payload = PayLoads.getCreateAirlinePayloadFromMap("998877665522","KGH", "IN", "KGH logo", "JKGH", "KA", "www.kgh.com", "1989");
        Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
