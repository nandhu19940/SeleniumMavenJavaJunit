package Selenium.maven.Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.maven.ConfigReader.configReader;

public class verifyLoginFunction {

	private static WebDriver driver;
	WebElement element;
	configReader obj = new configReader();

	@BeforeClass
	public static void openBrowser() throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		URL remoteURL = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(remoteURL, options);

	}

	@Before
	public void launchWebsite() throws MalformedURLException {
		driver.get(obj.appUrl());
	}

	@Test
	public void loginToSauceDemo() {
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals("Swag Labs", pageTitle);
		WebElement username = driver.findElement(By.xpath(obj.usernameTextBox()));
		WebElement password = driver.findElement(By.xpath(obj.passwordTextBox()));
		WebElement loginButton = driver.findElement(By.xpath(obj.loginButton()));
		username.sendKeys(obj.userID());
		password.sendKeys(obj.passcode());
		loginButton.click();

		final WebDriverWait waitForDashBoradPageElement = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForDashBoradPageElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.productText())));
		WebElement dashBoradConfirmationPage = driver.findElement(By.xpath(obj.productText()));
		String dashBoradPageTextVerify = dashBoradConfirmationPage.getText();
		if (dashBoradPageTextVerify.equals(obj.productTextVerification())) {
			System.out.println("Successfully entered in dashboard page and verified the element successfully");
		}
	}

	@After
	public void closeBrowserSession() {
		driver.quit();
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(verifyLoginFunction.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Result==" + result.wasSuccessful());
	}
}
