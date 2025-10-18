# Hospital Management System

## Project Description
This is a **Hospital Management System** built using **Java** and **Spring Boot**.  
It manages all hospital operations including patients, doctors, employees, appointments, payments, rooms, and prescriptions.  

This project follows a **layered architecture** with separate layers for:  
- **Controller** – handles HTTP requests  
- **Service** – business logic  
- **Repository (DAO)** – database interactions  
- **DTO** – data transfer objects  
- **Exception Handling** – custom exceptions  

---

## Technologies Used
- **Java 11+**  
- **Spring Boot**  
- **Spring Data JPA**  
- **MySQL / H2 Database**  
- **Maven** for build management  
- **REST API** design  

---

## Features
- CRUD operations for Patients, Doctors, Employees, Hospitals, and Branches  
- Payment and Prescription management  
- Exception handling for invalid data or missing IDs  
- Structured and maintainable layered architecture  
- Easily extendable for future enhancements  

---

## Project Structure
hospital-management-system
│
└───src
└───main
└───java
└───com.project.hospital_management_system
├── controller
├── service
├── repo
├── dto
└── exception
└───resources
└───application.properties

## How to Run
1. Clone the repository:  
```bash
git clone https://github.com/Rakesh-Putti/hospital-management-system.git
Open the project in Eclipse or IntelliJ IDEA

Configure your database in application.properties

Run the main application class:

HospitalManagementSystemApplication.java
Access the APIs via Postman or any REST client

Author:
Putti Rakesh Varma
GitHub: https://github.com/Rakesh-Putti
Email: rakeshvarmaputti@gmail.com
