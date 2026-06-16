package com.example.vendingmachineservice.orderpayment;

import com.example.vendingmachineservice.Constants;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.time.LocalDateTime;
import java.util.Objects;

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
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public OrderPayment updateVendingOrder(VendingOrder vendingOrder){
        if(Objects.equals(this.vendingOrder, vendingOrder)){
            return this;
        }
        handleUpdate(VENDING_ORDER_PROPERTY, getVendingOrder(), vendingOrder);
        this.vendingOrder = vendingOrder;
        return this;
    }
    protected OrderPayment updatePaymentMethod(PaymentMethod paymentMethod){
        if(Objects.equals(this.paymentMethod, paymentMethod)){
            return this;
        }
        handleUpdate(PAYMENT_METHOD_PROPERTY, getPaymentMethod(), paymentMethod);
        this.paymentMethod = paymentMethod;
        return this;
    }
    protected OrderPayment updatePaymentStatus(PaymentStatus paymentStatus){
        if(Objects.equals(this.paymentStatus, paymentStatus)){
            return this;
        }
        handleUpdate(PAYMENT_STATUS_PROPERTY, getPaymentStatus(), paymentStatus);
        this.paymentStatus = paymentStatus;
        return this;
    }
    public OrderPayment updateAmount(Integer amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public OrderPayment updatePaymentTime(LocalDateTime paymentTime){
        if(Objects.equals(this.paymentTime, paymentTime)){
            return this;
        }
        handleUpdate(PAYMENT_TIME_PROPERTY, getPaymentTime(), paymentTime);
        this.paymentTime = paymentTime;
        return this;
    }
    public OrderPayment updateTransactionId(String transactionId){
        transactionId = (transactionId == null ? null : transactionId.trim());
        if(Objects.equals(this.transactionId, transactionId)){
            return this;
        }
        handleUpdate(TRANSACTION_ID_PROPERTY, getTransactionId(), transactionId);
        this.transactionId = transactionId;
        return this;
    }
    public OrderPayment updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public OrderPayment updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public boolean isPaymentMethodGooglePay(){
        return Objects.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_GOOGLE_PAY);
    }

    public OrderPayment updatePaymentMethodToGooglePay(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_GOOGLE_PAY);
    }
    public boolean isPaymentMethodApplePay(){
        return Objects.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_APPLE_PAY);
    }

    public OrderPayment updatePaymentMethodToApplePay(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_APPLE_PAY);
    }
    public boolean isPaymentMethodPaypal(){
        return Objects.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_PAYPAL);
    }

    public OrderPayment updatePaymentMethodToPaypal(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_PAYPAL);
    }
    public boolean isPaymentMethodCreditCard(){
        return Objects.equals(getPaymentMethod(), Constants.PAYMENT_METHOD_CREDIT_CARD);
    }

    public OrderPayment updatePaymentMethodToCreditCard(){
        return updatePaymentMethod(Constants.PAYMENT_METHOD_CREDIT_CARD);
    }
    public boolean isPaymentStatusPending(){
        return Objects.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_PENDING);
    }

    public OrderPayment updatePaymentStatusToPending(){
        return updatePaymentStatus(Constants.PAYMENT_STATUS_PENDING);
    }
    public boolean isPaymentStatusSuccess(){
        return Objects.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_SUCCESS);
    }

    public OrderPayment updatePaymentStatusToSuccess(){
        return updatePaymentStatus(Constants.PAYMENT_STATUS_SUCCESS);
    }
    public boolean isPaymentStatusFailed(){
        return Objects.equals(getPaymentStatus(), Constants.PAYMENT_STATUS_FAILED);
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

    @Override
    @SuppressWarnings("unchecked")
    public Audited<OrderPayment> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "vendingOrder": this.vendingOrder = (VendingOrder) value; break;

            case "paymentMethod": this.paymentMethod = (PaymentMethod) value; break;

            case "paymentStatus": this.paymentStatus = (PaymentStatus) value; break;

            case "amount": this.amount = (Integer) value; break;

            case "paymentTime": this.paymentTime = (LocalDateTime) value; break;

            case "transactionId": this.transactionId = (value == null ? null : ((String)value).trim()); break;

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