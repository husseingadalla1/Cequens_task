package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.GenericMethods;
import pages.HomePage;
import pages.RegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homepage_obj;
	RegisterationPage registerpage_obj;

	



	@Test(priority = 1) 
							
	public void verify_user_Can_Register_Successfully() {

		homepage_obj = new HomePage(driver);
		homepage_obj.open_registeration_page();

		GenericMethods.implicit_wait_for_seconds(driver, 5);

		registerpage_obj = new RegisterationPage(driver);
		registerpage_obj.user_can_register_steps();

		boolean Nothing_booked_msg_presence = registerpage_obj.user_succssfully_registered_verification();
		registerpage_obj.signout_steps();
		Assert.assertEquals(Nothing_booked_msg_presence, true);
	}

}
