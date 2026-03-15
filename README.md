# Coupon System Backend

A Spring Boot backend for a coupon management system, designed to support multiple user roles (Admin / Company / Customer) with full CRUD operations, authentication, and scheduled maintenance. The service persists data in a relational database via Spring Data JPA and includes a background job for cleaning up expired coupons.

## Technical Highlights

* **Role-Based CRUD API (Admin / Company / Customer)**: Implements separate controllers + services for each client type, enforcing role-specific business rules (e.g., companies can only manage their own coupons, customers can only purchase once, admin can manage companies/customers).
* **Spring Data JPA + Entity Modeling**: Uses JPA entities (`Coupon`, `Company`, `Customer`, etc.) and repositories (`CouponRepo`, `CompanyRepo`, `CustomerRepo`) for database access with convenience query methods and custom native queries.
* **JWT-Based Authentication**: Includes a `JWTutil` class to generate/validate tokens and a login flow that returns a token used to authenticate further requests (via `LoginController` + `LoginService`).
* **Scheduled Expiration Cleanup**: `CouponExpirationDailyJob` runs daily (cron `0 0 2 * * ?`) and removes expired coupons using a native query in `CouponRepo`.
* **Custom Exception Handling**: Global exception advice (`ClientAdvice`) standardizes error responses and uses `CustomExceptions` + `OptionalExceptionMessages` for consistent messaging.
* **Flexible Database Configuration**: `application.properties` can easily switch between local MySQL (commented out) and deployed PostgreSQL (currently active, including Heroku config); `spring.jpa.hibernate.ddl-auto=update` keeps schema in sync.

## Tech Stack

* **Language**: Java (Spring Boot)
* **Frameworks**: Spring Boot, Spring MVC, Spring Data JPA, Spring Scheduling
* **Database**: PostgreSQL (Heroku); optional MySQL (commented config)
* **Build Tool**: Maven
* **Security/Auth**: JWT tokens + role-based service layer

## System Architecture

1. **HTTP Layer (Controllers)**  
   Each role has a dedicated controller (`AdminController`, `CompanyController`, `CustomerController`, `GuestController`, `LoginController`) exposing REST endpoints.

2. **Service Layer (Business Logic)**  
   Services (`AdminService`, `CompanyService`, `CustomerService`, `GuestService`, `LoginService`) coordinate validation, authorization rules, and repository operations.

3. **Persistence Layer (Repositories / Entities)**  
   Repositories extend `JpaRepository` and include custom queries (e.g., deleting expired coupons, checking purchase history). Entities represent domain objects and map to DB tables.

4. **Background Job (Scheduler)**  
   `CouponExpirationDailyJob` runs nightly to delete expired coupons, keeping the database clean without manual intervention.

5. **Error Handling**  
   `ClientAdvice` handles exceptions and returns standardized JSON errors for clients.

---

### Professional Summary

This project demonstrates a production-ready backend architecture built with **Spring Boot**, combining clean separation of concerns (controllers/services/repos), secure authentication (JWT), scheduled background processing, and database persistence. It is tailored for real-world deployment (Heroku-friendly) and showcases strong competence in designing robust, maintainable, role-driven REST APIs with automated data maintenance.
