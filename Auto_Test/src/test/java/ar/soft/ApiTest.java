package ar.soft;

import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class ApiTest {

//    ==================== тренировочный ===============================
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
                .then()
                .statusCode(200)
                .body("count", Matchers.equalTo(1302),
                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
    }

    @Test
    public void restAssured2Test() {
        RestAssured.when().post("http://23.105.246.172:5000/login")
                .then()
                .statusCode(200)
                .body("count", Matchers.equalTo(1302),
                        "results.name", Matchers.hasItems("bulbasaur", "ivysaur"));
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
