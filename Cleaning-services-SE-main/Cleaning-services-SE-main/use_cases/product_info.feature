Feature: Record Full Information for Product
   admin can be able to record full information for a Product 
   to different Customers 
  Scenario: Record full information for a new Product
    Given that administrator is logged in
    When I go to customer section then to products 
    And I enter I enter the ID of the product as "ID"
    And  I enter the name as "sams Carpet" 
    And  I enter the category as "Carpet" 
    And  I enter the description as "Red Large" 
    And  I enter the weight in Kg as 3.0
    And  I enter the length in m as 3.4
    And  I enter the width in m as 2.5
    And  I enter the picture as "Carpet.jpg" 
    And  I enter the special_treatment as "yes" 
    And  I enter the material as "silk" 
    And  I enter the status of product as "waiting"
    And  I enter the date we got the product as "4/3/2002"
    And  I enter the date we Finish with the product as "5/3/2002"
    Then I click the add Product button
    And the Product's full information should be saved in the system
    And Price of the product will be calculated 
    And I should see a confirmation message that the Product was added successfully
 
  Scenario: Record full information for a Product that already exist in its Customer 
    Given that administrator is logged in
    When I go to customer section then to products
    And I enter I enter the ID of the product as "ID"
    And  I enter the name as "sams Carpet" 
    And  I enter the category as "Carpet" 
    And  I enter the description as "Red Large" 
    And  I enter the weight in Kg as 3.0
    And  I enter the length in m as 3.4
    And  I enter the width in m as 2.5
    And  I enter the picture as "Carpet.jpg" 
    And  I enter the special_treatment as "yes" 
    And  I enter the material as "silk" 
    And  I enter the status of product as "waiting"
    And  I enter the date we got the product as "4/3/2002"
    And  I enter the date we Finish with the product as "5/3/2002"
    Then I click the add Product button
    And Product will not be added again to same customer the system
    And I should see a message that the Product already exist
 
  Scenario: Edit full information for an existing Product 
    Given that administrator is logged in
    When I go to customer section then to products
    And I search for the Product with the ID as "ID"
    And  I Update the name to "lily's Carpet" 
    And  I Update the category to "Carpet" 
    And  I Update the description to "green Large" 
    And  I Update the weight in Kg to 3.0
    And  I Update the length in m to 3.4
    And  I Update the width in m to 2.5
    And  I Update the picture to "Carpet.jpg" 
    And  I Update the special_treatment to "yes" 
    And  I Update the material to "silk" 
    And  I Update the status of product to "completed"
    And  I Update the date we got the product as "4/3/2002"
    And  I Update the date we Finish with the product as "5/3/2002"
    Then the Product's full information should be updated in the system
    And Price of the product will be calculated 
    And I should see a confirmation message that the Product was updated successfully

    Scenario: Edit a product that does not exist
    Given that administrator is logged in
    When I go to customer section then to products
    And I search for non existing product with id "123"
    And I click the "Edit" button for the Product
    Then the fail to delete customer because it does not exist
    
  Scenario: Delete a Product's information from the system
    Given that administrator is logged in
    When I go to customer section then to products
    And I search for the Product with the ID as "ID"
    And I click the "Delete" button for the Product
    And I confirm that I want to delete the products information
    Then the product's full information should be deleted from the system
    And I should see a confirmation message that the product was deleted successfully

Scenario: Delete a product that does not exist
    Given that administrator is logged in
    When I go to customer section then to products
    And I search for non existing product with id "123"
    And I click the "delete" button for the Product
    Then the fail to delete customer because it does not exist