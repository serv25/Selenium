package demo.selenium.utils;

import java.io.File;
import java.util.Properties;

public class EnvironmentUtil {

	private static Properties properties = null;

	public static String getProperty(String key) {

		if (properties == null) {
			String environment = System.getProperty("environment", "qa").toLowerCase();
			String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "config"
					+ File.separator + "env_" + environment + ".properties";
			properties = PropertyUtil.getProperties(path);
		}

		String value = properties.getProperty(key);

		if (value == null) {
			throw new IllegalArgumentException("No properties found with key " + key);
		}
		return value;
	}

}
