Feature: Add to cart functionality
Scenario: Successful adding of an item to cart
Given User is on the products page and selects an item
When User clicks on Add to cart button
Then The item should appear in the cart and should contain correct item
And User navigates back to products page