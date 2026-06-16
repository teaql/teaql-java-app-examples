package com.example.vendingmachineservice.vendingorder;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class VendingOrderListExpression<T, E, U extends VendingOrder> extends SmartListExpression<T, E, U> {
    public VendingOrderListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public VendingOrderListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public VendingOrderExpression<T, U, U> first() {
       return new VendingOrderExpression(super.first());
    }

    public VendingOrderExpression<T, U, U> get(int index) {
      return new VendingOrderExpression(super.get(index));
    }
}