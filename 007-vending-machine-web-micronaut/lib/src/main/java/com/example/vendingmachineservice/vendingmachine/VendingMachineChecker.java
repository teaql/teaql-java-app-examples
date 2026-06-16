package com.example.vendingmachineservice.vendingmachine;

import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusChecker;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentmethod.PaymentMethodChecker;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.paymentstatus.PaymentStatusChecker;
import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.product.ProductChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class VendingMachineChecker implements Checker<VendingMachine>{

    public String type(){
        return VendingMachine.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, VendingMachine vendingMachine, ObjectLocation _parentLocation){
        if(needCheck(_ctx, vendingMachine)){
            markAsChecked(_ctx, vendingMachine);
            doCheck(_ctx, vendingMachine, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, VendingMachine vendingMachine, ObjectLocation _parentLocation){
      if((vendingMachine == null)){
         return;
      }
      if(vendingMachine.newItem()){
        if(vendingMachine.getCreateTime() == null){
           vendingMachine.updateCreateTime(java.time.LocalDateTime.now());
        }if(vendingMachine.getUpdateTime() == null){
           vendingMachine.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(vendingMachine.updateItem()){
        vendingMachine.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, vendingMachine.getProperty(VendingMachine.NAME_PROPERTY), newLocation(_parentLocation, VendingMachine.NAME_PROPERTY));
      checkCreateTime(_ctx, vendingMachine.getProperty(VendingMachine.CREATE_TIME_PROPERTY), newLocation(_parentLocation, VendingMachine.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, vendingMachine.getProperty(VendingMachine.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, VendingMachine.UPDATE_TIME_PROPERTY));
      for(int i = 0; vendingMachine.getOrderStatusList() != null && i < vendingMachine.getOrderStatusList().size(); i++){
         OrderStatus orderStatus = vendingMachine.getOrderStatusList().get(i);
         new OrderStatusChecker().checkAndFix(_ctx, orderStatus, newLocation(_parentLocation, VendingMachine.ORDER_STATUS_LIST_PROPERTY, i));
      }
      for(int i = 0; vendingMachine.getPaymentMethodList() != null && i < vendingMachine.getPaymentMethodList().size(); i++){
         PaymentMethod paymentMethod = vendingMachine.getPaymentMethodList().get(i);
         new PaymentMethodChecker().checkAndFix(_ctx, paymentMethod, newLocation(_parentLocation, VendingMachine.PAYMENT_METHOD_LIST_PROPERTY, i));
      }
      for(int i = 0; vendingMachine.getPaymentStatusList() != null && i < vendingMachine.getPaymentStatusList().size(); i++){
         PaymentStatus paymentStatus = vendingMachine.getPaymentStatusList().get(i);
         new PaymentStatusChecker().checkAndFix(_ctx, paymentStatus, newLocation(_parentLocation, VendingMachine.PAYMENT_STATUS_LIST_PROPERTY, i));
      }
      for(int i = 0; vendingMachine.getProductList() != null && i < vendingMachine.getProductList().size(); i++){
         Product product = vendingMachine.getProductList().get(i);
         new ProductChecker().checkAndFix(_ctx, product, newLocation(_parentLocation, VendingMachine.PRODUCT_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

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