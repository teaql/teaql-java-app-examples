package com.example.vendingmachineservice.orderpayment;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorder.VendingOrderRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderPaymentRequest<T extends OrderPayment> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public OrderPaymentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public OrderPaymentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public OrderPaymentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public OrderPaymentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public OrderPaymentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public OrderPaymentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public OrderPaymentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (OrderPaymentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public OrderPaymentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public OrderPaymentRequest<T> matchingAnyOf(OrderPaymentRequest orderPayment){
        super.internalMatchAny(orderPayment);
        return this;
    }

    public OrderPaymentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public OrderPaymentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public OrderPaymentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public OrderPaymentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectVendingOrderIdOnly().selectPaymentMethodIdOnly().selectPaymentStatusIdOnly().selectAmount().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OrderPaymentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public OrderPaymentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectVendingOrder().selectPaymentMethod().selectPaymentStatus().selectAmount().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OrderPaymentRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectVendingOrder().selectPaymentMethod().selectPaymentStatus().selectAmount().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public OrderPaymentRequest<T> selectId(){
       selectProperty(OrderPayment.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectId(){
       unselectProperty(OrderPayment.ID_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectName(){
       selectProperty(OrderPayment.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectName(){
       unselectProperty(OrderPayment.NAME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectVendingOrderIdOnly(){
       selectProperty(OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> selectVendingOrder(){
        return selectVendingOrderWith(Q.vendingOrders().unlimited().selectSelf());
    }

    public OrderPaymentRequest<T> selectVendingOrderWith(VendingOrderRequest vendingOrder){
       selectProperty(OrderPayment.VENDING_ORDER_PROPERTY);
       enhanceRelation(OrderPayment.VENDING_ORDER_PROPERTY, vendingOrder);
       return this;
    }

    public OrderPaymentRequest<T> unselectVendingOrder(){
       unselectProperty(OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectPaymentMethodIdOnly(){
       selectProperty(OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> selectPaymentMethod(){
        return selectPaymentMethodWith(Q.paymentMethods().unlimited().selectSelf());
    }

    public OrderPaymentRequest<T> selectPaymentMethodWith(PaymentMethodRequest paymentMethod){
       selectProperty(OrderPayment.PAYMENT_METHOD_PROPERTY);
       enhanceRelation(OrderPayment.PAYMENT_METHOD_PROPERTY, paymentMethod);
       return this;
    }

    public OrderPaymentRequest<T> unselectPaymentMethod(){
       unselectProperty(OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectPaymentStatusIdOnly(){
       selectProperty(OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> selectPaymentStatus(){
        return selectPaymentStatusWith(Q.paymentStatuses().unlimited().selectSelf());
    }

    public OrderPaymentRequest<T> selectPaymentStatusWith(PaymentStatusRequest paymentStatus){
       selectProperty(OrderPayment.PAYMENT_STATUS_PROPERTY);
       enhanceRelation(OrderPayment.PAYMENT_STATUS_PROPERTY, paymentStatus);
       return this;
    }

    public OrderPaymentRequest<T> unselectPaymentStatus(){
       unselectProperty(OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectAmount(){
       selectProperty(OrderPayment.AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the amount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  amount) to fetch amount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the amount with customized aggrFunction, TEAQL uses ({aggrFunction}(amount) AS amount to fetch amount property.
     * @param aggrFunction  aggrFunction
     */
    public OrderPaymentRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(OrderPayment.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public OrderPaymentRequest<T> unselectAmount(){
       unselectProperty(OrderPayment.AMOUNT_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectPaymentTime(){
       selectProperty(OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the paymentTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  paymentTime) to fetch paymentTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectPaymentTime(){
       unselectProperty(OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectTransactionId(){
       selectProperty(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }

    /**
     * fill the transactionId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  transactionId) to fetch transactionId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectTransactionId(){
       unselectProperty(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectCreateTime(){
       selectProperty(OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectCreateTime(){
       unselectProperty(OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectUpdateTime(){
       selectProperty(OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectUpdateTime(){
       unselectProperty(OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> selectVersion(){
       selectProperty(OrderPayment.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderPaymentRequest<T> unselectVersion(){
       unselectProperty(OrderPayment.VERSION_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.ID_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public OrderPaymentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public OrderPaymentRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public OrderPaymentRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.NAME_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public OrderPaymentRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public OrderPaymentRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public OrderPaymentRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public OrderPaymentRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public OrderPaymentRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public OrderPaymentRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public OrderPaymentRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public OrderPaymentRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public OrderPaymentRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public OrderPaymentRequest<T> filterByVendingOrder(VendingOrder... vendingOrder){
      if (vendingOrder == null || vendingOrder.length == 0) {
        throw new IllegalArgumentException("filterByVendingOrder parameter vendingOrder cannot be empty");
      }
      return appendSearchCriteria(createVendingOrderCriteria(Operator.EQUAL, (Object[])vendingOrder));
    }

    public OrderPaymentRequest<T> withVendingOrder(Operator operator, Object... values){
       return appendSearchCriteria(createVendingOrderCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withVendingOrderIsUnknown(){
       return withVendingOrder(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withVendingOrderIsKnown(){
       return withVendingOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.VENDING_ORDER_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> filterByVendingOrder(Long vendingOrder){
      if(vendingOrder == null){
         return this;
      }
      return withVendingOrder(Operator.EQUAL, vendingOrder);
    }
    public OrderPaymentRequest<T> withVendingOrderMatching(VendingOrderRequest vendingOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderPayment.VENDING_ORDER_PROPERTY, vendingOrder, VendingOrder.ID_PROPERTY));
    }

    public OrderPaymentRequest<T> filterByPaymentMethod(PaymentMethod... paymentMethod){
      if (paymentMethod == null || paymentMethod.length == 0) {
        throw new IllegalArgumentException("filterByPaymentMethod parameter paymentMethod cannot be empty");
      }
      return appendSearchCriteria(createPaymentMethodCriteria(Operator.EQUAL, (Object[])paymentMethod));
    }

    public OrderPaymentRequest<T> withPaymentMethod(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentMethodCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withPaymentMethodIsUnknown(){
       return withPaymentMethod(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withPaymentMethodIsKnown(){
       return withPaymentMethod(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentMethodCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.PAYMENT_METHOD_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> filterByPaymentMethod(Long paymentMethod){
      if(paymentMethod == null){
         return this;
      }
      return withPaymentMethod(Operator.EQUAL, paymentMethod);
    }
    public OrderPaymentRequest<T> withPaymentMethodMatching(PaymentMethodRequest paymentMethod){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderPayment.PAYMENT_METHOD_PROPERTY, paymentMethod, PaymentMethod.ID_PROPERTY));
    }

    public OrderPaymentRequest<T> filterByPaymentStatus(PaymentStatus... paymentStatus){
      if (paymentStatus == null || paymentStatus.length == 0) {
        throw new IllegalArgumentException("filterByPaymentStatus parameter paymentStatus cannot be empty");
      }
      return appendSearchCriteria(createPaymentStatusCriteria(Operator.EQUAL, (Object[])paymentStatus));
    }

    public OrderPaymentRequest<T> withPaymentStatus(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentStatusCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withPaymentStatusIsUnknown(){
       return withPaymentStatus(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withPaymentStatusIsKnown(){
       return withPaymentStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.PAYMENT_STATUS_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> filterByPaymentStatus(Long paymentStatus){
      if(paymentStatus == null){
         return this;
      }
      return withPaymentStatus(Operator.EQUAL, paymentStatus);
    }
    public OrderPaymentRequest<T> withPaymentStatusMatching(PaymentStatusRequest paymentStatus){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderPayment.PAYMENT_STATUS_PROPERTY, paymentStatus, PaymentStatus.ID_PROPERTY));
    }

    public OrderPaymentRequest<T> filterByAmount(Integer... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public OrderPaymentRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.AMOUNT_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withAmountGreaterThan(Integer amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public OrderPaymentRequest<T> withAmountGreaterThanOrEqualTo(Integer amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public OrderPaymentRequest<T> withAmountLessThan(Integer amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public OrderPaymentRequest<T> withAmountLessThanOrEqualTo(Integer amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public OrderPaymentRequest<T> withAmountBetween(Integer startOfAmount, Integer endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public OrderPaymentRequest<T> filterByPaymentTime(LocalDateTime... paymentTime){
      if (paymentTime == null || paymentTime.length == 0) {
        throw new IllegalArgumentException("filterByPaymentTime parameter paymentTime cannot be empty");
      }
      return appendSearchCriteria(createPaymentTimeCriteria(Operator.EQUAL, (Object[])paymentTime));
    }

    public OrderPaymentRequest<T> withPaymentTime(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentTimeCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withPaymentTimeIsUnknown(){
       return withPaymentTime(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withPaymentTimeIsKnown(){
       return withPaymentTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.PAYMENT_TIME_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withPaymentTimeGreaterThan(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeGreaterThanOrEqualTo(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN_OR_EQUAL, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeLessThan(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeLessThanOrEqualTo(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN_OR_EQUAL, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeBetween(LocalDateTime startOfPaymentTime, LocalDateTime endOfPaymentTime){
       return withPaymentTime(Operator.BETWEEN, startOfPaymentTime, endOfPaymentTime);
    }
    public OrderPaymentRequest<T> withPaymentTimeBefore(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeBefore(Date paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeAfter(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeAfter(Date paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public OrderPaymentRequest<T> withPaymentTimeBetween(Date startOfPaymentTime, Date endOfPaymentTime){
       return withPaymentTime(Operator.BETWEEN, startOfPaymentTime, endOfPaymentTime);
    }




    public OrderPaymentRequest<T> filterByTransactionId(String... transactionId){
      if (transactionId == null || transactionId.length == 0) {
        throw new IllegalArgumentException("filterByTransactionId parameter transactionId cannot be empty");
      }
      return appendSearchCriteria(createTransactionIdCriteria(Operator.EQUAL, (Object[])transactionId));
    }

    public OrderPaymentRequest<T> withTransactionId(Operator operator, Object... values){
       return appendSearchCriteria(createTransactionIdCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withTransactionIdIsUnknown(){
       return withTransactionId(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withTransactionIdIsKnown(){
       return withTransactionId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTransactionIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.TRANSACTION_ID_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withTransactionIdGreaterThan(String transactionId){
       return withTransactionId(Operator.GREATER_THAN, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdGreaterThanOrEqualTo(String transactionId){
       return withTransactionId(Operator.GREATER_THAN_OR_EQUAL, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdLessThan(String transactionId){
       return withTransactionId(Operator.LESS_THAN, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdLessThanOrEqualTo(String transactionId){
       return withTransactionId(Operator.LESS_THAN_OR_EQUAL, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdBetween(String startOfTransactionId, String endOfTransactionId){
       return withTransactionId(Operator.BETWEEN, startOfTransactionId, endOfTransactionId);
    }
    public OrderPaymentRequest<T> withTransactionIdStartingWith(String transactionId){
       return withTransactionId(Operator.BEGIN_WITH, transactionId);
    }
    public OrderPaymentRequest<T> withTransactionIdContaining(String transactionId){
       return withTransactionId(Operator.CONTAIN, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdEndingWith(String transactionId){
       return withTransactionId(Operator.END_WITH, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdIs(String transactionId){
       return withTransactionId(Operator.EQUAL, transactionId);
    }

    public OrderPaymentRequest<T> withTransactionIdSoundingLike(String transactionId){
       return withTransactionId(Operator.SOUNDS_LIKE, transactionId);
    }



    public OrderPaymentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public OrderPaymentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.CREATE_TIME_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public OrderPaymentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderPaymentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public OrderPaymentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public OrderPaymentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.UPDATE_TIME_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public OrderPaymentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderPaymentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public OrderPaymentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public OrderPaymentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public OrderPaymentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public OrderPaymentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderPayment.VERSION_PROPERTY, operator, values);
    }

    public OrderPaymentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public OrderPaymentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public OrderPaymentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public OrderPaymentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public OrderPaymentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public OrderPaymentRequest<T> count(){
        super.count();
        return this;
    }
    public OrderPaymentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public OrderPaymentRequest minAmount(){
        return minAmountAs(prefix("minOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest minAmountAs(String retName){
        super.min(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest maxAmountAs(String retName){
        super.max(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest sumAmountAs(String retName){
        super.sum(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest avgAmountAs(String retName){
        super.avg(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",OrderPayment.AMOUNT_PROPERTY));
    }

    public OrderPaymentRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, OrderPayment.AMOUNT_PROPERTY);
        return this;
    }
    public OrderPaymentRequest<T> groupByVendingOrderWithDetails(){
       return groupByVendingOrderWithDetails(Q.vendingOrders().unlimited());
    }

    public OrderPaymentRequest<T> groupByVendingOrderWithDetails(VendingOrderRequest subRequest){
       aggregate(OrderPayment.VENDING_ORDER_PROPERTY, subRequest);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentMethodWithDetails(){
       return groupByPaymentMethodWithDetails(Q.paymentMethods().unlimited());
    }

    public OrderPaymentRequest<T> groupByPaymentMethodWithDetails(PaymentMethodRequest subRequest){
       aggregate(OrderPayment.PAYMENT_METHOD_PROPERTY, subRequest);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentStatusWithDetails(){
       return groupByPaymentStatusWithDetails(Q.paymentStatuses().unlimited());
    }

    public OrderPaymentRequest<T> groupByPaymentStatusWithDetails(PaymentStatusRequest subRequest){
       aggregate(OrderPayment.PAYMENT_STATUS_PROPERTY, subRequest);
       return this;
    }








    public OrderPaymentRequest<T> groupById(){
       groupBy(OrderPayment.ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByIdAs(String retName){
       groupBy(retName, OrderPayment.ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.ID_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByName(){
       groupBy(OrderPayment.NAME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByNameAs(String retName){
       groupBy(retName, OrderPayment.NAME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.NAME_PROPERTY, function);
       return this;
    }
    public OrderPaymentRequest<T> groupByVendingOrderWith(VendingOrderRequest subRequest){
       groupBy(OrderPayment.VENDING_ORDER_PROPERTY, subRequest);
       return this;
    }
    public OrderPaymentRequest<T> groupByVendingOrder(){
       groupBy(OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByVendingOrderAs(String retName){
       groupBy(retName, OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByVendingOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.VENDING_ORDER_PROPERTY, function);
       return this;
    }
    public OrderPaymentRequest<T> groupByPaymentMethodWith(PaymentMethodRequest subRequest){
       groupBy(OrderPayment.PAYMENT_METHOD_PROPERTY, subRequest);
       return this;
    }
    public OrderPaymentRequest<T> groupByPaymentMethod(){
       groupBy(OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentMethodAs(String retName){
       groupBy(retName, OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentMethodWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.PAYMENT_METHOD_PROPERTY, function);
       return this;
    }
    public OrderPaymentRequest<T> groupByPaymentStatusWith(PaymentStatusRequest subRequest){
       groupBy(OrderPayment.PAYMENT_STATUS_PROPERTY, subRequest);
       return this;
    }
    public OrderPaymentRequest<T> groupByPaymentStatus(){
       groupBy(OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentStatusAs(String retName){
       groupBy(retName, OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.PAYMENT_STATUS_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByAmount(){
       groupBy(OrderPayment.AMOUNT_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByAmountAs(String retName){
       groupBy(retName, OrderPayment.AMOUNT_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.AMOUNT_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentTime(){
       groupBy(OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentTimeAs(String retName){
       groupBy(retName, OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByPaymentTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.PAYMENT_TIME_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByTransactionId(){
       groupBy(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByTransactionIdAs(String retName){
       groupBy(retName, OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByTransactionIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.TRANSACTION_ID_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByCreateTime(){
       groupBy(OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByUpdateTime(){
       groupBy(OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> groupByVersion(){
       groupBy(OrderPayment.VERSION_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, OrderPayment.VERSION_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderPayment.VERSION_PROPERTY, function);
       return this;
    }

    public OrderPaymentRequest<T> withPaymentMethodIsGooglePay(){
       filterByPaymentMethod(com.example.vendingmachineservice.Constants.PAYMENT_METHOD_GOOGLE_PAY);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentMethodIsApplePay(){
       filterByPaymentMethod(com.example.vendingmachineservice.Constants.PAYMENT_METHOD_APPLE_PAY);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentMethodIsPaypal(){
       filterByPaymentMethod(com.example.vendingmachineservice.Constants.PAYMENT_METHOD_PAYPAL);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentMethodIsCreditCard(){
       filterByPaymentMethod(com.example.vendingmachineservice.Constants.PAYMENT_METHOD_CREDIT_CARD);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentStatusIsPending(){
       filterByPaymentStatus(com.example.vendingmachineservice.Constants.PAYMENT_STATUS_PENDING);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentStatusIsSuccess(){
       filterByPaymentStatus(com.example.vendingmachineservice.Constants.PAYMENT_STATUS_SUCCESS);
       return this;
    }


    public OrderPaymentRequest<T> withPaymentStatusIsFailed(){
       filterByPaymentStatus(com.example.vendingmachineservice.Constants.PAYMENT_STATUS_FAILED);
       return this;
    }




    public OrderPaymentRequest<T> orderByIdAscending(){
       addOrderByAscending(OrderPayment.ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByIdDescending(){
       addOrderByDescending(OrderPayment.ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByNameAscending(){
       addOrderByAscending(OrderPayment.NAME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByNameDescending(){
       addOrderByDescending(OrderPayment.NAME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OrderPayment.NAME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OrderPayment.NAME_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> orderByVendingOrderAscending(){
       addOrderByAscending(OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByVendingOrderDescending(){
       addOrderByDescending(OrderPayment.VENDING_ORDER_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentMethodAscending(){
       addOrderByAscending(OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentMethodDescending(){
       addOrderByDescending(OrderPayment.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentStatusAscending(){
       addOrderByAscending(OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentStatusDescending(){
       addOrderByDescending(OrderPayment.PAYMENT_STATUS_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByAmountAscending(){
       addOrderByAscending(OrderPayment.AMOUNT_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByAmountDescending(){
       addOrderByDescending(OrderPayment.AMOUNT_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentTimeAscending(){
       addOrderByAscending(OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByPaymentTimeDescending(){
       addOrderByDescending(OrderPayment.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByTransactionIdAscending(){
       addOrderByAscending(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByTransactionIdDescending(){
       addOrderByDescending(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> orderByTransactionIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByTransactionIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OrderPayment.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public OrderPaymentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(OrderPayment.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(OrderPayment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByVersionAscending(){
       addOrderByAscending(OrderPayment.VERSION_PROPERTY);
       return this;
    }

    public OrderPaymentRequest<T> orderByVersionDescending(){
       addOrderByDescending(OrderPayment.VERSION_PROPERTY);
       return this;
    }


    public VendingOrderRequest rollUpToVendingOrder(){
       VendingOrderRequest vendingOrder = Q.vendingOrders().unlimited();
       this.withVendingOrderMatching(vendingOrder)
           .groupByVendingOrderWith(vendingOrder);
       return vendingOrder;
    }

    public PaymentMethodRequest rollUpToPaymentMethod(){
       PaymentMethodRequest paymentMethod = Q.paymentMethods().unlimited();
       this.withPaymentMethodMatching(paymentMethod)
           .groupByPaymentMethodWith(paymentMethod);
       return paymentMethod;
    }

    public PaymentStatusRequest rollUpToPaymentStatus(){
       PaymentStatusRequest paymentStatus = Q.paymentStatuses().unlimited();
       this.withPaymentStatusMatching(paymentStatus)
           .groupByPaymentStatusWith(paymentStatus);
       return paymentStatus;
    }








   public OrderPaymentRequest<T> facetByVendingOrderAs(String facetName, VendingOrderRequest vendingOrder){
       return facetByVendingOrderAs(facetName, vendingOrder, true);
   }

   public OrderPaymentRequest<T> facetByVendingOrderAs(String facetName, VendingOrderRequest vendingOrder, boolean includeAllFacets){
       addFacet(facetName, OrderPayment.VENDING_ORDER_PROPERTY, vendingOrder, includeAllFacets);
       return this;
   }
   public OrderPaymentRequest<T> facetByPaymentMethodAs(String facetName, PaymentMethodRequest paymentMethod){
       return facetByPaymentMethodAs(facetName, paymentMethod, true);
   }

   public OrderPaymentRequest<T> facetByPaymentMethodAs(String facetName, PaymentMethodRequest paymentMethod, boolean includeAllFacets){
       addFacet(facetName, OrderPayment.PAYMENT_METHOD_PROPERTY, paymentMethod, includeAllFacets);
       return this;
   }
   public OrderPaymentRequest<T> facetByPaymentStatusAs(String facetName, PaymentStatusRequest paymentStatus){
       return facetByPaymentStatusAs(facetName, paymentStatus, true);
   }

   public OrderPaymentRequest<T> facetByPaymentStatusAs(String facetName, PaymentStatusRequest paymentStatus, boolean includeAllFacets){
       addFacet(facetName, OrderPayment.PAYMENT_STATUS_PROPERTY, paymentStatus, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public OrderPaymentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public OrderPaymentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public OrderPaymentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public OrderPaymentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public OrderPaymentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}