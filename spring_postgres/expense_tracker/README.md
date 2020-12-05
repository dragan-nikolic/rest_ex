# Expense Tracker API

freeCodeCamp.org

## References

* [Spring Boot Java Tutorial - REST API using PosgreSQL and JWT](https://www.freecodecamp.org/news/use-spring-boot-and-java-to-create-a-rest-api-tutorial/) 1:02:44

## Prerequisites

* Java JDK 8
* Docker
* PostgreSQL

## Run the app

### Run postgres DB

* Run PostgreSQL in docker as explained in 'PostgreSQL setup'
* execute sql script in docker
  * Copy script to container's root: `docker cp expensetracker_db.sql postgresdb:/`
  * Go inside container: `docker exec -it postgresdb bash`
  * Execute SQL: `psql -U postgres --file expensetracker_db.sql`

### Run app from command line

* mvn clean install
* java -jar target/expense-tracker-api-{version}.jar

### Run from IntelliJ

* run ExpenseTrackerApiApplication

## Setup

### PostgreSQL setup

Use docker [image](https://hub.docker.com/_/postgres).

Run: `$ docker container run --name posgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres`
Check: `$ docker ps -a`
Remove: `$ docker rm container_id`

### Create Spring Boot project

* use [spring initializr](https://start.spring.io/)
  * Project: Maven
  * Language: Java
  * Packaging: Jar
  * Java: 8
  * Dependencies
    * Spring Web
    * JDBC API
    * PosgreSQL Driver
    * Spring Boot DevTools

* unzip the project and open it in IntelliJ
  * Run the app > error unable to connect to the database

* create sql script to initialize db (expensetracker_db.sql)

* add database info to the application.properties

* run the app again (from IntelliJ run ExpenseTrackerApiApplication)
  * this time we get 'Whitelabel Error Page', which means db coneection is ok :)
  
## Implementation

* POST example: registerUser

## Tools

### IntelliJ

Set project SDK to 1.8 and language level to 8.

### Postman

Use Expense Tracker API.postman_collection.json to test API.

### PostgreSQL commands

* Go into container and run open db command line as posgtres user: `docker exec -it postgresdb psql -U postgres`

#### Connect to expensetrackerdb

`\connect expensetrackerdb;`

#### Execute SQL

* Select all users: `select * from et_users;`
* Delete all users: `delete from et_users;`

## Issues

### JWT signWith generates DatatypeConverter exception

Solution: Use java 8 instead of Java 11.

[Stackoverflow question](https://stackoverflow.com/questions/62660131/jwt-token-datatypeconverter-parsebase64binary-nullpointerexception-on-signwith)
