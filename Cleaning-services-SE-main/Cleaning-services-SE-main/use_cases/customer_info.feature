Feature: Record Full Information for Customer
   admin can be able to record full information for a customer
  So that I can provide better customer service
  Scenario: Record full information for a new customer
    Given that administrator is logged in
    When I go to customer section 
    And I enter the customer's first name as "Nour"
    And I enter the customer's last name as "Kawni"
    And I enter the customer's email address as "nour.mkawni@gmail.com"
    And I enter the customer's phone number as "0595080919"
    And I enter the customer's mailing address as "Nablus"
    Then I click the add button for the customer
    And the customer's full information should be saved in the system
    And I should see a confirmation message that the customer was added successfully
 
  Scenario: Record full information for a customer that already exist 
    Given that administrator is logged in
    When I go to customer section 
    And I enter the customer's first name as "Nour"
    And I enter the customer's last name as "Kawni"
    And I enter the customer's email address as "nour.mkawni@gmail.com"
    And I enter the customer's phone number as "0595080919"
    And I enter the customer's mailing address as "Nablus"
    Then I click the add button for the customer
    And customer will not be added again to the system
    And I should see a message that the customer already exist
 
  Scenario: Edit full information for an existing customer
    Given that administrator is logged in
    When I go to customer section 
    And I search for the customer with the email address "nour.mkawni@gmail.com"
    And I click the "Edit" button for the customer
    And I update the customer's first name to "Razan"
    And I update the customer's last name to "Khammash"
    And I update the customer's phone number to "0598646381"
    And I update the customer's mailing address to "Nabluss"
    Then the customer's full information should be updated in the system
    And I should see a confirmation message that the customer was updated successfully

 Scenario: Edit full information for a non existing customer
    Given that administrator is logged in
    When I go to customer section 
      And I search for non existing customer with the email address "nour.kawni@gmail.com"
    And I click the "Edit" button for the customer
    Then the fail to update customer because it does not exist 

  Scenario: Delete a customer's information from the system
    Given that administrator is logged in
    When I go to customer section 
    And I search for the customer with the email address "nour.mkawni@gmail.com"
    And I click the "Delete" button for the customer
    And I confirm that I want to delete the customer's information
    Then the customer's full information should be deleted from the system
    And I should see a confirmation message that the customer was deleted successfully

  Scenario: Delete a customer that does not exist
    Given that administrator is logged in
    When I go to customer section 
    And I search for non existing customer with the email address "nour.kawni@gmail.com"
    And I click the "delete" button for the customer
    Then the fail to delete customer because it does not exist
    
    Scenario: print customer's information
    Given the system has a customer
    When the Admin wants to print the customer informations
    Then the informations are printed