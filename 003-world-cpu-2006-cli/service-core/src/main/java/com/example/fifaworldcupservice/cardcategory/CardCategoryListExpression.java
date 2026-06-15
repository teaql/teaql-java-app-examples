package com.example.fifaworldcupservice.cardcategory;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class CardCategoryListExpression<T, E, U extends CardCategory> extends SmartListExpression<T, E, U> {
    public CardCategoryListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public CardCategoryListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public CardCategoryExpression<T, U, U> first() {
       return new CardCategoryExpression(super.first());
    }

    public CardCategoryExpression<T, U, U> get(int index) {
      return new CardCategoryExpression(super.get(index));
    }
}