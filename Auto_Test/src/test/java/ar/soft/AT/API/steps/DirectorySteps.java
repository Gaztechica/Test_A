package ar.soft.AT.API.steps;

import ar.soft.AT.API.models.director.request.DirectoryRequest;
import ar.soft.AT.API.models.director.request.FileSearchRequest;
import ar.soft.AT.API.models.director.response.ResponseDirectoryDto;
import io.restassured.specification.RequestSpecification;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectorySteps {

    // 🌟 Внутреннее состояние для хранения ответа бэка между шагами цепочки
    private ResponseDirectoryDto lastResponse;
    private final RequestSpecification spec;

    public DirectorySteps(RequestSpecification spec) {
        this.spec = spec;
    }

    // 1. Шаг создания папки (возвращает this)
    public DirectorySteps createDirectory(String name, String projectId, Long parentId) {
        DirectoryRequest body = DirectoryRequest.builder()
                .name(name)
                .projectId(projectId)
                .parentDirectoryId(parentId)
                .build();

        lastResponse = step("API Шаг: Отправить POST-запрос на создание директории '" + name + "'", () ->
                given()
                        .spec(spec)
                        .queryParam("contextProjectId", projectId)
                        .body(body)
                        .when()
                        .post("/directory/create")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );
        return this; // 👈 Магия Fluent Interface
    }

    // 2. Шаг проверки общих метаданных (возвращает this)
    public DirectorySteps verifyMetadataSuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
            assertThat(lastResponse.success()).isEqualTo("object has been added to the catalog");
            assertThat(lastResponse.error()).isNull();
        });
        return this;
    }

    public DirectorySteps verifyEditMetadataSuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
            assertThat(lastResponse.success()).isEqualTo("updated");
            assertThat(lastResponse.error()).isNull();
        });
        return this;
    }

    // 3. Шаг проверки контента созданной папки (возвращает void или очередной класс степов)
    public void verifyDirectoryContent(String expectedName, Long expectedProjectId) {
        step("API Шаг: Проверить соответствие данных созданной папки", () -> {
            assertThat(lastResponse.data())
                    .as("Объект 'data' не должен быть null")
                    .isNotNull();

            if (lastResponse.data() != null) {
                assertThat(lastResponse.data().name()).isEqualTo(expectedName);
                assertThat(lastResponse.data().projectId()).isEqualTo(expectedProjectId);
            }
        });
    }

    public DirectorySteps deleteDirectoryAndReturnResponse(Long directoryId, Long projectId) {
        lastResponse = step("API Шаг: Отправить DELETE-запрос на удаление папки с ID: " + directoryId, () ->
                given()
                        .spec(spec)
                        .pathParam("id", directoryId)
                        .queryParam("contextProjectId", projectId)
                        .when()
                        .delete("/directory/delete/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );
        return this;
    }



    public DirectorySteps verifyDeleteSuccess(String expectedMessage) {
        step("API Шаг: Проверить, что в ответе вернулось сообщение об успешном удалении", () -> {
            assertThat(lastResponse).as("Ответ сервера после удаления пустой").isNotNull();

            // Используем внутреннее поле lastResponse вместо локальной переменной deleteResponse
            assertThat(lastResponse.success())
                    .as("Сообщение об успешном удалении не совпадает")
                    .contains(expectedMessage);

            assertThat(lastResponse.error()).isNull();
        });
        return this; // Возвращаем ссылку на класс для возможности продолжения цепочки
    }

    //  Шаг редактирование папки (возвращает this)
    public DirectorySteps editDirectory(Long directoryId, String newName, String projectId, Long parentId) {
        DirectoryRequest editBody = DirectoryRequest.builder()
                .id(directoryId) // Передаем ID папки, которую хотим изменить
                .name(newName)
                .projectId(projectId)
                .parentDirectoryId(parentId)
                .build();

        lastResponse = step("API Шаг: Отправить PUT-запрос на редактирование директории с ID: " + directoryId, () ->
                given()
                        .spec(spec)
                        .queryParam("contextProjectId", projectId)
                        .body(editBody)
                        .when()
                        .put("/directory/edit")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );
        return this;
    }

    public DirectorySteps searchFileInDirectory(String fileName, Long currentDirectoryId, String projectId) {
        FileSearchRequest searchBody = FileSearchRequest.builder()
                .name(fileName)
                .currentDirectoryId(currentDirectoryId)
                .build();

        lastResponse = step("API Шаг: Найти файл '" + fileName + "' в директории ID: " + currentDirectoryId, () ->
                given()
                        .spec(spec)
                        .queryParam("contextProjectId", projectId)
                        .body(searchBody)
                        .when()
                        .post("/directory/file") // 👈 Вызов эндпоинта поиска из Swagger
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );
        return this;
    }

    public void verifyFoundFileName(String expectedFileName) {
        step("API Шаг: Проверить, что искомый файл присутствует в результатах поиска", () -> {
            assertThat(lastResponse.data()).as("Блок 'data' в ответе пустой").isNotNull();

            // Достаем список файлов из десериализованного ответа
            var files = lastResponse.data().filesInDirectory();

            assertThat(files)
                    .as("Список файлов в директории пустой, файл не был найден")
                    .isNotEmpty();

            // Проверяем, что хотя бы один файл в списке имеет искомое имя
            boolean isFileFound = files.stream()
                    .anyMatch(file -> file.name().equals(expectedFileName));

            assertThat(isFileFound)
                    .as("Файл с именем '" + expectedFileName + "' не найден в ответе сервера")
                    .isTrue();
        });
    }






    public void deleteDirectorySilently(Long directoryId, Long projectId) {
        step("Очистка данных: Удалить временную директорию с ID: " + directoryId, () ->
                given()
                        .spec(spec)
                        .pathParam("id", directoryId)
                        .queryParam("contextProjectId", projectId)
                        .when()
                        .delete("/directory/delete/{id}")
                        .then()
                        .log().ifValidationFails()
        );
    }


    // 🌟 НОВЫЙ ХЕЛПЕР: Возвращает полный объект ответа для тестов валидации
    public ResponseDirectoryDto createDirectoryAndReturnResponse(String name, String projectId, Long parentId) {
        DirectoryRequest body = DirectoryRequest.builder()
                .name(name)
                .projectId(projectId)
                .parentDirectoryId(parentId)
                .build();

        return step("API Шаг: Отправить POST-запрос на создание директории '" + name + "'", () ->
                given()
                        .spec(spec)
                        .queryParam("contextProjectId", projectId)
                        .body(body)
                        .when()
                        .post("/directory/create")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );
    }

    // Старый метод для теста удаления папки (пусть вызывает новый хелпер, чтобы не дублировать код!)
    public Long createTemporaryDirectory(String name, Long projectId, Long parentId) {
        return createDirectoryAndReturnResponse(name, String.valueOf(projectId), parentId).data().id();
    }


}


