package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import browsers.Chrome;
import browsers.Edge;
import browsers.Firefox;

public class Setup {
	public WebDriver driver;
	public Properties prop;
	private FileReader fr;
	private CustomActions custom_actions;
	private Actions built_in_actions;

	@Parameters("browser")
	@BeforeMethod
	public void initialize_driver(String browser) {
		try {
			fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "config.properties");
		} catch (FileNotFoundException e) {
			Loggers.logger.fatal("can't find configuration file");
		}
		prop = new Properties();

		try {
			prop.load(fr);
		} catch (IOException e) {
			Loggers.logger.fatal("can't read the configuration file");
		}

		if (browser.trim().toLowerCase().equals("chrome")) {
			Chrome ch = new Chrome();
			driver = ch.chrome_setup();

		} else if (browser.trim().toLowerCase().equals("firefox")) {
			Firefox fx = new Firefox();
			driver = fx.firefox_setup();
		} else if (browser.trim().toLowerCase().equals("edge")) {
			Edge fx = new Edge();
			driver = fx.edge_setup();
		}

		SafeThread.setDriver(driver);
		SafeThread.getDriver().navigate().to(prop.getProperty("url"));
		Loggers.logger.info("navigate to " + prop.getProperty("url"));

	}

	public CustomActions getCustomActions() {
		if (custom_actions instanceof CustomActions) {
			return custom_actions;
		} else {
			custom_actions = new CustomActions();
			return custom_actions;
		}
	}

	public Actions getBuiltInActions() {
		if (built_in_actions instanceof Actions) {
			return built_in_actions;
		} else {
			built_in_actions = new Actions(SafeThread.getDriver());
			return built_in_actions;
		}
	}

	@AfterMethod
	public void tear_driver() {
		SafeThread.getDriver().quit();
		SafeThread.unload();
		Loggers.logger.info("close drivers and tear down thread");
	}

}
