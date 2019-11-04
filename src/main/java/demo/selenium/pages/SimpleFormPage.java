package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.selenium.utils.ConfigUtil;

public class SimpleFormPage {

	private WebDriverWait wait;
	private final Logger log = Logger.getLogger(SimpleFormPage.class);

	@FindBy(xpath = "//input[@id='user-message']")
	public WebElement enterMessageInput;

	@FindBy(xpath = "//button[contains(@onclick,'showInput();')]")
	public WebElement showMessageBtn;

	@FindBy(xpath = "//span[@id='display']")
	public WebElement displayedMessageTxt;

	@FindBy(xpath = "//input[@id='sum1']")
	public WebElement enterAInput;

	@FindBy(xpath = "//input[@id='sum2']")
	public WebElement enterBInput;

	@FindBy(xpath = "//button[@onclick='return total()']")
	public WebElement getTotalBtn;

	@FindBy(xpath = "//span[@id='displayvalue']")
	public WebElement totalTxt;

	public SimpleFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
	}

	public void enterMessage(String message) {
		log.info("Enter message \'" + message + "\' into input \'Enter message\'");
		enterMessageInput.sendKeys(message);
	}

	public void clickOnshowMessageBtn() {
		log.info("Click on \'Show Message\' button");
		showMessageBtn.click();
	}

	public String getDisplayedMessageTxt() {
		log.info("Get text of WebElement \'Your Message:\'");
		wait.until(ExpectedConditions.visibilityOfAllElements(displayedMessageTxt));
		return displayedMessageTxt.getText();
	}

	public void enterA(String digit) {
		log.info("Enter message \'" + digit + "\' into input \'Enter a\'");
		wait.until(ExpectedConditions.visibilityOfAllElements(enterAInput));
		enterAInput.sendKeys(digit);
	}

	public void enterB(String digit) {
		log.info("Enter message \'" + digit + "\' into input \'Enter b\'");
		wait.until(ExpectedConditions.visibilityOfAllElements(enterBInput));
		enterBInput.sendKeys(digit);
	}

	public void clickOnGetTotalBtn() {
		log.info("Click on \'Get Total\' button");
		getTotalBtn.click();
	}

	public String getTotalTxt() {
		log.info("Get text of WebElement \'Total a + b =\'");
		wait.until(ExpectedConditions.visibilityOfAllElements(totalTxt));
		return totalTxt.getText();
	}
}
