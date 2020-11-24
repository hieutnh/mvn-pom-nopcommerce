package driverFactory;

public class DriverFactory {
	public static DriverManager getBrowserDriver(String BrowserName) {
		DriverManager driverManager;

		if (BrowserName.equalsIgnoreCase("firefox_ui")) {
			driverManager = new FirefoxDriverManager();
		} else if (BrowserName.equalsIgnoreCase("chrome_ui")) {
			driverManager = new ChromeDriverManager();
		} else if (BrowserName.equalsIgnoreCase("edge_chromium")) {
			driverManager = new EdgeDriverManager();
		} else {
			throw new RuntimeException("Please input valid browser name");
		}
		return driverManager;
	}
}
