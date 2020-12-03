package pageUIsAdmin;

public class AbstractPageUIAdmin {
	public static final String DYNAMIC_SEARCH_BUTTON = "//button[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_ADMIN = "//input[@id='%s']";
	public static final String DYNAMIC_LIST_MENU_LINK_DASBOARD = "//i[@class='%s']";
	public static final String DYNAMIC_LIST_MENU_CUSTOMERS_CHILD_NOT_SELECTED_LINK_DASBOARD = "//li[@class='treeview menu-open']//ul//span[contains(text(),'%s')]";
	public static final String DYNAMIC_LIST_MENU_CUSTOMERS_CHILD_SELECTED_LINK_DASBOARD = "//li[@class='treeview active current-active-item menu-open']//ul//span[contains(text(),'Customers')]";
	public static final String DYNAMIC_MESSAGE_ALLERT = "//div[@class='alert alert-success alert-dismissable' and contains(string(),'%s')]";
	public static final String DYNAMIC_BUTTON_IN_ADD_NEW_ADDRESS_PAGE = "//button[contains(text(),'%s')]";
}
