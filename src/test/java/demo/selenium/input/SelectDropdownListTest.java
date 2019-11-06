package demo.selenium.input;

import demo.selenium.TestBase;
import demo.selenium.pages.MainPage;
import demo.selenium.pages.SelectDropdownListPage;
import demo.selenium.pages.TestPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectDropdownListTest extends TestBase {

    private SelectDropdownListPage dropdownListPage;
    private static final String EXPECTED_MESSAGE_FOR_SELECTED_DAY = "Day selected :- Monday";

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        super.beforeMethod(result);
        driver.get(host);
        MainPage mainPage = new MainPage(driver);
        TestPage testPage = mainPage.clickOnDemoWebsiteBtn();
        testPage.clickOnInputFormsLink();
        dropdownListPage = testPage.clickOnSelectDropdownListLink();
    }

    @Test
    public void singleSelectByTextTest() {
        dropdownListPage.selectDayByText("Monday");
        Assert.assertEquals(dropdownListPage.getSelectedDay(), EXPECTED_MESSAGE_FOR_SELECTED_DAY);
    }

    @Test
    public void singleSelectByValueTest() {
        dropdownListPage.selectDayByValue("Monday");
        Assert.assertEquals(dropdownListPage.getSelectedDay(), EXPECTED_MESSAGE_FOR_SELECTED_DAY);
    }

    @Test
    public void singleSelectByIndexTest() {
        dropdownListPage.selectDayByIndex(2);
        Assert.assertEquals(dropdownListPage.getSelectedDay(), EXPECTED_MESSAGE_FOR_SELECTED_DAY);
    }

    @Test
    public void multiSelectTest() {
        List<String> states = Arrays.asList("New Jersey", "Pennsylvania", "New York");
        dropdownListPage.selectStateByText(states);
        List<String> selectedStates = dropdownListPage.getSelectedStates();

        int count = 0;
        for (String expectedState : states) {
            for (String selectedState : selectedStates) {
                if (expectedState.equals(selectedState)) {
                    count++;
                    break;
                }
            }
        }
        Assert.assertEquals(states.size(), count,
                "Should be selected states " + states.toString() + " but found " + selectedStates.toString());
    }
}
