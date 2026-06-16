package com.example.vendingmachineservice.vendingmachine;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusRequest;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest;
import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.product.ProductRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class VendingMachineRequest<T extends VendingMachine> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public VendingMachineRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public VendingMachineRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public VendingMachineRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public VendingMachineRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public VendingMachineRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public VendingMachineRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public VendingMachineRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (VendingMachineRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public VendingMachineRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public VendingMachineRequest<T> matchingAnyOf(VendingMachineRequest vendingMachine){
        super.internalMatchAny(vendingMachine);
        return this;
    }

    public VendingMachineRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public VendingMachineRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public VendingMachineRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public VendingMachineRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingMachineRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public VendingMachineRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingMachineRequest<T> selectChildren(){
        super.selectAny();
        selectOrderStatusList().selectPaymentMethodList().selectPaymentStatusList().selectProductList();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public VendingMachineRequest<T> selectId(){
       selectProperty(VendingMachine.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingMachineRequest<T> unselectId(){
       unselectProperty(VendingMachine.ID_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> selectName(){
       selectProperty(VendingMachine.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingMachineRequest<T> unselectName(){
       unselectProperty(VendingMachine.NAME_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> selectCreateTime(){
       selectProperty(VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingMachineRequest<T> unselectCreateTime(){
       unselectProperty(VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> selectUpdateTime(){
       selectProperty(VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingMachineRequest<T> unselectUpdateTime(){
       unselectProperty(VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> selectVersion(){
       selectProperty(VendingMachine.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingMachineRequest<T> unselectVersion(){
       unselectProperty(VendingMachine.VERSION_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> selectOrderStatusList(){
       return selectOrderStatusListWith(Q.orderStatuses().selectSelf());
    }

    public VendingMachineRequest<T> selectOrderStatusListWith(OrderStatusRequest orderStatusList){
       enhanceRelation(VendingMachine.ORDER_STATUS_LIST_PROPERTY, orderStatusList);
       return this;
    }
    public VendingMachineRequest<T> selectPaymentMethodList(){
       return selectPaymentMethodListWith(Q.paymentMethods().selectSelf());
    }

    public VendingMachineRequest<T> selectPaymentMethodListWith(PaymentMethodRequest paymentMethodList){
       enhanceRelation(VendingMachine.PAYMENT_METHOD_LIST_PROPERTY, paymentMethodList);
       return this;
    }
    public VendingMachineRequest<T> selectPaymentStatusList(){
       return selectPaymentStatusListWith(Q.paymentStatuses().selectSelf());
    }

    public VendingMachineRequest<T> selectPaymentStatusListWith(PaymentStatusRequest paymentStatusList){
       enhanceRelation(VendingMachine.PAYMENT_STATUS_LIST_PROPERTY, paymentStatusList);
       return this;
    }
    public VendingMachineRequest<T> selectProductList(){
       return selectProductListWith(Q.products().selectSelf());
    }

    public VendingMachineRequest<T> selectProductListWith(ProductRequest productList){
       enhanceRelation(VendingMachine.PRODUCT_LIST_PROPERTY, productList);
       return this;
    }

    public VendingMachineRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingMachine.ID_PROPERTY, operator, values);
    }

    public VendingMachineRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public VendingMachineRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public VendingMachineRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public VendingMachineRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public VendingMachineRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public VendingMachineRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingMachine.NAME_PROPERTY, operator, values);
    }

    public VendingMachineRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public VendingMachineRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public VendingMachineRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public VendingMachineRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public VendingMachineRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public VendingMachineRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public VendingMachineRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public VendingMachineRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public VendingMachineRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public VendingMachineRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public VendingMachineRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public VendingMachineRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public VendingMachineRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public VendingMachineRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingMachine.CREATE_TIME_PROPERTY, operator, values);
    }

    public VendingMachineRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public VendingMachineRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingMachineRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public VendingMachineRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public VendingMachineRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public VendingMachineRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public VendingMachineRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingMachine.UPDATE_TIME_PROPERTY, operator, values);
    }

    public VendingMachineRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public VendingMachineRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingMachineRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public VendingMachineRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public VendingMachineRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public VendingMachineRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public VendingMachineRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingMachine.VERSION_PROPERTY, operator, values);
    }

    public VendingMachineRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public VendingMachineRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public VendingMachineRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public VendingMachineRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public VendingMachineRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public VendingMachineRequest<T> withOrderStatusListMatching(OrderStatusRequest orderStatusRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, orderStatusRequest, OrderStatus.VENDING_MACHINE_PROPERTY));
    }

    public VendingMachineRequest<T> withoutOrderStatusListMatching(OrderStatusRequest orderStatusRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, orderStatusRequest, OrderStatus.VENDING_MACHINE_PROPERTY)));
    }

    public VendingMachineRequest<T> haveOrderStatuses(){
        return withOrderStatusListMatching(Q.orderStatuses().unlimited());
    }

    public VendingMachineRequest<T> haveNoOrderStatuses(){
        return withoutOrderStatusListMatching(Q.orderStatuses().unlimited());
    }
    public VendingMachineRequest<T> withPaymentMethodListMatching(PaymentMethodRequest paymentMethodRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, paymentMethodRequest, PaymentMethod.VENDING_MACHINE_PROPERTY));
    }

    public VendingMachineRequest<T> withoutPaymentMethodListMatching(PaymentMethodRequest paymentMethodRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, paymentMethodRequest, PaymentMethod.VENDING_MACHINE_PROPERTY)));
    }

    public VendingMachineRequest<T> havePaymentMethods(){
        return withPaymentMethodListMatching(Q.paymentMethods().unlimited());
    }

    public VendingMachineRequest<T> haveNoPaymentMethods(){
        return withoutPaymentMethodListMatching(Q.paymentMethods().unlimited());
    }
    public VendingMachineRequest<T> withPaymentStatusListMatching(PaymentStatusRequest paymentStatusRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, paymentStatusRequest, PaymentStatus.VENDING_MACHINE_PROPERTY));
    }

    public VendingMachineRequest<T> withoutPaymentStatusListMatching(PaymentStatusRequest paymentStatusRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, paymentStatusRequest, PaymentStatus.VENDING_MACHINE_PROPERTY)));
    }

    public VendingMachineRequest<T> havePaymentStatuses(){
        return withPaymentStatusListMatching(Q.paymentStatuses().unlimited());
    }

    public VendingMachineRequest<T> haveNoPaymentStatuses(){
        return withoutPaymentStatusListMatching(Q.paymentStatuses().unlimited());
    }
    public VendingMachineRequest<T> withProductListMatching(ProductRequest productRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, productRequest, Product.VENDING_MACHINE_PROPERTY));
    }

    public VendingMachineRequest<T> withoutProductListMatching(ProductRequest productRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(VendingMachine.ID_PROPERTY, productRequest, Product.VENDING_MACHINE_PROPERTY)));
    }

    public VendingMachineRequest<T> haveProducts(){
        return withProductListMatching(Q.products().unlimited());
    }

    public VendingMachineRequest<T> haveNoProducts(){
        return withoutProductListMatching(Q.products().unlimited());
    }

    public VendingMachineRequest<T> count(){
        super.count();
        return this;
    }
    public VendingMachineRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public VendingMachineRequest<T> groupByOrderStatusesWithDetails(OrderStatusRequest subRequest){
       aggregate(VendingMachine.ORDER_STATUS_LIST_PROPERTY, subRequest);
       return this;
    }
    public VendingMachineRequest<T> groupByPaymentMethodsWithDetails(PaymentMethodRequest subRequest){
       aggregate(VendingMachine.PAYMENT_METHOD_LIST_PROPERTY, subRequest);
       return this;
    }
    public VendingMachineRequest<T> groupByPaymentStatusesWithDetails(PaymentStatusRequest subRequest){
       aggregate(VendingMachine.PAYMENT_STATUS_LIST_PROPERTY, subRequest);
       return this;
    }
    public VendingMachineRequest<T> groupByProductsWithDetails(ProductRequest subRequest){
       aggregate(VendingMachine.PRODUCT_LIST_PROPERTY, subRequest);
       return this;
    }

    public VendingMachineRequest<T> groupById(){
       groupBy(VendingMachine.ID_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByIdAs(String retName){
       groupBy(retName, VendingMachine.ID_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingMachine.ID_PROPERTY, function);
       return this;
    }

    public VendingMachineRequest<T> groupByName(){
       groupBy(VendingMachine.NAME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByNameAs(String retName){
       groupBy(retName, VendingMachine.NAME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingMachine.NAME_PROPERTY, function);
       return this;
    }

    public VendingMachineRequest<T> groupByCreateTime(){
       groupBy(VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingMachine.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingMachineRequest<T> groupByUpdateTime(){
       groupBy(VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingMachine.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingMachineRequest<T> groupByVersion(){
       groupBy(VendingMachine.VERSION_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByVersionAs(String retName){
       groupBy(retName, VendingMachine.VERSION_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingMachine.VERSION_PROPERTY, function);
       return this;
    }



    public VendingMachineRequest<T> orderByIdAscending(){
       addOrderByAscending(VendingMachine.ID_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByIdDescending(){
       addOrderByDescending(VendingMachine.ID_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByNameAscending(){
       addOrderByAscending(VendingMachine.NAME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByNameDescending(){
       addOrderByDescending(VendingMachine.NAME_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(VendingMachine.NAME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(VendingMachine.NAME_PROPERTY);
       return this;
    }
    public VendingMachineRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(VendingMachine.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(VendingMachine.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByVersionAscending(){
       addOrderByAscending(VendingMachine.VERSION_PROPERTY);
       return this;
    }

    public VendingMachineRequest<T> orderByVersionDescending(){
       addOrderByDescending(VendingMachine.VERSION_PROPERTY);
       return this;
    }


    public VendingMachineRequest<T> statsFromOrderStatusesAs(String name, OrderStatusRequest subRequest){
       return statsFromOrderStatusesAs(name, subRequest, false);
    }

    public VendingMachineRequest<T> statsFromOrderStatusesAs(String name, OrderStatusRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderStatus.VENDING_MACHINE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingMachineRequest<T> statsFromOrderStatuses(OrderStatusRequest subRequest){
       return statsFromOrderStatusesAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest<T> statsFromPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
       return statsFromPaymentMethodsAs(name, subRequest, false);
    }

    public VendingMachineRequest<T> statsFromPaymentMethodsAs(String name, PaymentMethodRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentMethod.VENDING_MACHINE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingMachineRequest<T> statsFromPaymentMethods(PaymentMethodRequest subRequest){
       return statsFromPaymentMethodsAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest<T> statsFromPaymentStatusesAs(String name, PaymentStatusRequest subRequest){
       return statsFromPaymentStatusesAs(name, subRequest, false);
    }

    public VendingMachineRequest<T> statsFromPaymentStatusesAs(String name, PaymentStatusRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentStatus.VENDING_MACHINE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingMachineRequest<T> statsFromPaymentStatuses(PaymentStatusRequest subRequest){
       return statsFromPaymentStatusesAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest<T> statsFromProductsAs(String name, ProductRequest subRequest){
       return statsFromProductsAs(name, subRequest, false);
    }

    public VendingMachineRequest<T> statsFromProductsAs(String name, ProductRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Product.VENDING_MACHINE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public VendingMachineRequest<T> statsFromProducts(ProductRequest subRequest){
       return statsFromProductsAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest<T> countOrderStatuses(){
        return countOrderStatusesAs("Count");
    }

    public VendingMachineRequest<T> countOrderStatusesAs(String name){
        return countOrderStatusesWith(name, Q.orderStatuses().unlimited());
    }

    public VendingMachineRequest<T> countOrderStatusesWith(String name, OrderStatusRequest subRequest){
        return statsFromOrderStatusesAs(name, subRequest.count(), true);
    }
    public VendingMachineRequest<T> countPaymentMethods(){
        return countPaymentMethodsAs("Count");
    }

    public VendingMachineRequest<T> countPaymentMethodsAs(String name){
        return countPaymentMethodsWith(name, Q.paymentMethods().unlimited());
    }

    public VendingMachineRequest<T> countPaymentMethodsWith(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.count(), true);
    }
    public VendingMachineRequest<T> countPaymentStatuses(){
        return countPaymentStatusesAs("Count");
    }

    public VendingMachineRequest<T> countPaymentStatusesAs(String name){
        return countPaymentStatusesWith(name, Q.paymentStatuses().unlimited());
    }

    public VendingMachineRequest<T> countPaymentStatusesWith(String name, PaymentStatusRequest subRequest){
        return statsFromPaymentStatusesAs(name, subRequest.count(), true);
    }
    public VendingMachineRequest<T> countProducts(){
        return countProductsAs("Count");
    }

    public VendingMachineRequest<T> countProductsAs(String name){
        return countProductsWith(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> countProductsWith(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.count(), true);
    }
    public VendingMachineRequest<T> minPriceOfProducts(){
        return minPriceOfProductsAs("minPriceOfProducts");
    }

    public VendingMachineRequest<T> minPriceOfProductsAs(String name){
        return minPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> minPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.minPrice(), true);
    }
    public VendingMachineRequest<T> maxPriceOfProducts(){
        return maxPriceOfProductsAs("maxPriceOfProducts");
    }

    public VendingMachineRequest<T> maxPriceOfProductsAs(String name){
        return maxPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> maxPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.maxPrice(), true);
    }
    public VendingMachineRequest<T> sumPriceOfProducts(){
        return sumPriceOfProductsAs("sumPriceOfProducts");
    }

    public VendingMachineRequest<T> sumPriceOfProductsAs(String name){
        return sumPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> sumPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sumPrice(), true);
    }
    public VendingMachineRequest<T> avgPriceOfProducts(){
        return avgPriceOfProductsAs("avgPriceOfProducts");
    }

    public VendingMachineRequest<T> avgPriceOfProductsAs(String name){
        return avgPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> avgPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.avgPrice(), true);
    }
    public VendingMachineRequest<T> standardDeviationPriceOfProducts(){
        return standardDeviationPriceOfProductsAs("stdDevPriceOfProducts");
    }

    public VendingMachineRequest<T> standardDeviationPriceOfProductsAs(String name){
        return standardDeviationPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> standardDeviationPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.standardDeviationPrice(), true);
    }
    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationPriceOfProducts(){
        return squareRootOfPopulationStandardDeviationPriceOfProductsAs("stdDevPopPriceOfProducts");
    }

    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationPriceOfProductsAs(String name){
        return squareRootOfPopulationStandardDeviationPriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.squareRootOfPopulationStandardDeviationPrice(), true);
    }
    public VendingMachineRequest<T> sampleVariancePriceOfProducts(){
        return sampleVariancePriceOfProductsAs("varSampPriceOfProducts");
    }

    public VendingMachineRequest<T> sampleVariancePriceOfProductsAs(String name){
        return sampleVariancePriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> sampleVariancePriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sampleVariancePrice(), true);
    }
    public VendingMachineRequest<T> samplePopulationVariancePriceOfProducts(){
        return samplePopulationVariancePriceOfProductsAs("varPopPriceOfProducts");
    }

    public VendingMachineRequest<T> samplePopulationVariancePriceOfProductsAs(String name){
        return samplePopulationVariancePriceOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> samplePopulationVariancePriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.samplePopulationVariancePrice(), true);
    }
    public VendingMachineRequest<T> minStockOfProducts(){
        return minStockOfProductsAs("minStockOfProducts");
    }

    public VendingMachineRequest<T> minStockOfProductsAs(String name){
        return minStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> minStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.minStock(), true);
    }
    public VendingMachineRequest<T> maxStockOfProducts(){
        return maxStockOfProductsAs("maxStockOfProducts");
    }

    public VendingMachineRequest<T> maxStockOfProductsAs(String name){
        return maxStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> maxStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.maxStock(), true);
    }
    public VendingMachineRequest<T> sumStockOfProducts(){
        return sumStockOfProductsAs("sumStockOfProducts");
    }

    public VendingMachineRequest<T> sumStockOfProductsAs(String name){
        return sumStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> sumStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sumStock(), true);
    }
    public VendingMachineRequest<T> avgStockOfProducts(){
        return avgStockOfProductsAs("avgStockOfProducts");
    }

    public VendingMachineRequest<T> avgStockOfProductsAs(String name){
        return avgStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> avgStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.avgStock(), true);
    }
    public VendingMachineRequest<T> standardDeviationStockOfProducts(){
        return standardDeviationStockOfProductsAs("stdDevStockOfProducts");
    }

    public VendingMachineRequest<T> standardDeviationStockOfProductsAs(String name){
        return standardDeviationStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> standardDeviationStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.standardDeviationStock(), true);
    }
    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationStockOfProducts(){
        return squareRootOfPopulationStandardDeviationStockOfProductsAs("stdDevPopStockOfProducts");
    }

    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationStockOfProductsAs(String name){
        return squareRootOfPopulationStandardDeviationStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> squareRootOfPopulationStandardDeviationStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.squareRootOfPopulationStandardDeviationStock(), true);
    }
    public VendingMachineRequest<T> sampleVarianceStockOfProducts(){
        return sampleVarianceStockOfProductsAs("varSampStockOfProducts");
    }

    public VendingMachineRequest<T> sampleVarianceStockOfProductsAs(String name){
        return sampleVarianceStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> sampleVarianceStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sampleVarianceStock(), true);
    }
    public VendingMachineRequest<T> samplePopulationVarianceStockOfProducts(){
        return samplePopulationVarianceStockOfProductsAs("varPopStockOfProducts");
    }

    public VendingMachineRequest<T> samplePopulationVarianceStockOfProductsAs(String name){
        return samplePopulationVarianceStockOfProductsAs(name, Q.products().unlimited());
    }

    public VendingMachineRequest<T> samplePopulationVarianceStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.samplePopulationVarianceStock(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public VendingMachineRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public VendingMachineRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public VendingMachineRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public VendingMachineRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public VendingMachineRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}