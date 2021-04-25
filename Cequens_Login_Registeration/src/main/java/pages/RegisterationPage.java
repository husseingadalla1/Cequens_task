package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class RegisterationPage extends PageBase {

	public RegisterationPage(WebDriver driver_) {

		super(driver_);
		this.driver_page = driver_;

	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstname_input;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastname_input;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email_input;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement Mobile_input;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password_input;
	
	@FindBy(xpath = "//input[@name='confirmpassword']")
	WebElement confirm_password_input;

	@FindBy(xpath = "//button[@type='submit' and @class='signupbtn btn_full btn btn-success btn-block btn-lg']")
	public WebElement signup_button;
	
	@FindBy(xpath = "//i[@class='bx bx-user']")
	WebElement user_icon_top_right;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout_link;
	
	@FindBy(xpath = "//strong[contains(text(),'Nothing Booked Yet')]")
	WebElement Nothing_booked_txt;
	
	

	

	String Firstname = "Hussein";
	String Lastname = "Gadalla";
	String Random_character = GenericMethods.generateRandomCharacter();
	String Email = Firstname + "." + Lastname + Random_character + "@gmail.com";
	String password = "Test1234";
	String Mobile_No ="01002210048";

	

	public void user_can_register_steps() {
		GenericMethods.explicit_wait_for_seconds_visibility(driver_page, driver_wait_page, 10, firstname_input);
		GenericMethods.write_text_box(firstname_input, Firstname);
		GenericMethods.write_text_box(lastname_input, Lastname);
		GenericMethods.write_text_box(Mobile_input, Mobile_No);
		GenericMethods.write_text_box(email_input, Email);
		GenericMethods.write_text_box(password_input, password);
		GenericMethods.write_text_box(confirm_password_input, password);
		GenericMethods.scroll_to_element(signup_button, driver_page);
		GenericMethods.explicit_wait_for_seconds_clickability(driver_page, driver_wait_page, 5, signup_button);
		GenericMethods.click_element(signup_button);
		

	}

	public boolean user_succssfully_registered_verification() {

	//	GenericMethods.explicit_wait_for_seconds_invisibility(driver_page, driver_wait_page, 10, signup_button);
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
