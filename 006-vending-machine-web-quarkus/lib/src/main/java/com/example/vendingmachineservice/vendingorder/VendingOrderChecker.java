package com.example.vendingmachineservice.vendingorder;

import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentChecker;
import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusChecker;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItemChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class VendingOrderChecker implements Checker<VendingOrder>{

    public String type(){
        return VendingOrder.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, VendingOrder vendingOrder, ObjectLocation _parentLocation){
        if(needCheck(_ctx, vendingOrder)){
            markAsChecked(_ctx, vendingOrder);
            doCheck(_ctx, vendingOrder, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, VendingOrder vendingOrder, ObjectLocation _parentLocation){
      if((vendingOrder == null)){
         return;
      }
      if(vendingOrder.newItem()){
        if(vendingOrder.getCreateTime() == null){
           vendingOrder.updateCreateTime(java.time.LocalDateTime.now());
        }if(vendingOrder.getUpdateTime() == null){
           vendingOrder.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(vendingOrder.updateItem()){
        vendingOrder.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkTitle(_ctx, vendingOrder.getProperty(VendingOrder.TITLE_PROPERTY), newLocation(_parentLocation, VendingOrder.TITLE_PROPERTY));
      checkTotalAmount(_ctx, vendingOrder.getProperty(VendingOrder.TOTAL_AMOUNT_PROPERTY), newLocation(_parentLocation, VendingOrder.TOTAL_AMOUNT_PROPERTY));
      checkStatus(_ctx, vendingOrder.getProperty(VendingOrder.STATUS_PROPERTY), newLocation(_parentLocation, VendingOrder.STATUS_PROPERTY));
      checkCreateTime(_ctx, vendingOrder.getProperty(VendingOrder.CREATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrder.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, vendingOrder.getProperty(VendingOrder.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrder.UPDATE_TIME_PROPERTY));
      for(int i = 0; vendingOrder.getOrderPaymentList() != null && i < vendingOrder.getOrderPaymentList().size(); i++){
         OrderPayment orderPayment = vendingOrder.getOrderPaymentList().get(i);
         new OrderPaymentChecker().checkAndFix(_ctx, orderPayment, newLocation(_parentLocation, VendingOrder.ORDER_PAYMENT_LIST_PROPERTY, i));
      }
      for(int i = 0; vendingOrder.getVendingOrderItemList() != null && i < vendingOrder.getVendingOrderItemList().size(); i++){
         VendingOrderItem vendingOrderItem = vendingOrder.getVendingOrderItemList().get(i);
         new VendingOrderItemChecker().checkAndFix(_ctx, vendingOrderItem, newLocation(_parentLocation, VendingOrder.VENDING_ORDER_ITEM_LIST_PROPERTY, i));
      }
    }

    public void checkTitle(UserContext _ctx, String title, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, title);
    if((title == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, title);

    }
    public void checkTotalAmount(UserContext _ctx, Integer totalAmount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, totalAmount);
    if((totalAmount == null)){
        return;
    }
    }
    public void checkStatus(UserContext _ctx, OrderStatus status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    new OrderStatusChecker().checkAndFix(_ctx, status, _parentLocation);
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