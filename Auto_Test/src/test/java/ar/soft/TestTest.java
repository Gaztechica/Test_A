package ar.soft;

import ar.soft.element.ActionT;
import ar.soft.modelPage.TestPage;
import ar.soft.runner.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestTest extends BaseTest {


    @Test
    public void createTypesWork() throws InterruptedException {
        TestPage testPage = new TestPage(getDriver())
                 .btnAddCheck()
                 .btnCheckboxUserClick();
        testPage.newNameCheckClick2.click();
        ActionT.OneClick.clickAndEnterTextDeleteLineBreak(testPage.newNameCheckClick,  " Remove Name");
        ActionT.OneClick.click(testPage.newNameCheckClick);

    }

    public void setKey(String[] arg) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("rtyuio", 35);
        for (String key : map.keySet()){

        }
    }
}
