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
import commons.DataHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageOjectsAdmin.PageGeneratorManagerAdmin;
import pageOjectsAdmin.addNewAddressPageObjectAdmin;
import pageOjectsAdmin.customerAddNewPageObjectAdmin;
import pageOjectsAdmin.customerPageObjectAdmin;
import pageOjectsAdmin.homePageObjectAdmin;
import pageOjectsAdmin.loginPageObjectAdmin;
import pageOjectsAdmin.productInfoPageOjectAdmin;
import pageOjectsAdmin.productPageOjectAdmin;
import reportConfigAllure.AllureTestListener;

@Listeners({ AllureTestListener.class })
public class Level_10_Admin extends AbstractTest {
	WebDriver driver;
	Select select;
	String emailRegister, passRegister, firstnameRegister, lastnameRegister, reEmail, dateOfBirth, companyRegister, emailEdit;

	// run all browsers
	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void beforeClass(String BrowserName, String appUrl) {
		driver = getBrowserDriver(BrowserName, appUrl);

		data = DataHelper.getData();
		emailRegister = data.getEmail();
		firstnameRegister = data.getFirstName();
		lastnameRegister = data.getLastName();
		dateOfBirth = "9/20/1992";
		companyRegister = data.getCompanyName();
		emailEdit = "test" + getRanDom() + "@gmail.com";
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
		homePage.clickToMenuParent(driver, "fa fa-book");
		homePage.clickToChildMenuCatalogtLink(driver, "Products");
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
//		productInfoPage.clickProductInfoExpand();
		Assert.assertTrue(productInfoPage.isDisplayProducInfo());
		Assert.assertTrue(productInfoPage.isDisplayProductNameInfo());

	}

	@Test
	@Description("Create new customer")
	@Story("Story 8 - Create new customer")
	@Severity(SeverityLevel.CRITICAL)
	public void TC_08_Create_New_Customer() {
		productInfoPage.clickToMenuParent(driver, "fa fa-user");
		productInfoPage.clickToChildMenuNotSelectCustomersLink(driver, "Customers");
		customerPage = PageGeneratorManagerAdmin.getCustomerPage(driver);
		customerAddNewPage = customerPage.clickToAddNewCustomer();
		customerAddNewPage.InputTextBoxAdminByID(driver, emailRegister, "Email");
		customerAddNewPage.InputTextBoxAdminByID(driver, "123123", "Password");
		customerAddNewPage.InputTextBoxAdminByID(driver, firstnameRegister, "FirstName");
		customerAddNewPage.InputTextBoxAdminByID(driver, lastnameRegister, "LastName");
		customerAddNewPage.clickToGenderRadioButton();
		customerAddNewPage.InputTextBoxAdminByID(driver, dateOfBirth, "DateOfBirth");
		customerAddNewPage.InputTextBoxAdminByID(driver, companyRegister, "Company");
		customerAddNewPage.clickDeleteTitleCustomerRoles();
		customerAddNewPage.clicktoDropdownCustomerRoles("Guests");
		customerAddNewPage.inputAdminCommentTextBox("Add new customer (Guests)");
		customerAddNewPage.clicktoButtonSaveAndContinue("save-continue");
		Assert.assertTrue(customerAddNewPage.getTextMessageAllertSuccess(driver, "The new customer has been added successfully."));
		Assert.assertEquals(customerAddNewPage.getAtributeAddSuccess(driver, "value", "Email"), emailRegister);
		Assert.assertEquals(customerAddNewPage.getAtributeAddSuccess(driver, "value", "FirstName"), firstnameRegister);
		Assert.assertEquals(customerAddNewPage.getAtributeAddSuccess(driver, "value", "LastName"), lastnameRegister);
		Assert.assertEquals(customerAddNewPage.getAtributeAddSuccess(driver, "value", "DateOfBirth"), dateOfBirth);
		Assert.assertEquals(customerAddNewPage.getAtributeAddSuccess(driver, "value", "Company"), companyRegister);
		Assert.assertEquals(customerAddNewPage.getTextCustomerRolesAddSuccess(), "Guests");
		Assert.assertTrue(customerAddNewPage.verifyCheckedActive());
		Assert.assertEquals(customerAddNewPage.getTextAddSuccess(), "Add new customer (Guests)");
		customerPage = customerAddNewPage.clickToBackToCustomerList();

	}

