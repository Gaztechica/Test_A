package ar.soft.modelPage.FileSPage;

import ar.soft.modelPage.base.BasePage;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import static org.openqa.selenium.By.xpath;

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

    @Name("кнопка добавить2")
    public FilePage folderAdd2() {
        getDriver().findElement(By.xpath("(//*[@data-test-id='button'][contains(., 'Добавить')])[2]")).click();

        return this;
    }

    @Name("check новая папка")
    public String checkCreateFolder() throws InterruptedException {
        Thread.sleep(100);
        return getDriver().findElement(xpath("//*[@data-test-id='text'][contains(., 'новая папка')]")).getText();
    }

    @Name("кнопка редактировать ПKM название папки")
    public FilePage btnRemovePRMFolderClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//*[@data-test-id='text'][contains(., 'новая папка')]"));
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

    @Name("название папки")
    public FilePage folderName(String name) {
        getDriver().findElement(By.xpath("//*[@id='CreateFolderModal_title']")).sendKeys(name);

        return this;
    }

    @Name("Переименовал папку")
    public FilePage folderRename(String name) {
        getDriver().findElement(By.xpath("//*[@id='RenameModal_title']")).sendKeys(name);

        return this;
    }
}
