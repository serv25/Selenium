package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.selenium.utils.ConfigUtil;

public class TestPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private final Logger log = Logger.getLogger(TestPage.class);

	@FindBy(xpath = "//a[@href='#'][contains(.,'All Examples')]")
	public WebElement allExamplesLink;

	@FindBy(xpath = "(//a[contains(.,'Input Forms')])[2]")
	public WebElement inputFormsLink;

	@FindBy(xpath = "(//a[@href='./basic-first-form-demo.html'])[2]")
	public WebElement simpleFormDemoLink;

	@FindBy(xpath = "(//a[@href='./basic-checkbox-demo.html'])[2]")
	public WebElement checkboxDemoLink;

	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
	}

	public void clickOnInputFormsLink() {
		if (!inputFormsLink.isDisplayed()) {
			log.info("Click on \'All Examples\' link");
			wait.until(ExpectedConditions.elementToBeClickable(allExamplesLink));
			allExamplesLink.click();
		}

		log.info("Click on \'Input Forms\' link");
		wait.until(ExpectedConditions.elementToBeClickable(inputFormsLink));
		inputFormsLink.click();
	}

	public SimpleFormPage clickOnSimpleFormDemoLink() {
		if (!inputFormsLink.isDisplayed()) {
			log.info("Click on \'Input Forms\' link");
			wait.until(ExpectedConditions.elementToBeClickable(inputFormsLink));
			inputFormsLink.click();
		}

		log.info("Click on \'Simple Form Demo\' link");
		wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemoLink));
		simpleFormDemoLink.click();
		return new SimpleFormPage(driver);
	}

	public CheckboxPage clickOnCheckboxDemoLink() {
		if (!inputFormsLink.isDisplayed()) {
			log.info("Click on \'Input Forms\' link");
			wait.until(ExpectedConditions.elementToBeClickable(inputFormsLink));
			inputFormsLink.click();
		}

		log.info("Click on \'Checkbox Demo\' link");
		wait.until(ExpectedConditions.elementToBeClickable(checkboxDemoLink));
		checkboxDemoLink.click();
		return new CheckboxPage(driver);
	}

}
