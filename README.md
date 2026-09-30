# 🏦 Bank Management System

A backend REST API project developed using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project provides APIs for managing customers, bank accounts, and transactions such as deposits and withdrawals. It also includes validation and global exception handling.

## 🚀 Features

* Customer Management
* Bank Account Management
* Account-Customer Relationship
* Deposit Transactions
* Withdrawal Transactions
* Account Balance Management
* Transaction History
* Input Validation
* Global Exception Handling
* RESTful APIs
* MySQL Database Integration

## 🛠️ Technologies Used

* Java 21
* Spring Boot 4.0.8
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Postman
* Git & GitHub

## 📂 Project Structure

```text
src/main/java/com/aryan/bank_management_system
│
├── account
│   ├── controller
│   ├── entity
│   ├── repository
│   ├── service
│   └── transaction
│       ├── controller
│       ├── entity
│       ├── repository
│       └── service
│
├── controller
├── entity
├── exception
├── repository
├── service
│
└── BankManagementSystemApplication.java
```

## 🔗 API Endpoints

### 👤 Customer APIs

| Method | Endpoint                   | Description           |
| ------ | -------------------------- | --------------------- |
| POST   | `/customers`               | Create Customer       |
| GET    | `/customers`               | Get All Customers     |
| GET    | `/customers/{id}`          | Get Customer by ID    |
| PUT    | `/customers/{id}`          | Update Customer       |
| GET    | `/customers/{id}/accounts` | Get Customer Accounts |

### 🏦 Account APIs

| Method | Endpoint                      | Description              |
| ------ | ----------------------------- | ------------------------ |
| POST   | `/accounts?customerId=1`      | Create Account           |
| GET    | `/accounts`                   | Get All Accounts         |
| GET    | `/accounts/{id}`              | Get Account by ID        |
| PUT    | `/accounts/{id}`              | Update Account           |
| GET    | `/accounts/{id}/transactions` | Get Account Transactions |

### 💰 Transaction APIs

| Method | Endpoint                      | Description                     |
| ------ | ----------------------------- | ------------------------------- |
| POST   | `/transactions?accountId=1`   | Create Transaction              |
| GET    | `/transactions`               | Get All Transactions            |
| GET    | `/transactions/{id}`          | Get Transaction by ID           |
| GET    | `/accounts/{id}/transactions` | Get Account Transaction History |

## 💳 Transaction Types

The system supports two transaction types:

* `DEPOSIT` — Adds money to the account balance.
* `WITHDRAW` — Deducts money from the account balance.

Withdrawal is not allowed when the requested amount is greater than the available balance.

## ✅ Validation

The project includes validation for:

* Customer name
* Email
* Phone number
* Address
* Account number
* Account type
* Account balance
* Transaction type
* Transaction amount

Example validation:

```text
Phone must be 10 digits
Amount must be greater than 0
Transaction type must be DEPOSIT or WITHDRAW
Insufficient balance
```

## ⚠️ Exception Handling

Global exception handling is implemented using:

* `@RestControllerAdvice`
* `@ExceptionHandler`
* Custom `ResourceNotFoundException`

This provides clear error responses for validation errors and missing resources.

## 🗄️ Database

Database: **MySQL**

Database name:

```text
bank_management_system
```

Database credentials are configured using environment variables and are **not stored directly in the source code**.

Example:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/aryan14x/bank-management-system.git
```

### 2. Open the Project

Open the project in **VS Code** or **IntelliJ IDEA**.

### 3. Configure Database Environment Variables

Set the following environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

Example:

```text
DB_URL=jdbc:mysql://localhost:3306/bank_management_system
DB_USERNAME=root
DB_PASSWORD=your_password
```

### 4. Run the Application

Using Maven Wrapper:

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

Or run:

```text
BankManagementSystemApplication.java
```

from your IDE.

### 5. Server

The application runs on:

```text
http://localhost:8080
```

## 🧪 API Testing

APIs can be tested using **Postman**.

Example:

```text
POST http://localhost:8080/customers
```

```json
{
    "name": "Amit Kumar",
    "email": "amit@gmail.com",
    "phone": "9876543210",
    "address": "Raipur"
}
```

## 🎯 Project Purpose

This project was developed to understand and implement real-world backend development concepts including:

* REST API development
* Spring Boot
* JPA & Hibernate
* MySQL database integration
* Entity relationships
* CRUD operations
* Validation
* Exception handling
* Backend business logic

## 👨‍💻 Author

**Aryan Bhardwaj**

B.Tech CSE | Java Backend Developer

### Skills

```text
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
REST API
HTML
CSS
JavaScript
Git & GitHub
```

## 📌 GitHub Repository

[Bank Management System](https://github.com/aryan14x/bank-management-system)

---

⭐ If you find this project useful, feel free to explore the repository.
