package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.ConfigLoader;

public class SpecBuilder {

    public static RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder().setBaseUri(ConfigLoader.getConfigLoader().get("baseurl"))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecBuilder() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
