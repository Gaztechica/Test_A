package ar.soft.AT.UI.steps.authSteps;

import ar.soft.AT.UI.config.ConfigReader;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthSteps {

    /**
     * Метод отправляет POST запрос и возвращает токен авторизации.
     * Данные автоматически берутся из конфигурационного файла проекта.
     */
    public static String getToken() {
        String email = ConfigReader.get("arSelenide.email");
        String password = ConfigReader.get("arSelenide.password");
        String apiUrl = ConfigReader.get("arSelenide.apiUrl");

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        return given()
                .baseUri(apiUrl)
                .contentType(ContentType.JSON)
                .body(credentials)
                .when()
                .post("/account/login")
                .then()
                .statusCode(200)
                .extract()
                .path("token"); // Вытаскиваем токен (строку) из тела ответа
    }
}
