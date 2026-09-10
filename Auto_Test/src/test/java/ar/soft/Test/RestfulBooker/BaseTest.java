package ar.soft.Test.RestfulBooker;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public final static String BASE_URI = ConfigReader.getBaseUri();

    protected static RequestSpecification requestSpec;

    @BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    @AfterMethod
    public void tearDown() {

        given()
                .spec(requestSpec)
                .when()
                .then()
                .log().all()
                .statusCode(204);
    }
}

