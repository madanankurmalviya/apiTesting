Feature: Selenium Easy Website Testing With BDD FW (First Page)

Scenario Outline: First SeleniumEasy First Page 
	Given enter to the URL 
	When check Btn Text contains DemoWebsite 
	Then click on DemoBtn 
	When check url contains test 
	Then click on input forms 
	Then click on simple form demo 
	Then click on All Examples- Input Form 
	Then click on Simple Form Demo Second 
	Then enter Message in "<message>" of Single Input Field Tab 
	Then verify Message by clicking SHow Message Btn "<message>" 
	Then  enter value in Two Input Field "<valueA>" and "<valueB>" 
	Then click in GetTotal tab and verify Total 
	And quit the driver
	
	Examples: 
		| message    | valueA | valueB |
		| Hello World|   10   |   20   |
		| ankur malv |   10   |   100  |
		| Abcd123abc |   20   |   30   |