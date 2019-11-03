package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {

	private WebDriver driver;
	private final Logger log = Logger.getLogger(SimpleFormPage.class);

	@FindBy(xpath = "//input[@id='user-message']")
	WebElement enterMessageInput;

	@FindBy(xpath = "//button[contains(@onclick,'showInput();')]")
	WebElement showMessageBtn;

	@FindBy(xpath = "//span[@id='display']")
	WebElement displayedMessageTxt;

	public SimpleFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		return displayedMessageTxt.getText();
	}
}
