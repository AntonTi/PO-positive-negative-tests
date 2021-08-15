# QA automation training project ITEA

Web UI automation tests with Selenium WebDriver Framework
___
### REQUIREMENTS:
- JDK (1.8 or higher);
- apache maven (3.6.3 or higher);
- ChromeDriver (latest version);
- Allure (for test report);
- Jenkins (for CI/CD);
- IntelliJ IDEA (IDE).
___
### INSTALLATION:
- download ChromeDriver (latest stable release):
<https://chromedriver.chromium.org>

- add the folder where the ChromeDriver is located to system variables

- **MAKE SURE** you have the latest version of Chrome browser installed
___
### RUN:
On command line (terminal), type in the following command:
`mvn clean test`
---
### ALLURE REPORT:
On command line (terminal), type in the following command:
`allure serve allure-results`