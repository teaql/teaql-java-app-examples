package com.example.fifaworldcupservice.matchgroup;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MatchGroupListExpression<T, E, U extends MatchGroup> extends SmartListExpression<T, E, U> {
    public MatchGroupListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MatchGroupListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MatchGroupExpression<T, U, U> first() {
       return new MatchGroupExpression(super.first());
    }

    public MatchGroupExpression<T, U, U> get(int index) {
      return new MatchGroupExpression(super.get(index));
    }
}