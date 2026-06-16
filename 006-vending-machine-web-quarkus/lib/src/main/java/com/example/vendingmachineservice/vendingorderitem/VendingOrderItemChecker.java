package com.example.vendingmachineservice.vendingorderitem;

import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.product.ProductChecker;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorder.VendingOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class VendingOrderItemChecker implements Checker<VendingOrderItem>{

    public String type(){
        return VendingOrderItem.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, VendingOrderItem vendingOrderItem, ObjectLocation _parentLocation){
        if(needCheck(_ctx, vendingOrderItem)){
            markAsChecked(_ctx, vendingOrderItem);
            doCheck(_ctx, vendingOrderItem, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, VendingOrderItem vendingOrderItem, ObjectLocation _parentLocation){
      if((vendingOrderItem == null)){
         return;
      }
      if(vendingOrderItem.newItem()){
        if(vendingOrderItem.getCreateTime() == null){
           vendingOrderItem.updateCreateTime(java.time.LocalDateTime.now());
        }if(vendingOrderItem.getUpdateTime() == null){
           vendingOrderItem.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(vendingOrderItem.updateItem()){
        vendingOrderItem.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, vendingOrderItem.getProperty(VendingOrderItem.NAME_PROPERTY), newLocation(_parentLocation, VendingOrderItem.NAME_PROPERTY));
      checkVendingOrder(_ctx, vendingOrderItem.getProperty(VendingOrderItem.VENDING_ORDER_PROPERTY), newLocation(_parentLocation, VendingOrderItem.VENDING_ORDER_PROPERTY));
      checkProduct(_ctx, vendingOrderItem.getProperty(VendingOrderItem.PRODUCT_PROPERTY), newLocation(_parentLocation, VendingOrderItem.PRODUCT_PROPERTY));
      checkQuantity(_ctx, vendingOrderItem.getProperty(VendingOrderItem.QUANTITY_PROPERTY), newLocation(_parentLocation, VendingOrderItem.QUANTITY_PROPERTY));
      checkPrice(_ctx, vendingOrderItem.getProperty(VendingOrderItem.PRICE_PROPERTY), newLocation(_parentLocation, VendingOrderItem.PRICE_PROPERTY));
      checkAmount(_ctx, vendingOrderItem.getProperty(VendingOrderItem.AMOUNT_PROPERTY), newLocation(_parentLocation, VendingOrderItem.AMOUNT_PROPERTY));
      checkCreateTime(_ctx, vendingOrderItem.getProperty(VendingOrderItem.CREATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrderItem.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, vendingOrderItem.getProperty(VendingOrderItem.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrderItem.UPDATE_TIME_PROPERTY));
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
    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if((product == null)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkQuantity(UserContext _ctx, Integer quantity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, quantity);
    if((quantity == null)){
        return;
    }
    }
    public void checkPrice(UserContext _ctx, Integer price, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, price);
    if((price == null)){
        return;
    }
    }
    public void checkAmount(UserContext _ctx, Integer amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
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