# TeaQL Tool & Runtime API Reference

> Framework-level APIs. These are the same for all TeaQL projects.
> For domain-specific APIs (entities, queries, mutations), see `API_GUIDE.md`.

---

## 1. UserContext — Application Entry Point

`UserContext` is the runtime context passed to all queries and mutations.

### Key Methods
| Method | Description |
|--------|-------------|
| `ctx.execute(request)` | Execute query, return list |
| `ctx.executeForList(request)` | Execute query, return list |
| `ctx.executeForOne(request)` | Execute query, return single entity |
| `ctx.saveGraph(entity)` | Save entity and its graph |
| `ctx.checkAndFix(entity)` | Run entity checkers before save |
| `ctx.getBean(Class)` | Retrieve Spring bean from context |
| `ctx.now()` | Get current timestamp |

### Runtime Enforcement (Triple-Intent)
```java
// Controlled by TEAQL_ENFORCE_INTENT env var or system property
// Values: off (default), warn, strict
// In strict mode:
//   - Queries without .comment() + .purpose() → RepositoryException
//   - Saves without .auditAs() → RepositoryException
```

---

## 2. SmartList — Collection with Metadata

`SmartList` wraps `List` with pagination metadata.

| Method | Description |
|--------|-------------|
| `.size()` | Number of items in current page |
| `.getTotalCount()` | Total matching records |
| `.isEmpty()` | Check if list is empty |
| `.stream()` | Java Stream API |
| `.forEach(consumer)` | Iterate items |
| `.first()` | Get first item or null |

---

## 3. SearchRequest — Query Configuration

Base class for all generated request types.

| Method | Description |
|--------|-------------|
| `.setSize(n)` | Limit result count |
| `.setOffset(n)` | Skip first N results |
| `.comment("text")` | **REQUIRED** — describe what query loads |
| `.purpose("text")` | **REQUIRED** — describe why data is needed |
| `.selectSelf()` | Select own fields |
| `.selectAll()` | Select own fields + all relations |
| `.selectChildren()` | Select all child lists |
| `.aggregateOnXxx()` | Add aggregation (count, sum, etc.) |

---

## 4. Entity Base Methods

Methods available on all generated entities (inherited from BaseEntity).

| Method | Description |
|--------|-------------|
| `.getId()` | Get entity ID |
| `.getVersion()` | Get optimistic lock version |
| `.getDisplayName()` | Get human-readable name |
| `.auditAs("action")` | **REQUIRED** — set audit comment before save |
| `.save(ctx)` | Persist to database (calls `ctx.saveGraph(this)`) |
| `.markAsDeleted()` | Flag for soft delete |
| `.markAsRecover()` | Undo soft delete |
| `.addAction(WebAction)` | Add UI action to entity |
| `.additionalInfo(key)` | Get extra metadata |
| `.addAdditionalInfo(key, val)` | Set extra metadata |

---

## 5. WebResponse — HTTP Response Builder

```java
// Return single entity
return WebResponse.of(task);

// Return paginated list
return WebResponse.of(taskList);

// Error response
return WebResponse.fail("Invalid request");
```

---

## 6. Entity Expression (E) — Null-Safe Access

Generated `E` facade provides null-safe expression chains:

```java
// Instead of: task.getStatus() != null ? task.getStatus().getCode() : ""
// Use:
String code = E.task(task).status().code().value();  // returns "" if any part is null
int count = E.task(task).version().value();           // returns 0 if null
```

| Method | Returns |
|--------|---------|
| `.value()` | The actual value, or type-appropriate default (0, "", false) |
| `.isPresent()` | Whether the value is non-null |

---

## 7. WebAction — UI Action Metadata

Attach actions to entities for frontend rendering:

```java
WebAction action = WebAction.of("edit")
    .withTitle("Edit Task")
    .withTarget("/tasks/" + task.getId() + "/edit");
task.addAction(action);
```

---

## 8. Checker — Validation Framework

Checkers are generated for each entity and run automatically before save.

```java
// Custom checker logic goes in {Entity}Checker.java
// Checkers validate:
//   - Required fields are set
//   - String length constraints
//   - Business rules
// Results appear as CheckResults with error messages
```

---

## 9. GraphMutationEngine — Save Pipeline

When `ctx.saveGraph(entity)` is called, the engine:
1. Enforces `auditAs()` is set (Triple-Intent)
2. Runs checkers (`checkAndFix`)
3. Diffs entity against database state
4. Generates INSERT/UPDATE/DELETE SQL
5. Writes audit trail with comment
6. Fires entity change events

> **You never call GraphMutationEngine directly.** Use `entity.save(ctx)` or `ctx.saveGraph(entity)`.