package com.example.robottaskboardservice.task;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.platform.PlatformChecker;
import com.example.robottaskboardservice.tasklog.TaskLog;
import com.example.robottaskboardservice.tasklog.TaskLogChecker;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.taskstatus.TaskStatusChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class TaskChecker implements Checker<Task>{

    public String type(){
        return Task.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Task task, ObjectLocation _parentLocation){
        if(needCheck(_ctx, task)){
            markAsChecked(_ctx, task);
            doCheck(_ctx, task, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Task task, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(task)){
         return;
      }
      if(task.newItem()){
        if(task.getCreateTime() == null){
           task.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(task.getUpdateTime() == null){
           task.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(task.updateItem()){
        task.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkName(_ctx, task.getProperty(Task.NAME_PROPERTY), newLocation(_parentLocation, Task.NAME_PROPERTY));
      checkPlatform(_ctx, task.getProperty(Task.PLATFORM_PROPERTY), newLocation(_parentLocation, Task.PLATFORM_PROPERTY));
      checkStatus(_ctx, task.getProperty(Task.STATUS_PROPERTY), newLocation(_parentLocation, Task.STATUS_PROPERTY));
      checkCreateTime(_ctx, task.getProperty(Task.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Task.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, task.getProperty(Task.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Task.UPDATE_TIME_PROPERTY));
      for(int i = 0; task.getTaskLogList() != null && i < task.getTaskLogList().size(); i++){
         TaskLog taskLog = task.getTaskLogList().get(i);
         new TaskLogChecker().checkAndFix(_ctx, taskLog, newLocation(_parentLocation, Task.TASK_LOG_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if(ObjectUtil.isNull(name)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPlatform(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, platform);
    if(ObjectUtil.isNull(platform)){
        return;
    }
    new PlatformChecker().checkAndFix(_ctx, platform, _parentLocation);
    }
    public void checkStatus(UserContext _ctx, TaskStatus status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if(ObjectUtil.isNull(status)){
        return;
    }
    new TaskStatusChecker().checkAndFix(_ctx, status, _parentLocation);
    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if(ObjectUtil.isNull(createTime)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if(ObjectUtil.isNull(updateTime)){
        return;
    }
    }
}