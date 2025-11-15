package ar.soft.api.Account;

import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static ar.soft.api.Account.Login.token;
import static ar.soft.runner.BaseTest.EMAIL;
import static ar.soft.runner.BaseTest.PASSWORD;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountLoginTest extends Login{

//    public static final token =

    @Story("Авторизация и получение токена")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "")
    public static void accountLoginTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", EMAIL);
        user.put("password", PASSWORD);
        Response response = given()
                .body(user)
                .when()
                .post("account/login")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        String email = jsonPath.get("data.email");
//        String token = jsonPath.get("token.token");
        String token = response.getBody().jsonPath().get("token").toString();
        Assert.assertEquals(359, id);
        Assert.assertEquals("Елизавета", name);
        Assert.assertEquals("f.ff.1980@list.ru", email);
        Assert.assertEquals(token, token);
    }

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void checkAccountLoginTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);

        Response response = given()
                .body(loginReguest)
                .when().log().all()
                .post("account/login")
                .then().log().all()
//                .body("data.id", equalTo(117))                  проверка по простому
//                .body("data.name", equalTo("Александр"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        String email = jsonPath.get("data.email");
//        String token = jsonPath.get("token.token");
        String token = response.getBody().jsonPath().get("token").toString();
        Assert.assertEquals(359, id);
        Assert.assertEquals("Елизавета", name);
        Assert.assertEquals("f.ff.1980@list.ru", email);
        Assert.assertEquals(token, token);
    }

    @Story("Авторизация и получение токена")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
            description = "")
    public void checkAccountInfoTest4s() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response2 = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer_" + token)
                .get("account/info")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response2.jsonPath();
        int ids = jsonPath.get("data.id");
        String names = jsonPath.get("data.name");
        Assert.assertEquals(359, ids);
    }

    @Story("Авторизация и получение токена")
    @Description("вывести всех пользователей по организации")
    @Test(priority = 3, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void checkAccountOrganizationTests() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", EMAIL);
        user.put("password", PASSWORD);
        Response response = given()
                .body(user)
                .when()
                .post("account/login")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String token = response.getBody().jsonPath().get("token").toString();

        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
//        Map<String, String> user2 = new HashMap<>();
        Response response2 = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer_" + token)
                .get("account/organization")
                .then().log().all()
                .body("totalElements", Matchers.equalTo(59))
                .body("totalElements", equalTo(59))
                .body("domain[0].email", equalTo("1аye21vtcmvg@mail.ru"))
                .body("domain[9].email", equalTo("d8q2s@fthcapital.com"))
                .extract().response();
        jsonPath = response2.jsonPath();
        int ids = jsonPath.get("totalElements");
//        String email = jsonPath.get("$.domain.id[0]");
        Assert.assertEquals(59, ids);
//                Assert.assertEquals(785, email);
//                Assert.assertEquals("d8q2s@fthcapital.com", email);
    }
}
