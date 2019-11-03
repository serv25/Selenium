package demo.selenium.input;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.selenium.TestBase;
import demo.selenium.pages.MainPage;
import demo.selenium.pages.SimpleFormPage;
import demo.selenium.pages.TestPage;

public class SimpleFormTest extends TestBase {

	@Test
	public void testSingleInputField() {
		driver.get(host);
		MainPage mainPage = new MainPage(driver);
		TestPage testPage = mainPage.clickOnDemoWebsiteBtn();
		testPage.clickOnInputFormsLink();
		SimpleFormPage simpleFormPage = testPage.clickOnSimpleFormDemoLink();

		String message = "Test Message!";
		simpleFormPage.enterMessage(message);
		simpleFormPage.clickOnshowMessageBtn();

		Assert.assertEquals(simpleFormPage.getDisplayedMessageTxt(), message);
	}

}
