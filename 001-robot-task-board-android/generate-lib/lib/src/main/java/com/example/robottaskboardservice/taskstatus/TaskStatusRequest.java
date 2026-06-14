package com.example.robottaskboardservice.taskstatus;

import com.example.robottaskboardservice.Q;
import com.example.robottaskboardservice.platform.Platform;
import com.example.robottaskboardservice.platform.PlatformRequest;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class TaskStatusRequest<T extends TaskStatus> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TaskStatusRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TaskStatusRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TaskStatusRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TaskStatusRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TaskStatusRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TaskStatusRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TaskStatusRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TaskStatusRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TaskStatusRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TaskStatusRequest<T> matchingAnyOf(TaskStatusRequest taskStatus){
        super.internalMatchAny(taskStatus);
        return this;
    }

    public TaskStatusRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TaskStatusRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TaskStatusRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TaskStatusRequest<T> selectSelf(){
        super.selectSelf();
        return selectPlatformIdOnly().selectId().selectName().selectCode().selectVersion();
    }

    public TaskStatusRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TaskStatusRequest<T> selectAll(){
        super.selectAll();
        return selectPlatform().selectId().selectName().selectCode().selectVersion();
    }

    public TaskStatusRequest<T> selectChildren(){
        super.selectAny();
        selectTaskList();
        return selectPlatform().selectId().selectName().selectCode().selectVersion();
    }


    public TaskStatusRequest<T> selectPlatformIdOnly(){
       selectProperty(TaskStatus.PLATFORM_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> selectPlatform(){
        return selectPlatformWith(Q.platforms().unlimited().selectSelf());
    }

    public TaskStatusRequest<T> selectPlatformWith(PlatformRequest platform){
       selectProperty(TaskStatus.PLATFORM_PROPERTY);
       enhanceRelation(TaskStatus.PLATFORM_PROPERTY, platform);
       return this;
    }

    public TaskStatusRequest<T> unselectPlatform(){
       unselectProperty(TaskStatus.PLATFORM_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> selectId(){
       selectProperty(TaskStatus.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskStatusRequest<T> unselectId(){
       unselectProperty(TaskStatus.ID_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> selectName(){
       selectProperty(TaskStatus.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskStatusRequest<T> unselectName(){
       unselectProperty(TaskStatus.NAME_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> selectCode(){
       selectProperty(TaskStatus.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskStatusRequest<T> unselectCode(){
       unselectProperty(TaskStatus.CODE_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> selectVersion(){
       selectProperty(TaskStatus.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskStatusRequest<T> unselectVersion(){
       unselectProperty(TaskStatus.VERSION_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> selectTaskList(){
       return selectTaskListWith(Q.tasks().selectSelf());
    }

    public TaskStatusRequest<T> selectTaskListWith(TaskRequest taskList){
       enhanceRelation(TaskStatus.TASK_LIST_PROPERTY, taskList);
       return this;
    }

    public TaskStatusRequest<T> filterByPlatform(Platform... platform){
      if (platform == null || platform.length == 0) {
        throw new IllegalArgumentException("filterByPlatform parameter platform cannot be empty");
      }
      return appendSearchCriteria(createPlatformCriteria(Operator.EQUAL, (Object[])platform));
    }

    public TaskStatusRequest<T> withPlatform(Operator operator, Object... values){
       return appendSearchCriteria(createPlatformCriteria(operator, values));
    }

    public TaskStatusRequest<T> withPlatformIsUnknown(){
       return withPlatform(Operator.IS_NULL);
    }

    public TaskStatusRequest<T> withPlatformIsKnown(){
       return withPlatform(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlatformCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskStatus.PLATFORM_PROPERTY, operator, values);
    }

    public TaskStatusRequest<T> filterByPlatform(Long platform){
      if(platform == null){
         return this;
      }
      return withPlatform(Operator.EQUAL, platform);
    }
    public TaskStatusRequest<T> withPlatformMatching(PlatformRequest platform){
       return appendSearchCriteria(new SubQuerySearchCriteria(TaskStatus.PLATFORM_PROPERTY, platform, Platform.ID_PROPERTY));
    }

    public TaskStatusRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskStatus.ID_PROPERTY, operator, values);
    }

    public TaskStatusRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TaskStatusRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TaskStatusRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public TaskStatusRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public TaskStatusRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public TaskStatusRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskStatus.NAME_PROPERTY, operator, values);
    }

    public TaskStatusRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public TaskStatusRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public TaskStatusRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public TaskStatusRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public TaskStatusRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public TaskStatusRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public TaskStatusRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public TaskStatusRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public TaskStatusRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public TaskStatusRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public TaskStatusRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public TaskStatusRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public TaskStatusRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public TaskStatusRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskStatus.CODE_PROPERTY, operator, values);
    }

    public TaskStatusRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public TaskStatusRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public TaskStatusRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public TaskStatusRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public TaskStatusRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public TaskStatusRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public TaskStatusRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public TaskStatusRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public TaskStatusRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public TaskStatusRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public TaskStatusRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TaskStatusRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TaskStatusRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TaskStatusRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskStatus.VERSION_PROPERTY, operator, values);
    }

    public TaskStatusRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TaskStatusRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TaskStatusRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TaskStatusRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TaskStatusRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TaskStatusRequest<T> withTaskListMatching(TaskRequest taskRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TaskStatus.ID_PROPERTY, taskRequest, Task.STATUS_PROPERTY));
    }

    public TaskStatusRequest<T> withoutTaskListMatching(TaskRequest taskRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TaskStatus.ID_PROPERTY, taskRequest, Task.STATUS_PROPERTY)));
    }

    public TaskStatusRequest<T> haveTasks(){
        return withTaskListMatching(Q.tasks().unlimited());
    }

    public TaskStatusRequest<T> haveNoTasks(){
        return withoutTaskListMatching(Q.tasks().unlimited());
    }

    public TaskStatusRequest<T> count(){
        super.count();
        return this;
    }
    public TaskStatusRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TaskStatusRequest<T> groupByPlatformWithDetails(){
       return groupByPlatformWithDetails(Q.platforms().unlimited());
    }

    public TaskStatusRequest<T> groupByPlatformWithDetails(PlatformRequest subRequest){
       aggregate(TaskStatus.PLATFORM_PROPERTY, subRequest);
       return this;
    }





    public TaskStatusRequest<T> groupByTasksWithDetails(TaskRequest subRequest){
       aggregate(TaskStatus.TASK_LIST_PROPERTY, subRequest);
       return this;
    }

    public TaskStatusRequest<T> groupByPlatformWith(PlatformRequest subRequest){
       groupBy(TaskStatus.PLATFORM_PROPERTY, subRequest);
       return this;
    }
    public TaskStatusRequest<T> groupByPlatform(){
       groupBy(TaskStatus.PLATFORM_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByPlatformAs(String retName){
       groupBy(retName, TaskStatus.PLATFORM_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByPlatformWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskStatus.PLATFORM_PROPERTY, function);
       return this;
    }

    public TaskStatusRequest<T> groupById(){
       groupBy(TaskStatus.ID_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByIdAs(String retName){
       groupBy(retName, TaskStatus.ID_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskStatus.ID_PROPERTY, function);
       return this;
    }

    public TaskStatusRequest<T> groupByName(){
       groupBy(TaskStatus.NAME_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByNameAs(String retName){
       groupBy(retName, TaskStatus.NAME_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskStatus.NAME_PROPERTY, function);
       return this;
    }

    public TaskStatusRequest<T> groupByCode(){
       groupBy(TaskStatus.CODE_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByCodeAs(String retName){
       groupBy(retName, TaskStatus.CODE_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskStatus.CODE_PROPERTY, function);
       return this;
    }

    public TaskStatusRequest<T> groupByVersion(){
       groupBy(TaskStatus.VERSION_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TaskStatus.VERSION_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskStatus.VERSION_PROPERTY, function);
       return this;
    }



    public TaskStatusRequest<T> orderByPlatformAscending(){
       addOrderByAscending(TaskStatus.PLATFORM_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByPlatformDescending(){
       addOrderByDescending(TaskStatus.PLATFORM_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByIdAscending(){
       addOrderByAscending(TaskStatus.ID_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByIdDescending(){
       addOrderByDescending(TaskStatus.ID_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByNameAscending(){
       addOrderByAscending(TaskStatus.NAME_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByNameDescending(){
       addOrderByDescending(TaskStatus.NAME_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TaskStatus.NAME_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TaskStatus.NAME_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> orderByCodeAscending(){
       addOrderByAscending(TaskStatus.CODE_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByCodeDescending(){
       addOrderByDescending(TaskStatus.CODE_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TaskStatus.CODE_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TaskStatus.CODE_PROPERTY);
       return this;
    }
    public TaskStatusRequest<T> orderByVersionAscending(){
       addOrderByAscending(TaskStatus.VERSION_PROPERTY);
       return this;
    }

    public TaskStatusRequest<T> orderByVersionDescending(){
       addOrderByDescending(TaskStatus.VERSION_PROPERTY);
       return this;
    }


    public TaskStatusRequest<T> statsFromTasksAs(String name, TaskRequest subRequest){
       return statsFromTasksAs(name, subRequest, false);
    }

    public TaskStatusRequest<T> statsFromTasksAs(String name, TaskRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Task.STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TaskStatusRequest<T> statsFromTasks(TaskRequest subRequest){
       return statsFromTasksAs(REFINEMENTS, subRequest);
    }
    public PlatformRequest rollUpToPlatform(){
       PlatformRequest platform = Q.platforms().unlimited();
       this.withPlatformMatching(platform)
           .groupByPlatformWith(platform);
       return platform;
    }





    public TaskStatusRequest<T> countTasks(){
        return countTasksAs("Count");
    }

    public TaskStatusRequest<T> countTasksAs(String name){
        return countTasksWith(name, Q.tasks().unlimited());
    }

    public TaskStatusRequest<T> countTasksWith(String name, TaskRequest subRequest){
        return statsFromTasksAs(name, subRequest.count(), true);
    }

   public TaskStatusRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform){
       return facetByPlatformAs(facetName, platform, true);
   }

   public TaskStatusRequest<T> facetByPlatformAs(String facetName, PlatformRequest platform, boolean includeAllFacets){
       addFacet(facetName, TaskStatus.PLATFORM_PROPERTY, platform, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TaskStatusRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TaskStatusRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TaskStatusRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TaskStatusRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TaskStatusRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}