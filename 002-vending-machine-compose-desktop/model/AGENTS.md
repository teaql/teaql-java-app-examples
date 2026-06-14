# TeaQL Workspace Agent Guide

> [!WARNING]
> **PARADIGM SHIFT WARNING: DO NOT GUESS METHOD NAMES**
> TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
> You must clear your memory of traditional ORMs (Spring Data JPA, Hibernate, MyBatis, etc.).
> There are no standard setter methods. The entity structure is entirely proprietary and dynamically generated.
> **RULE:** If you encounter a compilation error like `cannot find symbol` or `method not found` when calling a method (e.g., `updateXxx()`), **ABSOLUTELY DO NOT GUESS** another method name. You must immediately use the `view_file` tool to read the generated source code for the entity and find the exact method signature, or stop and ask the user for help.

This workspace is the Spring Boot runtime for the TeaQL domain package `com.doublechaintech.vendingmachineservice`.

> [!CAUTION]
> **AI AGENT GUARDRAIL: DO NOT BYPASS TEAQL ON COMPILATION/RUNTIME ERRORS**
> If you encounter compilation errors or runtime validation errors (e.g., `Missing: .auditAs()` or `Missing: .purpose()`):
> 1. **DO NOT** attempt to write direct SQL, JDBC, MyBatis, or bypass the TeaQL API.
> 2. **DO NOT** add or use external database libraries (e.g., JPA/Hibernate, Spring Data repositories) to access the database.
> 3. **DO NOT** write custom DAO or Repository implementations.
> 4. **THE ONLY CORRECT FIX** is to apply the **Triple-Intent Audit Pattern**:
>    - **Java Entity Save**: You must chain `.auditAs("comment")` before saving: `entity.auditAs("action comment").save(userContext)`
>    - **Queries**: You must chain `.comment("what is loaded").purpose("why it is loaded")` before calling the execution method (e.g., `.executeForList(userContext)`).
> Any workaround that bypasses TeaQL will violate database safety constraints and fail CI.

## Read First

- Absolute rule: never use SQL to operate on the database from workspace business code.
- If a change cannot be implemented with generated TeaQL APIs, stop and report the missing API. Do not work around it with SQL.
- Use generated TeaQL APIs before writing repository code, DTO mapping, or manual relation loaders.
- Before writing code against the generated TeaQL library, read the library guide at `../generate-lib/AGENTS.md`. If the library is supplied from a package repository instead of a local generated directory, locate the unpacked dependency sources or published source artifact and read that library's `AGENTS.md` before using its APIs.
- Do not use other database access technologies from workspace business code. This includes JPA/Hibernate, Spring Data repositories, MyBatis, JDBC templates, jOOQ, QueryDSL, native queries, raw SQL clients, and hand-written DAO layers.
- Do not add dependencies or helper wrappers that bypass TeaQL for persistence, querying, transactions, relation loading, or DTO mapping.

## Application Layer Safety Guardrails

### 1. Use the Entity API Exclusively
- Always perform state transitions or updates via generated `updateXxx(...)` methods and call `auditAs("comment").save(userContext)`.
- Never use repository-level methods directly. They execute full graph replacements and may implicitly delete child records.
- Data MUST NOT be deleted implicitly. Use the generated soft-delete API. Do not write SQL delete/update statements.

### 2. BAN ON RAW IO AND UTILITY LIBRARIES
- Inside the application layer, do not use raw IO or utility libraries directly (e.g. `java.nio.file.Files`, `java.net.HttpURLConnection`, Apache HttpClient, OkHttp).
- All side effects (network, file, time) and stateful computations SHOULD go through `UserContext` extensions or dedicated Util classes that are centrally auditable.
- Do not use `System.currentTimeMillis()`, `LocalDateTime.now()`, or `Instant.now()` directly. Use the context-aware time provider to ensure correct timezone handling for global deployments.

