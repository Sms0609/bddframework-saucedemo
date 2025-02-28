package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void setUp() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("chrome://settings/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("chrome.settingsPrivate.setDefaultZoom(0.67);");
		}
	}

	@After
	public void tearDown() {
		// Do NOT close the driver after each scenario
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}