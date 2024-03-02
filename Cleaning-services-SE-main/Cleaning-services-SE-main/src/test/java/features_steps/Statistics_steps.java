package features_steps;


import java.util.ArrayList;
import java.util.List;

import cleaning.services.util.Customer;
import cleaning.services.util.Invoice;
import cleaning.services.util.Product;
import cleaning.services.util.Statistics;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Statistics_steps {
	 public List<Customer> customers=new  ArrayList<>();;
	 public List<Statistics> statistics=new ArrayList<>();
	 Customer razan;
	 Customer Nour;
	  Statistics s;
	  Invoice i1;
	  Invoice i2;
	 
	@Given("the system has customers")
	public void the_system_has_customers() {
razan=new Customer();
Nour=new Customer();
customers.add(Nour); customers.add(razan);
	}
	@Given("the customers have products")
	public void the_customers_have_products() {
Product p1=new Product();
p1.setID("1");
p1.setWeight(3.0);
p1.setWidth(3.0);
p1.setLength(3.0);
p1.setCategory("rug");
p1.setSpecialTreatment("yes");

Product p2=new Product();
p2.setID("2");
p2.setWeight(3.0);
p2.setWidth(3.0);
p2.setLength(3.0);
p2.setCategory("rug");
p2.setSpecialTreatment("yes");
razan.addProduct(p1); razan.addProduct(p2);

Product p3=new Product();
p3.setID("3");
p3.setWeight(3.0);
p3.setWidth(3.0);
p3.setLength(3.0);
p3.setCategory("rug");
p3.setSpecialTreatment("yes");
Nour.addProduct(p3);
	}
	@Given("the customers have invoices")
	public void the_customers_have_invoices() {
i1=new Invoice(razan);
i1.setPaid(true);
razan.addInvoice(i1);
i2=new Invoice(Nour);
i2.setPaid(false);
Nour.addInvoice(i2);
}

	@When("the Admin wants to generate a statistics")
	public void the_admin_wants_to_generate_a_statistics_about_debts_and_cash() {
		s=new Statistics();
		  s.setCustomers(customers);
		    statistics.add(s);
		   s.printStatistics();
	}

	@Then("the statistics is generated includes all debts")
	public void the_statistics_is_generated_includes_all_debts() {
	s.calculateTotalDebts();
	}

	@Then("the statistics is generated includes all cash")
	public void the_statistics_is_generated_includes_all_cash() {
		  s.calculateTotalPaid();
	}
	@Then("the statistics is generated includes count of customers")
	public void the_statistics_is_generated_includes_count_of_customes() {
	    s.countOfProducts();
	}
	
	/*Scenario: return the customer lists
			Given: the system has customers
			When: the Admin wants to know the customers
			Then: the list of customers will be returned*/


			@When("the Admin wants to know the customers")
			public void the_Admin_wants_to_know_the_customers() {
			s=new Statistics();
		s.setCustomers(customers);
			}

			@Then("the list of customers will be returned")
			public void the_list_of_customers_will_be_generated() {
		s.getCustomersList();
			}

}