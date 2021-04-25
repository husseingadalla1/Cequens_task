package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GenericMethods;
import pages.HomePage;
import pages.LoginPage;
import test_data.JsonReader;

public class UserLoginTest extends TestBase {

	HomePage homeobj;
	LoginPage loginobj;

	

	@Test(priority = 1, enabled = true)
	public void verify_user_canlogin_valid_credentials() throws IOException, ParseException {
		JsonReader jsonreaderobj = new JsonReader();
		jsonreaderobj.JsonFileReader("TestDataLogin.json");
		
		homeobj = new HomePage(driver);
		homeobj.open_login_page();
		GenericMethods.implicit_wait_for_seconds(driver, 5);
		
		loginobj = new LoginPage(driver);
		loginobj.login_steps(jsonreaderobj.email, jsonreaderobj.password);
		
		boolean Nothing_booked_msg_presence = loginobj.user_succssfully_login_verification();
		loginobj.signout_steps();
		Assert.assertEquals(Nothing_booked_msg_presence, true);

		

	}

}

