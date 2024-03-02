Feature: customer can have products
Scenario:
Given customer want to add new product to clean
And customer can update info of product 
And customer can remove product 
When customer select add or update he can be able to add or ubdate product 
Scenario:
Given customer want information of all products 
And customer print product 
When customer will see information of all products  
Scenario:
Given customer want Delete all products  
When customer delete all 
Then all products must be deleted

Scenario: return the customer lists
Given: the system has customers
When: the Admin wants to know the customers
Then: the list of customers will be returned

