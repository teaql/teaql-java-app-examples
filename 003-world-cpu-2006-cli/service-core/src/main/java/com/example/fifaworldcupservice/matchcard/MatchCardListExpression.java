package com.example.fifaworldcupservice.matchcard;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MatchCardListExpression<T, E, U extends MatchCard> extends SmartListExpression<T, E, U> {
    public MatchCardListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MatchCardListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MatchCardExpression<T, U, U> first() {
       return new MatchCardExpression(super.first());
    }

    public MatchCardExpression<T, U, U> get(int index) {
      return new MatchCardExpression(super.get(index));
    }
}