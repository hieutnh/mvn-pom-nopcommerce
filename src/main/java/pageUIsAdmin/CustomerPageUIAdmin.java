package pageUIsAdmin;

public class CustomerPageUIAdmin {
	public static final String ADD_NEW_CUSTOMER_BUTTON = "//a[@class='btn bg-blue']";
	public static final String CUSTOMER_ROLE_DROPDOWN = "//option[contains(text(),'Guests')]//parent::select//preceding-sibling::div//input";
	public static final String DELETE_TITLE_CUSTOMER_INFO = "//span[@title='delete']";
	public static final String ROW_CUSTOMER_ROLES_WITH_GUESTS = "//td[text()='Guests']";
	public static final String DYNAMIC_HEADER_COLUMNNAME = "//th[contains(text(),'%s')]//preceding-sibling::th";
	public static final String DYNAMIC_VALUE_AT_SOME_COLUMN = "//tr[%s]//td[%s][contains(text(),'%s')]";
	public static final String COUNT_NUMBER_ITEM_DISPLAY = "//tr//td[contains(text(),'Guests')]";
	public static final String MONTH_OF_MONTH_OF_BIRTH_DROPDOWN = "//select[@id='SearchMonthOfBirth']";
	public static final String MONTH_OF_DAY_OF_BIRTH_DROPDOWN = "//select[@id='SearchDayOfBirth']";
	public static final String EDIT_USER_BUTTON = "//i[@class='fa fa-pencil']";
	public static final String ACTIVE_CHECK_TRUE = "//i[@class='fa fa-check true-icon']";
	
	
	
	
	
}
