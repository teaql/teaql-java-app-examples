package com.example.vendingmachineservice.paymentmethod;

import com.example.vendingmachineservice.Q;
import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentRequest;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class PaymentMethodRequest<T extends PaymentMethod> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentMethodRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentMethodRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentMethodRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentMethodRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentMethodRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentMethodRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentMethodRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentMethodRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentMethodRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentMethodRequest<T> matchingAnyOf(PaymentMethodRequest paymentMethod){
        super.internalMatchAny(paymentMethod);
        return this;
    }

    public PaymentMethodRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentMethodRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentMethodRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentMethodRequest<T> selectSelf(){
        super.selectSelf();
        return selectVendingMachineIdOnly().selectId().selectName().selectCode().selectVersion();
    }

    public PaymentMethodRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentMethodRequest<T> selectAll(){
        super.selectAll();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }

    public PaymentMethodRequest<T> selectChildren(){
        super.selectAny();
        selectOrderPaymentList();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }


    public PaymentMethodRequest<T> selectVendingMachineIdOnly(){
       selectProperty(PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> selectVendingMachine(){
        return selectVendingMachineWith(Q.vendingMachines().unlimited().selectSelf());
    }

    public PaymentMethodRequest<T> selectVendingMachineWith(VendingMachineRequest vendingMachine){
       selectProperty(PaymentMethod.VENDING_MACHINE_PROPERTY);
       enhanceRelation(PaymentMethod.VENDING_MACHINE_PROPERTY, vendingMachine);
       return this;
    }

    public PaymentMethodRequest<T> unselectVendingMachine(){
       unselectProperty(PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectId(){
       selectProperty(PaymentMethod.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectId(){
       unselectProperty(PaymentMethod.ID_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectName(){
       selectProperty(PaymentMethod.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectName(){
       unselectProperty(PaymentMethod.NAME_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectCode(){
       selectProperty(PaymentMethod.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectCode(){
       unselectProperty(PaymentMethod.CODE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectVersion(){
       selectProperty(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectVersion(){
       unselectProperty(PaymentMethod.VERSION_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectOrderPaymentList(){
       return selectOrderPaymentListWith(Q.orderPayments().selectSelf());
    }

    public PaymentMethodRequest<T> selectOrderPaymentListWith(OrderPaymentRequest orderPaymentList){
       enhanceRelation(PaymentMethod.ORDER_PAYMENT_LIST_PROPERTY, orderPaymentList);
       return this;
    }

    public PaymentMethodRequest<T> filterByVendingMachine(VendingMachine... vendingMachine){
      if (vendingMachine == null || vendingMachine.length == 0) {
        throw new IllegalArgumentException("filterByVendingMachine parameter vendingMachine cannot be empty");
      }
      return appendSearchCriteria(createVendingMachineCriteria(Operator.EQUAL, (Object[])vendingMachine));
    }

    public PaymentMethodRequest<T> withVendingMachine(Operator operator, Object... values){
       return appendSearchCriteria(createVendingMachineCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withVendingMachineIsUnknown(){
       return withVendingMachine(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withVendingMachineIsKnown(){
       return withVendingMachine(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingMachineCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.VENDING_MACHINE_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> filterByVendingMachine(Long vendingMachine){
      if(vendingMachine == null){
         return this;
      }
      return withVendingMachine(Operator.EQUAL, vendingMachine);
    }
    public PaymentMethodRequest<T> withVendingMachineMatching(VendingMachineRequest vendingMachine){
       return appendSearchCriteria(new SubQuerySearchCriteria(PaymentMethod.VENDING_MACHINE_PROPERTY, vendingMachine, VendingMachine.ID_PROPERTY));
    }

    public PaymentMethodRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.ID_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentMethodRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentMethodRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public PaymentMethodRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.NAME_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public PaymentMethodRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public PaymentMethodRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public PaymentMethodRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public PaymentMethodRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public PaymentMethodRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public PaymentMethodRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public PaymentMethodRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public PaymentMethodRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public PaymentMethodRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public PaymentMethodRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public PaymentMethodRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.CODE_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public PaymentMethodRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public PaymentMethodRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public PaymentMethodRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public PaymentMethodRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public PaymentMethodRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public PaymentMethodRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public PaymentMethodRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public PaymentMethodRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public PaymentMethodRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public PaymentMethodRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentMethodRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.VERSION_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentMethodRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentMethodRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentMethodRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentMethodRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PaymentMethodRequest<T> withOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PaymentMethod.ID_PROPERTY, orderPaymentRequest, OrderPayment.PAYMENT_METHOD_PROPERTY));
    }

    public PaymentMethodRequest<T> withoutOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PaymentMethod.ID_PROPERTY, orderPaymentRequest, OrderPayment.PAYMENT_METHOD_PROPERTY)));
    }

    public PaymentMethodRequest<T> haveOrderPayments(){
        return withOrderPaymentListMatching(Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> haveNoOrderPayments(){
        return withoutOrderPaymentListMatching(Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentMethodRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentMethodRequest<T> groupByVendingMachineWithDetails(){
       return groupByVendingMachineWithDetails(Q.vendingMachines().unlimited());
    }

    public PaymentMethodRequest<T> groupByVendingMachineWithDetails(VendingMachineRequest subRequest){
       aggregate(PaymentMethod.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }





    public PaymentMethodRequest<T> groupByOrderPaymentsWithDetails(OrderPaymentRequest subRequest){
       aggregate(PaymentMethod.ORDER_PAYMENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public PaymentMethodRequest<T> groupByVendingMachineWith(VendingMachineRequest subRequest){
       groupBy(PaymentMethod.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }
    public PaymentMethodRequest<T> groupByVendingMachine(){
       groupBy(PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVendingMachineAs(String retName){
       groupBy(retName, PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVendingMachineWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.VENDING_MACHINE_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupById(){
       groupBy(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByIdAs(String retName){
       groupBy(retName, PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.ID_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByName(){
       groupBy(PaymentMethod.NAME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByNameAs(String retName){
       groupBy(retName, PaymentMethod.NAME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.NAME_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByCode(){
       groupBy(PaymentMethod.CODE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByCodeAs(String retName){
       groupBy(retName, PaymentMethod.CODE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.CODE_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersion(){
       groupBy(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentMethodRequest<T> orderByVendingMachineAscending(){
       addOrderByAscending(PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByVendingMachineDescending(){
       addOrderByDescending(PaymentMethod.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByIdAscending(){
       addOrderByAscending(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByIdDescending(){
       addOrderByDescending(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByNameAscending(){
       addOrderByAscending(PaymentMethod.NAME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByNameDescending(){
       addOrderByDescending(PaymentMethod.NAME_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentMethod.NAME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentMethod.NAME_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByCodeAscending(){
       addOrderByAscending(PaymentMethod.CODE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByCodeDescending(){
       addOrderByDescending(PaymentMethod.CODE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentMethod.CODE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentMethod.CODE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByVersionAscending(){
       addOrderByAscending(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByVersionDescending(){
       addOrderByDescending(PaymentMethod.VERSION_PROPERTY);
       return this;
    }


    public PaymentMethodRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(name, subRequest, false);
    }

    public PaymentMethodRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderPayment.PAYMENT_METHOD_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentMethodRequest<T> statsFromOrderPayments(OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest rollUpToVendingMachine(){
       VendingMachineRequest vendingMachine = Q.vendingMachines().unlimited();
       this.withVendingMachineMatching(vendingMachine)
           .groupByVendingMachineWith(vendingMachine);
       return vendingMachine;
    }





    public PaymentMethodRequest<T> countOrderPayments(){
        return countOrderPaymentsAs("Count");
    }

    public PaymentMethodRequest<T> countOrderPaymentsAs(String name){
        return countOrderPaymentsWith(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> countOrderPaymentsWith(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.count(), true);
    }
    public PaymentMethodRequest<T> minAmountOfOrderPayments(){
        return minAmountOfOrderPaymentsAs("minAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> minAmountOfOrderPaymentsAs(String name){
        return minAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> minAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.minAmount(), true);
    }
    public PaymentMethodRequest<T> maxAmountOfOrderPayments(){
        return maxAmountOfOrderPaymentsAs("maxAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> maxAmountOfOrderPaymentsAs(String name){
        return maxAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> maxAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.maxAmount(), true);
    }
    public PaymentMethodRequest<T> sumAmountOfOrderPayments(){
        return sumAmountOfOrderPaymentsAs("sumAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> sumAmountOfOrderPaymentsAs(String name){
        return sumAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> sumAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sumAmount(), true);
    }
    public PaymentMethodRequest<T> avgAmountOfOrderPayments(){
        return avgAmountOfOrderPaymentsAs("avgAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> avgAmountOfOrderPaymentsAs(String name){
        return avgAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> avgAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.avgAmount(), true);
    }
    public PaymentMethodRequest<T> standardDeviationAmountOfOrderPayments(){
        return standardDeviationAmountOfOrderPaymentsAs("stdDevAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name){
        return standardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPayments(){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs("stdDevPopAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public PaymentMethodRequest<T> sampleVarianceAmountOfOrderPayments(){
        return sampleVarianceAmountOfOrderPaymentsAs("varSampAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name){
        return sampleVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public PaymentMethodRequest<T> samplePopulationVarianceAmountOfOrderPayments(){
        return samplePopulationVarianceAmountOfOrderPaymentsAs("varPopAmountOfOrderPayments");
    }

    public PaymentMethodRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name){
        return samplePopulationVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentMethodRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public PaymentMethodRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine){
       return facetByVendingMachineAs(facetName, vendingMachine, true);
   }

   public PaymentMethodRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine, boolean includeAllFacets){
       addFacet(facetName, PaymentMethod.VENDING_MACHINE_PROPERTY, vendingMachine, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentMethodRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentMethodRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentMethodRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentMethodRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentMethodRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}