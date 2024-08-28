package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers){
        return  RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is "+ queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is "+ queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are "+ queryableRequestSpecification.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Request Body is "+ queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response status is "+ response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are "+ response.getHeaders().asList().toString());
        ExtentReportManager.logInfoDetails("Response Body is "+ response.getBody());
    }

    //Executing the POST API
    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers){

        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
//        return  RestAssured.given().log().all()
//                .baseUri(endPoint)
//                .headers(headers)
//                .contentType(ContentType.JSON)
//                .body(requestPayload)
//                .post()
//                .then().log().all().extract().response();
    }
}
