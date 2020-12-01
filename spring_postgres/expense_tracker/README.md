# Expense Tracker API

freeCodeCamp.org

## References

* [Spring Boot Java Tutorial - REST API using PosgreSQL and JWT](https://www.freecodecamp.org/news/use-spring-boot-and-java-to-create-a-rest-api-tutorial/)

## Setup

* Java JDK 8
* IntelliJ IDE
* Postman
* Docker
* PostgreSQL

### PostgreSQL

Use docker [image](https://hub.docker.com/_/postgres).

Run: `$ docker container run --name posgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres`
Check: `$ docker ps -a`
Remove: `$ docker rm container_id`

### Create Spring Boot project

* use [spring initializr](https://start.spring.io/)
  * Project: Maven
  * Language: Java
  * Packaging: Jar
  * Java: 11
  * Dependencies
    * Spring Web
    * JDBC API
    * PosgreSQL Driver
    * Spring Boot DevTools

* unzip the project and open it in IntelliJ
