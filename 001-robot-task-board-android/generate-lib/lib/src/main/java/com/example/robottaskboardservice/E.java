package com.example.robottaskboardservice;

import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.platform.PlatformExpression;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskExpression;
import com.example.robottaskboardservice.tasklog.TaskLog;
import com.example.robottaskboardservice.tasklog.TaskLogExpression;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.taskstatus.TaskStatusExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static TaskStatusExpression<TaskStatus, TaskStatus, TaskStatus> taskStatus(TaskStatus taskStatus){
      return new TaskStatusExpression(new ValueExpression(taskStatus));
  }
  public static PlatformExpression<Platform, Platform, Platform> platform(Platform platform){
      return new PlatformExpression(new ValueExpression(platform));
  }
  public static TaskExpression<Task, Task, Task> task(Task task){
      return new TaskExpression(new ValueExpression(task));
  }
  public static TaskLogExpression<TaskLog, TaskLog, TaskLog> taskLog(TaskLog taskLog){
      return new TaskLogExpression(new ValueExpression(taskLog));
  }
}