package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.DestopOnCategoriesPageUI;
import pageUIsUser.searchFooterPageUI;

public class destopOnCategoriesPageObject extends AbstractPage {
	public destopOnCategoriesPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void selectSortDropdown(String value) {
		waitToElementClickAble(driver, DestopOnCategoriesPageUI.SORT_IN_DESTOP_DROPDOWN);
		selectItemInDropdown(driver, DestopOnCategoriesPageUI.SORT_IN_DESTOP_DROPDOWN, value);
	}

	public boolean isNameSortAscending() {
		waitToElementsVisible(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_NAME);
		return isDataSortedAscending(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_NAME);
	}

	public boolean isNameSortDescending() {
		waitToElementsVisible(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_NAME);
		return isDataSortedDescending(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_NAME);
	}

	public boolean isPriceSortAscending() {
		waitToElementsVisible(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_PRICE);
		return isPriceSortAscending(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_PRICE);
	}

	public boolean isPriceSortDescending() {
		waitToElementsVisible(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_PRICE);
		return isPriceSortedDescending(driver, DestopOnCategoriesPageUI.SORT_ASCENDING_PRICE);
	}

	public int countItemInDestopMenu() {
		waitToElementVisible(driver, DestopOnCategoriesPageUI.ALL_ITEM_DESKTOP);
		return countElementSize(driver, DestopOnCategoriesPageUI.ALL_ITEM_DESKTOP);
	}

	public void selectDisplayPerPage(String value) {
		waitToElementClickAble(driver, DestopOnCategoriesPageUI.SORT_DISPLAY_IN_DESTOP_DROPDOWN);
		selectItemInDropdown(driver, DestopOnCategoriesPageUI.SORT_DISPLAY_IN_DESTOP_DROPDOWN, value);
	}
}
