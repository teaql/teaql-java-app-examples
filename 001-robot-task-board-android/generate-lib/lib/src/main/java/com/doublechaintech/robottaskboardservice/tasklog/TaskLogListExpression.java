package com.doublechaintech.robottaskboardservice.tasklog;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TaskLogListExpression<T, E, U extends TaskLog> extends SmartListExpression<T, E, U> {
    public TaskLogListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TaskLogListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TaskLogExpression<T, U, U> first() {
       return new TaskLogExpression(super.first());
    }

    public TaskLogExpression<T, U, U> get(int index) {
      return new TaskLogExpression(super.get(index));
    }
}