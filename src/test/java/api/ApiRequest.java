package api;

import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder {

    public static Response post(String endPoint, Headers headers, HashMap<String, Object> formParams, Cookies cookies) {
        return given(requestSpecBuilder())
                .headers(headers)
                .formParams(formParams)
                .cookies(cookies)
                .post(endPoint)
                .then()
                .spec(responseSpecBuilder())
                .extract()
                .response();
    }

    public static Response get(String endpoint, Headers headers, Cookies cookies){
        return given(requestSpecBuilder())
                .headers(headers)
                .cookies(cookies)
                .get(endpoint)
                .then()
                .spec(responseSpecBuilder())
                .extract().response();
    }
}
