package com.doublechaintech.vendingmachineservice.orderstatus;

import com.doublechaintech.vendingmachineservice.Q;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class OrderStatusRequest<T extends OrderStatus> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public OrderStatusRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public OrderStatusRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public OrderStatusRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public OrderStatusRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public OrderStatusRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public OrderStatusRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public OrderStatusRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (OrderStatusRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public OrderStatusRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public OrderStatusRequest<T> matchingAnyOf(OrderStatusRequest orderStatus){
        super.internalMatchAny(orderStatus);
        return this;
    }

    public OrderStatusRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public OrderStatusRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public OrderStatusRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public OrderStatusRequest<T> selectSelf(){
        super.selectSelf();
        return selectVendingMachineIdOnly().selectId().selectName().selectCode().selectVersion();
    }

    public OrderStatusRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public OrderStatusRequest<T> selectAll(){
        super.selectAll();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }

    public OrderStatusRequest<T> selectChildren(){
        super.selectAny();
        selectVendingOrderList();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }


    public OrderStatusRequest<T> selectVendingMachineIdOnly(){
       selectProperty(OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> selectVendingMachine(){
        return selectVendingMachineWith(Q.vendingMachines().unlimited().selectSelf());
    }

    public OrderStatusRequest<T> selectVendingMachineWith(VendingMachineRequest vendingMachine){
       selectProperty(OrderStatus.VENDING_MACHINE_PROPERTY);
       enhanceRelation(OrderStatus.VENDING_MACHINE_PROPERTY, vendingMachine);
       return this;
    }

    public OrderStatusRequest<T> unselectVendingMachine(){
       unselectProperty(OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> selectId(){
       selectProperty(OrderStatus.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderStatusRequest<T> unselectId(){
       unselectProperty(OrderStatus.ID_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> selectName(){
       selectProperty(OrderStatus.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderStatusRequest<T> unselectName(){
       unselectProperty(OrderStatus.NAME_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> selectCode(){
       selectProperty(OrderStatus.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderStatusRequest<T> unselectCode(){
       unselectProperty(OrderStatus.CODE_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> selectVersion(){
       selectProperty(OrderStatus.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderStatusRequest<T> unselectVersion(){
       unselectProperty(OrderStatus.VERSION_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> selectVendingOrderList(){
       return selectVendingOrderListWith(Q.vendingOrders().selectSelf());
    }

    public OrderStatusRequest<T> selectVendingOrderListWith(VendingOrderRequest vendingOrderList){
       enhanceRelation(OrderStatus.VENDING_ORDER_LIST_PROPERTY, vendingOrderList);
       return this;
    }

    public OrderStatusRequest<T> filterByVendingMachine(VendingMachine... vendingMachine){
      if (vendingMachine == null || vendingMachine.length == 0) {
        throw new IllegalArgumentException("filterByVendingMachine parameter vendingMachine cannot be empty");
      }
      return appendSearchCriteria(createVendingMachineCriteria(Operator.EQUAL, (Object[])vendingMachine));
    }

    public OrderStatusRequest<T> withVendingMachine(Operator operator, Object... values){
       return appendSearchCriteria(createVendingMachineCriteria(operator, values));
    }

    public OrderStatusRequest<T> withVendingMachineIsUnknown(){
       return withVendingMachine(Operator.IS_NULL);
    }

    public OrderStatusRequest<T> withVendingMachineIsKnown(){
       return withVendingMachine(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingMachineCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderStatus.VENDING_MACHINE_PROPERTY, operator, values);
    }

    public OrderStatusRequest<T> filterByVendingMachine(Long vendingMachine){
      if(vendingMachine == null){
         return this;
      }
      return withVendingMachine(Operator.EQUAL, vendingMachine);
    }
    public OrderStatusRequest<T> withVendingMachineMatching(VendingMachineRequest vendingMachine){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderStatus.VENDING_MACHINE_PROPERTY, vendingMachine, VendingMachine.ID_PROPERTY));
    }

    public OrderStatusRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderStatus.ID_PROPERTY, operator, values);
    }

    public OrderStatusRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public OrderStatusRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public OrderStatusRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public OrderStatusRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public OrderStatusRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public OrderStatusRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderStatus.NAME_PROPERTY, operator, values);
    }

    public OrderStatusRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public OrderStatusRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public OrderStatusRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public OrderStatusRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public OrderStatusRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public OrderStatusRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public OrderStatusRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public OrderStatusRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public OrderStatusRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public OrderStatusRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public OrderStatusRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public OrderStatusRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public OrderStatusRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public OrderStatusRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderStatus.CODE_PROPERTY, operator, values);
    }

    public OrderStatusRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public OrderStatusRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public OrderStatusRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public OrderStatusRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public OrderStatusRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public OrderStatusRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public OrderStatusRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public OrderStatusRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public OrderStatusRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public OrderStatusRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public OrderStatusRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public OrderStatusRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public OrderStatusRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public OrderStatusRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderStatus.VERSION_PROPERTY, operator, values);
    }

    public OrderStatusRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public OrderStatusRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public OrderStatusRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public OrderStatusRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public OrderStatusRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public OrderStatusRequest<T> withVendingOrderListMatching(VendingOrderRequest vendingOrderRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(OrderStatus.ID_PROPERTY, vendingOrderRequest, VendingOrder.STATUS_PROPERTY));
    }

    public OrderStatusRequest<T> withoutVendingOrderListMatching(VendingOrderRequest vendingOrderRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(OrderStatus.ID_PROPERTY, vendingOrderRequest, VendingOrder.STATUS_PROPERTY)));
    }

    public OrderStatusRequest<T> haveVendingOrders(){
        return withVendingOrderListMatching(Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> haveNoVendingOrders(){
        return withoutVendingOrderListMatching(Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> count(){
        super.count();
        return this;
    }
    public OrderStatusRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public OrderStatusRequest<T> groupByVendingMachineWithDetails(){
       return groupByVendingMachineWithDetails(Q.vendingMachines().unlimited());
    }

    public OrderStatusRequest<T> groupByVendingMachineWithDetails(VendingMachineRequest subRequest){
       aggregate(OrderStatus.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }





    public OrderStatusRequest<T> groupByVendingOrdersWithDetails(VendingOrderRequest subRequest){
       aggregate(OrderStatus.VENDING_ORDER_LIST_PROPERTY, subRequest);
       return this;
    }

    public OrderStatusRequest<T> groupByVendingMachineWith(VendingMachineRequest subRequest){
       groupBy(OrderStatus.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }
    public OrderStatusRequest<T> groupByVendingMachine(){
       groupBy(OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByVendingMachineAs(String retName){
       groupBy(retName, OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByVendingMachineWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderStatus.VENDING_MACHINE_PROPERTY, function);
       return this;
    }

    public OrderStatusRequest<T> groupById(){
       groupBy(OrderStatus.ID_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByIdAs(String retName){
       groupBy(retName, OrderStatus.ID_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderStatus.ID_PROPERTY, function);
       return this;
    }

    public OrderStatusRequest<T> groupByName(){
       groupBy(OrderStatus.NAME_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByNameAs(String retName){
       groupBy(retName, OrderStatus.NAME_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderStatus.NAME_PROPERTY, function);
       return this;
    }

    public OrderStatusRequest<T> groupByCode(){
       groupBy(OrderStatus.CODE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByCodeAs(String retName){
       groupBy(retName, OrderStatus.CODE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderStatus.CODE_PROPERTY, function);
       return this;
    }

    public OrderStatusRequest<T> groupByVersion(){
       groupBy(OrderStatus.VERSION_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByVersionAs(String retName){
       groupBy(retName, OrderStatus.VERSION_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderStatus.VERSION_PROPERTY, function);
       return this;
    }



    public OrderStatusRequest<T> orderByVendingMachineAscending(){
       addOrderByAscending(OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByVendingMachineDescending(){
       addOrderByDescending(OrderStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByIdAscending(){
       addOrderByAscending(OrderStatus.ID_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByIdDescending(){
       addOrderByDescending(OrderStatus.ID_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByNameAscending(){
       addOrderByAscending(OrderStatus.NAME_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByNameDescending(){
       addOrderByDescending(OrderStatus.NAME_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OrderStatus.NAME_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OrderStatus.NAME_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> orderByCodeAscending(){
       addOrderByAscending(OrderStatus.CODE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByCodeDescending(){
       addOrderByDescending(OrderStatus.CODE_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(OrderStatus.CODE_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(OrderStatus.CODE_PROPERTY);
       return this;
    }
    public OrderStatusRequest<T> orderByVersionAscending(){
       addOrderByAscending(OrderStatus.VERSION_PROPERTY);
       return this;
    }

    public OrderStatusRequest<T> orderByVersionDescending(){
       addOrderByDescending(OrderStatus.VERSION_PROPERTY);
       return this;
    }


    public OrderStatusRequest<T> statsFromVendingOrdersAs(String name, VendingOrderRequest subRequest){
       return statsFromVendingOrdersAs(name, subRequest, false);
    }

    public OrderStatusRequest<T> statsFromVendingOrdersAs(String name, VendingOrderRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(VendingOrder.STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public OrderStatusRequest<T> statsFromVendingOrders(VendingOrderRequest subRequest){
       return statsFromVendingOrdersAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest rollUpToVendingMachine(){
       VendingMachineRequest vendingMachine = Q.vendingMachines().unlimited();
       this.withVendingMachineMatching(vendingMachine)
           .groupByVendingMachineWith(vendingMachine);
       return vendingMachine;
    }





    public OrderStatusRequest<T> countVendingOrders(){
        return countVendingOrdersAs("Count");
    }

    public OrderStatusRequest<T> countVendingOrdersAs(String name){
        return countVendingOrdersWith(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> countVendingOrdersWith(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.count(), true);
    }
    public OrderStatusRequest<T> minTotalAmountOfVendingOrders(){
        return minTotalAmountOfVendingOrdersAs("minTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> minTotalAmountOfVendingOrdersAs(String name){
        return minTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> minTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.minTotalAmount(), true);
    }
    public OrderStatusRequest<T> maxTotalAmountOfVendingOrders(){
        return maxTotalAmountOfVendingOrdersAs("maxTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> maxTotalAmountOfVendingOrdersAs(String name){
        return maxTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> maxTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.maxTotalAmount(), true);
    }
    public OrderStatusRequest<T> sumTotalAmountOfVendingOrders(){
        return sumTotalAmountOfVendingOrdersAs("sumTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> sumTotalAmountOfVendingOrdersAs(String name){
        return sumTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> sumTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.sumTotalAmount(), true);
    }
    public OrderStatusRequest<T> avgTotalAmountOfVendingOrders(){
        return avgTotalAmountOfVendingOrdersAs("avgTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> avgTotalAmountOfVendingOrdersAs(String name){
        return avgTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> avgTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.avgTotalAmount(), true);
    }
    public OrderStatusRequest<T> standardDeviationTotalAmountOfVendingOrders(){
        return standardDeviationTotalAmountOfVendingOrdersAs("stdDevTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> standardDeviationTotalAmountOfVendingOrdersAs(String name){
        return standardDeviationTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> standardDeviationTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.standardDeviationTotalAmount(), true);
    }
    public OrderStatusRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfVendingOrders(){
        return squareRootOfPopulationStandardDeviationTotalAmountOfVendingOrdersAs("stdDevPopTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfVendingOrdersAs(String name){
        return squareRootOfPopulationStandardDeviationTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.squareRootOfPopulationStandardDeviationTotalAmount(), true);
    }
    public OrderStatusRequest<T> sampleVarianceTotalAmountOfVendingOrders(){
        return sampleVarianceTotalAmountOfVendingOrdersAs("varSampTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> sampleVarianceTotalAmountOfVendingOrdersAs(String name){
        return sampleVarianceTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> sampleVarianceTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.sampleVarianceTotalAmount(), true);
    }
    public OrderStatusRequest<T> samplePopulationVarianceTotalAmountOfVendingOrders(){
        return samplePopulationVarianceTotalAmountOfVendingOrdersAs("varPopTotalAmountOfVendingOrders");
    }

    public OrderStatusRequest<T> samplePopulationVarianceTotalAmountOfVendingOrdersAs(String name){
        return samplePopulationVarianceTotalAmountOfVendingOrdersAs(name, Q.vendingOrders().unlimited());
    }

    public OrderStatusRequest<T> samplePopulationVarianceTotalAmountOfVendingOrdersAs(String name, VendingOrderRequest subRequest){
        return statsFromVendingOrdersAs(name, subRequest.samplePopulationVarianceTotalAmount(), true);
    }

   public OrderStatusRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine){
       return facetByVendingMachineAs(facetName, vendingMachine, true);
   }

   public OrderStatusRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine, boolean includeAllFacets){
       addFacet(facetName, OrderStatus.VENDING_MACHINE_PROPERTY, vendingMachine, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public OrderStatusRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public OrderStatusRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public OrderStatusRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public OrderStatusRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public OrderStatusRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}