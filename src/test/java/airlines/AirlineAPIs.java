package airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String, Object> createAirlinePayLoad){

        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndpoint");
        return RestUtils.performPost(endPoint,createAirlinePayLoad, new HashMap<>());

    }
}
