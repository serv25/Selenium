package demo.selenium.input;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.selenium.TestBase;
import demo.selenium.pages.MainPage;
import demo.selenium.pages.SimpleFormPage;
import demo.selenium.pages.TestPage;

public class SimpleFormTest extends TestBase {

	private SimpleFormPage simpleFormPage;

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		super.beforeMethod(result);
		driver.get(host);
		MainPage mainPage = new MainPage(driver);
		TestPage testPage = mainPage.clickOnDemoWebsiteBtn();
		testPage.clickOnInputFormsLink();
		simpleFormPage = testPage.clickOnSimpleFormDemoLink();
	}

	@Test
	public void testSingleInputField() {
		String message = "Test Message!";
		simpleFormPage.enterMessage(message);
		simpleFormPage.clickOnshowMessageBtn();
		Assert.assertEquals(simpleFormPage.getDisplayedMessageTxt(), message);
	}

	@Test
	public void testTwoInputFields() {
		int digitA = 7;
		int digitB = 3;

		simpleFormPage.enterA(String.valueOf(digitA));
		simpleFormPage.enterB(String.valueOf(digitB));
		simpleFormPage.clickOnGetTotalBtn();

		String total = simpleFormPage.getTotalTxt();
		Assert.assertEquals(total, String.valueOf(digitA + digitB));
	}

}
