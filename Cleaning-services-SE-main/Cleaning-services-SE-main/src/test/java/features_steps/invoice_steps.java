package features_steps;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;

import cleaning.services.util.Customer;
import cleaning.services.util.DB;
import cleaning.services.util.Product;
import cleaning.services.util.Invoice;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class invoice_steps {
	Customer x=new Customer();
	 Invoice inv;
	 Invoice inv1;
	 Product p=new Product();
	 Invoice i=new Invoice();
	 int invid;
	 boolean expectedPaid;
	 boolean actualPaid;
	 double actualDiscountPercent;
	 double expectedDiscountPercent;
	 String expected;
	 String email;
	 List<Customer>customers=new ArrayList<>();
	@Given("the customer has a products")
	public void the_customer_has_a_products() {
		x.addProduct(p);
	   
	} 
	@Given("the product length is {double}")
	public void the_product_length_is(Double double1) {
		p.setLength(double1);
	}

	@Given("the product Width is {double}")
	public void the_product_width_is(Double double1) {
		p.setWidth(double1);
	}

	@Given("the product Category is {string}")
	public void the_product_category_is(String string) {
		p.setCategory(string);
	}
	@Given("the special treatment is {string}")
	public void the_special_treatment_is(String string) {
	p.setSpecialTreatment(string);
	}
	@Given("the customer email is {string}")
	public void the_customer_email_is(String string) {
	 email=string;
		x.setEmail(string);
		customers.add(x);
	}

	@When("he wants to cheackout")
	public void he_wants_to_cheackout() {
	
	}

	@Then("an invoice with requiered information is generated")
	public void an_invoice_with_requiered_information_is_generated() {
  //   inv=new Invoice(x);
	DB.createInvoiceALLProducts(email, customers);
     x.addInvoice(inv);;
	} 
	@Then("the invoice is added to the list of customer's invoices")
	public void the_invoice_is_added_to_the_list_of_customer_s_invoices() {
		assertTrue(x.getInvoices().contains(inv));
	}
	@Given("the product id is {string}")
	public void the_product_id_is(String string) {
p.setID(string);
x.addProduct(p);
	}

	@When("he enters the ID of the product as {string}")
	public void he_enters_the_id_of_the_product_as(String string) {
	//	inv=new Invoice(x,string);
		inv=DB.createInvoiceProduct(email, string, customers);
		x.addInvoice(inv);
	}

	
	@Given("if the discount percent is {double}")
	public void if_the_discount_percent_is(Double double1) {
		actualDiscountPercent=double1;
	}

	@When("the user wants the discount percent")
	public void the_user_wants_the_discount_percent() {
expectedDiscountPercent=i.getDiscount();
	}
	
	@Then("the returned value equals the discount percent")
	public void the_returned_value_equals_the_discount_percent() {
		assertEquals(expectedDiscountPercent, actualDiscountPercent,0.1);
	}
 

	@When("the customer wants to print it")
	public void the_customer_wants_to_print_it() {
	 DB.printInvoice(invid, customers);
	}

	@Given("the invoice is paid")
	public void the_invoice_is_paid() {
		inv=new Invoice();
	   inv.setPaid(true);
	}

@When("the user wants to check wether it's paid or not")
public void the_user_wants_to_check_wether_it_s_paid_or_not() {
 expectedPaid=inv.isPaid();
expected=String.valueOf(expectedPaid);
}

@Then("the function returns {string}")
public void the_function_returns(String string) {
   assertEquals(expected,string);
}
@Given("the customer have invoice")
public void the_customer_have_invoice() {
	p.setID("1");
	p.setWeight(3.0);
	p.setWidth(3.0);
	p.setLength(3.0);
	p.setCategory("rug");
	p.setSpecialTreatment("yes");
	x.addProduct(p);
	inv=new Invoice(x);
	invid=inv.getID();
    x.addInvoice(inv);
    customers.add(x);
}

@Given("he wants to pay an invoice")
public void he_wants_to_pay_an_invoice() {
  DB.payInvoice(customers, invid);
}
@Then("the invoice paying is done")
public void the_invoice_paying_is_done() {
  assertTrue(inv.isPaid());
}

@When("he wants to cheackout but the email is wrong")
public void he_wants_to_cheackout_but_the_email_is_wrong() {
 DB.createInvoiceALLProducts("wrongemail", customers);
 DB.createInvoiceProduct("wrongemail", "1", customers);
}

@Then("nothing will be generated")
public void nothing_will_be_generated() {
   
}
}
