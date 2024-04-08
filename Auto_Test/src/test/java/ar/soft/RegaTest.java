package ar.soft;

import ar.soft.modelPage.ProgectPage;
import ar.soft.runner.BaseTest;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public class RegaTest extends BaseTest {

    WebDriver driver = new ChromeDriver();
    public static final String NEGA_EMAIL = "dfghjkluytr@mail.ru";
    private By getErrorText = By.xpath("//div[@style='text-align: center; margin-bottom: 20px; color: rgb(255, 0, 0);']");
    private By getEmailText = By.xpath("//h2[@class='ant-typography h2_m RestorePassword__sendSuccess-text']");
    private By newProgect = By.xpath("//input[@id='EditProjectForm_name']");

//    private By newProgect = By.xpath("//input[@id='EditProjectForm_name'][@value='1Новый проект']");

    @BeforeMethod
    @AfterMethod

    //=============================== смена пароля ====================================
    @Test
    public void passwordTest () throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();

        driver.findElement(By.xpath("//input[@id='RestorePassword_email']")).sendKeys(EMAIL);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default authButton big colorPrimary ']")).click();

        driver.quit();

    }




        //=============================== регистрация нового пользователя ====================================


//  рамдомные почтовые ящ создавать/удалять пользователей
    @Test
    public void autorisationTest () throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(2000);

        String emailText = driver.findElement(getEmailText).getText();
        Assert.assertEquals(emailText, "Мы отправили по адресу n-k-65@list.ru ссылку для восстановления доступа");
        driver.quit();
    }

    @Test
    public void randomAutorisationTest () throws InterruptedException {

        driver.get(URL);
        Thread.sleep(1000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h2[@class='ant-typography h2_m Login__restore-text']")).click();
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB).get("https://tmailor.com/ru");

        Thread.sleep(2000);
        WebElement userRolesc = driver.findElement(By.xpath("//input[@class='form-control shadow-none']"));
        Thread.sleep(2000);
        userRolesc.sendKeys(Keys.LEFT_CONTROL + "c");
//        driver.findElement(By.xpath("//button[@class='btn btn-light shadow-sm btn-email border rounded-5 m-2'][contains(.,' Копировать')]")).click();
//        WebDriver driver = new ChromeDriver();
//        Thread.sleep(2000);
//        driver.get(URL);
//        driver.findElement(By.xpath("////*[@id="ajax-html"]/div[1]/div/div/div[1]/div[1]/div[3]/button[1]")).click();
//

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='RestorePassword_email']")).sendKeys(Keys.LEFT_CONTROL + "v");
//        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);

                // .sendKeys(EMAIL);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();

        driver.quit();
    }

    @Test
    public void regNegaTest() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(1000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(NEGA_EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals(getError,"Неправильный логин или пароль");
        driver.quit();
    }


// ============================== Проект создание/удаление ==================================



    //      ======  добавить проверку проекта===
    @Test
    public void RegasTest() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
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

        Thread.sleep(2000);

        WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
        textSection.click();

        Thread.sleep(2000);
        String newProg = driver.findElement(newProgect).getText();
        String text = driver.findElement(By.xpath("//input[@id='EditProjectForm_name'][@value='1Новый проект']")).getText();
        Thread.sleep(5000);
        Assert.assertEquals(newProg, text);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(.,'Подтвердить')]")).click();
        driver.quit();

    }

    // ================================== пользователь пагинация =====================================================

    // нет изменения кол-ва строк на странице
    @Test
    public void ProjectTest() throws InterruptedException{

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

//=============================================================

         driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();

         driver.findElement(By.xpath("//button[@class='ant-pagination-item-link']/span[@aria-label='left']")).click();

         driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'2')]")).click();

         driver.findElement(By.xpath("//a[@rel='nofollow'][contains(.,'1')]")).click();

//====================================================================================
//        WebElement elemPage = driver.findElement(By.xpath("//input[@class='ant-select-selection-search-input']"));

        WebElement elemPage = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
        elemPage.click();
        Thread.sleep(3000);

