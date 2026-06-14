package com.doublechaintech.vendingmachineservice.product;

import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineChecker;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class ProductChecker implements Checker<Product>{

    public String type(){
        return Product.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Product product, ObjectLocation _parentLocation){
        if(needCheck(_ctx, product)){
            markAsChecked(_ctx, product);
            doCheck(_ctx, product, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Product product, ObjectLocation _parentLocation){
      if((product == null)){
         return;
      }
      if(product.newItem()){
        if(product.getCreateTime() == null){
           product.updateCreateTime(java.time.LocalDateTime.now());
        }if(product.getUpdateTime() == null){
           product.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(product.updateItem()){
        product.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, product.getProperty(Product.NAME_PROPERTY), newLocation(_parentLocation, Product.NAME_PROPERTY));
      checkPrice(_ctx, product.getProperty(Product.PRICE_PROPERTY), newLocation(_parentLocation, Product.PRICE_PROPERTY));
      checkStock(_ctx, product.getProperty(Product.STOCK_PROPERTY), newLocation(_parentLocation, Product.STOCK_PROPERTY));
      checkImageUrl(_ctx, product.getProperty(Product.IMAGE_URL_PROPERTY), newLocation(_parentLocation, Product.IMAGE_URL_PROPERTY));
      checkVendingMachine(_ctx, product.getProperty(Product.VENDING_MACHINE_PROPERTY), newLocation(_parentLocation, Product.VENDING_MACHINE_PROPERTY));
      checkCreateTime(_ctx, product.getProperty(Product.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Product.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, product.getProperty(Product.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Product.UPDATE_TIME_PROPERTY));
      for(int i = 0; product.getVendingOrderItemList() != null && i < product.getVendingOrderItemList().size(); i++){
         VendingOrderItem vendingOrderItem = product.getVendingOrderItemList().get(i);
         new VendingOrderItemChecker().checkAndFix(_ctx, vendingOrderItem, newLocation(_parentLocation, Product.VENDING_ORDER_ITEM_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPrice(UserContext _ctx, Integer price, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, price);
    if((price == null)){
        return;
    }
    }
    public void checkStock(UserContext _ctx, Integer stock, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, stock);
    if((stock == null)){
        return;
    }
    }
    public void checkImageUrl(UserContext _ctx, String imageUrl, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, imageUrl);
    if((imageUrl == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, imageUrl);

    }
    public void checkVendingMachine(UserContext _ctx, VendingMachine vendingMachine, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, vendingMachine);
    if((vendingMachine == null)){
        return;
    }
    new VendingMachineChecker().checkAndFix(_ctx, vendingMachine, _parentLocation);
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