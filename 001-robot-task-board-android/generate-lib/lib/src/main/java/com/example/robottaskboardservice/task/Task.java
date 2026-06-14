package com.example.robottaskboardservice.task;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.robottaskboardservice.Constants;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.tasklog.TaskLog;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
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
public class Task extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Task";

    public static final String NAME_PROPERTY = "name";
    public static final String PLATFORM_PROPERTY = "platform";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TASK_LOG_LIST_PROPERTY = "taskLogList";
    private String name;
    private Platform platform;
    private TaskStatus status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<TaskLog> taskLogList;

    public String getName(){
        return this.name;
    }
    public Platform getPlatform(){
        return this.platform;
    }
    public TaskStatus getStatus(){
        return this.status;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<TaskLog> getTaskLogList(){
        return this.taskLogList;
    }
    public Task updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Task updatePlatform(Platform platform){
        if(ObjectUtil.equal(this.platform, platform)){
            return this;
        }
        handleUpdate(PLATFORM_PROPERTY, getPlatform(), platform);
        this.platform = platform;
        return this;
    }
    protected Task updateStatus(TaskStatus status){
        if(ObjectUtil.equal(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Task updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Task updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Task addTaskLog(TaskLog taskLog){
        if (taskLog == null){
            return this;
        }

        if(null == this.taskLogList){
            this.taskLogList = new SmartList<>();
        }

        this.taskLogList.add(taskLog);
        taskLog.cacheRelation(TaskLog.TASK_PROPERTY, this);
        return this;
    }
    public boolean isStatusTodo(){
        return ObjectUtil.equals(getStatus(), Constants.TASK_STATUS_TODO);
    }

    public Task updateStatusToTodo(){
        return updateStatus(Constants.TASK_STATUS_TODO);
    }
    public boolean isStatusInProgress(){
        return ObjectUtil.equals(getStatus(), Constants.TASK_STATUS_IN_PROGRESS);
    }

    public Task updateStatusToInProgress(){
        return updateStatus(Constants.TASK_STATUS_IN_PROGRESS);
    }
    public boolean isStatusDone(){
        return ObjectUtil.equals(getStatus(), Constants.TASK_STATUS_DONE);
    }

    public Task updateStatusToDone(){
        return updateStatus(Constants.TASK_STATUS_DONE);
    }

    public static Task refer(Long id){
        Task refer = new Task();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Task comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = StrUtil.trim((String) value); break;

            case "platform": this.platform = (Platform) value; break;

            case "status": this.status = (TaskStatus) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "taskLogList": this.taskLogList = (SmartList<TaskLog>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "platform": return this.platform;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "taskLogList": return this.taskLogList;
            default: return super.internalGet(property);
        }
    }

}