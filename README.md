# QA - Assessment Exercise: 2

This project is a Java-based automated testing framework that utilizes Maven for build management and Cucumber for behavior-driven development (BDD) testing.
It is shown testing of a REST API and of the same GraphQL API using Java and Rest-Assured.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Extra Scenarios To Test](#extra-scenarios-to-test)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or higher
- Maven 3.6.0 or higher
- An IDE like IntelliJ IDEA or Eclipse

## Installation

1. **Clone the repository**:

    ```bash
    git clone 'git-repository'
    cd qa_test_assessment_ui
    ```

2. **Install dependencies**:

    ```bash
    mvn clean install
    ```

## Running Tests

You can run the tests using Maven. Here are a few commands to help you get started:

1. **Run all tests**:

    ```bash
    mvn test
    ```

2. **Run tests with a specific Cucumber tag**:

    ```bash
    mvn test -Dcucumber.options="--tags @yourTag"
    ```

3. **Generate Cucumber reports**:

   After running tests, you can generate reports using:

    ```bash
    mvn verify
    ```

## Project Structure

The project follows a standard Maven structure:

```
qa_test_assessment
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── features
│       │   ├── stepDefinitions
│       │   ├── testRunners
│       │   └──utilities
│       └── resources
│           ├── data
│           └── reports
├── target
├── .gitignore
├── pom.xml
└── README.md
```

- **src/main/java**: Contains the main application code.
- **src/test/java**: Contains the test runners, step definitions, and feature files.

## Configuration

### Cucumber Options

Cucumber options such as report formats, tags, and glue paths can be configured in the `TestRunner.java` file.

## Notes

- Request and response can be filtered to exclude null or none values as needed. I have set Firefox as the default browser for running tests. However, it is possible to implement more dynamic methods for selecting the browser, allowing for greater flexibility in executing the tests.
- The REST API response schema can be validated if necessary.
- The report can be generated with a dynamic name for better organization and traceability.
- Logs should be managed efficiently to ensure clear and effective debugging and monitoring.


## Extra Scenarios To Test

```
positive:
validate standard request -> 200 ok
all valid query params -> 200 ok
boundaries values -> 200 ok 1 and last
combinations -> 200 ok /1,2 -> 2 characters in the results

REST negative:
invalid endpoint -> endpoint with another method 404
invalid params -> 404 ?page=43 max 42 or /827 max 826 characters or /1,900 got just character 1
server error -> 500 using unexpected values /helloworld or /1&
missing query params when mandatory -> 400 bad request
missing or invalid auth or invalid header -> 401 Unauthorized
insufficient permission -> 403 Forbidden status

GraphQL negative:
invalid params value or inexistent field -> 400 name: 1, extraField: "hi" 
invalid url -> 404 /graphqls
invalid query format -> 400 ex: query without last }
missing query params when mandatory -> 400 bad request
missing or invalid auth or invalid header -> 401 Unauthorized
insufficient permission -> 403 Forbidden status
```
