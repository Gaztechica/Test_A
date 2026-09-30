package ar.soft.AT.API.tests;

import ar.soft.AT.API.BaseApi.apiBaseTest.BaseTest;
import ar.soft.AT.API.models.director.response.ResponseDirectoryDto;
import ar.soft.AT.API.steps.DirectorySteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты API управления директориями")
public class DirectoryTests extends BaseTest {

    private final Long contextProjectId = 893L;
    private Long idToDelete;

    @Test
    @DisplayName("Успешное создание новой директории в корне проекта")
    public void createNewDirectoryAndValidateResponseTest() {
        String contextProjectId = "893";
        String expectedName = "Папка будущего";
        Long parentDirectoryId = 1413L;

        new DirectorySteps(requestSpec)
                .createDirectory(expectedName, contextProjectId, parentDirectoryId)
                .verifyMetadataSuccess()
                .verifyDirectoryContent(expectedName, Long.parseLong(contextProjectId));
    }

    @Test
    @DisplayName("Успешное редактирование названия директории")
    public void editDirectorySuccessTest() {
        String newFolderName = "Отредактированная папка";
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 1. Создаем временную папку через хелпер и запоминаем её ID
        idToDelete = directorySteps.createTemporaryDirectory("Папка для редактирования", contextProjectId, 1413L);

        // 2. Запускаем цепочку редактирования и проверок
        directorySteps
                .editDirectory(idToDelete, newFolderName, "893", 1413L) // Меняем имя
                .verifyUpdatedSuccess() // Базовая проверка (что ответ успешный)
                .verifyDirectoryContent(newFolderName, contextProjectId); // Проверяем, что имя изменилось на новое
    }

    @Test
    @DisplayName("Успешное удаление созданной директории")
    public void createAndThenDeleteDirectorySuccessTest() {
        // 1. Инициализируем степы
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 2. Создаем временную папку и сохраняем её ID
        Long targetId = directorySteps.createTemporaryDirectory("Папка для удаления", contextProjectId, 1413L);

        // 3. Вызываем цепочку удаления и проверки одной строчкой!
        directorySteps
                .deleteDirectoryAndReturnResponse(targetId, contextProjectId)
                .verifyDeleteSuccess("object deleted");
    }

//    @AfterEach
//    public void tearDown() {
//        // 👇 Этот метод выполнится ВСЕГДА после окончания теста (упал он или прошел)
//        if (idToDelete != null) {
//            DirectorySteps directorySteps = new DirectorySteps(requestSpec);
//            directorySteps.deleteDirectorySilently(idToDelete, contextProjectId);
//        }
//    }

    @Test
    @DisplayName("Успешная загрузка бинарного файла через Multipart Form Data")
    public void uploadFileSuccessTest() {

        File testFile = new File("src/test/resources/test_document.xlsx");
        var multipartSpec = requestSpec.given().contentType(io.restassured.http.ContentType.MULTIPART);
        new DirectorySteps(multipartSpec)
                .addFileDirectory(testFile, 2250L, 893L)
                .verifyUpdatedSuccess();
    }

    @Test
    @DisplayName("Успешный поиск файла по имени в текущей директории")
    public void searchFileInDirectorySuccessTest() {
        String targetFileName = "test_document.xlsx";
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        directorySteps
                .searchFileInDirectory(targetFileName, null, 1413L)
                .verifySuccess()
                .verifySearchFileName(targetFileName);
    }

    @Test
    @DisplayName("Успешное редактирование названия file")
    public void editFileSuccessTest() {
        String newFileName = "Отредактированная папка";
        java.io.File testFile = new java.io.File("src/test/resources/test_document.xlsx");
        var multipartSpec = requestSpec.given().contentType(io.restassured.http.ContentType.MULTIPART);
        new DirectorySteps(multipartSpec);
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // Вызываем хелпер и сохраняем ID файла в переменную
        Long uploadedFileId = directorySteps.addFileDirectoryAndReturnId(testFile, 1413L, 893L);

        directorySteps
                .editFileDirectory(uploadedFileId, newFileName, 1413L, 893L)
                .verifyUpdatedSuccess();
    }




