package com.doublechaintech.vendingmachineservice.paymentmethod;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class PaymentMethod extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PaymentMethod";

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
    public PaymentMethod updateVendingMachine(VendingMachine vendingMachine){
        if(ObjectUtil.equal(this.vendingMachine, vendingMachine)){
            return this;
        }
        handleUpdate(VENDING_MACHINE_PROPERTY, getVendingMachine(), vendingMachine);
        this.vendingMachine = vendingMachine;
        return this;
    }
    public PaymentMethod updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public PaymentMethod updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public PaymentMethod addOrderPayment(OrderPayment orderPayment){
        if (orderPayment == null){
            return this;
        }

        if(null == this.orderPaymentList){
            this.orderPaymentList = new SmartList<>();
        }

        this.orderPaymentList.add(orderPayment);
        orderPayment.cacheRelation(OrderPayment.PAYMENT_METHOD_PROPERTY, this);
        return this;
    }

    public static PaymentMethod refer(Long id){
        PaymentMethod refer = new PaymentMethod();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PaymentMethod comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "vendingMachine": this.vendingMachine = (VendingMachine) value; break;

            case "name": this.name = StrUtil.trim((String) value); break;

            case "code": this.code = StrUtil.trim((String) value); break;

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