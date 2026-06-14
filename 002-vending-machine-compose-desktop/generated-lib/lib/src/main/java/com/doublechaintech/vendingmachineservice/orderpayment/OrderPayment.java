package com.doublechaintech.vendingmachineservice.orderpayment;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.vendingmachineservice.Constants;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus;
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
public class OrderPayment extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "OrderPayment";

    public static final String NAME_PROPERTY = "name";
    public static final String VENDING_ORDER_PROPERTY = "vendingOrder";
    public static final String PAYMENT_METHOD_PROPERTY = "paymentMethod";
    public static final String PAYMENT_STATUS_PROPERTY = "paymentStatus";
    public static final String AMOUNT_PROPERTY = "amount";
    public static final String PAYMENT_TIME_PROPERTY = "paymentTime";
    public static final String TRANSACTION_ID_PROPERTY = "transactionId";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String name;
    private VendingOrder vendingOrder;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private Integer amount;
    private LocalDateTime paymentTime;
    private String transactionId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getName(){
        return this.name;
    }
    public VendingOrder getVendingOrder(){
        return this.vendingOrder;
    }
    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }
    public PaymentStatus getPaymentStatus(){
        return this.paymentStatus;
    }
    public Integer getAmount(){
        return this.amount;
    }
    public LocalDateTime getPaymentTime(){
        return this.paymentTime;
    }
    public String getTransactionId(){
        return this.transactionId;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public OrderPayment updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public OrderPayment updateVendingOrder(VendingOrder vendingOrder){
        if(ObjectUtil.equal(this.vendingOrder, vendingOrder)){
            return this;
        }
        handleUpdate(VENDING_ORDER_PROPERTY, getVendingOrder(), vendingOrder);
        this.vendingOrder = vendingOrder;
        return this;
    }
    protected OrderPayment updatePaymentMethod(PaymentMethod paymentMethod){
        if(ObjectUtil.equal(this.paymentMethod, paymentMethod)){
            return this;
        }
        handleUpdate(PAYMENT_METHOD_PROPERTY, getPaymentMethod(), paymentMethod);
        this.paymentMethod = paymentMethod;
        return this;
    }
    protected OrderPayment updatePaymentStatus(PaymentStatus paymentStatus){
        if(ObjectUtil.equal(this.paymentStatus, paymentStatus)){
            return this;
        }
        handleUpdate(PAYMENT_STATUS_PROPERTY, getPaymentStatus(), paymentStatus);
        this.paymentStatus = paymentStatus;
        return this;
    }
    public OrderPayment updateAmount(Integer amount){
        if(ObjectUtil.equal(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public OrderPayment updatePaymentTime(LocalDateTime paymentTime){
        if(ObjectUtil.equal(this.paymentTime, paymentTime)){
            return this;
        }
        handleUpdate(PAYMENT_TIME_PROPERTY, getPaymentTime(), paymentTime);
        this.paymentTime = paymentTime;
        return this;
    }
    public OrderPayment updateTransactionId(String transactionId){
        transactionId = StrUtil.trim(transactionId);
        if(ObjectUtil.equal(this.transactionId, transactionId)){
            return this;
        }
        handleUpdate(TRANSACTION_ID_PROPERTY, getTransactionId(), transactionId);
        this.transactionId = transactionId;
        return this;
    }
    public OrderPayment updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public OrderPayment updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public boolean isPaymentMethodWechat(){
        return ObjectUtil.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_WECHAT);
    }

    public OrderPayment updatePaymentMethodToWechat(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_WECHAT);
    }
    public boolean isPaymentMethodAlipay(){
        return ObjectUtil.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_ALIPAY);
    }

    public OrderPayment updatePaymentMethodToAlipay(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_ALIPAY);
    }
    public boolean isPaymentMethodCreditCard(){
        return ObjectUtil.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_CREDIT_CARD);
    }

    public OrderPayment updatePaymentMethodToCreditCard(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_CREDIT_CARD);
    }
    public boolean isPaymentStatusPending(){
        return ObjectUtil.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_PENDING);
    }

    public OrderPayment updatePaymentStatusToPending(){
        return updatePaymentStatus(Constants.PAYMENT_STATUS_PENDING);
    }
    public boolean isPaymentStatusSuccess(){
        return ObjectUtil.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_SUCCESS);
    }

    public OrderPayment updatePaymentStatusToSuccess(){
        return updatePaymentStatus(Constants.PAYMENT_STATUS_SUCCESS);
    }
    public boolean isPaymentStatusFailed(){
        return ObjectUtil.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_FAILED);
    }

    public OrderPayment updatePaymentStatusToFailed(){
        return updatePaymentStatus(Constants.PAYMENT_STATUS_FAILED);
    }

    public static OrderPayment refer(Long id){
        OrderPayment refer = new OrderPayment();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public OrderPayment comment(String comment){
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

            case "paymentMethod": this.paymentMethod = (PaymentMethod) value; break;

            case "paymentStatus": this.paymentStatus = (PaymentStatus) value; break;

            case "amount": this.amount = (Integer) value; break;

            case "paymentTime": this.paymentTime = (LocalDateTime) value; break;

            case "transactionId": this.transactionId = StrUtil.trim((String) value); break;

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
            case "paymentMethod": return this.paymentMethod;
            case "paymentStatus": return this.paymentStatus;
            case "amount": return this.amount;
            case "paymentTime": return this.paymentTime;
            case "transactionId": return this.transactionId;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.internalGet(property);
        }
    }

}