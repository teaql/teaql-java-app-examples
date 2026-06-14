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
        
        BusinessTask newTask = new BusinessTask();
        newTask.updateId(System.currentTimeMillis() % 100000L);
        newTask.updateName(taskName);
        newTask.updateStatusToTodo();
        newTask.updatePlatform(platform);
        newTask.auditAs("Create new task from UI").save(ctx);
    }

    @SuppressWarnings("unchecked")
    public static SmartList<BusinessTask> getAllTasks(UserContext ctx) {
        return (SmartList<BusinessTask>)(SmartList<?>) Q.tasks()
                .returnType(BusinessTask.class)
                .selectStatus()
                .comment("Load board").purpose("Display tasks")
                .executeForList(ctx);
    }

    public static void updateTaskStatus(UserContext ctx, String taskIdStr, String newStatusCode) {
        try {
            Long taskId = Long.valueOf(taskIdStr);
            BusinessTask task = (BusinessTask) Q.tasks()
                    .returnType(BusinessTask.class)
                    .withIdIs(taskId)
                    .comment("Update status").purpose("Drag and drop")
                    .executeForOne(ctx);
            if (task != null) {
                task.transitStatus(newStatusCode);
                task.auditAs("Moved task status from drag-and-drop").save(ctx);
            }
        } catch (NumberFormatException ignored) {
        }
    }
}
