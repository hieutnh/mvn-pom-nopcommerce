package reportConfig;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;

public class TestClassUsingListeners extends AbstractTest {
	WebDriver driver;

	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);
	}

	@Test
	public void TC_01_Success() {
		System.out.println("Executing Successful Test Method");

	}

	@Test
	public void TC_02_Failed() {
		System.out.println("Executing Failed Test Method");
		Assert.fail("Executing Failed Test Method");

	}

	@Test
	public void TC_02_Skipped() {
		System.out.println("Executing Skipped Test Method");
		throw new SkipException("Executing Failed Test Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}