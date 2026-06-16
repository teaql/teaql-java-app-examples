package com.example.vendingmachineservice.vendingorder;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentRequest;
import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusRequest;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItemRequest;
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
        return selectId().selectTitle().selectTotalAmount().selectStatusIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public VendingOrderRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTitle().selectTotalAmount().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderRequest<T> selectChildren(){
        super.selectAny();
        selectOrderPaymentList().selectVendingOrderItemList();
        return selectId().selectTitle().selectTotalAmount().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
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
    public VendingOrderRequest<T> selectTotalAmount(){
       selectProperty(VendingOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the totalAmount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  totalAmount) to fetch totalAmount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the totalAmount with customized aggrFunction, TEAQL uses ({aggrFunction}(totalAmount) AS totalAmount to fetch totalAmount property.
     * @param aggrFunction  aggrFunction
     */
    public VendingOrderRequest<T> selectTotalAmount(AggrFunction aggrFunction){
       selectProperty(VendingOrder.TOTAL_AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public VendingOrderRequest<T> unselectTotalAmount(){
       unselectProperty(VendingOrder.TOTAL_AMOUNT_PROPERTY);
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
    public VendingOrderRequest<T> selectOrderPaymentList(){
       return selectOrderPaymentListWith(Q.orderPayments().selectSelf());
    }

    public VendingOrderRequest<T> selectOrderPaymentListWith(OrderPaymentRequest orderPaymentList){
       enhanceRelation(VendingOrder.ORDER_PAYMENT_LIST_PROPERTY, orderPaymentList);
       return this;
    }
    public VendingOrderRequest<T> selectVendingOrderItemList(){
       return selectVendingOrderItemListWith(Q.vendingOrderItems().selectSelf());
    }

    public VendingOrderRequest<T> selectVendingOrderItemListWith(VendingOrderItemRequest vendingOrderItemList){
       enhanceRelation(VendingOrder.VENDING_ORDER_ITEM_LIST_PROPERTY, vendingOrderItemList);
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



    public VendingOrderRequest<T> filterByTotalAmount(Integer... totalAmount){
      if (totalAmount == null || totalAmount.length == 0) {
        throw new IllegalArgumentException("filterByTotalAmount parameter totalAmount cannot be empty");
      }
      return appendSearchCriteria(createTotalAmountCriteria(Operator.EQUAL, (Object[])totalAmount));
    }

    public VendingOrderRequest<T> withTotalAmount(Operator operator, Object... values){
       return appendSearchCriteria(createTotalAmountCriteria(operator, values));
    }

    public VendingOrderRequest<T> withTotalAmountIsUnknown(){
       return withTotalAmount(Operator.IS_NULL);
    }

    public VendingOrderRequest<T> withTotalAmountIsKnown(){
       return withTotalAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTotalAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrder.TOTAL_AMOUNT_PROPERTY, operator, values);
    }

    public VendingOrderRequest<T> withTotalAmountGreaterThan(Integer totalAmount){
       return withTotalAmount(Operator.GREATER_THAN, totalAmount);
    }

    public VendingOrderRequest<T> withTotalAmountGreaterThanOrEqualTo(Integer totalAmount){
       return withTotalAmount(Operator.GREATER_THAN_OR_EQUAL, totalAmount);
    }

    public VendingOrderRequest<T> withTotalAmountLessThan(Integer totalAmount){
       return withTotalAmount(Operator.LESS_THAN, totalAmount);
    }

    public VendingOrderRequest<T> withTotalAmountLessThanOrEqualTo(Integer totalAmount){
       return withTotalAmount(Operator.LESS_THAN_OR_EQUAL, totalAmount);
    }

    public VendingOrderRequest<T> withTotalAmountBetween(Integer startOfTotalAmount, Integer endOfTotalAmount){
       return withTotalAmount(Operator.BETWEEN, startOfTotalAmount, endOfTotalAmount);
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

    public VendingOrderRequest<T> withOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrder.ID_PROPERTY, orderPaymentRequest, OrderPayment.VENDING_ORDER_PROPERTY));
    }

    public VendingOrderRequest<T> withoutOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingOrder.ID_PROPERTY, orderPaymentRequest, OrderPayment.VENDING_ORDER_PROPERTY)));
    }

    public VendingOrderRequest<T> haveOrderPayments(){
        return withOrderPaymentListMatching(Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> haveNoOrderPayments(){
        return withoutOrderPaymentListMatching(Q.orderPayments().unlimited());
    }
    public VendingOrderRequest<T> withVendingOrderItemListMatching(VendingOrderItemRequest vendingOrderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrder.ID_PROPERTY, vendingOrderItemRequest, VendingOrderItem.VENDING_ORDER_PROPERTY));
    }

    public VendingOrderRequest<T> withoutVendingOrderItemListMatching(VendingOrderItemRequest vendingOrderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingOrder.ID_PROPERTY, vendingOrderItemRequest, VendingOrderItem.VENDING_ORDER_PROPERTY)));
    }

    public VendingOrderRequest<T> haveVendingOrderItems(){
        return withVendingOrderItemListMatching(Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> haveNoVendingOrderItems(){
        return withoutVendingOrderItemListMatching(Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> count(){
        super.count();
        return this;
    }
    public VendingOrderRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public VendingOrderRequest minTotalAmount(){
        return minTotalAmountAs(prefix("minOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest minTotalAmountAs(String retName){
        super.min(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest maxTotalAmount(){
        return maxTotalAmountAs(prefix("maxOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest maxTotalAmountAs(String retName){
        super.max(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest sumTotalAmount(){
        return sumTotalAmountAs(prefix("sumOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest sumTotalAmountAs(String retName){
        super.sum(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest avgTotalAmount(){
        return avgTotalAmountAs(prefix("avgOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest avgTotalAmountAs(String retName){
        super.avg(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest standardDeviationTotalAmount(){
        return standardDeviationTotalAmountAs(prefix("standardDeviationOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest standardDeviationTotalAmountAs(String retName){
        super.standardDeviation(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest squareRootOfPopulationStandardDeviationTotalAmount(){
        return squareRootOfPopulationStandardDeviationTotalAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest squareRootOfPopulationStandardDeviationTotalAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest sampleVarianceTotalAmount(){
        return sampleVarianceTotalAmountAs(prefix("sampleVarianceOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest sampleVarianceTotalAmountAs(String retName){
        super.sampleVariance(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest samplePopulationVarianceTotalAmount(){
        return samplePopulationVarianceTotalAmountAs(prefix("samplePopulationVarianceOf",VendingOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public VendingOrderRequest samplePopulationVarianceTotalAmountAs(String retName){
        super.samplePopulationVariance(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderRequest<T> groupByStatusWithDetails(){
       return groupByStatusWithDetails(Q.orderStatuses().unlimited());
    }

    public VendingOrderRequest<T> groupByStatusWithDetails(OrderStatusRequest subRequest){
       aggregate(VendingOrder.STATUS_PROPERTY, subRequest);
       return this;
    }




    public VendingOrderRequest<T> groupByOrderPaymentsWithDetails(OrderPaymentRequest subRequest){
       aggregate(VendingOrder.ORDER_PAYMENT_LIST_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderRequest<T> groupByVendingOrderItemsWithDetails(VendingOrderItemRequest subRequest){
       aggregate(VendingOrder.VENDING_ORDER_ITEM_LIST_PROPERTY, subRequest);
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

    public VendingOrderRequest<T> groupByTotalAmount(){
       groupBy(VendingOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTotalAmountAs(String retName){
       groupBy(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> groupByTotalAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrder.TOTAL_AMOUNT_PROPERTY, function);
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
       filterByStatus(com.example.vendingmachineservice.Constants.ORDER_STATUS_PENDING);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsPaid(){
       filterByStatus(com.example.vendingmachineservice.Constants.ORDER_STATUS_PAID);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsDispensing(){
       filterByStatus(com.example.vendingmachineservice.Constants.ORDER_STATUS_DISPENSING);
       return this;
    }


    public VendingOrderRequest<T> withStatusIsCompleted(){
       filterByStatus(com.example.vendingmachineservice.Constants.ORDER_STATUS_COMPLETED);
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
    public VendingOrderRequest<T> orderByTotalAmountAscending(){
       addOrderByAscending(VendingOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderRequest<T> orderByTotalAmountDescending(){
       addOrderByDescending(VendingOrder.TOTAL_AMOUNT_PROPERTY);
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


    public VendingOrderRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(name, subRequest, false);
    }

    public VendingOrderRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderPayment.VENDING_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingOrderRequest<T> statsFromOrderPayments(OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(REFINEMENTS, subRequest);
    }
    public VendingOrderRequest<T> statsFromVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
       return statsFromVendingOrderItemsAs(name, subRequest, false);
    }

    public VendingOrderRequest<T> statsFromVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(VendingOrderItem.VENDING_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingOrderRequest<T> statsFromVendingOrderItems(VendingOrderItemRequest subRequest){
       return statsFromVendingOrderItemsAs(REFINEMENTS, subRequest);
    }
    public OrderStatusRequest rollUpToStatus(){
       OrderStatusRequest status = Q.orderStatuses().unlimited();
       this.withStatusMatching(status)
           .groupByStatusWith(status);
       return status;
    }




    public VendingOrderRequest<T> countOrderPayments(){
        return countOrderPaymentsAs("Count");
    }

    public VendingOrderRequest<T> countOrderPaymentsAs(String name){
        return countOrderPaymentsWith(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> countOrderPaymentsWith(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.count(), true);
    }
    public VendingOrderRequest<T> countVendingOrderItems(){
        return countVendingOrderItemsAs("Count");
    }

    public VendingOrderRequest<T> countVendingOrderItemsAs(String name){
        return countVendingOrderItemsWith(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> countVendingOrderItemsWith(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.count(), true);
    }
    public VendingOrderRequest<T> minAmountOfOrderPayments(){
        return minAmountOfOrderPaymentsAs("minAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> minAmountOfOrderPaymentsAs(String name){
        return minAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> minAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.minAmount(), true);
    }
    public VendingOrderRequest<T> maxAmountOfOrderPayments(){
        return maxAmountOfOrderPaymentsAs("maxAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> maxAmountOfOrderPaymentsAs(String name){
        return maxAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> maxAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.maxAmount(), true);
    }
    public VendingOrderRequest<T> sumAmountOfOrderPayments(){
        return sumAmountOfOrderPaymentsAs("sumAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> sumAmountOfOrderPaymentsAs(String name){
        return sumAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> sumAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sumAmount(), true);
    }
    public VendingOrderRequest<T> avgAmountOfOrderPayments(){
        return avgAmountOfOrderPaymentsAs("avgAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> avgAmountOfOrderPaymentsAs(String name){
        return avgAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> avgAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.avgAmount(), true);
    }
    public VendingOrderRequest<T> standardDeviationAmountOfOrderPayments(){
        return standardDeviationAmountOfOrderPaymentsAs("stdDevAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name){
        return standardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPayments(){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs("stdDevPopAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public VendingOrderRequest<T> sampleVarianceAmountOfOrderPayments(){
        return sampleVarianceAmountOfOrderPaymentsAs("varSampAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name){
        return sampleVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public VendingOrderRequest<T> samplePopulationVarianceAmountOfOrderPayments(){
        return samplePopulationVarianceAmountOfOrderPaymentsAs("varPopAmountOfOrderPayments");
    }

    public VendingOrderRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name){
        return samplePopulationVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public VendingOrderRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }
    public VendingOrderRequest<T> minQuantityOfVendingOrderItems(){
        return minQuantityOfVendingOrderItemsAs("minQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> minQuantityOfVendingOrderItemsAs(String name){
        return minQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> minQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public VendingOrderRequest<T> maxQuantityOfVendingOrderItems(){
        return maxQuantityOfVendingOrderItemsAs("maxQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> maxQuantityOfVendingOrderItemsAs(String name){
        return maxQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> maxQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public VendingOrderRequest<T> sumQuantityOfVendingOrderItems(){
        return sumQuantityOfVendingOrderItemsAs("sumQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sumQuantityOfVendingOrderItemsAs(String name){
        return sumQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sumQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public VendingOrderRequest<T> avgQuantityOfVendingOrderItems(){
        return avgQuantityOfVendingOrderItemsAs("avgQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> avgQuantityOfVendingOrderItemsAs(String name){
        return avgQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> avgQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public VendingOrderRequest<T> standardDeviationQuantityOfVendingOrderItems(){
        return standardDeviationQuantityOfVendingOrderItemsAs("stdDevQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> standardDeviationQuantityOfVendingOrderItemsAs(String name){
        return standardDeviationQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> standardDeviationQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs("stdDevPopQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public VendingOrderRequest<T> sampleVarianceQuantityOfVendingOrderItems(){
        return sampleVarianceQuantityOfVendingOrderItemsAs("varSampQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sampleVarianceQuantityOfVendingOrderItemsAs(String name){
        return sampleVarianceQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sampleVarianceQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public VendingOrderRequest<T> samplePopulationVarianceQuantityOfVendingOrderItems(){
        return samplePopulationVarianceQuantityOfVendingOrderItemsAs("varPopQuantityOfVendingOrderItems");
    }

    public VendingOrderRequest<T> samplePopulationVarianceQuantityOfVendingOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> samplePopulationVarianceQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public VendingOrderRequest<T> minPriceOfVendingOrderItems(){
        return minPriceOfVendingOrderItemsAs("minPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> minPriceOfVendingOrderItemsAs(String name){
        return minPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> minPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minPrice(), true);
    }
    public VendingOrderRequest<T> maxPriceOfVendingOrderItems(){
        return maxPriceOfVendingOrderItemsAs("maxPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> maxPriceOfVendingOrderItemsAs(String name){
        return maxPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> maxPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxPrice(), true);
    }
    public VendingOrderRequest<T> sumPriceOfVendingOrderItems(){
        return sumPriceOfVendingOrderItemsAs("sumPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sumPriceOfVendingOrderItemsAs(String name){
        return sumPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sumPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumPrice(), true);
    }
    public VendingOrderRequest<T> avgPriceOfVendingOrderItems(){
        return avgPriceOfVendingOrderItemsAs("avgPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> avgPriceOfVendingOrderItemsAs(String name){
        return avgPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> avgPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgPrice(), true);
    }
    public VendingOrderRequest<T> standardDeviationPriceOfVendingOrderItems(){
        return standardDeviationPriceOfVendingOrderItemsAs("stdDevPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> standardDeviationPriceOfVendingOrderItemsAs(String name){
        return standardDeviationPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> standardDeviationPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationPrice(), true);
    }
    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs("stdDevPopPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationPrice(), true);
    }
    public VendingOrderRequest<T> sampleVariancePriceOfVendingOrderItems(){
        return sampleVariancePriceOfVendingOrderItemsAs("varSampPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sampleVariancePriceOfVendingOrderItemsAs(String name){
        return sampleVariancePriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sampleVariancePriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVariancePrice(), true);
    }
    public VendingOrderRequest<T> samplePopulationVariancePriceOfVendingOrderItems(){
        return samplePopulationVariancePriceOfVendingOrderItemsAs("varPopPriceOfVendingOrderItems");
    }

    public VendingOrderRequest<T> samplePopulationVariancePriceOfVendingOrderItemsAs(String name){
        return samplePopulationVariancePriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> samplePopulationVariancePriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVariancePrice(), true);
    }
    public VendingOrderRequest<T> minAmountOfVendingOrderItems(){
        return minAmountOfVendingOrderItemsAs("minAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> minAmountOfVendingOrderItemsAs(String name){
        return minAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> minAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minAmount(), true);
    }
    public VendingOrderRequest<T> maxAmountOfVendingOrderItems(){
        return maxAmountOfVendingOrderItemsAs("maxAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> maxAmountOfVendingOrderItemsAs(String name){
        return maxAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> maxAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxAmount(), true);
    }
    public VendingOrderRequest<T> sumAmountOfVendingOrderItems(){
        return sumAmountOfVendingOrderItemsAs("sumAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sumAmountOfVendingOrderItemsAs(String name){
        return sumAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sumAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumAmount(), true);
    }
    public VendingOrderRequest<T> avgAmountOfVendingOrderItems(){
        return avgAmountOfVendingOrderItemsAs("avgAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> avgAmountOfVendingOrderItemsAs(String name){
        return avgAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> avgAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgAmount(), true);
    }
    public VendingOrderRequest<T> standardDeviationAmountOfVendingOrderItems(){
        return standardDeviationAmountOfVendingOrderItemsAs("stdDevAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> standardDeviationAmountOfVendingOrderItemsAs(String name){
        return standardDeviationAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> standardDeviationAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs("stdDevPopAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public VendingOrderRequest<T> sampleVarianceAmountOfVendingOrderItems(){
        return sampleVarianceAmountOfVendingOrderItemsAs("varSampAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> sampleVarianceAmountOfVendingOrderItemsAs(String name){
        return sampleVarianceAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> sampleVarianceAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public VendingOrderRequest<T> samplePopulationVarianceAmountOfVendingOrderItems(){
        return samplePopulationVarianceAmountOfVendingOrderItemsAs("varPopAmountOfVendingOrderItems");
    }

    public VendingOrderRequest<T> samplePopulationVarianceAmountOfVendingOrderItemsAs(String name){
        return samplePopulationVarianceAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public VendingOrderRequest<T> samplePopulationVarianceAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public VendingOrderRequest<T> facetByStatusAs(String facetName, OrderStatusRequest status){
       return facetByStatusAs(facetName, status, true);
   }

   public VendingOrderRequest<T> facetByStatusAs(String facetName, OrderStatusRequest status, boolean includeAllFacets){
       addFacet(facetName, VendingOrder.STATUS_PROPERTY, status, includeAllFacets);
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