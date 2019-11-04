package demo.selenium.input;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.selenium.TestBase;
import demo.selenium.pages.MainPage;
import demo.selenium.pages.RadioButtonsPage;
import demo.selenium.pages.TestPage;
import demo.selenium.utils.EnvironmentUtil;

public class RadioButtonsTest extends TestBase {

	private RadioButtonsPage radioButtonsPage;
	private String maleChecked;
	private String femaleChecked;
	private String groupChecked;

	@BeforeClass
	public void beforeClass() {
		super.beforeClass();
		maleChecked = EnvironmentUtil.getProperty("maleRadioBtnCheckedMessage");
		femaleChecked = EnvironmentUtil.getProperty("femaleRadioBtnCheckedMessage");
		groupChecked = EnvironmentUtil.getProperty("groupRadioBtnMessage");
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		super.beforeMethod(result);
		driver.get(host);
		MainPage mainPage = new MainPage(driver);
		TestPage testPage = mainPage.clickOnDemoWebsiteBtn();
		testPage.clickOnInputFormsLink();
		radioButtonsPage = testPage.clickOnRadioButtonsDemoLink();
	}

	@Test
	public void maleRadioBtnSelected() {
		radioButtonsPage.clickOnMaleRadioBtn();
		radioButtonsPage.clickOnCheckedValueBtn();
		String actualMessage = radioButtonsPage.getCheckedValue();
		Assert.assertEquals(actualMessage, maleChecked);
	}

	@Test
	public void femaleRadioBtnSelected() {
		radioButtonsPage.clickOnFemaleRadioBtn();
		radioButtonsPage.clickOnCheckedValueBtn();
		String message = radioButtonsPage.getCheckedValue();
		Assert.assertEquals(message, femaleChecked);
	}

	@Test
	public void sexAndAgeSelected() {
		radioButtonsPage.clickOnGroupMaleRadioBtn();
		radioButtonsPage.clickOnGroup15to50RadioBtn();
		radioButtonsPage.clickOnGroupValuesBtn();
		String message = radioButtonsPage.getCheckedGroupValues();
		Assert.assertEquals(message, groupChecked);
	}
}
