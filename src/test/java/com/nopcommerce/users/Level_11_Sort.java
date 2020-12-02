package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageOjectsUser.PageGeneratorManager;
import pageOjectsUser.addressesPageObject;
import pageOjectsUser.changePasswordPageObject;
import pageOjectsUser.computerOnCategoriesPageObject;
import pageOjectsUser.customerInfoPageObject;
import pageOjectsUser.destopOnCategoriesPageObject;
import pageOjectsUser.homePageObject;
import pageOjectsUser.loginPageObject;
import pageOjectsUser.myProductReviewsPageObject;
import pageOjectsUser.ordersPageObject;
import pageOjectsUser.registerPageObject;
import pageOjectsUser.rewardPointsPageObject;
import pageOjectsUser.searchFooterPageObject;
import pageOjectsUser.stockSubscriptionsObject;
import reportConfigAllure.AllureTestListener;

@Listeners({ AllureTestListener.class })
public class Level_11_Sort extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname, reEmail;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);

		loginPage = homePage.clickToLoginLinkHeader();

		loginPage.inputToEmailTextBox(Common_01_Register.email);
		loginPage.inputToPasswordTextBox(Common_01_Register.pass);
		homePage = loginPage.clicktoLoginButton();

	}

	@Test
	@Description("Search and Advanced search")
	@Story("Story 1 - Search with empty data")
	@Severity(SeverityLevel.NORMAL)
	public void TC_01_Search_With_Empty_Data() {
		searchFooterPage = homePage.clickSearchFooter();
		computerOnCategoriesPage = searchFooterPage.clickComputerLinkOnCategories();
		destopOnCategoriesPage = computerOnCategoriesPage.clickDestopLinkOnMainScreen();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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
	changePasswordPageObject changePasswordPage;
	searchFooterPageObject searchFooterPage;
	computerOnCategoriesPageObject computerOnCategoriesPage;
	destopOnCategoriesPageObject destopOnCategoriesPage;
}