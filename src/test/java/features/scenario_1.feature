Feature: Login

@regression @sanity
Scenario: successfull login with valid credentials
Given user launch chrome brouser
When user navigate to url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email "admin@yourstore.com" and password "admin"
And click on login button
Then page title should be "Dashboard / nopCommerce administration"
When user click on logout button 
Then page title should be "Your store. Login"
And close browser
@sanity
Scenario Outline: successfull login with valid credentials
Given user launch chrome brouser
When user navigate to url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email "<email>" and password "<password>"
And click on login button
Then page title should be "Dashboard / nopCommerce administration"
When user click on logout button 
Then page title should be "Your store. Login"
And close browser

Examples: 
|email|password|
|admin@yourstore.com|admin|