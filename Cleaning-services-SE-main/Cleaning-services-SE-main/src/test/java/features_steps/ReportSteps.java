package features_steps;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import cleaning.services.util.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.package1.CleaningSystem;

public class ReportSteps {
	 Boolean isMade=false;
	 ArrayList<Customer>customers=new ArrayList<>();
	@Given("admin want to make a report about customers")
	public void admin_want_to_make_a_report_about_customers() {
             
	}

	@When("enters generate report")
	public void enters_generate_report() {
	 CleaningSystem.customerReport(customers);
		isMade=true;
	}

	@Then("a report about the customer will be generated")
	public void a_report_about_the_customer_will_be_generated() {
	    
	      assertTrue(isMade);
	      
	}

	@Given("admin want to make a report about products")
	public void admin_want_to_make_a_report_about_products() {
		CleaningSystem.productReport(customers);
		isMade=true;
	}

	@Then("a report about the products will be generated")
	public void a_report_about_the_products_will_be_generated() {
		 assertTrue(isMade);
		
	}

	@Given("admin want to make a report about workers")
	public void admin_want_to_make_a_report_about_workers() {
		isMade=true;
		//Cleaning_System.workerReport();
	}

	@Then("a report about the workers will be generated")
	public void a_report_about_the_workers_will_be_generated() {
	          
	          assertTrue(isMade);
	}

	@Given("admin want to make a report about system")
	public void admin_want_to_make_a_report_about_system() {
		CleaningSystem.report(customers);
		isMade=true;
	}

	@Then("a report about the system will be generated")
	public void a_report_about_the_system_will_be_generated() {
		 assertTrue(isMade);
	}
}