package ar.soft;

import ar.soft.modelPage.ProgectPage;
import ar.soft.modelPage.UserPage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectTest extends BaseTest {

    WebDriver driver = new ChromeDriver();
    public static final String NEGA_EMAIL = "dfghjkluytr@mail.ru";
    private By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");

    // ============================== Проект создание/удаление ==================================


    //      ======  добавить проверку проекта===
    @Test
    public void CreateProgect() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        new ProgectPage(driver).buttonCreateProgect();

        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("1Новый проект");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");

        driver.findElement(By.xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_code']")).sendKeys("123");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");

        driver.findElement(By.xpath("//input[@id='CreateProjectForm_startDate']")).click();

        WebElement NewData = driver.findElement(By.xpath("//a[@class='ant-picker-today-btn']"));

        Thread.sleep(2000);
        NewData.click();

        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));

//        Thread.sleep(1000);
        EndData.sendKeys("26-03-2024");
//        Thread.sleep(1000);
        EndData.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
        Thread.sleep(2000);

//       кнопка отмены
//        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
//        textBoxAside.click();

//        Thread.sleep(9000);

        WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
        textSection.click();

//        =========================== свернутый сайтбар ===============================

//        WebElement textSectionInput = driver.findElement(By.xpath("//input[@value='1Новый проект']"));
//        textSectionInput.click();
//        Thread.sleep(4000);
//        String getErr = driver.findElement(getText).getText();
//
//        Assert.assertEquals("1Новый проект", getErr);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();

//      ======  добавить проверку проекта===

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();
        driver.quit();

    }

    // ================================== пользователь пагинация =====================================================

    // нет изменения кол-ва строк на странице
//    @Test
//    public void ProjectTest() throws InterruptedException{
//
//        driver.get(URL);
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
////=============================================================
//
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();
//
//        driver.findElement(By.xpath("//button[@class='ant-pagination-item-link']/span[@aria-label='left']")).click();
//
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();
//
//        driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'1')]")).click();
//
////====================================================================================
////        WebElement elemPage = driver.findElement(By.xpath("//input[@class='ant-select-selection-search-input']"));
//
//        WebElement elemPage = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
//
//        elemPage.click();
//        Thread.sleep(3000);
////        elemPage.sendKeys(Keys.ARROW_DOWN);
//        elemPage.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//        elemPage.sendKeys(Keys.ENTER);
//
//        Thread.sleep(1000);
//
//        WebElement elemPage2 = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='50']"));
//
//        elemPage2.click();
//
//        Thread.sleep(1000);
//
//        WebElement elemPagve = driver.findElement(By.xpath("//span[@class='ant-select-selection-search']"));
//
//        elemPagve.click();
//
//        Thread.sleep(1000);
//
//        WebElement elemPageFift = driver.findElement(By.xpath("//span[@class='ant-select-arrow']"));
//
//        elemPageFift.click();
//
//        Thread.sleep(1000);
//
//        WebElement elemPageFifty = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//        elemPageFifty.click();
//
//        Thread.sleep(8000);
//
//        WebElement elemPageOne = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'50')]"));
//
//        elemPageOne.click();
//
//        Thread.sleep(1000);
//
//        WebElement elemPageOneN = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//        elemPageOneN.click();
//
//        Thread.sleep(1000);
//        WebElement textBoxCountry = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_country\"]"));
//
//        textBoxCountry.sendKeys("РФ");
//
//
//        WebElement textBoxStreet = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_street\"]"));
//
//        textBoxStreet.sendKeys("Победы");
//
//        WebElement textBoxPostalCode = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_postalCode\"]"));
//
//        textBoxPostalCode.sendKeys("444444");
//
//        WebElement submitButtonCreateProject = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']"));
//
//        submitButtonCreateProject.click();
////         driver.quit();
//
//    }

    // ================================== ссылки =====================================================

//    @Test
//    public void HrefPolitic() throws InterruptedException {
//
//        driver.get(URL);
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
//        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();
//
//        driver.quit();
//    }

//    @Test
//    public void HrefPoliticUser() throws InterruptedException {
//
//        driver.get(URL);
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
//        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/user-agreement-armobail/']")).click();
//
//        driver.quit();
//    }

//    @Test
//    public void HrefBot() throws InterruptedException {
//
//        driver.get(URL);
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
//        driver.findElement(By.xpath("//a[@href='https://t.me/arsoft_support_bot']")).click();
//
//        driver.quit();
//    }
//    @Test
//    public void RegNegaTest() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get(URL);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
//        String getError = driver.findElement(getErrorText).getText();
//
//        Assert.assertEquals(getError,"Неправильный логин или пароль");
////        driver.quit();
//    }

    //      ======  добавить проверку проекта===
