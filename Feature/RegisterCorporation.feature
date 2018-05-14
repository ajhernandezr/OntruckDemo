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
@OnTruckAltaEmpresas 
Feature: Get to Create corporation account 


Scenario Outline: Register new corporation 
	Given I am on "https://ontruck.com/es/" with "<browser>"
	When I navigate to business page 
	And proceed to Crear cuenta para empresa section 
	Then I get the create account form 
	And  fill the form with the following "<name>" and "<email>" and "<phone>" 
	
	Examples: 
		| browser | name  | email 	 | phone |
		| chrome |  Empresa Envios | Test@153 | 123456 |
		| chrome | 	 Empresa Furgonetas | Test@153 | 123456 |
		| Firefox | Empresa Camiones | Test@153 | 123456 |
