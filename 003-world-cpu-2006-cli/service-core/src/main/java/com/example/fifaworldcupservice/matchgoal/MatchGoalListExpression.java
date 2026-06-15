package com.example.fifaworldcupservice.matchgoal;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class MatchGoalListExpression<T, E, U extends MatchGoal> extends SmartListExpression<T, E, U> {
    public MatchGoalListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public MatchGoalListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public MatchGoalExpression<T, U, U> first() {
       return new MatchGoalExpression(super.first());
    }

    public MatchGoalExpression<T, U, U> get(int index) {
      return new MatchGoalExpression(super.get(index));
    }
}