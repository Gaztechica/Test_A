package ar.soft.api;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import java.util.stream.Stream;
import static org.hamcrest.Matchers.equalTo;

public class TestApi {

    // mvn clean test -Dtest=FakerApiTest
// https://fakerapi.it/en

    // многопоточный запукс тестов - аннатация @Execution
    @Execution(ExecutionMode.CONCURRENT)
    public class FakerApiTest {
        //точка входа (эндпоинт) сервиса api - URL открытых api
        private final String URL = "https://fakerapi.it/api/v1/";


        // Кейс 1. Получение данных книг по заголовку и проверка плученного залоговка в body
        @ParameterizedTest //параметризованный тест - аннатация @ParameterizedTest
        @MethodSource("dataForGetCharacterByBookTitleAndCheckBookTitle")
        //генератор / поставщик тестовых данных для параметризованного теста
        // отправка запроса данных и получение ответа
        public void getCharacterByBookTitleAndCheckBookTitle(String title, String expectedTitle) {
            RestAssured // библиотека RestAssured  - создание запроса к api
                    .given() // метод определяет, что будет отправлено в запросе
                    .log().uri() // вывод логов URL
                    .when() // метод  оппределяет с каким методом и на какой эндпоинт отправляем запрос
                    .get(URL + "books?" + title)
                    .then() // метод определяет как проверяется пришедший ответ
                    .log().status() //вывод логов статуса ответа сервера
                    .log().body() // вывод логов телла ответа сервера
                    .spec(
                            new ResponseSpecBuilder()
                                    .expectStatusCode(200)
                                    .expectBody("data[0].title", equalTo(expectedTitle))
                                    .build()
                    ); // спецификации  статус кода и тела ответа сервера. проверка тела ответа на соответсвие
        }

        // Генератор тестовых данных для @MethodSource("dataForGetCharacterByBookTitleAndCheckBookTitle")
        private static Stream<Arguments> dataForGetCharacterByBookTitleAndCheckBookTitle() {
            return Stream.of(
                    //тест фэйлится поскольку title динамически изменяется при каждом запросе  к серверу
                    Arguments.of("Alice; 'I might as.", "Alice; 'I might as."),
                    Arguments.of("The Queen turned.", "The Queen turned.")
            );
        }


        // Кейс 2. Получение данных книг и проверка статуса в body
        @ParameterizedTest
        @MethodSource("dataForGetCharacterByBookStatusAndCheckStatus")
        public void getCharacterByBookStatusAndCheckStatus(String status, String expectedStatus) {
            RestAssured
                    .given()
                    .log().uri()
                    .when()
                    .get(URL + "books?" + status)
                    .then()
                    .log().status()
                    .log().body()
                    .spec(
                            new ResponseSpecBuilder()
                                    .expectBody("status", equalTo(expectedStatus))
                                    .build()
                    );
        }

        // Генератор тестовых данных для getCharacterByBookStatusAndCheckStatus
        private static Stream<Arguments> dataForGetCharacterByBookStatusAndCheckStatus() {
            return Stream.of(
                    Arguments.of("OK", "OK")
            );
        }
    }
}
