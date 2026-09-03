package ar.soft.AT.API.OKS;

import ar.soft.AT.API.BaseApi.BaseApiTest;
import ar.soft.AT.API.BaseApi.Specification;
import ar.soft.AT.API.OKS.OksPojo.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OksTest extends BaseApiTest {

    public static final int ProjectId = 893;
    Integer idOks;
    Integer Oks;
    public static final String success = "object deleted";
    CreateOks createOks = new CreateOks("OKS", "123");
    RemoteOkS remoteOKS = new RemoteOkS("OKS переименован", "123");
    String bodyJson = """
            {
                "ids": [
                    188
                ]
            }
            """;
    GetParam getParam = new GetParam(893);
//    RecDelOks recDelOks = new RecDelOks(188);
    List<Integer> numb = Arrays.asList(188);

    public static void idd(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("ids", 188);
    }


    @Story("создать новый ОКС в проекте")
    @Description("")
    @Test(priority = 1, description = "")
    public void createOksTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .body(createOks)
                .post("oks/create/" + ProjectId)
                .then()
                .extract().response();
//                .as(ResCreateOks.class);
       JsonPath jsonPath = response.jsonPath();
        idOks = jsonPath.get("data.id");
//       idOks = response.body().jsonPath().get("data.id");

        Assert.assertEquals("123", createOks.getGeneralPlanNumber());
        Assert.assertEquals("OKS", createOks.getName());
    }

    @Story("переименовать ОКС в проекте")
    @Description("")
    @Test(priority = 2, description = "")
    public void remoteOksTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        RemoteOkS remoteOks = given(specification)
                .body(remoteOKS)
                .put("oks/edit/" + idOks)
                .then()
                .extract().response()
                .as(RemoteOkS.class);

        Assert.assertEquals("123", remoteOKS.getGeneralPlanNumber());
        Assert.assertEquals("OKS переименован", remoteOKS.getName());
    }

    @Story("получить ОКС по id")
    @Description("")
    @Test(priority = 3, description = "")
    public void getOksTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        ResCreateOks resCreate = given(specification)
                .get("oks/" + idOks)
                .then()
                .extract().response()
                .as(ResCreateOks.class);

        Assert.assertEquals("OKS", createOks.getName());
//        Assert.assertEquals("Елизавета Иванова", createOks.());
    }

    @Story("удалить OKS в проекте")
    @Description("")
    @Test(priority = 4, description = "")
    public void deleteDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        DeleteOks deleteOks = given(specification)
                .body(bodyJson)
//                .body("ids: " + numb)
//                .body("{ids: " + numb + "}")
                .delete("/oks/delete/batch")
                .then()
                .extract().response().as(DeleteOks.class);
        Assert.assertEquals(success, deleteOks.getSuccess());
    }

    @Story("получить все ОКС по id")
    @Description("")
    @Test(priority = 5, description = "")
    public void getAllOksTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
         GetParam getParam2 = given(specification)
                .queryParam("projectId", getParam)
                .get("oks" )
                .then()
                .extract().response()
                .as(GetParam.class);

//        Assert.assertEquals("359", resCreateOks2.getAuthorId());
//        Assert.assertEquals("Елизавета Иванова", resCreateOks2.getAuthorName());
    }


}