    @Test
    @DisplayName("Успешное создание новой директории в корне проекта")
    public void createNewDirectoryValidateResponseTest() {
        String contextProjectId = "893";
        String expectedName = "Папка будущего";
        Long parentDirectoryId = 1413L;

        // 1. Инициализируем слой хелперов
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 2. Вызываем создание папки одной строчкой через хелпер
        ResponseDirectoryDto response = directorySteps.createDirectoryAndReturnResponse(
                expectedName,
                contextProjectId,
                parentDirectoryId
        );

        // 3. Проверки бизнес-данных в стиле Fluent Assertions (AssertJ)
        step("Проверить структуру и данные в ответе сервера", () -> {
            assertThat(response.getSuccess()).isEqualTo("object has been added to the catalog");
            assertThat(response.getError()).isNull();

            assertThat(response.getData())
                    .as("Объект 'data' в ответе не должен быть пустым")
                    .isNotNull();

            if (response.getData() != null) {
                assertThat(response.getData().getName()).isEqualTo(expectedName);
                assertThat(response.getData().getProjectId()).isEqualTo(893L);
            }
        });
    }
//            assertThat(response.data().name()).isEqualTo(expectedName);
//            assertThat(response.data().projectId()).isEqualTo(893L);
////            assertThat(response.data().projectId()).isEqualTo(contextProjectId);
//            assertThat(response.data().filesInDirectory()).isEmpty(); // Ожидаем, что новая папка пустая

    @Test
    @DisplayName("Успешное удаление созданной директории")
    public void createThenDeleteDirectorySuccessTest() {
        Long contextProjectId = 893L;

        // 1. Инициализируем слой степов, передавая requestSpec из BaseTest
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 2. Пользуемся изолированным хелпером (создает папку и возвращает её ID)
        Long targetId = directorySteps.createTemporaryDirectory("Папка для удаления", 893L, 1413L);

        // 3. Шаг удаления этой же папки по её ID (используем targetId)
        ResponseDirectoryDto deleteResponse = step("Отправить DELETE-запрос на удаление папки с ID: " + targetId, () ->
                given()
                        .spec(requestSpec)
                        .pathParam("id", targetId) // 👈 Подставляем ID, полученный из хелпера
                        .queryParam("contextProjectId", contextProjectId)
                        .when()
                        .delete("/directory/delete/{id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ResponseDirectoryDto.class)
        );

        // 4. Проверка бизнес-логики ответа после удаления
        step("Проверить, что в ответе вернулось сообщение об успешном удалении", () -> {
            assertThat(deleteResponse.getSuccess()).contains("object deleted"); // Подстройте под реальный ответ бэка
            assertThat(deleteResponse.getError()).isNull();
        });
    }

    @Test
    @DisplayName("Успешное удаление созданной директории")
    public void deleteDirectorySuccessTest() {
        Long contextProjectId = 893L;

        // 1. Инициализируем слой хелперов
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 2. Создаем временную папку через первый хелпер и получаем её ID
        Long targetId = directorySteps.createTemporaryDirectory("Папка для удаления", contextProjectId, 1413L);

        // 3. Удаляем созданную папку через второй хелпер одной строчкой
        DirectorySteps deleteResponse = directorySteps.deleteDirectoryAndReturnResponse(targetId, contextProjectId);

        // 4. Проверка бизнес-логики ответа после удаления
//        step("Проверить, что в ответе вернулось сообщение об успешном удалении", () -> {
//            // Если тест упадет, мы увидим реальное сообщение в консоли
//            assertThat(deleteResponse.success()).contains("object deleted");
//            assertThat(deleteResponse.error()).isNull();
//        });
    }

}

