# myRetail RESTful service

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.

## Description

This is a Proof Of Concept (PoC) for products API that aggregates product data from multiple sources and returns it as JSON to the consumer.

## API URL structure
```
GET Products - /products/prices

GET Product Name - products/{id}/name

GET Product Price - products/{id}/price

GET Product Details - /products/{id}

PUT Product Price - /products/{id}/price

GET All Product Prices - /products/prices
```

### Examples
```
GET Product Name - localhost:8080/products/13860428/name

GET Product Details - localhost:8080/products/13860428

GET Product Price - localhost:8080/products/13860428/price

```

### Development Environment

* IDE - IDEA Intellij
* Version Control - Git
* Dependency Management - Maven 3.3.9
* Database - MongoDb NoSql
* RESTful Application framework - Spring Boot
* Programming language - Java 1.8
* Unit Testing library - JUnit, Mockito
* API Integration Testing - PostMan
* Operating System - MacOS Mojave

## Running the application

java -jar target/myretail-0.0.1-SNAPSHOT.jar com.target.myretail.service.myRetailApplication

OR from the project root

mvn spring-boot:run

## Testing

Unit tests
1) com.target.myretail.service.ProductServiceImplTest.java
2) com.target.myretail.utils.JsonUtilsTest.java

End to end testing
PostMan Collection Link
https://www.getpostman.com/collections/5195682166181eb98108

## Authors

* **Devyani Sharma**
[GitHub](https://github.com/devyani22)
