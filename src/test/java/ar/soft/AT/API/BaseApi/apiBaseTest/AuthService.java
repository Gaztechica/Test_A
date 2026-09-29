package ar.soft.AT.API.BaseApi.apiBaseTest;

import ar.soft.AT.API.BaseApi.LoginRequests;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AuthService {

    public static String getAuthToken(String email, String password) {
        LoginRequests credentials = new LoginRequests(email, password);

        return given()
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("/account/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath().getString("token");
    }
}


