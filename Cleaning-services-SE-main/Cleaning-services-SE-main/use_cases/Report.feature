Feature: given Admin want a report for the system
Scenario: Generate a report about the customers 
Given admin want to make a report about customers
When enters generate report
Then a report about the customer will be generated 

Scenario: Generate a report about the products
Given admin want to make a report about products
When enters generate report
Then a report about the products will be generated 

Scenario: Generate a report about the workers
Given admin want to make a report about workers
When enters generate report
Then a report about the workers will be generated 

Scenario: Generate a report about the whole system 
Given admin want to make a report about system
When enters generate report
Then a report about the system will be generated 

