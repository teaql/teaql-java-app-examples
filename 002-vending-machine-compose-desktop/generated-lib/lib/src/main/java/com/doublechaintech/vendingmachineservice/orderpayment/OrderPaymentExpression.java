package com.doublechaintech.vendingmachineservice.orderpayment;

import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodExpression;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class OrderPaymentExpression<T, E, U extends OrderPayment> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public OrderPaymentExpression(Expression<T, U> expression){
        super(expression);
    }

    public OrderPaymentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public OrderPaymentExpression<T, U, U> updateId(Long id){
        return new OrderPaymentExpression(this, $it -> {((OrderPayment)$it).internalSet("id", id); return this;});
     }

     public OrderPaymentExpression<T, U, U> save(UserContext userContext){
        return new OrderPaymentExpression(this, $it -> ((OrderPayment)$it).auditAs("Saved by Expression").save(userContext));
     }

     public OrderPaymentExpression<T, U, U> save(String intent, UserContext userContext){
        return new OrderPaymentExpression(this, $it -> ((OrderPayment)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(OrderPayment::getName);
    }
    public OrderPaymentExpression<T, U, U> updateName(String name){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateName(name));
    }

    public VendingOrderExpression<T, U, VendingOrder> getVendingOrder(){
       return new VendingOrderExpression(this, $it ->  ((OrderPayment)$it).getVendingOrder());
    }

    public OrderPaymentExpression<T, U, U> updateVendingOrder(VendingOrder vendingOrder){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateVendingOrder(vendingOrder));
    }

    public PaymentMethodExpression<T, U, PaymentMethod> getPaymentMethod(){
       return new PaymentMethodExpression(this, $it ->  ((OrderPayment)$it).getPaymentMethod());
    }

    public OrderPaymentExpression<T, U, U> updatePaymentMethodToWechat(){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updatePaymentMethodToWechat());
    }
    public OrderPaymentExpression<T, U, U> updatePaymentMethodToAlipay(){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updatePaymentMethodToAlipay());
    }
    public OrderPaymentExpression<T, U, U> updatePaymentMethodToCreditCard(){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updatePaymentMethodToCreditCard());
    }

    public Expression<T, Integer> getAmount(){
       return apply(OrderPayment::getAmount);
    }
    public OrderPaymentExpression<T, U, U> updateAmount(Integer amount){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateAmount(amount));
    }

    public Expression<T, LocalDateTime> getPaymentTime(){
       return apply(OrderPayment::getPaymentTime);
    }
    public OrderPaymentExpression<T, U, U> updatePaymentTime(LocalDateTime paymentTime){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updatePaymentTime(paymentTime));
    }

    public Expression<T, String> getTransactionId(){
       return apply(OrderPayment::getTransactionId);
    }
    public OrderPaymentExpression<T, U, U> updateTransactionId(String transactionId){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateTransactionId(transactionId));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(OrderPayment::getCreateTime);
    }
    public OrderPaymentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(OrderPayment::getUpdateTime);
    }
    public OrderPaymentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new OrderPaymentExpression(this, $it ->  ((OrderPayment)$it).updateUpdateTime(updateTime));
    }

}