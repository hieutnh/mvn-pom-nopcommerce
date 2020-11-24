package driverFactory;

import java.util.Collections;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.DataHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		// dissable infobars chrome
//		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//		options.setExperimentalOption("useAutomationExtension", false);
//		driver = new ChromeDriver(options);
//	}
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// dissable infobars chrome
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		setDriver(new ChromeDriver(options));
	}

}
