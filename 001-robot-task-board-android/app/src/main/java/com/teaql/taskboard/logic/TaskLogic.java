package com.teaql.taskboard.logic;

import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.Q;
import io.teaql.core.UserContext;
import io.teaql.core.SmartList;

public class TaskLogic {

    public static void createNewTask(UserContext ctx, String taskName) {
        Platform platform = Q.platforms().withIdIs(1L).comment("Init").purpose("New task").executeForOne(ctx);
        
        Task newTask = new Task();
        newTask.updateId(System.currentTimeMillis() % 100000L);
        newTask.updateName(taskName);
        newTask.updateStatusToTodo();
        newTask.updatePlatform(platform);
        newTask.auditAs("Create new task from UI").save(ctx);
    }

    public static SmartList<Task> getAllTasks(UserContext ctx) {
        return Q.tasks()
                .selectStatus()
                .comment("Load board").purpose("Display tasks")
                .executeForList(ctx);
    }

    public static void updateTaskStatus(UserContext ctx, String taskIdStr, String newStatusCode) {
        try {
            Long taskId = Long.valueOf(taskIdStr);
            Task task = Q.tasks().withIdIs(taskId).comment("Update status").purpose("Drag and drop").executeForOne(ctx);
            if (task != null) {
                switch (newStatusCode) {
                    case "TODO": task.updateStatusToTodo(); break;
                    case "IN_PROGRESS": task.updateStatusToInProgress(); break;
                    case "DONE": task.updateStatusToDone(); break;
                }
                task.auditAs("Moved task status from drag-and-drop").save(ctx);
            }
        } catch (NumberFormatException ignored) {
        }
    }
}
