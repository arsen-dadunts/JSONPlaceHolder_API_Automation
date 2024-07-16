# Rest Assured API Automation Framework

## Overview

This Test Automation Framework is created using Java + TestNG + RestAssured, which used for
JSONPlaceHolder api based applications.

## Prerequisites

Ensure you have the following software installed on your system:

* IntelliJ or Eclipse
* JDK 11
* [Maven](https://maven.apache.org/download.cgi) 3.6 or higher

## Getting Started

1. Clone the repository:
    ```bash
    git clone https://github.com/arsen-dadunts/JSONPlaceHolder_API_Automation.git
    cd JSONPlaceHolder_API_Automation
    ```
2. Build the project:
    ```bash
   mvn clean install
    ```

## Usage

To run your TestNG tests, use the following Maven command:
```bash
mvn test
```

or using test

## Directory Structure

The project consists of the following files:

- src to store tests: API models, tests' data, test scenarios, utility functions and helpers
- pom.xml maven project file

```bash
JSONPlaceHolder_API_Automation
├── pom.xml
├── README.md
└── src
   ├── main
   │   ├── java
   │   │   └── com
   │   │       └── jsonplaceholder
   │   │           ├── api
   │   │           │   ├── BaseAPI.java
   │   │           │   ├── PostsAPIController.java
   │   │           │   └── UsersAPIController.java
   │   │           ├── common
   │   │           │   └── Constants.java
   │   │           ├── pojo
   │   │           │   ├── Post.java
   │   │           │   └── User.java
   │   │           └── utils
   │   │               └── Helpers.java
   │   └── resources
   │       └── config.properties
   └── test
       ├── java
       │   └── com
       │       └── jsonplaceholder
       │           └── post
       │               └── CreatePostTest.java
       └── resources
           └── testng.xml
```
