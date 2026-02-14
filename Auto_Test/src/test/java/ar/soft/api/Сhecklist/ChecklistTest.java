package ar.soft.api.Сhecklist;

import ar.soft.api.BaseApi.BaseApiTest;
import ar.soft.api.Сhecklist.ChecklisPojo.ChecklistGreateReg;
import ar.soft.api.Сhecklist.ChecklisPojo.ChecklistRes;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static ar.soft.api.Log.LogTest.contextOrganizationId;
import static io.restassured.RestAssured.given;

public class ChecklistTest extends BaseApiTest {

    Integer id;

//    ArrayList<ChecklistGreateReg.CategoryDtoList> categoryDtoList = ArrayList<ChecklistGreateReg.CategoryDtoList>;
//    ChecklistGreateReg.Root root = ChecklistGreateReg(117, "newChecklist", false, categoryDtoList)
//    ChecklistRes checklist = new ChecklistRes(8825, "erg", 117, "ВладЕлец", "Тестов",
//            "2026-02-09T15:33:25.303106", null, [])



    @Story("Получить все чек-листы")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void getChecklistTestPojo() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        ChecklistRes checklistRes = given(specification)
                .get("/checklist" + contextOrganizationId)
                .then()
                .extract().response().body()
                .as(ChecklistRes.class);
        Assert.assertEquals(359, 359);
    }

    @Story("Получить чек-лист по ID")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void getChecklistTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .get("/checklist" + contextOrganizationId)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.get("domain[0].id");
        Assert.assertEquals(id, id);

        ChecklistRes checklistRes = given(specification)
                .get("/checklist/" + id + contextOrganizationId)
                .then()
                .extract().response().as(ChecklistRes.class);
        Assert.assertEquals(id, id);
    }

    @Story("Получить все чек-листы")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void postLogTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .get("/checklist" + contextOrganizationId)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int ids = jsonPath.get("domain[0].authorId");
        Assert.assertEquals(359, ids);
    }

    @Story("Создать новый чек-лист в библиотеке")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void deleteChecklistTest() {
        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
        Response response = given(specification)
                .post("/checklist/create" + contextOrganizationId)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.get("domain[0].id");
        Assert.assertEquals(id, id);

//        DelLog delLog = given(specification)
//                .delete("/checklist1/" + id + contextOrganizationId)
//                .then()
//                .extract().response().as(DelLog.class);
//        Assert.assertEquals(success, success);
    }
}
