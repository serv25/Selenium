package demo.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	private WebDriver driver;
	private final Logger log = Logger.getLogger(MainPage.class);

	@FindBy(xpath = "(//a[@class='btn btn-success'])[1]")
	WebElement btnDemoWebsite;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public TestPage clickOnDemoWebsiteBtn() {
		log.info("Click on \'Demo Website\' button");
		btnDemoWebsite.click();
		return new TestPage(driver);
	}
}
