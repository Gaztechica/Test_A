

import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegaTest extends BaseTest {

    public static final String NEGA_EMAIL = "dfghjkluytr@mail.ru";
    private By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private By getText = By.xpath("//input[@id='EditProjectForm_name'][@value='1Новый проект']");

    @BeforeMethod
    @AfterMethod

    //=============================== смена пароля ====================================
    @Test
    public void PassworTest () throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        driver.findElement(By.xpath("//input[@id='RestorePassword_email']")).sendKeys(EMAIL);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();

        driver.quit();

    }




        //=============================== регистрация нового пользователя ====================================


// найти рамдомные почтовые ящ и создавать/удалять пользователей?
    @Test
    public void AutorisationTest () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);
//        driver.quit();
    }


// ============================== Проект создание/удаление ==================================

    @Test
    public void RegNegaTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
//        driver.quit();
    }

    //      ======  добавить проверку проекта===
    @Test
    public void RegasTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

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

    // ================================== пользователь пагинация=====================================================

    // нет изменения кол-ва строк на странице
    @Test
    public void ProjectTest() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
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

    @Test public void HrefBot() throws InterruptedException {

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

//         Thread.sleep(1000);

    // ================================== пользователь =====================================================

//     редактирование/удаление  нет кнопок отменить
    @Test
    public void UserTestAdmin() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        WebElement pagiBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));

        pagiBoxi.click();
        pagiBoxi.sendKeys(Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));

        buttonPasswordDel.click();
        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));

//        buttonPasswordDel.click();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserTestInspektor() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserTestPodraydchic() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserTestNabludately() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        WebElement createRole = driver.findElement(By.xpath("//input[@id='user_employmentId']"));

        createRole.click();
        createRole.sendKeys("Kir", Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));

        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

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

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserTestPodraydchiAdd() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserTestNabludatelyAdd() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']")).click();

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

        Thread.sleep(2000);
        driver.quit();
    }


    //        не работает кгопка реактировать
    @Test
    public void UserRemove() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
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


//        WebElement userRen = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger ContentUsers__iconBlock-img']"));
//        WebElement userRen = driver.findElement(By.xpath("//div[@class='ContentUsers__iconBlock']/../../.."));
//        userRen.click();
//        WebElement userRenv = driver.findElement(By.xpath("//tbody[@class='ant-table-tbody']"));
//        userRenv.click();

//        WebElement Remove = driver.findElement(By.xpath("//div[@class='ContentUsers__iconBlock']"));
//
//        Remove.click();



//        userRen.click();

        Thread.sleep(2000);
//        driver.quit();
    }



   //        не работает сортировка по организациям нет кнопок отменить/пригласить
    @Test
    public void UserCreateAdmin() throws InterruptedException {

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
        userRoles.sendKeys(Keys.ENTER);

//        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void UserCreateAdminSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

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

    @Test
    public void UserCreateInspektor() throws InterruptedException {

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
        userRoles.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void UserCreatePodraydchic() throws InterruptedException {

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
    public void UserCreateNabludately() throws InterruptedException {

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

        WebDriver driver = new ChromeDriver();
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

// ================================== библиотека =====================================================


    @Test
    public void BibliotekaTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

//        WebElement buttonUserCreate = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] "));
//
//        buttonUserCreate.click();
//
//        WebElement createEmail = driver.findElement(By.xpath("//input[@id='InviteUserModal_email']"));
//
//        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям
        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
        userRolesx.click();
//        userRolesx.sendKeys(Keys.ARROW_DOWN);
//        WebElement userRoles = driver.findElement(By.xpath("//span[@title='Все организации']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ENTER);
//        userRoles.sendKeys(Keys.ARROW_DOWN);
//        userRoles.sendKeys(Keys.ENTER);
//        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
//        userRolesc.click();



//        Thread.sleep(2000);
//        driver.quit();
    }
}
