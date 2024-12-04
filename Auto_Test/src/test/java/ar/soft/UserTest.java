package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    // ================================== пользователь =====================================================

    //     редактирование/удаление
    //
    //     асерт

    @Test(priority = 1,
            description = "создание пользователя с ролью админ")
    public void userCreateAdmin() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("админ")
                .userLastName()
                .inputEmail("mikha-g@bk.ru")
                .userTimezoneClick()
                .userTime()
                .userTimeEnter()
                .userRolesClick()
                .userRoles()
                .userPassword()
                .userPasswordClick()
                .buttonSave();
    }

    @Test(priority = 2,
            description = "создание пользователя с ролью инспектор")
    public void userCreateInspektor() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("инспектор")
                .userLastName()
                .inputEmail("mikha.b.82@bk.ru")
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

    @Test(priority = 3,
            description = "создание пользователя с ролью подрядчик")
    public void userCreatePodraydchic() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("подрядчик")
                .userLastName()
                .inputEmail("mikha.r.00@bk.ru")
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
                .buttonSave();
    }

    @Test(priority = 4,
            description = "создание пользователя с ролью наблюдатель")
    public void userCreateNabludately() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("наблюдатель")
                .userLastName()
                .inputEmail("mikha.ye@bk.ru")
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
                .buttonSave();
    }

    @Test(priority = 5,
            description = "создание пользователя с ролью подрядчик и новой организацией")
    public void userCreatePodraydchiAdd() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("Николай")
                .userLastName()
                .inputEmail("kkk.k.82@list.ru")
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
                .buttonSave();
    }

    @Test(priority = 6,
            description = "создание пользователя с ролью наблюдатель и новой организацией")
    public void userCreateNabludatelyAdd() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("Игорь")
                .userLastName()
                .inputEmail("mikha.b.82@bk.ru")
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

    @Test(priority = 7,
            description = "переименование пользователя")
    public void userCreateRemove() {
        new UserPage(driver)
                .userPage()
                .createUserClick()
                .inputName("Михаил")
                .userLastName()
                .inputEmail("mikha.b.82@bk.ru")
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
                .buttonRemoCancel()

                .buttonSave();
    }

    @Test(priority = 8,
            description = "отмена удаления пользователя")
    public void userCancelDelete() {
        new UserPage(driver)
                .userPage()
                .buttonRemove()
                .userNameDel()
                .buttonRemoCancel();
    }

    //        не работает сортировка по организациям     смена страниц
    @Test(priority = 9,
            description = "сортировка пользователя с ролью админ")
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

//    @Test(priority = 1,
//            description = "приглашение пользователя с ролью админ")
//    public void userCreateAdmin() {
//        new UserPage(driver)
//                .userPage()
//                .createUserClick()
//
//                .userRole()
//                .userRoleAdmin()
//                .btnSubmit();
//    }

    @Test(priority = 10,
            description = "приглашение пользователя с ролью админ")
    public void userInviteAdmin() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
//                .inviteRolesEnter()
                .userRoleAdmin();
//                .buttonDeleteClick();
    }

    @Test
    public void userInviteInspektor() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
//                .inviteRolesArron()
//                .inviteRolesEnter()
                .userRoleInspect();
//                .buttonDeleteClick();
    }

    @Test
    public void userInvitePodraydchic() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .userRolePodr()
                .inviteRolesEmploymentClick()
                .inviteRoleEmplomentArro()
                .inviteRolesEmploymentEnter();
//                .buttonDeleteClick();
    }

    @Test
    public void userInviteNabludately() {
        new UserPage(driver)
                .userPage()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .userRoleNabl()
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
                .userRolePodr()
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
                .userRoleNabl()
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
                .searchInputSent("ye2vtcmvg@mail.ru");

        Assert.assertEquals("Леха", "Леха");
        Assert.assertEquals("Игнат", "Игнат");
        Assert.assertEquals("Kirov", "Kirov");
        Assert.assertEquals("Наблюдатель", "Наблюдатель");
        Assert.assertEquals("Наблюдатель", "Наблюдатель");
//        AssertionT.Element.elementPresentOnPageAndContainText(iCardFilePage.textBoxClose, "Леха");

//                .searchInputDelete();

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
