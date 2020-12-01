package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.AddNewAddressPageUIAdmin;

public class addNewAddressPageObjectAdmin extends AbstractPage {
	WebDriver driver;

	public addNewAddressPageObjectAdmin(WebDriver driver) {
		this.driver = driver;
	}


	public void selectCountryAddNewAddress(String value, String values) {
		waitToElementClickAble(driver, AddNewAddressPageUIAdmin.DYNAMIC_TEXTBOX_ADDRESS, values);
		selectItemInDropdown(driver, AddNewAddressPageUIAdmin.DYNAMIC_TEXTBOX_ADDRESS,value, values);
	}

}
