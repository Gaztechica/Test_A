package ar.soft.AT.UI.tests;

import ar.soft.AT.UI.modelPage.UserPage;
import ar.soft.AT.UI.tests.baseTest.BaseTest;
import org.testng.annotations.Test;

public class UserJoiningRequestsTest extends BaseTest {

    @Test(priority = 1,
            description = "запрос на вступление в организацию отклонить - отменить")
    public void requestUser() {
        new UserPage(driver)
                .userPage()
                .btnRequestUser()
                .hoverRequestUser()
                .buttonRequestUser()
                .buttonRequestUserCancel();
    }

    @Test(priority = 2,
            description = "запрос на вступление в организацию Добавить - отменить")
    public void requestAddUser() {
        new UserPage(driver)
                .userPage()
                .btnRequestUser()
                .hoverRequestUser()
                .buttonAddRequestUser()
                .buttonAddRequestUserCancel();
    }

}
