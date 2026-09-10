package ar.soft.modelPage.FileSPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FileSPage {

    public SelenideElement
            projectS = $x("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'test Regress')]"),
            fileSidebarS = $x("//span[@class='ant-menu-title-content'][contains(.,'Файлы')]"),
            folderAddS = $x("//*[@data-test-id='button'][contains(., 'Добавить')]"),
            folderSelectS = $x("//*[@data-test-id='text'][contains(., 'Папка')]"),
            folderNameS = $x("//*[@id='CreateFolderModal_title']"),
            inputReportsButton = $x("//button[@data-testid='Button8']").as("Ввод (InputReportsNS)"),
            fileAddButton = $x("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")
                    .as("кнопка добавить");


    public void projectS() {
        projectS.click();
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


}