package demo.selenium.browsers;

import java.io.File;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

	protected static final String OS;
	protected static final String DRIVERS_DIR;

	static {
		OS = System.getProperty("os.name");
		DRIVERS_DIR = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "drivers";
	}

	abstract WebDriver getDriver();

}
