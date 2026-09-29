package ar.soft.AT.API.BaseApi.apiBaseTest;

import ar.soft.AT.API.BaseApi.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    // Спецификация для авторизованных запросов (с токеном)
    protected static RequestSpecification requestSpec;

    // Спецификация для неавторизованных запросов (без токена)
    protected static RequestSpecification unauthRequestSpec;

    @BeforeAll
    public static void setUp() {
        // 1. Устанавливаем базовый URL глобально
        RestAssured.baseURI = ConfigReader.get("base.url");

        // 2. Создаем чистую спецификацию (без авторизации)
        unauthRequestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

        // 3. Получаем токен через вынесенный ранее AuthService
        String token = AuthService.getAuthToken(
                ConfigReader.get("auth.email"),
                ConfigReader.get("auth.password")
        );

        // 4. Создаем авторизованную спецификацию (подмешиваем токен)
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}