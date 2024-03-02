package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox {

	public WebDriver firefox_setup() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1280,800");

		WebDriver driver = new FirefoxDriver(options);
		return driver;

	}
}