	@Test
	@Description("Search Data Add New")
	@Story("Story 9 - Search Custom With Email")
	@Severity(SeverityLevel.NORMAL)
	public void TC_09_Search_Custom_With_Email() {
		customerPage.clickDeleteTitleCustomerRoles();
		customerPage.clicktoDropdownCustomerRoles("Guests");
		customerPage.InputTextBoxAdminByID(driver, emailRegister, "SearchEmail");
		customerPage.clickButtonByID(driver, "search-customers");
		Assert.assertEquals(customerPage.isDisplayOneItem(), 1);

	}

	@Test
	@Description("Search Data Add New")
	@Story("Story 10 - Search Custom With FirstName And LastName")
	@Severity(SeverityLevel.NORMAL)
	public void TC_10_Search_Custom_With_FirstName_And_LastName() {
		customerPage.clickToChildMenuCustomersSelectedLink(driver, "Customers");
		customerPage.InputTextBoxAdminByID(driver, firstnameRegister, "SearchFirstName");
		customerPage.InputTextBoxAdminByID(driver, lastnameRegister, "SearchLastName");
		customerPage.clickDeleteTitleCustomerRoles();
		customerPage.clicktoDropdownCustomerRoles("Guests");
		customerPage.clickButtonByID(driver, "search-customers");
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Name", firstnameRegister + " " + lastnameRegister));
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Customer roles", "Guests"));

	}

	@Test
	@Description("Search Data Add New")
	@Story("Story 11 - Search Custom With Customer And Company")
	@Severity(SeverityLevel.NORMAL)
	public void TC_11_Search_Custom_With_Customer_And_Company() {
		customerPage.clickToChildMenuCustomersSelectedLink(driver, "Customers");
		customerPage.InputTextBoxAdminByID(driver, companyRegister, "SearchCompany");
		customerPage.clickDeleteTitleCustomerRoles();
		customerPage.clicktoDropdownCustomerRoles("Guests");
		customerPage.clickButtonByID(driver, "search-customers");
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Company name", companyRegister));
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Customer roles", "Guests"));

	}

	@Test
	@Description("Search Data Add New")
	@Story("Story 12 - Search Custom With Full Data")
	@Severity(SeverityLevel.NORMAL)
	public void TC_12_Search_Custom_With_Full_Data() {
		customerPage.clickToChildMenuCustomersSelectedLink(driver, "Customers");
		customerPage.InputTextBoxAdminByID(driver, emailRegister, "SearchEmail");
		customerPage.InputTextBoxAdminByID(driver, firstnameRegister, "SearchFirstName");
		customerPage.InputTextBoxAdminByID(driver, lastnameRegister, "SearchLastName");
		customerPage.InputTextBoxAdminByID(driver, companyRegister, "SearchCompany");
		customerPage.selectMonthOfFillDayOfBirth("9");
		customerPage.selectDayOfFillDayOfBirth("20");
		customerPage.clickDeleteTitleCustomerRoles();
		customerPage.clicktoDropdownCustomerRoles("Guests");
		customerPage.clickButtonByID(driver, "search-customers");
		Assert.assertEquals(customerPage.isDisplayOneItem(), 1);
	}

	@Test
	@Description("Edit Customer")
	@Story("Story 13 - Edit Customer Add New")
	@Severity(SeverityLevel.MINOR)
	public void TC_13_Edit_Customer_Add_New() {
		customerAddNewPage = customerPage.clickEditUser();
		customerAddNewPage.InputTextBoxAdminByID(driver, emailEdit, "Email");
		customerAddNewPage.InputTextBoxAdminByID(driver, "Automation", "FirstName");
		customerAddNewPage.InputTextBoxAdminByID(driver, "Tester", "LastName");
		customerAddNewPage.InputTextBoxAdminByID(driver, "10/25/2020", "DateOfBirth");
		customerAddNewPage.InputTextBoxAdminByID(driver, "GamiTech", "Company");
		customerAddNewPage.inputAdminCommentTextBox("Edit customer (Guests)");
		customerAddNewPage.clicktoButtonSaveAndContinue("save");
		customerPage = PageGeneratorManagerAdmin.getCustomerPage(driver);
		Assert.assertTrue(customerAddNewPage.getTextMessageAllertSuccess(driver, "The customer has been updated successfully."));
		customerPage.InputTextBoxAdminByID(driver, emailEdit, "SearchEmail");
		customerPage.InputTextBoxAdminByID(driver, "Automation", "SearchFirstName");
		customerPage.InputTextBoxAdminByID(driver, "Tester", "SearchLastName");
		customerPage.InputTextBoxAdminByID(driver, "GamiTech", "SearchCompany");
		customerPage.selectMonthOfFillDayOfBirth("10");
		customerPage.selectDayOfFillDayOfBirth("25");
		customerPage.clickDeleteTitleCustomerRoles();
		customerPage.clicktoDropdownCustomerRoles("Guests");
		customerPage.clickButtonByID(driver, "search-customers");
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Email", "Guest"));
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Name", "Automation" + " " + "Tester"));
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Customer roles", "Guests"));
		Assert.assertTrue(customerPage.isDisplayUserAddNewWithCustomerRolesGuests("1", "Company name", "GamiTech"));
		Assert.assertEquals(customerPage.isDisplayActiveTrue("nop-value"), "true");
	}

