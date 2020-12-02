package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIsUser.RegisterPageUI;
import pageUIsUser.searchFooterPageUI;

public class destopOnCategoriesPageObject extends AbstractPage {
	public destopOnCategoriesPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

}
