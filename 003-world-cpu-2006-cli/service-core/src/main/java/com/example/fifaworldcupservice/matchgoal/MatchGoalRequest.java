package com.example.fifaworldcupservice.matchgoal;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentRequest;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest;
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

public class MatchGoalRequest<T extends MatchGoal> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MatchGoalRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MatchGoalRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MatchGoalRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MatchGoalRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MatchGoalRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MatchGoalRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MatchGoalRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MatchGoalRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MatchGoalRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MatchGoalRequest<T> matchingAnyOf(MatchGoalRequest matchGoal){
        super.internalMatchAny(matchGoal);
        return this;
    }

    public MatchGoalRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MatchGoalRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MatchGoalRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MatchGoalRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectPlayerName().selectMinuteScored().selectTournamentMatchIdOnly().selectTournamentTeamIdOnly().selectGoalCategoryIdOnly().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchGoalRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MatchGoalRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectPlayerName().selectMinuteScored().selectTournamentMatch().selectTournamentTeam().selectGoalCategory().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchGoalRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectPlayerName().selectMinuteScored().selectTournamentMatch().selectTournamentTeam().selectGoalCategory().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public MatchGoalRequest<T> selectId(){
       selectProperty(MatchGoal.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGoalRequest<T> unselectId(){
       unselectProperty(MatchGoal.ID_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectPlayerName(){
       selectProperty(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the playerName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  playerName) to fetch playerName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGoalRequest<T> unselectPlayerName(){
       unselectProperty(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectMinuteScored(){
       selectProperty(MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }

    /**
     * fill the minuteScored with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  minuteScored) to fetch minuteScored property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the minuteScored with customized aggrFunction, TEAQL uses ({aggrFunction}(minuteScored) AS minuteScored to fetch minuteScored property.
     * @param aggrFunction  aggrFunction
     */
    public MatchGoalRequest<T> selectMinuteScored(AggrFunction aggrFunction){
       selectProperty(MatchGoal.MINUTE_SCORED_PROPERTY, aggrFunction);
       return this;
    }


    public MatchGoalRequest<T> unselectMinuteScored(){
       unselectProperty(MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectTournamentMatchIdOnly(){
       selectProperty(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> selectTournamentMatch(){
        return selectTournamentMatchWith(Q.tournamentMatches().unlimited().selectSelf());
    }

    public MatchGoalRequest<T> selectTournamentMatchWith(TournamentMatchRequest tournamentMatch){
       selectProperty(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       enhanceRelation(MatchGoal.TOURNAMENT_MATCH_PROPERTY, tournamentMatch);
       return this;
    }

    public MatchGoalRequest<T> unselectTournamentMatch(){
       unselectProperty(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectTournamentTeamIdOnly(){
       selectProperty(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> selectTournamentTeam(){
        return selectTournamentTeamWith(Q.tournamentTeams().unlimited().selectSelf());
    }

    public MatchGoalRequest<T> selectTournamentTeamWith(TournamentTeamRequest tournamentTeam){
       selectProperty(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       enhanceRelation(MatchGoal.TOURNAMENT_TEAM_PROPERTY, tournamentTeam);
       return this;
    }

    public MatchGoalRequest<T> unselectTournamentTeam(){
       unselectProperty(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectGoalCategoryIdOnly(){
       selectProperty(MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> selectGoalCategory(){
        return selectGoalCategoryWith(Q.goalCategories().unlimited().selectSelf());
    }

    public MatchGoalRequest<T> selectGoalCategoryWith(GoalCategoryRequest goalCategory){
       selectProperty(MatchGoal.GOAL_CATEGORY_PROPERTY);
       enhanceRelation(MatchGoal.GOAL_CATEGORY_PROPERTY, goalCategory);
       return this;
    }

    public MatchGoalRequest<T> unselectGoalCategory(){
       unselectProperty(MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectTournamentIdOnly(){
       selectProperty(MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public MatchGoalRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(MatchGoal.TOURNAMENT_PROPERTY);
       enhanceRelation(MatchGoal.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public MatchGoalRequest<T> unselectTournament(){
       unselectProperty(MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectCreateTime(){
       selectProperty(MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGoalRequest<T> unselectCreateTime(){
       unselectProperty(MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectUpdateTime(){
       selectProperty(MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGoalRequest<T> unselectUpdateTime(){
       unselectProperty(MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> selectVersion(){
       selectProperty(MatchGoal.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchGoalRequest<T> unselectVersion(){
       unselectProperty(MatchGoal.VERSION_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.ID_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MatchGoalRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MatchGoalRequest<T> filterByPlayerName(String... playerName){
      if (playerName == null || playerName.length == 0) {
        throw new IllegalArgumentException("filterByPlayerName parameter playerName cannot be empty");
      }
      return appendSearchCriteria(createPlayerNameCriteria(Operator.EQUAL, (Object[])playerName));
    }

    public MatchGoalRequest<T> withPlayerName(Operator operator, Object... values){
       return appendSearchCriteria(createPlayerNameCriteria(operator, values));
    }

    public MatchGoalRequest<T> withPlayerNameIsUnknown(){
       return withPlayerName(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withPlayerNameIsKnown(){
       return withPlayerName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlayerNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.PLAYER_NAME_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withPlayerNameGreaterThan(String playerName){
       return withPlayerName(Operator.GREATER_THAN, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameGreaterThanOrEqualTo(String playerName){
       return withPlayerName(Operator.GREATER_THAN_OR_EQUAL, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameLessThan(String playerName){
       return withPlayerName(Operator.LESS_THAN, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameLessThanOrEqualTo(String playerName){
       return withPlayerName(Operator.LESS_THAN_OR_EQUAL, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameBetween(String startOfPlayerName, String endOfPlayerName){
       return withPlayerName(Operator.BETWEEN, startOfPlayerName, endOfPlayerName);
    }
    public MatchGoalRequest<T> withPlayerNameStartingWith(String playerName){
       return withPlayerName(Operator.BEGIN_WITH, playerName);
    }
    public MatchGoalRequest<T> withPlayerNameContaining(String playerName){
       return withPlayerName(Operator.CONTAIN, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameEndingWith(String playerName){
       return withPlayerName(Operator.END_WITH, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameIs(String playerName){
       return withPlayerName(Operator.EQUAL, playerName);
    }

    public MatchGoalRequest<T> withPlayerNameSoundingLike(String playerName){
       return withPlayerName(Operator.SOUNDS_LIKE, playerName);
    }



    public MatchGoalRequest<T> filterByMinuteScored(Integer... minuteScored){
      if (minuteScored == null || minuteScored.length == 0) {
        throw new IllegalArgumentException("filterByMinuteScored parameter minuteScored cannot be empty");
      }
      return appendSearchCriteria(createMinuteScoredCriteria(Operator.EQUAL, (Object[])minuteScored));
    }

    public MatchGoalRequest<T> withMinuteScored(Operator operator, Object... values){
       return appendSearchCriteria(createMinuteScoredCriteria(operator, values));
    }

    public MatchGoalRequest<T> withMinuteScoredIsUnknown(){
       return withMinuteScored(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withMinuteScoredIsKnown(){
       return withMinuteScored(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMinuteScoredCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.MINUTE_SCORED_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withMinuteScoredGreaterThan(Integer minuteScored){
       return withMinuteScored(Operator.GREATER_THAN, minuteScored);
    }

    public MatchGoalRequest<T> withMinuteScoredGreaterThanOrEqualTo(Integer minuteScored){
       return withMinuteScored(Operator.GREATER_THAN_OR_EQUAL, minuteScored);
    }

    public MatchGoalRequest<T> withMinuteScoredLessThan(Integer minuteScored){
       return withMinuteScored(Operator.LESS_THAN, minuteScored);
    }

    public MatchGoalRequest<T> withMinuteScoredLessThanOrEqualTo(Integer minuteScored){
       return withMinuteScored(Operator.LESS_THAN_OR_EQUAL, minuteScored);
    }

    public MatchGoalRequest<T> withMinuteScoredBetween(Integer startOfMinuteScored, Integer endOfMinuteScored){
       return withMinuteScored(Operator.BETWEEN, startOfMinuteScored, endOfMinuteScored);
    }



    public MatchGoalRequest<T> filterByTournamentMatch(TournamentMatch... tournamentMatch){
      if (tournamentMatch == null || tournamentMatch.length == 0) {
        throw new IllegalArgumentException("filterByTournamentMatch parameter tournamentMatch cannot be empty");
      }
      return appendSearchCriteria(createTournamentMatchCriteria(Operator.EQUAL, (Object[])tournamentMatch));
    }

    public MatchGoalRequest<T> withTournamentMatch(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentMatchCriteria(operator, values));
    }

    public MatchGoalRequest<T> withTournamentMatchIsUnknown(){
       return withTournamentMatch(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withTournamentMatchIsKnown(){
       return withTournamentMatch(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentMatchCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.TOURNAMENT_MATCH_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> filterByTournamentMatch(Long tournamentMatch){
      if(tournamentMatch == null){
         return this;
      }
      return withTournamentMatch(Operator.EQUAL, tournamentMatch);
    }
    public MatchGoalRequest<T> withTournamentMatchMatching(TournamentMatchRequest tournamentMatch){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchGoal.TOURNAMENT_MATCH_PROPERTY, tournamentMatch, TournamentMatch.ID_PROPERTY));
    }

    public MatchGoalRequest<T> filterByTournamentTeam(TournamentTeam... tournamentTeam){
      if (tournamentTeam == null || tournamentTeam.length == 0) {
        throw new IllegalArgumentException("filterByTournamentTeam parameter tournamentTeam cannot be empty");
      }
      return appendSearchCriteria(createTournamentTeamCriteria(Operator.EQUAL, (Object[])tournamentTeam));
    }

    public MatchGoalRequest<T> withTournamentTeam(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentTeamCriteria(operator, values));
    }

    public MatchGoalRequest<T> withTournamentTeamIsUnknown(){
       return withTournamentTeam(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withTournamentTeamIsKnown(){
       return withTournamentTeam(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentTeamCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.TOURNAMENT_TEAM_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> filterByTournamentTeam(Long tournamentTeam){
      if(tournamentTeam == null){
         return this;
      }
      return withTournamentTeam(Operator.EQUAL, tournamentTeam);
    }
    public MatchGoalRequest<T> withTournamentTeamMatching(TournamentTeamRequest tournamentTeam){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchGoal.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, TournamentTeam.ID_PROPERTY));
    }

    public MatchGoalRequest<T> filterByGoalCategory(GoalCategory... goalCategory){
      if (goalCategory == null || goalCategory.length == 0) {
        throw new IllegalArgumentException("filterByGoalCategory parameter goalCategory cannot be empty");
      }
      return appendSearchCriteria(createGoalCategoryCriteria(Operator.EQUAL, (Object[])goalCategory));
    }

    public MatchGoalRequest<T> withGoalCategory(Operator operator, Object... values){
       return appendSearchCriteria(createGoalCategoryCriteria(operator, values));
    }

    public MatchGoalRequest<T> withGoalCategoryIsUnknown(){
       return withGoalCategory(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withGoalCategoryIsKnown(){
       return withGoalCategory(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGoalCategoryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.GOAL_CATEGORY_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> filterByGoalCategory(Long goalCategory){
      if(goalCategory == null){
         return this;
      }
      return withGoalCategory(Operator.EQUAL, goalCategory);
    }
    public MatchGoalRequest<T> withGoalCategoryMatching(GoalCategoryRequest goalCategory){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchGoal.GOAL_CATEGORY_PROPERTY, goalCategory, GoalCategory.ID_PROPERTY));
    }

    public MatchGoalRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public MatchGoalRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public MatchGoalRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.TOURNAMENT_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public MatchGoalRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchGoal.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public MatchGoalRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public MatchGoalRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public MatchGoalRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.CREATE_TIME_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public MatchGoalRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchGoalRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public MatchGoalRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public MatchGoalRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public MatchGoalRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.UPDATE_TIME_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public MatchGoalRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchGoalRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public MatchGoalRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MatchGoalRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MatchGoalRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MatchGoalRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchGoal.VERSION_PROPERTY, operator, values);
    }

    public MatchGoalRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MatchGoalRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MatchGoalRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MatchGoalRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MatchGoalRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public MatchGoalRequest<T> count(){
        super.count();
        return this;
    }
    public MatchGoalRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MatchGoalRequest minMinuteScored(){
        return minMinuteScoredAs(prefix("minOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest minMinuteScoredAs(String retName){
        super.min(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest maxMinuteScored(){
        return maxMinuteScoredAs(prefix("maxOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest maxMinuteScoredAs(String retName){
        super.max(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest sumMinuteScored(){
        return sumMinuteScoredAs(prefix("sumOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest sumMinuteScoredAs(String retName){
        super.sum(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest avgMinuteScored(){
        return avgMinuteScoredAs(prefix("avgOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest avgMinuteScoredAs(String retName){
        super.avg(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest standardDeviationMinuteScored(){
        return standardDeviationMinuteScoredAs(prefix("standardDeviationOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest standardDeviationMinuteScoredAs(String retName){
        super.standardDeviation(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest squareRootOfPopulationStandardDeviationMinuteScored(){
        return squareRootOfPopulationStandardDeviationMinuteScoredAs(prefix("squareRootOfPopulationStandardDeviationOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest squareRootOfPopulationStandardDeviationMinuteScoredAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest sampleVarianceMinuteScored(){
        return sampleVarianceMinuteScoredAs(prefix("sampleVarianceOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest sampleVarianceMinuteScoredAs(String retName){
        super.sampleVariance(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest samplePopulationVarianceMinuteScored(){
        return samplePopulationVarianceMinuteScoredAs(prefix("samplePopulationVarianceOf",MatchGoal.MINUTE_SCORED_PROPERTY));
    }

    public MatchGoalRequest samplePopulationVarianceMinuteScoredAs(String retName){
        super.samplePopulationVariance(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
        return this;
    }
    public MatchGoalRequest<T> groupByTournamentMatchWithDetails(){
       return groupByTournamentMatchWithDetails(Q.tournamentMatches().unlimited());
    }

    public MatchGoalRequest<T> groupByTournamentMatchWithDetails(TournamentMatchRequest subRequest){
       aggregate(MatchGoal.TOURNAMENT_MATCH_PROPERTY, subRequest);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentTeamWithDetails(){
       return groupByTournamentTeamWithDetails(Q.tournamentTeams().unlimited());
    }

    public MatchGoalRequest<T> groupByTournamentTeamWithDetails(TournamentTeamRequest subRequest){
       aggregate(MatchGoal.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }

    public MatchGoalRequest<T> groupByGoalCategoryWithDetails(){
       return groupByGoalCategoryWithDetails(Q.goalCategories().unlimited());
    }

    public MatchGoalRequest<T> groupByGoalCategoryWithDetails(GoalCategoryRequest subRequest){
       aggregate(MatchGoal.GOAL_CATEGORY_PROPERTY, subRequest);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public MatchGoalRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(MatchGoal.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }





    public MatchGoalRequest<T> groupById(){
       groupBy(MatchGoal.ID_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByIdAs(String retName){
       groupBy(retName, MatchGoal.ID_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.ID_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> groupByPlayerName(){
       groupBy(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByPlayerNameAs(String retName){
       groupBy(retName, MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByPlayerNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.PLAYER_NAME_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> groupByMinuteScored(){
       groupBy(MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByMinuteScoredAs(String retName){
       groupBy(retName, MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByMinuteScoredWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.MINUTE_SCORED_PROPERTY, function);
       return this;
    }
    public MatchGoalRequest<T> groupByTournamentMatchWith(TournamentMatchRequest subRequest){
       groupBy(MatchGoal.TOURNAMENT_MATCH_PROPERTY, subRequest);
       return this;
    }
    public MatchGoalRequest<T> groupByTournamentMatch(){
       groupBy(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentMatchAs(String retName){
       groupBy(retName, MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentMatchWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.TOURNAMENT_MATCH_PROPERTY, function);
       return this;
    }
    public MatchGoalRequest<T> groupByTournamentTeamWith(TournamentTeamRequest subRequest){
       groupBy(MatchGoal.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }
    public MatchGoalRequest<T> groupByTournamentTeam(){
       groupBy(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentTeamAs(String retName){
       groupBy(retName, MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentTeamWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.TOURNAMENT_TEAM_PROPERTY, function);
       return this;
    }
    public MatchGoalRequest<T> groupByGoalCategoryWith(GoalCategoryRequest subRequest){
       groupBy(MatchGoal.GOAL_CATEGORY_PROPERTY, subRequest);
       return this;
    }
    public MatchGoalRequest<T> groupByGoalCategory(){
       groupBy(MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByGoalCategoryAs(String retName){
       groupBy(retName, MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByGoalCategoryWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.GOAL_CATEGORY_PROPERTY, function);
       return this;
    }
    public MatchGoalRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(MatchGoal.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public MatchGoalRequest<T> groupByTournament(){
       groupBy(MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> groupByCreateTime(){
       groupBy(MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> groupByUpdateTime(){
       groupBy(MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> groupByVersion(){
       groupBy(MatchGoal.VERSION_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MatchGoal.VERSION_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchGoal.VERSION_PROPERTY, function);
       return this;
    }

    public MatchGoalRequest<T> withGoalCategoryIsNormal(){
       filterByGoalCategory(com.example.fifaworldcupservice.Constants.GOAL_CATEGORY_NORMAL);
       return this;
    }


    public MatchGoalRequest<T> withGoalCategoryIsPenalty(){
       filterByGoalCategory(com.example.fifaworldcupservice.Constants.GOAL_CATEGORY_PENALTY);
       return this;
    }


    public MatchGoalRequest<T> withGoalCategoryIsOwnGoal(){
       filterByGoalCategory(com.example.fifaworldcupservice.Constants.GOAL_CATEGORY_OWN_GOAL);
       return this;
    }


    public MatchGoalRequest<T> withGoalCategoryIsFreeKick(){
       filterByGoalCategory(com.example.fifaworldcupservice.Constants.GOAL_CATEGORY_FREE_KICK);
       return this;
    }




    public MatchGoalRequest<T> orderByIdAscending(){
       addOrderByAscending(MatchGoal.ID_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByIdDescending(){
       addOrderByDescending(MatchGoal.ID_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByPlayerNameAscending(){
       addOrderByAscending(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByPlayerNameDescending(){
       addOrderByDescending(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> orderByPlayerNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByPlayerNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchGoal.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchGoalRequest<T> orderByMinuteScoredAscending(){
       addOrderByAscending(MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByMinuteScoredDescending(){
       addOrderByDescending(MatchGoal.MINUTE_SCORED_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentMatchAscending(){
       addOrderByAscending(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentMatchDescending(){
       addOrderByDescending(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentTeamAscending(){
       addOrderByAscending(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentTeamDescending(){
       addOrderByDescending(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByGoalCategoryAscending(){
       addOrderByAscending(MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByGoalCategoryDescending(){
       addOrderByDescending(MatchGoal.GOAL_CATEGORY_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentAscending(){
       addOrderByAscending(MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByTournamentDescending(){
       addOrderByDescending(MatchGoal.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(MatchGoal.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(MatchGoal.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByVersionAscending(){
       addOrderByAscending(MatchGoal.VERSION_PROPERTY);
       return this;
    }

    public MatchGoalRequest<T> orderByVersionDescending(){
       addOrderByDescending(MatchGoal.VERSION_PROPERTY);
       return this;
    }


    public TournamentMatchRequest rollUpToTournamentMatch(){
       TournamentMatchRequest tournamentMatch = Q.tournamentMatches().unlimited();
       this.withTournamentMatchMatching(tournamentMatch)
           .groupByTournamentMatchWith(tournamentMatch);
       return tournamentMatch;
    }

    public TournamentTeamRequest rollUpToTournamentTeam(){
       TournamentTeamRequest tournamentTeam = Q.tournamentTeams().unlimited();
       this.withTournamentTeamMatching(tournamentTeam)
           .groupByTournamentTeamWith(tournamentTeam);
       return tournamentTeam;
    }

    public GoalCategoryRequest rollUpToGoalCategory(){
       GoalCategoryRequest goalCategory = Q.goalCategories().unlimited();
       this.withGoalCategoryMatching(goalCategory)
           .groupByGoalCategoryWith(goalCategory);
       return goalCategory;
    }

    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }





   public MatchGoalRequest<T> facetByTournamentMatchAs(String facetName, TournamentMatchRequest tournamentMatch){
       return facetByTournamentMatchAs(facetName, tournamentMatch, true);
   }

   public MatchGoalRequest<T> facetByTournamentMatchAs(String facetName, TournamentMatchRequest tournamentMatch, boolean includeAllFacets){
       addFacet(facetName, MatchGoal.TOURNAMENT_MATCH_PROPERTY, tournamentMatch, includeAllFacets);
       return this;
   }
   public MatchGoalRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam){
       return facetByTournamentTeamAs(facetName, tournamentTeam, true);
   }

   public MatchGoalRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam, boolean includeAllFacets){
       addFacet(facetName, MatchGoal.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, includeAllFacets);
       return this;
   }
   public MatchGoalRequest<T> facetByGoalCategoryAs(String facetName, GoalCategoryRequest goalCategory){
       return facetByGoalCategoryAs(facetName, goalCategory, true);
   }

   public MatchGoalRequest<T> facetByGoalCategoryAs(String facetName, GoalCategoryRequest goalCategory, boolean includeAllFacets){
       addFacet(facetName, MatchGoal.GOAL_CATEGORY_PROPERTY, goalCategory, includeAllFacets);
       return this;
   }
   public MatchGoalRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public MatchGoalRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, MatchGoal.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MatchGoalRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MatchGoalRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MatchGoalRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MatchGoalRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MatchGoalRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}