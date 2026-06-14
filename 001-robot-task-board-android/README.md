# Robot Task Board - TeaQL Android App Example

这是一个基于 TeaQL 框架构建的 Android 本地任务看板示例应用（单机纯本地，零后端网络依赖）。

本项目最大的特点在于：**极简的业务代码** 与 **坚如磐石的数据流向控制**。所有的底层 CRUD、验证规则、关系绑定以及建表逻辑全部通过 `model.xml` 声明式元数据驱动生成，让 Android 端的开发者只关注真正的业务流转。

## 代码规模：用最少的代码做最多的事

目前 Android 原生工程（`app/src`）的所有业务逻辑及 UI 布局总行数仅为 **738 行**。AI 时代，更少的代码意味着更小的排错负担、更少的 Bug，以及更高的业务掌控力。

| 文件路径                               | 代码行数 | 说明                                        |
| :------------------------------------- | :------- | :------------------------------------------ |
| **Java 逻辑与 UI (总计 540 行)**        |          |                                             |
| `BoardFragment.java`                   | 148 行   | 看板拖拽与 UI 数据绑定核心逻辑              |
| `TeaQLManager.java`                    | 135 行   | TeaQL 框架与本地 SQLite 初始化和生命周期管理|
| `MainActivity.java`                    | 56 行    | 宿主 Activity                               |
| `LogAdapter.java`                      | 55 行    | SQL 审计日志列表的 RecyclerView Adapter     |
| `LogsFragment.java`                    | 50 行    | 底部面板，展示实时日志                      |
| `TeaQLLogSinkImpl.java`                | 47 行    | TeaQL 自定义日志拦截器（拦截底层 SQL 执行） |
| `TaskLogic.java`                       | 45 行    | 纯业务核心逻辑：新建任务、更新状态、读取列表|
| `LogEntry.java`                        | 14 行    | 简单的数据载体类                            |
| **Android XML 布局与资源 (总计 198 行)**|          |                                             |
| `fragment_board.xml`                   | 78 行    | 看板主体界面布局                            |
| `item_log.xml`                         | 25 行    | 日志列表单项布局                            |
| `AndroidManifest.xml`                  | 20 行    | 应用清单文件                                |
| `activity_main.xml`                    | 17 行    | 宿主布局                                    |
| `item_task.xml`                        | 17 行    | 看板上的卡片组件布局                        |
| `fragment_logs.xml`                    | 12 行    | 日志展示区布局                              |
| `themes.xml`                           | 11 行    | App 主题定义                                |
| `strings.xml`                          | 8 行     | 字符资源                                    |

---

## 核心业务场景与代码示例

通过强类型生成的 Java API（存放在 `generate-lib`），我们抛弃了容易出错的面条代码（Spaghetti code）。所有的查询、设值、日志埋点都有编译器的强制防护。

### 1. 新建对象并落库 (Create)
由于在元数据中标记了常量字段强约束，我们调用 `updateStatusToTodo()` 等方法来设值，而非法直接使用 `updateStatus(status)` 赋值。同时，保存时**必须指定三位一体的审计日志意图（auditAs）**，否则禁止调用 `save()`。

```java
// TaskLogic.java
public static void createNewTask(UserContext ctx, String taskName) {
    // 按需初始化平台，自动携带执行意图进行查询
    Platform platform = Q.platforms().withIdIs(1L)
                         .comment("Init").purpose("New task").executeForOne(ctx);
    
    Task newTask = new Task();
    newTask.updateId(System.currentTimeMillis() % 100000L); // 本地模拟分布式ID
    newTask.updateName(taskName);
    newTask.updateStatusToTodo(); // 严格类型约束：由底层生成器强加的安全网，仅开放常量方法
    newTask.updatePlatform(platform);
    
    // 强制意图声明落库
    newTask.auditAs("Create new task from UI").save(ctx);
}
```

### 2. 查询数据与流式过滤 (Query)
框架通过 `Q.xxx()` 暴露 DSL 风格的强类型查询能力。

```java
// TaskLogic.java
public static SmartList<Task> getAllTasks(UserContext ctx) {
    return Q.tasks()
            .selectStatus()  // 仅查询关联的 Status 字段，减少数据量
            .comment("Load board").purpose("Display tasks") // 携带审计标识
            .executeForList(ctx);
}
```

### 3. 更新特定数据状态 (Update)
针对拖拽看板的任务状态变更，不再进行先查后改的无效操作，而是通过明确的快捷意图方法进行强校验的变更。

```java
// TaskLogic.java
public static void updateTaskStatus(UserContext ctx, String taskIdStr, String newStatusCode) {
    Long taskId = Long.valueOf(taskIdStr);
    Task task = Q.tasks().withIdIs(taskId)
                 .comment("Update status").purpose("Drag and drop")
                 .executeForOne(ctx);
                 
    if (task != null) {
        // 根据状态码调用安全的生成方法
        switch (newStatusCode) {
            case "TODO": task.updateStatusToTodo(); break;
            case "IN_PROGRESS": task.updateStatusToInProgress(); break;
            case "DONE": task.updateStatusToDone(); break;
        }
        task.auditAs("Moved task status from drag-and-drop").save(ctx);
    }
}
```

### 4. 拦截底层行为：定制 User Context Custom Log
我们通过实现 `CustomLogSink` 可以极其容易地劫持底层的 SQL 执行过程，并将其呈现到 Android 界面上：

```java
// TeaQLLogSinkImpl.java
public class TeaQLLogSinkImpl implements CustomLogSink {
    private static final TeaQLLogSinkImpl INSTANCE = new TeaQLLogSinkImpl();
    private final List<LogEntry> logs = new ArrayList<>();
    
    // 劫持底层回调
    @Override
    public void onLog(String formattedLogContent) {
        synchronized (logs) {
            String time = sdf.format(new Date());
            logs.add(new LogEntry(formattedLogContent, time));
            if (listener != null) {
                // 通知前端 RecyclerView 刷新
                listener.onLogAdded();
            }
        }
    }
}
```

将其注册给运行时的 `UserContext` 即可全局生效：

```java
// 初始化 UserContext (摘自 TeaQLManager)
AndroidUserContextImpl ctx = new AndroidUserContextImpl(AndroidEnvironment.getInstance());
ctx.setCustomLogSink(TeaQLLogSinkImpl.getInstance());
```
