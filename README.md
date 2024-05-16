# Java / Spring Boot / Page Object Model / Cucumber / Selenium Grid / Allure

A starter project that provides the framework for building a robust QA automation pipeline using Java, Cucumber, Selenium Grid, and Allure Reporting. It's ideal for 
QA engineers or developers wanting to self-host their own automation tool chain.

Included is some example code utilises [the-internet.herokuapp.com](https://the-internet.herokuapp.com/) to showcase how to leverage the [Page Object Model (POM)](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/) pattern 
to provide a clear separation between test logic and page-specific details. While the use of [Cucumber](https://cucumber.io/) and [Gherkin](https://cucumber.io/docs/gherkin/) provide a behavior-driven development (BDD) approach to test suite 
creation. The human-readable syntax serves as a single source of truth of the application's behaviour that can be easily understood and maintained by all stakeholders.

Automation reports are produced using [Allure](https://allurereport.org/).

# Running locally

This is useful when creating Page Object Model code or working on Cucumber Feature test suites.

Start docker containers for Selenium Grid nodes (Chrome, Firefox, Edge):
```sh
docker-compose up -d
````

Run all JUnit test cases: 
```sh
make test
```

# License

This project is licensed under the terms of the [MIT License](https://github.com/stevencrawford/java-pom-selenium-allure/blob/main/LICENSE).

Copyright © 2024 [Steven Crawford](https://github.com/stevencrawford)
