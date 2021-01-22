package com.nopcommerce.common;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commons.AbstractTest;
import commons.DataHelper;
import driverFactory.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageOjectsUser.PageGeneratorManager;
import pageOjectsUser.addressesPageObject;
import pageOjectsUser.customerInfoPageObject;
import pageOjectsUser.homePageObject;
import pageOjectsUser.loginPageObject;
import pageOjectsUser.myProductReviewsPageObject;
import pageOjectsUser.ordersPageObject;
import pageOjectsUser.registerPageObject;
import pageOjectsUser.rewardPointsPageObject;
import pageOjectsUser.stockSubscriptionsObject;
import reportConfigAllure.AllureTestListener;
import reportConfigAllure.ExtentTestManager_2_Capture;

@Listeners({AllureTestListener.class})
public class Common_01_Register extends AbstractTest {
	WebDriver driver;
	DriverManager driverManager;
	Select select;
	public static String email, pass, firstname, lastname, reEmail, email2;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeTest
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);
//		driverManager = DriverFactory.getBrowserDriver(BrowserName);
//		driver = driverManager.getUrl(appUrl);
		
		data = DataHelper.getData();
		
		firstname = "test";
		lastname = "thoima";
		email = data.getEmail();
		email2 = "test" + getRanDom() + "@gmail.com"; 
		pass = "123456";
	}

	@Test
	@Description("Register a user to system and verify user register success")
	@Story("Story 1 - Register with empty data")
	@Severity(SeverityLevel.NORMAL)
	public void TC_01_Register_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickRegisterButton();
		String FirstName_error = registerPage.getTextErrorMessageByID(driver, "FirstName-error");
		verifyEquals(FirstName_error, "First name is required.");

		String LastName_error = registerPage.getTextErrorMessageByID(driver, "LastName-error");
		verifyEquals(LastName_error, "Last name is required.");

		String Email_error = registerPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(Email_error, "Email is required.");

		String Password_error = registerPage.getTextErrorMessageByID(driver, "Password-error");
		verifyEquals(Password_error, "Password is required.");

		String ConfirmPassword_error = registerPage.getTextErrorMessageByID(driver, "ConfirmPassword-error");
		verifyEquals(ConfirmPassword_error, "Password is required.");

	}
	@Description("Register a user to system and verify user register success")
	@Story("Story 2 - Register with wrong email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Register_Wrong_Email() {
		registerPage.clickToGenderRadioButton();

		registerPage.inputToFirstName(firstname);

		registerPage.inputToLastName(lastname);

		registerPage.selectDayOfBirthDropDown("1");
		Assert.assertEquals(registerPage.getSizeDayInlocator(), 32);

		registerPage.selectMonthOfBirthDropDown("May");
		Assert.assertEquals(registerPage.getSizeMonthInlocator(), 13);

		registerPage.selectYearOfBirthDropDown("1980");
		Assert.assertEquals(registerPage.getSizeYearInlocator(), 112);

		registerPage.inputEmailToTextBox("taotest");
		registerPage.inputPassToTextBox(pass);
		registerPage.inputConfirmPassToTextBox(pass);
		registerPage.clickRegisterButton();
		String ConfirmPassword_error = registerPage.getTextErrorMessageByID(driver, "Email-error");
		verifyEquals(ConfirmPassword_error, "Wrong email");
	}
	@Story("Story 3 - Register with pass at least 6")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Register_Pass_At_Least_6() {
		registerPage.inputEmailToTextBox(email);
		registerPage.inputPassToTextBox("1");
		registerPage.inputConfirmPassToTextBox("1");
		registerPage.clickRegisterButton();
		String Password_At_Least_6 = registerPage.errorMessageLeast6();
		Assert.assertEquals(Password_At_Least_6, "Password must meet the following rules:\n" + "must have at least 6 characters");
		
	}
	
	@Story("Story 4 - Register Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Register_Success() {
		registerPage.inputToFirstName(firstname);

		registerPage.inputToLastName(lastname);

		registerPage.inputEmailToTextBox(email);
		registerPage.inputPassToTextBox(pass);
		registerPage.inputConfirmPassToTextBox(pass);
		registerPage.clickRegisterButton();
		homePage = registerPage.clickToLogOutButton();
//		driverManager.removeDriver();
		removeDriver();
	}



	customerInfoPageObject customerInfoPage;
	homePageObject homePage;
	loginPageObject loginPage;
	registerPageObject registerPage;
	addressesPageObject addressPage;
	ordersPageObject ordersPage;
	myProductReviewsPageObject myProductPage;
	rewardPointsPageObject rewardPointsPage;
	stockSubscriptionsObject stockSubscriptionsPage;
	private DataHelper data;
}