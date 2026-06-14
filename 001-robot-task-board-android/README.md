# Robot Task Board - TeaQL Android App Example

This is an Android local task board example application built on the TeaQL framework (purely local, zero backend network dependencies).

The most prominent feature of this project is its **minimalist business logic** and **rock-solid data flow control**. All underlying CRUD operations, validation rules, relationship bindings, and table schema generation are driven entirely by the declarative metadata in `model.xml`. This allows Android developers to focus purely on the actual business flow.

## Code Scale: Do More with Less Code

Currently, the total number of lines for all business logic and UI layouts in the native Android project (`app/src`) is only **738 lines**. In the AI era, less code means lower cognitive load for debugging, fewer bugs, and higher control over the business logic.

| File Path                               | LOC   | Description                                 |
| :-------------------------------------- | :---- | :------------------------------------------ |
| **Java Logic and UI (Total: 540 lines)**|       |                                             |
| `BoardFragment.java`                    | 148   | Core logic for board drag-and-drop & UI binding |
| `TeaQLManager.java`                     | 135   | Initialization and lifecycle management of TeaQL & SQLite |
| `MainActivity.java`                     | 56    | Host Activity                               |
| `LogAdapter.java`                       | 55    | RecyclerView Adapter for SQL audit logs     |
| `LogsFragment.java`                     | 50    | Bottom panel displaying real-time logs      |
| `TeaQLLogSinkImpl.java`                 | 47    | Custom TeaQL log interceptor for underlying SQL execution |
| `TaskLogic.java`                        | 45    | Pure business core: create task, update status, read list |
| `LogEntry.java`                         | 14    | Simple data carrier class                   |
| **Android XML Layouts & Resources (Total: 198 lines)**|       |                                             |
| `fragment_board.xml`                    | 78    | Main board UI layout                        |
| `item_log.xml`                          | 25    | Layout for a single log list item           |
| `AndroidManifest.xml`                   | 20    | Application manifest file                   |
| `activity_main.xml`                     | 17    | Host layout                                 |
| `item_task.xml`                         | 17    | Layout for the task card component on the board |
| `fragment_logs.xml`                     | 12    | Layout for the log display area             |
| `themes.xml`                            | 11    | App theme definitions                       |
| `strings.xml`                           | 8     | String resources                            |

---

## Core Business Scenarios and Code Examples

By leveraging strongly-typed generated Java APIs (located in `generate-lib`), we eliminate error-prone spaghetti code. All queries, value assignments, and log instrumentations are strictly safeguarded by the compiler.

### 1. Create Object and Persist (Create)
Since we have enforced strict constraints on constant fields in the metadata, we assign values by calling methods like `updateStatusToTodo()`, and direct assignments via `updateStatus(status)` are prohibited. Furthermore, when saving, the **trinity audit log intent (`auditAs`) must be specified**, otherwise calling `save()` is forbidden.

```java
// TaskLogic.java
public static void createNewTask(UserContext ctx, String taskName) {
    // Initialize platform on demand, automatically carrying execution intent for query
    Platform platform = Q.platforms().withIdIs(1L)
                         .comment("Init").purpose("New task").executeForOne(ctx);
    
    Task newTask = new Task();
    newTask.updateId(System.currentTimeMillis() % 100000L); // Local simulated distributed ID
    newTask.updateName(taskName);
    newTask.updateStatusToTodo(); // Strict typing constraint: safety net enforced by underlying generator, exposing only constant methods
    newTask.updatePlatform(platform);
    
    // Persist with forced intent declaration
    newTask.auditAs("Create new task from UI").save(ctx);
}
```

### 2. Query Data with Fluent Filtering (Query)
The framework exposes DSL-style strongly-typed query capabilities through `Q.xxx()`.

```java
// TaskLogic.java
public static SmartList<BusinessTask> getAllTasks(UserContext ctx) {
    return (SmartList<BusinessTask>)(SmartList<?>) Q.tasks()
            .returnType(BusinessTask.class)
            .selectStatus()  // Only query the associated Status field to reduce payload
            .comment("Load board").purpose("Display tasks") // Attach audit identifiers
            .executeForList(ctx);
}
```

### 3. Update Specific Data Status (Update)
Instead of executing an invalid "query-then-update" sequence when a task status changes via drag-and-drop on the board, state changes are handled by calling explicit shortcut intent methods with strong validation.

```java
// TaskLogic.java
public static void updateTaskStatus(UserContext ctx, String taskIdStr, String newStatusCode) {
    try {
        Long taskId = Long.valueOf(taskIdStr);
        BusinessTask task = (BusinessTask) Q.tasks()
                .returnType(BusinessTask.class)
                .withIdIs(taskId)
                .comment("Update status").purpose("Drag and drop")
                .executeForOne(ctx);
        if (!E.task(task).isNull()) {
            task.transitStatus(newStatusCode);
            task.auditAs("Moved task status from drag-and-drop").save(ctx);
        }
    } catch (NumberFormatException ignored) {
    }
}
```

### 4. Intercepting Underlying Behaviors: Customizing User Context Log
By implementing `CustomLogSink`, we can easily hijack the underlying SQL execution process and present it on the Android UI:

```java
// TeaQLLogSinkImpl.java
public class TeaQLLogSinkImpl implements CustomLogSink {
    private static final TeaQLLogSinkImpl INSTANCE = new TeaQLLogSinkImpl();
    private final List<LogEntry> logs = new ArrayList<>();
    
    // Hijack underlying callback
    @Override
    public void onLog(String formattedLogContent) {
        synchronized (logs) {
            String time = sdf.format(new Date());
            logs.add(new LogEntry(formattedLogContent, time));
            if (listener != null) {
                // Notify frontend RecyclerView to refresh
                listener.onLogAdded();
            }
        }
    }
}
```

Simply register it to the runtime `UserContext` to make it globally effective:

```java
// Initialize UserContext (Snippet from TeaQLManager)
AndroidUserContextImpl ctx = new AndroidUserContextImpl(AndroidEnvironment.getInstance());
ctx.setCustomLogSink(TeaQLLogSinkImpl.getInstance());
```

### 5. Executed Query and Update Logs
Behind the scenes, TeaQL translates our high-level intent-based API calls into precise SQL statements, while attaching the `comment` and `purpose` as execution metadata.
For instance, the SQL logs generated when calling `getAllTasks()`:
```sql
[DEBUG]-ExecutionLog - [Load board] - [Fetched 0 rows]
SELECT id, name, platform, create_time AS "createTime", update_time AS "updateTime", version, status FROM task_data WHERE version > 0 LIMIT 1000 OFFSET 0
```

And when updating a task status via drag-and-drop:
```sql
[DEBUG]-ExecutionLog - [Moved task status from drag-and-drop] - [Batch affected 1 rows]
INSERT INTO task_data (id,name,platform,status,create_time,update_time,version) VALUES (1,NULL,NULL,1003,NULL,NULL,1)
```
