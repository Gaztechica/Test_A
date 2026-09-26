package ar.soft.AT.API.BaseApi;

import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;

public class BaseTest {
    // Эта спецификация будет доступна во всех классах-наследниках
    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {
        // 1. Создаем тело запроса для авторизации
        LoginRequests credentials = new LoginRequests(
                ConfigReader.get("auth.email"),
                ConfigReader.get("auth.password")
        );

        // 2. Логинимся, используя базовую неавторизованную спецификацию Specification.unauthSpec()
        String token = given()
                .spec(Specification.unauthSpec()) // 👈 Вызов без параметров (чистый JSON-запрос)
                .body(credentials)
                .when()
                .post("account/login")
                .then()
                .spec(Specification.responseSpecOk200()) // Валидация успешного ответа
                .extract()
                .jsonPath().getString("token"); // Извлекаем токен

        // 3. Создаем глобальную спецификацию С ТОКЕНОМ для всех последующих тестов
        requestSpec = Specification.authSpec(token); // 👈 Передаем только токен, URL подставится сам
    }
}



