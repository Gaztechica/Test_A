package ar.soft.api.Account;

import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static ar.soft.runner.BaseTest.EMAIL;
import static ar.soft.runner.BaseTest.PASSWORD;
import static io.restassured.RestAssured.given;

public class Login {

    public final static String URL = "http://62.113.97.50:8081";

        public static String token;
    @BeforeMethod
    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "")
    public static void accountLoginTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);

        Response response = given()
                .body(loginReguest)
                .when()
                .post("account/login")
                .then().log().all()
                .extract().response();
        token = response.getBody().jsonPath().get("token").toString();
    }
   }
