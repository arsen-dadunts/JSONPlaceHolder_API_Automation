# Rest Assured API Automation Framework

## Overview

This Test Automation Framework is created using Java + TestNG + RestAssured, which used for
JSONPlaceHolder api based applications.

## Prerequisites

Ensure you have the following software installed on your system:

* IntelliJ or Eclipse
* [JDK](https://www.java.com/en/download/) 1.8 or higher
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
   │   │           │   ├── Posts.java
   │   │           │   └── Users.java
   │   │           ├── common
   │   │           │   └── Constants.java
   │   │           └── utils
   │   │               └── Helpers.java
   │   └── resources
   │       └── config.properties
   └── test
       ├── java
       │   └── post
       │       └── CreatePostTest.java
       └── resources
           └── jsonSchemas
               └── createPostResponse.json
```