### 3. MANDATORY BUSINESS INTENT
- Every query MUST chain `.comment("English intent description")` and `.purpose("English business reason")` before execution to enable automatic audit trails.
- Every save/update MUST chain `.auditAs("English intent description")` before persistence.
- Use `Q` for reads and generated request builders.
- AI agents must not instantiate request builders directly. Do not write `new XxxRequest(...)`; start from `Q.xxx()` and chain generated request helpers from there.
- Business code may use only the supported TeaQL surface: `Q`, generated entity APIs, `auditAs("comment").save(userContext)`, `E`, and workspace-specific extensions of `UserContext`.
- Do not access lower-level TeaQL internals directly: repositories, repository registries, metadata registries, SQL executors, transaction internals, or framework persistence hooks.
- Single-object queries use `.executeForOne(userContext)`.
- Return query results from controllers with `WebResponse.of(entity)` or `WebResponse.of(list)`, and return `WebResponse.fail(e.getMessage())` on exceptions.
- Use entity `auditAs("comment").save(userContext)` for creates and updates.
- Mandatory update rule: use generated `updateXxx(...)` methods to change entity fields. Do not use `setXxx(...)`; setters are deprecated even when visible.
- Use the generated soft-delete API for deletes. Do not hard-delete rows and do not write SQL delete/update statements.
- Use generated relation selectors such as `selectXxx()` and `selectXxxWith(...)` instead of N+1 loops.
- Keep request-handling code in this workspace. Do not edit generated library classes copied from the domain package.
- Do not edit generated library files. If generated APIs are missing or awkward, update the KSML model or report the missing TeaQL API and regenerate.
- If the API shape is unclear, read `docs/teaql-java-crud-guide.md` before searching external code.

### 4. TRIPLE-INTENT AUDIT ENFORCEMENT
- **Mutations (Saves)**: Every entity mutation MUST call `.auditAs("Comment describing the business action")` before calling `.save(userContext)`. Saving without `auditAs(...)` will throw a strict validation error at runtime.
  ```java
  // Correct
  entity.updateName("example");
  entity.auditAs("Create new item").save(userContext);

  // WRONG: runtime validation error
  entity.save(userContext);
  ```
- **Queries**: Every select/query chain MUST call `.comment("What the query loads")` and `.purpose("Why the query is needed")` before calling the execution method (e.g. `.executeForList(userContext)`).
  ```java
  // Correct
  var list = Q.tasks()
      .selectSelf()
      .comment("Load tasks")
      .purpose("Render dashboard")
      .executeForList(ctx);
  ```

### 5. PREVENTING STACK OVERFLOW (CYCLIC REFERENCES & MASSIVE GRAPHS)
- **Graph Saving is the Core Advantage**: TeaQL encourages building an object graph in memory and saving it all at once via `.save(userContext)`. This is the standard and preferred way to handle business logic.
- **Cyclic Reference Hazard**: During `save()`, TeaQL recursively traverses loaded relations. If you have cyclic references in memory (e.g., `tenant` references `user` via `owner`, and `user` references `tenant` via `tenant`), calling `.save(ctx)` will throw a `StackOverflowError`.
  - **The Fix**: You MUST break the loop in memory before calling `.save(ctx)`. Update one side of the relation (usually the parent back-reference on the child entity) to `null` or clear the children list before saving.
- **Massive Graph Hazard (Sample Data)**: While saving graphs is encouraged, building an excessively large graph (e.g., attaching > 20 child items to a root entity during system initialization or sample data generation) can cause a `StackOverflowError` in debug builds due to massive stack frame allocation.
  - **The Fix**: If you are generating seed data or sample data exceeding 20 items, DO NOT build a single massive graph. You must chunk the creation into smaller loops or save the children independently.

## Business Code Boundaries

TeaQL business code should express intent through layers:

```text
Controller -> Service -> Helper -> <Subject><DomainEntity> -> save/update
```

- Controller owns HTTP/API only: accept request payloads, create command/event/input objects, call services, and return `WebResponse`. Do not put business logic, transactions, Q queries, setters, or `updateXxx(...)` calls in controllers.
- Service owns use-case orchestration and transaction boundaries. Add `@Transactional` to methods that modify data. Services may load entities through helpers, call domain business methods, and persist changes, but must not return `WebResponse` or implement business transitions as field assignments.
- Helper owns reusable Q request semantics and business-oriented loading only. Use names like `loadOrderForShipping(ctx, id)`, apply query-side preconditions, and use `returnType(<Subject><DomainEntity>.class)` when behavior-specific domain objects are needed. Helpers must not mutate state, start transactions, return `WebResponse`, or execute business actions.
- `<Subject><DomainEntity>` classes carry business behavior for a generated entity in a specific role, for example `ShippingOrder`, `CancelableOrder`, or `ApprovingInvoice`. Business methods accept command/event/input objects, validate invariants, and use chainable `updateXxx(...)` internally.
- Util classes isolate low-level technical concerns such as time, string, JSON, crypto, encoding, files, IDs, or external libraries. Utils must not know business concepts, use Q APIs, access the database, return `WebResponse`, or mutate domain entities.

