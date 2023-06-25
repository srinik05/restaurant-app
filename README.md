# Restaurant Reservation Table Booking App

The Restaurant Reservation Table Booking App is a Java-based web application built with Spring Boot and MongoDB. It allows users to make table reservations for a restaurant.

## Features

- Create a table reservation with the following details:
    - Reservation date
    - Number of guests
    - Time slot
    - Customer name
    - Email
    - Mobile number
- View the details of a single reservation.
- View the details of all reservations.
- Update an existing reservation.
- Delete a reservation.

## Technologies Used

- Java 8
- Spring Boot
- Spring Data MongoDB
- Docker
- Maven

## Getting Started

These instructions will help you set up and run the Restaurant Reservation Table Booking App on your local machine for development and testing purposes.

### Prerequisites

- Java 8 JDK or later
- Maven
- MongoDB (installed and running)
- IntelliJ IDEA or any preferred IDE
- Docker 

### Installation

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/srinik05/restaurant-app.git
   
##Steps: 
1. Import the project into your IDE (e.g., IntelliJ IDEA) as a Maven project.
2. Build the project using Maven:

#mvn clean install

3.Run the MongoDB service on your local machine.
4. Update the MongoDB connection details in application.properties. Specify the MongoDB host, port, and database name:

#spring.data.mongodb.host=localhost
#spring.data.mongodb.port=27017
#spring.data.mongodb.database=restaurant

5. Build the Docker image:

'docker build -t restaurant-reservation-app'

6.Run the Docker container:
'docker run -p 8080:8080 restaurant-reservation-app'

Image will create from the above step and we can ready to deploy into 'cloud'

#mvn spring-boot:run
The application should now be running at http://localhost:8080.

API Endpoints
The following API endpoints are available:

'POST /api/reservations' - Create a new table reservation.
'GET /api/reservations/{id}' - Get the details of a specific reservation.
'GET /api/reservations' - Get the details of all reservations.
'PUT /api/reservations/{id}' - Update an existing reservation.
'DELETE /api/reservations/{id}' - Delete a reservation.


Refer to the API documentation or Postman collection for more details on how to use these endpoints.

##Database
The application uses MongoDB as the database. Make sure you have MongoDB installed and running on your local machine. The connection details are specified in 'application.properties'. The database specified in the configuration will be automatically created when the application starts.


##Error Handling
The application implements exception handling to provide appropriate error responses. Custom exceptions have been defined to handle specific scenarios. Error responses include a code, message, and trace ID for easier debugging.

##Testing
Unit tests and integration tests have been provided to ensure the functionality of the application. You can run the tests using Maven:

'mvn test'

##Future Enhancements
Add authentication and authorization to secure the API endpoints.
Implement search and filtering functionality for reservations.
Add validation for input data to ensure consistency and correctness.
Support different time zones for reservations.
Integrate with external services for email notifications or SMS alerts.

##Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.
