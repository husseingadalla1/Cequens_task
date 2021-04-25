package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait driver_wait;

	@BeforeSuite
	@Parameters({ "browser" })
	public void startDriver(@Optional("chrome") String browser_name) {
		if (browser_name.equalsIgnoreCase("chrome")) {
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--disable-notifications");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			String chrome_path = System.getProperty("user.dir") + "\\Updated drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chrome_path);

			driver = new ChromeDriver(options);
		}
		if (browser_name.equalsIgnoreCase("firefox")) {
			String firefox_path = System.getProperty("user.dir") + "\\Updated drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", firefox_path);
			driver = new FirefoxDriver();
		}

		driver.navigate().to("http://www.phptravels.net");
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

}
