package com.example.fifaworldcupservice.matchstage;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentRequest;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class MatchStageRequest<T extends MatchStage> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MatchStageRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MatchStageRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MatchStageRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MatchStageRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MatchStageRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MatchStageRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MatchStageRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MatchStageRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MatchStageRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MatchStageRequest<T> matchingAnyOf(MatchStageRequest matchStage){
        super.internalMatchAny(matchStage);
        return this;
    }

    public MatchStageRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MatchStageRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MatchStageRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MatchStageRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectTournamentIdOnly().selectVersion();
    }

    public MatchStageRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MatchStageRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }

    public MatchStageRequest<T> selectChildren(){
        super.selectAny();
        selectTournamentMatchList();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }


    public MatchStageRequest<T> selectId(){
       selectProperty(MatchStage.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStageRequest<T> unselectId(){
       unselectProperty(MatchStage.ID_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> selectName(){
       selectProperty(MatchStage.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStageRequest<T> unselectName(){
       unselectProperty(MatchStage.NAME_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> selectCode(){
       selectProperty(MatchStage.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStageRequest<T> unselectCode(){
       unselectProperty(MatchStage.CODE_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> selectTournamentIdOnly(){
       selectProperty(MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public MatchStageRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(MatchStage.TOURNAMENT_PROPERTY);
       enhanceRelation(MatchStage.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public MatchStageRequest<T> unselectTournament(){
       unselectProperty(MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> selectVersion(){
       selectProperty(MatchStage.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStageRequest<T> unselectVersion(){
       unselectProperty(MatchStage.VERSION_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> selectTournamentMatchList(){
       return selectTournamentMatchListWith(Q.tournamentMatches().selectSelf());
    }

    public MatchStageRequest<T> selectTournamentMatchListWith(TournamentMatchRequest tournamentMatchList){
       enhanceRelation(MatchStage.TOURNAMENT_MATCH_LIST_PROPERTY, tournamentMatchList);
       return this;
    }

    public MatchStageRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStage.ID_PROPERTY, operator, values);
    }

    public MatchStageRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MatchStageRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MatchStageRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public MatchStageRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public MatchStageRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public MatchStageRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStage.NAME_PROPERTY, operator, values);
    }

    public MatchStageRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public MatchStageRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public MatchStageRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public MatchStageRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public MatchStageRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public MatchStageRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public MatchStageRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public MatchStageRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public MatchStageRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public MatchStageRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public MatchStageRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public MatchStageRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public MatchStageRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public MatchStageRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStage.CODE_PROPERTY, operator, values);
    }

    public MatchStageRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public MatchStageRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public MatchStageRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public MatchStageRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public MatchStageRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public MatchStageRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public MatchStageRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public MatchStageRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public MatchStageRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public MatchStageRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public MatchStageRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public MatchStageRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public MatchStageRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public MatchStageRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStage.TOURNAMENT_PROPERTY, operator, values);
    }

    public MatchStageRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public MatchStageRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchStage.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public MatchStageRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MatchStageRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MatchStageRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MatchStageRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStage.VERSION_PROPERTY, operator, values);
    }

    public MatchStageRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MatchStageRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MatchStageRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MatchStageRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MatchStageRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public MatchStageRequest<T> withTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(MatchStage.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_STAGE_PROPERTY));
    }

    public MatchStageRequest<T> withoutTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(MatchStage.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_STAGE_PROPERTY)));
    }

    public MatchStageRequest<T> haveTournamentMatches(){
        return withTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> haveNoTournamentMatches(){
        return withoutTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> count(){
        super.count();
        return this;
    }
    public MatchStageRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MatchStageRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public MatchStageRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(MatchStage.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }


    public MatchStageRequest<T> groupByTournamentMatchesWithDetails(TournamentMatchRequest subRequest){
       aggregate(MatchStage.TOURNAMENT_MATCH_LIST_PROPERTY, subRequest);
       return this;
    }

    public MatchStageRequest<T> groupById(){
       groupBy(MatchStage.ID_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByIdAs(String retName){
       groupBy(retName, MatchStage.ID_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStage.ID_PROPERTY, function);
       return this;
    }

    public MatchStageRequest<T> groupByName(){
       groupBy(MatchStage.NAME_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByNameAs(String retName){
       groupBy(retName, MatchStage.NAME_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStage.NAME_PROPERTY, function);
       return this;
    }

    public MatchStageRequest<T> groupByCode(){
       groupBy(MatchStage.CODE_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByCodeAs(String retName){
       groupBy(retName, MatchStage.CODE_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStage.CODE_PROPERTY, function);
       return this;
    }
    public MatchStageRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(MatchStage.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public MatchStageRequest<T> groupByTournament(){
       groupBy(MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStage.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public MatchStageRequest<T> groupByVersion(){
       groupBy(MatchStage.VERSION_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MatchStage.VERSION_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStage.VERSION_PROPERTY, function);
       return this;
    }



    public MatchStageRequest<T> orderByIdAscending(){
       addOrderByAscending(MatchStage.ID_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByIdDescending(){
       addOrderByDescending(MatchStage.ID_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByNameAscending(){
       addOrderByAscending(MatchStage.NAME_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByNameDescending(){
       addOrderByDescending(MatchStage.NAME_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchStage.NAME_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchStage.NAME_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> orderByCodeAscending(){
       addOrderByAscending(MatchStage.CODE_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByCodeDescending(){
       addOrderByDescending(MatchStage.CODE_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchStage.CODE_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchStage.CODE_PROPERTY);
       return this;
    }
    public MatchStageRequest<T> orderByTournamentAscending(){
       addOrderByAscending(MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByTournamentDescending(){
       addOrderByDescending(MatchStage.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByVersionAscending(){
       addOrderByAscending(MatchStage.VERSION_PROPERTY);
       return this;
    }

    public MatchStageRequest<T> orderByVersionDescending(){
       addOrderByDescending(MatchStage.VERSION_PROPERTY);
       return this;
    }


    public MatchStageRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(name, subRequest, false);
    }

    public MatchStageRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.MATCH_STAGE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MatchStageRequest<T> statsFromTournamentMatches(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }


    public MatchStageRequest<T> countTournamentMatches(){
        return countTournamentMatchesAs("Count");
    }

    public MatchStageRequest<T> countTournamentMatchesAs(String name){
        return countTournamentMatchesWith(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> countTournamentMatchesWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.count(), true);
    }
    public MatchStageRequest<T> minMatchNumberOfTournamentMatches(){
        return minMatchNumberOfTournamentMatchesAs("minMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> minMatchNumberOfTournamentMatchesAs(String name){
        return minMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minMatchNumber(), true);
    }
    public MatchStageRequest<T> maxMatchNumberOfTournamentMatches(){
        return maxMatchNumberOfTournamentMatchesAs("maxMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> maxMatchNumberOfTournamentMatchesAs(String name){
        return maxMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxMatchNumber(), true);
    }
    public MatchStageRequest<T> sumMatchNumberOfTournamentMatches(){
        return sumMatchNumberOfTournamentMatchesAs("sumMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> sumMatchNumberOfTournamentMatchesAs(String name){
        return sumMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumMatchNumber(), true);
    }
    public MatchStageRequest<T> avgMatchNumberOfTournamentMatches(){
        return avgMatchNumberOfTournamentMatchesAs("avgMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> avgMatchNumberOfTournamentMatchesAs(String name){
        return avgMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgMatchNumber(), true);
    }
    public MatchStageRequest<T> standardDeviationMatchNumberOfTournamentMatches(){
        return standardDeviationMatchNumberOfTournamentMatchesAs("stdDevMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs("stdDevPopMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public MatchStageRequest<T> sampleVarianceMatchNumberOfTournamentMatches(){
        return sampleVarianceMatchNumberOfTournamentMatchesAs("varSampMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public MatchStageRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatches(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs("varPopMatchNumberOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public MatchStageRequest<T> minHomeScoreOfTournamentMatches(){
        return minHomeScoreOfTournamentMatchesAs("minHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> minHomeScoreOfTournamentMatchesAs(String name){
        return minHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minHomeScore(), true);
    }
    public MatchStageRequest<T> maxHomeScoreOfTournamentMatches(){
        return maxHomeScoreOfTournamentMatchesAs("maxHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> maxHomeScoreOfTournamentMatchesAs(String name){
        return maxHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxHomeScore(), true);
    }
    public MatchStageRequest<T> sumHomeScoreOfTournamentMatches(){
        return sumHomeScoreOfTournamentMatchesAs("sumHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> sumHomeScoreOfTournamentMatchesAs(String name){
        return sumHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumHomeScore(), true);
    }
    public MatchStageRequest<T> avgHomeScoreOfTournamentMatches(){
        return avgHomeScoreOfTournamentMatchesAs("avgHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> avgHomeScoreOfTournamentMatchesAs(String name){
        return avgHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgHomeScore(), true);
    }
    public MatchStageRequest<T> standardDeviationHomeScoreOfTournamentMatches(){
        return standardDeviationHomeScoreOfTournamentMatchesAs("stdDevHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs("stdDevPopHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public MatchStageRequest<T> sampleVarianceHomeScoreOfTournamentMatches(){
        return sampleVarianceHomeScoreOfTournamentMatchesAs("varSampHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public MatchStageRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatches(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs("varPopHomeScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public MatchStageRequest<T> minAwayScoreOfTournamentMatches(){
        return minAwayScoreOfTournamentMatchesAs("minAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> minAwayScoreOfTournamentMatchesAs(String name){
        return minAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minAwayScore(), true);
    }
    public MatchStageRequest<T> maxAwayScoreOfTournamentMatches(){
        return maxAwayScoreOfTournamentMatchesAs("maxAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> maxAwayScoreOfTournamentMatchesAs(String name){
        return maxAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxAwayScore(), true);
    }
    public MatchStageRequest<T> sumAwayScoreOfTournamentMatches(){
        return sumAwayScoreOfTournamentMatchesAs("sumAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> sumAwayScoreOfTournamentMatchesAs(String name){
        return sumAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumAwayScore(), true);
    }
    public MatchStageRequest<T> avgAwayScoreOfTournamentMatches(){
        return avgAwayScoreOfTournamentMatchesAs("avgAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> avgAwayScoreOfTournamentMatchesAs(String name){
        return avgAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgAwayScore(), true);
    }
    public MatchStageRequest<T> standardDeviationAwayScoreOfTournamentMatches(){
        return standardDeviationAwayScoreOfTournamentMatchesAs("stdDevAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs("stdDevPopAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public MatchStageRequest<T> sampleVarianceAwayScoreOfTournamentMatches(){
        return sampleVarianceAwayScoreOfTournamentMatchesAs("varSampAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public MatchStageRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatches(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs("varPopAwayScoreOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public MatchStageRequest<T> minExtraTimeHomeOfTournamentMatches(){
        return minExtraTimeHomeOfTournamentMatchesAs("minExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeHome(), true);
    }
    public MatchStageRequest<T> maxExtraTimeHomeOfTournamentMatches(){
        return maxExtraTimeHomeOfTournamentMatchesAs("maxExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public MatchStageRequest<T> sumExtraTimeHomeOfTournamentMatches(){
        return sumExtraTimeHomeOfTournamentMatchesAs("sumExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public MatchStageRequest<T> avgExtraTimeHomeOfTournamentMatches(){
        return avgExtraTimeHomeOfTournamentMatchesAs("avgExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public MatchStageRequest<T> standardDeviationExtraTimeHomeOfTournamentMatches(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public MatchStageRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatches(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs("varSampExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public MatchStageRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs("varPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public MatchStageRequest<T> minExtraTimeAwayOfTournamentMatches(){
        return minExtraTimeAwayOfTournamentMatchesAs("minExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeAway(), true);
    }
    public MatchStageRequest<T> maxExtraTimeAwayOfTournamentMatches(){
        return maxExtraTimeAwayOfTournamentMatchesAs("maxExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public MatchStageRequest<T> sumExtraTimeAwayOfTournamentMatches(){
        return sumExtraTimeAwayOfTournamentMatchesAs("sumExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public MatchStageRequest<T> avgExtraTimeAwayOfTournamentMatches(){
        return avgExtraTimeAwayOfTournamentMatchesAs("avgExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public MatchStageRequest<T> standardDeviationExtraTimeAwayOfTournamentMatches(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public MatchStageRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatches(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs("varSampExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public MatchStageRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs("varPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public MatchStageRequest<T> minPenaltyHomeOfTournamentMatches(){
        return minPenaltyHomeOfTournamentMatchesAs("minPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name){
        return minPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyHome(), true);
    }
    public MatchStageRequest<T> maxPenaltyHomeOfTournamentMatches(){
        return maxPenaltyHomeOfTournamentMatchesAs("maxPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyHome(), true);
    }
    public MatchStageRequest<T> sumPenaltyHomeOfTournamentMatches(){
        return sumPenaltyHomeOfTournamentMatchesAs("sumPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyHome(), true);
    }
    public MatchStageRequest<T> avgPenaltyHomeOfTournamentMatches(){
        return avgPenaltyHomeOfTournamentMatchesAs("avgPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyHome(), true);
    }
    public MatchStageRequest<T> standardDeviationPenaltyHomeOfTournamentMatches(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPopPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public MatchStageRequest<T> sampleVariancePenaltyHomeOfTournamentMatches(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs("varSampPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public MatchStageRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatches(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs("varPopPenaltyHomeOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public MatchStageRequest<T> minPenaltyAwayOfTournamentMatches(){
        return minPenaltyAwayOfTournamentMatchesAs("minPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name){
        return minPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyAway(), true);
    }
    public MatchStageRequest<T> maxPenaltyAwayOfTournamentMatches(){
        return maxPenaltyAwayOfTournamentMatchesAs("maxPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyAway(), true);
    }
    public MatchStageRequest<T> sumPenaltyAwayOfTournamentMatches(){
        return sumPenaltyAwayOfTournamentMatchesAs("sumPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyAway(), true);
    }
    public MatchStageRequest<T> avgPenaltyAwayOfTournamentMatches(){
        return avgPenaltyAwayOfTournamentMatchesAs("avgPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyAway(), true);
    }
    public MatchStageRequest<T> standardDeviationPenaltyAwayOfTournamentMatches(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPopPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public MatchStageRequest<T> sampleVariancePenaltyAwayOfTournamentMatches(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs("varSampPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public MatchStageRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatches(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs("varPopPenaltyAwayOfTournamentMatches");
    }

    public MatchStageRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStageRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }

   public MatchStageRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public MatchStageRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, MatchStage.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MatchStageRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MatchStageRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MatchStageRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MatchStageRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MatchStageRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}