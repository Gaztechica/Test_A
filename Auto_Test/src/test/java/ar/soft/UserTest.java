package ar.soft;

import ar.soft.modelPage.UserPage;
import ar.soft.modelPage.base.BasePage;
import ar.soft.runner.BaseTest;
//import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    // ================================== пользователь =====================================================

    //     редактирование/удаление

    @Test
    public void userCreateAdmin() {
        new UserPage(driver)
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
    public void userCreateDelete() {
        new UserPage(driver)
                .createUser()
                .buttonRemove();
//                .userNameDel();
//                .buttonRemoCancel();
    }

    @Test
    public void requestUser() {
        new UserPage(driver)
                .createUser()
                .btnRequestUser();

        WebElement targetElementStatus = getWait10().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("")));
        new Actions(getDriver())
                .moveToElement(targetElementStatus)
                .perform();

getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Добавить')]")).click();
    }


    //        не работает сортировка по организациям     смена страниц
    @Test
    public void userCreateAdminSearch() {
        new UserPage(driver)
                .createUser()
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
                .createUser()
                .inviteUserClick()
                .inviteUserEmail()
                .inviteRolesClick()
                .inviteRolesEnter();
//                .buttonDeleteClick();
    }

    @Test
    public void userInviteInspektor() {
        new UserPage(driver)
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
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
                .createUser()
                .searchInputClick()
                .searchClick()
                .searchInputSent("Леха")
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
}
