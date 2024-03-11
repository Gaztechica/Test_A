package ar.soft;

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

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(5000);

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
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreateInspektor() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .buttonDeleteClick();


//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

        driver.quit();

    }

    @Test
    public void userCreatePodraydchic() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreateNabludately() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreatePodraydchiAdd() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .userRoles()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userCreateNabludatelyAdd() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .buttonDeleteClick();

//        WebElement userRen = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
//
//        userRen.click();

//        WebElement Remove = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
//
//        Remove.click();
//
//        WebElement userRen = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
//
//        userRen.click();

        driver.quit();
    }

    @Test
    public void userCreateRemove() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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
                .buttonRemove();
        Thread.sleep(2000);
        new UserPage(driver)
                .removeName()
                .userNameClear()
                .userName("РедактироваL")
                .buttonRemoOtmena()
                .userNameClear()
                .userName("Отменить")
                .buttonSave();

        driver.quit();
    }

    @Test
    public void userCreateDelete() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        new UserPage(driver)
                .createUser();
        Thread.sleep(1000);
        new UserPage(driver)
                .buttonRemove();
        Thread.sleep(1000);
        new UserPage(driver)
                .userNameDel();
        Thread.sleep(1000);
        new UserPage(driver)
                .buttonRemoOtmena();

        driver.quit();
    }

    @Test
    public void userCreateAdminSearch() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

//        new UserPage(driver)
//                .createUser()
//                .inviteUserClick()
//                .inviteUserEmail(UserPage.USER_NAME)
//                .inviteRoles()
//                .inviteRolesEnter()
//                .buttonDeleteClick();

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        Thread.sleep(3000);
//        не работает сортировка по организациям
        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));

        userRolesx.click();
        userRolesx.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
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

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        new UserPage(driver)
                .createUser()
                .inviteUserClick()
                .inviteUserEmail(UserPage.USER_NAME)
                .inviteRoles()
                .inviteRolesEnter()
                .buttonDeleteClick();

        driver.quit();
    }

    @Test
    public void userInviteInspektor() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        new UserPage(driver)
                .createUser()
                .createUserClick()
                .userName(UserPage.USER_NAME)
                .userLastName("FamilyTest")
                .userEmail(UserPage.USER_EMAIL)
                .userEmailClick()
                .createRoleClick()
                .userRolesArron()
                .userRoles();

//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] ")).click();
//
//        driver.findElement(By.xpath("//input[@id='InviteUserModal_email']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//
//        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void userInvitePodraydchic() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] ")).click();

        driver.findElement(By.xpath("//input[@id='InviteUserModal_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//input[@id='InviteUserModal_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);


        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void userInviteNabludately() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] ")).click();

        driver.findElement(By.xpath("//input[@id='InviteUserModal_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//input[@id='InviteUserModal_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);


//        Thread.sleep(2000);
//        driver.quit();
    }





    @Test
    public void UserCreatePodraydchicAdd() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] ")).click();

        driver.findElement(By.xpath("//input[@id='InviteUserModal_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));

        createRole.click();

        WebElement createRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_employmentName']"));

        createRoles.click();
        createRoles.sendKeys("Kir", Keys.ENTER);


        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserCreateNabludatelyAdd() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] ")).click();

        driver.findElement(By.xpath("//input[@id='InviteUserModal_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));

        createRole.click();

        WebElement createRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_employmentName']"));

        createRoles.click();
        createRoles.sendKeys("Kir", Keys.ENTER);


        Thread.sleep(2000);
        driver.quit();
    }

    //        не работает сортировка по организациям
    @Test
    public void UserSearchTest() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

//        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']")).click();

//        WebElement cearch = driver.findElement(By.xpath("//div[@class='FilterUsers__search']"));
//        cearch.click();
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//input[@class='ant-input']")).sendKeys("леха");
//        Thread.sleep(1000);
//
//        WebElement cearchS = driver.findElement(By.xpath("//input[@class='ant-input']"));
//        cearchS.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        cearchS.sendKeys("игнат");
//        Thread.sleep(1000);
//
//        WebElement cearchP = driver.findElement(By.xpath("//input[@class='ant-input']"));
//        cearchP.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        cearchP.sendKeys("FASDAS");
//        Thread.sleep(1000);
//
//        WebElement cearchR = driver.findElement(By.xpath("//input[@class='ant-input']"));
//        cearchR.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
//        cearchR.sendKeys("Наблюдатель");
//        Thread.sleep(1000);


//        buttonUserCreate.click();
//        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//        WebElement createEmailn = driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  entered']"));
//        buttonUserCreate.click();

//        buttonUserCreate.sendKeys("yevgeniy.gor.91@mail.ru");
//        WebElement createEmail = driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']"));
//
//        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям

//        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
//        userRolesx.click();
//        userRolesx.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        WebElement userRoles = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        WebElement userRoles = driver.findElement(By.xpath("//*[@id=\"root\"]/section/main/div/div/div[1]/div[1]/div[1]/div/div/span[2]"));
//        WebElement userRoles = driver.findElement(By.xpath("//span[@title='Все организации']"));
        userRoles.click();
        Thread.sleep(1000);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();



//        Thread.sleep(2000);
//        driver.quit();
    }
}
