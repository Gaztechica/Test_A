package ar.soft.AT.UI.modelPage.FileSPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class FileSPage {

    private SelenideElement
            projectS = $x("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'test Regress')]"),
            fileSidebarS = $x("//span[@class='ant-menu-title-content'][contains(.,'Файлы')]"),
            folderAddS = $x("//*[@data-test-id='button'][contains(., 'Добавить')]"),
            folderSelectS = $x("//*[@data-test-id='text'][contains(., 'Папка')]"),
            folderNameS = $x("//*[@id='CreateFolderModal_title']"),
            inputReportsButton = $x("//button[@data-testid='Button8']").as("Ввод (InputReportsNS)"),
            fileAddButton = $x("//form[@id='CreateFolderModal']//button[@type='submit']")
                    .as("кнопка добавить");


    @Step("Открыть проект")
    public FileSPage openProjects() {
        projectS.click();
        return this; // Возвращаем эту же страницу для продолжения цепочки
    }

    public void fileSidebarS() {
        fileSidebarS.click();
    }

    public void folderAddS() {
        folderAddS.click();
    }

    public void folderSelectS() {
        folderSelectS.click();
    }

    public void folderNameS() {
        folderNameS.click();
    }

    public void inputReportsButton() {
        inputReportsButton.click();
    }

    public void fileAddButton() {
        fileAddButton.click();
    }

    public FileSPage openProjectsAndFiles() {
        projectS.click();
        fileSidebarS.click();
        return this;
    }

    // 3. Ваш отличный метод (оставляем, добавив аннотацию по желанию)
    @Step("Создать новую папку: {folderName}")
    public FileSPage createNewFolder(String folderName) {
        folderAddS.click();
        folderSelectS.click();
        folderNameS.sendKeys(folderName);
        fileAddButton.click();
        return this;
    }

    @Step("Алерт")
    public void mecConfirm(String expectedText) {
        $x("//*[@class='ant-message-notice-content']").shouldHave(text(expectedText));
    }

}