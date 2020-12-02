package pageOjectsUser;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import io.qameta.allure.Step;
import pageUIsUser.RegisterPageUI;
import pageUIsUser.searchFooterPageUI;

public class searchFooterPageObject extends AbstractPage {
	public searchFooterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	@Step("Click search button")
	public void clickToSearchButtonKeyword() {
		waitToElementClickAble(driver, searchFooterPageUI.SEARCH_KEYWORD_BUTTON);
		clickToElement(driver, searchFooterPageUI.SEARCH_KEYWORD_BUTTON);
	}

	@Step("Input item not exist")
	public void inputItemNotExist(String value) {
		waitToElementVisible(driver, searchFooterPageUI.SEARCH_KEYWORK_TEXTBOX);
		sendkeyToElement(driver, searchFooterPageUI.SEARCH_KEYWORK_TEXTBOX, value);
	}

	@Step("Verify error message empty search")
	public String getTextErrorMessageEmptySearch() {
		waitToElementVisible(driver, searchFooterPageUI.ERROR_MESSAGE_SEARCH_EMPTY);
		return getElementText(driver, searchFooterPageUI.ERROR_MESSAGE_SEARCH_EMPTY);
	}

	@Step("Get size item have in page after search")
	public Object getSizeItemDisplayed() {
		waitToElementVisible(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY);
		return getElements(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY).size();
	}

	@Step("Get text item has been searched in page")
	public String getTextItem() {
		waitToElementVisible(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY);
		return getElementText(driver, searchFooterPageUI.NUMBER_ITEM_DISPLAY);
	}
	
	@Step("Click advance search checkbox")
	public void clickAdvanceSearch() {
		waitToElementClickAble(driver, searchFooterPageUI.ADVANCE_SEARCH_CHECKBOX);
		checkToCheckbox(driver, searchFooterPageUI.ADVANCE_SEARCH_CHECKBOX);

	}

	@Step("Click dropdown category")
	public void clickDropdownCategory(int expectedItem) {
		waitToElementVisible(driver, searchFooterPageUI.CATEGORY_SEARCH_DROPDOWN_PARENT);
		selectItemByIndexInDropdown(driver, searchFooterPageUI.CATEGORY_SEARCH_DROPDOWN_PARENT, expectedItem);
	}
	
	@Step("Click automatically seach sub categories checkbox")
	public void clickAutomaticallySearchSubCategories() {
		waitToElementsVisible(driver, searchFooterPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
		clickToElement(driver, searchFooterPageUI.AUTOMATICALLY_SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	@Step("Verify error message when not found item")
	public String isErrorMessageNotFound() {
		waitToElementVisible(driver, searchFooterPageUI.ERROR_MESSAGE_NOT_FOUND);
		return getElementText(driver, searchFooterPageUI.ERROR_MESSAGE_NOT_FOUND);
	}

	@Step("Click dropdown manufacturer")
	public void clickDropdowManufacturer(String itemValue) {
		waitToElementVisible(driver, searchFooterPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDropdown(driver, searchFooterPageUI.MANUFACTURER_DROPDOWN, itemValue);
	}

	@Step("Input price from textbox")
	public void inputPriceFromTextbox(String value) {
		waitToElementVisible(driver, searchFooterPageUI.PRICEFROMTEXTBOX);
		sendkeyToElement(driver, searchFooterPageUI.PRICEFROMTEXTBOX, value);
	}

	@Step("Input price to textbox")
	public void inputPriceToTextbox(String value) {
		waitToElementVisible(driver, searchFooterPageUI.PRICETOTEXTBOX);
		sendkeyToElement(driver, searchFooterPageUI.PRICETOTEXTBOX, value);
	}

	public computerOnCategoriesPageObject clickComputerLinkOnCategories() {
		waitToElementsVisible(driver, searchFooterPageUI.COMPUTER_LINK_ON_CATEGORIES);
		clickToElement(driver, searchFooterPageUI.COMPUTER_LINK_ON_CATEGORIES);
		return PageGeneratorManager.getComputerOnCategoriesPage(driver);
	}

	

}
