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
  * Run the app > error unable to connect to the database

* create sql script to initialize db (expensetracker_db.sql)

* execute sql script in docker
  * Copy script to container's root: `docker cp expensetracker_db.sql postgresdb:/`
  * Go inside container: `docker exec -it postgresdb bash`
  * Execute SQL: `psql -U postgres --file expensetracker_db.sql`

* add database info to the application.properties

* run the app again
  * this time we get 'Whitelabel Error Page', which means db coneection is ok :)
  