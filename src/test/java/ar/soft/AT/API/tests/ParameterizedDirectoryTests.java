package ar.soft.AT.API.tests;

import ar.soft.AT.API.BaseApi.BaseTest;
import ar.soft.AT.API.models.director.request.DirectoryRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@DisplayName("API тесты: Параметризованная валидация создания директории")
public class ParameterizedDirectoryTests extends BaseTest {

    @ParameterizedTest(name = "Позитивный тест: Создание директории с именем [{0}]")
    @ValueSource(strings = {
            "Обычная папка",
            "New_Folder_2026",
            "Папка с пробелами и спец символами #!@",
            "A",
            "ОченьДлинноеНазваниеПапкиКотороеПроверяетМаксимальноДопустимуюДлинуПоляВводаНаБэкенде"
    })
    public void createDirectoryValidNamesTest(String folderName) {
        Long contextProjectId = 893L;

        DirectoryRequest directoryBody = DirectoryRequest.builder()
                .name(folderName)
                .projectId("893")
                .parentDirectoryId(1413L)
                .build();

        step("Отправить POST-запрос с именем папки: " + folderName, () ->
                given()
                        .spec(requestSpec)
                        .queryParam("contextProjectId", contextProjectId)
                        .body(directoryBody)
                        .when()
                        .post("/directory/create")
                        .then()
                        .statusCode(200)
        );
    }
}

