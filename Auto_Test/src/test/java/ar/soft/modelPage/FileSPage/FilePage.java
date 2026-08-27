package ar.soft.modelPage.FileSPage;

import ar.soft.modelPage.base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qa.methods.WaitT;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ar.soft.AT.UI.FileTest.FileTest.NEW_FOLDER;
import static ar.soft.AT.UI.FileTest.FileTest.REMOVE_FOLDER;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.LEFT_CONTROL;

public class FilePage extends BasePage {

    public FilePage(WebDriver driver) {
        super(driver);
    }

    public final By columnNameList = By.xpath("//*[@class='ant-dropdown-trigger dropdown-icon']");

    @Name("кнопка добавить")
    public FilePage folderAdd() {
        getDriver().findElement(By.xpath("//*[@data-test-id='button'][contains(., 'Добавить')]")).click();

        return this;
    }

    @Name("кнопка троеточие")
    public FilePage ellipsisButton() {
        getDriver().findElement(By.xpath("//*[@class='ContentFileStorage__content-iconBlock']")).click();

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

    @Name("вызов контекстного меню ПKM")
    public FilePage btnPRMClick() {
        Actions actions = new Actions(getDriver());
        WebElement btnElement = getDriver().findElement(xpath("//*[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r ContentFileStorage__content-title']"));
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
    public FilePage selectMoving() {
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

    @Name("")
    public List<String> mecMovilngFolder() {
        WaitT.littleWait(200);
        return Collections.singletonList(getDriver().findElement(xpath("//*[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-rightTop ']//*[@data-test-id='text']")).getText());
    }

//    @Name("")
//    public String mecMovingpFolder() {
//        WaitT.littleWait(200);
//        return getDriver().findElement(By.xpath("//*[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r ContentFileStorage__content-title']")).click();
//    }

//    public List<String> getTextItemsSidePanel() {
//        List<String> textValue = new ArrayList<>();
//        for (WebElement item : itemsSidePanel) {
//            textValue.add(item.getText());
//        }
//
//        return textValue;
//    }

    @Name("список контекстного меню")
    @FindBy(xpath = "//*[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-rightTop ']//*[@data-test-id='text']")
    public List<WebElement> nameButton;

    public List<String> getNameButtonText() {
        return nameButton.stream().map(WebElement::getText).toList();
    }

    @Name("список кнопок в троеточие")
    @FindBy(xpath = "//*[@class='ant-dropdown Dropdown undefined ant-dropdown-placement-leftTop ']//*[@data-test-id='text']")
    public List<WebElement> nameButtonEllipsis;

    public List<String> getNameButtonEllipsisText() {
        return nameButtonEllipsis.stream().map(WebElement::getText).toList();
    }

    public FilePage goAboutJenkins() {
//        jenkinsVersionButton.click();
//        aboutJenkinsButton.click();

        return this;
    }
//    public Container.Self clickJenkinsVersionButton() {
//        getWait10().until(ExpectedConditions.elementToBeClickable(jenkinsVersionButton)).click();
//
//        return (Container.Self)this;
//    }
//
//    public List<String> getVersionJenkinsTippyBoxText() {
//        getWait10().until(ExpectedConditions.visibilityOf(tippyBox));
//
//        return jenkinsVersionButton.stream().map(WebElement::getText).toList();
//    }

//    @Step("Метод для проверки ожидаемого перечня команд в контексном меню")
//    public void checkCommandList(List<String> commands) {
//        columnNameList.findElement().click();
//        for (String command : commands) {
//            $(byText(command)).shouldBe(visible);
//        }
//    }

//    @Step("Метод для проверки ожидаемого перечня команд в контексном меню")
//    public void checkCommandList(List<String> commands) {
//        columnNameList.first().contextClick();
//        for (String command : commands) {
//            $(byText(command)).shouldBe(visible);
//        }
//    }

    @Step("Проверяем сортировку элементов колонки")
    public void clickAndCheckSortColumn(SelenideElement header, ElementsCollection columnElement) {
        // Кликаем на заголовок для сортировки
        header.click();

        // Ожидаем, пока иконка сортировки станет видимой
        $x("//*[@data-test-id='data-sort-item-text'][contains (., 'Название')]")
                .as("Сортировка А-Я").click();
//                .shouldBe(visible, Duration.ofSeconds(10));

        // Ожидаем, пока элементы на странице отсортируются
        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            List<String> currentTexts = columnElement.texts();
            int sortedPairsCount = 0;
            for (int i = 1; i < currentTexts.size(); i++) {
                if (currentTexts.get(i - 1).compareToIgnoreCase(currentTexts.get(i)) <= 0) {
                    sortedPairsCount++; // Увеличиваем счетчик, если порядок правильный
                }
            }
            // Проверяем, что больше половины пар отсортировано
            return sortedPairsCount >= (currentTexts.size() - 1) / 2;
        });

        // Собираем тексты элементов, исключая ненужные
        List<String> textList = new ArrayList<>();
        for (SelenideElement element : columnElement) {
            String text = element.getText();
            if (!text.contains("_") && !text.contains("ЯЯЯЯ") && !text.isEmpty()) {
                textList.add(text);
            }
        }
    }
}
