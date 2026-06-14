package com.doublechaintech.robottaskboardservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusRequest<com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus> taskStatuses(){
      return new com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusRequest(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusRequest<com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus> taskStatusesWithMinimalFields(){
      return new com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusRequest(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.robottaskboardservice.platform.PlatformRequest<com.doublechaintech.robottaskboardservice.platform.Platform> platforms(){
      return new com.doublechaintech.robottaskboardservice.platform.PlatformRequest(com.doublechaintech.robottaskboardservice.platform.Platform.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.robottaskboardservice.platform.PlatformRequest<com.doublechaintech.robottaskboardservice.platform.Platform> platformsWithMinimalFields(){
      return new com.doublechaintech.robottaskboardservice.platform.PlatformRequest(com.doublechaintech.robottaskboardservice.platform.Platform.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.robottaskboardservice.task.TaskRequest<com.doublechaintech.robottaskboardservice.task.Task> tasks(){
      return new com.doublechaintech.robottaskboardservice.task.TaskRequest(com.doublechaintech.robottaskboardservice.task.Task.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.robottaskboardservice.task.TaskRequest<com.doublechaintech.robottaskboardservice.task.Task> tasksWithMinimalFields(){
      return new com.doublechaintech.robottaskboardservice.task.TaskRequest(com.doublechaintech.robottaskboardservice.task.Task.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.robottaskboardservice.tasklog.TaskLogRequest<com.doublechaintech.robottaskboardservice.tasklog.TaskLog> taskLogs(){
      return new com.doublechaintech.robottaskboardservice.tasklog.TaskLogRequest(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.robottaskboardservice.tasklog.TaskLogRequest<com.doublechaintech.robottaskboardservice.tasklog.TaskLog> taskLogsWithMinimalFields(){
      return new com.doublechaintech.robottaskboardservice.tasklog.TaskLogRequest(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}