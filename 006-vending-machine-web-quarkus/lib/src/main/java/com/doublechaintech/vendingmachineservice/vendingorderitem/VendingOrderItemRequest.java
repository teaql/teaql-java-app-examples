package com.doublechaintech.vendingmachineservice.vendingorderitem;

import com.doublechaintech.vendingmachineservice.Q;
import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.product.ProductRequest;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class VendingOrderItemRequest<T extends VendingOrderItem> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public VendingOrderItemRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public VendingOrderItemRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public VendingOrderItemRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public VendingOrderItemRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public VendingOrderItemRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public VendingOrderItemRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public VendingOrderItemRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (VendingOrderItemRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public VendingOrderItemRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public VendingOrderItemRequest<T> matchingAnyOf(VendingOrderItemRequest vendingOrderItem){
        super.internalMatchAny(vendingOrderItem);
        return this;
    }

    public VendingOrderItemRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public VendingOrderItemRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public VendingOrderItemRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public VendingOrderItemRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectVendingOrderIdOnly().selectProductIdOnly().selectQuantity().selectPrice().selectAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderItemRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public VendingOrderItemRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectVendingOrder().selectProduct().selectQuantity().selectPrice().selectAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public VendingOrderItemRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectVendingOrder().selectProduct().selectQuantity().selectPrice().selectAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public VendingOrderItemRequest<T> selectId(){
       selectProperty(VendingOrderItem.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderItemRequest<T> unselectId(){
       unselectProperty(VendingOrderItem.ID_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectName(){
       selectProperty(VendingOrderItem.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderItemRequest<T> unselectName(){
       unselectProperty(VendingOrderItem.NAME_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectVendingOrderIdOnly(){
       selectProperty(VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> selectVendingOrder(){
        return selectVendingOrderWith(Q.vendingOrders().unlimited().selectSelf());
    }

    public VendingOrderItemRequest<T> selectVendingOrderWith(VendingOrderRequest vendingOrder){
       selectProperty(VendingOrderItem.VENDING_ORDER_PROPERTY);
       enhanceRelation(VendingOrderItem.VENDING_ORDER_PROPERTY, vendingOrder);
       return this;
    }

    public VendingOrderItemRequest<T> unselectVendingOrder(){
       unselectProperty(VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectProductIdOnly(){
       selectProperty(VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public VendingOrderItemRequest<T> selectProductWith(ProductRequest product){
       selectProperty(VendingOrderItem.PRODUCT_PROPERTY);
       enhanceRelation(VendingOrderItem.PRODUCT_PROPERTY, product);
       return this;
    }

    public VendingOrderItemRequest<T> unselectProduct(){
       unselectProperty(VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectQuantity(){
       selectProperty(VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    /**
     * fill the quantity with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  quantity) to fetch quantity property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the quantity with customized aggrFunction, TEAQL uses ({aggrFunction}(quantity) AS quantity to fetch quantity property.
     * @param aggrFunction  aggrFunction
     */
    public VendingOrderItemRequest<T> selectQuantity(AggrFunction aggrFunction){
       selectProperty(VendingOrderItem.QUANTITY_PROPERTY, aggrFunction);
       return this;
    }


    public VendingOrderItemRequest<T> unselectQuantity(){
       unselectProperty(VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectPrice(){
       selectProperty(VendingOrderItem.PRICE_PROPERTY);
       return this;
    }

    /**
     * fill the price with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  price) to fetch price property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the price with customized aggrFunction, TEAQL uses ({aggrFunction}(price) AS price to fetch price property.
     * @param aggrFunction  aggrFunction
     */
    public VendingOrderItemRequest<T> selectPrice(AggrFunction aggrFunction){
       selectProperty(VendingOrderItem.PRICE_PROPERTY, aggrFunction);
       return this;
    }


    public VendingOrderItemRequest<T> unselectPrice(){
       unselectProperty(VendingOrderItem.PRICE_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectAmount(){
       selectProperty(VendingOrderItem.AMOUNT_PROPERTY);
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
    public VendingOrderItemRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(VendingOrderItem.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public VendingOrderItemRequest<T> unselectAmount(){
       unselectProperty(VendingOrderItem.AMOUNT_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectCreateTime(){
       selectProperty(VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderItemRequest<T> unselectCreateTime(){
       unselectProperty(VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectUpdateTime(){
       selectProperty(VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderItemRequest<T> unselectUpdateTime(){
       unselectProperty(VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> selectVersion(){
       selectProperty(VendingOrderItem.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public VendingOrderItemRequest<T> unselectVersion(){
       unselectProperty(VendingOrderItem.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.ID_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public VendingOrderItemRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public VendingOrderItemRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public VendingOrderItemRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.NAME_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public VendingOrderItemRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public VendingOrderItemRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public VendingOrderItemRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public VendingOrderItemRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public VendingOrderItemRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public VendingOrderItemRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public VendingOrderItemRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public VendingOrderItemRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public VendingOrderItemRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public VendingOrderItemRequest<T> filterByVendingOrder(VendingOrder... vendingOrder){
      if (vendingOrder == null || vendingOrder.length == 0) {
        throw new IllegalArgumentException("filterByVendingOrder parameter vendingOrder cannot be empty");
      }
      return appendSearchCriteria(createVendingOrderCriteria(Operator.EQUAL, (Object[])vendingOrder));
    }

    public VendingOrderItemRequest<T> withVendingOrder(Operator operator, Object... values){
       return appendSearchCriteria(createVendingOrderCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withVendingOrderIsUnknown(){
       return withVendingOrder(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withVendingOrderIsKnown(){
       return withVendingOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.VENDING_ORDER_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> filterByVendingOrder(Long vendingOrder){
      if(vendingOrder == null){
         return this;
      }
      return withVendingOrder(Operator.EQUAL, vendingOrder);
    }
    public VendingOrderItemRequest<T> withVendingOrderMatching(VendingOrderRequest vendingOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrderItem.VENDING_ORDER_PROPERTY, vendingOrder, VendingOrder.ID_PROPERTY));
    }

    public VendingOrderItemRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public VendingOrderItemRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.PRODUCT_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public VendingOrderItemRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(VendingOrderItem.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public VendingOrderItemRequest<T> filterByQuantity(Integer... quantity){
      if (quantity == null || quantity.length == 0) {
        throw new IllegalArgumentException("filterByQuantity parameter quantity cannot be empty");
      }
      return appendSearchCriteria(createQuantityCriteria(Operator.EQUAL, (Object[])quantity));
    }

    public VendingOrderItemRequest<T> withQuantity(Operator operator, Object... values){
       return appendSearchCriteria(createQuantityCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withQuantityIsUnknown(){
       return withQuantity(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withQuantityIsKnown(){
       return withQuantity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQuantityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.QUANTITY_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withQuantityGreaterThan(Integer quantity){
       return withQuantity(Operator.GREATER_THAN, quantity);
    }

    public VendingOrderItemRequest<T> withQuantityGreaterThanOrEqualTo(Integer quantity){
       return withQuantity(Operator.GREATER_THAN_OR_EQUAL, quantity);
    }

    public VendingOrderItemRequest<T> withQuantityLessThan(Integer quantity){
       return withQuantity(Operator.LESS_THAN, quantity);
    }

    public VendingOrderItemRequest<T> withQuantityLessThanOrEqualTo(Integer quantity){
       return withQuantity(Operator.LESS_THAN_OR_EQUAL, quantity);
    }

    public VendingOrderItemRequest<T> withQuantityBetween(Integer startOfQuantity, Integer endOfQuantity){
       return withQuantity(Operator.BETWEEN, startOfQuantity, endOfQuantity);
    }



    public VendingOrderItemRequest<T> filterByPrice(Integer... price){
      if (price == null || price.length == 0) {
        throw new IllegalArgumentException("filterByPrice parameter price cannot be empty");
      }
      return appendSearchCriteria(createPriceCriteria(Operator.EQUAL, (Object[])price));
    }

    public VendingOrderItemRequest<T> withPrice(Operator operator, Object... values){
       return appendSearchCriteria(createPriceCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withPriceIsUnknown(){
       return withPrice(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withPriceIsKnown(){
       return withPrice(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPriceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.PRICE_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withPriceGreaterThan(Integer price){
       return withPrice(Operator.GREATER_THAN, price);
    }

    public VendingOrderItemRequest<T> withPriceGreaterThanOrEqualTo(Integer price){
       return withPrice(Operator.GREATER_THAN_OR_EQUAL, price);
    }

    public VendingOrderItemRequest<T> withPriceLessThan(Integer price){
       return withPrice(Operator.LESS_THAN, price);
    }

    public VendingOrderItemRequest<T> withPriceLessThanOrEqualTo(Integer price){
       return withPrice(Operator.LESS_THAN_OR_EQUAL, price);
    }

    public VendingOrderItemRequest<T> withPriceBetween(Integer startOfPrice, Integer endOfPrice){
       return withPrice(Operator.BETWEEN, startOfPrice, endOfPrice);
    }



    public VendingOrderItemRequest<T> filterByAmount(Integer... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public VendingOrderItemRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.AMOUNT_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withAmountGreaterThan(Integer amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public VendingOrderItemRequest<T> withAmountGreaterThanOrEqualTo(Integer amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public VendingOrderItemRequest<T> withAmountLessThan(Integer amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public VendingOrderItemRequest<T> withAmountLessThanOrEqualTo(Integer amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public VendingOrderItemRequest<T> withAmountBetween(Integer startOfAmount, Integer endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public VendingOrderItemRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public VendingOrderItemRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.CREATE_TIME_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public VendingOrderItemRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public VendingOrderItemRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public VendingOrderItemRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public VendingOrderItemRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.UPDATE_TIME_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public VendingOrderItemRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public VendingOrderItemRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public VendingOrderItemRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public VendingOrderItemRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public VendingOrderItemRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public VendingOrderItemRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(VendingOrderItem.VERSION_PROPERTY, operator, values);
    }

    public VendingOrderItemRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public VendingOrderItemRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public VendingOrderItemRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public VendingOrderItemRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public VendingOrderItemRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public VendingOrderItemRequest<T> count(){
        super.count();
        return this;
    }
    public VendingOrderItemRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public VendingOrderItemRequest minQuantity(){
        return minQuantityAs(prefix("minOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest minQuantityAs(String retName){
        super.min(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest maxQuantity(){
        return maxQuantityAs(prefix("maxOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest maxQuantityAs(String retName){
        super.max(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sumQuantity(){
        return sumQuantityAs(prefix("sumOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest sumQuantityAs(String retName){
        super.sum(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest avgQuantity(){
        return avgQuantityAs(prefix("avgOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest avgQuantityAs(String retName){
        super.avg(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest standardDeviationQuantity(){
        return standardDeviationQuantityAs(prefix("standardDeviationOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest standardDeviationQuantityAs(String retName){
        super.standardDeviation(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationQuantity(){
        return squareRootOfPopulationStandardDeviationQuantityAs(prefix("squareRootOfPopulationStandardDeviationOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationQuantityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sampleVarianceQuantity(){
        return sampleVarianceQuantityAs(prefix("sampleVarianceOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest sampleVarianceQuantityAs(String retName){
        super.sampleVariance(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest samplePopulationVarianceQuantity(){
        return samplePopulationVarianceQuantityAs(prefix("samplePopulationVarianceOf",VendingOrderItem.QUANTITY_PROPERTY));
    }

    public VendingOrderItemRequest samplePopulationVarianceQuantityAs(String retName){
        super.samplePopulationVariance(retName, VendingOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest minPrice(){
        return minPriceAs(prefix("minOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest minPriceAs(String retName){
        super.min(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest maxPrice(){
        return maxPriceAs(prefix("maxOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest maxPriceAs(String retName){
        super.max(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sumPrice(){
        return sumPriceAs(prefix("sumOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest sumPriceAs(String retName){
        super.sum(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest avgPrice(){
        return avgPriceAs(prefix("avgOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest avgPriceAs(String retName){
        super.avg(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest standardDeviationPrice(){
        return standardDeviationPriceAs(prefix("standardDeviationOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest standardDeviationPriceAs(String retName){
        super.standardDeviation(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationPrice(){
        return squareRootOfPopulationStandardDeviationPriceAs(prefix("squareRootOfPopulationStandardDeviationOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationPriceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sampleVariancePrice(){
        return sampleVariancePriceAs(prefix("sampleVarianceOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest sampleVariancePriceAs(String retName){
        super.sampleVariance(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest samplePopulationVariancePrice(){
        return samplePopulationVariancePriceAs(prefix("samplePopulationVarianceOf",VendingOrderItem.PRICE_PROPERTY));
    }

    public VendingOrderItemRequest samplePopulationVariancePriceAs(String retName){
        super.samplePopulationVariance(retName, VendingOrderItem.PRICE_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest minAmount(){
        return minAmountAs(prefix("minOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest minAmountAs(String retName){
        super.min(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest maxAmountAs(String retName){
        super.max(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest sumAmountAs(String retName){
        super.sum(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest avgAmountAs(String retName){
        super.avg(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",VendingOrderItem.AMOUNT_PROPERTY));
    }

    public VendingOrderItemRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, VendingOrderItem.AMOUNT_PROPERTY);
        return this;
    }
    public VendingOrderItemRequest<T> groupByVendingOrderWithDetails(){
       return groupByVendingOrderWithDetails(Q.vendingOrders().unlimited());
    }

    public VendingOrderItemRequest<T> groupByVendingOrderWithDetails(VendingOrderRequest subRequest){
       aggregate(VendingOrderItem.VENDING_ORDER_PROPERTY, subRequest);
       return this;
    }

    public VendingOrderItemRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public VendingOrderItemRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(VendingOrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }








    public VendingOrderItemRequest<T> groupById(){
       groupBy(VendingOrderItem.ID_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByIdAs(String retName){
       groupBy(retName, VendingOrderItem.ID_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.ID_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByName(){
       groupBy(VendingOrderItem.NAME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByNameAs(String retName){
       groupBy(retName, VendingOrderItem.NAME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.NAME_PROPERTY, function);
       return this;
    }
    public VendingOrderItemRequest<T> groupByVendingOrderWith(VendingOrderRequest subRequest){
       groupBy(VendingOrderItem.VENDING_ORDER_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderItemRequest<T> groupByVendingOrder(){
       groupBy(VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByVendingOrderAs(String retName){
       groupBy(retName, VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByVendingOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.VENDING_ORDER_PROPERTY, function);
       return this;
    }
    public VendingOrderItemRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(VendingOrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public VendingOrderItemRequest<T> groupByProduct(){
       groupBy(VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByProductAs(String retName){
       groupBy(retName, VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.PRODUCT_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByQuantity(){
       groupBy(VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByQuantityAs(String retName){
       groupBy(retName, VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByQuantityWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.QUANTITY_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByPrice(){
       groupBy(VendingOrderItem.PRICE_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByPriceAs(String retName){
       groupBy(retName, VendingOrderItem.PRICE_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByPriceWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.PRICE_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByAmount(){
       groupBy(VendingOrderItem.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByAmountAs(String retName){
       groupBy(retName, VendingOrderItem.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.AMOUNT_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByCreateTime(){
       groupBy(VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByUpdateTime(){
       groupBy(VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public VendingOrderItemRequest<T> groupByVersion(){
       groupBy(VendingOrderItem.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByVersionAs(String retName){
       groupBy(retName, VendingOrderItem.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, VendingOrderItem.VERSION_PROPERTY, function);
       return this;
    }



    public VendingOrderItemRequest<T> orderByIdAscending(){
       addOrderByAscending(VendingOrderItem.ID_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByIdDescending(){
       addOrderByDescending(VendingOrderItem.ID_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByNameAscending(){
       addOrderByAscending(VendingOrderItem.NAME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByNameDescending(){
       addOrderByDescending(VendingOrderItem.NAME_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(VendingOrderItem.NAME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(VendingOrderItem.NAME_PROPERTY);
       return this;
    }
    public VendingOrderItemRequest<T> orderByVendingOrderAscending(){
       addOrderByAscending(VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByVendingOrderDescending(){
       addOrderByDescending(VendingOrderItem.VENDING_ORDER_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByProductAscending(){
       addOrderByAscending(VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByProductDescending(){
       addOrderByDescending(VendingOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByQuantityAscending(){
       addOrderByAscending(VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByQuantityDescending(){
       addOrderByDescending(VendingOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByPriceAscending(){
       addOrderByAscending(VendingOrderItem.PRICE_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByPriceDescending(){
       addOrderByDescending(VendingOrderItem.PRICE_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByAmountAscending(){
       addOrderByAscending(VendingOrderItem.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByAmountDescending(){
       addOrderByDescending(VendingOrderItem.AMOUNT_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(VendingOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(VendingOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByVersionAscending(){
       addOrderByAscending(VendingOrderItem.VERSION_PROPERTY);
       return this;
    }

    public VendingOrderItemRequest<T> orderByVersionDescending(){
       addOrderByDescending(VendingOrderItem.VERSION_PROPERTY);
       return this;
    }


    public VendingOrderRequest rollUpToVendingOrder(){
       VendingOrderRequest vendingOrder = Q.vendingOrders().unlimited();
       this.withVendingOrderMatching(vendingOrder)
           .groupByVendingOrderWith(vendingOrder);
       return vendingOrder;
    }

    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }








   public VendingOrderItemRequest<T> facetByVendingOrderAs(String facetName, VendingOrderRequest vendingOrder){
       return facetByVendingOrderAs(facetName, vendingOrder, true);
   }

   public VendingOrderItemRequest<T> facetByVendingOrderAs(String facetName, VendingOrderRequest vendingOrder, boolean includeAllFacets){
       addFacet(facetName, VendingOrderItem.VENDING_ORDER_PROPERTY, vendingOrder, includeAllFacets);
       return this;
   }
   public VendingOrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public VendingOrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, VendingOrderItem.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public VendingOrderItemRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public VendingOrderItemRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public VendingOrderItemRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public VendingOrderItemRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public VendingOrderItemRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}