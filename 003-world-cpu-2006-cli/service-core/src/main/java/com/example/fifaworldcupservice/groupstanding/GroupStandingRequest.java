package com.example.fifaworldcupservice.groupstanding;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupRequest;
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
import java.time.LocalDateTime;
import java.util.Date;

public class GroupStandingRequest<T extends GroupStanding> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public GroupStandingRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public GroupStandingRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public GroupStandingRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public GroupStandingRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public GroupStandingRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public GroupStandingRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public GroupStandingRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (GroupStandingRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public GroupStandingRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public GroupStandingRequest<T> matchingAnyOf(GroupStandingRequest groupStanding){
        super.internalMatchAny(groupStanding);
        return this;
    }

    public GroupStandingRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public GroupStandingRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public GroupStandingRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public GroupStandingRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectPlayed().selectWon().selectDrawn().selectLost().selectGoalsFor().selectGoalsAgainst().selectGoalDifference().selectPoints().selectStandingRank().selectTournamentTeamIdOnly().selectMatchGroupIdOnly().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public GroupStandingRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public GroupStandingRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectPlayed().selectWon().selectDrawn().selectLost().selectGoalsFor().selectGoalsAgainst().selectGoalDifference().selectPoints().selectStandingRank().selectTournamentTeam().selectMatchGroup().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public GroupStandingRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectPlayed().selectWon().selectDrawn().selectLost().selectGoalsFor().selectGoalsAgainst().selectGoalDifference().selectPoints().selectStandingRank().selectTournamentTeam().selectMatchGroup().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public GroupStandingRequest<T> selectId(){
       selectProperty(GroupStanding.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GroupStandingRequest<T> unselectId(){
       unselectProperty(GroupStanding.ID_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectPlayed(){
       selectProperty(GroupStanding.PLAYED_PROPERTY);
       return this;
    }

    /**
     * fill the played with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  played) to fetch played property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the played with customized aggrFunction, TEAQL uses ({aggrFunction}(played) AS played to fetch played property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectPlayed(AggrFunction aggrFunction){
       selectProperty(GroupStanding.PLAYED_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectPlayed(){
       unselectProperty(GroupStanding.PLAYED_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectWon(){
       selectProperty(GroupStanding.WON_PROPERTY);
       return this;
    }

    /**
     * fill the won with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  won) to fetch won property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the won with customized aggrFunction, TEAQL uses ({aggrFunction}(won) AS won to fetch won property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectWon(AggrFunction aggrFunction){
       selectProperty(GroupStanding.WON_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectWon(){
       unselectProperty(GroupStanding.WON_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectDrawn(){
       selectProperty(GroupStanding.DRAWN_PROPERTY);
       return this;
    }

    /**
     * fill the drawn with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  drawn) to fetch drawn property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the drawn with customized aggrFunction, TEAQL uses ({aggrFunction}(drawn) AS drawn to fetch drawn property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectDrawn(AggrFunction aggrFunction){
       selectProperty(GroupStanding.DRAWN_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectDrawn(){
       unselectProperty(GroupStanding.DRAWN_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectLost(){
       selectProperty(GroupStanding.LOST_PROPERTY);
       return this;
    }

    /**
     * fill the lost with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  lost) to fetch lost property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the lost with customized aggrFunction, TEAQL uses ({aggrFunction}(lost) AS lost to fetch lost property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectLost(AggrFunction aggrFunction){
       selectProperty(GroupStanding.LOST_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectLost(){
       unselectProperty(GroupStanding.LOST_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectGoalsFor(){
       selectProperty(GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }

    /**
     * fill the goalsFor with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  goalsFor) to fetch goalsFor property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the goalsFor with customized aggrFunction, TEAQL uses ({aggrFunction}(goalsFor) AS goalsFor to fetch goalsFor property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectGoalsFor(AggrFunction aggrFunction){
       selectProperty(GroupStanding.GOALS_FOR_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectGoalsFor(){
       unselectProperty(GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectGoalsAgainst(){
       selectProperty(GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }

    /**
     * fill the goalsAgainst with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  goalsAgainst) to fetch goalsAgainst property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the goalsAgainst with customized aggrFunction, TEAQL uses ({aggrFunction}(goalsAgainst) AS goalsAgainst to fetch goalsAgainst property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectGoalsAgainst(AggrFunction aggrFunction){
       selectProperty(GroupStanding.GOALS_AGAINST_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectGoalsAgainst(){
       unselectProperty(GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectGoalDifference(){
       selectProperty(GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }

    /**
     * fill the goalDifference with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  goalDifference) to fetch goalDifference property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the goalDifference with customized aggrFunction, TEAQL uses ({aggrFunction}(goalDifference) AS goalDifference to fetch goalDifference property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectGoalDifference(AggrFunction aggrFunction){
       selectProperty(GroupStanding.GOAL_DIFFERENCE_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectGoalDifference(){
       unselectProperty(GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectPoints(){
       selectProperty(GroupStanding.POINTS_PROPERTY);
       return this;
    }

    /**
     * fill the points with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  points) to fetch points property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the points with customized aggrFunction, TEAQL uses ({aggrFunction}(points) AS points to fetch points property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectPoints(AggrFunction aggrFunction){
       selectProperty(GroupStanding.POINTS_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectPoints(){
       unselectProperty(GroupStanding.POINTS_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectStandingRank(){
       selectProperty(GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }

    /**
     * fill the standingRank with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  standingRank) to fetch standingRank property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the standingRank with customized aggrFunction, TEAQL uses ({aggrFunction}(standingRank) AS standingRank to fetch standingRank property.
     * @param aggrFunction  aggrFunction
     */
    public GroupStandingRequest<T> selectStandingRank(AggrFunction aggrFunction){
       selectProperty(GroupStanding.STANDING_RANK_PROPERTY, aggrFunction);
       return this;
    }


    public GroupStandingRequest<T> unselectStandingRank(){
       unselectProperty(GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectTournamentTeamIdOnly(){
       selectProperty(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> selectTournamentTeam(){
        return selectTournamentTeamWith(Q.tournamentTeams().unlimited().selectSelf());
    }

    public GroupStandingRequest<T> selectTournamentTeamWith(TournamentTeamRequest tournamentTeam){
       selectProperty(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       enhanceRelation(GroupStanding.TOURNAMENT_TEAM_PROPERTY, tournamentTeam);
       return this;
    }

    public GroupStandingRequest<T> unselectTournamentTeam(){
       unselectProperty(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectMatchGroupIdOnly(){
       selectProperty(GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> selectMatchGroup(){
        return selectMatchGroupWith(Q.matchGroups().unlimited().selectSelf());
    }

    public GroupStandingRequest<T> selectMatchGroupWith(MatchGroupRequest matchGroup){
       selectProperty(GroupStanding.MATCH_GROUP_PROPERTY);
       enhanceRelation(GroupStanding.MATCH_GROUP_PROPERTY, matchGroup);
       return this;
    }

    public GroupStandingRequest<T> unselectMatchGroup(){
       unselectProperty(GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectTournamentIdOnly(){
       selectProperty(GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public GroupStandingRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(GroupStanding.TOURNAMENT_PROPERTY);
       enhanceRelation(GroupStanding.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public GroupStandingRequest<T> unselectTournament(){
       unselectProperty(GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectCreateTime(){
       selectProperty(GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GroupStandingRequest<T> unselectCreateTime(){
       unselectProperty(GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectUpdateTime(){
       selectProperty(GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GroupStandingRequest<T> unselectUpdateTime(){
       unselectProperty(GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }
    public GroupStandingRequest<T> selectVersion(){
       selectProperty(GroupStanding.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GroupStandingRequest<T> unselectVersion(){
       unselectProperty(GroupStanding.VERSION_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.ID_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public GroupStandingRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public GroupStandingRequest<T> filterByPlayed(Integer... played){
      if (played == null || played.length == 0) {
        throw new IllegalArgumentException("filterByPlayed parameter played cannot be empty");
      }
      return appendSearchCriteria(createPlayedCriteria(Operator.EQUAL, (Object[])played));
    }

    public GroupStandingRequest<T> withPlayed(Operator operator, Object... values){
       return appendSearchCriteria(createPlayedCriteria(operator, values));
    }

    public GroupStandingRequest<T> withPlayedIsUnknown(){
       return withPlayed(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withPlayedIsKnown(){
       return withPlayed(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlayedCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.PLAYED_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withPlayedGreaterThan(Integer played){
       return withPlayed(Operator.GREATER_THAN, played);
    }

    public GroupStandingRequest<T> withPlayedGreaterThanOrEqualTo(Integer played){
       return withPlayed(Operator.GREATER_THAN_OR_EQUAL, played);
    }

    public GroupStandingRequest<T> withPlayedLessThan(Integer played){
       return withPlayed(Operator.LESS_THAN, played);
    }

    public GroupStandingRequest<T> withPlayedLessThanOrEqualTo(Integer played){
       return withPlayed(Operator.LESS_THAN_OR_EQUAL, played);
    }

    public GroupStandingRequest<T> withPlayedBetween(Integer startOfPlayed, Integer endOfPlayed){
       return withPlayed(Operator.BETWEEN, startOfPlayed, endOfPlayed);
    }



    public GroupStandingRequest<T> filterByWon(Integer... won){
      if (won == null || won.length == 0) {
        throw new IllegalArgumentException("filterByWon parameter won cannot be empty");
      }
      return appendSearchCriteria(createWonCriteria(Operator.EQUAL, (Object[])won));
    }

    public GroupStandingRequest<T> withWon(Operator operator, Object... values){
       return appendSearchCriteria(createWonCriteria(operator, values));
    }

    public GroupStandingRequest<T> withWonIsUnknown(){
       return withWon(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withWonIsKnown(){
       return withWon(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createWonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.WON_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withWonGreaterThan(Integer won){
       return withWon(Operator.GREATER_THAN, won);
    }

    public GroupStandingRequest<T> withWonGreaterThanOrEqualTo(Integer won){
       return withWon(Operator.GREATER_THAN_OR_EQUAL, won);
    }

    public GroupStandingRequest<T> withWonLessThan(Integer won){
       return withWon(Operator.LESS_THAN, won);
    }

    public GroupStandingRequest<T> withWonLessThanOrEqualTo(Integer won){
       return withWon(Operator.LESS_THAN_OR_EQUAL, won);
    }

    public GroupStandingRequest<T> withWonBetween(Integer startOfWon, Integer endOfWon){
       return withWon(Operator.BETWEEN, startOfWon, endOfWon);
    }



    public GroupStandingRequest<T> filterByDrawn(Integer... drawn){
      if (drawn == null || drawn.length == 0) {
        throw new IllegalArgumentException("filterByDrawn parameter drawn cannot be empty");
      }
      return appendSearchCriteria(createDrawnCriteria(Operator.EQUAL, (Object[])drawn));
    }

    public GroupStandingRequest<T> withDrawn(Operator operator, Object... values){
       return appendSearchCriteria(createDrawnCriteria(operator, values));
    }

    public GroupStandingRequest<T> withDrawnIsUnknown(){
       return withDrawn(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withDrawnIsKnown(){
       return withDrawn(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDrawnCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.DRAWN_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withDrawnGreaterThan(Integer drawn){
       return withDrawn(Operator.GREATER_THAN, drawn);
    }

    public GroupStandingRequest<T> withDrawnGreaterThanOrEqualTo(Integer drawn){
       return withDrawn(Operator.GREATER_THAN_OR_EQUAL, drawn);
    }

    public GroupStandingRequest<T> withDrawnLessThan(Integer drawn){
       return withDrawn(Operator.LESS_THAN, drawn);
    }

    public GroupStandingRequest<T> withDrawnLessThanOrEqualTo(Integer drawn){
       return withDrawn(Operator.LESS_THAN_OR_EQUAL, drawn);
    }

    public GroupStandingRequest<T> withDrawnBetween(Integer startOfDrawn, Integer endOfDrawn){
       return withDrawn(Operator.BETWEEN, startOfDrawn, endOfDrawn);
    }



    public GroupStandingRequest<T> filterByLost(Integer... lost){
      if (lost == null || lost.length == 0) {
        throw new IllegalArgumentException("filterByLost parameter lost cannot be empty");
      }
      return appendSearchCriteria(createLostCriteria(Operator.EQUAL, (Object[])lost));
    }

    public GroupStandingRequest<T> withLost(Operator operator, Object... values){
       return appendSearchCriteria(createLostCriteria(operator, values));
    }

    public GroupStandingRequest<T> withLostIsUnknown(){
       return withLost(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withLostIsKnown(){
       return withLost(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLostCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.LOST_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withLostGreaterThan(Integer lost){
       return withLost(Operator.GREATER_THAN, lost);
    }

    public GroupStandingRequest<T> withLostGreaterThanOrEqualTo(Integer lost){
       return withLost(Operator.GREATER_THAN_OR_EQUAL, lost);
    }

    public GroupStandingRequest<T> withLostLessThan(Integer lost){
       return withLost(Operator.LESS_THAN, lost);
    }

    public GroupStandingRequest<T> withLostLessThanOrEqualTo(Integer lost){
       return withLost(Operator.LESS_THAN_OR_EQUAL, lost);
    }

    public GroupStandingRequest<T> withLostBetween(Integer startOfLost, Integer endOfLost){
       return withLost(Operator.BETWEEN, startOfLost, endOfLost);
    }



    public GroupStandingRequest<T> filterByGoalsFor(Integer... goalsFor){
      if (goalsFor == null || goalsFor.length == 0) {
        throw new IllegalArgumentException("filterByGoalsFor parameter goalsFor cannot be empty");
      }
      return appendSearchCriteria(createGoalsForCriteria(Operator.EQUAL, (Object[])goalsFor));
    }

    public GroupStandingRequest<T> withGoalsFor(Operator operator, Object... values){
       return appendSearchCriteria(createGoalsForCriteria(operator, values));
    }

    public GroupStandingRequest<T> withGoalsForIsUnknown(){
       return withGoalsFor(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withGoalsForIsKnown(){
       return withGoalsFor(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGoalsForCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.GOALS_FOR_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withGoalsForGreaterThan(Integer goalsFor){
       return withGoalsFor(Operator.GREATER_THAN, goalsFor);
    }

    public GroupStandingRequest<T> withGoalsForGreaterThanOrEqualTo(Integer goalsFor){
       return withGoalsFor(Operator.GREATER_THAN_OR_EQUAL, goalsFor);
    }

    public GroupStandingRequest<T> withGoalsForLessThan(Integer goalsFor){
       return withGoalsFor(Operator.LESS_THAN, goalsFor);
    }

    public GroupStandingRequest<T> withGoalsForLessThanOrEqualTo(Integer goalsFor){
       return withGoalsFor(Operator.LESS_THAN_OR_EQUAL, goalsFor);
    }

    public GroupStandingRequest<T> withGoalsForBetween(Integer startOfGoalsFor, Integer endOfGoalsFor){
       return withGoalsFor(Operator.BETWEEN, startOfGoalsFor, endOfGoalsFor);
    }



    public GroupStandingRequest<T> filterByGoalsAgainst(Integer... goalsAgainst){
      if (goalsAgainst == null || goalsAgainst.length == 0) {
        throw new IllegalArgumentException("filterByGoalsAgainst parameter goalsAgainst cannot be empty");
      }
      return appendSearchCriteria(createGoalsAgainstCriteria(Operator.EQUAL, (Object[])goalsAgainst));
    }

    public GroupStandingRequest<T> withGoalsAgainst(Operator operator, Object... values){
       return appendSearchCriteria(createGoalsAgainstCriteria(operator, values));
    }

    public GroupStandingRequest<T> withGoalsAgainstIsUnknown(){
       return withGoalsAgainst(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withGoalsAgainstIsKnown(){
       return withGoalsAgainst(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGoalsAgainstCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.GOALS_AGAINST_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withGoalsAgainstGreaterThan(Integer goalsAgainst){
       return withGoalsAgainst(Operator.GREATER_THAN, goalsAgainst);
    }

    public GroupStandingRequest<T> withGoalsAgainstGreaterThanOrEqualTo(Integer goalsAgainst){
       return withGoalsAgainst(Operator.GREATER_THAN_OR_EQUAL, goalsAgainst);
    }

    public GroupStandingRequest<T> withGoalsAgainstLessThan(Integer goalsAgainst){
       return withGoalsAgainst(Operator.LESS_THAN, goalsAgainst);
    }

    public GroupStandingRequest<T> withGoalsAgainstLessThanOrEqualTo(Integer goalsAgainst){
       return withGoalsAgainst(Operator.LESS_THAN_OR_EQUAL, goalsAgainst);
    }

    public GroupStandingRequest<T> withGoalsAgainstBetween(Integer startOfGoalsAgainst, Integer endOfGoalsAgainst){
       return withGoalsAgainst(Operator.BETWEEN, startOfGoalsAgainst, endOfGoalsAgainst);
    }



    public GroupStandingRequest<T> filterByGoalDifference(Integer... goalDifference){
      if (goalDifference == null || goalDifference.length == 0) {
        throw new IllegalArgumentException("filterByGoalDifference parameter goalDifference cannot be empty");
      }
      return appendSearchCriteria(createGoalDifferenceCriteria(Operator.EQUAL, (Object[])goalDifference));
    }

    public GroupStandingRequest<T> withGoalDifference(Operator operator, Object... values){
       return appendSearchCriteria(createGoalDifferenceCriteria(operator, values));
    }

    public GroupStandingRequest<T> withGoalDifferenceIsUnknown(){
       return withGoalDifference(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withGoalDifferenceIsKnown(){
       return withGoalDifference(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGoalDifferenceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.GOAL_DIFFERENCE_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withGoalDifferenceGreaterThan(Integer goalDifference){
       return withGoalDifference(Operator.GREATER_THAN, goalDifference);
    }

    public GroupStandingRequest<T> withGoalDifferenceGreaterThanOrEqualTo(Integer goalDifference){
       return withGoalDifference(Operator.GREATER_THAN_OR_EQUAL, goalDifference);
    }

    public GroupStandingRequest<T> withGoalDifferenceLessThan(Integer goalDifference){
       return withGoalDifference(Operator.LESS_THAN, goalDifference);
    }

    public GroupStandingRequest<T> withGoalDifferenceLessThanOrEqualTo(Integer goalDifference){
       return withGoalDifference(Operator.LESS_THAN_OR_EQUAL, goalDifference);
    }

    public GroupStandingRequest<T> withGoalDifferenceBetween(Integer startOfGoalDifference, Integer endOfGoalDifference){
       return withGoalDifference(Operator.BETWEEN, startOfGoalDifference, endOfGoalDifference);
    }



    public GroupStandingRequest<T> filterByPoints(Integer... points){
      if (points == null || points.length == 0) {
        throw new IllegalArgumentException("filterByPoints parameter points cannot be empty");
      }
      return appendSearchCriteria(createPointsCriteria(Operator.EQUAL, (Object[])points));
    }

    public GroupStandingRequest<T> withPoints(Operator operator, Object... values){
       return appendSearchCriteria(createPointsCriteria(operator, values));
    }

    public GroupStandingRequest<T> withPointsIsUnknown(){
       return withPoints(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withPointsIsKnown(){
       return withPoints(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPointsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.POINTS_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withPointsGreaterThan(Integer points){
       return withPoints(Operator.GREATER_THAN, points);
    }

    public GroupStandingRequest<T> withPointsGreaterThanOrEqualTo(Integer points){
       return withPoints(Operator.GREATER_THAN_OR_EQUAL, points);
    }

    public GroupStandingRequest<T> withPointsLessThan(Integer points){
       return withPoints(Operator.LESS_THAN, points);
    }

    public GroupStandingRequest<T> withPointsLessThanOrEqualTo(Integer points){
       return withPoints(Operator.LESS_THAN_OR_EQUAL, points);
    }

    public GroupStandingRequest<T> withPointsBetween(Integer startOfPoints, Integer endOfPoints){
       return withPoints(Operator.BETWEEN, startOfPoints, endOfPoints);
    }



    public GroupStandingRequest<T> filterByStandingRank(Integer... standingRank){
      if (standingRank == null || standingRank.length == 0) {
        throw new IllegalArgumentException("filterByStandingRank parameter standingRank cannot be empty");
      }
      return appendSearchCriteria(createStandingRankCriteria(Operator.EQUAL, (Object[])standingRank));
    }

    public GroupStandingRequest<T> withStandingRank(Operator operator, Object... values){
       return appendSearchCriteria(createStandingRankCriteria(operator, values));
    }

    public GroupStandingRequest<T> withStandingRankIsUnknown(){
       return withStandingRank(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withStandingRankIsKnown(){
       return withStandingRank(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStandingRankCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.STANDING_RANK_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withStandingRankGreaterThan(Integer standingRank){
       return withStandingRank(Operator.GREATER_THAN, standingRank);
    }

    public GroupStandingRequest<T> withStandingRankGreaterThanOrEqualTo(Integer standingRank){
       return withStandingRank(Operator.GREATER_THAN_OR_EQUAL, standingRank);
    }

    public GroupStandingRequest<T> withStandingRankLessThan(Integer standingRank){
       return withStandingRank(Operator.LESS_THAN, standingRank);
    }

    public GroupStandingRequest<T> withStandingRankLessThanOrEqualTo(Integer standingRank){
       return withStandingRank(Operator.LESS_THAN_OR_EQUAL, standingRank);
    }

    public GroupStandingRequest<T> withStandingRankBetween(Integer startOfStandingRank, Integer endOfStandingRank){
       return withStandingRank(Operator.BETWEEN, startOfStandingRank, endOfStandingRank);
    }



    public GroupStandingRequest<T> filterByTournamentTeam(TournamentTeam... tournamentTeam){
      if (tournamentTeam == null || tournamentTeam.length == 0) {
        throw new IllegalArgumentException("filterByTournamentTeam parameter tournamentTeam cannot be empty");
      }
      return appendSearchCriteria(createTournamentTeamCriteria(Operator.EQUAL, (Object[])tournamentTeam));
    }

    public GroupStandingRequest<T> withTournamentTeam(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentTeamCriteria(operator, values));
    }

    public GroupStandingRequest<T> withTournamentTeamIsUnknown(){
       return withTournamentTeam(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withTournamentTeamIsKnown(){
       return withTournamentTeam(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentTeamCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.TOURNAMENT_TEAM_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> filterByTournamentTeam(Long tournamentTeam){
      if(tournamentTeam == null){
         return this;
      }
      return withTournamentTeam(Operator.EQUAL, tournamentTeam);
    }
    public GroupStandingRequest<T> withTournamentTeamMatching(TournamentTeamRequest tournamentTeam){
       return appendSearchCriteria(new SubQuerySearchCriteria(GroupStanding.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, TournamentTeam.ID_PROPERTY));
    }

    public GroupStandingRequest<T> filterByMatchGroup(MatchGroup... matchGroup){
      if (matchGroup == null || matchGroup.length == 0) {
        throw new IllegalArgumentException("filterByMatchGroup parameter matchGroup cannot be empty");
      }
      return appendSearchCriteria(createMatchGroupCriteria(Operator.EQUAL, (Object[])matchGroup));
    }

    public GroupStandingRequest<T> withMatchGroup(Operator operator, Object... values){
       return appendSearchCriteria(createMatchGroupCriteria(operator, values));
    }

    public GroupStandingRequest<T> withMatchGroupIsUnknown(){
       return withMatchGroup(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withMatchGroupIsKnown(){
       return withMatchGroup(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchGroupCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.MATCH_GROUP_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> filterByMatchGroup(Long matchGroup){
      if(matchGroup == null){
         return this;
      }
      return withMatchGroup(Operator.EQUAL, matchGroup);
    }
    public GroupStandingRequest<T> withMatchGroupMatching(MatchGroupRequest matchGroup){
       return appendSearchCriteria(new SubQuerySearchCriteria(GroupStanding.MATCH_GROUP_PROPERTY, matchGroup, MatchGroup.ID_PROPERTY));
    }

    public GroupStandingRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public GroupStandingRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public GroupStandingRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.TOURNAMENT_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public GroupStandingRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(GroupStanding.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public GroupStandingRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public GroupStandingRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public GroupStandingRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.CREATE_TIME_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public GroupStandingRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GroupStandingRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public GroupStandingRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public GroupStandingRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public GroupStandingRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.UPDATE_TIME_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public GroupStandingRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GroupStandingRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public GroupStandingRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public GroupStandingRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public GroupStandingRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public GroupStandingRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GroupStanding.VERSION_PROPERTY, operator, values);
    }

    public GroupStandingRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public GroupStandingRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public GroupStandingRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public GroupStandingRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public GroupStandingRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public GroupStandingRequest<T> count(){
        super.count();
        return this;
    }
    public GroupStandingRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public GroupStandingRequest minPlayed(){
        return minPlayedAs(prefix("minOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest minPlayedAs(String retName){
        super.min(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxPlayed(){
        return maxPlayedAs(prefix("maxOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest maxPlayedAs(String retName){
        super.max(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumPlayed(){
        return sumPlayedAs(prefix("sumOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest sumPlayedAs(String retName){
        super.sum(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgPlayed(){
        return avgPlayedAs(prefix("avgOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest avgPlayedAs(String retName){
        super.avg(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationPlayed(){
        return standardDeviationPlayedAs(prefix("standardDeviationOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest standardDeviationPlayedAs(String retName){
        super.standardDeviation(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationPlayed(){
        return squareRootOfPopulationStandardDeviationPlayedAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationPlayedAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVariancePlayed(){
        return sampleVariancePlayedAs(prefix("sampleVarianceOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest sampleVariancePlayedAs(String retName){
        super.sampleVariance(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVariancePlayed(){
        return samplePopulationVariancePlayedAs(prefix("samplePopulationVarianceOf",GroupStanding.PLAYED_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVariancePlayedAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.PLAYED_PROPERTY);
        return this;
    }
    public GroupStandingRequest minWon(){
        return minWonAs(prefix("minOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest minWonAs(String retName){
        super.min(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxWon(){
        return maxWonAs(prefix("maxOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest maxWonAs(String retName){
        super.max(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumWon(){
        return sumWonAs(prefix("sumOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest sumWonAs(String retName){
        super.sum(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgWon(){
        return avgWonAs(prefix("avgOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest avgWonAs(String retName){
        super.avg(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationWon(){
        return standardDeviationWonAs(prefix("standardDeviationOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest standardDeviationWonAs(String retName){
        super.standardDeviation(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationWon(){
        return squareRootOfPopulationStandardDeviationWonAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationWonAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceWon(){
        return sampleVarianceWonAs(prefix("sampleVarianceOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceWonAs(String retName){
        super.sampleVariance(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceWon(){
        return samplePopulationVarianceWonAs(prefix("samplePopulationVarianceOf",GroupStanding.WON_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceWonAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.WON_PROPERTY);
        return this;
    }
    public GroupStandingRequest minDrawn(){
        return minDrawnAs(prefix("minOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest minDrawnAs(String retName){
        super.min(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxDrawn(){
        return maxDrawnAs(prefix("maxOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest maxDrawnAs(String retName){
        super.max(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumDrawn(){
        return sumDrawnAs(prefix("sumOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest sumDrawnAs(String retName){
        super.sum(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgDrawn(){
        return avgDrawnAs(prefix("avgOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest avgDrawnAs(String retName){
        super.avg(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationDrawn(){
        return standardDeviationDrawnAs(prefix("standardDeviationOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest standardDeviationDrawnAs(String retName){
        super.standardDeviation(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationDrawn(){
        return squareRootOfPopulationStandardDeviationDrawnAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationDrawnAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceDrawn(){
        return sampleVarianceDrawnAs(prefix("sampleVarianceOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceDrawnAs(String retName){
        super.sampleVariance(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceDrawn(){
        return samplePopulationVarianceDrawnAs(prefix("samplePopulationVarianceOf",GroupStanding.DRAWN_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceDrawnAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.DRAWN_PROPERTY);
        return this;
    }
    public GroupStandingRequest minLost(){
        return minLostAs(prefix("minOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest minLostAs(String retName){
        super.min(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxLost(){
        return maxLostAs(prefix("maxOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest maxLostAs(String retName){
        super.max(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumLost(){
        return sumLostAs(prefix("sumOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest sumLostAs(String retName){
        super.sum(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgLost(){
        return avgLostAs(prefix("avgOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest avgLostAs(String retName){
        super.avg(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationLost(){
        return standardDeviationLostAs(prefix("standardDeviationOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest standardDeviationLostAs(String retName){
        super.standardDeviation(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationLost(){
        return squareRootOfPopulationStandardDeviationLostAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationLostAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceLost(){
        return sampleVarianceLostAs(prefix("sampleVarianceOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceLostAs(String retName){
        super.sampleVariance(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceLost(){
        return samplePopulationVarianceLostAs(prefix("samplePopulationVarianceOf",GroupStanding.LOST_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceLostAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.LOST_PROPERTY);
        return this;
    }
    public GroupStandingRequest minGoalsFor(){
        return minGoalsForAs(prefix("minOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest minGoalsForAs(String retName){
        super.min(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxGoalsFor(){
        return maxGoalsForAs(prefix("maxOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest maxGoalsForAs(String retName){
        super.max(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumGoalsFor(){
        return sumGoalsForAs(prefix("sumOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest sumGoalsForAs(String retName){
        super.sum(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgGoalsFor(){
        return avgGoalsForAs(prefix("avgOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest avgGoalsForAs(String retName){
        super.avg(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationGoalsFor(){
        return standardDeviationGoalsForAs(prefix("standardDeviationOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest standardDeviationGoalsForAs(String retName){
        super.standardDeviation(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalsFor(){
        return squareRootOfPopulationStandardDeviationGoalsForAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalsForAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceGoalsFor(){
        return sampleVarianceGoalsForAs(prefix("sampleVarianceOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceGoalsForAs(String retName){
        super.sampleVariance(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceGoalsFor(){
        return samplePopulationVarianceGoalsForAs(prefix("samplePopulationVarianceOf",GroupStanding.GOALS_FOR_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceGoalsForAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.GOALS_FOR_PROPERTY);
        return this;
    }
    public GroupStandingRequest minGoalsAgainst(){
        return minGoalsAgainstAs(prefix("minOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest minGoalsAgainstAs(String retName){
        super.min(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxGoalsAgainst(){
        return maxGoalsAgainstAs(prefix("maxOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest maxGoalsAgainstAs(String retName){
        super.max(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumGoalsAgainst(){
        return sumGoalsAgainstAs(prefix("sumOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest sumGoalsAgainstAs(String retName){
        super.sum(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgGoalsAgainst(){
        return avgGoalsAgainstAs(prefix("avgOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest avgGoalsAgainstAs(String retName){
        super.avg(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationGoalsAgainst(){
        return standardDeviationGoalsAgainstAs(prefix("standardDeviationOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest standardDeviationGoalsAgainstAs(String retName){
        super.standardDeviation(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalsAgainst(){
        return squareRootOfPopulationStandardDeviationGoalsAgainstAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalsAgainstAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceGoalsAgainst(){
        return sampleVarianceGoalsAgainstAs(prefix("sampleVarianceOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceGoalsAgainstAs(String retName){
        super.sampleVariance(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceGoalsAgainst(){
        return samplePopulationVarianceGoalsAgainstAs(prefix("samplePopulationVarianceOf",GroupStanding.GOALS_AGAINST_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceGoalsAgainstAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
        return this;
    }
    public GroupStandingRequest minGoalDifference(){
        return minGoalDifferenceAs(prefix("minOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest minGoalDifferenceAs(String retName){
        super.min(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxGoalDifference(){
        return maxGoalDifferenceAs(prefix("maxOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest maxGoalDifferenceAs(String retName){
        super.max(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumGoalDifference(){
        return sumGoalDifferenceAs(prefix("sumOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest sumGoalDifferenceAs(String retName){
        super.sum(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgGoalDifference(){
        return avgGoalDifferenceAs(prefix("avgOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest avgGoalDifferenceAs(String retName){
        super.avg(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationGoalDifference(){
        return standardDeviationGoalDifferenceAs(prefix("standardDeviationOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest standardDeviationGoalDifferenceAs(String retName){
        super.standardDeviation(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalDifference(){
        return squareRootOfPopulationStandardDeviationGoalDifferenceAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationGoalDifferenceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceGoalDifference(){
        return sampleVarianceGoalDifferenceAs(prefix("sampleVarianceOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceGoalDifferenceAs(String retName){
        super.sampleVariance(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceGoalDifference(){
        return samplePopulationVarianceGoalDifferenceAs(prefix("samplePopulationVarianceOf",GroupStanding.GOAL_DIFFERENCE_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceGoalDifferenceAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
        return this;
    }
    public GroupStandingRequest minPoints(){
        return minPointsAs(prefix("minOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest minPointsAs(String retName){
        super.min(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxPoints(){
        return maxPointsAs(prefix("maxOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest maxPointsAs(String retName){
        super.max(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumPoints(){
        return sumPointsAs(prefix("sumOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest sumPointsAs(String retName){
        super.sum(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgPoints(){
        return avgPointsAs(prefix("avgOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest avgPointsAs(String retName){
        super.avg(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationPoints(){
        return standardDeviationPointsAs(prefix("standardDeviationOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest standardDeviationPointsAs(String retName){
        super.standardDeviation(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationPoints(){
        return squareRootOfPopulationStandardDeviationPointsAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationPointsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVariancePoints(){
        return sampleVariancePointsAs(prefix("sampleVarianceOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest sampleVariancePointsAs(String retName){
        super.sampleVariance(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVariancePoints(){
        return samplePopulationVariancePointsAs(prefix("samplePopulationVarianceOf",GroupStanding.POINTS_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVariancePointsAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.POINTS_PROPERTY);
        return this;
    }
    public GroupStandingRequest minStandingRank(){
        return minStandingRankAs(prefix("minOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest minStandingRankAs(String retName){
        super.min(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest maxStandingRank(){
        return maxStandingRankAs(prefix("maxOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest maxStandingRankAs(String retName){
        super.max(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest sumStandingRank(){
        return sumStandingRankAs(prefix("sumOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest sumStandingRankAs(String retName){
        super.sum(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest avgStandingRank(){
        return avgStandingRankAs(prefix("avgOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest avgStandingRankAs(String retName){
        super.avg(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest standardDeviationStandingRank(){
        return standardDeviationStandingRankAs(prefix("standardDeviationOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest standardDeviationStandingRankAs(String retName){
        super.standardDeviation(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest squareRootOfPopulationStandardDeviationStandingRank(){
        return squareRootOfPopulationStandardDeviationStandingRankAs(prefix("squareRootOfPopulationStandardDeviationOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest squareRootOfPopulationStandardDeviationStandingRankAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest sampleVarianceStandingRank(){
        return sampleVarianceStandingRankAs(prefix("sampleVarianceOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest sampleVarianceStandingRankAs(String retName){
        super.sampleVariance(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest samplePopulationVarianceStandingRank(){
        return samplePopulationVarianceStandingRankAs(prefix("samplePopulationVarianceOf",GroupStanding.STANDING_RANK_PROPERTY));
    }

    public GroupStandingRequest samplePopulationVarianceStandingRankAs(String retName){
        super.samplePopulationVariance(retName, GroupStanding.STANDING_RANK_PROPERTY);
        return this;
    }
    public GroupStandingRequest<T> groupByTournamentTeamWithDetails(){
       return groupByTournamentTeamWithDetails(Q.tournamentTeams().unlimited());
    }

    public GroupStandingRequest<T> groupByTournamentTeamWithDetails(TournamentTeamRequest subRequest){
       aggregate(GroupStanding.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }

    public GroupStandingRequest<T> groupByMatchGroupWithDetails(){
       return groupByMatchGroupWithDetails(Q.matchGroups().unlimited());
    }

    public GroupStandingRequest<T> groupByMatchGroupWithDetails(MatchGroupRequest subRequest){
       aggregate(GroupStanding.MATCH_GROUP_PROPERTY, subRequest);
       return this;
    }

    public GroupStandingRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public GroupStandingRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(GroupStanding.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }





    public GroupStandingRequest<T> groupById(){
       groupBy(GroupStanding.ID_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByIdAs(String retName){
       groupBy(retName, GroupStanding.ID_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.ID_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByPlayed(){
       groupBy(GroupStanding.PLAYED_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByPlayedAs(String retName){
       groupBy(retName, GroupStanding.PLAYED_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByPlayedWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.PLAYED_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByWon(){
       groupBy(GroupStanding.WON_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByWonAs(String retName){
       groupBy(retName, GroupStanding.WON_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByWonWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.WON_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByDrawn(){
       groupBy(GroupStanding.DRAWN_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByDrawnAs(String retName){
       groupBy(retName, GroupStanding.DRAWN_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByDrawnWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.DRAWN_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByLost(){
       groupBy(GroupStanding.LOST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByLostAs(String retName){
       groupBy(retName, GroupStanding.LOST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByLostWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.LOST_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsFor(){
       groupBy(GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsForAs(String retName){
       groupBy(retName, GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsForWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.GOALS_FOR_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsAgainst(){
       groupBy(GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsAgainstAs(String retName){
       groupBy(retName, GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalsAgainstWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.GOALS_AGAINST_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalDifference(){
       groupBy(GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalDifferenceAs(String retName){
       groupBy(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByGoalDifferenceWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.GOAL_DIFFERENCE_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByPoints(){
       groupBy(GroupStanding.POINTS_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByPointsAs(String retName){
       groupBy(retName, GroupStanding.POINTS_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByPointsWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.POINTS_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByStandingRank(){
       groupBy(GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByStandingRankAs(String retName){
       groupBy(retName, GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByStandingRankWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.STANDING_RANK_PROPERTY, function);
       return this;
    }
    public GroupStandingRequest<T> groupByTournamentTeamWith(TournamentTeamRequest subRequest){
       groupBy(GroupStanding.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }
    public GroupStandingRequest<T> groupByTournamentTeam(){
       groupBy(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByTournamentTeamAs(String retName){
       groupBy(retName, GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByTournamentTeamWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.TOURNAMENT_TEAM_PROPERTY, function);
       return this;
    }
    public GroupStandingRequest<T> groupByMatchGroupWith(MatchGroupRequest subRequest){
       groupBy(GroupStanding.MATCH_GROUP_PROPERTY, subRequest);
       return this;
    }
    public GroupStandingRequest<T> groupByMatchGroup(){
       groupBy(GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByMatchGroupAs(String retName){
       groupBy(retName, GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByMatchGroupWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.MATCH_GROUP_PROPERTY, function);
       return this;
    }
    public GroupStandingRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(GroupStanding.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public GroupStandingRequest<T> groupByTournament(){
       groupBy(GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByCreateTime(){
       groupBy(GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByUpdateTime(){
       groupBy(GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public GroupStandingRequest<T> groupByVersion(){
       groupBy(GroupStanding.VERSION_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByVersionAs(String retName){
       groupBy(retName, GroupStanding.VERSION_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, GroupStanding.VERSION_PROPERTY, function);
       return this;
    }



    public GroupStandingRequest<T> orderByIdAscending(){
       addOrderByAscending(GroupStanding.ID_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByIdDescending(){
       addOrderByDescending(GroupStanding.ID_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByPlayedAscending(){
       addOrderByAscending(GroupStanding.PLAYED_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByPlayedDescending(){
       addOrderByDescending(GroupStanding.PLAYED_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByWonAscending(){
       addOrderByAscending(GroupStanding.WON_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByWonDescending(){
       addOrderByDescending(GroupStanding.WON_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByDrawnAscending(){
       addOrderByAscending(GroupStanding.DRAWN_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByDrawnDescending(){
       addOrderByDescending(GroupStanding.DRAWN_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByLostAscending(){
       addOrderByAscending(GroupStanding.LOST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByLostDescending(){
       addOrderByDescending(GroupStanding.LOST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalsForAscending(){
       addOrderByAscending(GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalsForDescending(){
       addOrderByDescending(GroupStanding.GOALS_FOR_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalsAgainstAscending(){
       addOrderByAscending(GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalsAgainstDescending(){
       addOrderByDescending(GroupStanding.GOALS_AGAINST_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalDifferenceAscending(){
       addOrderByAscending(GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByGoalDifferenceDescending(){
       addOrderByDescending(GroupStanding.GOAL_DIFFERENCE_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByPointsAscending(){
       addOrderByAscending(GroupStanding.POINTS_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByPointsDescending(){
       addOrderByDescending(GroupStanding.POINTS_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByStandingRankAscending(){
       addOrderByAscending(GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByStandingRankDescending(){
       addOrderByDescending(GroupStanding.STANDING_RANK_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByTournamentTeamAscending(){
       addOrderByAscending(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByTournamentTeamDescending(){
       addOrderByDescending(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByMatchGroupAscending(){
       addOrderByAscending(GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByMatchGroupDescending(){
       addOrderByDescending(GroupStanding.MATCH_GROUP_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByTournamentAscending(){
       addOrderByAscending(GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByTournamentDescending(){
       addOrderByDescending(GroupStanding.TOURNAMENT_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(GroupStanding.CREATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(GroupStanding.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByVersionAscending(){
       addOrderByAscending(GroupStanding.VERSION_PROPERTY);
       return this;
    }

    public GroupStandingRequest<T> orderByVersionDescending(){
       addOrderByDescending(GroupStanding.VERSION_PROPERTY);
       return this;
    }


    public TournamentTeamRequest rollUpToTournamentTeam(){
       TournamentTeamRequest tournamentTeam = Q.tournamentTeams().unlimited();
       this.withTournamentTeamMatching(tournamentTeam)
           .groupByTournamentTeamWith(tournamentTeam);
       return tournamentTeam;
    }

    public MatchGroupRequest rollUpToMatchGroup(){
       MatchGroupRequest matchGroup = Q.matchGroups().unlimited();
       this.withMatchGroupMatching(matchGroup)
           .groupByMatchGroupWith(matchGroup);
       return matchGroup;
    }

    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }





   public GroupStandingRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam){
       return facetByTournamentTeamAs(facetName, tournamentTeam, true);
   }

   public GroupStandingRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam, boolean includeAllFacets){
       addFacet(facetName, GroupStanding.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, includeAllFacets);
       return this;
   }
   public GroupStandingRequest<T> facetByMatchGroupAs(String facetName, MatchGroupRequest matchGroup){
       return facetByMatchGroupAs(facetName, matchGroup, true);
   }

   public GroupStandingRequest<T> facetByMatchGroupAs(String facetName, MatchGroupRequest matchGroup, boolean includeAllFacets){
       addFacet(facetName, GroupStanding.MATCH_GROUP_PROPERTY, matchGroup, includeAllFacets);
       return this;
   }
   public GroupStandingRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public GroupStandingRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, GroupStanding.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public GroupStandingRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public GroupStandingRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public GroupStandingRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public GroupStandingRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public GroupStandingRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}