package ar.soft;

import ar.soft.modelPage.ProgectPage;
import ar.soft.runner.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ProjectTest extends BaseTest {

    WebDriver driver = new ChromeDriver();

    private By newProgectNameText = By.xpath("//div[@class='Sidebar__project-name'][contains(.,'1Новый проект')]");
    private By getPoliticaText = By.xpath("//h1[@class='page-header-title clr']");
    private By getPoliticaUserText = By.xpath("//span[@style='font-size: 19px;'][contains(.,'Предмет пользовательского соглашения')]");
    private By getBotText = By.xpath("//span[@dir='auto']");

    // ============================== Проект создание/удаление ==================================

    @Test
    public void createProgect() throws InterruptedException {

        new ProgectPage(driver)
                .login();

        new ProgectPage(driver)
                .buttonCreateProgect();
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
        NewData.click();

        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));
        EndData.sendKeys("26-03-2024");
        EndData.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();

        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();

//       кнопка отмены
//        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
//        textBoxAside.click();

        WebElement textSection = driver.findElement(By.xpath("//a[@style='color: inherit;'][contains(.,'Настройки')]"));
        textSection.click();

        String newProgectName = driver.findElement(newProgectNameText).getText();

        Assert.assertEquals("1Новый проект", newProgectName);

        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorRed ']")).click();

        driver.quit();

    }

    @Test
    public void cancelCreateProgectTest() throws InterruptedException {

        new ProgectPage(driver)
                .login();

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

        NewData.click();

        WebElement EndData = driver.findElement(By.xpath("//input[@id='CreateProjectForm_endDate']"));

        EndData.sendKeys("26-03-2024");

        EndData.sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();


//        driver.findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r']")).click();

//       кнопка отмены
        WebElement textBoxAside = driver.findElement(By.xpath("//button[@class='Sidebar__collapsibleBtn']"));
        textBoxAside.click();

//        driver.quit();

    }

    // ================================== пользователь пагинация =====================================================

    // нет изменения кол-ва строк на странице
    @Test
    public void poginacyaTest() throws InterruptedException {

        new ProgectPage(driver)
                .login();
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
         driver.quit();

    }

    // ================================== ссылки =====================================================

    @Test
    public void hrefPolitic() throws InterruptedException {

        new ProgectPage(driver)
                .login();

        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/personal-data-processing-policy/']")).click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String getErr = driver.findElement(getPoliticaText).getText();

        Assert.assertEquals("Политика обработки персональных данных", getErr);
        driver.quit();
    }

    @Test
    public void hrefPoliticUser() throws InterruptedException {

        new ProgectPage(driver)
                .login();

        driver.findElement(By.xpath("//a[@href='https://vr-arsoft.com/user-agreement-armobail/']")).click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        String getPoliticaUser = driver.findElement(getPoliticaUserText).getText();

        Assert.assertEquals("Предмет пользовательского соглашения", getPoliticaUser);
        driver.quit();
    }

    @Test
    public void hrefBot() throws InterruptedException {

        new ProgectPage(driver)
                .login();

        driver.findElement(By.xpath("//a[@href='https://t.me/arsoft_support_bot']")).click();

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String getBot = driver.findElement(getBotText).getText();

        Assert.assertEquals("AR SOFT support", getBot);
        driver.quit();
    }

//    =================================================


    //     редактирование/удаление


    // ================================== пагинация=====================================================

    // нет изменения кол-ва строк на странице
    @Test
    public void projectTest() throws InterruptedException{

        new ProgectPage(driver)
                .login();


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



}
