package ar.soft.modelPage;

import ar.soft.modelPage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogFilePage extends BasePage {

    public LogFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/logfiles']")
    private WebElement btnLogFile;

    @FindBy(xpath = "//img[@class='project__image']") // заменил 29.06.24 не удалял
//    @FindBy(xpath = "//img[@src='/static/media/Basket.8774715cc0eccb962b78054dc111a9a8.svg']")
    private WebElement iconDeleteLogFile;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default cleanButton big colorPrimary ']")
    private WebElement btnCanselDeleteLogFile;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default primaryButton big colorPrimary ']//span")
    private WebElement btnDeleteLogFile;

//    @FindBy(xpath = "//input[@id='rc_select_3']")
    @FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
    private WebElement searchLogFile;

//    @FindBy(xpath = "")).getText();
//    private WebElement logName;
//
//    @FindBy(xpath = "//a[@href='/logfiles']")
//    private WebElement btnLogFile;

    public LogFilePage btnLogFile() {
        btnLogFile.click();

        return this;
    }

    public LogFilePage iconDeleteLogFile() {
        iconDeleteLogFile.click();

        return this;
    }

    public LogFilePage btnCanselDeleteLogFile() {
        btnCanselDeleteLogFile.click();

        return this;
    }

    public LogFilePage btnDeleteLogFile() throws InterruptedException {
        Thread.sleep(100);
        btnDeleteLogFile.click();

        return this;
    }

    public LogFilePage searchLogFile() {
        searchLogFile.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    public String logNameText() {
        return getDriver().findElement(By.xpath("//*[@data-testid='Text'][contains(., 'f.ff.1980@list.ru')]")).getText();
    }

//    public LogFilePage logName() {
//        logName.click();
//
//        return this;
//    }
//
//    public void btnLogFile() {
//        btnLogFile.click();
//    }
//
//    public void btnLogFile() {
//        btnLogFile.click();
//    }
}
