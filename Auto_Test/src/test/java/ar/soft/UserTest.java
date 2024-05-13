package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class UserTest extends BaseTest {

    // ================================== пользователь =====================================================

    //     редактирование/удаление
    //
    //     асерт

    @Test
    public void userCreateAdmin() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("Леха")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRoles()
                .userPassword()
                .userPasswordClick()
                .buttonSave();
    }

    @Test
    public void userCreateInspektor() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("Игнат")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRoles()
                .userPassword()
                .userPasswordClick()
                .buttonSave();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
    }

    @Test
    public void userCreatePodraydchic() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("Kirov")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .imputRolesEmplomentClick()
                .inputRolesEmplomentArro()
                .imputRolesEmplomentEnter()
                .userPassword()
                .userPasswordClick()
                .buttonDeleteClick();
    }

    @Test
    public void userCreateNabludately() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("Наблюдатель")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .imputRolesEmplomentClick()
                .inputRolesEmplomentArro()
                .imputRolesEmplomentEnter()
                .userPassword()
                .userPasswordClick()
                .buttonDeleteClick();
    }

    @Test
    public void userCreatePodraydchiAdd() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .createRoleClick()
                .createRoleEmploment()
                .roleEmploment()
                .roleEmplomentClick()
                .userPassword()
                .userPasswordClick()
                .buttonDeleteClick();
    }

    @Test
    public void userCreateNabludatelyAdd() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("Наблюдатель")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .createRoleClick()
                .createRoleEmploment()
                .roleEmploment()
                .roleEmplomentClick()
                .userRoles()
                .userPassword()
                .userPasswordClick()
                .buttonSave();
    }

    @Test
    public void userCreateRemove() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail()
                .userEmailClick()
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .createRoleClick()
                .createRoleEmploment()
                .roleEmploment()
                .roleEmplomentClick()
                .userRoles()
                .userPassword()
                .userPasswordClick()
                .buttonDeleteClick()
                .buttonRemove()
                .removeName()
                .userNameClear()
                .userName("РедактироваL")
                .buttonRemoCancel()
                .userNameClear()
                .userName("Отменить");
//                .buttonSave();
    }

    @Test
    public void userCancelDelete() {
        new UserPage(driver)
                .userPage()
                .buttonRemove()
                .userNameDel()
                .buttonRemoCancel();
    }

    @Test
    public void requestUser() {
        new UserPage(driver)
                .userPage()
                .btnRequestUser()
                .hoverRequestUser();

        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed '][contains(.,'Отклонить')]")).click();
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
        new UserPage(driver)
                .hoverRequestUser();

        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Добавить')]")).click();
        getDriver().findElement(By.xpath("//div[@class='InviteUserModal__buttons']//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
    }


    //        не работает сортировка по организациям     смена страниц
    @Test
    public void userCreateAdminSearch() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesEnter();
//                .buttonDeleteClick();

//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        Thread.sleep(3000);
//        не работает сортировка по организациям

//        смена страниц
//        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
//        Thread.sleep(3000);
//        userRolesx.click();
//        Thread.sleep(3000);
//        userRolesx.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        WebElement userRoles = driver.findElement(By.xpath("//span[@title='Все организации']"));
        userRoles.click();

        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(1000);
//        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();

    }

    //        не работает сортировка по организациям нет кнопок отменить/пригласить
    @Test
    public void userInviteAdmin() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesEnter();
//                .buttonDeleteClick();
    }

    @Test
    public void userInviteInspektor() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesEnter()
                .buttonDeleteClick();
    }

    @Test
    public void userInvitePodraydchic() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .inviteRoleEmplomentArro()
                .inviteRolesEmploymentEnter()
                .buttonDeleteClick();
    }

    @Test
    public void userInviteNabludately() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .inviteRoleEmplomentArro()
                .inviteRolesEmploymentEnter()
                .buttonDeleteClick();
    }

    @Test
    public void userCreatePodraydchicAdd() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .createRoleClick()
                .createRolesEmplomentClick()
                .createRolesEmplomentSent()
                .inviteRoleEmplomentEnter()
                .buttonDeleteClick();
    }

    @Test
    public void userCreaNabludatelyAdd() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .createRoleClick()
                .createRolesEmplomentClick()
                .createRolesEmplomentSent()
                .inviteRoleEmplomentEnter()
                .buttonDeleteClick();
    }

    //        не работает сортировка по организациям
    @Test
    public void userSearchTest() {
        new UserPage(driver)
                .userPage()
                .searchInputClick()
                .searchClick()
                .searchInputSent("Леха")

//      ===========================асерт ==================================
                .searchInputDelete()
                .searchInputSent("Игнат")

                .searchInputDelete()
                .searchInputSent("Kirov")

                .searchInputDelete()
                .searchInputSent("Наблюдатель")

                .searchInputDelete()
                .searchInputSent("ye2vtcmvg@mail.ru")

                .searchInputDelete()
                .searchInputClick();
    }

    @Test
    public void organisationSearchTest() {
        new UserPage(driver)
                .userPage();
        driver.findElement(By.xpath("//div[@class='FilterUsers__employments']//span[@class='ant-select-selection-search']")).click();
        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(.,'Kir')]")).click();

//        не работает сортировка по организациям



//        WebElement userRoles = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        WebElement userRoles = driver.findElement(By.xpath("//*[@id=\"root\"]/section/main/div/div/div[1]/div[1]/div[1]/div/div/span[2]"));
//        WebElement userRoles = driver.findElement(By.xpath("//span[@title='Все организации']"));
//        userRoles.click();
//        Thread.sleep(1000);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ENTER);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();

        new UserPage(driver)
                .buttonDeleteClick();
    }

//    public String randomString() {
//        return UUID.randomUUID()
//                .toString()
//                .substring(0, 7);
//    }

    @DataProvider(name = "userAddProvider")
    public Object[][] userAddProvider() {
        return new Object[][]{
                {"Gleb", "Password", "Full name", "E-mail@com"},
                {"Ignat", "Password", "Full name", "E-mail@com"},
                {"Lion", "Password", "Full name", "E-mail@com"},
                {"Oleg", "Password", "Full name", "E-mail@com"},
                {"Den", "Password", "Full name", "E-mail@com"},
        };
    }

    @Test(dataProvider = "userAddProvider")
    public void testCheckPeople(String Username, String Password, String Fullname, String Email) {

//        List<String> showNam =
                new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesEnter();
//        Assert.assertTrue(showNames.contains(username));

    }


//    public String randomEmail() {
//        return randomString() + "@" + randomString() + ".com";
//    }

//    @DataProvider(name = "usersCreateDataProvider")
//    public Object[][] usersCreateDataProvider() {
//        return new Object[][] {
////                {"Username", "Password", "Full name", "E-mail address"},
//                {"Ivan", randomString(), randomString(), randomEmail()},
//                {"Maria", randomString(), randomString(), randomEmail()},
//                {"Sofia", randomString(), randomString(), randomEmail()},
//                {"Irina", randomString(), randomString(), randomEmail()}
//        };
//    }

//    @Test(dataProvider = "usersCreateDataProvider")
//    public void testCreateUsers(String username, String password, String fullName, String email) {
//
//        List<String> showNames = new UserPage((getDriver())
//                .;;
//
//        Assert.assertTrue(showNames.contains(username));
//    }

//    @Test(dependsOnMethods = "testCreateUsers")
//    public void testRedirectToUserPage() {
//        new HomePage(getDriver())
//                .clickPeopleButton();
////                .getUserIDListWebElement()
//
//        TestUtils.sleep(this,3);
//
//    }
}
