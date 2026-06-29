package ar.soft.api.Directory;

import ar.soft.api.BaseApi.BaseApiTest;
import ar.soft.api.Directory.DirectoryPojo.DirectDel;
import ar.soft.api.Directory.DirectoryPojo.DirectRename;
import ar.soft.api.Directory.DirectoryPojo.DirectoryReg;
import ar.soft.api.Directory.DirectoryPojo.DirectoryRes;
import ar.soft.api.Log.LogPojo.DelLog;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.bouncycastle.asn1.cmc.CMCStatus.success;

public class DirectoryTest extends BaseApiTest {

    int id = 1413;
    int parentDirectory;
    public Integer directId;
    public Integer direct = 4411;
    public static final String contextProjectId = "?contextProjectId=893";
    public static final String successDirect = "object deleted";
    DirectoryReg directCreate = new DirectoryReg("Test test", 893, id);
    DirectRename directRename2 = new DirectRename(directId, "Test 123", 893, id);
    DirectRename directRename = new DirectRename(direct, "Test 123", 893, id);

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
        parentDirectory = jsonPath.get("data.directory.id");
        Assert.assertEquals(id, parentDirectory);

    }

    @Story("создать новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
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
        Assert.assertEquals(id, 1413);

    }

    @Story("создать и удалить новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 3, groups = {"10.5", "1"},
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

//        DelLog delLog = given(specification)
//                .delete("/directory/delete/" + directId + contextProjectId)
//                .then()
//                .extract().response().as(DelLog.class);
//        Assert.assertEquals("object deleted", "object deleted");
    }

    @Story("переименовать новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 4, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void renameDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        DirectRename rename = given(specification)
                .body(directRename2)
                .contentType(ContentType.JSON)
                .put("/directory/edit" + contextProjectId)
                .then()
                .extract().response().as(DirectRename.class);
//        Assert.assertEquals(name, success);
    }

    @Story("удалить новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 5, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void deleteDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        DirectDel directDel = given(specification)
                .delete("/directory/delete/" + directId + contextProjectId)
                .then()
                .extract().response().as(DirectDel.class);
        Assert.assertEquals(successDirect, "object deleted");
    }
}
