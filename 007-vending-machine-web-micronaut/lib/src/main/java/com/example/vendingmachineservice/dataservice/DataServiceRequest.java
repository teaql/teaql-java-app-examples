package com.example.vendingmachineservice.dataservice;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class DataServiceRequest<T extends DataService> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public DataServiceRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public DataServiceRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public DataServiceRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public DataServiceRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public DataServiceRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public DataServiceRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public DataServiceRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (DataServiceRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public DataServiceRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public DataServiceRequest<T> matchingAnyOf(DataServiceRequest dataService){
        super.internalMatchAny(dataService);
        return this;
    }

    public DataServiceRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public DataServiceRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public DataServiceRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public DataServiceRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectJdbcInfo().selectVersion();
    }

    public DataServiceRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public DataServiceRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectJdbcInfo().selectVersion();
    }

    public DataServiceRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectJdbcInfo().selectVersion();
    }


    public DataServiceRequest<T> selectId(){
       selectProperty(DataService.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DataServiceRequest<T> unselectId(){
       unselectProperty(DataService.ID_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> selectName(){
       selectProperty(DataService.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DataServiceRequest<T> unselectName(){
       unselectProperty(DataService.NAME_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> selectJdbcInfo(){
       selectProperty(DataService.JDBC_INFO_PROPERTY);
       return this;
    }

    /**
     * fill the jdbcInfo with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  jdbcInfo) to fetch jdbcInfo property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DataServiceRequest<T> unselectJdbcInfo(){
       unselectProperty(DataService.JDBC_INFO_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> selectVersion(){
       selectProperty(DataService.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DataServiceRequest<T> unselectVersion(){
       unselectProperty(DataService.VERSION_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(DataService.ID_PROPERTY, operator, values);
    }

    public DataServiceRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public DataServiceRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public DataServiceRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public DataServiceRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public DataServiceRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public DataServiceRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(DataService.NAME_PROPERTY, operator, values);
    }

    public DataServiceRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public DataServiceRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public DataServiceRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public DataServiceRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public DataServiceRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public DataServiceRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public DataServiceRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public DataServiceRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public DataServiceRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public DataServiceRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public DataServiceRequest<T> filterByJdbcInfo(String... jdbcInfo){
      if (jdbcInfo == null || jdbcInfo.length == 0) {
        throw new IllegalArgumentException("filterByJdbcInfo parameter jdbcInfo cannot be empty");
      }
      return appendSearchCriteria(createJdbcInfoCriteria(Operator.EQUAL, (Object[])jdbcInfo));
    }

    public DataServiceRequest<T> withJdbcInfo(Operator operator, Object... values){
       return appendSearchCriteria(createJdbcInfoCriteria(operator, values));
    }

    public DataServiceRequest<T> withJdbcInfoIsUnknown(){
       return withJdbcInfo(Operator.IS_NULL);
    }

    public DataServiceRequest<T> withJdbcInfoIsKnown(){
       return withJdbcInfo(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createJdbcInfoCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(DataService.JDBC_INFO_PROPERTY, operator, values);
    }

    public DataServiceRequest<T> withJdbcInfoGreaterThan(String jdbcInfo){
       return withJdbcInfo(Operator.GREATER_THAN, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoGreaterThanOrEqualTo(String jdbcInfo){
       return withJdbcInfo(Operator.GREATER_THAN_OR_EQUAL, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoLessThan(String jdbcInfo){
       return withJdbcInfo(Operator.LESS_THAN, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoLessThanOrEqualTo(String jdbcInfo){
       return withJdbcInfo(Operator.LESS_THAN_OR_EQUAL, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoBetween(String startOfJdbcInfo, String endOfJdbcInfo){
       return withJdbcInfo(Operator.BETWEEN, startOfJdbcInfo, endOfJdbcInfo);
    }
    public DataServiceRequest<T> withJdbcInfoStartingWith(String jdbcInfo){
       return withJdbcInfo(Operator.BEGIN_WITH, jdbcInfo);
    }
    public DataServiceRequest<T> withJdbcInfoContaining(String jdbcInfo){
       return withJdbcInfo(Operator.CONTAIN, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoEndingWith(String jdbcInfo){
       return withJdbcInfo(Operator.END_WITH, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoIs(String jdbcInfo){
       return withJdbcInfo(Operator.EQUAL, jdbcInfo);
    }

    public DataServiceRequest<T> withJdbcInfoSoundingLike(String jdbcInfo){
       return withJdbcInfo(Operator.SOUNDS_LIKE, jdbcInfo);
    }



    public DataServiceRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public DataServiceRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public DataServiceRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public DataServiceRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(DataService.VERSION_PROPERTY, operator, values);
    }

    public DataServiceRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public DataServiceRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public DataServiceRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public DataServiceRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public DataServiceRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public DataServiceRequest<T> count(){
        super.count();
        return this;
    }
    public DataServiceRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }

    public DataServiceRequest<T> groupById(){
       groupBy(DataService.ID_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByIdAs(String retName){
       groupBy(retName, DataService.ID_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, DataService.ID_PROPERTY, function);
       return this;
    }

    public DataServiceRequest<T> groupByName(){
       groupBy(DataService.NAME_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByNameAs(String retName){
       groupBy(retName, DataService.NAME_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, DataService.NAME_PROPERTY, function);
       return this;
    }

    public DataServiceRequest<T> groupByJdbcInfo(){
       groupBy(DataService.JDBC_INFO_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByJdbcInfoAs(String retName){
       groupBy(retName, DataService.JDBC_INFO_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByJdbcInfoWithFunction(String retName, AggrFunction function){
       groupBy(retName, DataService.JDBC_INFO_PROPERTY, function);
       return this;
    }

    public DataServiceRequest<T> groupByVersion(){
       groupBy(DataService.VERSION_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByVersionAs(String retName){
       groupBy(retName, DataService.VERSION_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, DataService.VERSION_PROPERTY, function);
       return this;
    }



    public DataServiceRequest<T> orderByIdAscending(){
       addOrderByAscending(DataService.ID_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByIdDescending(){
       addOrderByDescending(DataService.ID_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByNameAscending(){
       addOrderByAscending(DataService.NAME_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByNameDescending(){
       addOrderByDescending(DataService.NAME_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(DataService.NAME_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(DataService.NAME_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> orderByJdbcInfoAscending(){
       addOrderByAscending(DataService.JDBC_INFO_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByJdbcInfoDescending(){
       addOrderByDescending(DataService.JDBC_INFO_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> orderByJdbcInfoAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(DataService.JDBC_INFO_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByJdbcInfoDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(DataService.JDBC_INFO_PROPERTY);
       return this;
    }
    public DataServiceRequest<T> orderByVersionAscending(){
       addOrderByAscending(DataService.VERSION_PROPERTY);
       return this;
    }

    public DataServiceRequest<T> orderByVersionDescending(){
       addOrderByDescending(DataService.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public DataServiceRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public DataServiceRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public DataServiceRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public DataServiceRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public DataServiceRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}