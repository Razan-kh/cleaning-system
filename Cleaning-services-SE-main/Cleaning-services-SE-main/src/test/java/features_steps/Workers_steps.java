package features_steps;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import cleaning.services.util.DB;
import cleaning.services.util.Product;
import cleaning.services.util.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Workers_steps {
	static List <Worker>list=new ArrayList<>();
	static public boolean isDistrubuted=false;
	static public boolean isRemoved=false;
	Product product;
	Product done;
	@Given("there are available workers")
	public void there_are_available_workers() {
          for(Worker W:list) {
        	  W.getId();
        	  W.getName();
        	  W.getSalary();
        	  W.getProduct();
          }
		
		   DB.addWorkerToSystem(list);
           
	}

	@Given("a there is a new order to the system")
	public void a_there_is_a_new_order_to_the_system() {
	    product=new Product();
        product.setID("123");
        
	}

	@When("the order is assigned to the available worker")
	public void the_order_is_assigned_to_the_available_worker() {
	         DB.assignProductToWorkers(product,list);
	}

	@Then("each order should have a worker")
	public void each_order_should_have_a_worker() {
	       assertNotEquals(list.size(),0);
	      
	}

	@Given("a ready to work on new order")
	public void a_ready_to_work_on_new_order() {
		done=new Product();
        done.setID("123");
	}

	@When("the order is removed from system")
	public void the_order_is_removed_from_system() {
		    DB.removeOrderFromWorker(done,list);
		    isRemoved=true;
	}

	@Then("number of orders to the worker should be decreased")
	public void number_of_orders_to_the_worker_should_be_decreased() {
		 assertEquals(true,isRemoved);
	}

}