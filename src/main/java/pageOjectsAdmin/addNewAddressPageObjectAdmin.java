package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.AddNewAddressPageUIAdmin;

public class addNewAddressPageObjectAdmin extends AbstractPage {
	WebDriver driver;

	public addNewAddressPageObjectAdmin(WebDriver driver) {
		this.driver = driver;
	}

	public void selectCountryAddNewAddress(String value) {
		waitToElementClickAble(driver, AddNewAddressPageUIAdmin.TEXTBOX_ADDRESS);
		selectItemInDropdown(driver, AddNewAddressPageUIAdmin.TEXTBOX_ADDRESS, value);
	}

	public String getAtributeAddAddressCountrySuccess() {
		waitToElementVisible(driver, AddNewAddressPageUIAdmin.COUNTRY_DROPDOWN);
		return getSelectedItemInDropdown(driver, AddNewAddressPageUIAdmin.COUNTRY_DROPDOWN);
	}
}
