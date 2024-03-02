package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Edge {

	
	public WebDriver edge_setup() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1280,800");
		WebDriver driver = new EdgeDriver(options);
		return driver;

	}
}
