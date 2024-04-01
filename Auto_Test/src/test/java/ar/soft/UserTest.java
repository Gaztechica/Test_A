package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.modelPage.base.BasePage;
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
                .login();
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
                .userRoles()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonSave();

//        driver.quit();
    }

    @Test
    public void userCreateInspektor() throws InterruptedException {

        new UserPage(driver)
                .login();
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
                .login();
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
                .login();
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
                .login();
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
                .login();
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
                .login();
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
                .userName("Отменить");
//                .buttonSave();

//        driver.quit();
    }

    @Test
    public void userCreateDelete() throws InterruptedException {
        new UserPage(driver)
                .login();
        new UserPage(driver)
                .createUser()
                .buttonRemove()
                .userNameDel()
                .buttonRemoCancel();

        driver.quit();
    }
    @Test
    public void userCreateDelete() throws InterruptedException {
        new UserPage(driver)
                .login();
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
                .login();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
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
//        Thread.sleep(3000);
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//        Thread.sleep(3000);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(1000);
//        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();

//        Thread.sleep(2000);
        driver.quit();
    }

    //        не работает сортировка по организациям нет кнопок отменить/пригласить
    @Test
    public void userInviteAdmin() throws InterruptedException {
        new UserPage(driver)
                .login();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
                .inviteRolesEnter()
                .buttonDeleteClick();
        driver.quit();
    }

    @Test
    public void userInviteInspektor() throws InterruptedException {
        new UserPage(driver)
                .login();
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
                .login();
        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRolesClick()
//        Thread.sleep(4000);
//        new UserPage(driver)
                .inviteRolesArron()

//        Thread.sleep(2000);
//        new UserPage(driver)
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
                .login();
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
                .login();
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
                .login();
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
                .login();
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
