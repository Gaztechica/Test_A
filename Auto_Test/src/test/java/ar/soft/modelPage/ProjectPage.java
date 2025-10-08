package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import io.qameta.allure.Allure;
import jdk.jfr.Name;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.qa.elements.Button;
import ru.qa.methods.ActionT;
import ru.qa.methods.WaitT;

import javax.print.attribute.standard.MediaSize;

import static ar.soft.runner.BaseTest.PASSWORD;
import static java.lang.Character.getName;
import static org.openqa.selenium.By.xpath;

public class ProjectPage extends BasePage {

    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

//    @Name("кнопка создать Проект")
//    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")
//    private WebElement btnCreateProject;
//
//    @Name("кнопка создать Проект")
//    public ProjectPage btnCreateProject() {
//        btnCreateProject.click();
//        return this;
//    }





//    @Name("кнопка Завершенные")
//    @FindBy(xpath = "//div[@class='ant-tabs-tab-btn'][contains(., 'Завершенные')]")
//    private WebElement selectCompletedClick;

    @Name("кнопка Завершенные")
    public ProjectPage selectCompletedClick() {
        ActionT.OneClick.click("//div[@class='ant-tabs-tab-btn'][contains(., 'Завершенные')]");

//        selectCompletedClick();
        return this;
    }

    @Name("кнопка создать Проект")
    public ProjectPage btnCreateProject() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("logo")
    public ProjectPage logoProject() {
        getDriver().findElement(xpath("//*[@class='Logo']")).click();
        return this;
    }

    @Name("кнопка поиска")
    public ProjectPage searchProject() {
        getDriver().findElement(xpath("//div[@class='Checklists__extraButtonChecklict-search']")).click();
        return this;
    }

    @Name("название Проекта")
    public ProjectPage inputNameProject() {
        getDriver().findElement(xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
        return this;
    }

    @Name("Поле ввода названия Проекта")
    public ProjectPage inputSearchNameProject() {
        getDriver().findElement(xpath("//*[@class='ant-input']")).sendKeys("админ");
        return this;
    }

    @Name("Город Проекта")
    public ProjectPage inputCityProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
        return this;
    }

    @Name("Страна Проекта")
    public ProjectPage inputCountryProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");
        return this;
    }

    @Name("улица Проекта")
    public ProjectPage inputStreetProject() {
        getDriver().findElement(xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");
        return this;
    }

    @Name("Почтовый индекс Проекта")
    public ProjectPage inputPostalCodeProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");
        return this;
    }

    @Name("Код проекта Проекта")
    public ProjectPage inputCodeProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_code']")).sendKeys("1235558258655");
        return this;
    }

    @Name("Дом Проекта")
    public ProjectPage inputBuildingProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");
        return this;
    }

    @Name("Офис Проекта")
    public ProjectPage inputOfficeProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");
        return this;
    }

    @Name("Дата начала Проекта")
    public ProjectPage inputStartDateProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_startDate']")).sendKeys("01-11-2024", Keys.ENTER);
        return this;
    }

    @Name("Вкладка Завершенные Проекта")
    public ProjectPage restoreProjectClick() {
        getDriver().findElement(xpath("//*[@class='ant-tabs-tab-btn'][contains(., 'Завершенные')]")).click();
        return this;
    }

    @Name("Завершение Проекта")
    public ProjectPage ellipsisProjectClick() {
        getDriver().findElement(xpath("//*[@class='ant-typography p_r']")).click();
        return this;
    }

    @Name("Завершение Проекта")
    public ProjectPage restorePKMProjectClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//*[@class='ant-table-row ant-table-row-level-0'][contains(.,'11AAНовый проект')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }

    @Name("Восстановить Проект")
    public ProjectPage ellipsisPKMProjectClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("(//*[@class='ant-table-row ant-table-row-level-0'][contains(.,'11AAНовый проект')])[2]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }

    @Name("Восстановить Проект")
    public ProjectPage ellipsisProjectClick2() throws InterruptedException {
        Thread.sleep(300);
        WebElement submitButton2 = getDriver().findElement(xpath("//span[contains(.,'Подтвердить')]"));
//        getDriver().findElement(By.xpath("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']//*[contains(.,'Подтвердить')])[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", submitButton2);
        return this;
    }

    @Name("ввод пароля для Завершения Проекта")
    public ProjectPage inputPasswordProject() {
        getDriver().findElement(xpath("//*[@id='EditedPasswordUser_password']")).sendKeys(PASSWORD, Keys.ENTER);
        return this;
    }

    @Name("троеточие Восстановить Проект")
    public ProjectPage ellipsisProject() {
        getDriver().findElement(xpath("(//*[@class='ant-table-row ant-table-row-level-0'][contains(.,'11AAНовый проект')]//*[@class='Checklists__info-iconBlock'])[2]")).click();

        return new ProjectPage(getDriver());
    }

    @Name("Дата окончания Проекта")
    public ProjectPage inputEndDateProject() {
        getDriver().findElement(xpath("//input[@id='CreateProjectForm_endDate']")).sendKeys("26-11-2024", Keys.ENTER);
        return this;
    }

    @Name("название Проекта - в сайтбаре")
    public String sidebarProjectText() {
        return getDriver().findElement(xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_m']")).getText();
    }

    @Name("название Проекта - ")
    public String searchProjectText() {
        return getDriver().findElement(xpath("//*[contains(@class, 'ant-typography-ellipsis-single-line p_r')][contains(., 'админ')]")).getText();
    }

    @Name("уведомление - Проект успешно создан")
    public String addProjectText() {
        return getDriver().findElement(xpath("//span[contains(., 'Проект успешно создан')]")).getText();
    }

    @Name("уведомление - Проект успешно завершен")
    public String sendProjectText() {
        return getDriver().findElement(xpath("//span[contains(., 'Проект успешно завершен')]")).getText();
    }

    @Name("уведомление - Проект успешно восстановлен")
    public String sendProjectText2() {

        return getDriver().findElement(xpath("//span[contains(., 'Проект успешно восстановлен')]")).getText();
    }

    @Name("кнопка добавить Проект")
    public ProjectPage addProject() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("кнопка отменить Проект")
    public ProjectPage cancelProject() {
        getDriver().findElement(xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        return this;
    }

    @Name(" Проект")
    public ProjectPage Project() {
        getDriver().findElement(xpath("")).click();
        return this;
    }

    @Name("выбрать сегодняшнюю дату")
    public ProjectPage todayProject() {
        getDriver().findElement(xpath("//a[@class='ant-picker-today-btn']")).click();
        return this;
    }

//    public ProjectPage selectProject() {
//        selectProject.click();
//        return this;
//    }
}
