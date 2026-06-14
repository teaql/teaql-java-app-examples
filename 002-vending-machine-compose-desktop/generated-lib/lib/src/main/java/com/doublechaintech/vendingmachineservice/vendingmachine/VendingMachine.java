package com.doublechaintech.vendingmachineservice.vendingmachine;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus;
import com.doublechaintech.vendingmachineservice.product.Product;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class VendingMachine extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "VendingMachine";

    public static final String NAME_PROPERTY = "name";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String ORDER_STATUS_LIST_PROPERTY = "orderStatusList";
    public static final String PAYMENT_METHOD_LIST_PROPERTY = "paymentMethodList";
    public static final String PAYMENT_STATUS_LIST_PROPERTY = "paymentStatusList";
    public static final String PRODUCT_LIST_PROPERTY = "productList";
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<OrderStatus> orderStatusList;
    private SmartList<PaymentMethod> paymentMethodList;
    private SmartList<PaymentStatus> paymentStatusList;
    private SmartList<Product> productList;

    public String getName(){
        return this.name;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<OrderStatus> getOrderStatusList(){
        return this.orderStatusList;
    }
    public SmartList<PaymentMethod> getPaymentMethodList(){
        return this.paymentMethodList;
    }
    public SmartList<PaymentStatus> getPaymentStatusList(){
        return this.paymentStatusList;
    }
    public SmartList<Product> getProductList(){
        return this.productList;
    }
    public VendingMachine updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public VendingMachine updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public VendingMachine updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public VendingMachine addOrderStatus(OrderStatus orderStatus){
        if (orderStatus == null){
            return this;
        }

        if(null == this.orderStatusList){
            this.orderStatusList = new SmartList<>();
        }

        this.orderStatusList.add(orderStatus);
        orderStatus.cacheRelation(OrderStatus.VENDING_MACHINE_PROPERTY, this);
        return this;
    }
    public VendingMachine addPaymentMethod(PaymentMethod paymentMethod){
        if (paymentMethod == null){
            return this;
        }

        if(null == this.paymentMethodList){
            this.paymentMethodList = new SmartList<>();
        }

        this.paymentMethodList.add(paymentMethod);
        paymentMethod.cacheRelation(PaymentMethod.VENDING_MACHINE_PROPERTY, this);
        return this;
    }
    public VendingMachine addPaymentStatus(PaymentStatus paymentStatus){
        if (paymentStatus == null){
            return this;
        }

        if(null == this.paymentStatusList){
            this.paymentStatusList = new SmartList<>();
        }

        this.paymentStatusList.add(paymentStatus);
        paymentStatus.cacheRelation(PaymentStatus.VENDING_MACHINE_PROPERTY, this);
        return this;
    }
    public VendingMachine addProduct(Product product){
        if (product == null){
            return this;
        }

        if(null == this.productList){
            this.productList = new SmartList<>();
        }

        this.productList.add(product);
        product.cacheRelation(Product.VENDING_MACHINE_PROPERTY, this);
        return this;
    }

    public static VendingMachine refer(Long id){
        VendingMachine refer = new VendingMachine();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public VendingMachine comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = StrUtil.trim((String) value); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "orderStatusList": this.orderStatusList = (SmartList<OrderStatus>) value; break;
            case "paymentMethodList": this.paymentMethodList = (SmartList<PaymentMethod>) value; break;
            case "paymentStatusList": this.paymentStatusList = (SmartList<PaymentStatus>) value; break;
            case "productList": this.productList = (SmartList<Product>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "orderStatusList": return this.orderStatusList;
            case "paymentMethodList": return this.paymentMethodList;
            case "paymentStatusList": return this.paymentStatusList;
            case "productList": return this.productList;
            default: return super.internalGet(property);
        }
    }

}