package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerAdmin {

	public static homePageObjectAdmin getHomePage(WebDriver driver) {
		return new homePageObjectAdmin(driver);
	}

	public static loginPageObjectAdmin getLoginPage(WebDriver driver) {
		return new loginPageObjectAdmin(driver);
	}
	public static productPageOjectAdmin getProductPage(WebDriver driver) {
		return new productPageOjectAdmin(driver);
	}
	
	public static productInfoPageOjectAdmin getProductInfoPage(WebDriver driver) {
		return new productInfoPageOjectAdmin(driver);
	}
	
	public static customerPageObjectAdmin getCustomerPage(WebDriver driver) {
		return new customerPageObjectAdmin(driver);
	}
	
	public static customerAddNewPageObjectAdmin getCustomerAddNewPage(WebDriver driver) {
		return new customerAddNewPageObjectAdmin(driver);
	}
	
	public static addNewAddressPageObjectAdmin getAddNewAddressPage(WebDriver driver) {
		return new addNewAddressPageObjectAdmin(driver);
	}
}
