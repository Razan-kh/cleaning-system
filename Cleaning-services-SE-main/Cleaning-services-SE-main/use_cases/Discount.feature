Feature:Discount
Scenario:creating a discount
Given the total amount of money is greater than or equal 400 NIS
Then the customer get 0.1 discount 
And the total amount of money equal 90% of the original amount
 