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
}
