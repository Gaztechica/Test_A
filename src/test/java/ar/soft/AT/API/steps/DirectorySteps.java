package ar.soft.AT.API.steps;

import ar.soft.AT.API.models.director.request.DirectoryRequest;
import ar.soft.AT.API.models.director.request.FileSearchRequest;
import ar.soft.AT.API.models.director.response.FileDto;
import ar.soft.AT.API.models.director.response.ResponseDirectoryDto;
import io.restassured.specification.RequestSpecification;

import java.io.File;

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
//        DirectoryRequest body = DirectoryRequest.builder()
//                .name(name)
//                .projectId(Long.parseLong(projectId))
//                .parentDirectoryId(parentId)
//                .build();
//
//        lastResponse = step("API Шаг: Отправить POST-запрос на создание директории '" + name + "'", () ->
//                given()
//                        .queryParam("contextProjectId", projectId)
//                        .body(body)
        // 1. Оставляем Allure-шаг, но убираем лишний .spec(spec) и скрываем объявление переменной body
        lastResponse = step("API Шаг: Отправить POST-запрос на создание директории '" + name + "'", () ->
                given()
                        .queryParam("contextProjectId", projectId) // Чистый Long
                        .body(DirectoryRequest.builder()
                                .name(name)
                                .projectId(Long.parseLong(projectId))
                                .parentDirectoryId(parentId)
                                .build())
                        .when()
                        .post("/directory/create")
                        .then()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );
        return this; // 👈 Магия Fluent Interface
    }

    public DirectorySteps addFileDirectory(File file, Long directoryId, Long contextProjectId) {

        lastResponse = step("API Шаг: Загрузить файл '" + file.getName() + "' в директорию ID: " + directoryId, () ->
                given()
                        .queryParam("directoryId", directoryId)
                        .queryParam("contextProjectId", contextProjectId)
                        // загружаем бинарный файл в Form data
                        // Первый параметр "files" — это имя ключа, второй — сам объект файла
                        .multiPart("files", file)
                        .when()
                        .post("/directory/files")
                        .then().log().all()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );
        return this;
    }

    // 2. Шаг проверки общих метаданных (возвращает this)
    public DirectorySteps verifyMetadataSuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
            assertThat(lastResponse.getSuccess()).isEqualTo("object has been added to the catalog");
            assertThat(lastResponse.getError()).isNull();
        });
        return this;
    }

    public DirectorySteps verifySuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
            assertThat(lastResponse.getSuccess()).isEqualTo("found");
            assertThat(lastResponse.getError()).isNull();
        });
        return this;
    }

    public DirectorySteps verifyUpdatedSuccess() {
        step("API Шаг: Проверить успешный статус операции в ответе", () -> {
            assertThat(lastResponse).as("Ответ сервера пустой").isNotNull();
            assertThat(lastResponse.getSuccess()).isEqualTo("updated");
            assertThat(lastResponse.getError()).isNull();
        });
        return this;
    }

    // 3. Шаг проверки контента созданной папки (возвращает void или очередной класс степов)
    public void verifyDirectoryContent(String expectedName, Long expectedProjectId) {
        step("API Шаг: Проверить соответствие данных созданной папки", () -> {
            assertThat(lastResponse.getData())
                    .as("Объект 'data' не должен быть null")
                    .isNotNull();

            if (lastResponse.getData() != null) {
                assertThat(lastResponse.getData().getName()).isEqualTo(expectedName);
                assertThat(lastResponse.getData().getProjectId()).isEqualTo(expectedProjectId);
            }
        });
    }

    public DirectorySteps deleteDirectoryAndReturnResponse(Long directoryId, Long projectId) {
        lastResponse = step("API Шаг: Отправить DELETE-запрос на удаление папки с ID: " + directoryId, () ->
                given()
                        .pathParam("id", directoryId)
                        .queryParam("contextProjectId", projectId)
                        .when()
                        .delete("/directory/delete/{id}")
                        .then()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );
        return this;
    }

    public DirectorySteps verifyDeleteSuccess(String expectedMessage) {
        step("API Шаг: Проверить, что в ответе вернулось сообщение об успешном удалении", () -> {
            assertThat(lastResponse).as("Ответ сервера после удаления пустой").isNotNull();

            // Используем внутреннее поле lastResponse вместо локальной переменной deleteResponse
            assertThat(lastResponse.getSuccess())
                    .as("Сообщение об успешном удалении не совпадает")
                    .contains(expectedMessage);

            assertThat(lastResponse.getError()).isNull();
        });
        return this; // Возвращаем ссылку на класс для возможности продолжения цепочки
    }

    //  Шаг редактирование папки (возвращает this)
    public DirectorySteps editDirectory(Long directoryId, String newName, String projectId, Long parentId) {

        lastResponse = step("API Шаг: Отправить PUT-запрос на редактирование директории с ID: " + directoryId, () ->
                given()
                        .queryParam("contextProjectId", projectId)
                        .body(DirectoryRequest.builder()
                                .id(directoryId) // Передаем ID папки, которую хотим изменить
                                .name(newName)
                                .projectId(Long.parseLong(projectId))
                                .parentDirectoryId(parentId)
                                .build())
                        .when()
                        .put("/directory/edit")
                        .then()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );
        return this;
    }

    // Убираем newDirectoryId — оставляем только то, что реально уходит в сеть
    public DirectorySteps editFileDirectory(Long id, String name, Long currentDirectoryId, Long contextProjectId) {

        FileDto requestBody = FileDto.builder()
                .id(id)
                .name(name)
                .currentDirectoryId(currentDirectoryId)
                .build();

        lastResponse = step("API Шаг: PUT-запрос на редактирование файла с ID: " + id, () ->
                given()
                        .contentType(io.restassured.http.ContentType.JSON)
                        .queryParam("contextProjectId", contextProjectId) // Передаем 893L
                        .body(requestBody)
                        .when()
                        .put("/directory/file")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );

        return this;
    }



    public DirectorySteps searchFileInDirectory(String fileName, Long newDirectoryId, Long currentDirectoryId) {
        FileSearchRequest searchBody = FileSearchRequest.builder()
                .name(fileName)
                .newDirectoryId(newDirectoryId)
                .currentDirectoryId(currentDirectoryId)
                .build();

        lastResponse = step("API Шаг: Найти файл '" + fileName + "' в директории ID: " + currentDirectoryId, () ->
                        given()
//                        .spec(spec)
                                .queryParam("contextProjectId", currentDirectoryId)
                                .body(searchBody)
                                .when()
                                .post("/directory/file")
                                .then()
                                .statusCode(200)
                                .extract().as(ResponseDirectoryDto.class)
        );
        return this;
    }

    public void verifyFoundFileName(String expectedFileName) {
        step("API Шаг: Проверить, что искомый файл присутствует в результатах поиска", () -> {
            assertThat(lastResponse.getData()).as("Блок 'data' в ответе пустой").isNotNull();

            // Достаем список файлов из десериализованного ответа
            var files = lastResponse.getData().getFilesInDirectory();

            assertThat(files)
                    .as("Список файлов в директории пустой, файл не был найден")
                    .isNotEmpty();

            // Проверяем, что хотя бы один файл в списке имеет искомое имя
            boolean isFileFound = files.stream()
                    .anyMatch(file -> file.getName().equals(expectedFileName));

            assertThat(isFileFound)
                    .as("Файл с именем '" + expectedFileName + "' не найден в ответе сервера")
                    .isTrue();
        });
    }

    public void verifySearchFileName(String expectedFileName) {
        step("API Шаг: Проверить, что искомый файл присутствует в результатах поиска", () -> {
            assertThat(lastResponse.getData()).as("Блок 'data' в ответе пустой").isNotNull();
            var files = lastResponse.getData().getFilesInDirectory();

            // Извлекаем из каждого рекорда File поле name() и проверяем, что в полученном списке строк есть наше имя
            assertThat(files)
                    .extracting(file -> file.getName()) // или File::name, если это ссылка на метод рекорда
                    .as("Файл с именем '" + expectedFileName + "' не найден в ответе сервера")
                    .contains(expectedFileName);
        });
    }


    //для pojo
