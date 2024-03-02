package features_steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import cleaning.services.util.Admin;
import cleaning.services.util.Customer;
import cleaning.services.util.DB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerInfo_steps {
Admin admin=new Admin();
Customer customer;
static ArrayList<Customer>Customers=new ArrayList<Customer>();
Customer selectedCustomer;
Customer customerExist;
Customer doesnotExist;
boolean exit=false;
boolean there=false;
Customer x;
@Given("that administrator is logged in")
public void that_administrator_is_logged_in() {
//  assertTrue(this.admin.isloggedin==true);
}

@When("I go to customer section")
public void i_go_to_customer_section() {
	customer=new Customer();
	selectedCustomer=new Customer();
	customerExist=new Customer();
	doesnotExist=new Customer();

}

@When("I enter the customer's first name as {string}")
public void i_enter_the_customer_s_first_name_as(String string) {
           customer.setFirstName(string);
           customerExist.setFirstName(string);
           customer.getFName();
}

@When("I enter the customer's last name as {string}")
public void i_enter_the_customer_s_last_name_as(String string) {
         customer.setLastName(string);
         customerExist.setLastName(string);
}

@When("I enter the customer's email address as {string}")
public void i_enter_the_customer_s_email_address_as(String string) {
  
	      customer.setEmail(string);
         customerExist.setEmail(string);
        if( DB.sameCustomerEmail(string, Customers)&&DB.exit(doesnotExist,Customers));
        
}

@When("I enter the customer's phone number as {string}")
public void i_enter_the_customer_s_phone_number_as(String string) {
       customer.setPhone(string);
       customerExist.setPhone(string);
       customer.getPhone();
}

@When("I enter the customer's mailing address as {string}")
public void i_enter_the_customer_s_mailing_address_as(String string) {
       customer.setAddress(string);
       customerExist.setAddress(string);
       customer.getAddress();

}
@Then("I click the {string} button for the customer")
public void i_click_the_button_for_the_customer(String string) {
                                        
}
@Then("I click the add button for the customer")
public void i_click_the_add_button_for_the_customer() {
	   DB.createCustomer(customer,Customers);
}
@Then("the customer's full information should be saved in the system")
public void the_customer_s_full_information_should_be_saved_in_the_system() {
	DB.returnCustomer(customer.getMail(), Customers);
	assertTrue(DB.haveCustomer(customer,Customers));
}

@Then("I should see a confirmation message that the customer was added successfully")
public void i_should_see_a_confirmation_message_that_the_customer_was_added_successfully() {
     	  System.out.println("Customer was added successfully!");

}
@Then("customer will not be added again to the system")
public void customer_will_not_be_added_again_to_the_system() {
	    assertFalse(DB.specialEmail(customerExist.getMail(),Customers));

}

@Then("I should see a message that the customer already exist")
public void i_should_see_a_message_that_the_customer_already_exist() {
    System.out.println("Customer already exist!");
}

@When("I search for the customer with the email address {string}")
public void i_search_for_the_customer_with_the_email_address(String string) {
            		selectedCustomer.setEmail(string);;

}

@When("I update the customer's first name to {string}")
public void i_update_the_customer_s_first_name_to(String string) {
	           DB.updateCustomerFName(selectedCustomer.getMail(),string,Customers);
}

@When("I update the customer's last name to {string}")
public void i_update_the_customer_s_last_name_to(String string) {
	 DB.updateCustomerLName(selectedCustomer.getMail(),string,Customers);
}

@When("I update the customer's phone number to {string}")
public void i_update_the_customer_s_phone_number_to(String string) {
	 DB.updateCustomerPhone(selectedCustomer.getMail(),string,Customers);
}

@When("I update the customer's mailing address to {string}")
public void i_update_the_customer_s_mailing_address_to(String string) {
	DB.updateCustomerAddress(selectedCustomer.getMail(),string,Customers);
}

@Then("the customer's full information should be updated in the system")
public void the_customer_s_full_information_should_be_updated_in_the_system() {
	 for(Customer C: Customers) {
     	if( C.getMail().equals(selectedCustomer.getMail())) {
     	    assertTrue(Customers.contains(C));

     	}
      }

}
@Then("I should see a confirmation message that the customer was updated successfully")
public void i_should_see_a_confirmation_message_that_the_customer_was_updated_successfully() {
          System.out.println("Customer was updated successfully");
}

@Then("the fail to update customer because it does not exist")
public void the_fail_to_update_customer_because_it_does_not_exist() {

	
}

@When("I confirm that I want to delete the customer's information")
public void i_confirm_that_i_want_to_delete_the_customer_s_information() {
  
    	DB.removed(selectedCustomer.getMail(), Customers);
    		    DB.exit(doesnotExist, Customers);
	 DB.removeCustomer(selectedCustomer.getMail(),Customers);
     
}

@Then("the customer's full information should be deleted from the system")
public void the_customer_s_full_information_should_be_deleted_from_the_system() {
	  	assertFalse(DB.haveCustomer(selectedCustomer,Customers));

}

@Then("I should see a confirmation message that the customer was deleted successfully")
public void i_should_see_a_confirmation_message_that_the_customer_was_deleted_successfully() {
        System.out.print("The customer was deleted successfully");
}

@Then("the fail to delete customer because it does not exist")
public void the_fail_to_delete_customer_because_it_does_not_exist() {

}
@When("I search for non existing customer with the email address {string}")
public void i_search_for_non_existing_customer_with_the_email_address(String string) {
     doesnotExist.setEmail(string);
     assertFalse(DB.exit(doesnotExist,Customers));
     assertTrue(DB.removed(string, Customers));

}
@Given("the system has a customer")
public void the_system_has_a_customer() {
x=new Customer();
x.setFirstName("first name");
x.setLastName("last name");
x.setPhone("0599");
x.setEmail("email");
x.setAddress("address");
}

@When("the Admin wants to print the customer informations")
public void the_admin_wants_to_print_the_customer_informations() {
   x.print();
}

@Then("the informations are printed")
public void the_informations_are_printed() {

}
}