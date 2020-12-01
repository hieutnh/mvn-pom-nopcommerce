package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.CustomerAddNewPageUIAdmin;

public class customerAddNewPageObjectAdmin extends AbstractPage {
	WebDriver driver;

	public customerAddNewPageObjectAdmin(WebDriver driver) {
		// lấy biến toàn cục vô biến cục bộ
		this.driver = driver;
	}

	public void clickToGenderRadioButton() {
		waitToElementClickAble(driver, CustomerAddNewPageUIAdmin.GENDER_RADIO_BUTTON);
		clickToElement(driver, CustomerAddNewPageUIAdmin.GENDER_RADIO_BUTTON);
	}

	public void clicktoDropdownCustomerRoles(String value) {
		waitToElementVisible(driver, CustomerAddNewPageUIAdmin.CUSTOMER_ROLE_DROPDOWN);
		sendkeyToElement(driver, CustomerAddNewPageUIAdmin.CUSTOMER_ROLE_DROPDOWN, value);
		sendKeyBoardEnterToElement(driver, CustomerAddNewPageUIAdmin.CUSTOMER_ROLE_DROPDOWN);
	}

	public void inputAdminCommentTextBox(String value) {
		waitToElementVisible(driver, CustomerAddNewPageUIAdmin.ADMIN_COMMENT_TEXTBOX);
		sendkeyToElement(driver, CustomerAddNewPageUIAdmin.ADMIN_COMMENT_TEXTBOX, value);
	}

	public void clicktoButtonSaveAndContinue(String values) {
		waitToElementClickAble(driver, CustomerAddNewPageUIAdmin.DYNAMIC_SAVE_AND_CONTINUE_BUTTON, values);
		clickToElement(driver, CustomerAddNewPageUIAdmin.DYNAMIC_SAVE_AND_CONTINUE_BUTTON, values);
	}

	public customerPageObjectAdmin clickToBackToCustomerList() {
		waitToElementClickAble(driver, CustomerAddNewPageUIAdmin.BACK_TO_CUSTOMER_LIST_LINK);
		clickToElement(driver, CustomerAddNewPageUIAdmin.BACK_TO_CUSTOMER_LIST_LINK);
		return PageGeneratorManagerAdmin.getCustomerPage(driver);
	}

	public void clickDeleteTitleCustomerRoles() {
		waitToElementClickAble(driver, CustomerAddNewPageUIAdmin.DELETE_TITLE_CUSTOMER_INFO);
		clickToElement(driver, CustomerAddNewPageUIAdmin.DELETE_TITLE_CUSTOMER_INFO);
	}

	public String getTextCustomerRolesAddSuccess() {
		waitToElementVisible(driver, CustomerAddNewPageUIAdmin.CUSTOMER_ROLE_ADD_SUCCESS_TEXT);
		return getElementText(driver, CustomerAddNewPageUIAdmin.CUSTOMER_ROLE_ADD_SUCCESS_TEXT);
	}

	public String getTextAddSuccess() {
		waitToElementVisible(driver, CustomerAddNewPageUIAdmin.ADMIN_COMMENT_TEXT);
		return getElementText(driver, CustomerAddNewPageUIAdmin.ADMIN_COMMENT_TEXT);
	}

	public boolean verifyCheckedActive() {
		waitToElementVisible(driver, CustomerAddNewPageUIAdmin.ACTIVE_CHECKBOX);
		return verifyCheckbox(driver, CustomerAddNewPageUIAdmin.ACTIVE_CHECKBOX);
	}

	public void clickAddresscollapse() {
		waitToElementClickAble(driver, CustomerAddNewPageUIAdmin.ADDRESS_COLLAPSE);
		checkDisplayToClick(driver, CustomerAddNewPageUIAdmin.ADDRESS_COLLAPSE);
	}

}
