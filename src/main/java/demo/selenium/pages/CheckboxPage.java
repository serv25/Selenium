package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.selenium.utils.ConfigUtil;

public class CheckboxPage {

	private WebDriverWait wait;
	private final Logger log = Logger.getLogger(CheckboxPage.class);

	@FindBy(xpath = "//div[@id='txtAge']")
	public WebElement successTxt;

	@FindBy(xpath = "//input[@id='isAgeSelected']")
	public WebElement singleCheckbox;

	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[2]")
	public WebElement option1Checkbox;

	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[3]")
	public WebElement option2Checkbox;

	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[4]")
	public WebElement option3Checkbox;

	@FindBy(xpath = "(//input[contains(@type,'checkbox')])[5]")
	public WebElement option4Checkbox;

	@FindBy(xpath = "//input[@id='check1']")
	public WebElement checkAllBtn;

	public CheckboxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
	}

	public void clickOnSingleCheckbox() {
		log.info("Click on \'Click on this check box\' checkbox");
		wait.until(ExpectedConditions.elementToBeClickable(singleCheckbox));
		singleCheckbox.click();
	}

	public boolean isSingleCheckboxSelected() {
		return singleCheckbox.isSelected();
	}

	public boolean isSuccessMessageDisplayed() {
		log.info("Check if success message is displayed");
		wait.until(ExpectedConditions.visibilityOfAllElements(successTxt));
		return successTxt.isDisplayed();
	}

	public void clickOncheckAllBtn() {
		log.info("Click on \'Check All\' button");
		wait.until(ExpectedConditions.elementToBeClickable(checkAllBtn));
		checkAllBtn.click();
	}

	public void clickOnOption1Checkbox() {
		log.info("Click on \'Option 1\' checkbox");
		wait.until(ExpectedConditions.elementToBeClickable(option1Checkbox));
		option1Checkbox.click();
	}

	public void clickOnOption2Checkbox() {
		log.info("Click on \'Option 2\' checkbox");
		wait.until(ExpectedConditions.elementToBeClickable(option2Checkbox));
		option2Checkbox.click();
	}

	public void clickOnOption3Checkbox() {
		log.info("Click on \'Option 3\' checkbox");
		wait.until(ExpectedConditions.elementToBeClickable(option3Checkbox));
		option3Checkbox.click();
	}

	public String getCheckAllBtnText() {
		log.info("Get \'Check All\' button text");
		long waitTimeMs = 500;
		try {
			log.info("Wait for " + waitTimeMs + " ms");
			Thread.sleep(waitTimeMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return checkAllBtn.getAttribute("value");
	}
}