//    @Test
//     public void RegasTest() throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        driver.get(URL);
//        driver.manage().window().setSize(new Dimension(1820,1080));
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
//        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
//        driver.findElement(By.xpath(BTN_PASSWORD)).click();
//        Thread.sleep(9000);
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
//
//        driver.findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("1Новый проект");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");
//
//        driver.findElement(By.xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_code']")).sendKeys("123");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");
//
//        driver.findElement(By.xpath("//input[@id='CreateProjectForm_startDate']")).click();
//
//        WebElement NewData = driver.findElement(By.xpath("//a[@class='ant-picker-today-btn']"));
//
//        Thread.sleep(2000);
//        NewData.click();
//
//        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));
//
////        Thread.sleep(1000);
//        EndData.sendKeys("26-03-2024");
////        Thread.sleep(1000);
//        EndData.sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();
//        Thread.sleep(2000);
//
////       кнопка отмены
////        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
////        textBoxAside.click();
//
////        Thread.sleep(9000);
//
//        WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
//        textSection.click();
//
////        =========================== свернутый сайтбар ===============================
//
////        WebElement textSectionInput = driver.findElement(By.xpath("//input[@value='1Новый проект']"));
////        textSectionInput.click();
////        Thread.sleep(4000);
////        String getErr = driver.findElement(getText).getText();
////
////        Assert.assertEquals("1Новый проект", getErr);
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();
//
////      ======  добавить проверку проекта===
//
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();
//        driver.quit();
//
//    }



    //     редактирование/удаление
    @Test
    public void userTestAdmin() throws InterruptedException {

        driver.get(URL);
//        Thread.sleep(2000);
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
                .userEmail("yevgeniy.gor.91@mail.ru")
                .userEmailClick()
                .userTimezoneClick()
                .userTime("UTC + 00:00")
                .userTimeEnter()
                .userRolesClick()
                .userRoles()
                .userPassword("zxcvbnm123")
                .userPasswordClick()
                .buttonDeleteClick();

//        UserPage userPage1 = new UserPage(driver);
//        Assert.assertEquals(driver.findElement(By.xpath(UserPage.USER_NAME)).getText(), UserPage.USER_NAME);


//        driver.findElement(By.xpath("//a[@href='/users']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();
//        new UserPage(getDriver()).CreateUserClick();

//        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

//        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

//        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

//        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));
//        userTimezone.click();

//        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

//        WebElement pagiBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
//        pagiBoxi.click();
//        pagiBoxi.sendKeys(Keys.ENTER);

//        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
//        elemPage02.sendKeys("zxcvbnm123");
//        elemPage02.click();
//        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));
//
//        buttonPasswordDel.click();
//        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
//      buttonPasswordDel.click();

        driver.quit();
    }

    @Test
    public void UserTestInspektor() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        WebElement user = driver.findElement(By.xpath("//a[@href='/users']"));

        user.click();

        WebElement buttonUser = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']"));

        buttonUser.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));

        userName.sendKeys("123EvgenTest");

        WebElement userNameLast = driver.findElement(By.xpath("//input[@id='user_last_name']"));

        userNameLast.sendKeys("FamilyTest");

        WebElement userEmail = driver.findElement(By.xpath("//input[@id='user_email']"));

        userEmail.sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));

        buttonPasswordDel.click();
        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

//        buttonPassword.click();

        driver.quit();
    }

    @Test
    public void UserTestPodraydchic() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

//        buttonPassword.click();

        driver.quit();
    }

    @Test
    public void UserTestNabludately() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezon = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezon.click();

        userTimezon.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBox = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBox.click();
        createBox.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRol = driver.findElement(By.xpath("//input[@id='user_employmentId']"));

        createRol.click();
        createRol.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage0 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage0.sendKeys("zxcvbnm123");
        elemPage0.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

        driver.quit();
    }

    @Test
    public void UserTestPodraydchiAdd() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));

        createRole.click();

        WebElement createRoles = driver.findElement(By.xpath("//input[@id='user_employmentName']"));

        createRoles.click();
        createRoles.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        driver.quit();
    }

    @Test
    public void UserTestNabludatelyAdd() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("123EvgenTest");

        driver.findElement(By.xpath("//input[@id='user_last_name']")).sendKeys("FamilyTest");

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//img[@src='/static/media/AddButton.48ed616f99340e2467c9c2a6d8a8b67e.svg']"));

        createRole.click();

        WebElement createRoles = driver.findElement(By.xpath("//input[@id='user_employmentName']"));

        createRoles.click();
        createRoles.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();

