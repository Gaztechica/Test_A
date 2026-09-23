package ar.soft.AT.API.Autorisation;

import ar.soft.AT.API.BaseApi.ConfigReader;
import ar.soft.AT.API.BaseApi.LoginRequests;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthorizationApiTest {

    @Story("Получить логи всех аккаунтов")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void authorizationTest() {
//        Specification.intransSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
//        LoginReguest loginReguest = new LoginReguest(PASSWORD, EMAIL);
        LoginRequests loginRequests = new LoginRequests(
                ConfigReader.get("auth.email"),
                ConfigReader.get("auth.password")
        );
    }

    @DataProvider(name = "authMatrixProvider")
    public Object[][] authMatrixProvider() {
        return new Object[][]{

                // 1. Эквивалентный разбиения
                {"AUTH-001 | Валидные креды", "admin", "password123", 200, "token", "NOT_NULL"},
                {"AUTH-002 | Невалидный login", "wrong_admin", "password123", 401, "reason", "Bad credentials"},
                {"AUTH-003 | Невалидный password", "admin", "wrong_pass", 401, "reason", "Bad credentials"},
//
                // 3. Граничные значения
                {"AUTH-004 | Пустой username", "", "password123", 400, "reason", "Bad credentials"},
                {"AUTH-005 | Пустой password", "admin", "", 400, "reason", "Bad credentials"},
                {"AUTH-006 | длинное username", "a".repeat(1000), "password123", 400, "reason", "Bad credentials"},

                // 4. Попарное тестирование аномальных типов данных
                {"AUTH-007 | Username равен null", null, "password123", 400, "reason", "Bad credentials"},
                {"AUTH-008 | Password равен null", "admin", null, 400, "reason", "Bad credentials"},
                {"AUTH-009 | Username типа Integer", 12345, "password123", 400, "reason", "Bad credentials"},
                {"AUTH-010 | Password типа Boolean", "admin", true, 400, "reason", "Bad credentials"},
                {"AUTH-011 | Username и Password типа массива", "[admin]", "[password123]", 400, "reason", "Bad credentials"},
                {"AUTH-012 | SQL-инъекций", "' OR '1'='1", "' OR '1'='1", 400, "reason", "Bad credentials"},
                {"AUTH-013 | XSS-инъекция в логине", "<script>alert(1)</script>", "' OR '1'='1", 400, "reason", "Bad credentials"},
                {"AUTH-014 | Неверный регистр логина", "ADMIN", "password123", 401, "reason", "Bad credentials"},
                {"AUTH-015 | Пропущено поле password", "admin", 401, "reason", "Bad credentials"}
        };


//    @Test(description = "AUTH-001 - AUTH-015", dataProvider = "authMatrixProvider")
//    public void testAuthEndpointMatrix(String testCaseName, Object username, Object password, int expectedStatusCode, String expectedJsonKey, String expectedJsonValue) {
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("username", username);
//        payload.put("password", password);
//
//        var responseValidation = given(requestSpec)
//                .body(payload)
//                .when()
//                .post("/auth")
//                .then()
//                .statusCode(expectedStatusCode)
//                .body(matchesJsonSchemaInClasspath("response-token.json"));
//
//        if (expectedStatusCode == 200 && "NOT_NULL".equals(expectedJsonValue)) {
//            responseValidation.body(matchesJsonSchemaInClasspath("response-token.json"));
//        }
//        if ("NOT_NULL".equals(expectedJsonValue)) {
//            responseValidation.body(expectedJsonKey, is(notNullValue()));
//        } else {
//            responseValidation.body(expectedJsonKey, equalTo(expectedJsonValue))
//            ;
//        }
    }

//    @Test(description = "AUTH-016 Проверка  Неверный HTTP-метод GET")
//    public void testInvalidMethodGet() {
//
//        given(requestSpec)
//                .when()
//                .get("/auth")
//                .then()
//                .statusCode(anyOf(is(400), is(405)));
//    }
//
//    @Test(description = "AUTH-017 Проверка на неверный заголовок Content-Type text/plain")
//    public void testInvalidContentType() {
//
//        given()
//                .contentType(ContentType.TEXT)
//                .when()
//                .post("/auth")
//                .then()
//                .statusCode(500);
//    }
//
//    @Test(description = "Проверка отправки слишком длинного логина (граничные значения)")
//    public void testLongUsernameBoundary() {
//
//        String longUsername = "a".repeat(500);
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("username", longUsername);
//        payload.put("password", "password123");
//
//        given(requestSpec)
//                .body(payload)
//                .when()
//                .post("/auth")
//                .then().log().all()
//                .statusCode(400)
//                .body("message", containsString("превышает допустимую длину"));
//    }
}
