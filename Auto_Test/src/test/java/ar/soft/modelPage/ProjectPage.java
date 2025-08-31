package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import io.qameta.allure.Allure;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.qa.elements.Button;
import ru.qa.methods.ActionT;
import ru.qa.methods.WaitT;

import javax.print.attribute.standard.MediaSize;

import static java.lang.Character.getName;

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
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("logo")
    public ProjectPage logoProject() {
        getDriver().findElement(By.xpath("//*[@class='Logo']")).click();
        return this;
    }

    @Name("кнопка поиска")
    public ProjectPage searchProject() {
        getDriver().findElement(By.xpath("//div[@class='Checklists__extraButtonChecklict-search']")).click();
        return this;
    }

    @Name("название Проекта")
    public ProjectPage inputNameProject() {
        getDriver().findElement(By.xpath("//input[@class='ant-input primaryInput  not-entered']")).sendKeys("11AAНовый проект");
        return this;
    }

    @Name("Поле ввода названия Проекта")
    public ProjectPage inputSearchNameProject() {
        getDriver().findElement(By.xpath("//*[@class='ant-input']")).sendKeys("админ");
        return this;
    }

    @Name("Город Проекта")
    public ProjectPage inputCityProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_city']")).sendKeys("Самара");
        return this;
    }

    @Name("Страна Проекта")
    public ProjectPage inputCountryProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_country']")).sendKeys("РФ");
        return this;
    }

    @Name("улица Проекта")
    public ProjectPage inputStreetProject() {
        getDriver().findElement(By.xpath("//textarea[@id='CreateProjectForm_street']")).sendKeys("Победы");
        return this;
    }

    @Name("Почтовый индекс Проекта")
    public ProjectPage inputPostalCodeProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_postalCode']")).sendKeys("444444");
        return this;
    }

    @Name("Код проекта Проекта")
    public ProjectPage inputCodeProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_code']")).sendKeys("1235558258655");
        return this;
    }

    @Name("Дом Проекта")
    public ProjectPage inputBuildingProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_building']")).sendKeys("121");
        return this;
    }

    @Name("Офис Проекта")
    public ProjectPage inputOfficeProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_office']")).sendKeys("117");
        return this;
    }

    @Name("Дата начала Проекта")
    public ProjectPage inputStartDateProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_startDate']")).sendKeys("01-11-2024", Keys.ENTER);
        return this;
    }

    @Name("Дата окончания Проекта")
    public ProjectPage inputEndDateProject() {
        getDriver().findElement(By.xpath("//input[@id='CreateProjectForm_endDate']")).sendKeys("26-11-2024", Keys.ENTER);
        return this;
    }

    @Name("название Проекта - в сайтбаре")
    public String sidebarProjectText() {
        return getDriver().findElement(By.xpath("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_m']")).getText();
    }

    @Name("название Проекта - ")
    public String searchProjectText() {
        return getDriver().findElement(By.xpath("//*[contains(@class, 'ant-typography-ellipsis-single-line p_r')][contains(., 'админ')]")).getText();
    }

    @Name("уведомление - Проект успешно создан")
    public String addProjectText() {
        return getDriver().findElement(By.xpath("//span[contains(., 'Проект успешно создан')]")).getText();
    }
    @Name("кнопка добавить Проект")
    public ProjectPage addProject() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']")).click();
        return this;
    }

    @Name("кнопка отменить Проект")
    public ProjectPage cancelProject() {
        getDriver().findElement(By.xpath("//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")).click();
        return this;
    }

    @Name(" Проект")
    public ProjectPage Project() {
        getDriver().findElement(By.xpath("")).click();
        return this;
    }

    @Name("выбрать сегодняшнюю дату")
    public ProjectPage todayProject() {
        getDriver().findElement(By.xpath("//a[@class='ant-picker-today-btn']")).click();
        return this;
    }

//    public ProjectPage selectProject() {
//        selectProject.click();
//        return this;
//    }
}
