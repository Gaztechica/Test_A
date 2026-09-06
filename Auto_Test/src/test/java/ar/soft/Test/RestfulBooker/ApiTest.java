package ar.soft.Test.RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class ApiTest extends BasesTest {

//    ==================== тренировочный ===============================


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
                {"AUTH-012 | SQL-инъекций", "' OR '1'='1", "' OR '1'='1", 400, "reason", "Bad credentials"}
        };
    }

    @Test(dataProvider = "authMatrixProvider")
    public void testAuthEndpointMatrix(String testCaseName, Object username, Object password, int expectedStatusCode, String expectedJsonKey, String expectedJsonValue) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", password);

        var responseValidation = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("response-token.json"));

        if (expectedStatusCode == 200 && "NOT_NULL".equals(expectedJsonValue)) {
            responseValidation.body(matchesJsonSchemaInClasspath("response-token.json"));
        }

        if ("NOT_NULL".equals(expectedJsonValue)) {
            responseValidation.body(expectedJsonKey, is(notNullValue()));
        } else {
            responseValidation.body(expectedJsonKey, equalTo(expectedJsonValue));
        }
    }

    @DataProvider(name = "authMatrixProviderStatus")
    public Object[][] authMatrixProviderStatus() {
        return new Object[][]{
                // Тест-кейс | Логин | Пароль | Ожидаемый статус | Ключ в JSON | Значение в JSON

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
                {"AUTH-012 | SQL-инъекций", "' OR '1'='1", "' OR '1'='1", 400, "reason", "Bad credentials"}
        };
    }


    @Test(dataProvider = "authMatrixProviderStatus")
    public void testAuthEndpointMatrixStatus(String testCaseName, Object username, Object password, int expectedStatusCode, String expectedJsonKey, String expectedJsonValue) {

        // Динамическая сборка JSON-тела с сохранением типов данных
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", password);

        var responseValidation = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth")
                .then()
                // Проверяем статус-код динамически из DataProvider
                .statusCode(expectedStatusCode);

        if (expectedStatusCode == 200 && "NOT_NULL".equals(expectedJsonValue)) {
            responseValidation.body(matchesJsonSchemaInClasspath("response-token.json"));
        }

        // Динамическая проверка тела ответа
        if ("NOT_NULL".equals(expectedJsonValue)) {
            responseValidation.body(expectedJsonKey, is(notNullValue()));
        } else {
            responseValidation.body(expectedJsonKey, equalTo(expectedJsonValue));
        }
    }

    @Test(description = "Проверка защиты от SQL-инъекций")
    public void testSqlInjectionProtection(String username) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", "' OR '1'='1");
        payload.put("password", "' OR '1'='1");

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth")
                .then()
                // Система должна вернуть ошибку авторизации или валидации, но не 500 ошибку сервера
                .statusCode(anyOf(is(400), is(401)));
    }

    @Test(description = "Проверка защиты от SQL-инъекций")
    public void testSqlInjectionsProtection(String username) {

        given()
                .cookie("token", authToken)
                .when()
                .post("/auth")
                .then()
                // Система должна вернуть ошибку авторизации или валидации, но не 500 ошибку сервера
                .statusCode(anyOf(is(400), is(401)));
    }

    @Test(description = "Проверка отправки слишком длинного логина (граничные значения)")
    public void testLongUsernameBoundary() {

        // Генерируем строку в 500 символов
        String longUsername = "a".repeat(500);
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", longUsername);
        payload.put("password", "password123");


        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth")
                .then().log().all()
                // Сервер должен корректно ответить 400 Bad Request, а не упасть с ошибкой 500
                .statusCode(400)
                .body("message", containsString("превышает допустимую длину"));
    }

    @Test(dataProvider = "authMatrixProvider")
    public void AuthEndpointMatrixTest(String testCaseName, Object username, Object password, String expectedJsonKey, String expectedJsonValue) {

        // Динамическая сборка JSON-тела с сохранением типов данных
        Map<String, Object> payload = new HashMap<>();
        payload.put("username", username);
        payload.put("password", password);

        // Получаем объект валидации ответа
        ValidatableResponse responseValidation = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth")
                .then()
                .statusCode(200) // Особенность архитектуры Restful-Booker: всегда возвращает 200
                .contentType(ContentType.JSON);

        // ПРАВИЛЬНО: Переприсваиваем или вызываем методы на объекте валидации
        // Проверка ожидаемого контента в зависимости от тест-кейса
        if ("NOT_NULL".equals(expectedJsonValue)) {
            responseValidation.body(expectedJsonKey, is(notNullValue()));
        } else {
            // Преобразуем значение, если это boolean или число (опционально, зависит от вашего DataProvider)
            Object targetValue = expectedJsonValue;
            if ("true".equalsIgnoreCase(expectedJsonValue)) targetValue = true;
            if ("false".equalsIgnoreCase(expectedJsonValue)) targetValue = false;

            responseValidation.body(expectedJsonKey, equalTo(targetValue));
//                1. Контекст: Что такое responseValidation?Когда мы написали:javaValidatableResponse responseValidation = given()....then().statusCode(200);
//Используйте код с осторожностью.Мы сохранили «инструмент валидации» в переменную. Этот объект помнит всё о пришедшем ответе сервера. Чтобы запустить проверку конкретного поля, нам нужно вызвать метод .body() именно у этого объекта.В вашем исходном коде вызов responseValidation.body(...) висел «в воздухе». В исправленном варианте строка responseValidation.body(...) принудительно активирует механизм проверки RestAssured для сохраненного ответа.2. Построчный разбор кодаСтрока 1: Условие для проверки на "не пустоту"javaif ("NOT_NULL".equals(expectedJsonValue)) {
//Используйте код с осторожностью.Что делает: Проверяет, пришло ли из вашего DataProvider специальное ключевое слово "NOT_NULL" в качестве ожидаемого значения.Зачем это нужно: Бывают ситуации (например, при успешной авторизации), когда сервер генерирует динамический токен (например, "token": "63bc9942a412"). Мы не можем предугадать точный текст токена в DataProvider, но мы хотим убедиться, что сервер вообще прислал этот ключ и он не пустой.Строка 2: Сама проверка на Not Nulljava    responseValidation.body(expectedJsonKey, is(notNullValue()));
//}
//Используйте код с осторожностью.Что делает: Если условие выполнено, мы берем имя ключа (например, "token") и с помощью Hamcrest-матчеров is(notNullValue()) проверяем, что в JSON-ответе это поле существует и его значение не равно null.Строка 3: Блок else (если мы ждем конкретное значение)javaelse {
//Используйте код с осторожностью.Что делает: Срабатывает во всех остальных случаях, когда в DataProvider указано конкретное ожидаемое значение (например, "Bad credentials", "true", "false" и т.д.).Строки 4–7: Решение проблемы с типами данных (String vs Boolean/Number)java    Object targetValue = expectedJsonValue;
//    if ("true".equalsIgnoreCase(expectedJsonValue)) targetValue = true;
//    if ("false".equalsIgnoreCase(expectedJsonValue)) targetValue = false;
//Используйте код с осторожностью.В чем проблема: Из DataProvider в переменную expectedJsonValue часто все значения передаются как обычные строки (тип String), например "true" или "false". Однако, если сервер restful-booker вернет валидный JSON с настоящим логическим типом: {"success": true} (без кавычек), то для Java это тип Boolean.Что делает этот код: Мы создаем переменную универсального типа Object targetValue. Если в строке написано "true", мы превращаем её в настоящий Boolean (true). Если написано "false" — в false.Зачем это нужно: Если этого не сделать, то проверка equalTo("true") (сравнение строки "true" и булевого значения true) всегда будет падать, выдавая ошибку: Expected: "true" but was: true.Строка 8: Финальная проверка значенияjava    responseValidation.body(expectedJsonKey, equalTo(targetValue));
//}
//Используйте код с осторожностью.Что делает: Вызывает у объекта валидации метод .body(). Он берет переданный ключ (например, "reason") и сверяет его значение из JSON-ответа со значением targetValue (которое мы только что подготовили и очистили от проблем с типами). Если они не совпадают, RestAssured прерывает тест и выбрасывает AssertionError.
        }
    }


    @Test
    public void GetUsersListWithQueryParamAndValidateSchemaTest() {
        RestAssured.baseURI = "https://reqres.in";

        given()
                .queryParam("page", 2)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users")
                .then().log().all()
                .statusCode(200)
                .body("page", equalTo(2))
                .body(matchesJsonSchemaInClasspath("users-short-schema.json"));
    }


    @Test
    public void createUserAndValidateSchemaTest() {
        RestAssured.baseURI = "https://reqres.in";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON).log().all()
                .body(matchesJsonSchemaInClasspath("response-schema.json"));
    }


    @Test
    public void testCreateUserAndValidateSchema() {
        // 1. Указываем базовый URL для Rest Assured
        RestAssured.baseURI = "https://reqres.in";

        // 2. Формируем тело запроса
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");

        // 3. Выполняем запрос и проверяем ответ
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201) // Проверка статус-кода 201 Created
                .contentType(ContentType.JSON) // Проверка типа контента
                // Проверка схемы из папки ресурсов (src/test/resources)
                .body(matchesJsonSchemaInClasspath("response-schema.json"));
    }


    @Test
    public void testGetUsersListWithQueryParamAndValidateSchema() {
        // Указываем базовый URI для Rest Assured
        RestAssured.baseURI = "https://reqres.in";

        given()
                // Передаем query-параметр page=2
                .queryParam("page", 2)
                .contentType(ContentType.JSON)
                .when()
                // Выполняем GET-запрос на эндпоинт
                .get("/api/users")
                .then().log().all()
                // Проверяем статус-код ответа (200 OK)
                .statusCode(200)
                // Опционально: проверяем, что в ответе вернулась именно запрашиваемая страница 2
                .body("page", equalTo(2))
                // Валидация JSON-схемы из папки ресурсов (src/test/resources)
                .body(matchesJsonSchemaInClasspath("users-short-schema.json"));
    }


    private static class Pokemon {
        public String name;
        public String url;

        public Pokemon() {
        }

        public Pokemon(String name, String url) {
            this.name = name;
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pokemon pokemon = (Pokemon) o;
            return Objects.equals(name, pokemon.name) && Objects.equals(url, pokemon.url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, url);
        }
    }

    private static class Pokemons {
        public int count;
        public String next;
        public String previous;
        public List<Pokemon> results;
    }


