# Project: Cadastro de Colaboradores

## Project Overview
A Spring Boot-based API for managing collaborators and their activities. The system allows creating, listing, updating, and deleting collaborators, with each collaborator being assigned to a specific activity. It follows a modern layered architecture focused on maintainability and clean code.

### Core Technologies
- **Java 26**: Utilizing the latest Java features.
- **Spring Boot 4.0.5**: Core framework for web and dependency management.
- **Spring Data JPA**: For object-relational mapping and database interaction.
- **H2 Database**: In-memory database used for development and testing.
- **Flyway**: Database migration management.
- **Lombok**: Reducing boilerplate code in models and DTOs.
- **Maven**: Project build and dependency management.

### Architecture & Patterns
- **Layered Architecture**:
  - `Controller`: Handles HTTP requests and returns `ResponseEntity`.
  - `Service`: Contains business logic and orchestrates data flow between mappers and repositories.
  - `Repository`: Interface for database operations using Spring Data JPA.
  - `Model/Entity`: Represents the database schema.
  - `DTO (Data Transfer Object)`: Used for data exchange between layers and API clients.
  - `Mapper`: Custom `@Component` classes responsible for converting between Models and DTOs.
- **Dependency Injection**: Primarily uses constructor injection.
- **Database Migrations**: SQL scripts located in `src/main/resources/db/migrations`.

## Building and Running
### Prerequisites
- JDK 26
- Maven

### Key Commands
- **Clean and Install Dependencies**:
  ```bash
  ./mvnw clean install
  ```
- **Run the Application**:
  ```bash
  ./mvnw spring-boot:run
  ```
- **Run Tests**:
  ```bash
  ./mvnw test
  ```
- **Access H2 Console**: Available at `http://localhost:8080/h2-console` (Check `application.properties` for credentials).

## Development Conventions
- **Naming Strategy**:
  - Controllers: `*Controller.java`
  - Services: `*Service.java`
  - Repositories: `*Repository.java`
  - Models: `*Model.java`
  - DTOs: `*DTO.java`
  - Mappers: `*Mapper.java`
- **Mapping**: Always use the dedicated Mapper component to transform Entities to DTOs and vice-versa within the Service layer.
- **Responses**: Controllers should always return `ResponseEntity<?>` to provide appropriate HTTP status codes and consistent bodies.
- **Database**: Add any schema changes via new Flyway migration files in `src/main/resources/db/migrations` using the `V<Version>__<Description>.sql` naming convention.
