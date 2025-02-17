# Employee Management API

## 📌 Overview

This is a **Spring Boot** application that provides a **RESTful API** for managing employee data. It uses **Hibernate ORM** with **H2 Database** (or MySQL) and incorporates **Aspect-Oriented Programming (AOP)** for logging and performance monitoring.

## ⚡ Features

- Create, Read, Update, Delete (CRUD) operations for Employees
- Spring Data JPA with Hibernate ORM
- H2 in-memory database (configurable for MySQL)
- AOP-based Logging & Performance Monitoring
- Exception Handling & Transaction Management

## 🚀 Tech Stack

- **Spring Boot** (Core, Web, AOP)
- **Spring Data JPA** (Hibernate ORM)
- **H2 Database** (or MySQL)
- **Lombok** (for reducing boilerplate code)
- **Maven** (Dependency Management)
- **Spring Boot Starter AOP** (Aspect-Oriented Programming)

## 📂 Project Structure

```
com.vlink.EmployeeManagement
 ├── EmployeeManagementApplication.java  # Main Spring Boot Application
 ├── Entity
 │     ├── Employee.java                 # JPA Entity Class
 ├── Repository
 │     ├── EmployeeRepository.java       # JPA Repository Interface
 ├── Service
 │     ├── EmployeeService.java          # Business Logic Layer
 ├── Controller
 │     ├── EmployeeController.java       # REST API Endpoints
 ├── Aspect
 │     ├── LoggingAspect.java            # AOP Logging & Performance Monitoring
 ├── resources
 │     ├── application.properties        # Database Configuration
```

## 🛠️ Setup Instructions

### **1️⃣ Clone the Repository**

```sh
git clone https://github.com/your-username/employee-management-api.git
cd employee-management-api
```

### **2️⃣ Configure the Database**

#### ✅ **For H2 Database (Default, No Configuration Needed)**

The application is pre-configured with H2 in-memory database. If using H2, no changes are needed.

#### ✅ **For MySQL (Optional)**

Update `src/main/resources/application.properties`:

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### **3️⃣ Build & Run the Application**

```sh
mvn clean install
mvn spring-boot:run
```

## 📡 API Endpoints

### **Create Employee**

```http
POST /api/employees
```

**Request Body:**

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "department": "Engineering"
}
```

### **Get Employee by ID**

```http
GET /api/employees/{id}
```

### **Get All Employees**

```http
GET /api/employees
```

### **Update Employee**

```http
PUT /api/employees/{id}
```

**Request Body:**

```json
{
  "name": "John Smith",
  "email": "john.smith@example.com",
  "department": "HR"
}
```

### **Delete Employee**

```http
DELETE /api/employees/{id}
```

## 📊 AOP Logging & Performance Monitoring

The **LoggingAspect** class logs method calls and execution time. **Example Log Output:**

```
INFO  EmployeeManagement - Executing Service Method...
INFO  EmployeeManagement - Execution Time of EmployeeService.getEmployeeById: 15 ms
INFO  EmployeeManagement - Service Method Execution Completed.
```

## 📌 H2 Database Console (Optional)

If using H2, access the database UI at: 👉 [**http://localhost:8080/h2-console**](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:employee_db`
- Username: `sa`
- Password: (leave empty)
---

🔹 **Author:** Your Name\
🔹 **GitHub:** [YourUsername](https://github.com/your-username)\
🔹 **Contributions:** Feel free to submit pull requests! 🚀

