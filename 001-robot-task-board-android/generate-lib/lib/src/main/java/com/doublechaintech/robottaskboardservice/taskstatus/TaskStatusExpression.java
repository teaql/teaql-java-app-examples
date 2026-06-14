package com.doublechaintech.robottaskboardservice.taskstatus;

import com.doublechaintech.robottaskboardservice.platform.Platform;
import com.doublechaintech.robottaskboardservice.platform.PlatformExpression;
import com.doublechaintech.robottaskboardservice.task.Task;
import com.doublechaintech.robottaskboardservice.task.TaskListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class TaskStatusExpression<T, E, U extends TaskStatus> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TaskStatusExpression(Expression<T, U> expression){
        super(expression);
    }

    public TaskStatusExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TaskStatusExpression<T, U, U> updateId(Long id){
        return new TaskStatusExpression(this, $it -> {((TaskStatus)$it).internalSet("id", id); return this;});
     }

     public TaskStatusExpression<T, U, U> save(UserContext userContext){
        return new TaskStatusExpression(this, $it -> ((TaskStatus)$it).auditAs("Saved by Expression").save(userContext));
     }


    public PlatformExpression<T, U, Platform> getPlatform(){
       return new PlatformExpression(this, $it ->  ((TaskStatus)$it).getPlatform());
    }

    public TaskStatusExpression<T, U, U> updatePlatform(Platform platform){
       return new TaskStatusExpression(this, $it ->  ((TaskStatus)$it).updatePlatform(platform));
    }

    public Expression<T, String> getName(){
       return apply(TaskStatus::getName);
    }
    public TaskStatusExpression<T, U, U> updateName(String name){
       return new TaskStatusExpression(this, $it ->  ((TaskStatus)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(TaskStatus::getCode);
    }
    public TaskStatusExpression<T, U, U> updateCode(String code){
       return new TaskStatusExpression(this, $it ->  ((TaskStatus)$it).updateCode(code));
    }

    public TaskListExpression<T, U, Task> getTaskList(){
        return new TaskListExpression(this, $it ->  ((TaskStatus)$it).getTaskList());
    }
    public TaskStatusExpression<T, U, U> addTask(Task task){
       return new TaskStatusExpression(this, $it ->  ((TaskStatus)$it).addTask(task));
    }
}