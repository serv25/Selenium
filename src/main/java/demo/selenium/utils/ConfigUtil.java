package demo.selenium.utils;

import java.io.File;
import java.util.Properties;

public class ConfigUtil {

	private static Properties properties = null;

	public static String getProperty(String key) {

		if (properties == null) {
			String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "config"
					+ File.separator + "config.properties";
			properties = PropertyUtil.getProperties(path);
		}

		String value = properties.getProperty(key);

		if (value == null) {
			throw new IllegalArgumentException("No properties found with key " + key);
		}
		return value;
	}

	public static Long getImplicitWaitTimeProperty() {
		return Long.valueOf(getProperty("implicitWait"));
	}

	public static Long getExplicitWaitTimeProperty() {
		return Long.valueOf(getProperty("explicitWait"));
	}

	public static Long getPageLoadTimeProperty() {
		return Long.valueOf(getProperty("pageLoadTime"));
	}
}
