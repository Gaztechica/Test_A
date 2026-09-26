package ar.soft.AT.API.tests;

import ar.soft.AT.API.BaseApi.BaseTest;
import ar.soft.AT.API.models.director.response.ResponseDirectoryDto;
import ar.soft.AT.API.steps.DirectorySteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        String contextProjectId = "892";
        String expectedName = "Папка будущего";
        Long parentDirectoryId = 1413L;

        // Инициализируем и запускаем непрерывную Fluent-цепочку
        new DirectorySteps(requestSpec)
                .createDirectory(expectedName, contextProjectId, parentDirectoryId)
                .verifyMetadataSuccess()
                .verifyDirectoryContent(expectedName, 893L);
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
                .verifyEditMetadataSuccess() // Базовая проверка (что ответ успешный)
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
    @DisplayName("Успешный поиск файла по имени в текущей директории")
    public void searchFileInDirectorySuccessTest() {
        String targetFileName = "test_document.pdf";
        DirectorySteps directorySteps = new DirectorySteps(requestSpec);

        // 1. Предусловие: Создаем целевую временную папку
        idToDelete = directorySteps.createTemporaryDirectory("Папка для поиска файлов", contextProjectId, 1413L);

        // 2. Действие и комплексная Fluent-проверка одной строчкой
        directorySteps
                .searchFileInDirectory(targetFileName, idToDelete, "893")
                .verifyMetadataSuccess()
                .verifyFoundFileName(targetFileName); // 👈 Добавили строгую проверку контента!
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
            assertThat(response.success()).isEqualTo("object has been added to the catalog");
            assertThat(response.error()).isNull();

            assertThat(response.data())
                    .as("Объект 'data' в ответе не должен быть пустым")
                    .isNotNull();

            if (response.data() != null) {
                assertThat(response.data().name()).isEqualTo(expectedName);
                assertThat(response.data().projectId()).isEqualTo(893L);
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
            assertThat(deleteResponse.success()).contains("object deleted"); // Подстройте под реальный ответ бэка
            assertThat(deleteResponse.error()).isNull();
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

