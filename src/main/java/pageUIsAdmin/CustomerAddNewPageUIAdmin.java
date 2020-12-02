package pageUIsAdmin;

public class CustomerAddNewPageUIAdmin {
	public static final String CUSTOMER_INFO_EXPAND = "//div[@class='panel-heading']";
	public static final String GENDER_RADIO_BUTTON = "//input[@id='Gender_Male']";
	public static final String CUSTOMER_ROLE_DROPDOWN = "//option[contains(text(),'Guests')]//parent::select//preceding-sibling::div//input";
	public static final String CUSTOMER_ROLE_CHILD_DROPDOWN = "//select[@id='SelectedCustomerRoleIds']/option";
	public static final String ADMIN_COMMENT_TEXTBOX = "//textarea[@id='AdminComment']";
	public static final String DYNAMIC_SAVE_AND_CONTINUE_BUTTON = "//button[@name='%s']";
	public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[contains(text(),'back to customer list')]";
	public static final String DELETE_TITLE_CUSTOMER_INFO = "//span[@title='delete']";
	public static final String CUSTOMER_ROLE_ADD_SUCCESS_TEXT = "//span[contains(text(),'Guests')]//parent::li";
	public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
	public static final String ADMIN_COMMENT_TEXT = "//textarea[@id='AdminComment']";
	public static final String ADDRESS_COLLAPSE = "//div[@class='panel-heading']//span[text()='Addresses']";
	public static final String DELETE_ADDRESS_BUTTON = "//a[contains(text(),'Delete')]";
	public static final String MESSAGE_DELETE_ADDRESS = "//div[@class='panel-container']//td[@class='dataTables_empty']";
	
	
	
	
}
