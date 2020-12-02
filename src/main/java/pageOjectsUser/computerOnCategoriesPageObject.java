package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.ComputerOnCategoriesPageUI;

public class computerOnCategoriesPageObject extends AbstractPage {
	public computerOnCategoriesPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;


	public destopOnCategoriesPageObject clickDestopLinkOnMainScreen() {
		waitToElementsVisible(driver, ComputerOnCategoriesPageUI.DESKTOP_LINK_ON_MAINSCREEN);
		clickToElement(driver, ComputerOnCategoriesPageUI.DESKTOP_LINK_ON_MAINSCREEN);
		return PageGeneratorManager.getDestopOnCategoriesPage(driver);
	}

}
