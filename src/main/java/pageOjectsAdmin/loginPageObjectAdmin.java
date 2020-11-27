package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.LoginPageUIAdmin;
import pageUIsUser.LoginPageUI;

public class loginPageObjectAdmin extends AbstractPage {
	WebDriver driver;

	public loginPageObjectAdmin(WebDriver driver) {

		this.driver = driver;
	}

	public void inputToEmailTextBox(String email) {
		waitToElementVisible(driver, LoginPageUIAdmin.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIAdmin.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextBox(String pass) {
		waitToElementVisible(driver, LoginPageUIAdmin.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIAdmin.PASSWORD_TEXTBOX, pass);
	}

	public homePageObjectAdmin clicktoLoginButton() {
		waitToElementVisible(driver, LoginPageUIAdmin.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUIAdmin.LOGIN_BUTTON);
		return PageGeneratorManagerAdmin.getHomePage(driver);
	}

}
