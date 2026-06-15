package com.doublechaintech.vendingmachineservice.paymentstatus;

import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class PaymentStatus extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PaymentStatus";

    public static final String VENDING_MACHINE_PROPERTY = "vendingMachine";
    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String ORDER_PAYMENT_LIST_PROPERTY = "orderPaymentList";
    private VendingMachine vendingMachine;
    private String name;
    private String code;
    private SmartList<OrderPayment> orderPaymentList;

    public VendingMachine getVendingMachine(){
        return this.vendingMachine;
    }
    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public SmartList<OrderPayment> getOrderPaymentList(){
        return this.orderPaymentList;
    }
    public PaymentStatus updateVendingMachine(VendingMachine vendingMachine){
        if(Objects.equals(this.vendingMachine, vendingMachine)){
            return this;
        }
        handleUpdate(VENDING_MACHINE_PROPERTY, getVendingMachine(), vendingMachine);
        this.vendingMachine = vendingMachine;
        return this;
    }
    public PaymentStatus updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public PaymentStatus updateCode(String code){
        code = (code == null ? null : code.trim());
        if(Objects.equals(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public PaymentStatus addOrderPayment(OrderPayment orderPayment){
        if (orderPayment == null){
            return this;
        }

        if(null == this.orderPaymentList){
            this.orderPaymentList = new SmartList<>();
        }

        this.orderPaymentList.add(orderPayment);
        orderPayment.cacheRelation(OrderPayment.PAYMENT_STATUS_PROPERTY, this);
        return this;
    }

    public static PaymentStatus refer(Long id){
        PaymentStatus refer = new PaymentStatus();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PaymentStatus comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PaymentStatus> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "vendingMachine": this.vendingMachine = (VendingMachine) value; break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "code": this.code = (value == null ? null : ((String)value).trim()); break;

            case "orderPaymentList": this.orderPaymentList = (SmartList<OrderPayment>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "vendingMachine": return this.vendingMachine;
            case "name": return this.name;
            case "code": return this.code;
            case "orderPaymentList": return this.orderPaymentList;
            default: return super.internalGet(property);
        }
    }

}