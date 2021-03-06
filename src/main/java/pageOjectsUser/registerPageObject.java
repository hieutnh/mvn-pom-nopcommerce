package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import io.qameta.allure.Step;
import pageUIsUser.RegisterPageUI;

public class registerPageObject extends AbstractPage {
	public registerPageObject(WebDriver driver) {

		this.driver = driver;
	}

	WebDriver driver;

	@Step("Click to gender radio button")
	public void clickToGenderRadioButton() {
		waitToElementClickAble(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
		clickToElement(driver, RegisterPageUI.GENDER_RADIO_BUTTON);
	}

	@Step("Select day of birth")
	public void selectDayOfBirthDropDown(String day) {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);

	}

	@Step("Get number data in day dropdown")
	public Object getSizeDayInlocator() {
		waitToElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.DAY_DROPDOWN);
	}

	@Step("Get number data in month dropdown")
	public Object getSizeMonthInlocator() {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.MONTH_DROPDOWN);
	}

	@Step("Select year of birth")
	public void selectYearOfBirthDropDown(String year) {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);

	}
	@Step("Get number data in year dropdown")
	public Object getSizeYearInlocator() {
		waitToElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		return getAllElementInLocator(driver, RegisterPageUI.YEAR_DROPDOWN);
	}

	@Step("Input email to textbox with value: {0}")
	public void inputEmailToTextBox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXBOX, email);
	}

	@Step("Input password to textbox with value: {0}")
	public void inputPassToTextBox(String pass) {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXBOX, pass);

	}

	@Step("Input confirm password to textbox with value: {0}")
	public void inputConfirmPassToTextBox(String pass) {
		waitToElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXBOX, pass);

	}
	@Step("Click to register button")
	public void clickRegisterButton() {
		waitToElementClickAble(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Get text register user success")
	public String getRegisterSuccessMessage() {
		waitToElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}

	@Step("Click to home page button")
	public homePageObject clickToLogOutButton() {
		waitToElementClickAble(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	@Step("Input firstname to textbox with value: {0}")
	public void inputToFirstName(String firstname) {
		waitToElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstname);

	}
	@Step("Input lastname to textbox with value: {0}")
	public void inputToLastName(String lastname) {
		waitToElementVisible(driver, RegisterPageUI.LAST_NAEM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAEM_TEXTBOX, lastname);

	}
	@Step("Select month of birth")
	public void selectMonthOfBirthDropDown(String year) {
		waitToElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, year);
	}

	
	@Step("Get text to verify error message when input password least 6")
	public String errorMessageLeast6() {
		waitToElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_PASS_LEAST_6);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_PASS_LEAST_6);
	}


}
