Feature: Customer 
Background:
    Given user launch chrome brouser 
	When user navigate to url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And user enter email "admin@yourstore.com" and password "admin" 
	And click on login button 
	Then user can see the dashboard and click on csutomer menu 
@regression
Scenario: Add new customer 
	When click on add customer button 
	Then user can view add cutomer page and enter the details 
	And click on save button 
	Then user can see the confirmation message "The new customer has been added successfully" 
	And close browser 
	
@sanity	
Scenario: Search Customer by Email 
	When Enter customer email "james_pan@nopCommerce.com" 
	And Click on search button 
	Then User should found "james_pan@nopCommerce.com" in the Search table 
	And close browser 