Hard rule: generated setters are not business APIs. New business code must not call `setXxx(...)` from controllers, services, helpers, utils, or domain behavior methods.

## Main Imports

```java
import com.doublechaintech.vendingmachineservice.Q;
import com.doublechaintech.vendingmachineservice.VendingMachineServiceUserContext;
import io.teaql.core.web.WebResponse;
```

Use `CustomUserContext` for workspace-specific request context behavior.
Extend `CustomUserContext` or the generated `VendingMachineServiceUserContext` type for context-specific behavior instead of reaching into runtime internals.

## Query Pattern

```java
public WebResponse list(@TQLContext UserContext userContext) {
    try {
        var list = Q.vendingMachines()
            .selectSelf()
            .page(1, 20)
            .executeForList(userContext);
        return WebResponse.of(list);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

```java
public WebResponse getOne(@TQLContext UserContext userContext, Long id) {
    try {
        var entity = Q.vendingMachines()
            .filterById(id)
            .selectSelf()
            .executeForOne(userContext);
        return WebResponse.of(entity);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

## Save Pattern

```java
var entity = new VendingMachine();
// entity.updateName("example");
entity.auditAs("Create new entity").save(userContext);
```

Use `updateXxx(...)` for every field change. Never use `setXxx(...)` in new workspace code.

## Internationalization (i18n) Guidance

For multilingual support and translation of domain terms (e.g. validation error messages) when using non-English locales (such as Chinese, Spanish, etc.), TeaQL provides a clean, offline i18n translation dictionary workflow:

1. **Locate the Sample File**: Find the auto-generated `teaql-i18n.sample.json` file in the workspace root. It contains all unique domain entity and property vocabulary keys.
2. **Translate via AI**: Paste the contents of `teaql-i18n.sample.json` into your AI tool, or instruct this AI agent to translate it. Use the following prompt:
   > **Prompt**: "Translate this JSON file containing TeaQL domain vocabulary keys into 15 languages: Arabic (ar), Simplified Chinese (zh_CN), Traditional Chinese (zh_TW), Spanish (es), French (fr), German (de), Japanese (ja), Korean (ko), Portuguese (pt), Thai (th), Ukrainian (uk), Filipino (fil), Indonesian (id), English (en) under each key. Return only the valid JSON result."
3. **Save the JSON**: Save the translated JSON result as `teaql-i18n.json` externally or on the classpath.
4. **Configure JVM Parameter**: Set the JVM property `-Dteaql.i18n.path=/path/to/teaql-i18n.json` pointing to your translated file.
5. **Runtime Validation Rule**: If a non-English translator is instantiated at runtime and `-Dteaql.i18n.path` is unconfigured, invalid, or the file is empty, the starter throws a strict `IllegalStateException` to prevent unlocalized output.

## Core Business Entry Points

These examples use entities with the highest reverse relation counts. A high reverse relation count means many other objects point back to this entity, making it a stronger aggregate-root candidate.

- `VendingMachine`: `Q.vendingMachines()`, reverse relations `3`, class `com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine`
- `VendingOrder`: `Q.vendingOrders()`, reverse relations `2`, class `com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder`
- `OrderStatus`: `Q.orderStatuses()`, reverse relations `1`, class `com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus`

## All Domain Entry Points

- `VendingMachine`: `Q.vendingMachines()`, reverse relations `3`, class `com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine`
- `OrderStatus`: `Q.orderStatuses()`, reverse relations `1`, class `com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus`
- `PaymentMethod`: `Q.paymentMethods()`, reverse relations `1`, class `com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod`
- `Product`: `Q.products()`, reverse relations `1`, class `com.doublechaintech.vendingmachineservice.product.Product`
- `VendingOrder`: `Q.vendingOrders()`, reverse relations `2`, class `com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder`
- `OrderPayment`: `Q.orderPayments()`, reverse relations `0`, class `com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment`
- `VendingOrderItem`: `Q.vendingOrderItems()`, reverse relations `0`, class `com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem`