package com.example.robottaskboardservice.tasklog;

import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TaskLogExpression<T, E, U extends TaskLog> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TaskLogExpression(Expression<T, U> expression){
        super(expression);
    }

    public TaskLogExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TaskLogExpression<T, U, U> updateId(Long id){
        return new TaskLogExpression(this, $it -> {((TaskLog)$it).internalSet("id", id); return this;});
     }

     public TaskLogExpression<T, U, U> save(UserContext userContext){
        return new TaskLogExpression(this, $it -> ((TaskLog)$it).auditAs("Saved by Expression").save(userContext));
     }


    public Expression<T, String> getQuery(){
       return apply(TaskLog::getQuery);
    }
    public TaskLogExpression<T, U, U> updateQuery(String query){
       return new TaskLogExpression(this, $it ->  ((TaskLog)$it).updateQuery(query));
    }

    public Expression<T, String> getCreatedBy(){
       return apply(TaskLog::getCreatedBy);
    }
    public TaskLogExpression<T, U, U> updateCreatedBy(String createdBy){
       return new TaskLogExpression(this, $it ->  ((TaskLog)$it).updateCreatedBy(createdBy));
    }

    public TaskExpression<T, U, Task> getTask(){
       return new TaskExpression(this, $it ->  ((TaskLog)$it).getTask());
    }

    public TaskLogExpression<T, U, U> updateTask(Task task){
       return new TaskLogExpression(this, $it ->  ((TaskLog)$it).updateTask(task));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(TaskLog::getCreateTime);
    }
    public TaskLogExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TaskLogExpression(this, $it ->  ((TaskLog)$it).updateCreateTime(createTime));
    }

}