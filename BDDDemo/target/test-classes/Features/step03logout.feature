Feature: Logout after shopping
Scenario: Successful logout
    Given User has an item in the cart
    When User opens the menu
    And Clicks the logout button
    Then User should be redirected to login page
