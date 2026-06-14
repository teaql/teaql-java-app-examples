package com.doublechaintech.vendingmachineservice.vendingorderitem;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class VendingOrderItem extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "VendingOrderItem";

    public static final String NAME_PROPERTY = "name";
    public static final String VENDING_ORDER_PROPERTY = "vendingOrder";
    public static final String PRODUCT_PROPERTY = "product";
    public static final String QUANTITY_PROPERTY = "quantity";
    public static final String PRICE_PROPERTY = "price";
    public static final String AMOUNT_PROPERTY = "amount";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String name;
    private VendingOrder vendingOrder;
    private Product product;
    private Integer quantity;
    private Integer price;
    private Integer amount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getName(){
        return this.name;
    }
    public VendingOrder getVendingOrder(){
        return this.vendingOrder;
    }
    public Product getProduct(){
        return this.product;
    }
    public Integer getQuantity(){
        return this.quantity;
    }
    public Integer getPrice(){
        return this.price;
    }
    public Integer getAmount(){
        return this.amount;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public VendingOrderItem updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public VendingOrderItem updateVendingOrder(VendingOrder vendingOrder){
        if(ObjectUtil.equal(this.vendingOrder, vendingOrder)){
            return this;
        }
        handleUpdate(VENDING_ORDER_PROPERTY, getVendingOrder(), vendingOrder);
        this.vendingOrder = vendingOrder;
        return this;
    }
    public VendingOrderItem updateProduct(Product product){
        if(ObjectUtil.equal(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public VendingOrderItem updateQuantity(Integer quantity){
        if(ObjectUtil.equal(this.quantity, quantity)){
            return this;
        }
        handleUpdate(QUANTITY_PROPERTY, getQuantity(), quantity);
        this.quantity = quantity;
        return this;
    }
    public VendingOrderItem updatePrice(Integer price){
        if(ObjectUtil.equal(this.price, price)){
            return this;
        }
        handleUpdate(PRICE_PROPERTY, getPrice(), price);
        this.price = price;
        return this;
    }
    public VendingOrderItem updateAmount(Integer amount){
        if(ObjectUtil.equal(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public VendingOrderItem updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public VendingOrderItem updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static VendingOrderItem refer(Long id){
        VendingOrderItem refer = new VendingOrderItem();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public VendingOrderItem comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = StrUtil.trim((String) value); break;

            case "vendingOrder": this.vendingOrder = (VendingOrder) value; break;

            case "product": this.product = (Product) value; break;

            case "quantity": this.quantity = (Integer) value; break;

            case "price": this.price = (Integer) value; break;

            case "amount": this.amount = (Integer) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "vendingOrder": return this.vendingOrder;
            case "product": return this.product;
            case "quantity": return this.quantity;
            case "price": return this.price;
            case "amount": return this.amount;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.internalGet(property);
        }
    }

}