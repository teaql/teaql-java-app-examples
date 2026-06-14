package com.example.robottaskboardservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.robottaskboardservice.taskstatus.TaskStatusRequest<com.example.robottaskboardservice.taskstatus.TaskStatus> taskStatuses(){
      return new com.example.robottaskboardservice.taskstatus.TaskStatusRequest(com.example.robottaskboardservice.taskstatus.TaskStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.robottaskboardservice.taskstatus.TaskStatusRequest<com.example.robottaskboardservice.taskstatus.TaskStatus> taskStatusesWithMinimalFields(){
      return new com.example.robottaskboardservice.taskstatus.TaskStatusRequest(com.example.robottaskboardservice.taskstatus.TaskStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.robottaskboardservice.platform.PlatformRequest<com.example.robottaskboardservice.platform.Platform> platforms(){
      return new com.example.robottaskboardservice.platform.PlatformRequest(com.example.robottaskboardservice.platform.Platform.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.robottaskboardservice.platform.PlatformRequest<com.example.robottaskboardservice.platform.Platform> platformsWithMinimalFields(){
      return new com.example.robottaskboardservice.platform.PlatformRequest(com.example.robottaskboardservice.platform.Platform.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.robottaskboardservice.task.TaskRequest<com.example.robottaskboardservice.task.Task> tasks(){
      return new com.example.robottaskboardservice.task.TaskRequest(com.example.robottaskboardservice.task.Task.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.robottaskboardservice.task.TaskRequest<com.example.robottaskboardservice.task.Task> tasksWithMinimalFields(){
      return new com.example.robottaskboardservice.task.TaskRequest(com.example.robottaskboardservice.task.Task.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.robottaskboardservice.tasklog.TaskLogRequest<com.example.robottaskboardservice.tasklog.TaskLog> taskLogs(){
      return new com.example.robottaskboardservice.tasklog.TaskLogRequest(com.example.robottaskboardservice.tasklog.TaskLog.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.robottaskboardservice.tasklog.TaskLogRequest<com.example.robottaskboardservice.tasklog.TaskLog> taskLogsWithMinimalFields(){
      return new com.example.robottaskboardservice.tasklog.TaskLogRequest(com.example.robottaskboardservice.tasklog.TaskLog.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}