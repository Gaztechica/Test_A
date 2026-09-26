package ar.soft.AT.API.Directory;

import ar.soft.AT.API.BaseApi.BaseTest;
import ar.soft.AT.API.BaseApi.Specification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FolderTests extends BaseTest {

//    @Test
//    public void createFolderSuccessTest() {
//        FolderRequest folderData = new FolderRequest("Новая Папка");
//
//        given()
//                .spec(requestSpec) // 👈 Цепочка: Передаем готовую спецификацию с токеном из BaseTest
//                .body(folderData)
//                .when()
//                .post("folders/create") // Отправляем запрос на эндпоинт
//                .then()
//                .spec(Specification.responseSpecOk200()) // 👈 Цепочка: Валидируем статус-код 200 через Specification
//                .body("status", equalTo("success"));    // Дополнительная проверка тела ответа
//    }

    @Test
    public void getFolderWithCustomUrlTest() {
        // Пример на случай, если одному тесту понадобился совершенно другой микросервис
        String alternativeUrl = "https://another-service.com";

        given()
                .spec(Specification.customSpec(alternativeUrl, "any_token")) // 👈 Кастомный вызов с ручным URL
                .when()
                .get("folders/list")
                .then()
                .spec(Specification.responseSpecOk200());
    }
}

