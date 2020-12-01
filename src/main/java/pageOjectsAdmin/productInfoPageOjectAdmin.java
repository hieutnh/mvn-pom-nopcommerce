package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.ProductPageUIInfoAdmin;

public class productInfoPageOjectAdmin extends AbstractPage {
	WebDriver driver;

	public productInfoPageOjectAdmin(WebDriver driver) {
		// lấy biến toàn cục vô biến cục bộ
		this.driver = driver;
	}

	public boolean isDisplayProducInfo() {
		waitToElementVisible(driver, ProductPageUIInfoAdmin.PRODUCT_INFO_TEXT);
		return isElementDisplayed(driver, ProductPageUIInfoAdmin.PRODUCT_INFO_TEXT);
	}

	public boolean isDisplayProductNameInfo() {
		waitToElementVisible(driver, ProductPageUIInfoAdmin.PRODUCT_NAME_TEXT);
		return isElementDisplayed(driver, ProductPageUIInfoAdmin.PRODUCT_NAME_TEXT);
	}


}
