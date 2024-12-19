# Web Automation on OrangeHRM Website with Selenium TestNG

## What is Automation?

Automation is the process of using software tools and scripts to perform tasks that would typically be done manually by a human. In the context of software testing, automation involves using tools to execute test cases and compare the actual results with the expected results automatically.

## Why we use Selenium TestNG for Automation?

Selenium is a popular open-source testing tool widely used for automating web browsers. It allows developers and testers to automate web-based applications' testing across multiple browsers and platforms. Selenium provides a set of APIs to interact with web elements and manipulate their properties and behaviors, making it an ideal tool for automating UI tests.

TestNG is a testing framework for Java that is designed to be more flexible and powerful than JUnit. It supports a wide range of testing functionalities, including unit, integration, and end-to-end testing, as well as parallel execution, data-driven testing, and reporting. TestNG is often used with Selenium to create robust and scalable test automation frameworks.

## Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Gradle
- Intellij idea
- Allure

## How to run this project

- Clone this project
- Hit the following command into the terminal:
 ```gradle clean test```
 
- For generating Allure Report use these commands:
```allure generate allure-results --clean -o allure-report``` and
```allure serve allure-results```
## Scenerio:
- Visit this url: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
- Login to this system using the below username & credential:
Username: Admin,
Password: admin123
- Then go to the Leave menu: https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave
- Write test case for apply Leave feature

## Test case check lists based on the Scenerio:

- Verify login functionality doesn't works with invalid credentials
- Verify login functionality works properly with valid credentials.
- Verify if user is redirected to the "Apply Leave" page correctly.
- Verify user cannot apply for leave with an invalid date.
- Verify that leave cannot be applied on Vacation or Off dates.
- Verify that user can successfully apply for leave for a single day.
- Verify that user can successfully apply for leave for multiple days.
- Verify that user cannot apply for the same leave request twice.
- Verify that system restricts leave applications that exceed the user’s leave balance.
- Verify that user can log out successfully. 
 

## Allure Report:



## Automation Output Video:




