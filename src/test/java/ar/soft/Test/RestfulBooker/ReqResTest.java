package ar.soft.Test.RestfulBooker;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class ReqResTest extends ReqBaseTest {

    @Test
    public void GetUsersListWithQueryParamAndValidateSchemaTest() {

        given(requestSpec)
                .queryParam("page", 2)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users")
                .then().log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body(matchesJsonSchemaInClasspath("users-short-schema.json"));
    }


    @Test
    public void createUserAndValidateSchemaTest() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        var response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON).log().all()
                .body(matchesJsonSchemaInClasspath("response-schema.json"))
                .extract().response();

        createdUserId = response.path("id").toString();
    }

    @Test
    public void testCreateUserAndValidateSchema() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        var response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("response-schema.json"))
                .extract().response();

        createdUserId = response.path("id").toString();
    }

    @Test
    public void testGetUsersListWithQueryParamAndValidateSchema() {

        given(requestSpec)
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body(matchesJsonSchemaInClasspath("users-short-schema.json"));
    }
}
