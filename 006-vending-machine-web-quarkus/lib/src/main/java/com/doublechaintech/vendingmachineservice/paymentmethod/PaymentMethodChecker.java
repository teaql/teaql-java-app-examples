package com.doublechaintech.vendingmachineservice.paymentmethod;

import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentChecker;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class PaymentMethodChecker implements Checker<PaymentMethod>{

    public String type(){
        return PaymentMethod.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
        if(needCheck(_ctx, paymentMethod)){
            markAsChecked(_ctx, paymentMethod);
            doCheck(_ctx, paymentMethod, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
      if((paymentMethod == null)){
         return;
      }
      if(paymentMethod.newItem()){
      }else if(paymentMethod.updateItem()){
      }
      checkVendingMachine(_ctx, paymentMethod.getProperty(PaymentMethod.VENDING_MACHINE_PROPERTY), newLocation(_parentLocation, PaymentMethod.VENDING_MACHINE_PROPERTY));
      checkName(_ctx, paymentMethod.getProperty(PaymentMethod.NAME_PROPERTY), newLocation(_parentLocation, PaymentMethod.NAME_PROPERTY));
      checkCode(_ctx, paymentMethod.getProperty(PaymentMethod.CODE_PROPERTY), newLocation(_parentLocation, PaymentMethod.CODE_PROPERTY));
      for(int i = 0; paymentMethod.getOrderPaymentList() != null && i < paymentMethod.getOrderPaymentList().size(); i++){
         OrderPayment orderPayment = paymentMethod.getOrderPaymentList().get(i);
         new OrderPaymentChecker().checkAndFix(_ctx, orderPayment, newLocation(_parentLocation, PaymentMethod.ORDER_PAYMENT_LIST_PROPERTY, i));
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