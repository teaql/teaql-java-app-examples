package com.example.vendingmachineservice.vendingmachine;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class VendingMachineListExpression<T, E, U extends VendingMachine> extends SmartListExpression<T, E, U> {
    public VendingMachineListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public VendingMachineListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public VendingMachineExpression<T, U, U> first() {
       return new VendingMachineExpression(super.first());
    }

    public VendingMachineExpression<T, U, U> get(int index) {
      return new VendingMachineExpression(super.get(index));
    }
}