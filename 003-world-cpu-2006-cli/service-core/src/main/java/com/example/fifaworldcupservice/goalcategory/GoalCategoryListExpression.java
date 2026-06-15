package com.example.fifaworldcupservice.goalcategory;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class GoalCategoryListExpression<T, E, U extends GoalCategory> extends SmartListExpression<T, E, U> {
    public GoalCategoryListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public GoalCategoryListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public GoalCategoryExpression<T, U, U> first() {
       return new GoalCategoryExpression(super.first());
    }

    public GoalCategoryExpression<T, U, U> get(int index) {
      return new GoalCategoryExpression(super.get(index));
    }
}