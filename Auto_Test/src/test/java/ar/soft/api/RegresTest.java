package ar.soft.api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegresTest {

    private final static String URL2 = "https://reqres.in/";

    @Test
    public void checkAutorisationIdTestp() {
//        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        List<UserData> users = given()
                .when().log().all()
                .contentType(ContentType.JSON)
                .get(URL2 + "api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
//        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        int f = 0;
    }

    @Test
    public void checkAutorisationIdTesedtp() {
        Specification.intansSpec(Specification.requestSpec(URL2), Specification.responseSpecOk200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SucessReg regId = given()
                .body(user)
                .when()
//                .contentType(ContentType.JSON)
                .post("api/register")
                .then().log().all()
                .extract().as(SucessReg.class);
        Assert.assertEquals(id, regId.getId());
        Assert.assertEquals(token, regId.getToken());
    }
}
