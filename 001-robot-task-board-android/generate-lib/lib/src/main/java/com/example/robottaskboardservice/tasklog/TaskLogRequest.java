package com.example.robottaskboardservice.tasklog;

import com.example.robottaskboardservice.Q;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class TaskLogRequest<T extends TaskLog> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TaskLogRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TaskLogRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TaskLogRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TaskLogRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TaskLogRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TaskLogRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TaskLogRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TaskLogRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TaskLogRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TaskLogRequest<T> matchingAnyOf(TaskLogRequest taskLog){
        super.internalMatchAny(taskLog);
        return this;
    }

    public TaskLogRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TaskLogRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TaskLogRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TaskLogRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectQuery().selectCreatedBy().selectTaskIdOnly().selectCreateTime().selectVersion();
    }

    public TaskLogRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TaskLogRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectQuery().selectCreatedBy().selectTask().selectCreateTime().selectVersion();
    }

    public TaskLogRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectQuery().selectCreatedBy().selectTask().selectCreateTime().selectVersion();
    }


    public TaskLogRequest<T> selectId(){
       selectProperty(TaskLog.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskLogRequest<T> unselectId(){
       unselectProperty(TaskLog.ID_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> selectQuery(){
       selectProperty(TaskLog.QUERY_PROPERTY);
       return this;
    }

    /**
     * fill the query with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  query) to fetch query property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskLogRequest<T> unselectQuery(){
       unselectProperty(TaskLog.QUERY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> selectCreatedBy(){
       selectProperty(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }

    /**
     * fill the createdBy with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdBy) to fetch createdBy property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskLogRequest<T> unselectCreatedBy(){
       unselectProperty(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> selectTaskIdOnly(){
       selectProperty(TaskLog.TASK_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> selectTask(){
        return selectTaskWith(Q.tasks().unlimited().selectSelf());
    }

    public TaskLogRequest<T> selectTaskWith(TaskRequest task){
       selectProperty(TaskLog.TASK_PROPERTY);
       enhanceRelation(TaskLog.TASK_PROPERTY, task);
       return this;
    }

    public TaskLogRequest<T> unselectTask(){
       unselectProperty(TaskLog.TASK_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> selectCreateTime(){
       selectProperty(TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskLogRequest<T> unselectCreateTime(){
       unselectProperty(TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> selectVersion(){
       selectProperty(TaskLog.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaskLogRequest<T> unselectVersion(){
       unselectProperty(TaskLog.VERSION_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.ID_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TaskLogRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TaskLogRequest<T> filterByQuery(String... query){
      if (query == null || query.length == 0) {
        throw new IllegalArgumentException("filterByQuery parameter query cannot be empty");
      }
      return appendSearchCriteria(createQueryCriteria(Operator.EQUAL, (Object[])query));
    }

    public TaskLogRequest<T> withQuery(Operator operator, Object... values){
       return appendSearchCriteria(createQueryCriteria(operator, values));
    }

    public TaskLogRequest<T> withQueryIsUnknown(){
       return withQuery(Operator.IS_NULL);
    }

    public TaskLogRequest<T> withQueryIsKnown(){
       return withQuery(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQueryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.QUERY_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> withQueryGreaterThan(String query){
       return withQuery(Operator.GREATER_THAN, query);
    }

    public TaskLogRequest<T> withQueryGreaterThanOrEqualTo(String query){
       return withQuery(Operator.GREATER_THAN_OR_EQUAL, query);
    }

    public TaskLogRequest<T> withQueryLessThan(String query){
       return withQuery(Operator.LESS_THAN, query);
    }

    public TaskLogRequest<T> withQueryLessThanOrEqualTo(String query){
       return withQuery(Operator.LESS_THAN_OR_EQUAL, query);
    }

    public TaskLogRequest<T> withQueryBetween(String startOfQuery, String endOfQuery){
       return withQuery(Operator.BETWEEN, startOfQuery, endOfQuery);
    }
    public TaskLogRequest<T> withQueryStartingWith(String query){
       return withQuery(Operator.BEGIN_WITH, query);
    }
    public TaskLogRequest<T> withQueryContaining(String query){
       return withQuery(Operator.CONTAIN, query);
    }

    public TaskLogRequest<T> withQueryEndingWith(String query){
       return withQuery(Operator.END_WITH, query);
    }

    public TaskLogRequest<T> withQueryIs(String query){
       return withQuery(Operator.EQUAL, query);
    }

    public TaskLogRequest<T> withQuerySoundingLike(String query){
       return withQuery(Operator.SOUNDS_LIKE, query);
    }



    public TaskLogRequest<T> filterByCreatedBy(String... createdBy){
      if (createdBy == null || createdBy.length == 0) {
        throw new IllegalArgumentException("filterByCreatedBy parameter createdBy cannot be empty");
      }
      return appendSearchCriteria(createCreatedByCriteria(Operator.EQUAL, (Object[])createdBy));
    }

    public TaskLogRequest<T> withCreatedBy(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedByCriteria(operator, values));
    }

    public TaskLogRequest<T> withCreatedByIsUnknown(){
       return withCreatedBy(Operator.IS_NULL);
    }

    public TaskLogRequest<T> withCreatedByIsKnown(){
       return withCreatedBy(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedByCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.CREATED_BY_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> withCreatedByGreaterThan(String createdBy){
       return withCreatedBy(Operator.GREATER_THAN, createdBy);
    }

    public TaskLogRequest<T> withCreatedByGreaterThanOrEqualTo(String createdBy){
       return withCreatedBy(Operator.GREATER_THAN_OR_EQUAL, createdBy);
    }

    public TaskLogRequest<T> withCreatedByLessThan(String createdBy){
       return withCreatedBy(Operator.LESS_THAN, createdBy);
    }

    public TaskLogRequest<T> withCreatedByLessThanOrEqualTo(String createdBy){
       return withCreatedBy(Operator.LESS_THAN_OR_EQUAL, createdBy);
    }

    public TaskLogRequest<T> withCreatedByBetween(String startOfCreatedBy, String endOfCreatedBy){
       return withCreatedBy(Operator.BETWEEN, startOfCreatedBy, endOfCreatedBy);
    }
    public TaskLogRequest<T> withCreatedByStartingWith(String createdBy){
       return withCreatedBy(Operator.BEGIN_WITH, createdBy);
    }
    public TaskLogRequest<T> withCreatedByContaining(String createdBy){
       return withCreatedBy(Operator.CONTAIN, createdBy);
    }

    public TaskLogRequest<T> withCreatedByEndingWith(String createdBy){
       return withCreatedBy(Operator.END_WITH, createdBy);
    }

    public TaskLogRequest<T> withCreatedByIs(String createdBy){
       return withCreatedBy(Operator.EQUAL, createdBy);
    }

    public TaskLogRequest<T> withCreatedBySoundingLike(String createdBy){
       return withCreatedBy(Operator.SOUNDS_LIKE, createdBy);
    }



    public TaskLogRequest<T> filterByTask(Task... task){
      if (task == null || task.length == 0) {
        throw new IllegalArgumentException("filterByTask parameter task cannot be empty");
      }
      return appendSearchCriteria(createTaskCriteria(Operator.EQUAL, (Object[])task));
    }

    public TaskLogRequest<T> withTask(Operator operator, Object... values){
       return appendSearchCriteria(createTaskCriteria(operator, values));
    }

    public TaskLogRequest<T> withTaskIsUnknown(){
       return withTask(Operator.IS_NULL);
    }

    public TaskLogRequest<T> withTaskIsKnown(){
       return withTask(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTaskCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.TASK_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> filterByTask(Long task){
      if(task == null){
         return this;
      }
      return withTask(Operator.EQUAL, task);
    }
    public TaskLogRequest<T> withTaskMatching(TaskRequest task){
       return appendSearchCriteria(new SubQuerySearchCriteria(TaskLog.TASK_PROPERTY, task, Task.ID_PROPERTY));
    }

    public TaskLogRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TaskLogRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TaskLogRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TaskLogRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.CREATE_TIME_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TaskLogRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TaskLogRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TaskLogRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaskLogRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TaskLogRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TaskLogRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TaskLogRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TaskLogRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaskLog.VERSION_PROPERTY, operator, values);
    }

    public TaskLogRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TaskLogRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TaskLogRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TaskLogRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TaskLogRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public TaskLogRequest<T> count(){
        super.count();
        return this;
    }
    public TaskLogRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TaskLogRequest<T> groupByTaskWithDetails(){
       return groupByTaskWithDetails(Q.tasks().unlimited());
    }

    public TaskLogRequest<T> groupByTaskWithDetails(TaskRequest subRequest){
       aggregate(TaskLog.TASK_PROPERTY, subRequest);
       return this;
    }




    public TaskLogRequest<T> groupById(){
       groupBy(TaskLog.ID_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByIdAs(String retName){
       groupBy(retName, TaskLog.ID_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.ID_PROPERTY, function);
       return this;
    }

    public TaskLogRequest<T> groupByQuery(){
       groupBy(TaskLog.QUERY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByQueryAs(String retName){
       groupBy(retName, TaskLog.QUERY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByQueryWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.QUERY_PROPERTY, function);
       return this;
    }

    public TaskLogRequest<T> groupByCreatedBy(){
       groupBy(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByCreatedByAs(String retName){
       groupBy(retName, TaskLog.CREATED_BY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByCreatedByWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.CREATED_BY_PROPERTY, function);
       return this;
    }
    public TaskLogRequest<T> groupByTaskWith(TaskRequest subRequest){
       groupBy(TaskLog.TASK_PROPERTY, subRequest);
       return this;
    }
    public TaskLogRequest<T> groupByTask(){
       groupBy(TaskLog.TASK_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByTaskAs(String retName){
       groupBy(retName, TaskLog.TASK_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByTaskWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.TASK_PROPERTY, function);
       return this;
    }

    public TaskLogRequest<T> groupByCreateTime(){
       groupBy(TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TaskLogRequest<T> groupByVersion(){
       groupBy(TaskLog.VERSION_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TaskLog.VERSION_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaskLog.VERSION_PROPERTY, function);
       return this;
    }



    public TaskLogRequest<T> orderByIdAscending(){
       addOrderByAscending(TaskLog.ID_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByIdDescending(){
       addOrderByDescending(TaskLog.ID_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByQueryAscending(){
       addOrderByAscending(TaskLog.QUERY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByQueryDescending(){
       addOrderByDescending(TaskLog.QUERY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> orderByQueryAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TaskLog.QUERY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByQueryDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TaskLog.QUERY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> orderByCreatedByAscending(){
       addOrderByAscending(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByCreatedByDescending(){
       addOrderByDescending(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> orderByCreatedByAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByCreatedByDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TaskLog.CREATED_BY_PROPERTY);
       return this;
    }
    public TaskLogRequest<T> orderByTaskAscending(){
       addOrderByAscending(TaskLog.TASK_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByTaskDescending(){
       addOrderByDescending(TaskLog.TASK_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(TaskLog.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByVersionAscending(){
       addOrderByAscending(TaskLog.VERSION_PROPERTY);
       return this;
    }

    public TaskLogRequest<T> orderByVersionDescending(){
       addOrderByDescending(TaskLog.VERSION_PROPERTY);
       return this;
    }


    public TaskRequest rollUpToTask(){
       TaskRequest task = Q.tasks().unlimited();
       this.withTaskMatching(task)
           .groupByTaskWith(task);
       return task;
    }




   public TaskLogRequest<T> facetByTaskAs(String facetName, TaskRequest task){
       return facetByTaskAs(facetName, task, true);
   }

   public TaskLogRequest<T> facetByTaskAs(String facetName, TaskRequest task, boolean includeAllFacets){
       addFacet(facetName, TaskLog.TASK_PROPERTY, task, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TaskLogRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TaskLogRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TaskLogRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TaskLogRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TaskLogRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}