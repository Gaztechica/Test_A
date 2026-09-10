package ar.soft.AT.API.BaseApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    // 1. Основной метод для дефолтного URL (используется в 90% тестов)
    public static RequestSpecification requestSpec() {
        return requestSpec(ConfigReader.getBaseUri()); // берем из вашего конфига
    }

    // 2. Метод с параметром (для кастомных URL, если понадобятся)
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecOk400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }

    public static void intransSpec(RequestSpecification requst, ResponseSpecification responce) {
        RestAssured.requestSpecification = requst;
        RestAssured.responseSpecification = responce;
    }


}
