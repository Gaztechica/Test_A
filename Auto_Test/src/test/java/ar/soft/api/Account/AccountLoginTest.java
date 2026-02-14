package ar.soft.api.Account;

import ar.soft.api.BaseApi.BaseApiTest;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static ar.soft.runner.BaseTest.*;
import static ar.soft.runner.BaseTest.PASSWORD_N;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountLoginTest extends BaseApiTest {

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void accountAuthTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);
        Response response = given()
                .body(loginReguest)
                .when()
                .post("account/login");

        response
                .then().assertThat();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        String email = jsonPath.get("data.email");
        Assert.assertEquals(359, id);
        Assert.assertEquals("Елизавета", name);
        Assert.assertEquals(EMAIL, email);
    }

    @Story("вывести информацию о своем аккаунте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void accountInfoTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response2 = given(specification)
                .get("account/info")
                .then()
                .extract().response();
        JsonPath jsonPath = response2.jsonPath();
        int ids = jsonPath.get("data.id");
        String names = jsonPath.get("data.name");
        Assert.assertEquals(359, ids);
    }

    @Story("вывести всех пользователей по организации")
    @Description("вывести всех пользователей по организации")
    @Test(priority = 3, groups = {"10.5", "Dialogs"},
            description = "вывести всех пользователей по организации")
    public void accountOrganizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response2 = given(specification)
                .get("account/organization")
                .then().log().all()
                .body("totalElements", Matchers.equalTo(59))
                .body("totalElements", equalTo(59))
                .body("domain[0].email", equalTo("1аye21vtcmvg@mail.ru"))
//                .body("domain[9].email", equalTo("d8q2s@fthcapital.com"))
                .extract().response();
        JsonPath jsonPath = response2.jsonPath();
        int ids = jsonPath.get("totalElements");
        Integer id = jsonPath.get("domain[0].id");
        String email = jsonPath.get("domain[0].email");
        Assert.assertEquals(59, ids);
        Assert.assertEquals(785, id);
        Assert.assertEquals("1аye21vtcmvg@mail.ru", email);
    }

    @Story("Изменение пароля пользователя на странице профиля")
    @Description("Изменение пароля пользователя на странице профиля")
    @Test(priority = 4, groups = {"10.5", "Dialogs"},
            description = "Изменение пароля пользователя на странице профиля")
    public void putAccountPasswordTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("currentPassword", PASSWORD);
        user.put("newPassword", PASSWORD_N);
        Response response = given(specification)
                .body(user)
                .when()
                .put("account/password")
                .then()
                .extract().response();

        Map<String, String> user2 = new HashMap<>();
        user2.put("currentPassword", PASSWORD_N);
        user2.put("newPassword", PASSWORD);
        Response response2 = given(specification)
                .body(user2)
                .when().log().all()
                .header("Authorization", "Bearer_" + token)
                .put("account/password")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response2.jsonPath();
        int id = jsonPath.get("data.id");
        Assert.assertEquals(359, id);
        String email = jsonPath.get("data.email");
        Assert.assertEquals(EMAIL, email);
    }
}
