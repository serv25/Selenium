package demo.selenium;

import org.openqa.selenium.WebDriver;

import demo.selenium.browsers.ChromeBrowser;
import demo.selenium.browsers.EdgeBrowser;
import demo.selenium.browsers.FirefoxBrowser;

public class DriverFactory {

	public static WebDriver getDriver() {

		String browser = System.getProperty("browser", "Firefox");

		if (browser.equalsIgnoreCase("Chrome")) {
			return new ChromeBrowser().getDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			return new FirefoxBrowser().getDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			return new EdgeBrowser().getDriver();
		} else {
			throw new IllegalArgumentException("Unknown browser - " + browser);
		}

	}

}
