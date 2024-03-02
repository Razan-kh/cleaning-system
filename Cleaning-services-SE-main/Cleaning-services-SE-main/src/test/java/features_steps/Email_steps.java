package features_steps;

import cleaning.services.util.SendEmaill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Email_steps {
	@Given("the order is ready")
	public void the_order_is_ready() {

	}

	@Then("the Admin sents email to the customer with email {string}")
	public void the_admin_sents_email_to_the_customer_with_email(String string) {
SendEmaill s=new SendEmaill();
s.email(string,"your order is ready");
	}

}
