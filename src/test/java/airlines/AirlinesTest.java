package airlines;

import io.restassured.response.Response;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlinesTest extends AirlineAPIs {

    @Test
    public void createAirline() throws IOException {

        //System.out.println(System.getProperty("env") + " is the env value");
        //String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        //Map<String, Object> data = JsonUtils.getJsonDataAsMap("/"+env+"/airlinesApiData.json");
        //String endPoint = data.get("createAirLineEndpoint");
        //String endPoint = "https://api.instantwebtools.net/v1/airlines";


        Map<String, Object> payload = PayLoads.getCreateAirlinePayloadFromMap("998877665","KGH", "IN", "KGH logo", "JKGH", "KA", "www.kgh.com", "1989");
        //Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Response response = createAirline(payload);
        Assert.assertEquals(response.statusCode(), 200);
    }
}
