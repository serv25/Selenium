package demo.selenium.browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser extends Browser {

	@Override
	public WebDriver getDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-gpu");
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--window-size=1366,768");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);

		options.setCapability(ChromeOptions.CAPABILITY, capabilities);

		if (OS.contains("Window")) {
			setChromeProperties(DRIVERS_DIR + File.separator + "windows" + File.separator + "chromedriver.exe");
		} else if (OS.contains("Mac")) {
			setChromeProperties(DRIVERS_DIR + File.separator + "mac" + File.separator + "chromedriver");
		} else if (OS.contains("Linux")) {
			setChromeProperties(DRIVERS_DIR + File.separator + "linux" + File.separator + "chromedriver");
		} else {
			throw new IllegalArgumentException("Unknown OS: " + OS);
		}

		return new ChromeDriver(options);

	}

	private void setChromeProperties(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
	}
}