//    public void verifyFoundFileName(String expectedFileName) {
//        step("API Шаг: Проверить, что искомый файл присутствует в результатах поиска", () -> {
//            // 1. Проверяем, что корневой объект данных не null (используем геттер .getData())
//            assertThat(lastResponse.getData())
//                    .as("Блок 'data' в ответе пустой")
//                    .isNotNull();
//
//            // 2. Достаем список файлов из POJO-ответа (используем геттер .getFilesInDirectory())
//            var files = lastResponse.getData().getFilesInDirectory();
//
//            // 3. Извлекаем из каждого объекта File поле name через геттер и проверяем наличие
//            assertThat(files)
//                    // Ссылка на стандартный геттер класса-файла
//                    .extracting(FilePojo::getName)
//                    .as("Файл с именем '%s' не найден в ответе сервера", expectedFileName)
//                    .contains(expectedFileName);
//        });
//    }

    public void deleteDirectorySilently(Long directoryId, Long projectId) {
        step("Очистка данных: Удалить временную директорию с ID: " + directoryId, () ->
                given()
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

        return step("API Шаг: Отправить POST-запрос на создание директории '" + name + "'", () ->
                given()
                        .queryParam("contextProjectId", projectId)
                        .body(DirectoryRequest.builder()
                                .name(name)
                                .projectId(Long.parseLong(projectId))
                                .parentDirectoryId(parentId)
                                .build())
                        .when()
                        .post("/directory/create")
                        .then()
                        .statusCode(200)
                        .extract().as(ResponseDirectoryDto.class)
        );
    }

    // Старый метод для теста удаления папки (пусть вызывает новый хелпер, чтобы не дублировать код!)
    public Long createTemporaryDirectory(String name, Long projectId, Long parentId) {
        return createDirectoryAndReturnResponse(name, String.valueOf(projectId), parentId).getData().getId();
    }

    public Long addFileDirectoryAndReturnId(java.io.File file, Long directoryId, Long contextProjectId) {
        // 1. Вызываем метод загрузки файла
        addFileDirectory(file, directoryId, contextProjectId);

        // 2. ИСПРАВЛЕНО: Достаем список, берем первый элемент (.get(0)) и получаем его ID
        return lastResponse.getData().getFilesInDirectory().get(0).getId();


    }
}


