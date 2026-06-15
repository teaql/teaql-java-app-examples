package com.example.fifaworldcupservice.matchstatus;

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

public class MatchStatusRequest<T extends MatchStatus> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MatchStatusRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MatchStatusRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MatchStatusRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MatchStatusRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MatchStatusRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MatchStatusRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MatchStatusRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MatchStatusRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MatchStatusRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MatchStatusRequest<T> matchingAnyOf(MatchStatusRequest matchStatus){
        super.internalMatchAny(matchStatus);
        return this;
    }

    public MatchStatusRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MatchStatusRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MatchStatusRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MatchStatusRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectTournamentIdOnly().selectVersion();
    }

    public MatchStatusRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MatchStatusRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }

    public MatchStatusRequest<T> selectChildren(){
        super.selectAny();
        selectTournamentMatchList();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }


    public MatchStatusRequest<T> selectId(){
       selectProperty(MatchStatus.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStatusRequest<T> unselectId(){
       unselectProperty(MatchStatus.ID_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> selectName(){
       selectProperty(MatchStatus.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStatusRequest<T> unselectName(){
       unselectProperty(MatchStatus.NAME_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> selectCode(){
       selectProperty(MatchStatus.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStatusRequest<T> unselectCode(){
       unselectProperty(MatchStatus.CODE_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> selectTournamentIdOnly(){
       selectProperty(MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public MatchStatusRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(MatchStatus.TOURNAMENT_PROPERTY);
       enhanceRelation(MatchStatus.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public MatchStatusRequest<T> unselectTournament(){
       unselectProperty(MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> selectVersion(){
       selectProperty(MatchStatus.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchStatusRequest<T> unselectVersion(){
       unselectProperty(MatchStatus.VERSION_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> selectTournamentMatchList(){
       return selectTournamentMatchListWith(Q.tournamentMatches().selectSelf());
    }

    public MatchStatusRequest<T> selectTournamentMatchListWith(TournamentMatchRequest tournamentMatchList){
       enhanceRelation(MatchStatus.TOURNAMENT_MATCH_LIST_PROPERTY, tournamentMatchList);
       return this;
    }

    public MatchStatusRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStatus.ID_PROPERTY, operator, values);
    }

    public MatchStatusRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MatchStatusRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MatchStatusRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public MatchStatusRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public MatchStatusRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public MatchStatusRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStatus.NAME_PROPERTY, operator, values);
    }

    public MatchStatusRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public MatchStatusRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public MatchStatusRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public MatchStatusRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public MatchStatusRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public MatchStatusRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public MatchStatusRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public MatchStatusRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public MatchStatusRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public MatchStatusRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public MatchStatusRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public MatchStatusRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public MatchStatusRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public MatchStatusRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStatus.CODE_PROPERTY, operator, values);
    }

    public MatchStatusRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public MatchStatusRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public MatchStatusRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public MatchStatusRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public MatchStatusRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public MatchStatusRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public MatchStatusRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public MatchStatusRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public MatchStatusRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public MatchStatusRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public MatchStatusRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public MatchStatusRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public MatchStatusRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public MatchStatusRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStatus.TOURNAMENT_PROPERTY, operator, values);
    }

    public MatchStatusRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public MatchStatusRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchStatus.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public MatchStatusRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MatchStatusRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MatchStatusRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MatchStatusRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchStatus.VERSION_PROPERTY, operator, values);
    }

    public MatchStatusRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MatchStatusRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MatchStatusRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MatchStatusRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MatchStatusRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public MatchStatusRequest<T> withTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(MatchStatus.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_STATUS_PROPERTY));
    }

    public MatchStatusRequest<T> withoutTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(MatchStatus.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_STATUS_PROPERTY)));
    }

    public MatchStatusRequest<T> haveTournamentMatches(){
        return withTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> haveNoTournamentMatches(){
        return withoutTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> count(){
        super.count();
        return this;
    }
    public MatchStatusRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MatchStatusRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public MatchStatusRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(MatchStatus.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }


    public MatchStatusRequest<T> groupByTournamentMatchesWithDetails(TournamentMatchRequest subRequest){
       aggregate(MatchStatus.TOURNAMENT_MATCH_LIST_PROPERTY, subRequest);
       return this;
    }

    public MatchStatusRequest<T> groupById(){
       groupBy(MatchStatus.ID_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByIdAs(String retName){
       groupBy(retName, MatchStatus.ID_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStatus.ID_PROPERTY, function);
       return this;
    }

    public MatchStatusRequest<T> groupByName(){
       groupBy(MatchStatus.NAME_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByNameAs(String retName){
       groupBy(retName, MatchStatus.NAME_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStatus.NAME_PROPERTY, function);
       return this;
    }

    public MatchStatusRequest<T> groupByCode(){
       groupBy(MatchStatus.CODE_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByCodeAs(String retName){
       groupBy(retName, MatchStatus.CODE_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStatus.CODE_PROPERTY, function);
       return this;
    }
    public MatchStatusRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(MatchStatus.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public MatchStatusRequest<T> groupByTournament(){
       groupBy(MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStatus.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public MatchStatusRequest<T> groupByVersion(){
       groupBy(MatchStatus.VERSION_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MatchStatus.VERSION_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchStatus.VERSION_PROPERTY, function);
       return this;
    }



    public MatchStatusRequest<T> orderByIdAscending(){
       addOrderByAscending(MatchStatus.ID_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByIdDescending(){
       addOrderByDescending(MatchStatus.ID_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByNameAscending(){
       addOrderByAscending(MatchStatus.NAME_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByNameDescending(){
       addOrderByDescending(MatchStatus.NAME_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchStatus.NAME_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchStatus.NAME_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> orderByCodeAscending(){
       addOrderByAscending(MatchStatus.CODE_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByCodeDescending(){
       addOrderByDescending(MatchStatus.CODE_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchStatus.CODE_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchStatus.CODE_PROPERTY);
       return this;
    }
    public MatchStatusRequest<T> orderByTournamentAscending(){
       addOrderByAscending(MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByTournamentDescending(){
       addOrderByDescending(MatchStatus.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByVersionAscending(){
       addOrderByAscending(MatchStatus.VERSION_PROPERTY);
       return this;
    }

    public MatchStatusRequest<T> orderByVersionDescending(){
       addOrderByDescending(MatchStatus.VERSION_PROPERTY);
       return this;
    }


    public MatchStatusRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(name, subRequest, false);
    }

    public MatchStatusRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.MATCH_STATUS_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MatchStatusRequest<T> statsFromTournamentMatches(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }


    public MatchStatusRequest<T> countTournamentMatches(){
        return countTournamentMatchesAs("Count");
    }

    public MatchStatusRequest<T> countTournamentMatchesAs(String name){
        return countTournamentMatchesWith(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> countTournamentMatchesWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.count(), true);
    }
    public MatchStatusRequest<T> minMatchNumberOfTournamentMatches(){
        return minMatchNumberOfTournamentMatchesAs("minMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> minMatchNumberOfTournamentMatchesAs(String name){
        return minMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minMatchNumber(), true);
    }
    public MatchStatusRequest<T> maxMatchNumberOfTournamentMatches(){
        return maxMatchNumberOfTournamentMatchesAs("maxMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxMatchNumberOfTournamentMatchesAs(String name){
        return maxMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxMatchNumber(), true);
    }
    public MatchStatusRequest<T> sumMatchNumberOfTournamentMatches(){
        return sumMatchNumberOfTournamentMatchesAs("sumMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumMatchNumberOfTournamentMatchesAs(String name){
        return sumMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumMatchNumber(), true);
    }
    public MatchStatusRequest<T> avgMatchNumberOfTournamentMatches(){
        return avgMatchNumberOfTournamentMatchesAs("avgMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgMatchNumberOfTournamentMatchesAs(String name){
        return avgMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgMatchNumber(), true);
    }
    public MatchStatusRequest<T> standardDeviationMatchNumberOfTournamentMatches(){
        return standardDeviationMatchNumberOfTournamentMatchesAs("stdDevMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs("stdDevPopMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public MatchStatusRequest<T> sampleVarianceMatchNumberOfTournamentMatches(){
        return sampleVarianceMatchNumberOfTournamentMatchesAs("varSampMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public MatchStatusRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatches(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs("varPopMatchNumberOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public MatchStatusRequest<T> minHomeScoreOfTournamentMatches(){
        return minHomeScoreOfTournamentMatchesAs("minHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> minHomeScoreOfTournamentMatchesAs(String name){
        return minHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minHomeScore(), true);
    }
    public MatchStatusRequest<T> maxHomeScoreOfTournamentMatches(){
        return maxHomeScoreOfTournamentMatchesAs("maxHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxHomeScoreOfTournamentMatchesAs(String name){
        return maxHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxHomeScore(), true);
    }
    public MatchStatusRequest<T> sumHomeScoreOfTournamentMatches(){
        return sumHomeScoreOfTournamentMatchesAs("sumHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumHomeScoreOfTournamentMatchesAs(String name){
        return sumHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumHomeScore(), true);
    }
    public MatchStatusRequest<T> avgHomeScoreOfTournamentMatches(){
        return avgHomeScoreOfTournamentMatchesAs("avgHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgHomeScoreOfTournamentMatchesAs(String name){
        return avgHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgHomeScore(), true);
    }
    public MatchStatusRequest<T> standardDeviationHomeScoreOfTournamentMatches(){
        return standardDeviationHomeScoreOfTournamentMatchesAs("stdDevHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs("stdDevPopHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public MatchStatusRequest<T> sampleVarianceHomeScoreOfTournamentMatches(){
        return sampleVarianceHomeScoreOfTournamentMatchesAs("varSampHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public MatchStatusRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatches(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs("varPopHomeScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public MatchStatusRequest<T> minAwayScoreOfTournamentMatches(){
        return minAwayScoreOfTournamentMatchesAs("minAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> minAwayScoreOfTournamentMatchesAs(String name){
        return minAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minAwayScore(), true);
    }
    public MatchStatusRequest<T> maxAwayScoreOfTournamentMatches(){
        return maxAwayScoreOfTournamentMatchesAs("maxAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxAwayScoreOfTournamentMatchesAs(String name){
        return maxAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxAwayScore(), true);
    }
    public MatchStatusRequest<T> sumAwayScoreOfTournamentMatches(){
        return sumAwayScoreOfTournamentMatchesAs("sumAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumAwayScoreOfTournamentMatchesAs(String name){
        return sumAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumAwayScore(), true);
    }
    public MatchStatusRequest<T> avgAwayScoreOfTournamentMatches(){
        return avgAwayScoreOfTournamentMatchesAs("avgAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgAwayScoreOfTournamentMatchesAs(String name){
        return avgAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgAwayScore(), true);
    }
    public MatchStatusRequest<T> standardDeviationAwayScoreOfTournamentMatches(){
        return standardDeviationAwayScoreOfTournamentMatchesAs("stdDevAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs("stdDevPopAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public MatchStatusRequest<T> sampleVarianceAwayScoreOfTournamentMatches(){
        return sampleVarianceAwayScoreOfTournamentMatchesAs("varSampAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public MatchStatusRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatches(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs("varPopAwayScoreOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public MatchStatusRequest<T> minExtraTimeHomeOfTournamentMatches(){
        return minExtraTimeHomeOfTournamentMatchesAs("minExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> maxExtraTimeHomeOfTournamentMatches(){
        return maxExtraTimeHomeOfTournamentMatchesAs("maxExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> sumExtraTimeHomeOfTournamentMatches(){
        return sumExtraTimeHomeOfTournamentMatchesAs("sumExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> avgExtraTimeHomeOfTournamentMatches(){
        return avgExtraTimeHomeOfTournamentMatchesAs("avgExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> standardDeviationExtraTimeHomeOfTournamentMatches(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatches(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs("varSampExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs("varPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public MatchStatusRequest<T> minExtraTimeAwayOfTournamentMatches(){
        return minExtraTimeAwayOfTournamentMatchesAs("minExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> maxExtraTimeAwayOfTournamentMatches(){
        return maxExtraTimeAwayOfTournamentMatchesAs("maxExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> sumExtraTimeAwayOfTournamentMatches(){
        return sumExtraTimeAwayOfTournamentMatchesAs("sumExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> avgExtraTimeAwayOfTournamentMatches(){
        return avgExtraTimeAwayOfTournamentMatchesAs("avgExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> standardDeviationExtraTimeAwayOfTournamentMatches(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatches(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs("varSampExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs("varPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public MatchStatusRequest<T> minPenaltyHomeOfTournamentMatches(){
        return minPenaltyHomeOfTournamentMatchesAs("minPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name){
        return minPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyHome(), true);
    }
    public MatchStatusRequest<T> maxPenaltyHomeOfTournamentMatches(){
        return maxPenaltyHomeOfTournamentMatchesAs("maxPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyHome(), true);
    }
    public MatchStatusRequest<T> sumPenaltyHomeOfTournamentMatches(){
        return sumPenaltyHomeOfTournamentMatchesAs("sumPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyHome(), true);
    }
    public MatchStatusRequest<T> avgPenaltyHomeOfTournamentMatches(){
        return avgPenaltyHomeOfTournamentMatchesAs("avgPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyHome(), true);
    }
    public MatchStatusRequest<T> standardDeviationPenaltyHomeOfTournamentMatches(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPopPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public MatchStatusRequest<T> sampleVariancePenaltyHomeOfTournamentMatches(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs("varSampPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public MatchStatusRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatches(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs("varPopPenaltyHomeOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public MatchStatusRequest<T> minPenaltyAwayOfTournamentMatches(){
        return minPenaltyAwayOfTournamentMatchesAs("minPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name){
        return minPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyAway(), true);
    }
    public MatchStatusRequest<T> maxPenaltyAwayOfTournamentMatches(){
        return maxPenaltyAwayOfTournamentMatchesAs("maxPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyAway(), true);
    }
    public MatchStatusRequest<T> sumPenaltyAwayOfTournamentMatches(){
        return sumPenaltyAwayOfTournamentMatchesAs("sumPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyAway(), true);
    }
    public MatchStatusRequest<T> avgPenaltyAwayOfTournamentMatches(){
        return avgPenaltyAwayOfTournamentMatchesAs("avgPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyAway(), true);
    }
    public MatchStatusRequest<T> standardDeviationPenaltyAwayOfTournamentMatches(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPopPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public MatchStatusRequest<T> sampleVariancePenaltyAwayOfTournamentMatches(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs("varSampPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public MatchStatusRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatches(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs("varPopPenaltyAwayOfTournamentMatches");
    }

    public MatchStatusRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchStatusRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }

   public MatchStatusRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public MatchStatusRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, MatchStatus.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MatchStatusRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MatchStatusRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MatchStatusRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MatchStatusRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MatchStatusRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}