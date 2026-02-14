package ar.soft.modelPage.FileSPage;

import ar.soft.modelPage.base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class FileSPage extends BasePage {

    public FileSPage(WebDriver driver) {
        super(driver);
    }

//   создать и  добавить базовую страницу и баз тест для логирования на селениде
    public final SelenideElement
            projectS = $x("//div[@class='ant-typography ant-typography-ellipsis ant-typography-single-line ant-typography-ellipsis-single-line p_r'][contains(.,'11AAНовый проект')]"),
            fileSidebarS = $x("//span[@class='ant-menu-title-content'][contains(.,'Файлы')]"),
            folderAddS = $x("//*[@data-test-id='button'][contains(., 'Добавить')]"),
            folderSelectS = $x("//*[@data-test-id='text'][contains(., 'Папка')]"),
            folderNameS = $x("//*[@id='CreateFolderModal_title']"),
            inputReportsButton = $x("//button[@data-testid='Button8']").as("Ввод (InputReportsNS)"),
            fileAddButton = $x("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")
                    .as("кнопка добавить");
}
