package com.example.vendingmachineservice.paymentmethod;

import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentListExpression;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class PaymentMethodExpression<T, E, U extends PaymentMethod> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentMethodExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentMethodExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentMethodExpression<T, U, U> updateId(Long id){
        return new PaymentMethodExpression(this, $it -> {((PaymentMethod)$it).internalSet("id", id); return this;});
     }

     public PaymentMethodExpression<T, U, U> save(UserContext userContext){
        return new PaymentMethodExpression(this, $it -> ((PaymentMethod)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentMethodExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentMethodExpression(this, $it -> ((PaymentMethod)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public VendingMachineExpression<T, U, VendingMachine> getVendingMachine(){
       return new VendingMachineExpression(this, $it ->  ((PaymentMethod)$it).getVendingMachine());
    }

    public PaymentMethodExpression<T, U, U> updateVendingMachine(VendingMachine vendingMachine){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateVendingMachine(vendingMachine));
    }

    public Expression<T, String> getName(){
       return apply(PaymentMethod::getName);
    }
    public PaymentMethodExpression<T, U, U> updateName(String name){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(PaymentMethod::getCode);
    }
    public PaymentMethodExpression<T, U, U> updateCode(String code){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateCode(code));
    }

    public OrderPaymentListExpression<T, U, OrderPayment> getOrderPaymentList(){
        return new OrderPaymentListExpression(this, $it ->  ((PaymentMethod)$it).getOrderPaymentList());
    }
    public PaymentMethodExpression<T, U, U> addOrderPayment(OrderPayment orderPayment){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).addOrderPayment(orderPayment));
    }
}