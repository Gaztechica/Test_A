package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends BasePage {

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @Name("кнопка ")
    public TestPage btnAddCheck() {
        getDriver().findElement(By.xpath(" ")).click();

        return this;
    }

    @Name("referenceField")
    @FindBy(xpath = "//input[@class='ant-input']")
    public WebElement newNameCheckClick;

    @Name("referenceField")
    @FindBy(xpath = "//input[@class='ant-input']")
    public WebElement newNameCheckClick2;

    @Name("поле ввода с примером ")
    @FindBy(xpath = " ")
    private WebElement btnCheckboxUser;

    public TestPage btnCheckboxUserClick() {
        btnCheckboxUser.click();

        return this;
    }
}
