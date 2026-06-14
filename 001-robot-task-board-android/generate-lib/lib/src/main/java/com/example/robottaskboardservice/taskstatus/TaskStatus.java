package com.example.robottaskboardservice.taskstatus;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.task.Task;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class TaskStatus extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TaskStatus";

    public static final String PLATFORM_PROPERTY = "platform";
    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String TASK_LIST_PROPERTY = "taskList";
    private Platform platform;
    private String name;
    private String code;
    private SmartList<Task> taskList;

    public Platform getPlatform(){
        return this.platform;
    }
    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public SmartList<Task> getTaskList(){
        return this.taskList;
    }
    public TaskStatus updatePlatform(Platform platform){
        if(ObjectUtil.equal(this.platform, platform)){
            return this;
        }
        handleUpdate(PLATFORM_PROPERTY, getPlatform(), platform);
        this.platform = platform;
        return this;
    }
    public TaskStatus updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public TaskStatus updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public TaskStatus addTask(Task task){
        if (task == null){
            return this;
        }

        if(null == this.taskList){
            this.taskList = new SmartList<>();
        }

        this.taskList.add(task);
        task.cacheRelation(Task.STATUS_PROPERTY, this);
        return this;
    }

    public static TaskStatus refer(Long id){
        TaskStatus refer = new TaskStatus();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TaskStatus comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "platform": this.platform = (Platform) value; break;

            case "name": this.name = StrUtil.trim((String) value); break;

            case "code": this.code = StrUtil.trim((String) value); break;

            case "taskList": this.taskList = (SmartList<Task>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "platform": return this.platform;
            case "name": return this.name;
            case "code": return this.code;
            case "taskList": return this.taskList;
            default: return super.internalGet(property);
        }
    }

}