#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Number Result Page

Scenario: See a random number between 0 to 99
Given User opens the croove website
When he clicks on see a number link
Then he should be redirected to the number result page
And he should see a random number between 0 to 99
And the driver is closed

Scenario: See another number
Given User opens the croove website
When he clicks on see a number link
And he clicks on another number link
And the driver is closed

Scenario: Check Back to Main page
Given User is on Result Page
When he clicks back to main link
Then he should see HomePage "Welcome to Croove!"
And the driver is closed