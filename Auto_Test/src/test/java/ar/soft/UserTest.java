package ar.soft;

import ar.soft.modelPage.ProgectPage;
import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    // ================================== пользователь =====================================================

    //     редактирование/удаление

    @Test
    public void userCreateAdmin() throws InterruptedException {
        new UserPage(driver)
                .URL();

        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail("mikha-g@bk.ru")
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRoles()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonSave();

        driver.quit();
    }

    @Test
    public void userCreateInspektor() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRoles()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonSave();


//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

        driver.quit();

    }

    @Test
    public void userCreatePodraydchic() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .imputRolesEmplomentClick()
                .inputRolesEmplomentArro()
                .imputRolesEmplomentEnter()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreateNabludately() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .imputRolesEmplomentClick()
                .inputRolesEmplomentArro()
                .imputRolesEmplomentEnter()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreatePodraydchiAdd() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRolesArron()
                .userRolesArron()
                .userRoles()
                .createRoleClick()
                .createRoleEmploment()
                .roleEmploment()
                .roleEmplomentClick()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreateNabludatelyAdd() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
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
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonSave();

        driver.quit();
    }

    @Test
    public void userCreateRemove() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
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
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick()
                .buttonRemove()
                .removeName()
                .userNameClear()
                .userName("РедактироваL")
                .buttonRemoCancel()
                .userNameClear()
                .userName("Отменить")
                .buttonSave();

        driver.quit();
    }

    @Test
    public void userCreateDelete() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .buttonRemove()
                .userNameDel()
                .buttonRemoCancel();

        driver.quit();
    }

    //        не работает сортировка по организациям     смена страниц
    @Test
    public void userCreateAdminSearch() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
                .inviteRolesEnter();
//                .buttonDeleteClick();

//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
        Thread.sleep(3000);
//        не работает сортировка по организациям

//        смена страниц
//        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
//        Thread.sleep(3000);
//        userRolesx.click();
//        Thread.sleep(3000);
//        userRolesx.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        WebElement userRoles = driver.findElement(By.xpath("//span[@title='Все организации']"));
        userRoles.click();
        Thread.sleep(3000);
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(3000);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(1000);
//        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();



//        Thread.sleep(2000);
//        driver.quit();
    }

    //        не работает сортировка по организациям нет кнопок отменить/пригласить
    @Test
    public void userInviteAdmin() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
                .inviteRolesEnter()
                .buttonDeleteClick();

        driver.quit();
    }

//    @Test
//    public void userAdmin() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        new UserPage(driver)
//                .createUser()
//                .createUserClick()
//                .userName(UserPage.USER_NAME)
//                .userLastName("FamilyTest")
//                .userEmail("yevgeniy.gor.91@mail.ru")
//                .userEmailClick()
//                .userTimezoneClick()
//                .userTime("UTC + 00:00")
//                .userTimeEnter()
//                .userRolesClick()
//                .userRoles()
//                .userPassword("zxcvbnm123")
//                .userPasswordClick()
//                .buttonDeleteClick();
//
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
////        new UserPage(getDriver()).CreateUserClick();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement pagiBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//        pagiBoxi.click();
//        pagiBoxi.sendKeys(Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));
//
//        buttonPasswordDel.click();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//        buttonPassword.click();
//        Assert.assertEquals(driver.findElement(By.xpath(UserPage.USER_NAME)).getText(), UserPage.USER_NAME);
//
//        driver.quit();
//    }

//    @Test
//    public void userTestInspektor() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        WebElement user = driver.findElement(By.xpath("//a[@href='/users']"));
//
//        user.click();
//
//        WebElement buttonUser = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']"));
//
//        buttonUser.click();
//
//        WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
//
//        userName.sendKeys("123EvgenTest");
//
//        WebElement userNameLast = driver.findElement(By.xpath("//input[@id='user_last_name']"));
//
//        userNameLast.sendKeys("FamilyTest");
//
//        WebElement userEmail = driver.findElement(By.xpath("//input[@id='user_email']"));
//
//        userEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));
//
//        buttonPasswordDel.click();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//
////        buttonPassword.click();
//
//        driver.quit();
//    }

//    @Test
//    public void userTestPodraydchic() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));
//
//        createRole.click();
//        createRole.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//
////        buttonPassword.click();
//
//        driver.quit();
//    }

