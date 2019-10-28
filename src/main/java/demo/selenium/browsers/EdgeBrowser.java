package demo.selenium.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser extends Browser {

	@Override
	WebDriver getDriver() {
		if (!OS.contains("Window")) {
			throw new IllegalArgumentException("Edge browser is available only on Windows! Current OS: " + OS);
		}
		return new EdgeDriver();
	}
}
