package com.doublechaintech.vendingmachineservice.paymentstatus;

import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentChecker;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class PaymentStatusChecker implements Checker<PaymentStatus>{

    public String type(){
        return PaymentStatus.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PaymentStatus paymentStatus, ObjectLocation _parentLocation){
        if(needCheck(_ctx, paymentStatus)){
            markAsChecked(_ctx, paymentStatus);
            doCheck(_ctx, paymentStatus, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PaymentStatus paymentStatus, ObjectLocation _parentLocation){
      if((paymentStatus == null)){
         return;
      }
      if(paymentStatus.newItem()){
      }else if(paymentStatus.updateItem()){
      }
      checkVendingMachine(_ctx, paymentStatus.getProperty(PaymentStatus.VENDING_MACHINE_PROPERTY), newLocation(_parentLocation, PaymentStatus.VENDING_MACHINE_PROPERTY));
      checkName(_ctx, paymentStatus.getProperty(PaymentStatus.NAME_PROPERTY), newLocation(_parentLocation, PaymentStatus.NAME_PROPERTY));
      checkCode(_ctx, paymentStatus.getProperty(PaymentStatus.CODE_PROPERTY), newLocation(_parentLocation, PaymentStatus.CODE_PROPERTY));
      for(int i = 0; paymentStatus.getOrderPaymentList() != null && i < paymentStatus.getOrderPaymentList().size(); i++){
         OrderPayment orderPayment = paymentStatus.getOrderPaymentList().get(i);
         new OrderPaymentChecker().checkAndFix(_ctx, orderPayment, newLocation(_parentLocation, PaymentStatus.ORDER_PAYMENT_LIST_PROPERTY, i));
      }
    }

    public void checkVendingMachine(UserContext _ctx, VendingMachine vendingMachine, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, vendingMachine);
    if((vendingMachine == null)){
        return;
    }
    new VendingMachineChecker().checkAndFix(_ctx, vendingMachine, _parentLocation);
    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkCode(UserContext _ctx, String code, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, code);
    if((code == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, code);

    }
}