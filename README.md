# myRetail RESTful service

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps.

## Description

This is a Proof Of Concept (PoC) for products API that aggregates product data from multiple sources and returns it as JSON to the consumer.

## Application Flow Design

![Alt text](myretail_seq_diagram.jpg?raw=true "myRetail Sequence Diagram")

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

## Installing and Running mongoDB

  ### With HomeBrew

  ```
  Open the Terminal app and type brew update.
  After updating Homebrew brew install mongodb
  After downloading Mongo, create the “db” directory. This is where the Mongo data files will live. 
  You can create the directory in the default location by running mkdir -p /data/db
  Make sure that the /data/db directory has the right permissions by running

  > sudo chown -R `id -un` /data/db
  > # Enter your password

  Run the Mongo daemon, in one of your terminal windows run mongod. This should start the Mongo server.
  Run the Mongo shell, type mongo in another terminal window, to access data in MongoDB.
  To exit the Mongo shell run quit()
  To stop the Mongo daemon hit ctrl-c
  ```
## Running the application

```
java -jar target/myretail-0.0.1-SNAPSHOT.jar com.target.myretail.service.myRetailApplication
```
OR from the project root
```
mvn spring-boot:run
```
 
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
