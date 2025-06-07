package ar.soft.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecOk400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static void intansSpec(RequestSpecification requst, ResponseSpecification responce) {
        RestAssured.requestSpecification = requst;
        RestAssured.responseSpecification = responce;
    }


}
