package com.example.fifaworldcupservice.confederation;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ConfederationListExpression<T, E, U extends Confederation> extends SmartListExpression<T, E, U> {
    public ConfederationListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ConfederationListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ConfederationExpression<T, U, U> first() {
       return new ConfederationExpression(super.first());
    }

    public ConfederationExpression<T, U, U> get(int index) {
      return new ConfederationExpression(super.get(index));
    }
}