package com.doublechaintech.robottaskboardservice.platform;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.robottaskboardservice.task.Task;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class Platform extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Platform";

    public static final String NAME_PROPERTY = "name";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TASK_STATUS_LIST_PROPERTY = "taskStatusList";
    public static final String TASK_LIST_PROPERTY = "taskList";
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<TaskStatus> taskStatusList;
    private SmartList<Task> taskList;

    public String getName(){
        return this.name;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<TaskStatus> getTaskStatusList(){
        return this.taskStatusList;
    }
    public SmartList<Task> getTaskList(){
        return this.taskList;
    }
    public Platform updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Platform updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Platform updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Platform addTaskStatus(TaskStatus taskStatus){
        if (taskStatus == null){
            return this;
        }

        if(null == this.taskStatusList){
            this.taskStatusList = new SmartList<>();
        }

        this.taskStatusList.add(taskStatus);
        taskStatus.cacheRelation(TaskStatus.PLATFORM_PROPERTY, this);
        return this;
    }
    public Platform addTask(Task task){
        if (task == null){
            return this;
        }

        if(null == this.taskList){
            this.taskList = new SmartList<>();
        }

        this.taskList.add(task);
        task.cacheRelation(Task.PLATFORM_PROPERTY, this);
        return this;
    }

    public static Platform refer(Long id){
        Platform refer = new Platform();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Platform comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = StrUtil.trim((String) value); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "taskStatusList": this.taskStatusList = (SmartList<TaskStatus>) value; break;
            case "taskList": this.taskList = (SmartList<Task>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "taskStatusList": return this.taskStatusList;
            case "taskList": return this.taskList;
            default: return super.internalGet(property);
        }
    }

}