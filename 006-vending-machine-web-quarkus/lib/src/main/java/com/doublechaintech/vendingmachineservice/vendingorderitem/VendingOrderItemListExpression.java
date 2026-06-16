package com.doublechaintech.vendingmachineservice.vendingorderitem;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class VendingOrderItemListExpression<T, E, U extends VendingOrderItem> extends SmartListExpression<T, E, U> {
    public VendingOrderItemListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public VendingOrderItemListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public VendingOrderItemExpression<T, U, U> first() {
       return new VendingOrderItemExpression(super.first());
    }

    public VendingOrderItemExpression<T, U, U> get(int index) {
      return new VendingOrderItemExpression(super.get(index));
    }
}