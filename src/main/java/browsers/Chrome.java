package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.Loggers;

public class Chrome {

	public WebDriver chrome_setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1280,800");

		WebDriver driver = new ChromeDriver(options);
		Loggers.logger.info("starting chrome driver");
		return driver;

	}
}
