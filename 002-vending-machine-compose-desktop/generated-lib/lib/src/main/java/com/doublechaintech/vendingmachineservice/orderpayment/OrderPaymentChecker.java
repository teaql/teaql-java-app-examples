package com.doublechaintech.vendingmachineservice.orderpayment;

import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodChecker;
import com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus;
import com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatusChecker;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class OrderPaymentChecker implements Checker<OrderPayment>{

    public String type(){
        return OrderPayment.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, OrderPayment orderPayment, ObjectLocation _parentLocation){
        if(needCheck(_ctx, orderPayment)){
            markAsChecked(_ctx, orderPayment);
            doCheck(_ctx, orderPayment, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, OrderPayment orderPayment, ObjectLocation _parentLocation){
      if((orderPayment == null)){
         return;
      }
      if(orderPayment.newItem()){
        if(orderPayment.getPaymentTime() == null){
           orderPayment.updatePaymentTime(java.time.LocalDateTime.now());
        }if(orderPayment.getCreateTime() == null){
           orderPayment.updateCreateTime(java.time.LocalDateTime.now());
        }if(orderPayment.getUpdateTime() == null){
           orderPayment.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(orderPayment.updateItem()){
        orderPayment.updatePaymentTime(java.time.LocalDateTime.now());orderPayment.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, orderPayment.getProperty(OrderPayment.NAME_PROPERTY), newLocation(_parentLocation, OrderPayment.NAME_PROPERTY));
      checkVendingOrder(_ctx, orderPayment.getProperty(OrderPayment.VENDING_ORDER_PROPERTY), newLocation(_parentLocation, OrderPayment.VENDING_ORDER_PROPERTY));
      checkPaymentMethod(_ctx, orderPayment.getProperty(OrderPayment.PAYMENT_METHOD_PROPERTY), newLocation(_parentLocation, OrderPayment.PAYMENT_METHOD_PROPERTY));
      checkPaymentStatus(_ctx, orderPayment.getProperty(OrderPayment.PAYMENT_STATUS_PROPERTY), newLocation(_parentLocation, OrderPayment.PAYMENT_STATUS_PROPERTY));
      checkAmount(_ctx, orderPayment.getProperty(OrderPayment.AMOUNT_PROPERTY), newLocation(_parentLocation, OrderPayment.AMOUNT_PROPERTY));
      checkPaymentTime(_ctx, orderPayment.getProperty(OrderPayment.PAYMENT_TIME_PROPERTY), newLocation(_parentLocation, OrderPayment.PAYMENT_TIME_PROPERTY));
      checkTransactionId(_ctx, orderPayment.getProperty(OrderPayment.TRANSACTION_ID_PROPERTY), newLocation(_parentLocation, OrderPayment.TRANSACTION_ID_PROPERTY));
      checkCreateTime(_ctx, orderPayment.getProperty(OrderPayment.CREATE_TIME_PROPERTY), newLocation(_parentLocation, OrderPayment.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, orderPayment.getProperty(OrderPayment.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, OrderPayment.UPDATE_TIME_PROPERTY));
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkVendingOrder(UserContext _ctx, VendingOrder vendingOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, vendingOrder);
    if((vendingOrder == null)){
        return;
    }
    new VendingOrderChecker().checkAndFix(_ctx, vendingOrder, _parentLocation);
    }
    public void checkPaymentMethod(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentMethod);
    if((paymentMethod == null)){
        return;
    }
    new PaymentMethodChecker().checkAndFix(_ctx, paymentMethod, _parentLocation);
    }
    public void checkPaymentStatus(UserContext _ctx, PaymentStatus paymentStatus, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentStatus);
    if((paymentStatus == null)){
        return;
    }
    new PaymentStatusChecker().checkAndFix(_ctx, paymentStatus, _parentLocation);
    }
    public void checkAmount(UserContext _ctx, Integer amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
    }
    public void checkPaymentTime(UserContext _ctx, LocalDateTime paymentTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentTime);
    if((paymentTime == null)){
        return;
    }
    }
    public void checkTransactionId(UserContext _ctx, String transactionId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, transactionId);
    if((transactionId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, transactionId);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}