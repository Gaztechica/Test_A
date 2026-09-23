package ar.soft.AT.API.BaseApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    // 1. Для тестов, где НУЖНА авторизация (самый частый кейс)
    // В тесте будете писать просто: Specification.authSpec(token)
    public static RequestSpecification authSpec(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getBaseUri()) // берём урл автоматом
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token) // подставляем токен
                .build();
    }

    // 2. Для тестов, где НЕ НУЖНА авторизация (например, для самого метода login)
    // В тесте будете писать просто: Specification.unauthSpec()
    public static RequestSpecification unauthSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getBaseUri()) // берём урл автоматом
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    // 3. Кастомный метод (если вдруг для какого-то теста нужен बिल्कुल другой URL)
    public static RequestSpecification customSpec(String customBaseUrl, String token) {
        return new RequestSpecBuilder()
                .setBaseUri(customBaseUrl)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }


//    // 1. Основной метод для дефолтного URL (используется в 90% тестов)
//    public static RequestSpecification requestSpec() {
//        return requestSpec(ConfigReader.getBaseUri()); // берем из вашего конфига
//    }
//
//    // Спецификация для авторизованных запросов (передаем токен)
//    public static RequestSpecification requestSpec(String baseUrl, String token) {
//        return new RequestSpecBuilder()
//                .setBaseUri(baseUrl)
//                .setContentType(ContentType.JSON)
//                .setAccept(ContentType.JSON)
//                .addHeader("Authorization", "Bearer " + token)
//                .build();
//    }
//
//    // Спецификация для неавторизованных запросов (например, для самого логина)
//    public static RequestSpecification unauthRequestSpec(String baseUrl) {
//        return new RequestSpecBuilder()
//                .setBaseUri(baseUrl)
//                .setContentType(ContentType.JSON)
//                .setAccept(ContentType.JSON)
//                .build();
//    }
//
    // 2. Метод с параметром (для кастомных URL, если понадобятся)
    public static RequestSpecification requestSpec(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
//                .log(LogDetail.ALL)
                .build();
    }

    // Спецификация проверки успешного ответа (200 OK)
    public static ResponseSpecification responseSpecOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
//                .log(LogDetail.ALL)
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


