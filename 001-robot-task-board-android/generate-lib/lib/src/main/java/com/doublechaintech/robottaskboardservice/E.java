package com.doublechaintech.robottaskboardservice;

import com.doublechaintech.robottaskboardservice.platform.Platform;
import com.doublechaintech.robottaskboardservice.platform.PlatformExpression;
import com.doublechaintech.robottaskboardservice.task.Task;
import com.doublechaintech.robottaskboardservice.task.TaskExpression;
import com.doublechaintech.robottaskboardservice.tasklog.TaskLog;
import com.doublechaintech.robottaskboardservice.tasklog.TaskLogExpression;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusExpression;
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