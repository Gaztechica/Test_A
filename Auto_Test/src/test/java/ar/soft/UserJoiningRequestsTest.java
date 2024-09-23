package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.openqa.selenium.By;
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
