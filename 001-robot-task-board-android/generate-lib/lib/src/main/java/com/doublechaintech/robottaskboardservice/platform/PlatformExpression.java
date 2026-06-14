package com.doublechaintech.robottaskboardservice.platform;

import com.doublechaintech.robottaskboardservice.task.Task;
import com.doublechaintech.robottaskboardservice.task.TaskListExpression;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus;
import com.doublechaintech.robottaskboardservice.taskstatus.TaskStatusListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PlatformExpression<T, E, U extends Platform> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PlatformExpression(Expression<T, U> expression){
        super(expression);
    }

    public PlatformExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PlatformExpression<T, U, U> updateId(Long id){
        return new PlatformExpression(this, $it -> {((Platform)$it).internalSet("id", id); return this;});
     }

     public PlatformExpression<T, U, U> save(UserContext userContext){
        return new PlatformExpression(this, $it -> ((Platform)$it).auditAs("Saved by Expression").save(userContext));
     }


    public Expression<T, String> getName(){
       return apply(Platform::getName);
    }
    public PlatformExpression<T, U, U> updateName(String name){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateName(name));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Platform::getCreateTime);
    }
    public PlatformExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Platform::getUpdateTime);
    }
    public PlatformExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PlatformExpression(this, $it ->  ((Platform)$it).updateUpdateTime(updateTime));
    }

    public TaskStatusListExpression<T, U, TaskStatus> getTaskStatusList(){
        return new TaskStatusListExpression(this, $it ->  ((Platform)$it).getTaskStatusList());
    }
    public TaskListExpression<T, U, Task> getTaskList(){
        return new TaskListExpression(this, $it ->  ((Platform)$it).getTaskList());
    }
    public PlatformExpression<T, U, U> addTaskStatus(TaskStatus taskStatus){
       return new PlatformExpression(this, $it ->  ((Platform)$it).addTaskStatus(taskStatus));
    }
    public PlatformExpression<T, U, U> addTask(Task task){
       return new PlatformExpression(this, $it ->  ((Platform)$it).addTask(task));
    }
}