# Spring Boot REST Validation with Oracle DB

This is a Spring Boot project demonstrating input validation using DTOs (`@Valid`), custom exception handling (`@RestControllerAdvice`), and CRUD APIs using Spring Web, JPA, and Validation. It connects to an **Oracle database** using the `ojdbc11` driver.

---

## 🚀 Features

- Customer registration with strict input validation (`@Email`, `@NotBlank`, `@Min`, `@Max`, etc.)
- Centralized exception handling using `@RestControllerAdvice`
- API to get all customers
- API to fetch a customer by ID
- Optional: Delete customer by ID
- Oracle DB integration via JDBC
- Clean separation of DTO, Entity, Service, Repository layers

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- Hibernate Validator (JSR 380)
- Oracle Database (via `ojdbc11`)
- Maven

---

## ⚙️ Setup Instructions

### 1. Clone the repository

    ```bash
    git clone https://github.com/Hari612k/SpringRestValidation.git
    cd SpringRestValidation

2. Update Oracle DB Configuration

In src/main/resources/application.properties, configure:

  spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
  spring.datasource.username=your_oracle_username
  spring.datasource.password=your_oracle_password
  spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

Replace the url, username, and password with your local Oracle DB config.



📦 Project Structure

      src/
      ├── main/
      │   ├── java/
      │   │   └── com.hari.springprojects/
      │   │       ├── controller/
      │   │       ├── dto/
      │   │       ├── entity/
      │   │       ├── repository/
      │   │       ├── service/
      │   │       ├── advise/
      │   │       └── exception/
      │   └── resources/
      │       └── application.properties


📮 REST API Endpoints

    | Method | Endpoint                | Description                      |
    | ------ | ----------------------- | -------------------------------- |
    | POST   | `/customer/signup`      | Register a customer              |
    | GET    | `/customer/fetchAll`    | Get all customers                |
    | GET    | `/customer/fetch/{id}`  | Get customer by ID               |
    | DELETE | `/customer/delete/{id}` | Delete customer by ID (optional) |


🧪 Sample POST Request: /customer/signup

        {
          "name": "Hari",
          "email": "hari@example.com",
          "gender": "Male",
          "age": 24,
          "nationality": "India"
        }


❌ Sample Validation Error Response

        {
          "email": "Please provide a valid email",
          "age": "Age must be at most 60",
          "nationality": "Nationality should not be blank"
        }


🧪 Testing with Postman

    Send valid/invalid requests to see how @Valid DTO validation works.

    Invalid inputs will result in 400 Bad Request with detailed messages.

    If customer is not found, you'll get 404 Not Found.



👨‍🔧 Developer Notes

    Make sure Oracle is running and accessible on the configured port.

    Use the ojdbc11 jar available in Maven Central.

    If needed, you can switch to H2 for local testing.
