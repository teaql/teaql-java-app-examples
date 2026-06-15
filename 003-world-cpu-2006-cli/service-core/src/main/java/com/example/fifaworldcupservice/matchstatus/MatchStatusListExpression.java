package com.example.fifaworldcupservice.matchstatus;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MatchStatusListExpression<T, E, U extends MatchStatus> extends SmartListExpression<T, E, U> {
    public MatchStatusListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MatchStatusListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MatchStatusExpression<T, U, U> first() {
       return new MatchStatusExpression(super.first());
    }

    public MatchStatusExpression<T, U, U> get(int index) {
      return new MatchStatusExpression(super.get(index));
    }
}