package com.doublechaintech.vendingmachineservice.dataservice;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class DataServiceListExpression<T, E, U extends DataService> extends SmartListExpression<T, E, U> {
    public DataServiceListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public DataServiceListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public DataServiceExpression<T, U, U> first() {
       return new DataServiceExpression(super.first());
    }

    public DataServiceExpression<T, U, U> get(int index) {
      return new DataServiceExpression(super.get(index));
    }
}