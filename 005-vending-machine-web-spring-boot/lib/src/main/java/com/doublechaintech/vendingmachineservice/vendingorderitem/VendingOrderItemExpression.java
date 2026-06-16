package com.doublechaintech.vendingmachineservice.vendingorderitem;

import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.product.ProductExpression;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class VendingOrderItemExpression<T, E, U extends VendingOrderItem> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public VendingOrderItemExpression(Expression<T, U> expression){
        super(expression);
    }

    public VendingOrderItemExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public VendingOrderItemExpression<T, U, U> updateId(Long id){
        return new VendingOrderItemExpression(this, $it -> {((VendingOrderItem)$it).internalSet("id", id); return this;});
     }

     public VendingOrderItemExpression<T, U, U> save(UserContext userContext){
        return new VendingOrderItemExpression(this, $it -> ((VendingOrderItem)$it).auditAs("Saved by Expression").save(userContext));
     }

     public VendingOrderItemExpression<T, U, U> save(String intent, UserContext userContext){
        return new VendingOrderItemExpression(this, $it -> ((VendingOrderItem)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(VendingOrderItem::getName);
    }
    public VendingOrderItemExpression<T, U, U> updateName(String name){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateName(name));
    }

    public VendingOrderExpression<T, U, VendingOrder> getVendingOrder(){
       return new VendingOrderExpression(this, $it ->  ((VendingOrderItem)$it).getVendingOrder());
    }

    public VendingOrderItemExpression<T, U, U> updateVendingOrder(VendingOrder vendingOrder){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateVendingOrder(vendingOrder));
    }

    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((VendingOrderItem)$it).getProduct());
    }

    public VendingOrderItemExpression<T, U, U> updateProduct(Product product){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateProduct(product));
    }

    public Expression<T, Integer> getQuantity(){
       return apply(VendingOrderItem::getQuantity);
    }
    public VendingOrderItemExpression<T, U, U> updateQuantity(Integer quantity){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateQuantity(quantity));
    }

    public Expression<T, Integer> getPrice(){
       return apply(VendingOrderItem::getPrice);
    }
    public VendingOrderItemExpression<T, U, U> updatePrice(Integer price){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updatePrice(price));
    }

    public Expression<T, Integer> getAmount(){
       return apply(VendingOrderItem::getAmount);
    }
    public VendingOrderItemExpression<T, U, U> updateAmount(Integer amount){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateAmount(amount));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(VendingOrderItem::getCreateTime);
    }
    public VendingOrderItemExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(VendingOrderItem::getUpdateTime);
    }
    public VendingOrderItemExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new VendingOrderItemExpression(this, $it ->  ((VendingOrderItem)$it).updateUpdateTime(updateTime));
    }

}