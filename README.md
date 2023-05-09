# Book Club Pro

Book Club Pro is a web application built with Spring Boot and Java 20, which connects to a SQL Server database. The application is designed to manage books and their associated information.

## Prerequisites

Before running this application, please ensure that the following software is installed on your machine:

- Java JDK 20
- SQL Server database
- Visual Studio Code

## Setup

1. Clone this repository to your local machine using the following command:

```
git clone https://github.com/Ahm4dA/book-club-pro.git
```

2. Open the cloned repository in Visual Studio Code

3. Open the `application.properties` file located in `src/main/resources` and update the database connection properties to match your local database configuration:

```
spring.datasource.url=jdbc:sqlserver://localhost:1433/bookclubprodb
spring.datasource.username=<your-database-username>
spring.datasource.password=<your-database-password>
```

4. Ensure the following directories exist on your machine to ensure proper functionality:

   - `C:/programming files/books`
   - `C:/programming files/bookimages`

   You can create these directories manually or modify the paths in the application code to match your desired directory structure.

5. Run the database scripts located in the `code/database scripts` folder to create the necessary database tables and seed data.

6. Run the application by executing the `main` method in the `BookclubproApplication` class.

## Usage

Once the application is running, you can access it at `http://localhost:8080` in your web browser. From there, you can manage the books in your database by adding, updating, and deleting them.

## Contributing

If you would like to contribute to this project, please open a pull request with your changes. We welcome any and all contributions!
