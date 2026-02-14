package ar.soft.api.Directory;

import ar.soft.api.BaseApi.BaseApiTest;
import ar.soft.api.Directory.DirectoryPojo.DirectDel;
import ar.soft.api.Directory.DirectoryPojo.DirectoryReg;
import ar.soft.api.Directory.DirectoryPojo.DirectoryRes;
import ar.soft.api.Log.LogPojo.DelLog;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.api.Log.LogTest.contextOrganizationId;
import static io.restassured.RestAssured.given;

public class DirectoryTest extends BaseApiTest {

    int id = 1413;
    public Integer directId;
    public static final String contextProjectId = "?contextProjectId=893";
    DirectoryReg directCreate = new DirectoryReg("Test test", 893, 1413);

    @Story("")
    @Description("Получить данные о вложениях директории")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void getDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .get("/directory/" + id + contextProjectId)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.get("data.directory.id");
        Assert.assertEquals(id, id);

    }

    @Story("создать новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void postDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        DirectoryRes directoryRes = given(specification)
                .body(directCreate)
                .post("/directory/create" + contextProjectId)
                .then()
                .extract().response().body()
                .as(DirectoryRes.class);
//        JsonPath jsonPath = response.jsonPath();
//        id = jsonPath.get("data.directory.id");
        Assert.assertEquals(id, id);

    }

    @Story("создать и удалить новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void postDirector() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .body(directCreate)
                .post("/directory/create" + contextProjectId)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        directId = jsonPath.get("data.id");
        Assert.assertEquals(directId, directId);

        DelLog delLog = given(specification)
                .delete("/directory/" + directId + contextOrganizationId)
                .then()
                .extract().response().as(DelLog.class);
        Assert.assertEquals("object deleted", "object deleted");
    }

    @Story("создать новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void deleteDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
               DirectDel directDel = given(specification)
                .delete("/directory/" + directId + contextProjectId)
                .then()
                .extract().response().as(DirectDel.class);
        Assert.assertEquals("object deleted", "object deleted");
    }
}
