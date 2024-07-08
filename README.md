# Backend for Parcel Management and Real-Time Tracking Application
This backend of the parcel management and real-time tracking application was developed during my end-of-study internship at Bee Coders. Built with Spring Boot, Java, and MySQL, it handles business logic, data persistence, and provides REST APIs for the frontend developed with Angular.

# Prerequisites
Java 11 or higher,
Maven,
MySQL Server
# Installation and Configuration
Clone the Repository
git clone https://github.com/mokhtar85/Application-web-de-gestion-et-de-suivi-de-colis-de-transport-partie-back.git
cd Application-web-de-gestion-et-de-suivi-de-colis-de-transport-partie-back
# Configure the Database
Create a MySQL database named colis_db and add the connection details in the src/main/resources/application.properties file:

# properties
spring.datasource.url=jdbc:mysql://localhost:3306/colis_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
# Install Dependencies
Use Maven to install the dependencies:
mvn clean install
# Running the Application
# To start the application, use the following command:
mvn spring-boot:run
The application will be available at http://localhost:8080/.

# API Documentation
The REST API documentation can be accessed at http://localhost:8080/swagger-ui.html after starting the application.

# Running Tests
To run the unit tests, use:
 mvn test
Further Help
# For more help on Spring Boot, refer to the Spring Boot Reference Guide.
