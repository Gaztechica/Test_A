package ar.soft.api.Account;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static ar.soft.runner.BaseTest.EMAIL;
import static ar.soft.runner.BaseTest.PASSWORD;
import static io.restassured.RestAssured.given;

public class TokenService {

    @Test
    public String getJwtService(String email, String password) {
        LoginReguest loginReguest = new LoginReguest(email, password);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginReguest)
                .when()
                .post("http://62.113.97.50:8081/account/")
                .then().log().all()
                .extract()
                .response();

        TokenResponce tokenRespons = response.as(TokenResponce.class);
                return tokenRespons.getToken();
    }

    @Test
    public String getJwtServices(String email, String password) {
        LoginReguest loginReguest = new LoginReguest(email, password);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginReguest)
                .when()
                .post("http://62.113.97.50:8081/account/login")
                .then().log().all()
                .extract()
                .response();

        TokenResponce tokenRespons = response.as(TokenResponce.class);
        return tokenRespons.getToken();
    }

    @Test
    public void getJwtServices2() {
//        LoginReguest loginReguest = new LoginReguest("012345678", "f.ff.1980@list.ru");
        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginReguest)
                .when()
                .post("http://62.113.97.50:8081/account/login")
                .then().log().all()
                .extract()
                .response();

        TokenResponce tokenRespons = response.as(TokenResponce.class);
//        return tokenRespons.getToken();
    }

}
