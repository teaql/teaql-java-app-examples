package com.example.vendingmachineservice.product;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineRequest;
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

public class ProductRequest<T extends Product> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ProductRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ProductRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ProductRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ProductRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ProductRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ProductRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ProductRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ProductRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ProductRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ProductRequest<T> matchingAnyOf(ProductRequest product){
        super.internalMatchAny(product);
        return this;
    }

    public ProductRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ProductRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ProductRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ProductRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectPrice().selectStock().selectImageUrl().selectVendingMachineIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ProductRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectPrice().selectStock().selectImageUrl().selectVendingMachine().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductRequest<T> selectChildren(){
        super.selectAny();
        selectVendingOrderItemList();
        return selectId().selectName().selectPrice().selectStock().selectImageUrl().selectVendingMachine().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ProductRequest<T> selectId(){
       selectProperty(Product.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectId(){
       unselectProperty(Product.ID_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectName(){
       selectProperty(Product.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectName(){
       unselectProperty(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectPrice(){
       selectProperty(Product.PRICE_PROPERTY);
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
    public ProductRequest<T> selectPrice(AggrFunction aggrFunction){
       selectProperty(Product.PRICE_PROPERTY, aggrFunction);
       return this;
    }


    public ProductRequest<T> unselectPrice(){
       unselectProperty(Product.PRICE_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectStock(){
       selectProperty(Product.STOCK_PROPERTY);
       return this;
    }

    /**
     * fill the stock with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  stock) to fetch stock property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the stock with customized aggrFunction, TEAQL uses ({aggrFunction}(stock) AS stock to fetch stock property.
     * @param aggrFunction  aggrFunction
     */
    public ProductRequest<T> selectStock(AggrFunction aggrFunction){
       selectProperty(Product.STOCK_PROPERTY, aggrFunction);
       return this;
    }


    public ProductRequest<T> unselectStock(){
       unselectProperty(Product.STOCK_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectImageUrl(){
       selectProperty(Product.IMAGE_URL_PROPERTY);
       return this;
    }

    /**
     * fill the imageUrl with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  imageUrl) to fetch imageUrl property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectImageUrl(){
       unselectProperty(Product.IMAGE_URL_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectVendingMachineIdOnly(){
       selectProperty(Product.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public ProductRequest<T> selectVendingMachine(){
        return selectVendingMachineWith(Q.vendingMachines().unlimited().selectSelf());
    }

    public ProductRequest<T> selectVendingMachineWith(VendingMachineRequest vendingMachine){
       selectProperty(Product.VENDING_MACHINE_PROPERTY);
       enhanceRelation(Product.VENDING_MACHINE_PROPERTY, vendingMachine);
       return this;
    }

    public ProductRequest<T> unselectVendingMachine(){
       unselectProperty(Product.VENDING_MACHINE_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectCreateTime(){
       selectProperty(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectCreateTime(){
       unselectProperty(Product.CREATE_TIME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectUpdateTime(){
       selectProperty(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectUpdateTime(){
       unselectProperty(Product.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectVersion(){
       selectProperty(Product.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectVersion(){
       unselectProperty(Product.VERSION_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectVendingOrderItemList(){
       return selectVendingOrderItemListWith(Q.vendingOrderItems().selectSelf());
    }

    public ProductRequest<T> selectVendingOrderItemListWith(VendingOrderItemRequest vendingOrderItemList){
       enhanceRelation(Product.VENDING_ORDER_ITEM_LIST_PROPERTY, vendingOrderItemList);
       return this;
    }

    public ProductRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.ID_PROPERTY, operator, values);
    }

    public ProductRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ProductRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ProductRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public ProductRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public ProductRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public ProductRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.NAME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public ProductRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public ProductRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public ProductRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public ProductRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public ProductRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public ProductRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public ProductRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public ProductRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public ProductRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public ProductRequest<T> filterByPrice(Integer... price){
      if (price == null || price.length == 0) {
        throw new IllegalArgumentException("filterByPrice parameter price cannot be empty");
      }
      return appendSearchCriteria(createPriceCriteria(Operator.EQUAL, (Object[])price));
    }

    public ProductRequest<T> withPrice(Operator operator, Object... values){
       return appendSearchCriteria(createPriceCriteria(operator, values));
    }

    public ProductRequest<T> withPriceIsUnknown(){
       return withPrice(Operator.IS_NULL);
    }

    public ProductRequest<T> withPriceIsKnown(){
       return withPrice(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPriceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.PRICE_PROPERTY, operator, values);
    }

    public ProductRequest<T> withPriceGreaterThan(Integer price){
       return withPrice(Operator.GREATER_THAN, price);
    }

    public ProductRequest<T> withPriceGreaterThanOrEqualTo(Integer price){
       return withPrice(Operator.GREATER_THAN_OR_EQUAL, price);
    }

    public ProductRequest<T> withPriceLessThan(Integer price){
       return withPrice(Operator.LESS_THAN, price);
    }

    public ProductRequest<T> withPriceLessThanOrEqualTo(Integer price){
       return withPrice(Operator.LESS_THAN_OR_EQUAL, price);
    }

    public ProductRequest<T> withPriceBetween(Integer startOfPrice, Integer endOfPrice){
       return withPrice(Operator.BETWEEN, startOfPrice, endOfPrice);
    }



    public ProductRequest<T> filterByStock(Integer... stock){
      if (stock == null || stock.length == 0) {
        throw new IllegalArgumentException("filterByStock parameter stock cannot be empty");
      }
      return appendSearchCriteria(createStockCriteria(Operator.EQUAL, (Object[])stock));
    }

    public ProductRequest<T> withStock(Operator operator, Object... values){
       return appendSearchCriteria(createStockCriteria(operator, values));
    }

    public ProductRequest<T> withStockIsUnknown(){
       return withStock(Operator.IS_NULL);
    }

    public ProductRequest<T> withStockIsKnown(){
       return withStock(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStockCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.STOCK_PROPERTY, operator, values);
    }

    public ProductRequest<T> withStockGreaterThan(Integer stock){
       return withStock(Operator.GREATER_THAN, stock);
    }

    public ProductRequest<T> withStockGreaterThanOrEqualTo(Integer stock){
       return withStock(Operator.GREATER_THAN_OR_EQUAL, stock);
    }

    public ProductRequest<T> withStockLessThan(Integer stock){
       return withStock(Operator.LESS_THAN, stock);
    }

    public ProductRequest<T> withStockLessThanOrEqualTo(Integer stock){
       return withStock(Operator.LESS_THAN_OR_EQUAL, stock);
    }

    public ProductRequest<T> withStockBetween(Integer startOfStock, Integer endOfStock){
       return withStock(Operator.BETWEEN, startOfStock, endOfStock);
    }



    public ProductRequest<T> filterByImageUrl(String... imageUrl){
      if (imageUrl == null || imageUrl.length == 0) {
        throw new IllegalArgumentException("filterByImageUrl parameter imageUrl cannot be empty");
      }
      return appendSearchCriteria(createImageUrlCriteria(Operator.EQUAL, (Object[])imageUrl));
    }

    public ProductRequest<T> withImageUrl(Operator operator, Object... values){
       return appendSearchCriteria(createImageUrlCriteria(operator, values));
    }

    public ProductRequest<T> withImageUrlIsUnknown(){
       return withImageUrl(Operator.IS_NULL);
    }

    public ProductRequest<T> withImageUrlIsKnown(){
       return withImageUrl(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createImageUrlCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.IMAGE_URL_PROPERTY, operator, values);
    }

    public ProductRequest<T> withImageUrlGreaterThan(String imageUrl){
       return withImageUrl(Operator.GREATER_THAN, imageUrl);
    }

    public ProductRequest<T> withImageUrlGreaterThanOrEqualTo(String imageUrl){
       return withImageUrl(Operator.GREATER_THAN_OR_EQUAL, imageUrl);
    }

    public ProductRequest<T> withImageUrlLessThan(String imageUrl){
       return withImageUrl(Operator.LESS_THAN, imageUrl);
    }

    public ProductRequest<T> withImageUrlLessThanOrEqualTo(String imageUrl){
       return withImageUrl(Operator.LESS_THAN_OR_EQUAL, imageUrl);
    }

    public ProductRequest<T> withImageUrlBetween(String startOfImageUrl, String endOfImageUrl){
       return withImageUrl(Operator.BETWEEN, startOfImageUrl, endOfImageUrl);
    }
    public ProductRequest<T> withImageUrlStartingWith(String imageUrl){
       return withImageUrl(Operator.BEGIN_WITH, imageUrl);
    }
    public ProductRequest<T> withImageUrlContaining(String imageUrl){
       return withImageUrl(Operator.CONTAIN, imageUrl);
    }

    public ProductRequest<T> withImageUrlEndingWith(String imageUrl){
       return withImageUrl(Operator.END_WITH, imageUrl);
    }

    public ProductRequest<T> withImageUrlIs(String imageUrl){
       return withImageUrl(Operator.EQUAL, imageUrl);
    }

    public ProductRequest<T> withImageUrlSoundingLike(String imageUrl){
       return withImageUrl(Operator.SOUNDS_LIKE, imageUrl);
    }



    public ProductRequest<T> filterByVendingMachine(VendingMachine... vendingMachine){
      if (vendingMachine == null || vendingMachine.length == 0) {
        throw new IllegalArgumentException("filterByVendingMachine parameter vendingMachine cannot be empty");
      }
      return appendSearchCriteria(createVendingMachineCriteria(Operator.EQUAL, (Object[])vendingMachine));
    }

    public ProductRequest<T> withVendingMachine(Operator operator, Object... values){
       return appendSearchCriteria(createVendingMachineCriteria(operator, values));
    }

    public ProductRequest<T> withVendingMachineIsUnknown(){
       return withVendingMachine(Operator.IS_NULL);
    }

    public ProductRequest<T> withVendingMachineIsKnown(){
       return withVendingMachine(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingMachineCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.VENDING_MACHINE_PROPERTY, operator, values);
    }

    public ProductRequest<T> filterByVendingMachine(Long vendingMachine){
      if(vendingMachine == null){
         return this;
      }
      return withVendingMachine(Operator.EQUAL, vendingMachine);
    }
    public ProductRequest<T> withVendingMachineMatching(VendingMachineRequest vendingMachine){
       return appendSearchCriteria(new SubQuerySearchCriteria(Product.VENDING_MACHINE_PROPERTY, vendingMachine, VendingMachine.ID_PROPERTY));
    }

    public ProductRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ProductRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ProductRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ProductRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.CREATE_TIME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ProductRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ProductRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ProductRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ProductRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ProductRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ProductRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ProductRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ProductRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ProductRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ProductRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ProductRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ProductRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ProductRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.VERSION_PROPERTY, operator, values);
    }

    public ProductRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ProductRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ProductRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ProductRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ProductRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public ProductRequest<T> withVendingOrderItemListMatching(VendingOrderItemRequest vendingOrderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, vendingOrderItemRequest, VendingOrderItem.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutVendingOrderItemListMatching(VendingOrderItemRequest vendingOrderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, vendingOrderItemRequest, VendingOrderItem.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> haveVendingOrderItems(){
        return withVendingOrderItemListMatching(Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> haveNoVendingOrderItems(){
        return withoutVendingOrderItemListMatching(Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> count(){
        super.count();
        return this;
    }
    public ProductRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ProductRequest minPrice(){
        return minPriceAs(prefix("minOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest minPriceAs(String retName){
        super.min(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest maxPrice(){
        return maxPriceAs(prefix("maxOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest maxPriceAs(String retName){
        super.max(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest sumPrice(){
        return sumPriceAs(prefix("sumOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest sumPriceAs(String retName){
        super.sum(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest avgPrice(){
        return avgPriceAs(prefix("avgOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest avgPriceAs(String retName){
        super.avg(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest standardDeviationPrice(){
        return standardDeviationPriceAs(prefix("standardDeviationOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest standardDeviationPriceAs(String retName){
        super.standardDeviation(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest squareRootOfPopulationStandardDeviationPrice(){
        return squareRootOfPopulationStandardDeviationPriceAs(prefix("squareRootOfPopulationStandardDeviationOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest squareRootOfPopulationStandardDeviationPriceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest sampleVariancePrice(){
        return sampleVariancePriceAs(prefix("sampleVarianceOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest sampleVariancePriceAs(String retName){
        super.sampleVariance(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest samplePopulationVariancePrice(){
        return samplePopulationVariancePriceAs(prefix("samplePopulationVarianceOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest samplePopulationVariancePriceAs(String retName){
        super.samplePopulationVariance(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest minStock(){
        return minStockAs(prefix("minOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest minStockAs(String retName){
        super.min(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest maxStock(){
        return maxStockAs(prefix("maxOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest maxStockAs(String retName){
        super.max(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest sumStock(){
        return sumStockAs(prefix("sumOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest sumStockAs(String retName){
        super.sum(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest avgStock(){
        return avgStockAs(prefix("avgOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest avgStockAs(String retName){
        super.avg(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest standardDeviationStock(){
        return standardDeviationStockAs(prefix("standardDeviationOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest standardDeviationStockAs(String retName){
        super.standardDeviation(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest squareRootOfPopulationStandardDeviationStock(){
        return squareRootOfPopulationStandardDeviationStockAs(prefix("squareRootOfPopulationStandardDeviationOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest squareRootOfPopulationStandardDeviationStockAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest sampleVarianceStock(){
        return sampleVarianceStockAs(prefix("sampleVarianceOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest sampleVarianceStockAs(String retName){
        super.sampleVariance(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest samplePopulationVarianceStock(){
        return samplePopulationVarianceStockAs(prefix("samplePopulationVarianceOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest samplePopulationVarianceStockAs(String retName){
        super.samplePopulationVariance(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest<T> groupByVendingMachineWithDetails(){
       return groupByVendingMachineWithDetails(Q.vendingMachines().unlimited());
    }

    public ProductRequest<T> groupByVendingMachineWithDetails(VendingMachineRequest subRequest){
       aggregate(Product.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }




    public ProductRequest<T> groupByVendingOrderItemsWithDetails(VendingOrderItemRequest subRequest){
       aggregate(Product.VENDING_ORDER_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }

    public ProductRequest<T> groupById(){
       groupBy(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIdAs(String retName){
       groupBy(retName, Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.ID_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByName(){
       groupBy(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByNameAs(String retName){
       groupBy(retName, Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.NAME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByPrice(){
       groupBy(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByPriceAs(String retName){
       groupBy(retName, Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByPriceWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.PRICE_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByStock(){
       groupBy(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByStockAs(String retName){
       groupBy(retName, Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByStockWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.STOCK_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByImageUrl(){
       groupBy(Product.IMAGE_URL_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByImageUrlAs(String retName){
       groupBy(retName, Product.IMAGE_URL_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByImageUrlWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.IMAGE_URL_PROPERTY, function);
       return this;
    }
    public ProductRequest<T> groupByVendingMachineWith(VendingMachineRequest subRequest){
       groupBy(Product.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByVendingMachine(){
       groupBy(Product.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVendingMachineAs(String retName){
       groupBy(retName, Product.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVendingMachineWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.VENDING_MACHINE_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByCreateTime(){
       groupBy(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByUpdateTime(){
       groupBy(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByVersion(){
       groupBy(Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.VERSION_PROPERTY, function);
       return this;
    }



    public ProductRequest<T> orderByIdAscending(){
       addOrderByAscending(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByIdDescending(){
       addOrderByDescending(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameAscending(){
       addOrderByAscending(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameDescending(){
       addOrderByDescending(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByPriceAscending(){
       addOrderByAscending(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByPriceDescending(){
       addOrderByDescending(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByStockAscending(){
       addOrderByAscending(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByStockDescending(){
       addOrderByDescending(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByImageUrlAscending(){
       addOrderByAscending(Product.IMAGE_URL_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByImageUrlDescending(){
       addOrderByDescending(Product.IMAGE_URL_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByImageUrlAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Product.IMAGE_URL_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByImageUrlDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Product.IMAGE_URL_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByVendingMachineAscending(){
       addOrderByAscending(Product.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByVendingMachineDescending(){
       addOrderByDescending(Product.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByVersionAscending(){
       addOrderByAscending(Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByVersionDescending(){
       addOrderByDescending(Product.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest<T> statsFromVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
       return statsFromVendingOrderItemsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(VendingOrderItem.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromVendingOrderItems(VendingOrderItemRequest subRequest){
       return statsFromVendingOrderItemsAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest rollUpToVendingMachine(){
       VendingMachineRequest vendingMachine = Q.vendingMachines().unlimited();
       this.withVendingMachineMatching(vendingMachine)
           .groupByVendingMachineWith(vendingMachine);
       return vendingMachine;
    }




    public ProductRequest<T> countVendingOrderItems(){
        return countVendingOrderItemsAs("Count");
    }

    public ProductRequest<T> countVendingOrderItemsAs(String name){
        return countVendingOrderItemsWith(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> countVendingOrderItemsWith(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> minQuantityOfVendingOrderItems(){
        return minQuantityOfVendingOrderItemsAs("minQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> minQuantityOfVendingOrderItemsAs(String name){
        return minQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> minQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public ProductRequest<T> maxQuantityOfVendingOrderItems(){
        return maxQuantityOfVendingOrderItemsAs("maxQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> maxQuantityOfVendingOrderItemsAs(String name){
        return maxQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> maxQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public ProductRequest<T> sumQuantityOfVendingOrderItems(){
        return sumQuantityOfVendingOrderItemsAs("sumQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> sumQuantityOfVendingOrderItemsAs(String name){
        return sumQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sumQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public ProductRequest<T> avgQuantityOfVendingOrderItems(){
        return avgQuantityOfVendingOrderItemsAs("avgQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> avgQuantityOfVendingOrderItemsAs(String name){
        return avgQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> avgQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public ProductRequest<T> standardDeviationQuantityOfVendingOrderItems(){
        return standardDeviationQuantityOfVendingOrderItemsAs("stdDevQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> standardDeviationQuantityOfVendingOrderItemsAs(String name){
        return standardDeviationQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs("stdDevPopQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public ProductRequest<T> sampleVarianceQuantityOfVendingOrderItems(){
        return sampleVarianceQuantityOfVendingOrderItemsAs("varSampQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> sampleVarianceQuantityOfVendingOrderItemsAs(String name){
        return sampleVarianceQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public ProductRequest<T> samplePopulationVarianceQuantityOfVendingOrderItems(){
        return samplePopulationVarianceQuantityOfVendingOrderItemsAs("varPopQuantityOfVendingOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfVendingOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public ProductRequest<T> minPriceOfVendingOrderItems(){
        return minPriceOfVendingOrderItemsAs("minPriceOfVendingOrderItems");
    }

    public ProductRequest<T> minPriceOfVendingOrderItemsAs(String name){
        return minPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> minPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minPrice(), true);
    }
    public ProductRequest<T> maxPriceOfVendingOrderItems(){
        return maxPriceOfVendingOrderItemsAs("maxPriceOfVendingOrderItems");
    }

    public ProductRequest<T> maxPriceOfVendingOrderItemsAs(String name){
        return maxPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> maxPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxPrice(), true);
    }
    public ProductRequest<T> sumPriceOfVendingOrderItems(){
        return sumPriceOfVendingOrderItemsAs("sumPriceOfVendingOrderItems");
    }

    public ProductRequest<T> sumPriceOfVendingOrderItemsAs(String name){
        return sumPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sumPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumPrice(), true);
    }
    public ProductRequest<T> avgPriceOfVendingOrderItems(){
        return avgPriceOfVendingOrderItemsAs("avgPriceOfVendingOrderItems");
    }

    public ProductRequest<T> avgPriceOfVendingOrderItemsAs(String name){
        return avgPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> avgPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgPrice(), true);
    }
    public ProductRequest<T> standardDeviationPriceOfVendingOrderItems(){
        return standardDeviationPriceOfVendingOrderItemsAs("stdDevPriceOfVendingOrderItems");
    }

    public ProductRequest<T> standardDeviationPriceOfVendingOrderItemsAs(String name){
        return standardDeviationPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationPrice(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs("stdDevPopPriceOfVendingOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationPriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationPrice(), true);
    }
    public ProductRequest<T> sampleVariancePriceOfVendingOrderItems(){
        return sampleVariancePriceOfVendingOrderItemsAs("varSampPriceOfVendingOrderItems");
    }

    public ProductRequest<T> sampleVariancePriceOfVendingOrderItemsAs(String name){
        return sampleVariancePriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sampleVariancePriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVariancePrice(), true);
    }
    public ProductRequest<T> samplePopulationVariancePriceOfVendingOrderItems(){
        return samplePopulationVariancePriceOfVendingOrderItemsAs("varPopPriceOfVendingOrderItems");
    }

    public ProductRequest<T> samplePopulationVariancePriceOfVendingOrderItemsAs(String name){
        return samplePopulationVariancePriceOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVariancePriceOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVariancePrice(), true);
    }
    public ProductRequest<T> minAmountOfVendingOrderItems(){
        return minAmountOfVendingOrderItemsAs("minAmountOfVendingOrderItems");
    }

    public ProductRequest<T> minAmountOfVendingOrderItemsAs(String name){
        return minAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> minAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.minAmount(), true);
    }
    public ProductRequest<T> maxAmountOfVendingOrderItems(){
        return maxAmountOfVendingOrderItemsAs("maxAmountOfVendingOrderItems");
    }

    public ProductRequest<T> maxAmountOfVendingOrderItemsAs(String name){
        return maxAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> maxAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.maxAmount(), true);
    }
    public ProductRequest<T> sumAmountOfVendingOrderItems(){
        return sumAmountOfVendingOrderItemsAs("sumAmountOfVendingOrderItems");
    }

    public ProductRequest<T> sumAmountOfVendingOrderItemsAs(String name){
        return sumAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sumAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sumAmount(), true);
    }
    public ProductRequest<T> avgAmountOfVendingOrderItems(){
        return avgAmountOfVendingOrderItemsAs("avgAmountOfVendingOrderItems");
    }

    public ProductRequest<T> avgAmountOfVendingOrderItemsAs(String name){
        return avgAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> avgAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.avgAmount(), true);
    }
    public ProductRequest<T> standardDeviationAmountOfVendingOrderItems(){
        return standardDeviationAmountOfVendingOrderItemsAs("stdDevAmountOfVendingOrderItems");
    }

    public ProductRequest<T> standardDeviationAmountOfVendingOrderItemsAs(String name){
        return standardDeviationAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItems(){
        return squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs("stdDevPopAmountOfVendingOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public ProductRequest<T> sampleVarianceAmountOfVendingOrderItems(){
        return sampleVarianceAmountOfVendingOrderItemsAs("varSampAmountOfVendingOrderItems");
    }

    public ProductRequest<T> sampleVarianceAmountOfVendingOrderItemsAs(String name){
        return sampleVarianceAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public ProductRequest<T> samplePopulationVarianceAmountOfVendingOrderItems(){
        return samplePopulationVarianceAmountOfVendingOrderItemsAs("varPopAmountOfVendingOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceAmountOfVendingOrderItemsAs(String name){
        return samplePopulationVarianceAmountOfVendingOrderItemsAs(name, Q.vendingOrderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceAmountOfVendingOrderItemsAs(String name, VendingOrderItemRequest subRequest){
        return statsFromVendingOrderItemsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public ProductRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine){
       return facetByVendingMachineAs(facetName, vendingMachine, true);
   }

   public ProductRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine, boolean includeAllFacets){
       addFacet(facetName, Product.VENDING_MACHINE_PROPERTY, vendingMachine, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ProductRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ProductRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ProductRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ProductRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ProductRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}