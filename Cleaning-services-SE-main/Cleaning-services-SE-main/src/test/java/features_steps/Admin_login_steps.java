package features_steps;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;

import cleaning.services.util.Admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Admin_login_steps {
    Admin admin;
    boolean correctPass;
    boolean correctUser;
	@Given("that the administrator is not logged in")
	public void that_the_administrator_is_not_logged_in() {
 		 admin=new Admin();
         admin.getLoggedIn();
	}

	
	@Given("the passoward is {string}")
	public void the_passoward_is(String string) throws NoSuchAlgorithmException {
		correctPass=admin.checkpass(string);
	}
	
	@When("the userName is {string}")
	public void the_user_name_is(String string) {
		correctUser=admin.checkUser(string);

		
	}
 
	@Then("the administrator login succeeds")
	public void the_administrator_login_succeeds() {
		     assertTrue((correctPass==true)&&(correctUser==true));
		     admin.setLoggedIn(true);
	}

	@Then("the administrator is logged in")
	public void the_administrator_is_logged_in() {
		admin.setLoggedIn(true);
		admin.goHomePage();
		
	}

	
	
	@Then("the administrator login fails")
	public void the_administrator_login_fails() {
		  assertFalse(correctPass||correctUser);
		  admin.setLoggedIn(false);
	}

	 @Then("the administrator is not logged in")
	public void the_administrator_is_not_logged_in() {
		  admin.showFailMessage();
	}
}