package ar.soft.AT.API.Сhecklist;

import ar.soft.AT.API.BaseApi.BaseApiTest;
import ar.soft.AT.API.Сhecklist.ChecklisPojo.ChecklistGreateReg;
import ar.soft.AT.API.Сhecklist.ChecklisPojo.ChecklistRes;
import ar.soft.AT.API.BaseApi.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ar.soft.AT.API.Log.LogTest.contextOrganizationId;
import static io.restassured.RestAssured.given;

public class ChecklistTest extends BaseApiTest {

    Integer id;
    Integer idd;
    ChecklistGreateReg checklistGreateReg = new ChecklistGreateReg();

//    ChecklistGreateReg body = new ChecklistGreateReg(359, "kkkkkkkk",
//            "description", 000,
//            "categoryDtoList": [
//    {
//        "number": 1,
//            "name": "88",
//            "description": "",
//            "checkListId": 0,
//            "parentCategoryNumber": null,
//            "descendantCategoriesId": [],
//        "status": "EMPTY",
//            "links": []
//    }
//    ]
//});

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
//создать класс с ответом для проверки респонса, тело брать из класса
//    @Story("Создать новый чек-лист в библиотеке")
//    @Description("вывести информацию о своем аккаунте")
//    @Test(priority = 1, groups = {"10.5", "1"},
//            description = "вывести информацию о своем аккаунте")
//    public void deleteChecklistTest() {
//        Specification.intansSpec(Specification.requestSpec(URL_API), Specification.responseSpecOk200());
//        ChecklistGreateRes checklistGreateReg = given(specification)
//                .body(checklistGreateReg)
//                .post("/checklist/create" + contextOrganizationId)
//                .then()
//                .extract().response();
////        JsonPath jsonPath = checklistGreateReg.jsonPath();
//        idd = jsonPath.get("domain[0].id");
//        Assert.assertEquals(idd, id);
//
////        DelLog delLog = given(specification)
////                .delete("/checklist1/" + id + contextOrganizationId)
////                .then()
////                .extract().response().as(DelLog.class);
////        Assert.assertEquals(success, success);
//    }
}
