package com.example.vendingmachineservice.paymentstatus;

import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentListExpression;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class PaymentStatusExpression<T, E, U extends PaymentStatus> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentStatusExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentStatusExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentStatusExpression<T, U, U> updateId(Long id){
        return new PaymentStatusExpression(this, $it -> {((PaymentStatus)$it).internalSet("id", id); return this;});
     }

     public PaymentStatusExpression<T, U, U> save(UserContext userContext){
        return new PaymentStatusExpression(this, $it -> ((PaymentStatus)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentStatusExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentStatusExpression(this, $it -> ((PaymentStatus)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public VendingMachineExpression<T, U, VendingMachine> getVendingMachine(){
       return new VendingMachineExpression(this, $it ->  ((PaymentStatus)$it).getVendingMachine());
    }

    public PaymentStatusExpression<T, U, U> updateVendingMachine(VendingMachine vendingMachine){
       return new PaymentStatusExpression(this, $it ->  ((PaymentStatus)$it).updateVendingMachine(vendingMachine));
    }

    public Expression<T, String> getName(){
       return apply(PaymentStatus::getName);
    }
    public PaymentStatusExpression<T, U, U> updateName(String name){
       return new PaymentStatusExpression(this, $it ->  ((PaymentStatus)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(PaymentStatus::getCode);
    }
    public PaymentStatusExpression<T, U, U> updateCode(String code){
       return new PaymentStatusExpression(this, $it ->  ((PaymentStatus)$it).updateCode(code));
    }

    public OrderPaymentListExpression<T, U, OrderPayment> getOrderPaymentList(){
        return new OrderPaymentListExpression(this, $it ->  ((PaymentStatus)$it).getOrderPaymentList());
    }
    public PaymentStatusExpression<T, U, U> addOrderPayment(OrderPayment orderPayment){
       return new PaymentStatusExpression(this, $it ->  ((PaymentStatus)$it).addOrderPayment(orderPayment));
    }
}