package ar.soft.modelPage.FileSPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.qa.methods.WaitT;


import static ar.soft.AT.UI.FileTest.FileTest.NEW_FOLDER;
import static ar.soft.AT.UI.FileTest.FileTest.REMOVE_FOLDER;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.LEFT_CONTROL;

public class FilePage extends BasePage {

    public FilePage(WebDriver driver) {
        super(driver);
    }

    @Name("кнопка добавить")
    public FilePage folderAdd() {
        getDriver().findElement(By.xpath("//*[@data-test-id='button'][contains(., 'Добавить')]")).click();

        return this;
    }

    @Name("кнопка Сохранить")
    public FilePage btnSave() {
        getDriver().findElement(By.xpath("//*[@data-test-id='button'][contains(., 'Сохранить')]")).click();

        return this;
    }

    @Name("кнопка переместить подтверждение")
    public FilePage btnMovingSave() {
        getDriver().findElement(By.xpath("//*[@data-test-id='button'][contains(., 'Переместить')]")).click();

        return this;
    }

    @Name("кнопка добавить2")
    public FilePage folderMoving() {
        WaitT.littleWait(200);
        getDriver().findElement(By.xpath("//*[@class='ant-tree-title'][contains(., '11')]")).click();

        return this;
    }

    @Name("кнопка Переместить")
    public FilePage btnMoving() {
        WaitT.littleWait(300);
        getDriver().findElement(By.xpath("(//span[@class='ant-dropdown-menu-title-content'][contains(., 'Переместить')])[1]")).click();

        return this;
    }

    @Name("кнопка Подтвердить")
    public FilePage btnConfirm() {
        WaitT.littleWait(200);
        getDriver().findElement(By.xpath("//*[@data-test-id='modal-3-button']")).click();

        return this;
    }

    @Name("кнопка добавить2")
    public FilePage folderAdd2() {
        getDriver().findElement(By.xpath("(//*[@data-test-id='button'][contains(., 'Добавить')])[2]")).click();

        return this;
    }

    @Name("check новая папка")
    public String checkCreateFolder() throws InterruptedException {
        WaitT.littleWait(300);
        return getDriver().findElement(xpath("//*[@data-test-id='text'][contains(., '" + NEW_FOLDER + "')]")).getText();
    }

    @Name("кнопка редактировать ПKM название папки")
    public FilePage btnRemovePRMFolderClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//*[@data-test-id='text'][contains(., '" + NEW_FOLDER + "')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }

    @Name("вызов контекстного меню ПKM")
    public FilePage btnPRMFolderClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//*[@data-test-id='text'][contains(., '" + REMOVE_FOLDER + "')]"));
        actions.contextClick(btnElement)
                .perform();
        return this;
    }

    @Name("выбрать кнопку")
    public FilePage folderSelect() {
        getDriver().findElement(By.xpath("//*[@data-test-id='text'][contains(., 'Папка')]")).click();

        return this;
    }

    @Name("выбрать Переименовать")
    public FilePage btnRename() {
        getDriver().findElement(By.xpath("(//span[@class='ant-dropdown-menu-title-content'][contains(., 'Переименовать')])[1]")).click();

        return this;
    }

    @Name("выбрать Переместить")
    public FilePage selectMoving () {
        getDriver().findElement(By.xpath("//*[@class='ant-tree-title'][contains (., '" + REMOVE_FOLDER + "')]")).click();

        return this;
    }

    @Name("выбрать Удалить")
    public FilePage btnDelete() {
        getDriver().findElement(By.xpath("(//span[@class='ant-dropdown-menu-title-content'][contains(., 'Удалить')])[1]")).click();

        return this;
    }

    @Name("выбрать Открыть")
    public FilePage btnOpen() {
        getDriver().findElement(By.xpath("(//span[@class='ant-dropdown-menu-title-content'][contains(., 'Открыть')])[1]")).click();

        return this;
    }

    @Name("название папки")
    public FilePage folderName(String name) {
        getDriver().findElement(By.xpath("//*[@id='CreateFolderModal_title']")).sendKeys(name);

        return this;
    }

    @Name("Переименовал папку")
    public FilePage folderRename(String name) {
        getDriver().findElement(By.xpath("//*[@id='RenameModal_title']")).sendKeys(LEFT_CONTROL + "a");
        getDriver().findElement(By.xpath("//*[@id='RenameModal_title']")).sendKeys(name);

        return this;
    }

    @Name("Алерт")
    public String mecConfirm() {
        WaitT.littleWait(400);
        return getDriver().findElement(By.xpath("//*[@class='ant-message-notice-content']")).getText();
    }

    @Name("Папка открыта в проекте")
    public String mecOpenFolder() {
        WaitT.littleWait(200);
        return getDriver().findElement(By.xpath("//*[@class='ant-empty-description']")).getText();
    }

    @Name("")
    public String mecMovingFolder() {
        WaitT.littleWait(200);
        return getDriver().findElement(By.xpath("//*[@class='ant-message-notice-content']")).getText();
    }
}
