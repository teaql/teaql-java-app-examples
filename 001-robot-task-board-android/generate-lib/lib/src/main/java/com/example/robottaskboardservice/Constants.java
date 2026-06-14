package com.example.robottaskboardservice;

import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.taskstatus.TaskStatus;

public interface Constants  {
  public static final long PLATFORM_ID = 1l;
  public static final Platform PLATFORM = Platform.refer(PLATFORM_ID);
  public static final long TASK_STATUS_TODO_ID = 1001l ;
  public static final TaskStatus TASK_STATUS_TODO = TaskStatus.refer(TASK_STATUS_TODO_ID);public static final long TASK_STATUS_IN_PROGRESS_ID = 1002l ;
  public static final TaskStatus TASK_STATUS_IN_PROGRESS = TaskStatus.refer(TASK_STATUS_IN_PROGRESS_ID);public static final long TASK_STATUS_DONE_ID = 1003l ;
  public static final TaskStatus TASK_STATUS_DONE = TaskStatus.refer(TASK_STATUS_DONE_ID);
}