//        elemPage.sendKeys(Keys.ARROW_DOWN);
        elemPage.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        elemPage.sendKeys(Keys.ENTER);

         Thread.sleep(1000);

         WebElement elemPage2 = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][@title='50']"));

         elemPage2.click();

         Thread.sleep(1000);

         WebElement elemPagve = driver.findElement(By.xpath("//span[@class='ant-select-selection-search']"));

         elemPagve.click();

         Thread.sleep(1000);

         WebElement elemPageFift = driver.findElement(By.xpath("//span[@class='ant-select-arrow']"));

         elemPageFift.click();

         Thread.sleep(1000);

         WebElement elemPageFifty = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));

         elemPageFifty.click();

         Thread.sleep(8000);

         WebElement elemPageOne = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'50')]"));

         elemPageOne.click();

         Thread.sleep(1000);

         WebElement elemPageOneN = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'10')]"));

         elemPageOneN.click();

         Thread.sleep(1000);
         WebElement textBoxCountry = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_country\"]"));

         textBoxCountry.sendKeys("РФ");


         WebElement textBoxStreet = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_street\"]"));

         textBoxStreet.sendKeys("Победы");

         WebElement textBoxPostalCode = driver.findElement(By.xpath("//*[@id=\"CreateProjectForm_postalCode\"]"));

         textBoxPostalCode.sendKeys("444444");

         WebElement submitButtonCreateProject = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']"));

         submitButtonCreateProject.click();
//         driver.quit();

     }

     // ================================== ссылки =====================================================

    @Test
    public void HrefPolitic() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

       driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();

        driver.quit();
    }

    @Test
    public void HrefPoliticUser() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

       driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/user-agreement-armobail/']")).click();

        driver.quit();
    }

    @Test
    public void HrefBot() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='https://t.me/arsoft_support_bot']")).click();

        driver.quit();
    }



    // ================================== пользователь =====================================================

//     редактирование/удаление
    @Test
    public void UserTestAdmin() throws InterruptedException {

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

        WebElement pagiBoxi = driver.findElement(By.xpath("//input[@id='user_roles']"));
        pagiBoxi.click();
        pagiBoxi.sendKeys(Keys.ENTER);

        WebElement elemPage02 = driver.findElement(By.xpath("//input[@id='user_password']"));
        elemPage02.sendKeys("zxcvbnm123");
        elemPage02.click();
        WebElement buttonPasswordDel = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']"));

        buttonPasswordDel.click();
        WebElement buttonPassword = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary primaryButton big colorPrimary ']"));
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

        driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("yevgeniy@mail.ru");

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

   //        не работает сортировка по организациям нет кнопок отменить/пригласить
    @Test
    public void UserCreateAdmin() throws InterruptedException {

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

        driver.quit();
    }

    @Test
    public void UserCreateAdminSearch() throws InterruptedException {

        driver.get(URL);
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        Thread.sleep(3000);
//        не работает сортировка по организациям
        WebElement userRolesx = driver.findElement(By.xpath("//div[@class='ant-select SelectComponent ant-select-single ant-select-show-arrow'][contains(.,'Все организации')]"));

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

        driver.quit();
    }

    @Test
    public void UserCreateInspektor() throws InterruptedException {

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

        driver.quit();
    }

    @Test
    public void UserCreatePodraydchic() throws InterruptedException {

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

        driver.quit();
    }

    @Test
    public void UserCreateNabludately() throws InterruptedException {

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

        driver.quit();
    }

    @Test
    public void UserCreatePodraydchicAdd() throws InterruptedException {

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

        driver.quit();
    }

    @Test
    public void UserCreateNabludatelyAdd() throws InterruptedException {

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

        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']")).click();

        WebElement cearch = driver.findElement(By.xpath("//div[@class='FilterUsers__search']"));
        cearch.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@class='ant-input']")).sendKeys("леха");
        Thread.sleep(1000);

        WebElement cearchS = driver.findElement(By.xpath("//input[@class='ant-input']"));
        cearchS.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearchS.sendKeys("игнат");
        Thread.sleep(1000);

        WebElement cearchP = driver.findElement(By.xpath("//input[@class='ant-input']"));
        cearchP.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearchP.sendKeys("FASDAS");
        Thread.sleep(1000);

        WebElement cearchR = driver.findElement(By.xpath("//input[@class='ant-input']"));
        cearchR.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearchR.sendKeys("Наблюдатель");
        Thread.sleep(1000);

        WebElement cearchE = driver.findElement(By.xpath("//input[@class='ant-input']"));
        cearchE.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        cearchE.sendKeys("yevgeniy.gor.91@mail.ru");
        Thread.sleep(1000);
//        buttonUserCreate.click();
//        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//        WebElement createEmailn = driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  entered']"));
//        buttonUserCreate.click();
//
//        buttonUserCreate.sendKeys("yevgeniy.gor.91@mail.ru");
//        driver.findElement(By.xpath("//span[@class='ant-input-affix-wrapper searchBoxInput  not-entered']")).sendKeys("yevgeniy.gor.91@mail.ru");
//
////        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");
//
//        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
//        userRoles.click();
//        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям
        WebElement cearchDel = driver.findElement(By.xpath("//input[@class='ant-input']"));
        cearchDel.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);

