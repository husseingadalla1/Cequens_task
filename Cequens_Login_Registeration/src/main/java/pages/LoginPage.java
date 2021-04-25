package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver_) {
		super(driver_);
		this.driver_page = driver_;
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement email_input_for_login;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pass_input_for_login;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn']")
	public static WebElement login_btn;
	
	@FindBy(xpath = "//i[@class='bx bx-user']")
	WebElement user_icon_top_right;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout_link;
	
	@FindBy(xpath = "//strong[contains(text(),'Nothing Booked Yet')]")
	WebElement Nothing_booked_txt;
	

	

	

	public void login_steps(String email, String password) {
		GenericMethods.write_text_box(email_input_for_login, email);
		GenericMethods.write_text_box(pass_input_for_login, password);
		GenericMethods.click_element(login_btn);
	}
	
	
	public boolean user_succssfully_login_verification() {

			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 5, Nothing_booked_txt);
			boolean result = GenericMethods.Check_element_is_present(Nothing_booked_txt);

			return result;
		}

		

		public void signout_steps() {

			GenericMethods.click_element(user_icon_top_right);
			GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 5,logout_link);
			GenericMethods.click_element(logout_link);
		}

	

	}


