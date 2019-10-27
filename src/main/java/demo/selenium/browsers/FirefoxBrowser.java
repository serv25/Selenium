package demo.selenium.browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser extends Browser {

	@Override
	WebDriver getDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);

		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setCapability("marionette", true);

		FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);

		if (OS.contains("Window")) {
			setFirefoxProperties(DRIVERS_DIR + File.separator + "windows" + File.separator + "geckodriver.exe");
		} else if (OS.contains("Mac")) {
			setFirefoxProperties(DRIVERS_DIR + File.separator + "mac" + File.separator + "geckodriver");
		} else if (OS.contains("Linux")) {
			firefoxOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
			setFirefoxProperties(DRIVERS_DIR + File.separator + "linux" + File.separator + "geckodriver");
		} else {
			throw new IllegalArgumentException("Unknown OS: " + OS);
		}

		return new FirefoxDriver(firefoxOptions);
	}

	private void setFirefoxProperties(String driverPath) {
		System.setProperty("webdriver.gecko.driver", driverPath);
	}

}
