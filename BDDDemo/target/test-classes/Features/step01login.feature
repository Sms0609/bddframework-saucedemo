Feature: Login page of saucedemo web application
Scenario: Validate successful login using valid credentials
Given User is on login page
When User enters valid username and password
And Click on Login button
Then User is navigated to products page