//    @Test
//    public void httpTest() throws IOException, ParseException {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon");
//
//            request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
//
//            try (CloseableHttpResponse response = httpClient.execute(request)) {
//                Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
//
//                Assert.assertEquals(response.getCode(), 200);
//
//                HttpEntity entity = response.getEntity();
//                Assert.assertNotNull(entity);
//
////                 simple check
//                String jsonString = EntityUtils.toString(entity);
//                Assert.assertTrue(jsonString.startsWith("{\"count\":1292"));
//
//                // regular check
//                Pokemons pokemons = new Gson().fromJson(jsonString, Pokemons.class);
//                Assert.assertEquals(pokemons.count, 1302);
//                Assert.assertEquals(pokemons.results.size(), 20);
//            }
//        }
//    }

    @Test
    public void restAssuredTest() {
        RestAssured.when().get("https://pokeapi.co/api/v2/pokemon")
                .then().log().all()
                .statusCode(200);
//                .body("count", Matchers.equalTo(1302),
//                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
    }

    @Test
    public void restAssured2Test() {
        RestAssured.when().post("http://62.113.97.50:8081/account/login")
                .then()
                .statusCode(200)
                .body("count", Matchers.equalTo(1302),
                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
    }

    @Test
    public void restAssured2Test6() {
        RestAssured.when().post("https://pokeapi.co/docs/v2/66")
                .then().log().all()
                .statusCode(200);
//                .body("count", Matchers.equalTo(1302),
//                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
    }

//    @Test

//    public void testShadowDOM() {
//
//        getDriver().get("http://uitestingplayground.com/shadowdom");
//
//
//
//        WebElement shadowHost = getDriver().findElement(By.tagName("guid-generator"));
//
//        SearchContext shadowRoot = shadowHost.getShadowRoot();
//
//        WebElement shadowContent = shadowRoot.findElement(By.id("buttonGenerate"));
//
//
//
//        shadowContent.click();
//
//
//
//        WebElement shadowHost2 = getDriver().findElement(By.tagName("guid-generator"));
//
//        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
//
//
//
//        System.out.println(shadowRoot2.findElement(By.cssSelector("#editField div")).getText());
//
//
//
//    }
}
