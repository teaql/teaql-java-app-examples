package com.doublechaintech.vendingmachineservice.paymentstatus;

import com.doublechaintech.vendingmachineservice.Q;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment;
import com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentRequest;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class PaymentStatusRequest<T extends PaymentStatus> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentStatusRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentStatusRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentStatusRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentStatusRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentStatusRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentStatusRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentStatusRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentStatusRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentStatusRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentStatusRequest<T> matchingAnyOf(PaymentStatusRequest paymentStatus){
        super.internalMatchAny(paymentStatus);
        return this;
    }

    public PaymentStatusRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentStatusRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentStatusRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentStatusRequest<T> selectSelf(){
        super.selectSelf();
        return selectVendingMachineIdOnly().selectId().selectName().selectCode().selectVersion();
    }

    public PaymentStatusRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentStatusRequest<T> selectAll(){
        super.selectAll();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }

    public PaymentStatusRequest<T> selectChildren(){
        super.selectAny();
        selectOrderPaymentList();
        return selectVendingMachine().selectId().selectName().selectCode().selectVersion();
    }


    public PaymentStatusRequest<T> selectVendingMachineIdOnly(){
       selectProperty(PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> selectVendingMachine(){
        return selectVendingMachineWith(Q.vendingMachines().unlimited().selectSelf());
    }

    public PaymentStatusRequest<T> selectVendingMachineWith(VendingMachineRequest vendingMachine){
       selectProperty(PaymentStatus.VENDING_MACHINE_PROPERTY);
       enhanceRelation(PaymentStatus.VENDING_MACHINE_PROPERTY, vendingMachine);
       return this;
    }

    public PaymentStatusRequest<T> unselectVendingMachine(){
       unselectProperty(PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> selectId(){
       selectProperty(PaymentStatus.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentStatusRequest<T> unselectId(){
       unselectProperty(PaymentStatus.ID_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> selectName(){
       selectProperty(PaymentStatus.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentStatusRequest<T> unselectName(){
       unselectProperty(PaymentStatus.NAME_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> selectCode(){
       selectProperty(PaymentStatus.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentStatusRequest<T> unselectCode(){
       unselectProperty(PaymentStatus.CODE_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> selectVersion(){
       selectProperty(PaymentStatus.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentStatusRequest<T> unselectVersion(){
       unselectProperty(PaymentStatus.VERSION_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> selectOrderPaymentList(){
       return selectOrderPaymentListWith(Q.orderPayments().selectSelf());
    }

    public PaymentStatusRequest<T> selectOrderPaymentListWith(OrderPaymentRequest orderPaymentList){
       enhanceRelation(PaymentStatus.ORDER_PAYMENT_LIST_PROPERTY, orderPaymentList);
       return this;
    }

    public PaymentStatusRequest<T> filterByVendingMachine(VendingMachine... vendingMachine){
      if (vendingMachine == null || vendingMachine.length == 0) {
        throw new IllegalArgumentException("filterByVendingMachine parameter vendingMachine cannot be empty");
      }
      return appendSearchCriteria(createVendingMachineCriteria(Operator.EQUAL, (Object[])vendingMachine));
    }

    public PaymentStatusRequest<T> withVendingMachine(Operator operator, Object... values){
       return appendSearchCriteria(createVendingMachineCriteria(operator, values));
    }

    public PaymentStatusRequest<T> withVendingMachineIsUnknown(){
       return withVendingMachine(Operator.IS_NULL);
    }

    public PaymentStatusRequest<T> withVendingMachineIsKnown(){
       return withVendingMachine(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVendingMachineCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentStatus.VENDING_MACHINE_PROPERTY, operator, values);
    }

    public PaymentStatusRequest<T> filterByVendingMachine(Long vendingMachine){
      if(vendingMachine == null){
         return this;
      }
      return withVendingMachine(Operator.EQUAL, vendingMachine);
    }
    public PaymentStatusRequest<T> withVendingMachineMatching(VendingMachineRequest vendingMachine){
       return appendSearchCriteria(new SubQuerySearchCriteria(PaymentStatus.VENDING_MACHINE_PROPERTY, vendingMachine, VendingMachine.ID_PROPERTY));
    }

    public PaymentStatusRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentStatus.ID_PROPERTY, operator, values);
    }

    public PaymentStatusRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentStatusRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentStatusRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public PaymentStatusRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public PaymentStatusRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public PaymentStatusRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentStatus.NAME_PROPERTY, operator, values);
    }

    public PaymentStatusRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public PaymentStatusRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public PaymentStatusRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public PaymentStatusRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public PaymentStatusRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public PaymentStatusRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public PaymentStatusRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public PaymentStatusRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public PaymentStatusRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public PaymentStatusRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public PaymentStatusRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public PaymentStatusRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public PaymentStatusRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public PaymentStatusRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentStatus.CODE_PROPERTY, operator, values);
    }

    public PaymentStatusRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public PaymentStatusRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public PaymentStatusRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public PaymentStatusRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public PaymentStatusRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public PaymentStatusRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public PaymentStatusRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public PaymentStatusRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public PaymentStatusRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public PaymentStatusRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public PaymentStatusRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentStatusRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentStatusRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentStatusRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentStatus.VERSION_PROPERTY, operator, values);
    }

    public PaymentStatusRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentStatusRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentStatusRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentStatusRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentStatusRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PaymentStatusRequest<T> withOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PaymentStatus.ID_PROPERTY, orderPaymentRequest, OrderPayment.PAYMENT_STATUS_PROPERTY));
    }

    public PaymentStatusRequest<T> withoutOrderPaymentListMatching(OrderPaymentRequest orderPaymentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PaymentStatus.ID_PROPERTY, orderPaymentRequest, OrderPayment.PAYMENT_STATUS_PROPERTY)));
    }

    public PaymentStatusRequest<T> haveOrderPayments(){
        return withOrderPaymentListMatching(Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> haveNoOrderPayments(){
        return withoutOrderPaymentListMatching(Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentStatusRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentStatusRequest<T> groupByVendingMachineWithDetails(){
       return groupByVendingMachineWithDetails(Q.vendingMachines().unlimited());
    }

    public PaymentStatusRequest<T> groupByVendingMachineWithDetails(VendingMachineRequest subRequest){
       aggregate(PaymentStatus.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }





    public PaymentStatusRequest<T> groupByOrderPaymentsWithDetails(OrderPaymentRequest subRequest){
       aggregate(PaymentStatus.ORDER_PAYMENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public PaymentStatusRequest<T> groupByVendingMachineWith(VendingMachineRequest subRequest){
       groupBy(PaymentStatus.VENDING_MACHINE_PROPERTY, subRequest);
       return this;
    }
    public PaymentStatusRequest<T> groupByVendingMachine(){
       groupBy(PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByVendingMachineAs(String retName){
       groupBy(retName, PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByVendingMachineWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentStatus.VENDING_MACHINE_PROPERTY, function);
       return this;
    }

    public PaymentStatusRequest<T> groupById(){
       groupBy(PaymentStatus.ID_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByIdAs(String retName){
       groupBy(retName, PaymentStatus.ID_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentStatus.ID_PROPERTY, function);
       return this;
    }

    public PaymentStatusRequest<T> groupByName(){
       groupBy(PaymentStatus.NAME_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByNameAs(String retName){
       groupBy(retName, PaymentStatus.NAME_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentStatus.NAME_PROPERTY, function);
       return this;
    }

    public PaymentStatusRequest<T> groupByCode(){
       groupBy(PaymentStatus.CODE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByCodeAs(String retName){
       groupBy(retName, PaymentStatus.CODE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentStatus.CODE_PROPERTY, function);
       return this;
    }

    public PaymentStatusRequest<T> groupByVersion(){
       groupBy(PaymentStatus.VERSION_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PaymentStatus.VERSION_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentStatus.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentStatusRequest<T> orderByVendingMachineAscending(){
       addOrderByAscending(PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByVendingMachineDescending(){
       addOrderByDescending(PaymentStatus.VENDING_MACHINE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByIdAscending(){
       addOrderByAscending(PaymentStatus.ID_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByIdDescending(){
       addOrderByDescending(PaymentStatus.ID_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByNameAscending(){
       addOrderByAscending(PaymentStatus.NAME_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByNameDescending(){
       addOrderByDescending(PaymentStatus.NAME_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentStatus.NAME_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentStatus.NAME_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> orderByCodeAscending(){
       addOrderByAscending(PaymentStatus.CODE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByCodeDescending(){
       addOrderByDescending(PaymentStatus.CODE_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentStatus.CODE_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentStatus.CODE_PROPERTY);
       return this;
    }
    public PaymentStatusRequest<T> orderByVersionAscending(){
       addOrderByAscending(PaymentStatus.VERSION_PROPERTY);
       return this;
    }

    public PaymentStatusRequest<T> orderByVersionDescending(){
       addOrderByDescending(PaymentStatus.VERSION_PROPERTY);
       return this;
    }


    public PaymentStatusRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(name, subRequest, false);
    }

    public PaymentStatusRequest<T> statsFromOrderPaymentsAs(String name, OrderPaymentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderPayment.PAYMENT_STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentStatusRequest<T> statsFromOrderPayments(OrderPaymentRequest subRequest){
       return statsFromOrderPaymentsAs(REFINEMENTS, subRequest);
    }
    public VendingMachineRequest rollUpToVendingMachine(){
       VendingMachineRequest vendingMachine = Q.vendingMachines().unlimited();
       this.withVendingMachineMatching(vendingMachine)
           .groupByVendingMachineWith(vendingMachine);
       return vendingMachine;
    }





    public PaymentStatusRequest<T> countOrderPayments(){
        return countOrderPaymentsAs("Count");
    }

    public PaymentStatusRequest<T> countOrderPaymentsAs(String name){
        return countOrderPaymentsWith(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> countOrderPaymentsWith(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.count(), true);
    }
    public PaymentStatusRequest<T> minAmountOfOrderPayments(){
        return minAmountOfOrderPaymentsAs("minAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> minAmountOfOrderPaymentsAs(String name){
        return minAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> minAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.minAmount(), true);
    }
    public PaymentStatusRequest<T> maxAmountOfOrderPayments(){
        return maxAmountOfOrderPaymentsAs("maxAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> maxAmountOfOrderPaymentsAs(String name){
        return maxAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> maxAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.maxAmount(), true);
    }
    public PaymentStatusRequest<T> sumAmountOfOrderPayments(){
        return sumAmountOfOrderPaymentsAs("sumAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> sumAmountOfOrderPaymentsAs(String name){
        return sumAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> sumAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sumAmount(), true);
    }
    public PaymentStatusRequest<T> avgAmountOfOrderPayments(){
        return avgAmountOfOrderPaymentsAs("avgAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> avgAmountOfOrderPaymentsAs(String name){
        return avgAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> avgAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.avgAmount(), true);
    }
    public PaymentStatusRequest<T> standardDeviationAmountOfOrderPayments(){
        return standardDeviationAmountOfOrderPaymentsAs("stdDevAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name){
        return standardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> standardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public PaymentStatusRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPayments(){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs("stdDevPopAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> squareRootOfPopulationStandardDeviationAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public PaymentStatusRequest<T> sampleVarianceAmountOfOrderPayments(){
        return sampleVarianceAmountOfOrderPaymentsAs("varSampAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name){
        return sampleVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> sampleVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public PaymentStatusRequest<T> samplePopulationVarianceAmountOfOrderPayments(){
        return samplePopulationVarianceAmountOfOrderPaymentsAs("varPopAmountOfOrderPayments");
    }

    public PaymentStatusRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name){
        return samplePopulationVarianceAmountOfOrderPaymentsAs(name, Q.orderPayments().unlimited());
    }

    public PaymentStatusRequest<T> samplePopulationVarianceAmountOfOrderPaymentsAs(String name, OrderPaymentRequest subRequest){
        return statsFromOrderPaymentsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public PaymentStatusRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine){
       return facetByVendingMachineAs(facetName, vendingMachine, true);
   }

   public PaymentStatusRequest<T> facetByVendingMachineAs(String facetName, VendingMachineRequest vendingMachine, boolean includeAllFacets){
       addFacet(facetName, PaymentStatus.VENDING_MACHINE_PROPERTY, vendingMachine, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentStatusRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentStatusRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentStatusRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentStatusRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentStatusRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}