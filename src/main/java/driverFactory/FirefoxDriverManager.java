package driverFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

import commons.DataHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {
//	@Override
//	protected void createDriver() {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//	}
	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		setDriver(new FirefoxDriver());
	}

}
