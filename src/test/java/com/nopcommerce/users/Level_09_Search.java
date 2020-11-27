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
import pageOjectsUser.customerInfoPageObject;
import pageOjectsUser.homePageObject;
import pageOjectsUser.loginPageObject;
import pageOjectsUser.myProductReviewsPageObject;
import pageOjectsUser.ordersPageObject;
import pageOjectsUser.registerPageObject;
import pageOjectsUser.rewardPointsPageObject;
import pageOjectsUser.searchFooterPageObject;
import pageOjectsUser.stockSubscriptionsObject;
import reportConfigAllure.AllureTestListener;

@Listeners({AllureTestListener.class})
public class Level_09_Search extends AbstractTest {
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
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.getTextErrorMessageEmptySearch(), "Search term minimum length is 3 characters");

	}

	@Story("Story 2 - Search with data not exist")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Search_With_Data_Not_Exist() {
		searchFooterPage.inputItemNotExist("macbook 2050");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.getTextErrorMessageEmptySearch(), "No products were found that matched your criteria.");

	}

	@Story("Story 3 - Search with data exist")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_Search_With_Data_Exist() {
		searchFooterPage.inputItemNotExist("Lenovo");
		searchFooterPage.clickToSearchButtonKeyword();
		verifyEquals(searchFooterPage.getSizeItemDisplayed(), 2);
	}

	@Story("Story 4 - Search with product name")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_Search_With_Product_Name() {
		searchFooterPage.inputItemNotExist("ThinkPad X1 Carbon");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.getSizeItemDisplayed(), 1);
		Assert.assertEquals(searchFooterPage.getTextItem(), "Lenovo Thinkpad X1 Carbon Laptop");

	}

	@Story("Story 5 - Advanced search with parent categories")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_Advance_Search_With_Parent_Categories() {
		log.info("Advance_Search_With_Parent_Categories - Step 01:Input item not exits");
		searchFooterPage.inputItemNotExist("Apple Macbook Pro");
		log.info("Advance_Search_With_Parent_Categories - Step 02:click checkbox advance search");
		searchFooterPage.clickAdvanceSearch();
		log.info("Advance_Search_With_Parent_Categories - Step 03:click dropdown sellect computers");
		searchFooterPage.clickDropdownCategory(1);
		log.info("Advance_Search_With_Parent_Categories - Step 04:click search button");
		searchFooterPage.clickToSearchButtonKeyword();
		log.info("Advance_Search_With_Parent_Categories - Step 05:Verify error message not found item");
		Assert.assertEquals(searchFooterPage.isErrorMessageNotFound(), "No products were found that matched your criteria.");

	}

	@Story("Story 6 - Advanced search with sub categories")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_06_Advance_Search_With_Sub_Categories() throws InterruptedException {
		searchFooterPage.clickAutomaticallySearchSubCategories();
		log.info("Advance_Search_With_Sub_Categories - Step 05:click search button");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.getSizeItemDisplayed(), 1);
		Assert.assertEquals(searchFooterPage.getTextItem(), "Apple MacBook Pro 13-inch");
	}

	@Story("Story 7 - Advanced search with incorrect manufacturer")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_07_Advance_Search_With_Incorrect_Manufacturer() {
		searchFooterPage.clickDropdowManufacturer("HP");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.isErrorMessageNotFound(), "No products were found that matched your criteria.");
		
	}
	
	@Story("Story 8 - Advance Search With Price Range With Range")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_08_Advance_Search_With_Price_Range() {
		searchFooterPage.clickDropdowManufacturer("Apple");
		searchFooterPage.inputPriceFromTextbox("1000");
		searchFooterPage.inputPriceToTextbox("2000");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.getSizeItemDisplayed(), 1);
		Assert.assertEquals(searchFooterPage.getTextItem(), "Apple MacBook Pro 13-inch");
	}
	
	@Story("Story 9 - Advance Search With Price_Range Less")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_09_Advance_Search_With_Price_Range_less() {
		searchFooterPage.inputPriceToTextbox("1700");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.isErrorMessageNotFound(), "No products were found that matched your criteria.");
	}
	
	@Story("Story 10 - Advance Search With Price_Range Greater Than Product Price")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_10_Advance_Search_With_Price_Range_Greater_Than_Product_Price() {
		searchFooterPage.inputPriceFromTextbox("1900");
		searchFooterPage.inputPriceToTextbox("5000");
		searchFooterPage.clickToSearchButtonKeyword();
		Assert.assertEquals(searchFooterPage.isErrorMessageNotFound(), "No products were found that matched your criteria.");
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

}