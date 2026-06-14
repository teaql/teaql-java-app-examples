package com.doublechaintech.robottaskboardservice.taskstatus;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TaskStatusListExpression<T, E, U extends TaskStatus> extends SmartListExpression<T, E, U> {
    public TaskStatusListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TaskStatusListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TaskStatusExpression<T, U, U> first() {
       return new TaskStatusExpression(super.first());
    }

    public TaskStatusExpression<T, U, U> get(int index) {
      return new TaskStatusExpression(super.get(index));
    }
}