package com.doublechaintech.vendingmachineservice.orderpayment;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class OrderPaymentListExpression<T, E, U extends OrderPayment> extends SmartListExpression<T, E, U> {
    public OrderPaymentListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public OrderPaymentListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public OrderPaymentExpression<T, U, U> first() {
       return new OrderPaymentExpression(super.first());
    }

    public OrderPaymentExpression<T, U, U> get(int index) {
      return new OrderPaymentExpression(super.get(index));
    }
}