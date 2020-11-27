package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.AbstractPageUI;
import pageUIsUser.AddressesPageUI;

public class changePasswordPageObject extends AbstractPage {
	WebDriver driver;

	public changePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLinkHeader(String values) {
		waitToElementClickAble(driver, AbstractPageUI.DYNAMIC_LIST_LINK_HEADER, values);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LIST_LINK_HEADER, values);
		
	}


}