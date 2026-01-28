package ar.soft.api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;

public class TestApi2 {

// mvn clean test -Dtest=LastfmApiTest
// https://www.last.fm

    // многопоточный запукс тестов - аннатация @Execution
    @Execution(ExecutionMode.CONCURRENT)
    public class LastfmApiTest {

        //точка входа (эндпоинт) сервиса api - URL открытых api
        private final String URL = "http://ws.audioscrobbler.com/2.0/";
        //токен для получения данных по api
        private final String APIKEY = "c9d0508134290432816a16a773a83448";

        // Кейс 1. Получение данных атристов и проверка плученного имени артиста в body
        @ParameterizedTest //параметризованный тест - аннатация @ParameterizedTest
        @MethodSource("dataForGetCharacterByArtistNameAndCheckArtistName")
        //генератор / поставщик тестовых данных для параметризованного теста
        // отправка запроса данных и получение ответа
        public void getCharacterByArtistNameAndCheckArtistName(String expectedName) {
            RestAssured // библиотека RestAssured  - создание запроса к api
                    .given() // метод определяет, что будет отправлено в запросе
                    .log().uri() // вывод логов URL
                    .when() // метод  оппределяет с каким методом и на какой эндпоинт отправляем запрос
                    .get(URL + "?method=artist.getSimilar&artist=cher&api_key=" + APIKEY + "&format=json")
                    .then() // метод определяет как проверяется пришедший ответ
                    .log().status() //вывод логов статуса ответа сервера
                    .log().body() // вывод логов телла ответа сервера
                    .spec(
                            new ResponseSpecBuilder()
                                    .expectStatusCode(200)
                                    .expectBody("similarartists.artist[2].name", equalTo(expectedName))
                                    .build()
                    );// спецификации  статус кода и тела ответа сервера. проверка тела ответа на соответсвие
        }

        // Генератор тестовых данных для @MethodSource("dataForGetCharacterByArtistNameAndCheckArtistName")
        private static Stream<Arguments> dataForGetCharacterByArtistNameAndCheckArtistName() {
            return Stream.of(
                    Arguments.of("Kylie Minogue", "Kylie Minogue")
            );
        }

        // Кейс 2. Получение данных атристов и проверка плученного URL артиста в body
        @ParameterizedTest //параметризованный тест - аннатация @ParameterizedTest
        @MethodSource("dataForGetCharacterByArtistUrlAndCheckArtistUrl")
        //генератор / поставщик тестовых данных для параметризованного теста
        // отправка запроса данных и получение ответа
        public void getCharacterByArtistUrlAndCheckArtistURL(String expectedUrl) {
            RestAssured // библиотека RestAssured  - создание запроса к api
                    .given() // метод определяет, что будет отправлено в запросе
                    .log().uri() // вывод логов URL
                    .when() // метод  оппределяет с каким методом и на какой эндпоинт отправляем запрос
                    .get(URL + "?method=artist.getSimilar&artist=cher&api_key=" + APIKEY + "&format=json")
                    .then() // метод определяет как проверяется пришедший ответ
                    .log().status() //вывод логов статуса ответа сервера
                    .log().body() // вывод логов телла ответа сервера
                    .spec(
                            new ResponseSpecBuilder()
                                    .expectStatusCode(200)
                                    .expectBody("similarartists.artist[2].url", equalTo(expectedUrl))
                                    .build()
                    );// спецификации  статус кода и тела ответа сервера. проверка тела ответа на соответсвие
        }

        // Генератор тестовых данных для @MethodSource("dataForGetCharacterByArtistUrlAndCheckArtistUrl")
        private static Stream<Arguments> dataForGetCharacterByArtistUrlAndCheckArtistUrl() {
            return Stream.of(
                    Arguments.of("https://www.last.fm/music/Kylie+Minogue", "url")
            );
        }
    }
}
