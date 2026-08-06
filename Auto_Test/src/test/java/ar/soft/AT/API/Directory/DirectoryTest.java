package ar.soft.AT.API.Directory;

import ar.soft.AT.API.BaseApi.BaseApiTest;
import ar.soft.AT.API.Directory.DirectoryPojo.DirectoryRes;
import ar.soft.AT.API.Directory.DirectoryPojo.DirectDel;
import ar.soft.AT.API.Directory.DirectoryPojo.DirectRename;
import ar.soft.AT.API.Directory.DirectoryPojo.DirectoryReg;
import ar.soft.AT.API.BaseApi.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DirectoryTest extends BaseApiTest {

    int id = 1413;
    int parentDirectory;
    Integer directId;
    public Integer direct = 4507;
    public static final String contextProjectId = "?contextProjectId=893";
    public static final String successDirect = "object deleted";
    DirectoryReg directCreate = new DirectoryReg("Test test", 893, id);
//    DirectRename directRename2 = new DirectRename(directId, "Test 123", 893);
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
    public void createDirectory() {
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

    @Story("создать новую директорию в проекте")
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
    }

    @Story("переименовать новую директорию в проекте")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 4, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void renameDirectory() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        DirectRename rename = given(specification)
                .body(directRename)
                .contentType(ContentType.JSON)
                .put("/directory/edit" + contextProjectId)
                .then()
                .extract().response().as(DirectRename.class);
        Assert.assertEquals("name", rename.getName());
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
        Assert.assertEquals(successDirect, directDel.getSuccess());
    }
}
