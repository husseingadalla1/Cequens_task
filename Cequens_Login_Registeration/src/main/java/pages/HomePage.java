package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver_) {
		super(driver_);
		this.driver_page = driver_;

	}

	@FindBy(xpath = "//i[@class='bx bx-user']")
	WebElement user_icon_top_right;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signup_link;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement login_link;


	
	
	public void open_registeration_page() {
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, user_icon_top_right);
		GenericMethods.click_element(user_icon_top_right);
		GenericMethods.implicit_wait_for_seconds(driver_page, 4);
		GenericMethods.click_element(signup_link);
	}
	
	
	public void open_login_page() {
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, user_icon_top_right);
		GenericMethods.click_element(user_icon_top_right);
		GenericMethods.implicit_wait_for_seconds(driver_page, 4);
		GenericMethods.click_element(login_link);
	}
	

}
