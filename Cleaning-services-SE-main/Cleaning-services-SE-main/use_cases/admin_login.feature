Feature: Admin login 
 Description: the administrator can log into the cleaning servies 
 system and also logs out.
 
 Scenario: Administrator can login 
 Given that the administrator is not logged in 
 When the userName is "Admin"
 And the passoward is "correct"
 Then the administrator login succeeds
 And the administrator is logged in 
 
 Scenario: Administrator has the wrong password
 Given that the administrator is not logged in 
 When the userName is "Admin1"
 And the passoward is "Wrong"
 Then  the administrator login fails
 And the administrator is not logged in