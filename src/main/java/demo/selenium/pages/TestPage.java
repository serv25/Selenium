package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPage {

	private WebDriver driver;
	private final Logger log = Logger.getLogger(TestPage.class);

	@FindBy(xpath = "(//a[contains(.,'Input Forms')])[2]")
	WebElement inputFormsLink;

	@FindBy(xpath = "(//a[@href='./basic-first-form-demo.html'])[2]")
	WebElement simpleFormDemoLink;

	public TestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnInputFormsLink() {
		log.info("Click on \'Input Forms\' link");
		inputFormsLink.click();
	}

	public SimpleFormPage clickOnSimpleFormDemoLink() {
		log.info("Click on \'Simple Form Demo\' link");
		simpleFormDemoLink.click();
		return new SimpleFormPage(driver);
	}
}
