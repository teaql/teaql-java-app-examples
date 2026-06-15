package com.example.fifaworldcupservice.groupstanding;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class GroupStandingListExpression<T, E, U extends GroupStanding> extends SmartListExpression<T, E, U> {
    public GroupStandingListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public GroupStandingListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public GroupStandingExpression<T, U, U> first() {
       return new GroupStandingExpression(super.first());
    }

    public GroupStandingExpression<T, U, U> get(int index) {
      return new GroupStandingExpression(super.get(index));
    }
}