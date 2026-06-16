package com.example.vendingmachineservice.vendingmachine;

import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusListExpression;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentmethod.PaymentMethodListExpression;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.paymentstatus.PaymentStatusListExpression;
import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.product.ProductListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class VendingMachineExpression<T, E, U extends VendingMachine> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public VendingMachineExpression(Expression<T, U> expression){
        super(expression);
    }

    public VendingMachineExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public VendingMachineExpression<T, U, U> updateId(Long id){
        return new VendingMachineExpression(this, $it -> {((VendingMachine)$it).internalSet("id", id); return this;});
     }

     public VendingMachineExpression<T, U, U> save(UserContext userContext){
        return new VendingMachineExpression(this, $it -> ((VendingMachine)$it).auditAs("Saved by Expression").save(userContext));
     }

     public VendingMachineExpression<T, U, U> save(String intent, UserContext userContext){
        return new VendingMachineExpression(this, $it -> ((VendingMachine)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(VendingMachine::getName);
    }
    public VendingMachineExpression<T, U, U> updateName(String name){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).updateName(name));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(VendingMachine::getCreateTime);
    }
    public VendingMachineExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(VendingMachine::getUpdateTime);
    }
    public VendingMachineExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).updateUpdateTime(updateTime));
    }

    public OrderStatusListExpression<T, U, OrderStatus> getOrderStatusList(){
        return new OrderStatusListExpression(this, $it ->  ((VendingMachine)$it).getOrderStatusList());
    }
    public PaymentMethodListExpression<T, U, PaymentMethod> getPaymentMethodList(){
        return new PaymentMethodListExpression(this, $it ->  ((VendingMachine)$it).getPaymentMethodList());
    }
    public PaymentStatusListExpression<T, U, PaymentStatus> getPaymentStatusList(){
        return new PaymentStatusListExpression(this, $it ->  ((VendingMachine)$it).getPaymentStatusList());
    }
    public ProductListExpression<T, U, Product> getProductList(){
        return new ProductListExpression(this, $it ->  ((VendingMachine)$it).getProductList());
    }
    public VendingMachineExpression<T, U, U> addOrderStatus(OrderStatus orderStatus){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).addOrderStatus(orderStatus));
    }
    public VendingMachineExpression<T, U, U> addPaymentMethod(PaymentMethod paymentMethod){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).addPaymentMethod(paymentMethod));
    }
    public VendingMachineExpression<T, U, U> addPaymentStatus(PaymentStatus paymentStatus){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).addPaymentStatus(paymentStatus));
    }
    public VendingMachineExpression<T, U, U> addProduct(Product product){
       return new VendingMachineExpression(this, $it ->  ((VendingMachine)$it).addProduct(product));
    }
}