//        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
//        userRolesx.click();
//        userRolesx.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
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
        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
        userRolesc.click();
        Thread.sleep(1000);
        userRolesc.sendKeys(Keys.ARROW_DOWN);
        userRolesc.sendKeys(Keys.ARROW_DOWN);
        userRolesc.sendKeys(Keys.ENTER);
        driver.quit();
    }

// ================================== библиотека =====================================================


    @Test
    public void BibliotekaTest() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);

        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//a[@href='/users']")).click();

        WebElement buttonUserCreate = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary '] "));

        buttonUserCreate.click();

        WebElement createEmail = driver.findElement(By.xpath("//input[@id='InviteUserModal_email']"));

        createEmail.sendKeys("yevgeniy.gor.91@mail.ru");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям
        WebElement userRolesx = driver.findElement(By.xpath("//span[@class='ant-select-selection-item']"));
        userRolesx.click();
        userRolesx.sendKeys(Keys.ARROW_DOWN);
        WebElement userRolesvv = driver.findElement(By.xpath("//span[@title='Все организации']"));
        userRolesvv.click();
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
        userRolesc.click();

        driver.quit();
    }

    // ================================== админ панель =====================================================


    @Test
    public void AdminPanelTest() throws InterruptedException {

        driver.get(URL);
        driver.manage().window().setSize(new Dimension(1820,1080));
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(BTN_PASSWORD)).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//h2[@class='ant-typography h2_sb']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();

        driver.findElement(By.xpath("//div[@class='ant-tabs-tab-btn'][contains(.,'Организация')]")).click();
        Thread.sleep(8000);
        WebElement createEmail = driver.findElement(By.xpath("//span[@class='EditedOrganization__uploadLogoBlock-addButton']//span[contains(.,'Заменить')]"));
        createEmail.click();
        createEmail.sendKeys("C:\\Users\\User\\IdeaProjects\\AutoTest\\src\\imgs\\Logo.png");

        WebElement userRoles = driver.findElement(By.xpath("//input[@id='InviteUserModal_roles']"));
        userRoles.click();
        userRoles.sendKeys(Keys.ENTER);

//        не работает сортировка по организациям
        driver.findElement(By.xpath("//span[@class='ant-select-selection-item']")).click();

        driver.findElement(By.xpath("//div[@class='ant-typography p_r Profile__item'][contains(.,'Профиль')]")).click();
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
        userRoles.sendKeys(Keys.ARROW_DOWN);
        userRoles.sendKeys(Keys.ENTER);
        WebElement userRolesc = driver.findElement(By.xpath("//span[@class='ant-select-selection-item'][contains(.,'Все организации')]"));
        userRolesc.click();

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
}
