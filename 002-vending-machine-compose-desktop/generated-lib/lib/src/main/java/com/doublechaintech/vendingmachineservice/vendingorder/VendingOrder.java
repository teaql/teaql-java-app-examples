package com.doublechaintech.vendingmachineservice.vendingorder;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.vendingmachineservice.Constants;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem;
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
public class VendingOrder extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "VendingOrder";

    public static final String TITLE_PROPERTY = "title";
    public static final String TOTAL_AMOUNT_PROPERTY = "totalAmount";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String ORDER_PAYMENT_LIST_PROPERTY = "orderPaymentList";
    public static final String VENDING_ORDER_ITEM_LIST_PROPERTY = "vendingOrderItemList";
    private String title;
    private Integer totalAmount;
    private OrderStatus status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<OrderPayment> orderPaymentList;
    private SmartList<VendingOrderItem> vendingOrderItemList;

    public String getTitle(){
        return this.title;
    }
    public Integer getTotalAmount(){
        return this.totalAmount;
    }
    public OrderStatus getStatus(){
        return this.status;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<OrderPayment> getOrderPaymentList(){
        return this.orderPaymentList;
    }
    public SmartList<VendingOrderItem> getVendingOrderItemList(){
        return this.vendingOrderItemList;
    }
    public VendingOrder updateTitle(String title){
        title = StrUtil.trim(title);
        if(ObjectUtil.equal(this.title, title)){
            return this;
        }
        handleUpdate(TITLE_PROPERTY, getTitle(), title);
        this.title = title;
        return this;
    }
    public VendingOrder updateTotalAmount(Integer totalAmount){
        if(ObjectUtil.equal(this.totalAmount, totalAmount)){
            return this;
        }
        handleUpdate(TOTAL_AMOUNT_PROPERTY, getTotalAmount(), totalAmount);
        this.totalAmount = totalAmount;
        return this;
    }
    protected VendingOrder updateStatus(OrderStatus status){
        if(ObjectUtil.equal(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public VendingOrder updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public VendingOrder updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public VendingOrder addOrderPayment(OrderPayment orderPayment){
        if (orderPayment == null){
            return this;
        }

        if(null == this.orderPaymentList){
            this.orderPaymentList = new SmartList<>();
        }

        this.orderPaymentList.add(orderPayment);
        orderPayment.cacheRelation(OrderPayment.VENDING_ORDER_PROPERTY, this);
        return this;
    }
    public VendingOrder addVendingOrderItem(VendingOrderItem vendingOrderItem){
        if (vendingOrderItem == null){
            return this;
        }

        if(null == this.vendingOrderItemList){
            this.vendingOrderItemList = new SmartList<>();
        }

        this.vendingOrderItemList.add(vendingOrderItem);
        vendingOrderItem.cacheRelation(VendingOrderItem.VENDING_ORDER_PROPERTY, this);
        return this;
    }
    public boolean isStatusPending(){
        return ObjectUtil.equals(getStatus(), Constants.ORDER_STATUS_PENDING);
    }

    public VendingOrder updateStatusToPending(){
        return updateStatus(Constants.ORDER_STATUS_PENDING);
    }
    public boolean isStatusPaid(){
        return ObjectUtil.equals(getStatus(), Constants.ORDER_STATUS_PAID);
    }

    public VendingOrder updateStatusToPaid(){
        return updateStatus(Constants.ORDER_STATUS_PAID);
    }
    public boolean isStatusDispensing(){
        return ObjectUtil.equals(getStatus(), Constants.ORDER_STATUS_DISPENSING);
    }

    public VendingOrder updateStatusToDispensing(){
        return updateStatus(Constants.ORDER_STATUS_DISPENSING);
    }
    public boolean isStatusCompleted(){
        return ObjectUtil.equals(getStatus(), Constants.ORDER_STATUS_COMPLETED);
    }

    public VendingOrder updateStatusToCompleted(){
        return updateStatus(Constants.ORDER_STATUS_COMPLETED);
    }

    public static VendingOrder refer(Long id){
        VendingOrder refer = new VendingOrder();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public VendingOrder comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "title": this.title = StrUtil.trim((String) value); break;

            case "totalAmount": this.totalAmount = (Integer) value; break;

            case "status": this.status = (OrderStatus) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "orderPaymentList": this.orderPaymentList = (SmartList<OrderPayment>) value; break;
            case "vendingOrderItemList": this.vendingOrderItemList = (SmartList<VendingOrderItem>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "title": return this.title;
            case "totalAmount": return this.totalAmount;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "orderPaymentList": return this.orderPaymentList;
            case "vendingOrderItemList": return this.vendingOrderItemList;
            default: return super.internalGet(property);
        }
    }

}