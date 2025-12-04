package ar.soft.api.Account;

import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static ar.soft.runner.BaseTest.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountLoginPojoTest extends Login {

//    private final static String URL = "http://62.113.97.50:8081/account";

    AccountLoginPojo accountLogin = new AccountLoginPojo(359, "Елизавета",
            "Фёдоровна ", "Greenwich", 0, true, true, "f.ff.1980@list.ru", "222", "TEST!1",
            57, "ROLE_ADMIN", true, "Иванова");

    Pet pet = new Pet(359, "Елизавета", "Фёдоровна ");
  //  Pet pet = new Pet(359, "Елизавета", "Фёдоровна ");

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void checkAccountLoginTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);
        Response response = given()
//                .baseUri(URL)
                .body(loginReguest)
                .when()
                .contentType(ContentType.JSON)
                .post("account/login");

//        AccountLoginPojo actual2 = response.as(AccountLoginPojo.class);

        response
                .then().assertThat()
                .log().all()
                .statusCode(200);
        Pet actual = response.as(Pet.class);

        Assert.assertEquals(actual, pet);
//                .extract().response();

        JsonPath jsonPath = response.jsonPath();
//        Assert.assertEquals(actual2, accountLogin);

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
    public void checkAccountLoginTest2() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response2 = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer_" + token)
                .get("account/info")
                .then().log().all()
                .extract().response();
        Pet actual = response2.as(Pet.class);

        Assert.assertEquals(actual, pet);
        JsonPath jsonPath = response2.jsonPath();
        int ids = jsonPath.get("data.id");
        String names = jsonPath.get("data.name");
        Assert.assertEquals(359, ids);
    }

    @Story("вывести информацию о своем аккаунте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void GetAccountInfoTest() {
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

    @Story("вывести всех пользователей по организации")
    @Description("вывести всех пользователей по организации")
    @Test(priority = 3, groups = {"10.5", "Dialogs"},
            description = "вывести всех пользователей по организации")
    public void PostAccountOrganizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
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
    public void PutAccountPasswordTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("currentPassword", PASSWORD);
        user.put("newPassword", PASSWORD_N);
        Response response = given()
                .body(user)
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer_" + token)
                .put("account/password")
                .then()
                .extract().response();

        Map<String, String> user2 = new HashMap<>();
        user2.put("currentPassword", PASSWORD_N);
        user2.put("newPassword", PASSWORD);
        Response response2 = given()
                .body(user2)
                .when().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer_" + token)
                .put("account/password")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response2.jsonPath();
        int id = jsonPath.get("data.id");
        Assert.assertEquals(359, id);
        String email = jsonPath.get("data.email");
        Assert.assertEquals("f.ff.1980@list.ru", email);
    }

//    @Story("редактировать пользователя (если почта не изменяется, то в запрос ее передавать не нужно)")
//    @Description("редактировать пользователя (если почта не изменяется, то в запрос ее передавать не нужно)")
//    @Test(priority = 4, groups = {"10.5", "Dialogs"},
//            description = "редактировать пользователя (если почта не изменяется, то в запрос ее передавать не нужно)")
//    public void PutAccountTest() {
//        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
//        Map<String, String> user = new HashMap<>();
//        user.put( "{\n" +
//                "        \"id\": 359,\n" +
//                "        \"name\": \"Елизавета\",\n" +
//                "        \"middleName\": \"Фёдоровна \",\n" +
//                "        \"timezone\": \"Greenwich\",\n" +
//                "        \"timezoneOffset\": 0,\n" +
//                "        \"active\": true,\n" +
//                "        \"approvedByOrganization\": true,\n" +
//                "        \"roles\": [\n" +
//                "            {\n" +
//                "                \"name\": \"ROLE_ADMIN\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"email\": \"f.ff.1980@list.ru\",\n" +
//                "        \"phoneNumber\": \"222\",\n" +
//                "        \"organizationName\": \"TEST!1\",\n" +
//                "        \"organizationId\": 57,\n" +
//                "        \"license\": {\n" +
//                "            \"id\": 57,\n" +
//                "            \"creationDate\": \"2024-01-29T11:21:24.21129\",\n" +
//                "            \"endLicenseDate\": \"2025-12-31T15:21:24.211\",\n" +
//                "            \"maxNumberOfAdminAccounts\": 1,\n" +
//                "            \"maxNumberOfSubcontractorAccounts\": 50,\n" +
//                "            \"maxNumberOfObserverAccounts\": 50,\n" +
//                "            \"maxNumberOfWorkersAccounts\": 50,\n" +
//                "            \"accountId\": 359,\n" +
//                "            \"firstName\": \"Елизавета\",\n" +
//                "            \"lastName\": \"Иванова\",\n" +
//                "            \"accEmail\": \"f.ff.1980@list.ru\",\n" +
//                "            \"companyTitle\": \"TEST!1\",\n" +
//                "            \"tariff\": \"Индивидуальный\",\n" +
//                "            \"locale\": \"ru\",\n" +
//                "            \"identifyNumber\": \"33\",\n" +
//                "            \"storageMax\": 32212254720,\n" +
//                "            \"storageUsage\": 736534358,\n" +
//                "            \"accCount\": 0,\n" +
//                "            \"paid\": false,\n" +
//                "            \"links\": [\n" +
//                "                \n" +
//                "            ]\n" +
//                "        },\n" +
//                "        \"employment\": {\n" +
//                "            \"id\": 205,\n" +
//                "            \"name\": \"TEST!1\"\n" +
//                "        },\n" +
//                "        \"headRole\": \"ROLE_ADMIN\",\n" +
//                "        \"lastActivity\": \"2025-11-10T18:34:07.739807\",\n" +
//                "        \"projectsInfos\": [\n" +
//                "            \n" +
//                "        ],\n" +
//                "        \"enable\": true,\n" +
//                "        \"links\": [\n" +
//                "            \n" +
//                "        ],\n" +
//                "        \"last_name\": \"Иванова\"\n" +
//                "    }\n" +
//                "}");
//        Response response = given()
//                .body(user)
//                .when().log().all()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer_" + token)
//                .put("account")
//                .then()
//                .extract().response();
//
//        Map<String, String> user2 = new HashMap<>();
//        user2.put("middleName", "Фёдоровна");
//        Response response2 = given()
//                .body(user2)
//                .when().log().all()
//                .contentType(ContentType.JSON)
//                .header("Authorization", "Bearer_" + token)
//                .put("account")
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response2.jsonPath();
//        int id = jsonPath.get("data.id");
//        Assert.assertEquals(359, id);
//        String email = jsonPath.get("data.email");
//        Assert.assertEquals("f.ff.1980@list.ru", email);
//    }


}
