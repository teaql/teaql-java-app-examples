package com.example.vendingmachineservice.paymentstatus;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PaymentStatusListExpression<T, E, U extends PaymentStatus> extends SmartListExpression<T, E, U> {
    public PaymentStatusListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PaymentStatusListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PaymentStatusExpression<T, U, U> first() {
       return new PaymentStatusExpression(super.first());
    }

    public PaymentStatusExpression<T, U, U> get(int index) {
      return new PaymentStatusExpression(super.get(index));
    }
}