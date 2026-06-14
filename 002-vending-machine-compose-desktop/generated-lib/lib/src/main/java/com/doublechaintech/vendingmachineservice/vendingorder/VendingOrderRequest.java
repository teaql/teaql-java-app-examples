package com.doublechaintech.vendingmachineservice.vendingorder;

import com.doublechaintech.vendingmachineservice.Q;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusRequest;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodRequest;
import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.product.ProductRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class VendingOrderRequest<T extends VendingOrder> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public VendingOrderRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public VendingOrderRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public VendingOrderRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public VendingOrderRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public VendingOrderRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public VendingOrderRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public VendingOrderRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (VendingOrderRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public VendingOrderRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public VendingOrderRequest<T> matchingAnyOf(VendingOrderRequest vendingOrder){
        super.internalMatchAny(vendingOrder);
        return this;
    }

    public VendingOrderRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public VendingOrderRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public VendingOrderRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public VendingOrderRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectTitle().selectProductIdOnly().selectAmount().selectStatusIdOnly().selectPaymentMethodIdOnly().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public VendingOrderRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTitle().selectProduct().selectAmount().selectStatus().selectPaymentMethod().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectTitle().selectProduct().selectAmount().selectStatus().selectPaymentMethod().selectPaymentTime().selectTransactionId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public VendingOrderRequest<T> selectId(){
       selectProperty(VendingOrder.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectId(){
       unselectProperty(VendingOrder.ID_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectTitle(){
       selectProperty(VendingOrder.TITLE_PROPERTY);
       return this;
    }

    /**
     * fill the title with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  title) to fetch title property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectTitle(){
       unselectProperty(VendingOrder.TITLE_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectProductIdOnly(){
       selectProperty(VendingOrder.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public VendingOrderRequest<T> selectProductWith(ProductRequest product){
       selectProperty(VendingOrder.PRODUCT_PROPERTY);
       enhanceRelation(VendingOrder.PRODUCT_PROPERTY, product);
       return this;
    }

    public VendingOrderRequest<T> unselectProduct(){
       unselectProperty(VendingOrder.PRODUCT_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectAmount(){
       selectProperty(VendingOrder.AMOUNT_PROPERTY);
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
    public VendingOrderRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(VendingOrder.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public VendingOrderRequest<T> unselectAmount(){
       unselectProperty(VendingOrder.AMOUNT_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectStatusIdOnly(){
       selectProperty(VendingOrder.STATUS_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> selectStatus(){
        return selectStatusWith(Q.orderStatuses().unlimited().selectSelf());
    }

    public VendingOrderRequest<T> selectStatusWith(OrderStatusRequest status){
       selectProperty(VendingOrder.STATUS_PROPERTY);
       enhanceRelation(VendingOrder.STATUS_PROPERTY, status);
       return this;
    }

    public VendingOrderRequest<T> unselectStatus(){
       unselectProperty(VendingOrder.STATUS_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectPaymentMethodIdOnly(){
       selectProperty(VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> selectPaymentMethod(){
        return selectPaymentMethodWith(Q.paymentMethods().unlimited().selectSelf());
    }

    public VendingOrderRequest<T> selectPaymentMethodWith(PaymentMethodRequest paymentMethod){
       selectProperty(VendingOrder.PAYMENT_METHOD_PROPERTY);
       enhanceRelation(VendingOrder.PAYMENT_METHOD_PROPERTY, paymentMethod);
       return this;
    }

    public VendingOrderRequest<T> unselectPaymentMethod(){
       unselectProperty(VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectPaymentTime(){
       selectProperty(VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the paymentTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  paymentTime) to fetch paymentTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectPaymentTime(){
       unselectProperty(VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectTransactionId(){
       selectProperty(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }

    /**
     * fill the transactionId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  transactionId) to fetch transactionId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectTransactionId(){
       unselectProperty(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectCreateTime(){
       selectProperty(VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectCreateTime(){
       unselectProperty(VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectUpdateTime(){
       selectProperty(VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectUpdateTime(){
       unselectProperty(VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> selectVersion(){
       selectProperty(VendingOrder.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderRequest<T> unselectVersion(){
       unselectProperty(VendingOrder.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.ID_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public VendingOrderRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public VendingOrderRequest<T> filterByTitle(String... title){
      if (title == null || title.length == 0) {
        throw new IllegalArgumentException("filterByTitle parameter title cannot be empty");
      }
      return appendSearchCriteria(createTitleCriteria(Operator.EQUAL, (Object[])title));
    }

    public VendingOrderRequest<T> withTitle(Operator operator, Object... values){
       return appendSearchCriteria(createTitleCriteria(operator, values));
    }

    public VendingOrderRequest<T> withTitleIsUnknown(){
       return withTitle(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withTitleIsKnown(){
       return withTitle(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTitleCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.TITLE_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withTitleGreaterThan(String title){
       return withTitle(Operator.GREATER_THAN, title);
    }

    public VendingOrderRequest<T> withTitleGreaterThanOrEqualTo(String title){
       return withTitle(Operator.GREATER_THAN_OR_EQUAL, title);
    }

    public VendingOrderRequest<T> withTitleLessThan(String title){
       return withTitle(Operator.LESS_THAN, title);
    }

    public VendingOrderRequest<T> withTitleLessThanOrEqualTo(String title){
       return withTitle(Operator.LESS_THAN_OR_EQUAL, title);
    }

    public VendingOrderRequest<T> withTitleBetween(String startOfTitle, String endOfTitle){
       return withTitle(Operator.BETWEEN, startOfTitle, endOfTitle);
    }
    public VendingOrderRequest<T> withTitleStartingWith(String title){
       return withTitle(Operator.BEGIN_WITH, title);
    }
    public VendingOrderRequest<T> withTitleContaining(String title){
       return withTitle(Operator.CONTAIN, title);
    }

    public VendingOrderRequest<T> withTitleEndingWith(String title){
       return withTitle(Operator.END_WITH, title);
    }

    public VendingOrderRequest<T> withTitleIs(String title){
       return withTitle(Operator.EQUAL, title);
    }

    public VendingOrderRequest<T> withTitleSoundingLike(String title){
       return withTitle(Operator.SOUNDS_LIKE, title);
    }



    public VendingOrderRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public VendingOrderRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public VendingOrderRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.PRODUCT_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public VendingOrderRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrder.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public VendingOrderRequest<T> filterByAmount(Integer... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public VendingOrderRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public VendingOrderRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.AMOUNT_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withAmountGreaterThan(Integer amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public VendingOrderRequest<T> withAmountGreaterThanOrEqualTo(Integer amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public VendingOrderRequest<T> withAmountLessThan(Integer amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public VendingOrderRequest<T> withAmountLessThanOrEqualTo(Integer amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public VendingOrderRequest<T> withAmountBetween(Integer startOfAmount, Integer endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public VendingOrderRequest<T> filterByStatus(OrderStatus... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public VendingOrderRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public VendingOrderRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.STATUS_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> filterByStatus(Long status){
      if(status == null){
         return this;
      }
      return withStatus(Operator.EQUAL, status);
    }
    public VendingOrderRequest<T> withStatusMatching(OrderStatusRequest status){
       return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrder.STATUS_PROPERTY, status, OrderStatus.ID_PROPERTY));
    }

    public VendingOrderRequest<T> filterByPaymentMethod(PaymentMethod... paymentMethod){
      if (paymentMethod == null || paymentMethod.length == 0) {
        throw new IllegalArgumentException("filterByPaymentMethod parameter paymentMethod cannot be empty");
      }
      return appendSearchCriteria(createPaymentMethodCriteria(Operator.EQUAL, (Object[])paymentMethod));
    }

    public VendingOrderRequest<T> withPaymentMethod(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentMethodCriteria(operator, values));
    }

    public VendingOrderRequest<T> withPaymentMethodIsUnknown(){
       return withPaymentMethod(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withPaymentMethodIsKnown(){
       return withPaymentMethod(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentMethodCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.PAYMENT_METHOD_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> filterByPaymentMethod(Long paymentMethod){
      if(paymentMethod == null){
         return this;
      }
      return withPaymentMethod(Operator.EQUAL, paymentMethod);
    }
    public VendingOrderRequest<T> withPaymentMethodMatching(PaymentMethodRequest paymentMethod){
       return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrder.PAYMENT_METHOD_PROPERTY, paymentMethod, PaymentMethod.ID_PROPERTY));
    }

    public VendingOrderRequest<T> filterByPaymentTime(LocalDateTime... paymentTime){
      if (paymentTime == null || paymentTime.length == 0) {
        throw new IllegalArgumentException("filterByPaymentTime parameter paymentTime cannot be empty");
      }
      return appendSearchCriteria(createPaymentTimeCriteria(Operator.EQUAL, (Object[])paymentTime));
    }

    public VendingOrderRequest<T> withPaymentTime(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentTimeCriteria(operator, values));
    }

    public VendingOrderRequest<T> withPaymentTimeIsUnknown(){
       return withPaymentTime(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withPaymentTimeIsKnown(){
       return withPaymentTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.PAYMENT_TIME_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withPaymentTimeGreaterThan(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeGreaterThanOrEqualTo(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN_OR_EQUAL, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeLessThan(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeLessThanOrEqualTo(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN_OR_EQUAL, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeBetween(LocalDateTime startOfPaymentTime, LocalDateTime endOfPaymentTime){
       return withPaymentTime(Operator.BETWEEN, startOfPaymentTime, endOfPaymentTime);
    }
    public VendingOrderRequest<T> withPaymentTimeBefore(LocalDateTime paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeBefore(Date paymentTime){
       return withPaymentTime(Operator.LESS_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeAfter(LocalDateTime paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeAfter(Date paymentTime){
       return withPaymentTime(Operator.GREATER_THAN, paymentTime);
    }

    public VendingOrderRequest<T> withPaymentTimeBetween(Date startOfPaymentTime, Date endOfPaymentTime){
       return withPaymentTime(Operator.BETWEEN, startOfPaymentTime, endOfPaymentTime);
    }




    public VendingOrderRequest<T> filterByTransactionId(String... transactionId){
      if (transactionId == null || transactionId.length == 0) {
        throw new IllegalArgumentException("filterByTransactionId parameter transactionId cannot be empty");
      }
      return appendSearchCriteria(createTransactionIdCriteria(Operator.EQUAL, (Object[])transactionId));
    }

    public VendingOrderRequest<T> withTransactionId(Operator operator, Object... values){
       return appendSearchCriteria(createTransactionIdCriteria(operator, values));
    }

    public VendingOrderRequest<T> withTransactionIdIsUnknown(){
       return withTransactionId(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withTransactionIdIsKnown(){
       return withTransactionId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTransactionIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.TRANSACTION_ID_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withTransactionIdGreaterThan(String transactionId){
       return withTransactionId(Operator.GREATER_THAN, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdGreaterThanOrEqualTo(String transactionId){
       return withTransactionId(Operator.GREATER_THAN_OR_EQUAL, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdLessThan(String transactionId){
       return withTransactionId(Operator.LESS_THAN, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdLessThanOrEqualTo(String transactionId){
       return withTransactionId(Operator.LESS_THAN_OR_EQUAL, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdBetween(String startOfTransactionId, String endOfTransactionId){
       return withTransactionId(Operator.BETWEEN, startOfTransactionId, endOfTransactionId);
    }
    public VendingOrderRequest<T> withTransactionIdStartingWith(String transactionId){
       return withTransactionId(Operator.BEGIN_WITH, transactionId);
    }
    public VendingOrderRequest<T> withTransactionIdContaining(String transactionId){
       return withTransactionId(Operator.CONTAIN, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdEndingWith(String transactionId){
       return withTransactionId(Operator.END_WITH, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdIs(String transactionId){
       return withTransactionId(Operator.EQUAL, transactionId);
    }

    public VendingOrderRequest<T> withTransactionIdSoundingLike(String transactionId){
       return withTransactionId(Operator.SOUNDS_LIKE, transactionId);
    }



    public VendingOrderRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public VendingOrderRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public VendingOrderRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.CREATE_TIME_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public VendingOrderRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public VendingOrderRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public VendingOrderRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public VendingOrderRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.UPDATE_TIME_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public VendingOrderRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public VendingOrderRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public VendingOrderRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public VendingOrderRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.VERSION_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public VendingOrderRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public VendingOrderRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public VendingOrderRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public VendingOrderRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public VendingOrderRequest<T> count(){
        super.count();
        return this;
    }
    public VendingOrderRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public VendingOrderRequest minAmount(){
        return minAmountAs(prefix("minOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest minAmountAs(String retName){
        super.min(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest maxAmountAs(String retName){
        super.max(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest sumAmountAs(String retName){
        super.sum(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest avgAmountAs(String retName){
        super.avg(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",VendingOrder.AMOUNT_PROPERTY));
    }

    public VendingOrderRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, VendingOrder.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public VendingOrderRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(VendingOrder.PRODUCT_PROPERTY, subRequest);
       return this;
    }


    public VendingOrderRequest<T> groupByStatusWithDetails(){
       return groupByStatusWithDetails(Q.orderStatuses().unlimited());
    }

    public VendingOrderRequest<T> groupByStatusWithDetails(OrderStatusRequest subRequest){
       aggregate(VendingOrder.STATUS_PROPERTY, subRequest);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentMethodWithDetails(){
       return groupByPaymentMethodWithDetails(Q.paymentMethods().unlimited());
    }

    public VendingOrderRequest<T> groupByPaymentMethodWithDetails(PaymentMethodRequest subRequest){
       aggregate(VendingOrder.PAYMENT_METHOD_PROPERTY, subRequest);
       return this;
    }







    public VendingOrderRequest<T> groupById(){
       groupBy(VendingOrder.ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByIdAs(String retName){
       groupBy(retName, VendingOrder.ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.ID_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByTitle(){
       groupBy(VendingOrder.TITLE_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTitleAs(String retName){
       groupBy(retName, VendingOrder.TITLE_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTitleWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.TITLE_PROPERTY, function);
       return this;
    }
    public VendingOrderRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(VendingOrder.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderRequest<T> groupByProduct(){
       groupBy(VendingOrder.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByProductAs(String retName){
       groupBy(retName, VendingOrder.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.PRODUCT_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByAmount(){
       groupBy(VendingOrder.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByAmountAs(String retName){
       groupBy(retName, VendingOrder.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.AMOUNT_PROPERTY, function);
       return this;
    }
    public VendingOrderRequest<T> groupByStatusWith(OrderStatusRequest subRequest){
       groupBy(VendingOrder.STATUS_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderRequest<T> groupByStatus(){
       groupBy(VendingOrder.STATUS_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByStatusAs(String retName){
       groupBy(retName, VendingOrder.STATUS_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.STATUS_PROPERTY, function);
       return this;
    }
    public VendingOrderRequest<T> groupByPaymentMethodWith(PaymentMethodRequest subRequest){
       groupBy(VendingOrder.PAYMENT_METHOD_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderRequest<T> groupByPaymentMethod(){
       groupBy(VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentMethodAs(String retName){
       groupBy(retName, VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentMethodWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.PAYMENT_METHOD_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentTime(){
       groupBy(VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentTimeAs(String retName){
       groupBy(retName, VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByPaymentTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.PAYMENT_TIME_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByTransactionId(){
       groupBy(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTransactionIdAs(String retName){
       groupBy(retName, VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTransactionIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.TRANSACTION_ID_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByCreateTime(){
       groupBy(VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByUpdateTime(){
       groupBy(VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> groupByVersion(){
       groupBy(VendingOrder.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByVersionAs(String retName){
       groupBy(retName, VendingOrder.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.VERSION_PROPERTY, function);
       return this;
    }

    public VendingOrderRequest<T> withStatusIsPending(){
       filterByStatus(com.doublechaintech.vendingmachineservice.Constants.ORDER_STATUS_PENDING);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsPaid(){
       filterByStatus(com.doublechaintech.vendingmachineservice.Constants.ORDER_STATUS_PAID);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsDispensing(){
       filterByStatus(com.doublechaintech.vendingmachineservice.Constants.ORDER_STATUS_DISPENSING);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsCompleted(){
       filterByStatus(com.doublechaintech.vendingmachineservice.Constants.ORDER_STATUS_COMPLETED);
       return this;
    }


    public VendingOrderRequest<T> withPaymentMethodIsWechat(){
       filterByPaymentMethod(com.doublechaintech.vendingmachineservice.Constants.PAYMENT_METHOD_WECHAT);
       return this;
    }


    public VendingOrderRequest<T> withPaymentMethodIsAlipay(){
       filterByPaymentMethod(com.doublechaintech.vendingmachineservice.Constants.PAYMENT_METHOD_ALIPAY);
       return this;
    }


    public VendingOrderRequest<T> withPaymentMethodIsCreditCard(){
       filterByPaymentMethod(com.doublechaintech.vendingmachineservice.Constants.PAYMENT_METHOD_CREDIT_CARD);
       return this;
    }




    public VendingOrderRequest<T> orderByIdAscending(){
       addOrderByAscending(VendingOrder.ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByIdDescending(){
       addOrderByDescending(VendingOrder.ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTitleAscending(){
       addOrderByAscending(VendingOrder.TITLE_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTitleDescending(){
       addOrderByDescending(VendingOrder.TITLE_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> orderByTitleAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(VendingOrder.TITLE_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTitleDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(VendingOrder.TITLE_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> orderByProductAscending(){
       addOrderByAscending(VendingOrder.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByProductDescending(){
       addOrderByDescending(VendingOrder.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByAmountAscending(){
       addOrderByAscending(VendingOrder.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByAmountDescending(){
       addOrderByDescending(VendingOrder.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByStatusAscending(){
       addOrderByAscending(VendingOrder.STATUS_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByStatusDescending(){
       addOrderByDescending(VendingOrder.STATUS_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByPaymentMethodAscending(){
       addOrderByAscending(VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByPaymentMethodDescending(){
       addOrderByDescending(VendingOrder.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByPaymentTimeAscending(){
       addOrderByAscending(VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByPaymentTimeDescending(){
       addOrderByDescending(VendingOrder.PAYMENT_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTransactionIdAscending(){
       addOrderByAscending(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTransactionIdDescending(){
       addOrderByDescending(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> orderByTransactionIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTransactionIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(VendingOrder.TRANSACTION_ID_PROPERTY);
       return this;
    }
    public VendingOrderRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(VendingOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(VendingOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByVersionAscending(){
       addOrderByAscending(VendingOrder.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByVersionDescending(){
       addOrderByDescending(VendingOrder.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }


    public OrderStatusRequest rollUpToStatus(){
       OrderStatusRequest status = Q.orderStatuses().unlimited();
       this.withStatusMatching(status)
           .groupByStatusWith(status);
       return status;
    }

    public PaymentMethodRequest rollUpToPaymentMethod(){
       PaymentMethodRequest paymentMethod = Q.paymentMethods().unlimited();
       this.withPaymentMethodMatching(paymentMethod)
           .groupByPaymentMethodWith(paymentMethod);
       return paymentMethod;
    }







   public VendingOrderRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public VendingOrderRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, VendingOrder.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }
   public VendingOrderRequest<T> facetByStatusAs(String facetName, OrderStatusRequest status){
       return facetByStatusAs(facetName, status, true);
   }

   public VendingOrderRequest<T> facetByStatusAs(String facetName, OrderStatusRequest status, boolean includeAllFacets){
       addFacet(facetName, VendingOrder.STATUS_PROPERTY, status, includeAllFacets);
       return this;
   }
   public VendingOrderRequest<T> facetByPaymentMethodAs(String facetName, PaymentMethodRequest paymentMethod){
       return facetByPaymentMethodAs(facetName, paymentMethod, true);
   }

   public VendingOrderRequest<T> facetByPaymentMethodAs(String facetName, PaymentMethodRequest paymentMethod, boolean includeAllFacets){
       addFacet(facetName, VendingOrder.PAYMENT_METHOD_PROPERTY, paymentMethod, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public VendingOrderRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public VendingOrderRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public VendingOrderRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public VendingOrderRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public VendingOrderRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}