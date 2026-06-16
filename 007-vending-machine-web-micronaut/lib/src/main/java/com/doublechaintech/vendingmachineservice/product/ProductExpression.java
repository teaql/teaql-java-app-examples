package com.doublechaintech.vendingmachineservice.product;

import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineExpression;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ProductExpression<T, E, U extends Product> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ProductExpression(Expression<T, U> expression){
        super(expression);
    }

    public ProductExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ProductExpression<T, U, U> updateId(Long id){
        return new ProductExpression(this, $it -> {((Product)$it).internalSet("id", id); return this;});
     }

     public ProductExpression<T, U, U> save(UserContext userContext){
        return new ProductExpression(this, $it -> ((Product)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ProductExpression<T, U, U> save(String intent, UserContext userContext){
        return new ProductExpression(this, $it -> ((Product)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Product::getName);
    }
    public ProductExpression<T, U, U> updateName(String name){
       return new ProductExpression(this, $it ->  ((Product)$it).updateName(name));
    }

    public Expression<T, Integer> getPrice(){
       return apply(Product::getPrice);
    }
    public ProductExpression<T, U, U> updatePrice(Integer price){
       return new ProductExpression(this, $it ->  ((Product)$it).updatePrice(price));
    }

    public Expression<T, Integer> getStock(){
       return apply(Product::getStock);
    }
    public ProductExpression<T, U, U> updateStock(Integer stock){
       return new ProductExpression(this, $it ->  ((Product)$it).updateStock(stock));
    }

    public Expression<T, String> getImageUrl(){
       return apply(Product::getImageUrl);
    }
    public ProductExpression<T, U, U> updateImageUrl(String imageUrl){
       return new ProductExpression(this, $it ->  ((Product)$it).updateImageUrl(imageUrl));
    }

    public VendingMachineExpression<T, U, VendingMachine> getVendingMachine(){
       return new VendingMachineExpression(this, $it ->  ((Product)$it).getVendingMachine());
    }

    public ProductExpression<T, U, U> updateVendingMachine(VendingMachine vendingMachine){
       return new ProductExpression(this, $it ->  ((Product)$it).updateVendingMachine(vendingMachine));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Product::getCreateTime);
    }
    public ProductExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ProductExpression(this, $it ->  ((Product)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Product::getUpdateTime);
    }
    public ProductExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ProductExpression(this, $it ->  ((Product)$it).updateUpdateTime(updateTime));
    }

    public VendingOrderItemListExpression<T, U, VendingOrderItem> getVendingOrderItemList(){
        return new VendingOrderItemListExpression(this, $it ->  ((Product)$it).getVendingOrderItemList());
    }
    public ProductExpression<T, U, U> addVendingOrderItem(VendingOrderItem vendingOrderItem){
       return new ProductExpression(this, $it ->  ((Product)$it).addVendingOrderItem(vendingOrderItem));
    }
}