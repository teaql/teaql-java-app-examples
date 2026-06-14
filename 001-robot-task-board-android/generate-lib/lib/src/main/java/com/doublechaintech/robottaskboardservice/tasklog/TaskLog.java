package com.doublechaintech.robottaskboardservice.tasklog;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.robottaskboardservice.task.Task;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class TaskLog extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TaskLog";

    public static final String QUERY_PROPERTY = "query";
    public static final String CREATED_BY_PROPERTY = "createdBy";
    public static final String TASK_PROPERTY = "task";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    private String query;
    private String createdBy;
    private Task task;
    private LocalDateTime createTime;

    public String getQuery(){
        return this.query;
    }
    public String getCreatedBy(){
        return this.createdBy;
    }
    public Task getTask(){
        return this.task;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public TaskLog updateQuery(String query){
        query = StrUtil.trim(query);
        if(ObjectUtil.equal(this.query, query)){
            return this;
        }
        handleUpdate(QUERY_PROPERTY, getQuery(), query);
        this.query = query;
        return this;
    }
    public TaskLog updateCreatedBy(String createdBy){
        createdBy = StrUtil.trim(createdBy);
        if(ObjectUtil.equal(this.createdBy, createdBy)){
            return this;
        }
        handleUpdate(CREATED_BY_PROPERTY, getCreatedBy(), createdBy);
        this.createdBy = createdBy;
        return this;
    }
    public TaskLog updateTask(Task task){
        if(ObjectUtil.equal(this.task, task)){
            return this;
        }
        handleUpdate(TASK_PROPERTY, getTask(), task);
        this.task = task;
        return this;
    }
    public TaskLog updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }

    public static TaskLog refer(Long id){
        TaskLog refer = new TaskLog();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TaskLog comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "query": this.query = StrUtil.trim((String) value); break;

            case "createdBy": this.createdBy = StrUtil.trim((String) value); break;

            case "task": this.task = (Task) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "query": return this.query;
            case "createdBy": return this.createdBy;
            case "task": return this.task;
            case "createTime": return this.createTime;
            default: return super.internalGet(property);
        }
    }

}