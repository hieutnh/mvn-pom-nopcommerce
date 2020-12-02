package pageOjectsAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsAdmin.AbstractPageUIAdmin;
import pageUIsAdmin.ProductPageUIAdmin;

public class productPageOjectAdmin extends AbstractPage {
	WebDriver driver;

	public productPageOjectAdmin(WebDriver driver) {
		// lấy biến toàn cục vô biến cục bộ
		this.driver = driver;
	}

	public int isDisplayLenovoProduct() {
		waitToElementVisible(driver, ProductPageUIAdmin.PRODUCT_LENOVO_ROW);
		return countElementSize(driver, ProductPageUIAdmin.PRODUCT_LENOVO_ROW);
	}

	public void clickDropdownCategory(int itemValue, String values) {
		waitToElementClickAble(driver, ProductPageUIAdmin.DYNAMIC_DROPDOW_SEARCH, values);
		selectItemByIndexInDropdown(driver, ProductPageUIAdmin.DYNAMIC_DROPDOW_SEARCH, itemValue, values);
	}

	public void clickSubCategoriesUncheck() {
		waitToElementClickAble(driver, ProductPageUIAdmin.SEARCHSUBCATEGORIES_CHECKBOX);
		uncheckToCheckbox(driver, ProductPageUIAdmin.SEARCHSUBCATEGORIES_CHECKBOX);
	}

	public String getTextErrorMessageNoData() {
		waitToElementVisible(driver, ProductPageUIAdmin.ERROR_MESSAGE_NO_DATA_FOUND);
		return getElementText(driver, ProductPageUIAdmin.ERROR_MESSAGE_NO_DATA_FOUND);
	}

	public void clickSubCategoriesCheck() {
		waitToElementClickAble(driver, ProductPageUIAdmin.SEARCHSUBCATEGORIES_CHECKBOX);
		checkToCheckbox(driver, ProductPageUIAdmin.SEARCHSUBCATEGORIES_CHECKBOX);
	}

	public void clickManufacturer(int itemValue, String values) {
		waitToElementVisible(driver, ProductPageUIAdmin.DYNAMIC_DROPDOW_SEARCH, values);
		selectItemByIndexInDropdown(driver, ProductPageUIAdmin.DYNAMIC_DROPDOW_SEARCH, itemValue, values);
	}

	public void inputTextBoxByID(String value, String values) {
		waitToElementVisible(driver, AbstractPageUIAdmin.DYNAMIC_TEXTBOX_ADMIN, values);
		sendkeyToElement(driver, AbstractPageUIAdmin.DYNAMIC_TEXTBOX_ADMIN, value, values);
	}
}
