Feature: UPS Login
This feature is for UPS login with right credentials

Background:
Given I navigated to UPS login page

Scenario:  User should be able to login using correct username and password
When I input username "b.billah92" and password "Talentech123" 
And I click the submit button
Then I should be able to login