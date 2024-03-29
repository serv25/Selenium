package demo.selenium.input;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.selenium.TestBase;
import demo.selenium.pages.CheckboxPage;
import demo.selenium.pages.MainPage;
import demo.selenium.pages.TestPage;

public class CheckboxTest extends TestBase {

	private CheckboxPage checkboxPage;

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		super.beforeMethod(result);
		driver.get(host);
		MainPage mainPage = new MainPage(driver);
		TestPage testPage = mainPage.clickOnDemoWebsiteBtn();
		testPage.clickOnInputFormsLink();
		checkboxPage = testPage.clickOnCheckboxDemoLink();
	}

	@Test(description = "Test single checkbox is selected after clicking on it")
	public void singleCheckboxTest() {
		checkboxPage.clickOnSingleCheckbox();
		Assert.assertTrue(checkboxPage.isSingleCheckboxSelected(),
				"Success message should be displayed when checkbox is selected!");
	}

	@Test(description = "Button \'Check All\' should have default text \'Check All\'")
	public void checkAllBtnTest() {
		String actualText = checkboxPage.getCheckAllBtnText();
		Assert.assertEquals(actualText, "Check All", "By default button\'s text should be \'Check All\'");
	}

	@Test(description = "Button \'Check All\' should have text \'Uncheck All\' after clicking on it")
	public void checkAllBtnTest2() {
		checkboxPage.clickOncheckAllBtn();
		String actualText = checkboxPage.getCheckAllBtnText();
		Assert.assertEquals(actualText, "Uncheck All", "Button\'s text should be \'Uncheck All\'");
	}

	@Test(description = "When 3 checkboxs are selected - button \'Check All\' should change text to \'Uncheck All\'")
	public void multipleCheckboxTest() {
		checkboxPage.clickOnOption1Checkbox();
		checkboxPage.clickOnOption2Checkbox();
		checkboxPage.clickOnOption3Checkbox();
		String actualText = checkboxPage.getCheckAllBtnText();
		Assert.assertEquals(actualText, "Check All", "Button\'s text should be \'Uncheck All\'");
	}
}
