# Salary Management System

The Salary Management System is a web application built using Spring Boot as the backend framework and JPA Hibernate for data modeling. The frontend incorporates Bootstrap and jQuery to ensure a responsive and user-friendly interface. This system allows for the management of employee information, including CRUD operations and search functionality.

## Features

- Create new employee records
- Read and display employee data
- Update/Edit existing employee details
- Delete employee records
- Search for employees based on name, email, or department
- Auto-search functionality when typing in the search field
- Confirmation dialogs before editing or deleting an employee
- Default age set to 18 for new employees

## Technology Stack

- Backend Framework: Spring Boot
- Data Modeling: JPA Hibernate
- View Engine: Thymeleaf
- Frontend: Bootstrap, jQuery

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- MySQL

### Setup

1. Clone the repository:

    ```sh
    git clone https://github.com/yourusername/salary-manager.git
    cd salary-manager
    ```

2. Configure the database:

    Update the `application.properties` file with your MySQL database credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/salarymanager
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the application:

    ```sh
    ./mvnw spring-boot:run
    ```

4. Open your browser and navigate to `http://localhost:8080/employees`.

### Data Initialization

The application will automatically insert example data into the database if it is empty. This is handled by the `DataInitializer` class.

## Project Structure

- `src/main/java/com/salarymanager`
  - `controller`: Contains the `EmployeeController` class for handling HTTP requests.
  - `model`: Contains the `Employee` entity class.
  - `repository`: Contains the `EmployeeRepository` interface for database operations.
  - `service`: Contains the `EmployeeService` class for business logic.
  - `DataInitializer.java`: Initializes the database with example data if it is empty.

- `src/main/resources`
  - `templates`: Contains the Thymeleaf templates for the frontend.
    - `employees.html`: Displays the list of employees and includes search functionality.
    - `create_employee.html`: Form for creating a new employee.
    - `edit_employee.html`: Form for editing an existing employee.
  - `application.properties`: Configuration file for the Spring Boot application.

## Usage

### Creating a New Employee

1. Click the "Add Employee" button on the main page.
2. Fill out the form and click "Save".

### Editing an Employee

1. Click the "Edit" button next to the employee you want to edit.
2. Update the form and click "Update".

### Deleting an Employee

1. Click the "Delete" button next to the employee you want to delete.
2. Confirm the deletion in the popup dialog.

### Searching for Employees

1. Type a keyword in the search field on the main page.
2. The list of employees will be filtered automatically as you type.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.