//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        WebElement userRen = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
        userRen.click();

        driver.quit();
    }

    @Test
    public void UserRemove() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        WebElement buttonUser = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default secondaryButton big colorPrimary ']"));

        buttonUser.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='user_name']"));

        userName.sendKeys("123EvgenTest");

        WebElement userNameLast = driver.findElement(By.xpath("//input[@id='user_last_name']"));

        userNameLast.sendKeys("FamilyTest");

        WebElement userEmail = driver.findElement(By.xpath("//input[@id='user_email']"));

        userEmail.sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userTimezone = driver.findElement(By.xpath("//input[@id='user_timezone']"));

        userTimezone.click();

        userTimezone.sendKeys("UTC + 00:00", Keys.ENTER);

        WebElement createBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        createBoxi.click();
        createBoxi.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));

        buttonPasswordDel.click();
        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));


//        ================================ НЕ снимать комент ===========================================================
//        buttonPassword.click();
//        ================================ НЕ снимать комент ===========================================================

        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();

        WebElement userRen = driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]"));
        Thread.sleep(1000);
        userRen.click();

        WebElement cearchS = driver.findElement(By.xpath("//input[@id='user_name']"));
        cearchS.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearchS.sendKeys("РедактироваL");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();

        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();

        WebElement userRens = driver.findElement(By.xpath("//div[@class='ant-typography p_r'][contains(.,'Редактировать')]"));
        Thread.sleep(1000);
        userRens.click();

        WebElement cearch = driver.findElement(By.xpath("//input[@id='user_name']"));
        cearch.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearch.sendKeys("Отменить");

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

        driver.quit();
    }

    @Test
    public void UserDelete() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(11000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();


        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']")).click();

        WebElement userRen = driver.findElement(By.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(.,'Удалить')]"));
        Thread.sleep(1000);
        userRen.click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary '][contains(.,'Отменить')]")).click();

        driver.quit();
    }

    // ================================== пагинация=====================================================

    // нет изменения кол-ва строк на странице
    @Test
    public void ProjectTest() throws InterruptedException{

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);


//=============================================================

//         WebElement pagiSimvol = driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]"));
//
//         pagiSimvol.click();
//
//         Thread.sleep(1000);
//
//         WebElement pgiLeft = driver.findElement(By.xpath("//button[@class='ant-pagination-item-link']/span[@aria-label='left']"));
//
//         pgiLeft.click();
//
//         Thread.sleep(1000);
//
//         WebElement pagiLeft = driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]"));
//
//         pagiLeft.click();
//
//         Thread.sleep(1000);

//         WebElement pagiSimvolRetern = driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'1')]"));
//
//         pagiSimvolRetern.click();

//====================================================================================
//        WebElement elemPage = driver.findElement(By.xpath("//input[@class='ant-select-selection-search-input']"));

        WebElement elemPage = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
        elemPage.click();

//        Select simpl = new Select(selectWithoutMultiple);
//        simpl.selectByValue("two");
//        String newValue = selectWithoutMultiple.getAttribute("value");

        Thread.sleep(3000);
//        elemPage.sendKeys(Keys.ARROW_DOWN);
        elemPage.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        elemPage.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

//         WebElement elemPage2 = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='50']"));
//
//         elemPage2.click();
//
//         Thread.sleep(1000);

//         WebElement elemPagve = driver.findElement(By.xpath("//span[@class='ant-select-selection-search']"));
//
//         elemPagve.click();
//
//         Thread.sleep(1000);
//
//         WebElement elemPageFift = driver.findElement(By.xpath("//span[@class='ant-select-arrow']"));
//
//         elemPageFift.click();
//
//         Thread.sleep(1000);

//         WebElement elemPageFifty = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//         elemPageFifty.click();
//
//         Thread.sleep(8000);

//         WebElement elemPageOne = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'50')]"));
//
//         elemPageOne.click();
//
//         Thread.sleep(1000);
//
//         WebElement elemPageOneN = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));
//
//         elemPageOneN.click();
//
//         Thread.sleep(1000);
//         WebElement textBoxCountry = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_country\"]"));
//
//         textBoxCountry.sendKeys("РФ");
//
//
//         WebElement textBoxStreet = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_street\"]"));
//
//         textBoxStreet.sendKeys("Победы");
//
//         WebElement textBoxPostalCode = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_postalCode\"]"));
//
//         textBoxPostalCode.sendKeys("444444");
//
//         WebElement submitButtonCreateProject = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']"));
//
//         submitButtonCreateProject.click();
//         driver.quit();
//         Thread.sleep(5000);
    }

    // ================================== ссылки =====================================================

    @Test
    public void HrefPolitic() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        WebElement elemPage01 = driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']"));

        elemPage01.click();
//        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void HrefPoliticUser() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        WebElement elemPage02 = driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/user-agreement-armobail/']"));

        elemPage02.click();
//        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void HrefBot() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        WebElement elemPage03 = driver.findElement(By.xpath("//a[@href='https://t.me/arsoft_support_bot']"));

        elemPage03.click();
//        Thread.sleep(2000);
        driver.quit();
    }

}
