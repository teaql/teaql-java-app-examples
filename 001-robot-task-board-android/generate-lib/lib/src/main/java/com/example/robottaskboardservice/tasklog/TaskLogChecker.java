package com.example.robottaskboardservice.tasklog;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class TaskLogChecker implements Checker<TaskLog>{

    public String type(){
        return TaskLog.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TaskLog taskLog, ObjectLocation _parentLocation){
        if(needCheck(_ctx, taskLog)){
            markAsChecked(_ctx, taskLog);
            doCheck(_ctx, taskLog, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TaskLog taskLog, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(taskLog)){
         return;
      }
      if(taskLog.newItem()){
        if(taskLog.getCreateTime() == null){
           taskLog.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(taskLog.updateItem()){
      }
      checkQuery(_ctx, taskLog.getProperty(TaskLog.QUERY_PROPERTY), newLocation(_parentLocation, TaskLog.QUERY_PROPERTY));
      checkCreatedBy(_ctx, taskLog.getProperty(TaskLog.CREATED_BY_PROPERTY), newLocation(_parentLocation, TaskLog.CREATED_BY_PROPERTY));
      checkTask(_ctx, taskLog.getProperty(TaskLog.TASK_PROPERTY), newLocation(_parentLocation, TaskLog.TASK_PROPERTY));
      checkCreateTime(_ctx, taskLog.getProperty(TaskLog.CREATE_TIME_PROPERTY), newLocation(_parentLocation, TaskLog.CREATE_TIME_PROPERTY));
    }

    public void checkQuery(UserContext _ctx, String query, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, query);
    if(ObjectUtil.isNull(query)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, query);

    }
    public void checkCreatedBy(UserContext _ctx, String createdBy, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdBy);
    if(ObjectUtil.isNull(createdBy)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, createdBy);

    }
    public void checkTask(UserContext _ctx, Task task, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, task);
    if(ObjectUtil.isNull(task)){
        return;
    }
    new TaskChecker().checkAndFix(_ctx, task, _parentLocation);
    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if(ObjectUtil.isNull(createTime)){
        return;
    }
    }
}