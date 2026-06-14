package com.doublechaintech.robottaskboardservice.task;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TaskListExpression<T, E, U extends Task> extends SmartListExpression<T, E, U> {
    public TaskListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TaskListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TaskExpression<T, U, U> first() {
       return new TaskExpression(super.first());
    }

    public TaskExpression<T, U, U> get(int index) {
      return new TaskExpression(super.get(index));
    }
}