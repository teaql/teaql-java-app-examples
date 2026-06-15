package com.example.fifaworldcupservice.matchgroup;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingRequest;
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
import java.time.LocalDateTime;
import java.util.Date;

public class MatchGroupRequest<T extends MatchGroup> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MatchGroupRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MatchGroupRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MatchGroupRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MatchGroupRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MatchGroupRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MatchGroupRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MatchGroupRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MatchGroupRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MatchGroupRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MatchGroupRequest<T> matchingAnyOf(MatchGroupRequest matchGroup){
        super.internalMatchAny(matchGroup);
        return this;
    }

    public MatchGroupRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MatchGroupRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MatchGroupRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MatchGroupRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectGroupLetter().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchGroupRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MatchGroupRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectGroupLetter().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchGroupRequest<T> selectChildren(){
        super.selectAny();
        selectTournamentMatchList().selectGroupStandingList();
        return selectId().selectGroupLetter().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public MatchGroupRequest<T> selectId(){
       selectProperty(MatchGroup.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGroupRequest<T> unselectId(){
       unselectProperty(MatchGroup.ID_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectGroupLetter(){
       selectProperty(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }

    /**
     * fill the groupLetter with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  groupLetter) to fetch groupLetter property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGroupRequest<T> unselectGroupLetter(){
       unselectProperty(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectTournamentIdOnly(){
       selectProperty(MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public MatchGroupRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(MatchGroup.TOURNAMENT_PROPERTY);
       enhanceRelation(MatchGroup.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public MatchGroupRequest<T> unselectTournament(){
       unselectProperty(MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectCreateTime(){
       selectProperty(MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGroupRequest<T> unselectCreateTime(){
       unselectProperty(MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectUpdateTime(){
       selectProperty(MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGroupRequest<T> unselectUpdateTime(){
       unselectProperty(MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectVersion(){
       selectProperty(MatchGroup.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGroupRequest<T> unselectVersion(){
       unselectProperty(MatchGroup.VERSION_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> selectTournamentMatchList(){
       return selectTournamentMatchListWith(Q.tournamentMatches().selectSelf());
    }

    public MatchGroupRequest<T> selectTournamentMatchListWith(TournamentMatchRequest tournamentMatchList){
       enhanceRelation(MatchGroup.TOURNAMENT_MATCH_LIST_PROPERTY, tournamentMatchList);
       return this;
    }
    public MatchGroupRequest<T> selectGroupStandingList(){
       return selectGroupStandingListWith(Q.groupStandings().selectSelf());
    }

    public MatchGroupRequest<T> selectGroupStandingListWith(GroupStandingRequest groupStandingList){
       enhanceRelation(MatchGroup.GROUP_STANDING_LIST_PROPERTY, groupStandingList);
       return this;
    }

    public MatchGroupRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.ID_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MatchGroupRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MatchGroupRequest<T> filterByGroupLetter(String... groupLetter){
      if (groupLetter == null || groupLetter.length == 0) {
        throw new IllegalArgumentException("filterByGroupLetter parameter groupLetter cannot be empty");
      }
      return appendSearchCriteria(createGroupLetterCriteria(Operator.EQUAL, (Object[])groupLetter));
    }

    public MatchGroupRequest<T> withGroupLetter(Operator operator, Object... values){
       return appendSearchCriteria(createGroupLetterCriteria(operator, values));
    }

    public MatchGroupRequest<T> withGroupLetterIsUnknown(){
       return withGroupLetter(Operator.IS_NULL);
    }

    public MatchGroupRequest<T> withGroupLetterIsKnown(){
       return withGroupLetter(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGroupLetterCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.GROUP_LETTER_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> withGroupLetterGreaterThan(String groupLetter){
       return withGroupLetter(Operator.GREATER_THAN, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterGreaterThanOrEqualTo(String groupLetter){
       return withGroupLetter(Operator.GREATER_THAN_OR_EQUAL, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterLessThan(String groupLetter){
       return withGroupLetter(Operator.LESS_THAN, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterLessThanOrEqualTo(String groupLetter){
       return withGroupLetter(Operator.LESS_THAN_OR_EQUAL, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterBetween(String startOfGroupLetter, String endOfGroupLetter){
       return withGroupLetter(Operator.BETWEEN, startOfGroupLetter, endOfGroupLetter);
    }
    public MatchGroupRequest<T> withGroupLetterStartingWith(String groupLetter){
       return withGroupLetter(Operator.BEGIN_WITH, groupLetter);
    }
    public MatchGroupRequest<T> withGroupLetterContaining(String groupLetter){
       return withGroupLetter(Operator.CONTAIN, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterEndingWith(String groupLetter){
       return withGroupLetter(Operator.END_WITH, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterIs(String groupLetter){
       return withGroupLetter(Operator.EQUAL, groupLetter);
    }

    public MatchGroupRequest<T> withGroupLetterSoundingLike(String groupLetter){
       return withGroupLetter(Operator.SOUNDS_LIKE, groupLetter);
    }



    public MatchGroupRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public MatchGroupRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public MatchGroupRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public MatchGroupRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.TOURNAMENT_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public MatchGroupRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchGroup.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public MatchGroupRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public MatchGroupRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public MatchGroupRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public MatchGroupRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.CREATE_TIME_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public MatchGroupRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGroupRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public MatchGroupRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public MatchGroupRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public MatchGroupRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public MatchGroupRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.UPDATE_TIME_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public MatchGroupRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGroupRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public MatchGroupRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MatchGroupRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MatchGroupRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MatchGroupRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGroup.VERSION_PROPERTY, operator, values);
    }

    public MatchGroupRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MatchGroupRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MatchGroupRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MatchGroupRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MatchGroupRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public MatchGroupRequest<T> withTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(MatchGroup.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_GROUP_PROPERTY));
    }

    public MatchGroupRequest<T> withoutTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(MatchGroup.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.MATCH_GROUP_PROPERTY)));
    }

    public MatchGroupRequest<T> haveTournamentMatches(){
        return withTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> haveNoTournamentMatches(){
        return withoutTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }
    public MatchGroupRequest<T> withGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(MatchGroup.ID_PROPERTY, groupStandingRequest, GroupStanding.MATCH_GROUP_PROPERTY));
    }

    public MatchGroupRequest<T> withoutGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(MatchGroup.ID_PROPERTY, groupStandingRequest, GroupStanding.MATCH_GROUP_PROPERTY)));
    }

    public MatchGroupRequest<T> haveGroupStandings(){
        return withGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> haveNoGroupStandings(){
        return withoutGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> count(){
        super.count();
        return this;
    }
    public MatchGroupRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MatchGroupRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public MatchGroupRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(MatchGroup.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }




    public MatchGroupRequest<T> groupByTournamentMatchesWithDetails(TournamentMatchRequest subRequest){
       aggregate(MatchGroup.TOURNAMENT_MATCH_LIST_PROPERTY, subRequest);
       return this;
    }
    public MatchGroupRequest<T> groupByGroupStandingsWithDetails(GroupStandingRequest subRequest){
       aggregate(MatchGroup.GROUP_STANDING_LIST_PROPERTY, subRequest);
       return this;
    }

    public MatchGroupRequest<T> groupById(){
       groupBy(MatchGroup.ID_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByIdAs(String retName){
       groupBy(retName, MatchGroup.ID_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.ID_PROPERTY, function);
       return this;
    }

    public MatchGroupRequest<T> groupByGroupLetter(){
       groupBy(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByGroupLetterAs(String retName){
       groupBy(retName, MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByGroupLetterWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.GROUP_LETTER_PROPERTY, function);
       return this;
    }
    public MatchGroupRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(MatchGroup.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public MatchGroupRequest<T> groupByTournament(){
       groupBy(MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public MatchGroupRequest<T> groupByCreateTime(){
       groupBy(MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchGroupRequest<T> groupByUpdateTime(){
       groupBy(MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchGroupRequest<T> groupByVersion(){
       groupBy(MatchGroup.VERSION_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MatchGroup.VERSION_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGroup.VERSION_PROPERTY, function);
       return this;
    }



    public MatchGroupRequest<T> orderByIdAscending(){
       addOrderByAscending(MatchGroup.ID_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByIdDescending(){
       addOrderByDescending(MatchGroup.ID_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByGroupLetterAscending(){
       addOrderByAscending(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByGroupLetterDescending(){
       addOrderByDescending(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> orderByGroupLetterAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByGroupLetterDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchGroup.GROUP_LETTER_PROPERTY);
       return this;
    }
    public MatchGroupRequest<T> orderByTournamentAscending(){
       addOrderByAscending(MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByTournamentDescending(){
       addOrderByDescending(MatchGroup.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(MatchGroup.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(MatchGroup.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByVersionAscending(){
       addOrderByAscending(MatchGroup.VERSION_PROPERTY);
       return this;
    }

    public MatchGroupRequest<T> orderByVersionDescending(){
       addOrderByDescending(MatchGroup.VERSION_PROPERTY);
       return this;
    }


    public MatchGroupRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(name, subRequest, false);
    }

    public MatchGroupRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.MATCH_GROUP_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MatchGroupRequest<T> statsFromTournamentMatches(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(REFINEMENTS, subRequest);
    }
    public MatchGroupRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(name, subRequest, false);
    }

    public MatchGroupRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(GroupStanding.MATCH_GROUP_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public MatchGroupRequest<T> statsFromGroupStandings(GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }




    public MatchGroupRequest<T> countTournamentMatches(){
        return countTournamentMatchesAs("Count");
    }

    public MatchGroupRequest<T> countTournamentMatchesAs(String name){
        return countTournamentMatchesWith(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> countTournamentMatchesWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.count(), true);
    }
    public MatchGroupRequest<T> countGroupStandings(){
        return countGroupStandingsAs("Count");
    }

    public MatchGroupRequest<T> countGroupStandingsAs(String name){
        return countGroupStandingsWith(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> countGroupStandingsWith(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.count(), true);
    }
    public MatchGroupRequest<T> minMatchNumberOfTournamentMatches(){
        return minMatchNumberOfTournamentMatchesAs("minMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> minMatchNumberOfTournamentMatchesAs(String name){
        return minMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minMatchNumber(), true);
    }
    public MatchGroupRequest<T> maxMatchNumberOfTournamentMatches(){
        return maxMatchNumberOfTournamentMatchesAs("maxMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxMatchNumberOfTournamentMatchesAs(String name){
        return maxMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxMatchNumber(), true);
    }
    public MatchGroupRequest<T> sumMatchNumberOfTournamentMatches(){
        return sumMatchNumberOfTournamentMatchesAs("sumMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumMatchNumberOfTournamentMatchesAs(String name){
        return sumMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumMatchNumber(), true);
    }
    public MatchGroupRequest<T> avgMatchNumberOfTournamentMatches(){
        return avgMatchNumberOfTournamentMatchesAs("avgMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgMatchNumberOfTournamentMatchesAs(String name){
        return avgMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgMatchNumber(), true);
    }
    public MatchGroupRequest<T> standardDeviationMatchNumberOfTournamentMatches(){
        return standardDeviationMatchNumberOfTournamentMatchesAs("stdDevMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs("stdDevPopMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public MatchGroupRequest<T> sampleVarianceMatchNumberOfTournamentMatches(){
        return sampleVarianceMatchNumberOfTournamentMatchesAs("varSampMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatches(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs("varPopMatchNumberOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public MatchGroupRequest<T> minHomeScoreOfTournamentMatches(){
        return minHomeScoreOfTournamentMatchesAs("minHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> minHomeScoreOfTournamentMatchesAs(String name){
        return minHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minHomeScore(), true);
    }
    public MatchGroupRequest<T> maxHomeScoreOfTournamentMatches(){
        return maxHomeScoreOfTournamentMatchesAs("maxHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxHomeScoreOfTournamentMatchesAs(String name){
        return maxHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxHomeScore(), true);
    }
    public MatchGroupRequest<T> sumHomeScoreOfTournamentMatches(){
        return sumHomeScoreOfTournamentMatchesAs("sumHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumHomeScoreOfTournamentMatchesAs(String name){
        return sumHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumHomeScore(), true);
    }
    public MatchGroupRequest<T> avgHomeScoreOfTournamentMatches(){
        return avgHomeScoreOfTournamentMatchesAs("avgHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgHomeScoreOfTournamentMatchesAs(String name){
        return avgHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgHomeScore(), true);
    }
    public MatchGroupRequest<T> standardDeviationHomeScoreOfTournamentMatches(){
        return standardDeviationHomeScoreOfTournamentMatchesAs("stdDevHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs("stdDevPopHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public MatchGroupRequest<T> sampleVarianceHomeScoreOfTournamentMatches(){
        return sampleVarianceHomeScoreOfTournamentMatchesAs("varSampHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatches(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs("varPopHomeScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public MatchGroupRequest<T> minAwayScoreOfTournamentMatches(){
        return minAwayScoreOfTournamentMatchesAs("minAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> minAwayScoreOfTournamentMatchesAs(String name){
        return minAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minAwayScore(), true);
    }
    public MatchGroupRequest<T> maxAwayScoreOfTournamentMatches(){
        return maxAwayScoreOfTournamentMatchesAs("maxAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxAwayScoreOfTournamentMatchesAs(String name){
        return maxAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxAwayScore(), true);
    }
    public MatchGroupRequest<T> sumAwayScoreOfTournamentMatches(){
        return sumAwayScoreOfTournamentMatchesAs("sumAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumAwayScoreOfTournamentMatchesAs(String name){
        return sumAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumAwayScore(), true);
    }
    public MatchGroupRequest<T> avgAwayScoreOfTournamentMatches(){
        return avgAwayScoreOfTournamentMatchesAs("avgAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgAwayScoreOfTournamentMatchesAs(String name){
        return avgAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgAwayScore(), true);
    }
    public MatchGroupRequest<T> standardDeviationAwayScoreOfTournamentMatches(){
        return standardDeviationAwayScoreOfTournamentMatchesAs("stdDevAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs("stdDevPopAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public MatchGroupRequest<T> sampleVarianceAwayScoreOfTournamentMatches(){
        return sampleVarianceAwayScoreOfTournamentMatchesAs("varSampAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatches(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs("varPopAwayScoreOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public MatchGroupRequest<T> minExtraTimeHomeOfTournamentMatches(){
        return minExtraTimeHomeOfTournamentMatchesAs("minExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> maxExtraTimeHomeOfTournamentMatches(){
        return maxExtraTimeHomeOfTournamentMatchesAs("maxExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> sumExtraTimeHomeOfTournamentMatches(){
        return sumExtraTimeHomeOfTournamentMatchesAs("sumExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> avgExtraTimeHomeOfTournamentMatches(){
        return avgExtraTimeHomeOfTournamentMatchesAs("avgExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> standardDeviationExtraTimeHomeOfTournamentMatches(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatches(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs("varSampExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs("varPopExtraTimeHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public MatchGroupRequest<T> minExtraTimeAwayOfTournamentMatches(){
        return minExtraTimeAwayOfTournamentMatchesAs("minExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> maxExtraTimeAwayOfTournamentMatches(){
        return maxExtraTimeAwayOfTournamentMatchesAs("maxExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> sumExtraTimeAwayOfTournamentMatches(){
        return sumExtraTimeAwayOfTournamentMatchesAs("sumExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> avgExtraTimeAwayOfTournamentMatches(){
        return avgExtraTimeAwayOfTournamentMatchesAs("avgExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> standardDeviationExtraTimeAwayOfTournamentMatches(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatches(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs("varSampExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs("varPopExtraTimeAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public MatchGroupRequest<T> minPenaltyHomeOfTournamentMatches(){
        return minPenaltyHomeOfTournamentMatchesAs("minPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name){
        return minPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyHome(), true);
    }
    public MatchGroupRequest<T> maxPenaltyHomeOfTournamentMatches(){
        return maxPenaltyHomeOfTournamentMatchesAs("maxPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyHome(), true);
    }
    public MatchGroupRequest<T> sumPenaltyHomeOfTournamentMatches(){
        return sumPenaltyHomeOfTournamentMatchesAs("sumPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyHome(), true);
    }
    public MatchGroupRequest<T> avgPenaltyHomeOfTournamentMatches(){
        return avgPenaltyHomeOfTournamentMatchesAs("avgPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyHome(), true);
    }
    public MatchGroupRequest<T> standardDeviationPenaltyHomeOfTournamentMatches(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPopPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public MatchGroupRequest<T> sampleVariancePenaltyHomeOfTournamentMatches(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs("varSampPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public MatchGroupRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatches(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs("varPopPenaltyHomeOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public MatchGroupRequest<T> minPenaltyAwayOfTournamentMatches(){
        return minPenaltyAwayOfTournamentMatchesAs("minPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name){
        return minPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyAway(), true);
    }
    public MatchGroupRequest<T> maxPenaltyAwayOfTournamentMatches(){
        return maxPenaltyAwayOfTournamentMatchesAs("maxPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyAway(), true);
    }
    public MatchGroupRequest<T> sumPenaltyAwayOfTournamentMatches(){
        return sumPenaltyAwayOfTournamentMatchesAs("sumPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyAway(), true);
    }
    public MatchGroupRequest<T> avgPenaltyAwayOfTournamentMatches(){
        return avgPenaltyAwayOfTournamentMatchesAs("avgPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyAway(), true);
    }
    public MatchGroupRequest<T> standardDeviationPenaltyAwayOfTournamentMatches(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPopPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public MatchGroupRequest<T> sampleVariancePenaltyAwayOfTournamentMatches(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs("varSampPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public MatchGroupRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatches(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs("varPopPenaltyAwayOfTournamentMatches");
    }

    public MatchGroupRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }
    public MatchGroupRequest<T> minPlayedOfGroupStandings(){
        return minPlayedOfGroupStandingsAs("minPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> minPlayedOfGroupStandingsAs(String name){
        return minPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPlayed(), true);
    }
    public MatchGroupRequest<T> maxPlayedOfGroupStandings(){
        return maxPlayedOfGroupStandingsAs("maxPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> maxPlayedOfGroupStandingsAs(String name){
        return maxPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPlayed(), true);
    }
    public MatchGroupRequest<T> sumPlayedOfGroupStandings(){
        return sumPlayedOfGroupStandingsAs("sumPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> sumPlayedOfGroupStandingsAs(String name){
        return sumPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPlayed(), true);
    }
    public MatchGroupRequest<T> avgPlayedOfGroupStandings(){
        return avgPlayedOfGroupStandingsAs("avgPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> avgPlayedOfGroupStandingsAs(String name){
        return avgPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPlayed(), true);
    }
    public MatchGroupRequest<T> standardDeviationPlayedOfGroupStandings(){
        return standardDeviationPlayedOfGroupStandingsAs("stdDevPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name){
        return standardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPlayed(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs("stdDevPopPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPlayed(), true);
    }
    public MatchGroupRequest<T> sampleVariancePlayedOfGroupStandings(){
        return sampleVariancePlayedOfGroupStandingsAs("varSampPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name){
        return sampleVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePlayed(), true);
    }
    public MatchGroupRequest<T> samplePopulationVariancePlayedOfGroupStandings(){
        return samplePopulationVariancePlayedOfGroupStandingsAs("varPopPlayedOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name){
        return samplePopulationVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePlayed(), true);
    }
    public MatchGroupRequest<T> minWonOfGroupStandings(){
        return minWonOfGroupStandingsAs("minWonOfGroupStandings");
    }

    public MatchGroupRequest<T> minWonOfGroupStandingsAs(String name){
        return minWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minWon(), true);
    }
    public MatchGroupRequest<T> maxWonOfGroupStandings(){
        return maxWonOfGroupStandingsAs("maxWonOfGroupStandings");
    }

    public MatchGroupRequest<T> maxWonOfGroupStandingsAs(String name){
        return maxWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxWon(), true);
    }
    public MatchGroupRequest<T> sumWonOfGroupStandings(){
        return sumWonOfGroupStandingsAs("sumWonOfGroupStandings");
    }

    public MatchGroupRequest<T> sumWonOfGroupStandingsAs(String name){
        return sumWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumWon(), true);
    }
    public MatchGroupRequest<T> avgWonOfGroupStandings(){
        return avgWonOfGroupStandingsAs("avgWonOfGroupStandings");
    }

    public MatchGroupRequest<T> avgWonOfGroupStandingsAs(String name){
        return avgWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgWon(), true);
    }
    public MatchGroupRequest<T> standardDeviationWonOfGroupStandings(){
        return standardDeviationWonOfGroupStandingsAs("stdDevWonOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationWonOfGroupStandingsAs(String name){
        return standardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationWon(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs("stdDevPopWonOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationWon(), true);
    }
    public MatchGroupRequest<T> sampleVarianceWonOfGroupStandings(){
        return sampleVarianceWonOfGroupStandingsAs("varSampWonOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceWonOfGroupStandingsAs(String name){
        return sampleVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceWon(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceWonOfGroupStandings(){
        return samplePopulationVarianceWonOfGroupStandingsAs("varPopWonOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name){
        return samplePopulationVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceWon(), true);
    }
    public MatchGroupRequest<T> minDrawnOfGroupStandings(){
        return minDrawnOfGroupStandingsAs("minDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> minDrawnOfGroupStandingsAs(String name){
        return minDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minDrawn(), true);
    }
    public MatchGroupRequest<T> maxDrawnOfGroupStandings(){
        return maxDrawnOfGroupStandingsAs("maxDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> maxDrawnOfGroupStandingsAs(String name){
        return maxDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxDrawn(), true);
    }
    public MatchGroupRequest<T> sumDrawnOfGroupStandings(){
        return sumDrawnOfGroupStandingsAs("sumDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> sumDrawnOfGroupStandingsAs(String name){
        return sumDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumDrawn(), true);
    }
    public MatchGroupRequest<T> avgDrawnOfGroupStandings(){
        return avgDrawnOfGroupStandingsAs("avgDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> avgDrawnOfGroupStandingsAs(String name){
        return avgDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgDrawn(), true);
    }
    public MatchGroupRequest<T> standardDeviationDrawnOfGroupStandings(){
        return standardDeviationDrawnOfGroupStandingsAs("stdDevDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name){
        return standardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationDrawn(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs("stdDevPopDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationDrawn(), true);
    }
    public MatchGroupRequest<T> sampleVarianceDrawnOfGroupStandings(){
        return sampleVarianceDrawnOfGroupStandingsAs("varSampDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name){
        return sampleVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceDrawn(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceDrawnOfGroupStandings(){
        return samplePopulationVarianceDrawnOfGroupStandingsAs("varPopDrawnOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name){
        return samplePopulationVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceDrawn(), true);
    }
    public MatchGroupRequest<T> minLostOfGroupStandings(){
        return minLostOfGroupStandingsAs("minLostOfGroupStandings");
    }

    public MatchGroupRequest<T> minLostOfGroupStandingsAs(String name){
        return minLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minLost(), true);
    }
    public MatchGroupRequest<T> maxLostOfGroupStandings(){
        return maxLostOfGroupStandingsAs("maxLostOfGroupStandings");
    }

    public MatchGroupRequest<T> maxLostOfGroupStandingsAs(String name){
        return maxLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxLost(), true);
    }
    public MatchGroupRequest<T> sumLostOfGroupStandings(){
        return sumLostOfGroupStandingsAs("sumLostOfGroupStandings");
    }

    public MatchGroupRequest<T> sumLostOfGroupStandingsAs(String name){
        return sumLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumLost(), true);
    }
    public MatchGroupRequest<T> avgLostOfGroupStandings(){
        return avgLostOfGroupStandingsAs("avgLostOfGroupStandings");
    }

    public MatchGroupRequest<T> avgLostOfGroupStandingsAs(String name){
        return avgLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgLost(), true);
    }
    public MatchGroupRequest<T> standardDeviationLostOfGroupStandings(){
        return standardDeviationLostOfGroupStandingsAs("stdDevLostOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationLostOfGroupStandingsAs(String name){
        return standardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationLost(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs("stdDevPopLostOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationLost(), true);
    }
    public MatchGroupRequest<T> sampleVarianceLostOfGroupStandings(){
        return sampleVarianceLostOfGroupStandingsAs("varSampLostOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceLostOfGroupStandingsAs(String name){
        return sampleVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceLost(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceLostOfGroupStandings(){
        return samplePopulationVarianceLostOfGroupStandingsAs("varPopLostOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name){
        return samplePopulationVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceLost(), true);
    }
    public MatchGroupRequest<T> minGoalsForOfGroupStandings(){
        return minGoalsForOfGroupStandingsAs("minGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> minGoalsForOfGroupStandingsAs(String name){
        return minGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsFor(), true);
    }
    public MatchGroupRequest<T> maxGoalsForOfGroupStandings(){
        return maxGoalsForOfGroupStandingsAs("maxGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> maxGoalsForOfGroupStandingsAs(String name){
        return maxGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsFor(), true);
    }
    public MatchGroupRequest<T> sumGoalsForOfGroupStandings(){
        return sumGoalsForOfGroupStandingsAs("sumGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> sumGoalsForOfGroupStandingsAs(String name){
        return sumGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsFor(), true);
    }
    public MatchGroupRequest<T> avgGoalsForOfGroupStandings(){
        return avgGoalsForOfGroupStandingsAs("avgGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> avgGoalsForOfGroupStandingsAs(String name){
        return avgGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsFor(), true);
    }
    public MatchGroupRequest<T> standardDeviationGoalsForOfGroupStandings(){
        return standardDeviationGoalsForOfGroupStandingsAs("stdDevGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name){
        return standardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsFor(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs("stdDevPopGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsFor(), true);
    }
    public MatchGroupRequest<T> sampleVarianceGoalsForOfGroupStandings(){
        return sampleVarianceGoalsForOfGroupStandingsAs("varSampGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name){
        return sampleVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsFor(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceGoalsForOfGroupStandings(){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs("varPopGoalsForOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsFor(), true);
    }
    public MatchGroupRequest<T> minGoalsAgainstOfGroupStandings(){
        return minGoalsAgainstOfGroupStandingsAs("minGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> minGoalsAgainstOfGroupStandingsAs(String name){
        return minGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> maxGoalsAgainstOfGroupStandings(){
        return maxGoalsAgainstOfGroupStandingsAs("maxGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name){
        return maxGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> sumGoalsAgainstOfGroupStandings(){
        return sumGoalsAgainstOfGroupStandingsAs("sumGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name){
        return sumGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> avgGoalsAgainstOfGroupStandings(){
        return avgGoalsAgainstOfGroupStandingsAs("avgGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name){
        return avgGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> standardDeviationGoalsAgainstOfGroupStandings(){
        return standardDeviationGoalsAgainstOfGroupStandingsAs("stdDevGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return standardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs("stdDevPopGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> sampleVarianceGoalsAgainstOfGroupStandings(){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs("varSampGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandings(){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs("varPopGoalsAgainstOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsAgainst(), true);
    }
    public MatchGroupRequest<T> minGoalDifferenceOfGroupStandings(){
        return minGoalDifferenceOfGroupStandingsAs("minGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> minGoalDifferenceOfGroupStandingsAs(String name){
        return minGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalDifference(), true);
    }
    public MatchGroupRequest<T> maxGoalDifferenceOfGroupStandings(){
        return maxGoalDifferenceOfGroupStandingsAs("maxGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name){
        return maxGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalDifference(), true);
    }
    public MatchGroupRequest<T> sumGoalDifferenceOfGroupStandings(){
        return sumGoalDifferenceOfGroupStandingsAs("sumGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name){
        return sumGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalDifference(), true);
    }
    public MatchGroupRequest<T> avgGoalDifferenceOfGroupStandings(){
        return avgGoalDifferenceOfGroupStandingsAs("avgGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name){
        return avgGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalDifference(), true);
    }
    public MatchGroupRequest<T> standardDeviationGoalDifferenceOfGroupStandings(){
        return standardDeviationGoalDifferenceOfGroupStandingsAs("stdDevGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return standardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalDifference(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs("stdDevPopGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalDifference(), true);
    }
    public MatchGroupRequest<T> sampleVarianceGoalDifferenceOfGroupStandings(){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs("varSampGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalDifference(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandings(){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs("varPopGoalDifferenceOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalDifference(), true);
    }
    public MatchGroupRequest<T> minPointsOfGroupStandings(){
        return minPointsOfGroupStandingsAs("minPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> minPointsOfGroupStandingsAs(String name){
        return minPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPoints(), true);
    }
    public MatchGroupRequest<T> maxPointsOfGroupStandings(){
        return maxPointsOfGroupStandingsAs("maxPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> maxPointsOfGroupStandingsAs(String name){
        return maxPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPoints(), true);
    }
    public MatchGroupRequest<T> sumPointsOfGroupStandings(){
        return sumPointsOfGroupStandingsAs("sumPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> sumPointsOfGroupStandingsAs(String name){
        return sumPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPoints(), true);
    }
    public MatchGroupRequest<T> avgPointsOfGroupStandings(){
        return avgPointsOfGroupStandingsAs("avgPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> avgPointsOfGroupStandingsAs(String name){
        return avgPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPoints(), true);
    }
    public MatchGroupRequest<T> standardDeviationPointsOfGroupStandings(){
        return standardDeviationPointsOfGroupStandingsAs("stdDevPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationPointsOfGroupStandingsAs(String name){
        return standardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPoints(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs("stdDevPopPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPoints(), true);
    }
    public MatchGroupRequest<T> sampleVariancePointsOfGroupStandings(){
        return sampleVariancePointsOfGroupStandingsAs("varSampPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVariancePointsOfGroupStandingsAs(String name){
        return sampleVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePoints(), true);
    }
    public MatchGroupRequest<T> samplePopulationVariancePointsOfGroupStandings(){
        return samplePopulationVariancePointsOfGroupStandingsAs("varPopPointsOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name){
        return samplePopulationVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePoints(), true);
    }
    public MatchGroupRequest<T> minStandingRankOfGroupStandings(){
        return minStandingRankOfGroupStandingsAs("minStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> minStandingRankOfGroupStandingsAs(String name){
        return minStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> minStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minStandingRank(), true);
    }
    public MatchGroupRequest<T> maxStandingRankOfGroupStandings(){
        return maxStandingRankOfGroupStandingsAs("maxStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> maxStandingRankOfGroupStandingsAs(String name){
        return maxStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> maxStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxStandingRank(), true);
    }
    public MatchGroupRequest<T> sumStandingRankOfGroupStandings(){
        return sumStandingRankOfGroupStandingsAs("sumStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> sumStandingRankOfGroupStandingsAs(String name){
        return sumStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sumStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumStandingRank(), true);
    }
    public MatchGroupRequest<T> avgStandingRankOfGroupStandings(){
        return avgStandingRankOfGroupStandingsAs("avgStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> avgStandingRankOfGroupStandingsAs(String name){
        return avgStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> avgStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgStandingRank(), true);
    }
    public MatchGroupRequest<T> standardDeviationStandingRankOfGroupStandings(){
        return standardDeviationStandingRankOfGroupStandingsAs("stdDevStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name){
        return standardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationStandingRank(), true);
    }
    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs("stdDevPopStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationStandingRank(), true);
    }
    public MatchGroupRequest<T> sampleVarianceStandingRankOfGroupStandings(){
        return sampleVarianceStandingRankOfGroupStandingsAs("varSampStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name){
        return sampleVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceStandingRank(), true);
    }
    public MatchGroupRequest<T> samplePopulationVarianceStandingRankOfGroupStandings(){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs("varPopStandingRankOfGroupStandings");
    }

    public MatchGroupRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public MatchGroupRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceStandingRank(), true);
    }

   public MatchGroupRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public MatchGroupRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, MatchGroup.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MatchGroupRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MatchGroupRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MatchGroupRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MatchGroupRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MatchGroupRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}