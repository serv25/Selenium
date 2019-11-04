package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.selenium.utils.ConfigUtil;

public class RadioButtonsPage {

	private WebDriverWait wait;
	private final Logger log = Logger.getLogger(RadioButtonsPage.class);

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement maleRadioBtn;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement femaleRadioBtn;

	@FindBy(xpath = "//button[@id='buttoncheck']")
	WebElement checkedValueBtn;

	@FindBy(xpath = "//p[@class='radiobutton']")
	WebElement checkedValuesTxt;

	@FindBy(xpath = "(//label[@class='radio-inline'])[3]")
	WebElement groupMaleRadioBtn;

	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement groupFemaleRadioBtn;

	@FindBy(xpath = "//input[@value='0 - 5']")
	WebElement group0to5RadioBtn;

	@FindBy(xpath = "//input[@value='5 - 15']")
	WebElement group5to15RadioBtn;

	@FindBy(xpath = "//input[@value='15 - 50']")
	WebElement group15to50RadioBtn;

	@FindBy(xpath = "//button[@onclick='getValues();']")
	WebElement groupValuesBtn;

	@FindBy(xpath = "//p[contains(@class,'groupradiobutton')]")
	WebElement groupValuesTxt;

	public RadioButtonsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
	}

	public void clickOnMaleRadioBtn() {
		log.info("Click on \'Male\' radio button");
		wait.until(ExpectedConditions.elementToBeClickable(maleRadioBtn));
		maleRadioBtn.click();
	}

	public void clickOnFemaleRadioBtn() {
		log.info("Click on \'Female\' radio button");
		wait.until(ExpectedConditions.elementToBeClickable(femaleRadioBtn));
		femaleRadioBtn.click();
	}

	public void clickOnCheckedValueBtn() {
		log.info("Click on \'Get Checked value\' button");
		wait.until(ExpectedConditions.elementToBeClickable(checkedValueBtn));
		checkedValueBtn.click();
	}

	public String getCheckedValue() {
		log.info("Get checked value message");
		wait.until(ExpectedConditions.visibilityOfAllElements(checkedValuesTxt));
		return checkedValuesTxt.getText();
	}

	public void clickOnGroupMaleRadioBtn() {
		log.info("Click on \'Male\' radio button in Group Radio Buttons section");
		wait.until(ExpectedConditions.elementToBeClickable(groupMaleRadioBtn));
		groupMaleRadioBtn.click();
	}

	public void clickOnGroup15to50RadioBtn() {
		log.info("Click on \'15 -50\' radio button in Group Radio Buttons section");
		wait.until(ExpectedConditions.elementToBeClickable(group15to50RadioBtn));
		group15to50RadioBtn.click();
	}

	public void clickOnGroupValuesBtn() {
		log.info("Click on \'Get values\' button in Group Radio Buttons section");
		wait.until(ExpectedConditions.elementToBeClickable(groupValuesBtn));
		groupValuesBtn.click();
	}

	public String getCheckedGroupValues() {
		log.info("Get checked group value message");
		wait.until(ExpectedConditions.visibilityOfAllElements(groupValuesTxt));
		return groupValuesTxt.getText();
	}
}
