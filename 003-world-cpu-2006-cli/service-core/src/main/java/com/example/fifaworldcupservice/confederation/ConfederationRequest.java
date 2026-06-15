package com.example.fifaworldcupservice.confederation;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentRequest;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;

public class ConfederationRequest<T extends Confederation> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ConfederationRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ConfederationRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ConfederationRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ConfederationRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ConfederationRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ConfederationRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ConfederationRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ConfederationRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ConfederationRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ConfederationRequest<T> matchingAnyOf(ConfederationRequest confederation){
        super.internalMatchAny(confederation);
        return this;
    }

    public ConfederationRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ConfederationRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ConfederationRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ConfederationRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCode().selectTournamentIdOnly().selectVersion();
    }

    public ConfederationRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ConfederationRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }

    public ConfederationRequest<T> selectChildren(){
        super.selectAny();
        selectTournamentTeamList();
        return selectId().selectName().selectCode().selectTournament().selectVersion();
    }


    public ConfederationRequest<T> selectId(){
       selectProperty(Confederation.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ConfederationRequest<T> unselectId(){
       unselectProperty(Confederation.ID_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> selectName(){
       selectProperty(Confederation.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ConfederationRequest<T> unselectName(){
       unselectProperty(Confederation.NAME_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> selectCode(){
       selectProperty(Confederation.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ConfederationRequest<T> unselectCode(){
       unselectProperty(Confederation.CODE_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> selectTournamentIdOnly(){
       selectProperty(Confederation.TOURNAMENT_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public ConfederationRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(Confederation.TOURNAMENT_PROPERTY);
       enhanceRelation(Confederation.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public ConfederationRequest<T> unselectTournament(){
       unselectProperty(Confederation.TOURNAMENT_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> selectVersion(){
       selectProperty(Confederation.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ConfederationRequest<T> unselectVersion(){
       unselectProperty(Confederation.VERSION_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> selectTournamentTeamList(){
       return selectTournamentTeamListWith(Q.tournamentTeams().selectSelf());
    }

    public ConfederationRequest<T> selectTournamentTeamListWith(TournamentTeamRequest tournamentTeamList){
       enhanceRelation(Confederation.TOURNAMENT_TEAM_LIST_PROPERTY, tournamentTeamList);
       return this;
    }

    public ConfederationRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Confederation.ID_PROPERTY, operator, values);
    }

    public ConfederationRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ConfederationRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ConfederationRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public ConfederationRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public ConfederationRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public ConfederationRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Confederation.NAME_PROPERTY, operator, values);
    }

    public ConfederationRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public ConfederationRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public ConfederationRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public ConfederationRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public ConfederationRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public ConfederationRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public ConfederationRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public ConfederationRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public ConfederationRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public ConfederationRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public ConfederationRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public ConfederationRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public ConfederationRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public ConfederationRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Confederation.CODE_PROPERTY, operator, values);
    }

    public ConfederationRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public ConfederationRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public ConfederationRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public ConfederationRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public ConfederationRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public ConfederationRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public ConfederationRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public ConfederationRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public ConfederationRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public ConfederationRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public ConfederationRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public ConfederationRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public ConfederationRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public ConfederationRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Confederation.TOURNAMENT_PROPERTY, operator, values);
    }

    public ConfederationRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public ConfederationRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(Confederation.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public ConfederationRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ConfederationRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ConfederationRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ConfederationRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Confederation.VERSION_PROPERTY, operator, values);
    }

    public ConfederationRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ConfederationRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ConfederationRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ConfederationRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ConfederationRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public ConfederationRequest<T> withTournamentTeamListMatching(TournamentTeamRequest tournamentTeamRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Confederation.ID_PROPERTY, tournamentTeamRequest, TournamentTeam.CONFEDERATION_PROPERTY));
    }

    public ConfederationRequest<T> withoutTournamentTeamListMatching(TournamentTeamRequest tournamentTeamRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Confederation.ID_PROPERTY, tournamentTeamRequest, TournamentTeam.CONFEDERATION_PROPERTY)));
    }

    public ConfederationRequest<T> haveTournamentTeams(){
        return withTournamentTeamListMatching(Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> haveNoTournamentTeams(){
        return withoutTournamentTeamListMatching(Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> count(){
        super.count();
        return this;
    }
    public ConfederationRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ConfederationRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public ConfederationRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(Confederation.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }


    public ConfederationRequest<T> groupByTournamentTeamsWithDetails(TournamentTeamRequest subRequest){
       aggregate(Confederation.TOURNAMENT_TEAM_LIST_PROPERTY, subRequest);
       return this;
    }

    public ConfederationRequest<T> groupById(){
       groupBy(Confederation.ID_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByIdAs(String retName){
       groupBy(retName, Confederation.ID_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Confederation.ID_PROPERTY, function);
       return this;
    }

    public ConfederationRequest<T> groupByName(){
       groupBy(Confederation.NAME_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByNameAs(String retName){
       groupBy(retName, Confederation.NAME_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Confederation.NAME_PROPERTY, function);
       return this;
    }

    public ConfederationRequest<T> groupByCode(){
       groupBy(Confederation.CODE_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByCodeAs(String retName){
       groupBy(retName, Confederation.CODE_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Confederation.CODE_PROPERTY, function);
       return this;
    }
    public ConfederationRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(Confederation.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public ConfederationRequest<T> groupByTournament(){
       groupBy(Confederation.TOURNAMENT_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, Confederation.TOURNAMENT_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, Confederation.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public ConfederationRequest<T> groupByVersion(){
       groupBy(Confederation.VERSION_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Confederation.VERSION_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Confederation.VERSION_PROPERTY, function);
       return this;
    }



    public ConfederationRequest<T> orderByIdAscending(){
       addOrderByAscending(Confederation.ID_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByIdDescending(){
       addOrderByDescending(Confederation.ID_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByNameAscending(){
       addOrderByAscending(Confederation.NAME_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByNameDescending(){
       addOrderByDescending(Confederation.NAME_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Confederation.NAME_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Confederation.NAME_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> orderByCodeAscending(){
       addOrderByAscending(Confederation.CODE_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByCodeDescending(){
       addOrderByDescending(Confederation.CODE_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Confederation.CODE_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Confederation.CODE_PROPERTY);
       return this;
    }
    public ConfederationRequest<T> orderByTournamentAscending(){
       addOrderByAscending(Confederation.TOURNAMENT_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByTournamentDescending(){
       addOrderByDescending(Confederation.TOURNAMENT_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByVersionAscending(){
       addOrderByAscending(Confederation.VERSION_PROPERTY);
       return this;
    }

    public ConfederationRequest<T> orderByVersionDescending(){
       addOrderByDescending(Confederation.VERSION_PROPERTY);
       return this;
    }


    public ConfederationRequest<T> statsFromTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
       return statsFromTournamentTeamsAs(name, subRequest, false);
    }

    public ConfederationRequest<T> statsFromTournamentTeamsAs(String name, TournamentTeamRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentTeam.CONFEDERATION_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ConfederationRequest<T> statsFromTournamentTeams(TournamentTeamRequest subRequest){
       return statsFromTournamentTeamsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }


    public ConfederationRequest<T> countTournamentTeams(){
        return countTournamentTeamsAs("Count");
    }

    public ConfederationRequest<T> countTournamentTeamsAs(String name){
        return countTournamentTeamsWith(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> countTournamentTeamsWith(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.count(), true);
    }
    public ConfederationRequest<T> minFifaRankingOfTournamentTeams(){
        return minFifaRankingOfTournamentTeamsAs("minFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> minFifaRankingOfTournamentTeamsAs(String name){
        return minFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> minFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.minFifaRanking(), true);
    }
    public ConfederationRequest<T> maxFifaRankingOfTournamentTeams(){
        return maxFifaRankingOfTournamentTeamsAs("maxFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> maxFifaRankingOfTournamentTeamsAs(String name){
        return maxFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> maxFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.maxFifaRanking(), true);
    }
    public ConfederationRequest<T> sumFifaRankingOfTournamentTeams(){
        return sumFifaRankingOfTournamentTeamsAs("sumFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> sumFifaRankingOfTournamentTeamsAs(String name){
        return sumFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> sumFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.sumFifaRanking(), true);
    }
    public ConfederationRequest<T> avgFifaRankingOfTournamentTeams(){
        return avgFifaRankingOfTournamentTeamsAs("avgFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> avgFifaRankingOfTournamentTeamsAs(String name){
        return avgFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> avgFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.avgFifaRanking(), true);
    }
    public ConfederationRequest<T> standardDeviationFifaRankingOfTournamentTeams(){
        return standardDeviationFifaRankingOfTournamentTeamsAs("stdDevFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> standardDeviationFifaRankingOfTournamentTeamsAs(String name){
        return standardDeviationFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> standardDeviationFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.standardDeviationFifaRanking(), true);
    }
    public ConfederationRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeams(){
        return squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs("stdDevPopFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(String name){
        return squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.squareRootOfPopulationStandardDeviationFifaRanking(), true);
    }
    public ConfederationRequest<T> sampleVarianceFifaRankingOfTournamentTeams(){
        return sampleVarianceFifaRankingOfTournamentTeamsAs("varSampFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> sampleVarianceFifaRankingOfTournamentTeamsAs(String name){
        return sampleVarianceFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> sampleVarianceFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.sampleVarianceFifaRanking(), true);
    }
    public ConfederationRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeams(){
        return samplePopulationVarianceFifaRankingOfTournamentTeamsAs("varPopFifaRankingOfTournamentTeams");
    }

    public ConfederationRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeamsAs(String name){
        return samplePopulationVarianceFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public ConfederationRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.samplePopulationVarianceFifaRanking(), true);
    }

   public ConfederationRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public ConfederationRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, Confederation.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ConfederationRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ConfederationRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ConfederationRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ConfederationRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ConfederationRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}