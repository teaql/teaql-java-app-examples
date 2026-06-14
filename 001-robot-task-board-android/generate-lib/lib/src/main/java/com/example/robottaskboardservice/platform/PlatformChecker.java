package com.example.robottaskboardservice.platform;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskChecker;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.taskstatus.TaskStatusChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class PlatformChecker implements Checker<Platform>{

    public String type(){
        return Platform.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
        if(needCheck(_ctx, platform)){
            markAsChecked(_ctx, platform);
            doCheck(_ctx, platform, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Platform platform, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(platform)){
         return;
      }
      if(platform.newItem()){
        if(platform.getCreateTime() == null){
           platform.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(platform.getUpdateTime() == null){
           platform.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(platform.updateItem()){
        platform.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkName(_ctx, platform.getProperty(Platform.NAME_PROPERTY), newLocation(_parentLocation, Platform.NAME_PROPERTY));
      checkCreateTime(_ctx, platform.getProperty(Platform.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Platform.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, platform.getProperty(Platform.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Platform.UPDATE_TIME_PROPERTY));
      for(int i = 0; platform.getTaskStatusList() != null && i < platform.getTaskStatusList().size(); i++){
         TaskStatus taskStatus = platform.getTaskStatusList().get(i);
         new TaskStatusChecker().checkAndFix(_ctx, taskStatus, newLocation(_parentLocation, Platform.TASK_STATUS_LIST_PROPERTY, i));
      }
      for(int i = 0; platform.getTaskList() != null && i < platform.getTaskList().size(); i++){
         Task task = platform.getTaskList().get(i);
         new TaskChecker().checkAndFix(_ctx, task, newLocation(_parentLocation, Platform.TASK_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if(ObjectUtil.isNull(name)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

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