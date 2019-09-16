# CanalPlus-test-automation

CanalPlus-test-automation is a [Spring Boot](http://projects.spring.io/spring-boot/) application. Made to implement the cucumber scenario of a specific use case at Canal +.

## Features
-   **Spring Boot**: Designed to simplify the bootstrapping and development of a new **Spring** application.
-   **REST API**: CanalPlus-test-automation can be operated with its RESTful API for maximum flexibility.
-  **Hibernate Search**: Add efficient free text search capabilities to CanalPlus-test-automation.
- **Cucumber**: Test framework for « **B**ehavior **D**riven **D**evelopment ».
- **TestNG**: is an automation testing framework.
-  **JaCoCo**: Java Code Coverage Library used to generate a code coverage report.

## Prerequisites


For building and running the application you need:

-   [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
-   [Maven 3.x](https://maven.apache.org/)
##  Installation
###  Build project with Maven
```
$ mvn clean install
```
### Running
```
$ java -jar target/canalplus-test-automation.jar
```

## Installation with Docker
you should create image for CanalPlus-test-automation using this command line: 
```
docker build -f DockerFile -t testautomation . 
```
and to run the image in the container, we should reun this command:
```
docker run -d testautomation  -p 9899:9899
```

###  Author
Rayene BESSROUR