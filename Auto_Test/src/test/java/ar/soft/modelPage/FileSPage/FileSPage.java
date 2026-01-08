package ar.soft.modelPage.FileSPage;

import ar.soft.modelPage.base.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class FileSPage extends BasePage {

    public FileSPage(WebDriver driver) {
        super(driver);
    }

    public final SelenideElement
            inputReportsButton = $x("//button[@data-testid='Button8']").as("Ввод (InputReportsNS)"),
            fileAddButton = $x("(//*[@class='ant-btn ant-btn-default primaryButton big colorPrimary '][contains(., 'Добавить')])[2]")
                    .as("кнопка добавить");
}
