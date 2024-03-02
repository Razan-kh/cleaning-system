
package features_steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import cleaning.services.util.Customer;
import cleaning.services.util.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order_track{
	private Customer customer;
    private Product order;
    private String  st;
	@Given("a customer with email \"nour@gmail.com\"want to track thier order")
	public void a_customer_with_email_nour_gmail_com_want_to_track_thier_order() {
	         customer=new Customer();
	}

	@When("I enter the product id i want to check {string}")
	public void i_enter_the_product_id_i_want_to_check(String string) {
	         order=new Product();
		     order.setID(string);
		     customer.addProduct(order);
		     customer.trackOrder(string);
	}

	@Then("the system displays the order status, which can be {string}, {string} or {string}")
	public void the_system_displays_the_order_status_which_can_be_or(String string, String string2, String string3) {
	  assertTrue(order.getStatus().equals(string)||order.getStatus().equals(string2)||order.getStatus().equals(string3));
	}

	@Given("I am logged in as an Admin")
	public void i_am_logged_in_as_an_admin() {
	
	}

	@When("I select customer with email \"nour@gmail.com\"want to track thier order")
	public void i_select_customer_with_email_nour_gmail_com_want_to_track_thier_order() {
		  customer=new Customer();
	}

	@When("I change the status to {string} or {string}")
	public void i_change_the_status_to_or(String string, String string2) {
	          order.setStatus(string);
	          st=string;
	}

	@Then("the system updates the order status accordingly")
	public void the_system_updates_the_order_status_accordingly() {
	          assertEquals(st,order.getStatus());
	}
}