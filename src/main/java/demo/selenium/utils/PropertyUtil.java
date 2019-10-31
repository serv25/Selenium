package demo.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static Properties getProperties(String path) {
		Properties properties = null;

		try (InputStream input = new FileInputStream(path)) {
			properties = new Properties();
			properties.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(properties == null) {
			throw new NullPointerException("Failed to load properties from " + path);
		}
		
		return properties;
	}
}
