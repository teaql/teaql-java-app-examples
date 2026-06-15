package com.example.fifaworldcupservice.goalcategory;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalRequest;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class GoalCategoryRequest<T extends GoalCategory> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public GoalCategoryRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public GoalCategoryRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public GoalCategoryRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public GoalCategoryRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public GoalCategoryRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public GoalCategoryRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public GoalCategoryRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (GoalCategoryRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public GoalCategoryRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public GoalCategoryRequest<T> matchingAnyOf(GoalCategoryRequest goalCategory){
        super.internalMatchAny(goalCategory);
        return this;
    }

    public GoalCategoryRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public GoalCategoryRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public GoalCategoryRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public GoalCategoryRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectTournamentIdOnly().selectVersion();
    }

    public GoalCategoryRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public GoalCategoryRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }

    public GoalCategoryRequest<T> selectChildren(){
        super.selectAny();
        selectMatchGoalList();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }


    public GoalCategoryRequest<T> selectId(){
       selectProperty(GoalCategory.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GoalCategoryRequest<T> unselectId(){
       unselectProperty(GoalCategory.ID_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> selectName(){
       selectProperty(GoalCategory.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GoalCategoryRequest<T> unselectName(){
       unselectProperty(GoalCategory.NAME_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> selectCode(){
       selectProperty(GoalCategory.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GoalCategoryRequest<T> unselectCode(){
       unselectProperty(GoalCategory.CODE_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> selectTournamentIdOnly(){
       selectProperty(GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public GoalCategoryRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(GoalCategory.TOURNAMENT_PROPERTY);
       enhanceRelation(GoalCategory.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public GoalCategoryRequest<T> unselectTournament(){
       unselectProperty(GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> selectVersion(){
       selectProperty(GoalCategory.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GoalCategoryRequest<T> unselectVersion(){
       unselectProperty(GoalCategory.VERSION_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> selectMatchGoalList(){
       return selectMatchGoalListWith(Q.matchGoals().selectSelf());
    }

    public GoalCategoryRequest<T> selectMatchGoalListWith(MatchGoalRequest matchGoalList){
       enhanceRelation(GoalCategory.MATCH_GOAL_LIST_PROPERTY, matchGoalList);
       return this;
    }

    public GoalCategoryRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GoalCategory.ID_PROPERTY, operator, values);
    }

    public GoalCategoryRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public GoalCategoryRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public GoalCategoryRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public GoalCategoryRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public GoalCategoryRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public GoalCategoryRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GoalCategory.NAME_PROPERTY, operator, values);
    }

    public GoalCategoryRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public GoalCategoryRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public GoalCategoryRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public GoalCategoryRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public GoalCategoryRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public GoalCategoryRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public GoalCategoryRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public GoalCategoryRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public GoalCategoryRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public GoalCategoryRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public GoalCategoryRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public GoalCategoryRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public GoalCategoryRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public GoalCategoryRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GoalCategory.CODE_PROPERTY, operator, values);
    }

    public GoalCategoryRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public GoalCategoryRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public GoalCategoryRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public GoalCategoryRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public GoalCategoryRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public GoalCategoryRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public GoalCategoryRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public GoalCategoryRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public GoalCategoryRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public GoalCategoryRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public GoalCategoryRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public GoalCategoryRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public GoalCategoryRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public GoalCategoryRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GoalCategory.TOURNAMENT_PROPERTY, operator, values);
    }

    public GoalCategoryRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public GoalCategoryRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(GoalCategory.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public GoalCategoryRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public GoalCategoryRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public GoalCategoryRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public GoalCategoryRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GoalCategory.VERSION_PROPERTY, operator, values);
    }

    public GoalCategoryRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public GoalCategoryRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public GoalCategoryRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public GoalCategoryRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public GoalCategoryRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public GoalCategoryRequest<T> withMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(GoalCategory.ID_PROPERTY, matchGoalRequest, MatchGoal.GOAL_CATEGORY_PROPERTY));
    }

    public GoalCategoryRequest<T> withoutMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(GoalCategory.ID_PROPERTY, matchGoalRequest, MatchGoal.GOAL_CATEGORY_PROPERTY)));
    }

    public GoalCategoryRequest<T> haveMatchGoals(){
        return withMatchGoalListMatching(Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> haveNoMatchGoals(){
        return withoutMatchGoalListMatching(Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> count(){
        super.count();
        return this;
    }
    public GoalCategoryRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public GoalCategoryRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public GoalCategoryRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(GoalCategory.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }


    public GoalCategoryRequest<T> groupByMatchGoalsWithDetails(MatchGoalRequest subRequest){
       aggregate(GoalCategory.MATCH_GOAL_LIST_PROPERTY, subRequest);
       return this;
    }

    public GoalCategoryRequest<T> groupById(){
       groupBy(GoalCategory.ID_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByIdAs(String retName){
       groupBy(retName, GoalCategory.ID_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, GoalCategory.ID_PROPERTY, function);
       return this;
    }

    public GoalCategoryRequest<T> groupByName(){
       groupBy(GoalCategory.NAME_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByNameAs(String retName){
       groupBy(retName, GoalCategory.NAME_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, GoalCategory.NAME_PROPERTY, function);
       return this;
    }

    public GoalCategoryRequest<T> groupByCode(){
       groupBy(GoalCategory.CODE_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByCodeAs(String retName){
       groupBy(retName, GoalCategory.CODE_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, GoalCategory.CODE_PROPERTY, function);
       return this;
    }
    public GoalCategoryRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(GoalCategory.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public GoalCategoryRequest<T> groupByTournament(){
       groupBy(GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, GoalCategory.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public GoalCategoryRequest<T> groupByVersion(){
       groupBy(GoalCategory.VERSION_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByVersionAs(String retName){
       groupBy(retName, GoalCategory.VERSION_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, GoalCategory.VERSION_PROPERTY, function);
       return this;
    }



    public GoalCategoryRequest<T> orderByIdAscending(){
       addOrderByAscending(GoalCategory.ID_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByIdDescending(){
       addOrderByDescending(GoalCategory.ID_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByNameAscending(){
       addOrderByAscending(GoalCategory.NAME_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByNameDescending(){
       addOrderByDescending(GoalCategory.NAME_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(GoalCategory.NAME_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(GoalCategory.NAME_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> orderByCodeAscending(){
       addOrderByAscending(GoalCategory.CODE_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByCodeDescending(){
       addOrderByDescending(GoalCategory.CODE_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(GoalCategory.CODE_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(GoalCategory.CODE_PROPERTY);
       return this;
    }
    public GoalCategoryRequest<T> orderByTournamentAscending(){
       addOrderByAscending(GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByTournamentDescending(){
       addOrderByDescending(GoalCategory.TOURNAMENT_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByVersionAscending(){
       addOrderByAscending(GoalCategory.VERSION_PROPERTY);
       return this;
    }

    public GoalCategoryRequest<T> orderByVersionDescending(){
       addOrderByDescending(GoalCategory.VERSION_PROPERTY);
       return this;
    }


    public GoalCategoryRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(name, subRequest, false);
    }

    public GoalCategoryRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchGoal.GOAL_CATEGORY_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public GoalCategoryRequest<T> statsFromMatchGoals(MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }


    public GoalCategoryRequest<T> countMatchGoals(){
        return countMatchGoalsAs("Count");
    }

    public GoalCategoryRequest<T> countMatchGoalsAs(String name){
        return countMatchGoalsWith(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> countMatchGoalsWith(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.count(), true);
    }
    public GoalCategoryRequest<T> minMinuteScoredOfMatchGoals(){
        return minMinuteScoredOfMatchGoalsAs("minMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> minMinuteScoredOfMatchGoalsAs(String name){
        return minMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> minMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.minMinuteScored(), true);
    }
    public GoalCategoryRequest<T> maxMinuteScoredOfMatchGoals(){
        return maxMinuteScoredOfMatchGoalsAs("maxMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> maxMinuteScoredOfMatchGoalsAs(String name){
        return maxMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> maxMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.maxMinuteScored(), true);
    }
    public GoalCategoryRequest<T> sumMinuteScoredOfMatchGoals(){
        return sumMinuteScoredOfMatchGoalsAs("sumMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> sumMinuteScoredOfMatchGoalsAs(String name){
        return sumMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> sumMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sumMinuteScored(), true);
    }
    public GoalCategoryRequest<T> avgMinuteScoredOfMatchGoals(){
        return avgMinuteScoredOfMatchGoalsAs("avgMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> avgMinuteScoredOfMatchGoalsAs(String name){
        return avgMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> avgMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.avgMinuteScored(), true);
    }
    public GoalCategoryRequest<T> standardDeviationMinuteScoredOfMatchGoals(){
        return standardDeviationMinuteScoredOfMatchGoalsAs("stdDevMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return standardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.standardDeviationMinuteScored(), true);
    }
    public GoalCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoals(){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs("stdDevPopMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteScored(), true);
    }
    public GoalCategoryRequest<T> sampleVarianceMinuteScoredOfMatchGoals(){
        return sampleVarianceMinuteScoredOfMatchGoalsAs("varSampMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name){
        return sampleVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sampleVarianceMinuteScored(), true);
    }
    public GoalCategoryRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoals(){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs("varPopMinuteScoredOfMatchGoals");
    }

    public GoalCategoryRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public GoalCategoryRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.samplePopulationVarianceMinuteScored(), true);
    }

   public GoalCategoryRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public GoalCategoryRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, GoalCategory.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public GoalCategoryRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public GoalCategoryRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public GoalCategoryRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public GoalCategoryRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public GoalCategoryRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}