package ar.soft.api.Account;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ar.soft.runner.BaseTest.EMAIL;
import static ar.soft.runner.BaseTest.PASSWORD;

public class JwtToken {

    private static TokenService tokenService;
    @BeforeAll
    public  static void setup() {
        RestAssured.baseURI = "http://62.113.97.50:8081/account";
        tokenService = new TokenService();
    }

//    private void getjwtToken(String email, String password) {
//    }

    @Test
    @DisplayName("Авторизация и получение токена")
    public void reguestWithJwtToken() {
        String email = EMAIL;
        String password = PASSWORD;

        String jwtToken = tokenService.getJwtService(email, password);
//        String jwtToken = tokenService.getjwtToken(email, password);

        RestAssured.given()
//                .auth().oauth2(jwtToken)
//                .header("Authorization", "Bearer_" + token)
                .get("Login")
                .then().log().all()
                .statusCode(200);
    }
}
