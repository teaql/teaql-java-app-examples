package com.doublechaintech.vendingmachineservice.vendingorder;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusChecker;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodChecker;
import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.product.ProductChecker;
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
      if(ObjectUtil.isNull(vendingOrder)){
         return;
      }
      if(vendingOrder.newItem()){
        if(vendingOrder.getPaymentTime() == null){
           vendingOrder.updatePaymentTime(ReflectUtil.invoke(_ctx, "now"));
        }if(vendingOrder.getCreateTime() == null){
           vendingOrder.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(vendingOrder.getUpdateTime() == null){
           vendingOrder.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(vendingOrder.updateItem()){
        vendingOrder.updatePaymentTime(ReflectUtil.invoke(_ctx, "now"));vendingOrder.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkTitle(_ctx, vendingOrder.getProperty(VendingOrder.TITLE_PROPERTY), newLocation(_parentLocation, VendingOrder.TITLE_PROPERTY));
      checkProduct(_ctx, vendingOrder.getProperty(VendingOrder.PRODUCT_PROPERTY), newLocation(_parentLocation, VendingOrder.PRODUCT_PROPERTY));
      checkAmount(_ctx, vendingOrder.getProperty(VendingOrder.AMOUNT_PROPERTY), newLocation(_parentLocation, VendingOrder.AMOUNT_PROPERTY));
      checkStatus(_ctx, vendingOrder.getProperty(VendingOrder.STATUS_PROPERTY), newLocation(_parentLocation, VendingOrder.STATUS_PROPERTY));
      checkPaymentMethod(_ctx, vendingOrder.getProperty(VendingOrder.PAYMENT_METHOD_PROPERTY), newLocation(_parentLocation, VendingOrder.PAYMENT_METHOD_PROPERTY));
      checkPaymentTime(_ctx, vendingOrder.getProperty(VendingOrder.PAYMENT_TIME_PROPERTY), newLocation(_parentLocation, VendingOrder.PAYMENT_TIME_PROPERTY));
      checkTransactionId(_ctx, vendingOrder.getProperty(VendingOrder.TRANSACTION_ID_PROPERTY), newLocation(_parentLocation, VendingOrder.TRANSACTION_ID_PROPERTY));
      checkCreateTime(_ctx, vendingOrder.getProperty(VendingOrder.CREATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrder.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, vendingOrder.getProperty(VendingOrder.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, VendingOrder.UPDATE_TIME_PROPERTY));
    }

    public void checkTitle(UserContext _ctx, String title, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, title);
    if(ObjectUtil.isNull(title)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, title);

    }
    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if(ObjectUtil.isNull(product)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkAmount(UserContext _ctx, Integer amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if(ObjectUtil.isNull(amount)){
        return;
    }
    }
    public void checkStatus(UserContext _ctx, OrderStatus status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if(ObjectUtil.isNull(status)){
        return;
    }
    new OrderStatusChecker().checkAndFix(_ctx, status, _parentLocation);
    }
    public void checkPaymentMethod(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentMethod);
    if(ObjectUtil.isNull(paymentMethod)){
        return;
    }
    new PaymentMethodChecker().checkAndFix(_ctx, paymentMethod, _parentLocation);
    }
    public void checkPaymentTime(UserContext _ctx, LocalDateTime paymentTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentTime);
    if(ObjectUtil.isNull(paymentTime)){
        return;
    }
    }
    public void checkTransactionId(UserContext _ctx, String transactionId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, transactionId);
    if(ObjectUtil.isNull(transactionId)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, transactionId);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if(ObjectUtil.isNull(createTime)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if(ObjectUtil.isNull(updateTime)){
        return;
    }
    }
}