package com.example.vendingmachineservice.orderstatus;

import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineExpression;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorder.VendingOrderListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class OrderStatusExpression<T, E, U extends OrderStatus> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public OrderStatusExpression(Expression<T, U> expression){
        super(expression);
    }

    public OrderStatusExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public OrderStatusExpression<T, U, U> updateId(Long id){
        return new OrderStatusExpression(this, $it -> {((OrderStatus)$it).internalSet("id", id); return this;});
     }

     public OrderStatusExpression<T, U, U> save(UserContext userContext){
        return new OrderStatusExpression(this, $it -> ((OrderStatus)$it).auditAs("Saved by Expression").save(userContext));
     }

     public OrderStatusExpression<T, U, U> save(String intent, UserContext userContext){
        return new OrderStatusExpression(this, $it -> ((OrderStatus)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public VendingMachineExpression<T, U, VendingMachine> getVendingMachine(){
       return new VendingMachineExpression(this, $it ->  ((OrderStatus)$it).getVendingMachine());
    }

    public OrderStatusExpression<T, U, U> updateVendingMachine(VendingMachine vendingMachine){
       return new OrderStatusExpression(this, $it ->  ((OrderStatus)$it).updateVendingMachine(vendingMachine));
    }

    public Expression<T, String> getName(){
       return apply(OrderStatus::getName);
    }
    public OrderStatusExpression<T, U, U> updateName(String name){
       return new OrderStatusExpression(this, $it ->  ((OrderStatus)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(OrderStatus::getCode);
    }
    public OrderStatusExpression<T, U, U> updateCode(String code){
       return new OrderStatusExpression(this, $it ->  ((OrderStatus)$it).updateCode(code));
    }

    public VendingOrderListExpression<T, U, VendingOrder> getVendingOrderList(){
        return new VendingOrderListExpression(this, $it ->  ((OrderStatus)$it).getVendingOrderList());
    }
    public OrderStatusExpression<T, U, U> addVendingOrder(VendingOrder vendingOrder){
       return new OrderStatusExpression(this, $it ->  ((OrderStatus)$it).addVendingOrder(vendingOrder));
    }
}