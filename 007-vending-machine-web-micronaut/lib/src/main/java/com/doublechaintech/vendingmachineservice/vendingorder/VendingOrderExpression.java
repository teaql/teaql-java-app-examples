package com.doublechaintech.vendingmachineservice.vendingorder;

import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentListExpression;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusExpression;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class VendingOrderExpression<T, E, U extends VendingOrder> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public VendingOrderExpression(Expression<T, U> expression){
        super(expression);
    }

    public VendingOrderExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public VendingOrderExpression<T, U, U> updateId(Long id){
        return new VendingOrderExpression(this, $it -> {((VendingOrder)$it).internalSet("id", id); return this;});
     }

     public VendingOrderExpression<T, U, U> save(UserContext userContext){
        return new VendingOrderExpression(this, $it -> ((VendingOrder)$it).auditAs("Saved by Expression").save(userContext));
     }

     public VendingOrderExpression<T, U, U> save(String intent, UserContext userContext){
        return new VendingOrderExpression(this, $it -> ((VendingOrder)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getTitle(){
       return apply(VendingOrder::getTitle);
    }
    public VendingOrderExpression<T, U, U> updateTitle(String title){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateTitle(title));
    }

    public Expression<T, Integer> getTotalAmount(){
       return apply(VendingOrder::getTotalAmount);
    }
    public VendingOrderExpression<T, U, U> updateTotalAmount(Integer totalAmount){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateTotalAmount(totalAmount));
    }

    public OrderStatusExpression<T, U, OrderStatus> getStatus(){
       return new OrderStatusExpression(this, $it ->  ((VendingOrder)$it).getStatus());
    }

    public VendingOrderExpression<T, U, U> updateStatusToPending(){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateStatusToPending());
    }
    public VendingOrderExpression<T, U, U> updateStatusToPaid(){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateStatusToPaid());
    }
    public VendingOrderExpression<T, U, U> updateStatusToDispensing(){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateStatusToDispensing());
    }
    public VendingOrderExpression<T, U, U> updateStatusToCompleted(){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateStatusToCompleted());
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(VendingOrder::getCreateTime);
    }
    public VendingOrderExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(VendingOrder::getUpdateTime);
    }
    public VendingOrderExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).updateUpdateTime(updateTime));
    }

    public OrderPaymentListExpression<T, U, OrderPayment> getOrderPaymentList(){
        return new OrderPaymentListExpression(this, $it ->  ((VendingOrder)$it).getOrderPaymentList());
    }
    public VendingOrderItemListExpression<T, U, VendingOrderItem> getVendingOrderItemList(){
        return new VendingOrderItemListExpression(this, $it ->  ((VendingOrder)$it).getVendingOrderItemList());
    }
    public VendingOrderExpression<T, U, U> addOrderPayment(OrderPayment orderPayment){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).addOrderPayment(orderPayment));
    }
    public VendingOrderExpression<T, U, U> addVendingOrderItem(VendingOrderItem vendingOrderItem){
       return new VendingOrderExpression(this, $it ->  ((VendingOrder)$it).addVendingOrderItem(vendingOrderItem));
    }
}