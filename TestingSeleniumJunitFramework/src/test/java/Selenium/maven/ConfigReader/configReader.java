package Selenium.maven.ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
	Properties pro;

	public configReader() {
		try {
			File src = new File("./configs/configuration.properties");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is =====" + e.getMessage());
		}
	}

	public String appUrl() {
		return pro.getProperty("SauceDemoUrl");
	}

}
