# accionlabstest
Test URL : https://www.saucedemo.com/
## Test cases
1.	Login to the application with username and password
2.	On home page select the product dropdown ‘Price High to Low’
## Framework design
1.	Created maven project
2.	Created base and utility functions 
3.	Organized page objects
4.	Created the above 2 tests
5.	TestNG framework
6.	Log4j for logging inside the framework
7.	Extend HTML report for test results

## Run the code:
Run the TestNG.xml file
Or
Maven command 
Example for chrome browser : mvn test -Dbrowser=chrome	

## Code explanation
1.	Under main folder -> resources
•	data.properties file -> For initializing  Browser and URL 
•	Base.java -> Initializing web driver, writing block of code for browser specific execution, Initializing screenshot functionality for TestNg listeners
•	ExtendReporterNG.java -> for Html reports
•	Log4j2.xml -> For printing the logs
2.	Under main folder -> pageobjects
•	Page object files for the two test cases (Login and Dropdown selection)
3.	Under test folder -> testcases
•	Loginpage -> test case for logging in to application using TestNG dataprovider
•	ProductDropdown -> test case to select dropdown and one from the list
•	Listeners -> TestNG listeners implementation. But have not integrated with the current test.
4.	POM.xml -> To add builds, plugins, dependencies etc.
5.	Testng.xml -> To define the test suites and test cases



