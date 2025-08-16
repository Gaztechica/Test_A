package ar.soft.api;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.MediaType;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ar.soft.runner.BaseTest.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AutorisationApiTest {

    private final static String URL_API = "http://23.111.202.224:8081/account/";
    private final static String URL_API2 = "http://23.111.202.224:8081/account/password/send";
    //    private final static String URL2 = "http://23.105.246.172:5000/";
    private final static String URL2 = "https://reqres.in/api/users";

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 1, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью владельца")
    public void checkOwnerAuthorizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", EMAIL);
        user.put("password", PASSWORD);
        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
//                .body("data.id", equalTo(117))                  проверка по простому
//                .body("data.name", equalTo("Александр"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        Assert.assertEquals(359, id);
        Assert.assertEquals("Елизавета", name);
    }

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 2, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Admin")
    public void checkAdminAuthorizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "batrayilto@gufum.com");
        user.put("password", PASSWORD);
        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
//                .body("data.id", equalTo(117))                  проверка по простому
//                .body("data.name", equalTo("Александр"))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.get("data.id");
        String name = jsonPath.get("data.name");
        Assert.assertEquals(647, id);
        Assert.assertEquals("Семен", name);
    }

    @Story("Выход из аккаунта на устройстве")
    @Description("Выход из аккаунта на устройстве")
    @Test(priority = 2, groups = {"10.5", "Dialogs"},
            description = "Выход из аккаунта на устройстве")
    public void checkAdmin8AuthorizationTest() {
//        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
//        Map<String, String> user = new HashMap<>();
//        user.put("email", "yevgeniy.gor.90@mail.ru");
////        user.put("password", "");
//        given()
////        Response response = given()
//                .body(user)
//                .when()
//                .post("password/send")
//                .then().log().all()
//                .body("violation.error", equalTo("Wrong email or password"));


        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        List<UserData> users = given()
                .when()
                .post("password/send")
                .then().log().all()
                .extract().body().jsonPath().getList("success");


//        String baseUrl = URL_API;
//        String body = """
//                             {
//                               "email": "kkk.k.82@list.ru"
//
//
//
//                                              }
//                }""";
//        given()
//                .baseUri(baseUrl)
////                .header("accept", "application/json")
////                .header("Content-Type", "application/json")
//                .body(body).
//                when()
//                .post("password/send")
////                .then()
////                .statusCode(200);
//         .then().log().all()
//                .body("violation.error", equalTo("Wrong email or password"));
//                .body("code", equalTo(200));
//                .body("type", equalTo("unknown"))
//                .body("message", notNullValue(String.class));
    }


    @Story("Проверка на 400 при Авторизации с пустом password")
    @Description("Проверка на 400 при Авторизации с пустом password")
    @Test(priority = 3, groups = {"10.5", "Dialogs"},
            description = "Проверка на 400 при Авторизации с пустом password")
    public void checkAuthorizationNoOwnerPasswordTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "yevgeniy.gor.90@mail.ru");
        user.put("password", "");
        given()
//        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
                .body("violation.error", equalTo("Wrong email or password"));
    }

    @Story("Проверка на violation.error при Авторизации с корректным password")
    @Description("Проверка на 400 при Авторизации с пустом password")
    @Test(priority = 4, groups = {"10.5", "Dialogs"},
            description = "Проверка на 400 при Авторизации с пустом password")
    public void checkA222utorisation23331IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "yevgeniy.gor.90@mail.ru");
        user.put("password", "qwert12i345");
        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String error = jsonPath.get("violation.error");

        Assert.assertEquals("Wrong email or password", error);
    }

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 2, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Admin")
    public void check878865AdminAuthorizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", EMAIL); //"name": "string",
        user.put("password", PASSWORD);    //"projectId": 504
        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("token");
        Assert.assertEquals(token, token);

