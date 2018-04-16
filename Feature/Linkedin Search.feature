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
@LinkedinSearch
Feature: Linkedin Search	

  @First
  Scenario Outline: Linkedin Search	
    Given user is on "https://www.google.es/" url with "<browser>"
    When searching for "javier-hernandez-44374026 "
    And pressing search button with "javier-hernandez-44374026"
    Then page opened should be "https://es.linkedin.com"
    And the name should be "Javier Hernandez"
    And the current job should be "Qa Automation Engineer"
 Examples: 
      | browser | 
      | chrome | 
      | Firefox | 
	
      

