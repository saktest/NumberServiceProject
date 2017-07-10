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
Feature: NumberService HomePage
	I want to see HomePage with specific details

Scenario: User see the HomePage with Info and number result page link
Given User opens the croove website
Then he should see HomePage "Welcome to Croove!"
And he should see page title "Croove - QA Engineer"
And he should see Info link
And he should see a link to number result page
And the driver is closed

Scenario: Check Info Link
Given User opens the croove website
When he click Info link
Then he should see a modal dialog wndow
And he should see challenge instructions headline "challenge instructions"
And he should see list of steps
And he should see a link back to home page
And the driver is closed

Scenario: Check Back to Main link on Info pop-up
Given User opens the croove website
When he click Info link
And  he click Back to Main link
Then he should see HomePage "Welcome to Croove!"
And the driver is closed
    
    
