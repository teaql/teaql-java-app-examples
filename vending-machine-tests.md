# TeaQL Vending Machine Example - Multi-Framework Testing

This document tracks the testing of the `vending-machine-service` example across various Java frameworks using the PostgreSQL database.

## Test Strategy
- **Core Example**: Vending Machine (using `vending.xml`)
- **Database**: PostgreSQL (PG)
- **Workspaces Directory**: `~/githome/teaql-java-app-examples`
- **Frameworks Tested**:
  - `java-web-spring-boot` (Spring Boot 4.1.0)
  - `java-web-quarkus` (Quarkus 3.8.3)
  - `java-web-micronaut` (Micronaut 4.3.8)

## Test Results

### 1. Spring Boot 4.1.0 (`005-vending-machine-web-spring-boot`)
- **Status**: ✅ Passed
- **Details**:
  - Upgraded Spring Boot to 4.1.0 and Java 21.
  - Successfully generated the code using `LocalGenerator`.
  - Migrated to using `SpringJdbcSqlExecutor`.
  - Application compiles and runs successfully.

### 2. Quarkus 3.8.3 (`006-vending-machine-web-quarkus`)
- **Status**: ✅ Passed (Generation & Compilation)
- **Details**:
  - Initialized Quarkus project template in the generator.
  - Used `teaql-provider-jdbc` with `JdbcSqlExecutor` since Quarkus doesn't use Spring JDBC.
  - Adapted `App.java` and `EnsureModelController` for Quarkus `@ApplicationScoped` and `@Observes StartupEvent`.
  - Code generation via `LocalGenerator` completed successfully.

### 3. Micronaut 4.3.8 (`007-vending-machine-web-micronaut`)
- **Status**: ✅ Passed (Generation & Compilation)
- **Details**:
  - Initialized Micronaut project template in the generator.
  - Used `teaql-provider-jdbc` with `JdbcSqlExecutor`.
  - Adapted `App.java` and `EnsureModelController` using Micronaut `@Factory`, `@Singleton`, and `@EventListener`.
  - Code generation via `LocalGenerator` completed successfully.

## Conclusion
The core functionality of TeaQL is now confirmed to generate and compile successfully across the three major Java frameworks (Spring Boot, Quarkus, and Micronaut) targeting Java 21.
