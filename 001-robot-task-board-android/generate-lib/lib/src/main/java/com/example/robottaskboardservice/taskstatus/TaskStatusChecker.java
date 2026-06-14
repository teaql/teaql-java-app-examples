package com.example.robottaskboardservice.taskstatus;

import cn.hutool.core.util.ObjectUtil;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.platform.PlatformChecker;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class TaskStatusChecker implements Checker<TaskStatus>{

    public String type(){
        return TaskStatus.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TaskStatus taskStatus, ObjectLocation _parentLocation){
        if(needCheck(_ctx, taskStatus)){
            markAsChecked(_ctx, taskStatus);
            doCheck(_ctx, taskStatus, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TaskStatus taskStatus, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(taskStatus)){
         return;
      }
      if(taskStatus.newItem()){
      }else if(taskStatus.updateItem()){
      }
      checkPlatform(_ctx, taskStatus.getProperty(TaskStatus.PLATFORM_PROPERTY), newLocation(_parentLocation, TaskStatus.PLATFORM_PROPERTY));
      checkName(_ctx, taskStatus.getProperty(TaskStatus.NAME_PROPERTY), newLocation(_parentLocation, TaskStatus.NAME_PROPERTY));
      checkCode(_ctx, taskStatus.getProperty(TaskStatus.CODE_PROPERTY), newLocation(_parentLocation, TaskStatus.CODE_PROPERTY));
      for(int i = 0; taskStatus.getTaskList() != null && i < taskStatus.getTaskList().size(); i++){
         Task task = taskStatus.getTaskList().get(i);
         new TaskChecker().checkAndFix(_ctx, task, newLocation(_parentLocation, TaskStatus.TASK_LIST_PROPERTY, i));
      }
    }

    public void checkPlatform(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, platform);
    if(ObjectUtil.isNull(platform)){
        return;
    }
    new PlatformChecker().checkAndFix(_ctx, platform, _parentLocation);
    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if(ObjectUtil.isNull(name)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkCode(UserContext _ctx, String code, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, code);
    if(ObjectUtil.isNull(code)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, code);

    }
}