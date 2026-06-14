# FIFA World Cup 2026 CLI

An interactive Command-Line Interface (CLI) application for exploring the FIFA World Cup 2026 groups, fixtures, standings, and match results. This project serves as a comprehensive example of building a Java CLI application using [Picocli](https://picocli.info/), [JLine](https://github.com/jline/jline3), and the [TeaQL](https://teaql.io) framework for data modeling and persistence.

## Architecture Overview

The application is structured into a few core layers:

1. **CLI & Interactive REPL Layer**
   - Built on top of **Picocli** and **JLine3**.
   - Supports execution as single command-line arguments (e.g., `wc2026 groups`) as well as an interactive shell REPL with a custom prompt (`wc2026> `).
   - Core subcommands:
     - `groups`: Lists all match groups.
     - `group`: Displays details about a specific group.
     - `rank`: Shows the current standings and rankings.
     - `record`: Records or manages match results.

2. **Data & ORM Layer (TeaQL)**
   - The data model and persistence logic are powered entirely by **TeaQL**.
   - An embedded SQLite database (`~/.wc2026/worldcup.db`) is used as the data store, making the application portable and standalone.

3. **Build & Distribution**
   - Uses Maven for dependency management and build processes.
   - Generates a standalone fat JAR using the Maven Assembly Plugin.
   - Supports **GraalVM Native Image** compilation (`native` Maven profile) to build a standalone, lightning-fast native binary with zero JVM overhead.

## The Role of TeaQL

TeaQL is the backbone of the application's domain modeling and database interaction. Here is how it is used within the project:

### 1. Declarative Domain Modeling
Instead of writing boilerplate Java Entities and raw SQL schema definitions, the entire World Cup domain is declared in a single `models/model.xml` file. This file describes models such as `Tournament`, `TournamentTeam`, `MatchGroup`, and `TournamentMatch`.

### 2. Auto-Generated Domain Classes
TeaQL processes the `model.xml` and auto-generates the domain library (injected via the dependency `fifa-world-cup-2026-service-core`). This ensures type safety when querying and inserting data, completely decoupling business logic from SQL syntax.

### 3. Automated Schema Management
The `DatabaseManager` class initializes a `TeaQLRuntime` and an `SqliteDataServiceExecutor`. During initialization, TeaQL's `ensureSchema(ctx)` is invoked. This automatically provisions the underlying SQLite database with the necessary tables, columns, and foreign key relationships defined in the XML model—without requiring manual schema migrations.

### 4. Seamless Data Seeding and Querying
Using the TeaQL `UserContext`, the application seamlessly inserts initial seed data (see `SeedData.java`) and performs complex relational queries for the CLI commands. This provides a robust and highly readable approach to database interactions without writing verbose JDBC boilerplate.

## TeaQL API Usage in the Project

The application makes extensive use of TeaQL's generated APIs for data manipulation and querying. Below are the key APIs used:

### Query API (`Q` Object)
The `Q` (Query) static API provides fluent, type-safe query builders for all defined entities. It removes the need for raw SQL queries.
Examples used in this project:
- **Filtering & Matching**: `Q.tournamentTeams().filterByTeamCode(code)`, `Q.matchGroups().withIdIs(id)`
- **Sorting**: `.orderByStandingRankAsc()`, `.orderByPointsDesc()`
- **Auditing/Context**: `.comment("Load team").purpose("Display")` to tag queries in logs.
- **Execution**: `.executeForList(ctx)` to return a list of results, and `.executeForOne(ctx)` or `.first()` for a single record.

### Entity & Auditing API (`entity.auditAs().save()`)
For insertions and updates, TeaQL generates entity classes that provide fluent setters and an integrated auditing trail before saving.
- **Creating/Updating**: Entities are modified via generated setters like `t.updateTotalTeams(48)`.
- **Audited Saves**: To persist data, the project calls `.auditAs(reason).save(ctx)`. This persists the data using the active `UserContext` while logging the business reason for the change.
  - Example: `match.auditAs("Record match score").save(ctx);`
  - Example: `standing.auditAs("Update standing rank").save(ctx);`

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- (Optional) GraalVM for native compilation

### Building the Project

Compile and package the application into a fat JAR:
```bash
mvn clean package
```

*(Optional)* Build the GraalVM Native Image:
```bash
mvn clean package -Pnative
```

### Running the Application

Using the provided shell script wrapper:
```bash
./wc2026.sh
```

Or execute a specific command directly:
```bash
./wc2026.sh groups
```