//    @Test
//    public void userTestNabludately() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));
//
//        createRole.click();
//        createRole.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezon = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezon.click();
//
//        userTimezon.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBox = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBox.click();
//        createBox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRol = driver.findElement(By.xpath("//input[@id='user_employmentId']"));
//
//        createRol.click();
//        createRol.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage0 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage0.sendKeys("zxcvbnm123");
//        elemPage0.click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//
//        driver.quit();
//    }

//    @Test
//    public void userTestPodraydchiAdd() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));
//
//        createRole.click();
//
//        WebElement createRoles = driver.findElement(By.xpath("//input[@id='user_employmentName']"));
//
//        createRoles.click();
//        createRoles.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//
//        driver.quit();
//    }

//    @Test
//    public void userTestNabludatelyAdd() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");
//
//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");
//
//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));
//
//        createRole.click();
//
//        WebElement createRoles = driver.findElement(By.xpath("//input[@id='user_employmentName']"));
//
//        createRoles.click();
//        createRoles.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
//
////        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//
//        WebElement userRen = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
//        userRen.click();
//
//        driver.quit();
//    }

//    @Test
//    public void userRemove() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        WebElement buttonUser = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']"));
//
//        buttonUser.click();
//
//        WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));
//
//        userName.sendKeys("123EvgenTest");
//
//        WebElement userNameLast = driver.findElement(By.xpath("//input[@id='user_last_name']"));
//
//        userNameLast.sendKeys("FamilyTest");
//
//        WebElement userEmail = driver.findElement(By.xpath("//input[@id='user_email']"));
//
//        userEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//
//        userTimezone.click();
//
//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);
//
//        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//
//        createBoxi.click();
//        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//
//        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));
//
//        createRole.click();
//        createRole.sendKeys("Kir", Keys.ENTER);
//
//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));
//
//        buttonPasswordDel.click();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//
//
////        ================================ НЕ снимать комент ===========================================================
////        buttonPassword.click();
////        ================================ НЕ снимать комент ===========================================================
//
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();
//
//        WebElement userRen = driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]"));
//        Thread.sleep(1000);
//        userRen.click();
//
//        WebElement cearchS = driver.findElement(By.xpath("//input[@id='user_name']"));
//        cearchS.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        cearchS.sendKeys("РедактироваL");
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
//
//        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();
//
//        WebElement userRens = driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]"));
//        Thread.sleep(1000);
//        userRens.click();
//
//        WebElement cearch = driver.findElement(By.xpath("//input[@id='user_name']"));
//        cearch.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        cearch.sendKeys("Отменить");
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();
//
//        driver.quit();
//    }

//    @Test
//    public void userDelete() throws InterruptedException {
//
//        new ProgectPage(driver)
//                .URL();
//
//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();
//
//        WebElement userRen = driver.findElement(By.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(.,'Удалить')]"));
//        Thread.sleep(1000);
//        userRen.click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();
//
//        driver.quit();
//    }
    @Test
    public void userInviteInspektor() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
                .inviteRolesArron()
                .inviteRolesEnter()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userInvitePodraydchic() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick();
        Thread.sleep(4000);
        new UserPage(driver)
                .inviteRolesArron();

        Thread.sleep(2000);
        new UserPage(driver)
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .inviteRoleEmplomentArro()
                .inviteRolesEmploymentEnter()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userInviteNabludately() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
//        Thread.sleep(2000);
//        new UserPage(driver)
                .inviteRolesArron()

//        Thread.sleep(2000);
//        new UserPage(driver)
                .inviteRolesArron()
                .inviteRolesArron()
                .inviteRolesEnter()
                .inviteRolesEmploymentClick()
                .inviteRoleEmplomentArro()
                .inviteRolesEmploymentEnter()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreatePodraydchicAdd() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
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

        driver.quit();
    }

    @Test

    public void userCreaNabludatelyAdd() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
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

        driver.quit();
    }

    //        не работает сортировка по организациям
    @Test
    public void userSearchTest() throws InterruptedException {

        new UserPage(driver)
                .URL();
        new UserPage(driver)
                .createUser()
                .searchInputClick()
                .searchClick()
                .searchInputSent("леха")
                .searchInputDelete()
                .searchInputSent("игнат")
                .searchInputDelete()
                .searchInputSent("FASDAS")
                .searchInputDelete()
                .searchInputSent("Наблюдатель")
                .searchInputDelete()
                .searchInputSent("yevgeniy.gor.91@mail.ru")
                .searchInputDelete()
                .searchInputClick();



//
//        WebElement createEmail = driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']"));
//
//        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям

        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
        userRolesx.click();
        userRolesx.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
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

//        driver.quit();
    }
}
