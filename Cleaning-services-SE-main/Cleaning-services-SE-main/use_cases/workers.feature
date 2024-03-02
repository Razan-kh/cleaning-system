Feature: Distribute Orders to Available Workers

    Scenario: Distribute Orders among available workers
    Given there are available workers
    And a there is a new order to the system 
    When the order is assigned to the available worker 
    Then each order should have a worker 
    
    Scenario: Worker finished product 
    Given there are available workers
     And a there is a new order to the system
    And a ready to work on new order 
    When the order is removed from system  
    Then number of orders to the worker should be decreased 
 And a ready to work on new order 
    When the order is removed from system  
    Then number of orders to the worker should be decreased 