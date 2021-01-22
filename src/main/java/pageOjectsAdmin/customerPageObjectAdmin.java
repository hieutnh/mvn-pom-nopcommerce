package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.CustomerPageUIAdmin;

public class customerPageObjectAdmin extends AbstractPage {
	WebDriver driver;

	public customerPageObjectAdmin(WebDriver driver) {
		// lấy biến toàn cục vô biến cục bộ
		this.driver = driver;
	}

	public customerAddNewPageObjectAdmin clickToAddNewCustomer() {
		waitToElementClickAble(driver, CustomerPageUIAdmin.ADD_NEW_CUSTOMER_BUTTON);
		clickToElement(driver, CustomerPageUIAdmin.ADD_NEW_CUSTOMER_BUTTON);
		return PageGeneratorManagerAdmin.getCustomerAddNewPage(driver);
	}

	public void clicktoDropdownCustomerRoles(String value) {
		waitToElementVisible(driver, CustomerPageUIAdmin.CUSTOMER_ROLE_DROPDOWN);
		sendkeyToElement(driver, CustomerPageUIAdmin.CUSTOMER_ROLE_DROPDOWN, value);
		sendKeyBoardEnterToElement(driver, CustomerPageUIAdmin.CUSTOMER_ROLE_DROPDOWN);
	}

	public void clickDeleteTitleCustomerRoles() {
		waitToElementClickAble(driver, CustomerPageUIAdmin.DELETE_TITLE_CUSTOMER_INFO);
		clickToElement(driver, CustomerPageUIAdmin.DELETE_TITLE_CUSTOMER_INFO);
	}

	public boolean isDisplayUserAddNewWithCustomerRolesGuests(String rowNumber, String locatorColumnName, String value) {
		waitToElementVisible(driver, CustomerPageUIAdmin.DYNAMIC_HEADER_COLUMNNAME, locatorColumnName);
		String countElementGetIndex = String.valueOf(countElementSize(driver, CustomerPageUIAdmin.DYNAMIC_HEADER_COLUMNNAME, locatorColumnName) + 1);
		waitToElementVisible(driver, CustomerPageUIAdmin.DYNAMIC_VALUE_AT_SOME_COLUMN, rowNumber, countElementGetIndex, value);
		return isElementDisplayed(driver, CustomerPageUIAdmin.DYNAMIC_VALUE_AT_SOME_COLUMN, rowNumber, countElementGetIndex, value);
	}

	public int isDisplayOneItem() {
		waitToElementVisible(driver, CustomerPageUIAdmin.COUNT_NUMBER_ITEM_DISPLAY);
		return countElementSize(driver, CustomerPageUIAdmin.COUNT_NUMBER_ITEM_DISPLAY);
	}

	public void selectMonthOfFillDayOfBirth(String value) {
		waitToElementVisible(driver, CustomerPageUIAdmin.MONTH_OF_MONTH_OF_BIRTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerPageUIAdmin.MONTH_OF_MONTH_OF_BIRTH_DROPDOWN, value);
	}

	public void selectDayOfFillDayOfBirth(String value) {
		waitToElementVisible(driver, CustomerPageUIAdmin.MONTH_OF_DAY_OF_BIRTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerPageUIAdmin.MONTH_OF_DAY_OF_BIRTH_DROPDOWN, value);
	}

	public customerAddNewPageObjectAdmin clickEditUser() {
		waitToElementClickAble(driver, CustomerPageUIAdmin.EDIT_USER_BUTTON);
		clickToElement(driver, CustomerPageUIAdmin.EDIT_USER_BUTTON);
		return PageGeneratorManagerAdmin.getCustomerAddNewPage(driver);
	}

	public String isDisplayActiveTrue(String attributeName) {
		waitToElementVisible(driver, CustomerPageUIAdmin.ACTIVE_CHECK_TRUE);
		return getElementAttribute(driver, CustomerPageUIAdmin.ACTIVE_CHECK_TRUE, attributeName);
	}

}