//        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
//        Map<String, String> user = new HashMap<>();
//        user.put("name", "string"); //"name": "string",
//        user.put("projectId", "504");    //"projectId": 504
//        Response response = given()
//                .header("token", token)
//                .header("Content-Type", "application/json")
//                .body(user)
//                .when()
//                .post("login")
//                .then().log().all()
//                .extract().response();
//        JsonPath jsonPath = response.jsonPath();
//        String token = jsonPath.get("token");
    }

    @Story("Авторизация и получение токена")
    @Description("Авторизация и получение токена")
    @Test(priority = 2, groups = {"10.5", "Dialogs"},
            description = "Авторизация под ролью Admin")
    public void check8765AdminAuthorizationTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("name", "string"); //"name": "string",
        user.put("projectId", "504");    //"projectId": 504
        Response response = given()
//                .header("token", token)
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("login")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("token");
        Assert.assertEquals(token, token);
    }

    @Test
    public void checkAutorisationIdTest() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        List<UserData> users = given()
                .when()
//                .contentType(ContentType.JSON)
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
//        int f = 0;
    }

    @Test
    public void checkAutorisationId22Test() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        Response response = given()
                .when()
//                .contentType(ContentType.JSON)
                .get("api/users?page=2")
                .then().log().all()
                .body("page", equalTo(2))
                .body("data.id", notNullValue())
                .body("data.email", notNullValue())
                .body("data.first_name", notNullValue())
                .body("data.last_name", notNullValue())
                .body("data.avatar", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.get("data.email");
        List<Integer> ids = jsonPath.get("data.id");
        List<String> avatars = jsonPath.get("data.avatar");
        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x -> x.endsWith("@reqres.in")));
    }

    @Test
    public void checkAutorisation21IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", "eve.holt@reqres.in");
        user.put("password", "pistol");
        given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .body("id", equalTo(4))
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));

//        Integer id = 4;
//        String token = "QpwL5tke4Pnpja7X4";
//        Register user = new Register("eve.holt@reqres.in", "pistol");
//        SucessReg regId = given()
//                .body(user)
//                .when()
////                .contentType(ContentType.JSON)
//                .post("api/register")
//                .then().log().all()
//                .extract().as(SucessReg.class);
//        Assert.assertEquals(id, regId.getId());
//        Assert.assertEquals(token, regId.getToken());
    }

    @Test
    public void checkAutorisationIdTest2() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SucessReg regId = given()
                .body(user)
                .when()
//                .contentType(ContentType.JSON)
                .post("api/register")
                .then().log().all()
                .extract().as(SucessReg.class);
        Assert.assertEquals(id, regId.getId());
        Assert.assertEquals(token, regId.getToken());
    }


    @Test
    public void checkA22utorisation2333IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk400());
        Map<String, String> user = new HashMap<>();
        user.put("email", "yevgeniy.gor.90@mail.ru");
        user.put("password", "");
        given()
//        Response response = given()
                .body(user)
                .when()
                .post("login")
                .then().log().all()
                .body("violation.error", equalTo("Wrong email or password"));
    }


    @Test
    public void checkAutorisationIdTest4() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Integer id = 117;
        String token = "eyJhbGciOiJIUzI1NiJ9";
        Register user = new Register("yevgeniy.gor.90@mail.ru", "qwert12345");
        SucessReg regId = given()
                .body(user)
//                .body(user)
                .when()
//                .contentType(ContentType.JSON)
                .post("login")
                .then().log().all()
                .extract().as(SucessReg.class);
        Assert.assertEquals(id, regId.getId());
//        Assert.assertEquals(token, regId.getToken());
    }

    @Test
    public void restAssured2Test() {
        RestAssured.when().post(URL_API);
        Integer id = 117;
//        String token = "eyJhbGciOiJIUzI1NiJ9";
        Register user = new Register("yevgeniy.gor.90@mail.ru", "qwert12345");
        given()
//        SucessReg regId = given()
                .body(user)
                .then()
                .statusCode(200);

    }

    @Test
    public void checkAutorisationIdTest3() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
//        List<UserData> users = given()
        given()
                .baseUri(URL2)
                .basePath("/api/users?page=2")
                .contentType(ContentType.JSON)
                .when().get()
//                .contentType(ContentType.JSON)
//                .get("api/users?page=2")
//                .then().log().all()
                .then()
                .statusCode(200)
