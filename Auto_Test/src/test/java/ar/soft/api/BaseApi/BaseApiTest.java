package ar.soft.api.BaseApi;

import ar.soft.api.Account.LoginReguest;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static ar.soft.runner.BaseTest.EMAIL;
import static ar.soft.runner.BaseTest.PASSWORD;
import static io.netty.handler.codec.http.HttpHeaders.addHeader;
import static io.restassured.RestAssured.given;

public class BaseApiTest {

    public final static String URL_API = "http://62.113.97.50:8081";
//    public final static String URL = "http://62.113.97.50:8081";

    public static String token;

    @BeforeMethod
    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "")
    public static void accountLoginTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);

        Response response = given()
                .body(loginReguest)
                .when()
                .post("account/login")
                .then().log().all()
                .extract().response();
        token = response.getBody().jsonPath().get("token").toString();
    }

    public RequestSpecification specification;

    @BeforeMethod
    @Test
    public void token() {
        specification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer_" + token)
                .build();
    }
}