	@Test
	@Description("Add New Address")
	@Story("Story 14 - Add New Address In Customer Detail")
	@Severity(SeverityLevel.NORMAL)
	public void TC_14_Add_New_Address_In_Customer_Detail() {
		customerAddNewPage = customerPage.clickEditUser();
//		customerAddNewPage.clickAddresscollapse();
		customerAddNewPage.clickButtonInAddNewAddress(driver, "Add new address");
		addNewAddressPage = PageGeneratorManagerAdmin.getAddNewAddressPage(driver);
		addNewAddressPage.InputTextBoxAdminByID(driver, "Automation", "Address_FirstName");
		addNewAddressPage.InputTextBoxAdminByID(driver, "Tester", "Address_LastName");
		addNewAddressPage.InputTextBoxAdminByID(driver, emailEdit, "Address_Email");
		addNewAddressPage.InputTextBoxAdminByID(driver, "GamiTech", "Address_Company");
		addNewAddressPage.selectCountryAddNewAddress("Viet Nam");
		addNewAddressPage.InputTextBoxAdminByID(driver, "Ho Chi Minh", "Address_City");
		addNewAddressPage.InputTextBoxAdminByID(driver, "20 Van Coi, Tan Binh", "Address_Address1");
		addNewAddressPage.InputTextBoxAdminByID(driver, "70000", "Address_ZipPostalCode");
		addNewAddressPage.InputTextBoxAdminByID(driver, "0123456789", "Address_PhoneNumber");
		addNewAddressPage.clickButtonInAddNewAddress(driver, "Save");
		Assert.assertTrue(customerAddNewPage.getTextMessageAllertSuccess(driver, "The new address has been added successfully."));
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_FirstName"), "Automation");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_LastName"), "Tester");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_Email"), emailEdit);
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_Company"), "GamiTech");
		Assert.assertEquals(addNewAddressPage.getAtributeAddAddressCountrySuccess(), "Viet Nam");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_City"), "Ho Chi Minh");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_Address1"), "20 Van Coi, Tan Binh");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_ZipPostalCode"), "70000");
		Assert.assertEquals(addNewAddressPage.getAtributeAddSuccess(driver, "value", "Address_PhoneNumber"), "0123456789");
	}

	@Test
	@Description("Delete Address")
	@Story("Story 15 - Delete Address In Customer Detail")
	@Severity(SeverityLevel.NORMAL)
	public void TC_15_Delete_New_Address_In_Customer_Detail() {
		addNewAddressPage.clickToChildMenuCatalogtLink(driver, "Customers");
		customerPage = PageGeneratorManagerAdmin.getCustomerPage(driver);
		customerPage.InputTextBoxAdminByID(driver, emailEdit, "Email");
		customerPage.InputTextBoxAdminByID(driver, "Automation", "FirstName");
		customerPage.InputTextBoxAdminByID(driver, "Tester", "LastName");
		customerPage.InputTextBoxAdminByID(driver, "10/25/2020", "DateOfBirth");
		customerPage.InputTextBoxAdminByID(driver, "GamiTech", "Company");
		customerPage.clickButtonByID(driver, "search-customers");
		customerAddNewPage = customerPage.clickEditUser();
		customerAddNewPage.clickDeleteAddress();
		Assert.assertEquals(customerAddNewPage.getTextDeleteAddressSuccess(), "No data available in table");
	}

	@AfterClass
	public void afterClass() {
		removeDriver();
	}

	homePageObjectAdmin homePage;
	loginPageObjectAdmin loginPage;
	productPageOjectAdmin productPage;
	productInfoPageOjectAdmin productInfoPage;
	customerPageObjectAdmin customerPage;
	customerAddNewPageObjectAdmin customerAddNewPage;
	addNewAddressPageObjectAdmin addNewAddressPage;
	public DataHelper data;
}