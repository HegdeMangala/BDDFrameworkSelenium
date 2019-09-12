Feature: Login scenarios for AutomationPractice
Scenario: To test adding Tshirt to the cart and verify the order

Given user is on sign in page
When user enter username , password and clicks on submit
Then user adds Tshirt to the cart
Then user goes to Update profile and updates his first name
And user clicks on Log out 