//                .extract().body().jsonPath().getList("data", UserData.class);
//                .body("email", "michael.lawson@reqres.in"));
                .body("page", equalTo(2));
//                .extract().body().jsonPath().getList("data", UserData.class);
//        int f = 0;
    }

    @Test
    public void check1234AutorisationIdTest3() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        String value = String.valueOf(given()
                .log().all()
                .header("Authorization", "Bearer ")
                .contentType(ContentType.JSON)
                .when()
                        .get(URL2)
                        .then()
                        .statusCode(200)
                        .extract().jsonPath().getString("data[0].last_name"));
        Assert.assertEquals(value, "Lawson", "1234567");
    }

    @Test
    public void check123oo4AutorisationIdTest30() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        JsonPath value = given()
//                .filter(new AllureRestAssured())
                .log().all()
                .header("Authorization", "Bearer ")
                .contentType(ContentType.JSON)
                .when()
                .get(URL2)
                .prettyPeek()
                        .body()
                        .jsonPath();
//        Assert.assertEquals(value, get("data[0].last_name"), "Lawson", "1234567");
    }

////    их исправить?
////    @AllArgsConstructor
////    @Data
//    public class TestClass {
//        private List<Transfer> transfers;
//
//        public void getTransfersList() {
//            return transfers;
//        }
//        public List<Transfer> getActiveTransfer(List<Transfer> allTransfers) {
//            for (Transfer t : allTransfers) {
//                if (!t.getStatus().equals("paid")) {
//                    allTransfers.remove(t);
//                }
//            }
//            return allTransfers;
//        }
//        public void sendTransfer(long amount, String sender, String receiver) {
//            if (sender != receiver) {
//                Transfer newTransfer = new Transfer();
//                newTransfer.setAmount(amount);
//                newTransfer.setSender(sender);
//                newTransfer.setReceiver(receiver);
//            } else {
//                throw new RuntimeException("Transfers to yourself does`t available");
//            }
//        }
//    }

    @Test
    public void check12rr3oo4AutorisationIdTest3() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        JsonPath responce = given()
//                .filter(new AllureRestAssured())
                .log().all()
//                .header("Authorization", "Bearer ")
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "             \"name\": uuuuuu,\n" +
                        "             \"job\": \"string\",\n" +
                                     "}")
                .post(URL2)
                .prettyPeek()
                .body()
                .jsonPath();
//        Assert.assertEquals(value, get("data[0].last_name"), "Lawson", "1234567");
    }

    @Test
    public void check1232rr3oo4AutorisationIdTest3() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        JsonPath responce = given()
//                .filter(new AllureRestAssured())
                .log().all()
//                .header("Authorization", "Bearer ")
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "             \"email\": kkk.k.82@list.ru,\n" +

                        "}")
                .post(URL_API2)
                .prettyPeek()
                .body()
                .jsonPath();
//        Assert.assertEquals(value, get("data[0].last_name"), "Lawson", "1234567");
    }

//    @Test
//    public void check1232rr3oo4AutorisationIdTeseet3() {
////        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("http://23.111.202.224:8081/defect/draft")
//                .header("Content-Type", "application/json")
//                .header("Authorization", "••••••")
//                .body("{\r\n    \"id\": null,\r\n    \"name\": \"TestDefect\",\r\n    \"isDraft\": true,\r\n    \"layerId\": 743,\r\n    \"description\": \"DEFECT descr\",\r\n    \"priority\": \"\",\r\n    \"typeOfWorkId\": 560,\r\n    \"inspectionId\": null,\r\n    \"deadLine\": \"2025-11-26T19:00:00.000\",\r\n    \"responsibleId\": 218,\r\n    \"typesOfControl\": null,\r\n    \"projectId\": 504,\r\n    \"planMark\": {\r\n        \"markXCoord\": 4284,\r\n        \"markYCoord\": 626,\r\n        \"markZCoord\": 0,\r\n        \"markX2Coord\": 124,\r\n        \"markY2Coord\": 333,\r\n        \"objectPlanId\": 1801\r\n    }\r\n}")
//                .asString();
//
//    }
}