package com.example.fifaworldcupservice.matchstage;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MatchStageListExpression<T, E, U extends MatchStage> extends SmartListExpression<T, E, U> {
    public MatchStageListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MatchStageListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MatchStageExpression<T, U, U> first() {
       return new MatchStageExpression(super.first());
    }

    public MatchStageExpression<T, U, U> get(int index) {
      return new MatchStageExpression(super.get(index));
    }
}