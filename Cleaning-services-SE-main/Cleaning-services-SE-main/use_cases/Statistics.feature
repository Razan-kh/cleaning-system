Feature: Statistics
Scenario: Creating a statistics
Given the system has customers
And the customers have products 
And the customers have invoices
When the Admin wants to generate a statistics
Then the statistics is generated includes all debts
And the statistics is generated includes all cash
And the statistics is generated includes count of customers

Scenario: return the customer lists
Given the system has customers
When the Admin wants to know the customers
Then the list of customers will be returned