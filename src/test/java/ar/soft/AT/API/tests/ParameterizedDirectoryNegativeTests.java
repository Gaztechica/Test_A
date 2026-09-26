package ar.soft.AT.API.tests;

import ar.soft.AT.API.BaseApi.BaseTest;
import ar.soft.AT.API.models.director.request.DirectoryRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import io.restassured.response.ValidatableResponse;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@DisplayName("API тесты: Негативная валидация поля ввода")
public class ParameterizedDirectoryNegativeTests extends BaseTest {

    @ParameterizedTest(name = "Негативный тест: {0}")
    @CsvSource(value = {
            "Пустая строка в поле имени     , ''                 , 400              , Can't create directory without name!",
            "Строка из одних пробелов       , '   '              , 400              , Can't create directory without name!",
            "Превышение лимита (256+ симв)  , ДЛИННАЯ_СТРОКА_X256 , 500              , Internal Server Error",
            "Запрещенные символы в пути     , 'папка/слаш'       , 200              , object has been added to the catalog"
    }, delimiter = ',')
    public void createDirectoryNegativeValidationTest(String description, String inputName, int expectedStatusCode, String expectedErrorMessage) {
        Long contextProjectId = 893L;

        String finalName = inputName.equals("ДЛИННАЯ_СТРОКА_X256") ? "A".repeat(257) : inputName;

        DirectoryRequest directoryBody = DirectoryRequest.builder()
                .name(finalName)
                .projectId("893")
                .parentDirectoryId(1413L)
                .build();

        step("Отправить некорректный POST-запрос для проверки валидации поля name", () -> {
            ValidatableResponse response = given()
//                 given()
                    .spec(requestSpec)
                    .queryParam("contextProjectId", contextProjectId)
                    .body(directoryBody)
                    .when()
                    .post("/directory/create")
                    .then()
                    .log().ifValidationFails();
//                    .statusCode(expectedStatusCode);
            // Проверяем статус-код
            response.statusCode(expectedStatusCode);

// Динамически переключаем проверку тела в зависимости от ответа сервера
            if (expectedStatusCode == 200) {
                // Для багов со статусом 200 (например, запрещенные символы)
                response.body("success", containsString(expectedErrorMessage));
            } else if (expectedStatusCode == 500) {
                // Для багов со статусом 500 (превышение лимита символов)
                response.body("error", containsString(expectedErrorMessage)); // Ищет поле error в корне JSON
            } else {
                // Для нормальной валидации 400 (пустые строки и пробелы)
                response.body("violation.error", containsString(expectedErrorMessage));
            }
//                        .body("violation.error", containsString(expectedErrorMessage))
//                        .body("error", containsString(expectedErrorMessage))
        });
    }
}

