package ar.soft.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ar.soft.runner.BaseTest.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AutorisationTest {

    private final static String URL2 = "http://23.111.202.224:8081/account/";
//    private final static String URL2 = "http://23.105.246.172:5000/";
//    private final static String URL2 = "https://reqres.in/";

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
        for (int i=0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }
        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("@reqres.in")));
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
    public void checkAutorisation23331IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
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

    @Test
    public void checkA22utorisation23331IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk400());
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
    public void checkA222utorisation23331IdTest() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk400());
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

    @Test
    public void checkAutorisationIdTest4() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
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
        RestAssured.when().post("http://23.111.202.224:8081/account/");
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
                .baseUri("https://reqres.in/")
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
}
