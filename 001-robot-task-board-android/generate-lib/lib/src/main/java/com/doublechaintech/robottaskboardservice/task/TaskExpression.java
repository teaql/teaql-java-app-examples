package com.doublechaintech.robottaskboardservice.task;

import com.doublechaintech.robottaskboardservice.platform.Platform;
import com.doublechaintech.robottaskboardservice.platform.PlatformExpression;
import com.doublechaintech.robottaskboardservice.tasklog.TaskLog;
import com.doublechaintech.robottaskboardservice.tasklog.TaskLogListExpression;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TaskExpression<T, E, U extends Task> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TaskExpression(Expression<T, U> expression){
        super(expression);
    }

    public TaskExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TaskExpression<T, U, U> updateId(Long id){
        return new TaskExpression(this, $it -> {((Task)$it).internalSet("id", id); return this;});
     }

     public TaskExpression<T, U, U> save(UserContext userContext){
        return new TaskExpression(this, $it -> ((Task)$it).auditAs("Saved by Expression").save(userContext));
     }


    public Expression<T, String> getName(){
       return apply(Task::getName);
    }
    public TaskExpression<T, U, U> updateName(String name){
       return new TaskExpression(this, $it ->  ((Task)$it).updateName(name));
    }

    public PlatformExpression<T, U, Platform> getPlatform(){
       return new PlatformExpression(this, $it ->  ((Task)$it).getPlatform());
    }

    public TaskExpression<T, U, U> updatePlatform(Platform platform){
       return new TaskExpression(this, $it ->  ((Task)$it).updatePlatform(platform));
    }

    public TaskStatusExpression<T, U, TaskStatus> getStatus(){
       return new TaskStatusExpression(this, $it ->  ((Task)$it).getStatus());
    }

    public TaskExpression<T, U, U> updateStatusToTodo(){
       return new TaskExpression(this, $it ->  ((Task)$it).updateStatusToTodo());
    }
    public TaskExpression<T, U, U> updateStatusToInProgress(){
       return new TaskExpression(this, $it ->  ((Task)$it).updateStatusToInProgress());
    }
    public TaskExpression<T, U, U> updateStatusToDone(){
       return new TaskExpression(this, $it ->  ((Task)$it).updateStatusToDone());
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Task::getCreateTime);
    }
    public TaskExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TaskExpression(this, $it ->  ((Task)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Task::getUpdateTime);
    }
    public TaskExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TaskExpression(this, $it ->  ((Task)$it).updateUpdateTime(updateTime));
    }

    public TaskLogListExpression<T, U, TaskLog> getTaskLogList(){
        return new TaskLogListExpression(this, $it ->  ((Task)$it).getTaskLogList());
    }
    public TaskExpression<T, U, U> addTaskLog(TaskLog taskLog){
       return new TaskExpression(this, $it ->  ((Task)$it).addTaskLog(taskLog));
    }
}