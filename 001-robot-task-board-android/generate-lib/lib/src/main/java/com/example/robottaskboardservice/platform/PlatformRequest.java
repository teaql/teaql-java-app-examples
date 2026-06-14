package com.example.robottaskboardservice.platform;

import com.example.robottaskboardservice.Q;
import com.example.robottaskboardservice.task.Task;
import com.example.robottaskboardservice.task.TaskRequest;
import com.example.robottaskboardservice.taskstatus.TaskStatus;
import com.example.robottaskboardservice.taskstatus.TaskStatusRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class PlatformRequest<T extends Platform> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PlatformRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PlatformRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PlatformRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PlatformRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PlatformRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PlatformRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PlatformRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PlatformRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PlatformRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PlatformRequest<T> matchingAnyOf(PlatformRequest platform){
        super.internalMatchAny(platform);
        return this;
    }

    public PlatformRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PlatformRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PlatformRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PlatformRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PlatformRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PlatformRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PlatformRequest<T> selectChildren(){
        super.selectAny();
        selectTaskStatusList().selectTaskList();
        return selectId().selectName().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PlatformRequest<T> selectId(){
       selectProperty(Platform.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PlatformRequest<T> unselectId(){
       unselectProperty(Platform.ID_PROPERTY);
       return this;
    }
    public PlatformRequest<T> selectName(){
       selectProperty(Platform.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PlatformRequest<T> unselectName(){
       unselectProperty(Platform.NAME_PROPERTY);
       return this;
    }
    public PlatformRequest<T> selectCreateTime(){
       selectProperty(Platform.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PlatformRequest<T> unselectCreateTime(){
       unselectProperty(Platform.CREATE_TIME_PROPERTY);
       return this;
    }
    public PlatformRequest<T> selectUpdateTime(){
       selectProperty(Platform.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PlatformRequest<T> unselectUpdateTime(){
       unselectProperty(Platform.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PlatformRequest<T> selectVersion(){
       selectProperty(Platform.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PlatformRequest<T> unselectVersion(){
       unselectProperty(Platform.VERSION_PROPERTY);
       return this;
    }
    public PlatformRequest<T> selectTaskStatusList(){
       return selectTaskStatusListWith(Q.taskStatuses().selectSelf());
    }

    public PlatformRequest<T> selectTaskStatusListWith(TaskStatusRequest taskStatusList){
       enhanceRelation(Platform.TASK_STATUS_LIST_PROPERTY, taskStatusList);
       return this;
    }
    public PlatformRequest<T> selectTaskList(){
       return selectTaskListWith(Q.tasks().selectSelf());
    }

    public PlatformRequest<T> selectTaskListWith(TaskRequest taskList){
       enhanceRelation(Platform.TASK_LIST_PROPERTY, taskList);
       return this;
    }

    public PlatformRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Platform.ID_PROPERTY, operator, values);
    }

    public PlatformRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PlatformRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PlatformRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public PlatformRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public PlatformRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public PlatformRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Platform.NAME_PROPERTY, operator, values);
    }

    public PlatformRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public PlatformRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public PlatformRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public PlatformRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public PlatformRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public PlatformRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public PlatformRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public PlatformRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public PlatformRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public PlatformRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public PlatformRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PlatformRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PlatformRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PlatformRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Platform.CREATE_TIME_PROPERTY, operator, values);
    }

    public PlatformRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PlatformRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PlatformRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PlatformRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PlatformRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PlatformRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PlatformRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PlatformRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PlatformRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Platform.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PlatformRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PlatformRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PlatformRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PlatformRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PlatformRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PlatformRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PlatformRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Platform.VERSION_PROPERTY, operator, values);
    }

    public PlatformRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PlatformRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PlatformRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PlatformRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PlatformRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PlatformRequest<T> withTaskStatusListMatching(TaskStatusRequest taskStatusRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Platform.ID_PROPERTY, taskStatusRequest, TaskStatus.PLATFORM_PROPERTY));
    }

    public PlatformRequest<T> withoutTaskStatusListMatching(TaskStatusRequest taskStatusRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Platform.ID_PROPERTY, taskStatusRequest, TaskStatus.PLATFORM_PROPERTY)));
    }

    public PlatformRequest<T> haveTaskStatuses(){
        return withTaskStatusListMatching(Q.taskStatuses().unlimited());
    }

    public PlatformRequest<T> haveNoTaskStatuses(){
        return withoutTaskStatusListMatching(Q.taskStatuses().unlimited());
    }
    public PlatformRequest<T> withTaskListMatching(TaskRequest taskRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Platform.ID_PROPERTY, taskRequest, Task.PLATFORM_PROPERTY));
    }

    public PlatformRequest<T> withoutTaskListMatching(TaskRequest taskRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Platform.ID_PROPERTY, taskRequest, Task.PLATFORM_PROPERTY)));
    }

    public PlatformRequest<T> haveTasks(){
        return withTaskListMatching(Q.tasks().unlimited());
    }

    public PlatformRequest<T> haveNoTasks(){
        return withoutTaskListMatching(Q.tasks().unlimited());
    }

    public PlatformRequest<T> count(){
        super.count();
        return this;
    }
    public PlatformRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PlatformRequest<T> groupByTaskStatusesWithDetails(TaskStatusRequest subRequest){
       aggregate(Platform.TASK_STATUS_LIST_PROPERTY, subRequest);
       return this;
    }
    public PlatformRequest<T> groupByTasksWithDetails(TaskRequest subRequest){
       aggregate(Platform.TASK_LIST_PROPERTY, subRequest);
       return this;
    }

    public PlatformRequest<T> groupById(){
       groupBy(Platform.ID_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByIdAs(String retName){
       groupBy(retName, Platform.ID_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Platform.ID_PROPERTY, function);
       return this;
    }

    public PlatformRequest<T> groupByName(){
       groupBy(Platform.NAME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByNameAs(String retName){
       groupBy(retName, Platform.NAME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Platform.NAME_PROPERTY, function);
       return this;
    }

    public PlatformRequest<T> groupByCreateTime(){
       groupBy(Platform.CREATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Platform.CREATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Platform.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PlatformRequest<T> groupByUpdateTime(){
       groupBy(Platform.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Platform.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Platform.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PlatformRequest<T> groupByVersion(){
       groupBy(Platform.VERSION_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Platform.VERSION_PROPERTY);
       return this;
    }

    public PlatformRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Platform.VERSION_PROPERTY, function);
       return this;
    }



    public PlatformRequest<T> orderByIdAscending(){
       addOrderByAscending(Platform.ID_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByIdDescending(){
       addOrderByDescending(Platform.ID_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByNameAscending(){
       addOrderByAscending(Platform.NAME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByNameDescending(){
       addOrderByDescending(Platform.NAME_PROPERTY);
       return this;
    }
    public PlatformRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Platform.NAME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Platform.NAME_PROPERTY);
       return this;
    }
    public PlatformRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Platform.CREATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Platform.CREATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Platform.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Platform.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByVersionAscending(){
       addOrderByAscending(Platform.VERSION_PROPERTY);
       return this;
    }

    public PlatformRequest<T> orderByVersionDescending(){
       addOrderByDescending(Platform.VERSION_PROPERTY);
       return this;
    }


    public PlatformRequest<T> statsFromTaskStatusesAs(String name, TaskStatusRequest subRequest){
       return statsFromTaskStatusesAs(name, subRequest, false);
    }

    public PlatformRequest<T> statsFromTaskStatusesAs(String name, TaskStatusRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TaskStatus.PLATFORM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PlatformRequest<T> statsFromTaskStatuses(TaskStatusRequest subRequest){
       return statsFromTaskStatusesAs(REFINEMENTS, subRequest);
    }
    public PlatformRequest<T> statsFromTasksAs(String name, TaskRequest subRequest){
       return statsFromTasksAs(name, subRequest, false);
    }

    public PlatformRequest<T> statsFromTasksAs(String name, TaskRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Task.PLATFORM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PlatformRequest<T> statsFromTasks(TaskRequest subRequest){
       return statsFromTasksAs(REFINEMENTS, subRequest);
    }
    public PlatformRequest<T> countTaskStatuses(){
        return countTaskStatusesAs("Count");
    }

    public PlatformRequest<T> countTaskStatusesAs(String name){
        return countTaskStatusesWith(name, Q.taskStatuses().unlimited());
    }

    public PlatformRequest<T> countTaskStatusesWith(String name, TaskStatusRequest subRequest){
        return statsFromTaskStatusesAs(name, subRequest.count(), true);
    }
    public PlatformRequest<T> countTasks(){
        return countTasksAs("Count");
    }

    public PlatformRequest<T> countTasksAs(String name){
        return countTasksWith(name, Q.tasks().unlimited());
    }

    public PlatformRequest<T> countTasksWith(String name, TaskRequest subRequest){
        return statsFromTasksAs(name, subRequest.count(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public PlatformRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PlatformRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PlatformRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PlatformRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PlatformRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}