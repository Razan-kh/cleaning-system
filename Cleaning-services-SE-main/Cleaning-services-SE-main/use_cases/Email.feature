Feature: Email
Scenario: send  right email when the order is ready
Given the order is ready
Then the Admin sents email to the customer with email "razanmohamad262@gmail.com"
