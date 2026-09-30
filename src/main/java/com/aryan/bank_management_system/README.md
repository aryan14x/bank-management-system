# Bank Management System

A backend-based Bank Management System developed using Java, Spring Boot, Spring Data JPA and MySQL.

## Features

- Customer Management
- Account Management
- Customer-Account Relationship
- Deposit Transaction
- Withdraw Transaction
- Transaction History
- Balance Management
- Input Validation
- Exception Handling
- Duplicate Account Number Check
- REST APIs

## Technologies Used

- Java 21
- Spring Boot 4.0.8
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Postman

## Project Structure

- Customer
- Account
- Transaction
- Repository
- Service
- Controller
- Exception Handling

## API Endpoints

### Customer APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/customers` | Create Customer |
| GET | `/customers` | Get All Customers |
| GET | `/customers/{id}` | Get Customer By ID |
| PUT | `/customers/{id}` | Update Customer |
| GET | `/customers/{id}/accounts` | Get Customer Accounts |

### Account APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/accounts?customerId={id}` | Create Account |
| GET | `/accounts` | Get All Accounts |
| GET | `/accounts/{id}` | Get Account By ID |
| PUT | `/accounts/{id}` | Update Account |
| GET | `/accounts/{id}/transactions` | Get Account Transactions |

### Transaction APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/transactions?accountId={id}` | Create Transaction |
| GET | `/transactions` | Get All Transactions |
| GET | `/transactions/{id}` | Get Transaction By ID |

## Transaction Types

The system supports:

- DEPOSIT
- WITHDRAW

### Deposit

When a deposit is made, the transaction amount is added to the account balance.

### Withdraw

When a withdrawal is made, the transaction amount is deducted from the account balance.

The system also checks whether sufficient balance is available.

## Validation

The project validates:

- Customer name
- Email
- Phone number
- Address
- Account number
- Account type
- Account balance
- Transaction type
- Transaction amount

## Exception Handling

The project handles:

- Validation errors
- Customer not found
- Account not found
- Transaction not found
- Duplicate account number
- Invalid transaction type
- Insufficient balance

## Database

Database used:

`bank_management_system`

MySQL is used for storing customer, account and transaction data.

## How to Run

1. Clone the project.
2. Open the project in VS Code or IntelliJ IDEA.
3. Create a MySQL database named:

```sql
CREATE DATABASE bank_management_system;