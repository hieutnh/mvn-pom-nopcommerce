package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
import io.qameta.allure.Story;
import pageOjectsAdmin.PageGeneratorManagerAdmin;
import pageOjectsAdmin.homePageObjectAdmin;
import pageOjectsAdmin.loginPageObjectAdmin;
import pageOjectsAdmin.productInfoPageOjectAdmin;
import pageOjectsAdmin.productPageOjectAdmin;
import reportConfigAllure.AllureTestListener;

@Listeners({ AllureTestListener.class })
public class Level_10_Admin extends AbstractTest {
	WebDriver driver;
	Select select;
	String email, pass, firstname, lastname, reEmail;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

	}

	@Test
	@Description("Search data in database")
	@Story("Story 1 - Input user name and password success")
	@Severity(SeverityLevel.NORMAL)
	public void TC_01_Login_success() {
		loginPage = PageGeneratorManagerAdmin.getLoginPage(driver);
		loginPage.inputToEmailTextBox("admin@yourstore.com");
		loginPage.inputToPasswordTextBox("admin");
		homePage = loginPage.clicktoLoginButton();
	}

	@Test
	@Description("Search data in database")
	@Story("Story 2 - Search with product name")
	@Severity(SeverityLevel.NORMAL)
	public void TC_02_Search_With_Product_Name() {
		homePage.clickToCatalog(driver, "fa fa-book");
		homePage.clickToProductLink(driver, "Products");
		productPage = PageGeneratorManagerAdmin.getProductPage(driver);
		productPage.inputTextBoxByID("Lenovo IdeaCentre 600 All-in-One PC", "SearchProductName");
		productPage.clickButtonByID(driver, "search-products");
		Assert.assertEquals(productPage.isDisplayLenovoProduct(), 1);
	}

	@Test
	@Description("Search data in database")
	@Story("Story 3 - Search with product name,parent category unchecked")
	@Severity(SeverityLevel.NORMAL)
	public void TC_03_Search_With_Product_Name_And_Parent_Category_Unchecked() {
		productPage.clickDropdownCategory(1, "SearchCategoryId");
		productPage.clickSubCategoriesUncheck();
		productPage.clickButtonByID(driver, "search-products");
		Assert.assertEquals(productPage.getTextErrorMessageNoData(), "No data available in table");
	}

	@Test
	@Description("Search data in database")
	@Story("Story 4 - Search with product name,parent category checked")
	@Severity(SeverityLevel.NORMAL)
	public void TC_04_Search_With_Product_Name_And_Parent_Category_checked() {
		productPage.clickSubCategoriesCheck();
		productPage.clickButtonByID(driver, "search-products");
		Assert.assertEquals(productPage.isDisplayLenovoProduct(), 1);
	}

	@Test
	@Description("Search data in database")
	@Story("Story 5 - Search with product name child category")
	@Severity(SeverityLevel.NORMAL)
	public void TC_05_Search_With_Product_Name_And_Child_Category() {
		productPage.clickDropdownCategory(2, "SearchCategoryId");
		productPage.clickSubCategoriesUncheck();
		productPage.clickButtonByID(driver, "search-products");
		Assert.assertEquals(productPage.isDisplayLenovoProduct(), 1);
	}

	@Test
	@Description("Search data in database")
	@Story("Story 6 - Search with product name manufacturer")
	@Severity(SeverityLevel.NORMAL)
	public void TC_06_Search_With_Product_Name_Manufacturer() {
		productPage.clickDropdownCategory(0, "SearchCategoryId");
		productPage.clickSubCategoriesUncheck();
		productPage.clickManufacturer(2, "SearchManufacturerId");
		productPage.clickButtonByID(driver, "search-products");
		Assert.assertEquals(productPage.getTextErrorMessageNoData(), "No data available in table");
	}

	@Test
	@Description("Search data in database")
	@Story("Story 7 - Go Directly to product SKU")
	@Severity(SeverityLevel.NORMAL)
	public void TC_07_Go_Directly_To_Product_SKU() {
		productPage.inputTextBoxByID("LE_IC_600", "GoDirectlyToSku");
		productPage.clickButtonByID(driver, "go-to-product-by-sku");
		productInfoPage = PageGeneratorManagerAdmin.getProductInfoPage(driver);
		Assert.assertTrue(productInfoPage.isDisplayProducInfo());
		Assert.assertTrue(productInfoPage.isDisplayProductNameInfo());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	homePageObjectAdmin homePage;
	loginPageObjectAdmin loginPage;
	productPageOjectAdmin productPage;
	productInfoPageOjectAdmin productInfoPage;
}