package com.example.vendingmachineservice.orderstatus;

import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineChecker;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorder.VendingOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class OrderStatusChecker implements Checker<OrderStatus>{

    public String type(){
        return OrderStatus.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, OrderStatus orderStatus, ObjectLocation _parentLocation){
        if(needCheck(_ctx, orderStatus)){
            markAsChecked(_ctx, orderStatus);
            doCheck(_ctx, orderStatus, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, OrderStatus orderStatus, ObjectLocation _parentLocation){
      if((orderStatus == null)){
         return;
      }
      if(orderStatus.newItem()){
      }else if(orderStatus.updateItem()){
      }
      checkVendingMachine(_ctx, orderStatus.getProperty(OrderStatus.VENDING_MACHINE_PROPERTY), newLocation(_parentLocation, OrderStatus.VENDING_MACHINE_PROPERTY));
      checkName(_ctx, orderStatus.getProperty(OrderStatus.NAME_PROPERTY), newLocation(_parentLocation, OrderStatus.NAME_PROPERTY));
      checkCode(_ctx, orderStatus.getProperty(OrderStatus.CODE_PROPERTY), newLocation(_parentLocation, OrderStatus.CODE_PROPERTY));
      for(int i = 0; orderStatus.getVendingOrderList() != null && i < orderStatus.getVendingOrderList().size(); i++){
         VendingOrder vendingOrder = orderStatus.getVendingOrderList().get(i);
         new VendingOrderChecker().checkAndFix(_ctx, vendingOrder, newLocation(_parentLocation, OrderStatus.VENDING_ORDER_LIST_PROPERTY, i));
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