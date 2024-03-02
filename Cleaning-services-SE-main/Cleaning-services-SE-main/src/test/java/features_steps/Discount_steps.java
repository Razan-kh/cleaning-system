 package features_steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cleaning.services.util.Customer;
import cleaning.services.util.Invoice;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Discount_steps {
	Customer c=new Customer();
	Invoice x=new Invoice(c);
	double discount_percent;
	@Given("the total amount of money is greater than or equal {int} NIS")
	public void the_total_amount_of_money_is_greater_than_nis(Integer int1) {
		x.setTotalPriceBeforeDiscount(int1);

	}

	@Then("the customer get {double} discount")
	public void the_customer_get_discount(Double double1) {
x.setDiscountPercent(double1);
x.setDiscount();
discount_percent=double1;
	}

	@Then("the total amount of money equal {int}% of the original amount")
	public void the_total_amount_of_money_equal_of_the_original_amount(Integer int1) {
		assertEquals(x.getTotalPriceAfterDiscount(), (1-discount_percent)*x.getTotalPriceBeforeDiscount());
	}

}
