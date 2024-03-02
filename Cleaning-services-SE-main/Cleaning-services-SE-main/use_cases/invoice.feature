Feature: invoices
Scenario: creating invoice
Given the customer has a products
And the customer email is "email"
And the product length is 1.0
And the product Width is 1.0
And the product Category is "carpet"
And the special treatment is "no"
When he wants to cheackout
Then an invoice with requiered information is generated
Then the invoice is added to the list of customer's invoices

Scenario: creating invoice
Given the customer has a products
And the customer email is "email"
And the product length is 1.0
And the product Width is 1.0
And the product Category is "carpet"
And the special treatment is "no"
When he wants to cheackout but the email is wrong
Then nothing will be generated



Scenario: creating invoice for selected product
Given the customer has a products
And the customer email is "email"
And the product id is "1"
And the product length is 1.0
And the product Width is 1.0
And the product Category is "carpet"
And the special treatment is "no"
When he enters the ID of the product as "1"
And he wants to cheackout
Then the invoice is added to the list of customer's invoices 

Scenario: return the discount
Given if the discount percent is 0.1
When the user wants the discount percent
Then the returned value equals the discount percent

Scenario: Print invoice
Given the customer have invoice
When the customer wants to print it

Scenario: check if the invoice is paid or not
Given the invoice is paid
When the user wants to check wether it's paid or not
Then the function returns "true"

Scenario: pay invoice
Given the customer have invoice
And he wants to pay an invoice 
Then the invoice paying is done




# Scenario: creating invoice
#Given the customer has a products
#When he wants to cheackout
#Then an invoice with requiered information is generated
#Then the invoice is added to the list of customer's invoices

#Scenario:creating invoice for selected product
#Given the customer has a products
#When he enters the ID of the product as "<ID>"
#And he wants to cheackout
#Then an invoice with requiered information is generated
#And the invoice is added to the list of customer's invoices 

