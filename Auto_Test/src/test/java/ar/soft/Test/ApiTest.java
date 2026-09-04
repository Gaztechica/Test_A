package ar.soft.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

//    ==================== тренировочный ===============================


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
