Feature: Track Orders and Status
Scenario: View Order Status
  Given a customer with email "nour@gmail.com"want to track thier order 
  When I enter the product id i want to check "1234"
  Then the system displays the order status, which can be "waiting", "in treatment" or "complete"

Scenario: Update Order Status
  Given I am logged in as an Admin 
  When I select customer with email "nour@gmail.com"want to track thier order 
  And  I enter the product id i want to check "1234"
  And I change the status to "in treatment" or "complete"
  Then the system updates the order status accordingly