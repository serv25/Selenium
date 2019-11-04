package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.selenium.utils.ConfigUtil;

public class CheckboxPage {

	private WebDriver driver;
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
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, ConfigUtil.getExplicitWaitTimeProperty());
	}
}
