package features_steps;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import cleaning.services.util.Customer;
import cleaning.services.util.DB;
import cleaning.services.util.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class insertPtoC_steps {
	Customer C=new Customer();
	Product P=new Product();
	ArrayList <Product> myProd= new ArrayList<Product>();
	ArrayList <Customer> myCustomer= new ArrayList<Customer>();
	
	@Given("customer want to add new product to clean")
	public void customer_want_to_add_new_product_to_clean() {
	    C.setEmail("nour");
	    P.setID("ID");
	    C.addProduct(P);
	
		  DB.addProductTo(C.getMail(), P, myCustomer);
	}

	@Given("customer can update info of product")
	public void customer_can_update_info_of_product() {
		  C.setEmail("nour");
		    P.setID("ID");
		    C.addProduct(P);
		    myCustomer.add(C);
	  for(int i=0;i<13;i++) {
		  String newV="newValue";
		  if(i==7||i==8||i==9) {
			  newV="3.0";
		  }
	  DB.updateProductInfo(i,newV,P.getID(),C.getMail(),myCustomer);
	  }
	}

	@Given("customer can remove product")
	public void customer_can_remove_product() {

		if(!(DB.haveProduct(C.getMail(), P, myCustomer)&&C.specialProduct(P)))
	   DB.removeProduct(P.getID(),C.getMail(),myCustomer);
	 
	}

	@When("customer select add or update he can be able to add or ubdate product")
	public void customer_select_add_or_update_he_can_be_able_to_add_or_ubdate_product() {
	     DB.trackCustomer(C.getMail(),P.getID(), myCustomer);
	
	}
          

	@Given("customer want information of all products")
	public void customer_want_information_of_all_products() {
	
		    C.setEmail("nour");
		    P.setID("ID");
		    P.setWeight(3.3);
		    P.setWidth(3.3);
		    P.setLength(3.3);
		    P.setCategory("rug");
		    P.setSpecialTreatment("yes");
		    C.addProduct(P);
		    myCustomer.add(C);
		DB.printAllProducts("nour", myCustomer);
	}

	@Given("customer print product")
	public void customer_print_product() {
	 
	    C.setEmail("nour");
	    P.setID("ID");
	    P.setWeight(3.3);
	    P.setWidth(3.3);
	    P.setLength(3.3);
	    P.setCategory("rug");
	    P.setSpecialTreatment("yes");
	    C.addProduct(P);
	    myCustomer.add(C);
	    DB.printProduct("nour","ID", myCustomer);
	}

	@When("customer will see information of all products")
	public void customer_will_see_information_of_all_products() {
	      
	}


@Given("customer want Delete all products")
public void customer_want_delete_all_products() {
    
}

@When("customer delete all")
public void customer_delete_all() {
    C.deleteAllProducts();
}

@Then("all products must be deleted")
public void all_products_must_be_deleted() {
    assertTrue(C.getProducts().isEmpty());
}

}