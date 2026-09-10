package ar.soft.AT.API.BaseApi;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

//    public final static String URL_API = "http://62.113.97.50:8081";
    public final static String URL_API = ConfigReader.getBaseUri();

    public RequestSpecification specification;
    public static String token;

    @BeforeMethod
    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "")
    public static void accountLoginTest() {
        Specification.intransSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
//        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);
        LoginRequests loginRequests = new LoginRequests(
                ConfigReader.get("auth.email"),
                ConfigReader.get("auth.password")
        );

        Response response = given()
                .body(loginRequests)
                .when()
                .post("account/login")
                .then().log().all()
                .extract().response();
        token = response.getBody().jsonPath().get("token").toString();
    }


    @BeforeMethod
    @Test
    public void token() {
        specification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer_" + token)
                .build();
    }

//    private RequestSpecification getBaseSpecification() {
//        return new RequestSpecBuilder()
//                .addHeader("Authorization", "Bearer_" + token)
//                .setBasePath()
//                .build();
//    }
//    protected RequestSpecification getSpecification(String body) {
//        return specification
//
//    }
}
