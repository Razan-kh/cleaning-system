package features_steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import cleaning.services.util.Customer;

import cleaning.services.util.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class product_steps {
	Product product;
	Customer owner;
    Product selected_product;
    Product productExist;
    Product doesnotExist;
@When("I go to customer section then to products")
public void iGoToCustomerSectionThenToProducts() {
       owner=new Customer();
	   product=new Product();
       selected_product=new Product();
       selected_product.setID("ID");
       owner.addProduct(selected_product);
       productExist=new Product();
       doesnotExist=new Product();
}

@When("I enter I enter the ID of the product as {string}")
public void iEnterIEnterTheIDOfTheProductAs(String string) {
    product.setID(string);
    productExist.setID(string);
    product.getID();
}

@When("I enter the name as {string}")
public void iEnterTheNameAs(String string) {
   product.setName(string);
   productExist.setName(string);
   product.getName();
}

@When("I enter the category as {string}")
public void iEnterTheCategoryAs(String string) {
    product.setCategory(string);
    productExist.setCategory(string);
    product.getCategory();
}

@When("I enter the description as {string}")
public void iEnterTheDescriptionAs(String string) {
   product.setDescription(string);
   productExist.setDescription(string);
   product.getDescription();
}

@When("I enter the weight in Kg as {double}")
public void i_enter_the_weight_in_kg_as(Double double1) {
   product.setWeight(double1);
   productExist.setWeight(double1);
   product.getWeight();
}

@When("I enter the length in m as {double}")
public void iEnterTheLengthInMAs(Double double1) {
   product.setLength(double1);
   productExist.setLength(double1);
   product.getLength();
}

@When("I enter the width in m as {double}")
public void iEnterTheWidthInMAs(Double double1) {
  product.setWidth(double1);
  productExist.setWidth(double1);
  product.getWidth();
}

@When("I enter the picture as {string}")
public void iEnterThePictureAs(String string) {
   product.setPicture(string);
   productExist.setPicture(string);
   product.getPicture();
}

@When("I enter the special_treatment as {string}")
public void iEnterTheSpecialTreatmentAs(String string) {
   product.setSpecialTreatment(string);
   productExist.setSpecialTreatment(string);
   product.getSpecialTreatment();
}

@When("I enter the material as {string}")
public void iEnterTheMaterialAs(String string) {
   product.setMaterial(string);
   productExist.setMaterial(string);
   product.getMaterial();
}

@When("I enter the status of product as {string}")
public void iEnterTheStatusOfProductAs(String string) {
  product.setStatus(string);
  productExist.setStatus(string);
  product.getStatus();
}
@When("I enter the date we got the product as {string}")
public void i_enter_the_date_we_got_the_product_as(String string) {
	  product.setStartDate(string);
	  productExist.setStartDate(string);
	  product.getStartDate();
}

@When("I enter the date we Finish with the product as {string}")
public void i_enter_the_date_we_finish_with_the_product_as(String string) {
	  product.setFinishDate(string);
	  productExist.setFinishDate(string);
	  product.getFinishDate();
}
@Then("I click the add Product button")
public void iClickTheAddProductButton() {
 
    owner.addProduct(product);
}

@Then("the Product's full information should be saved in the system")
public void theProductSFullInformationShouldBeSavedInTheSystem() {
    assertTrue(owner.have(product));
}

@Then("Price of the product will be calculated")
public void priceOfTheProductWillBeCalculated() {
   // double Price=product.calculate_price();
}

@Then("I should see a confirmation message that the Product was added successfully")
public void iShouldSeeAConfirmationMessageThatTheProductWasAddedSuccessfully() {
    System.out.println("Product was added successfully to the system");
   product.setCategory("rug");
   product.setSpecialTreatment("yes");
	product.calculatePrice();
	 
	 assertNotEquals(product.getPrice(),-1);
    product.setCategory("mattress");
    product.calculatePrice();
    assertNotEquals(product.getPrice(),-1);
    product.setCategory("blanket");
   product.calculatePrice();
   assertNotEquals(product.getPrice(),-1);
    product.setCategory("other");
    product.calculatePrice();
    assertNotEquals(product.getPrice(),-1);
     
}

@When("Product will not be added again to same customer the system")
public void productWillNotBeAddedAgainToSameCustomerTheSystem() {
	 
      
	     assertFalse(owner.specialProduct(productExist));
}

@When("I should see a message that the Product already exist")
public void iShouldSeeAMessageThatTheProductAlreadyExist() {
    System.out.println("the Product already exist!");
}

@When("I search for the Product with the ID as {string}")
public void iSearchForTheProductWithTheIDAs(String string) {
       selected_product.setID(string);
}

@When("I Update the name to {string}")
public void i_update_the_name_to(String string) {
	 owner.setProductName(selected_product.getID(), string);
}

@When("I Update the category to {string}")
public void i_update_the_category_to(String string) {
	owner.setProductCategory(selected_product.getID(), string);
}

@When("I Update the description to {string}")
public void i_update_the_description_to(String string) {
	owner.updateProductDescription(selected_product.getID(), string);
}

@When("I Update the weight in Kg to {double}")
public void i_update_the_weight_in_kg_to(Double double1) {
	owner.updateProductWeight(selected_product.getID(), double1);
}

@When("I Update the length in m to {double}")
public void i_update_the_length_in_m_to(Double double1) {
	owner.updateProductLength(selected_product.getID(), double1);
}

@When("I Update the width in m to {double}")
public void i_update_the_width_in_m_to(Double double1) {
	owner.updateProductWidth(selected_product.getID(), double1);
}

@When("I Update the picture to {string}")
public void i_update_the_picture_to(String string) {
	owner.updateProductPicture(selected_product.getID(), string);
}

@When("I Update the special_treatment to {string}")
public void i_update_the_special_treatment_to(String string) {
	owner.updateProductSpecialTreatment(selected_product.getID(), string);
}

@When("I Update the material to {string}")
public void i_update_the_material_to(String string) {
	owner.updateProductMaterial(selected_product.getID(), string);
  
}

@When("I Update the status of product to {string}")
public void i_update_the_status_of_product_to(String string) {
	owner.updateProductStatus(selected_product.getID(), string);
}
@When("I Update the date we got the product as {string}")
public void i_update_the_date_we_got_the_product_as(String string) {
     owner.updateProductStartDate(selected_product.getID(), string);
}

@When("I Update the date we Finish with the product as {string}")
public void i_update_the_date_we_finish_with_the_product_as(String string) {
     owner.updateProductFinishDate(selected_product.getID(), string);
}
@Then("the Product's full information should be updated in the system")
public void theProductSFullInformationShouldBeUpdatedInTheSystem() {
	
}

@Then("I should see a confirmation message that the Product was updated successfully")
public void iShouldSeeAConfirmationMessageThatTheProductWasUpdatedSuccessfully() {
   System.out.println("the product was updated successfully!");
}

@When("I click the {string} button for the Product")
public void iClickTheButtonForTheProduct(String string) {
         
}

@When("I confirm that I want to delete the products information")
public void iConfirmThatIWantToDeleteTheProductsInformation() {
	 owner.removeProduct(selected_product);
}

@Then("the product's full information should be deleted from the system")
public void theProductSFullInformationShouldBeDeletedFromTheSystem() {
  assertFalse(owner.have(selected_product));
}

@Then("I should see a confirmation message that the product was deleted successfully")
public void iShouldSeeAConfirmationMessageThatTheProductWasDeletedSuccessfully() {
  System.out.print("the product was deleted succesfully!");
}
@When("I search for non existing product with id {string}")
public void i_search_for_non_existing_product_with_id(String string) {
    doesnotExist.setID(string);
    assertFalse(owner.have(doesnotExist));
}
}