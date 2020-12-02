package com.nopcommerce.users;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import reportConfigAllure.AllureTestListener;

@Listeners({AllureTestListener.class})
public class TestSum extends AbstractTest {
	WebDriver driver;
	WebElement element;
	Select select;
	Actions action;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor = (JavascriptExecutor) driver;
	}
	
	@Description("Check input data and total")
	@Story("Story 1 - Not input data")
	@Severity(SeverityLevel.NORMAL)
	public void TC_01_Not_Input_Value() {
		driver.findElement(By.xpath("//body/input[1]")).click();
		WebElement errorMessageNotInput = driver.findElement(By.xpath("//i[@id='message']"));
		String ABC = errorMessageNotInput.getText();
		verifyEquals(ABC, "Please input No1,Please input No2");
	}
	
	@Story("Story 2 - Not input data not valid")
	@Severity(SeverityLevel.NORMAL)
	public void TC_02_Input_Not_Invalid() {
		driver.findElement(By.xpath("//input[@id='No1']")).sendKeys("ABC");
		driver.findElement(By.xpath("//body/input[1]")).click();
		WebElement errorMessageNotValid = driver.findElement(By.xpath("//i[@id='message']"));
		driver.findElement(By.xpath("//body/input[1]")).click();
		verifyEquals(errorMessageNotValid.getText(), "Input value is not valid.");
	}
	
	@Story("Story 2 - Not input data valid")
	@Severity(SeverityLevel.NORMAL)
	public void TC_03_Input_Value_Valid() {
		driver.findElement(By.xpath("//input[@id='No1']")).clear();
		driver.findElement(By.xpath("//input[@id='No1']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='No2']")).sendKeys("1");
		driver.findElement(By.xpath("//body/input[1]")).click();
		sleepInSecond(2);
		WebElement messageSuccess = driver.findElement(By.xpath("//input[@id='No3']"));
		System.out.println("gettext" + messageSuccess.getText());
		verifyEquals(messageSuccess.getText(), "");
	}

	@Test
	public void TC_03_Random_Popup() {
//		driver.get("https://blog.testproject.io/");
		sleepInSecond(20);
		WebElement showregisterForm = driver.findElement(By.xpath("//div[@class='mailch-wrap rocket-lazyload']"));
		if (showregisterForm.isDisplayed()) {
			Assert.assertTrue(driver.findElement(By.xpath("//img[@class='right-arr lazyloaded']")).isDisplayed());
			sleepInSecond(2);
			driver.findElement(By.xpath("//div[@id='close-mailch']//*[local-name()='svg']")).click();
			sleepInSecond(2);
		}

		driver.findElement(By.xpath("//section[@id='search-2']//input[@placeholder='Search Articles']")).sendKeys("Selenium");
		sleepInSecond(2);
		driver.findElement(By.xpath("//section[@id='search-2']//span[@class='glass']")).click();
		sleepInSecond(2);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void clickToElementByJS(String locator) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	
	public void removeAttributeInDOM(String locator, String attributeRemove) {
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}