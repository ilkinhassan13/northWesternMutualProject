NorthWestern Mutual Project (UI, API, Performance)

This Project for technical task from NM 
Built with Maven 
Language - Java
UI Automation - Selenium
API Automation - RESTAssured
Libraries used - JUnit, Cucumber,TestNG, Jackson

Project Structure:
northWesternMutual:
src:
    test:
         java:
              apiTesting
              models
              pageObjectClasses
              performanceTesting
              runnerPackage
              stepDefinition
              utilities
         resources:
                   features
 configuration.properties
 pom.xml
                  
Project RUN : 
In Order to run the UI tests use Runner.class under runners package
In Order to run the API testing you have to run every Class from apiTesting package
In Order to run the Performance testing you have to run Performance.class under performanceTesting package

Utilities:
Config - retrieve configuration data from configuration.properties
Driver - to create browser instances 
Hooks - to set up environment and prerequisites for cucumber runs

UI:
You trigger UI tests from Runner class
For Headless run : You have to go to configuration.properties. UNcomment browser=headlessChrome and comment browser=Chrome
UI suite tests login functionality, adding , removing from shopping cart, sorting items, credentional input, checkout scenario,
end price calculation
I used Page Object Model to store Page webelements in separate classes
Test scenarios and test data are stored in the Cucumber Feature Files

API Testing:
You trigger API tests from separate class with corresponding class name under the apiTesting
RequestBody.class - It is a POJO Class for Custom request body creation
Each test hits required endpoint and then Asserting response data to the expected result
I used for assertion Hamcrest and JUnit libraries


Performance testing:
You run Performance tests from PerformanceTesting class
According to the task requirements i am checking if the test runs under 15 seconds
After each call i pause the execution for 3 seconds
Used : RESTAssured, Jackson, JUnit libraries






