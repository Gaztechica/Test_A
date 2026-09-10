package ar.soft.Test.RestfulBooker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class ReqBaseTest {

    public final static String URL_API = "https://reqres.in";

    protected static RequestSpecification requestSpec;

    protected String createdUserId;

    @BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(URL_API)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @AfterMethod
    public void tearDown() {

        if (createdUserId != null) {
            System.out.println("--- ОЧИСТКА: Удаляем созданного пользователя с ID: " + createdUserId + " ---");

            given()
                    .spec(requestSpec)
                    .when()
                    .delete("/api/users/" + createdUserId)
                    .then()
                    .log().all()
                    .statusCode(204);

            createdUserId = null;
        }
    }
}

