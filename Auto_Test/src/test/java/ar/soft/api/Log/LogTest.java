package ar.soft.api.Log;

import ar.soft.api.Account.Login;
import ar.soft.api.Log.LogPojo.DelLog;
import ar.soft.api.Log.LogPojo.LogReg;
import ar.soft.api.Log.LogPojo.LogRes;
//import ar.soft.api.LogPojo.*;
import ar.soft.api.Specification;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.bouncycastle.asn1.cmc.CMCStatus.success;

public class LogTest extends Login {

    String pageable = "?contextOrganizationId=57&page=0&size=9999";
    String contextOrganizationId = "?contextOrganizationId=57";
    Integer logId;
    LogReg logReg = new LogReg("2026-02-07T15:27:09.94138", null, 359);

    @Story("Получить логи всех аккаунтов")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 1, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void getLogTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response = given(specification)
                .get("/log" + pageable)
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        int ids = jsonPath.get("domain[0].accountId");
        Assert.assertEquals(359, ids);
    }

    @Story("Сохранить логи аккаунта по id")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void postLogTest() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        LogRes logRes = given(specification)
                .body(logReg)
                .post("/log" + contextOrganizationId)
                .then()
                .extract().response().body()
                .as(LogRes.class);
    }

    @Story("Сохранить логи аккаунта по id")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 2, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void postLogTest2() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
        Response response = given(specification)
                .body(logReg)
                .post("/log" + contextOrganizationId)
                .then()
//                .extract().response().body().as(Ress.class);
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        logId = jsonPath.get("data.id");
        Assert.assertEquals(logId, logId);

        DelLog delLog = given(specification)
                .delete("/log/" + logId + contextOrganizationId)
                .then()
                .extract().response().as(DelLog.class);
        Assert.assertEquals(success, success);
    }

//    @Story("Сохранить логи аккаунта по id")
//    @Description("вывести информацию о своем аккаунте")
//    @Test(priority = 2, groups = {"10.5", "1"},
//            description = "вывести информацию о своем аккаунте")
//    public void postLogTest3() {
//        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
//        Response response = given(specification)
//                .body(logReg)
//                .post("/log" + contextOrganizationId)
//                .then()
//                .extract().response();
////                .extract().response().as(LogRes.class);
//
//        JsonPath jsonPath = response.jsonPath();
//        logId = jsonPath.get("data.id");
//        Assert.assertEquals(logId, logId);
////                jsonPath().get("data.id");
//
//
////        logId = response.getBody();
////        logId = ress.setId();
//        System.out.println("=====logId=====   " + logId);
//
//        DelLog delLog = given(specification)
//                .delete("/log/" + logId + contextOrganizationId)
//                .then()
//                .extract().response().as(DelLog.class);
//        Assert.assertEquals(success, success);
//
//
//    }
//    @Story("Удалить логи аккаунта по id")
//    @Description("вывести информацию о своем аккаунте")
//    @Test(priority = 3, groups = {"10.5", "1"},
//            description = "вывести информацию о своем аккаунте")
//    public void deleteLogTest() {
//        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());
//
//        Response response = given(specification)
//                .delete("/log/" + (LogRes.class)
//                .then()
//                .extract().response();
//   }

    @Story("Удалить логи аккаунта по id")
    @Description("вывести информацию о своем аккаунте")
    @Test(priority = 3, groups = {"10.5", "1"},
            description = "вывести информацию о своем аккаунте")
    public void deleteLogTest2() {
        Specification.intansSpec(Specification.requestSpec(URL), Specification.responseSpecOk200());

        Response response = given(specification)
                .delete("/log/" + logId + contextOrganizationId)
                .then()
                .extract().response();


    }
}
