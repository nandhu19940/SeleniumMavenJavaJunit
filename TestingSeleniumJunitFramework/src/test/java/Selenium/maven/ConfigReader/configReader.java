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

	public String usernameTextBox() {
		return pro.getProperty("usernameField");
	}

	public String passwordTextBox() {
		return pro.getProperty("passwordField");
	}

	public String userID() {
		return pro.getProperty("UserID");
	}

	public String passcode() {
		return pro.getProperty("Passcode");
	}

	public String loginButton() {
		return pro.getProperty("loginbutton");
	}

	public String faceBookUrl() {
		return pro.getProperty("FBurl");
	}

	public String usernameTextBoxFacebook() {
		return pro.getProperty("UsernameFieldFB");
	}

	public String passwordTextBoxFacebook() {
		return pro.getProperty("PasswordFieldFB");
	}

	public String userIDFacebook() {
		return pro.getProperty("UserIDFB");
	}

	public String passcodeFacebook() {
		return pro.getProperty("PasscodeFB");
	}

	public String loginButtonFacebook() {
		return pro.getProperty("LoginButtonFB");
	}

	public String productText() {
		return pro.getProperty("productText");
	}

	public String productTextVerification() {
		return pro.getProperty("productTextExpected");
	}

}
