package com.example.fifaworldcupservice.tournamentmatch;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardRequest;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalRequest;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupRequest;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstage.MatchStageRequest;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.matchstatus.MatchStatusRequest;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TournamentMatchRequest<T extends TournamentMatch> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TournamentMatchRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TournamentMatchRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TournamentMatchRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TournamentMatchRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TournamentMatchRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TournamentMatchRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TournamentMatchRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TournamentMatchRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TournamentMatchRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TournamentMatchRequest<T> matchingAnyOf(TournamentMatchRequest tournamentMatch){
        super.internalMatchAny(tournamentMatch);
        return this;
    }

    public TournamentMatchRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TournamentMatchRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TournamentMatchRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TournamentMatchRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectMatchNumber().selectMatchDate().selectVenueName().selectVenueCity().selectVenueCountry().selectHomeScore().selectAwayScore().selectExtraTimeHome().selectExtraTimeAway().selectPenaltyHome().selectPenaltyAway().selectHomeTeamIdOnly().selectAwayTeamIdOnly().selectMatchStageIdOnly().selectMatchGroupIdOnly().selectMatchStatusIdOnly().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentMatchRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TournamentMatchRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectMatchNumber().selectMatchDate().selectVenueName().selectVenueCity().selectVenueCountry().selectHomeScore().selectAwayScore().selectExtraTimeHome().selectExtraTimeAway().selectPenaltyHome().selectPenaltyAway().selectHomeTeam().selectAwayTeam().selectMatchStage().selectMatchGroup().selectMatchStatus().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentMatchRequest<T> selectChildren(){
        super.selectAny();
        selectMatchGoalList().selectMatchCardList();
        return selectId().selectMatchNumber().selectMatchDate().selectVenueName().selectVenueCity().selectVenueCountry().selectHomeScore().selectAwayScore().selectExtraTimeHome().selectExtraTimeAway().selectPenaltyHome().selectPenaltyAway().selectHomeTeam().selectAwayTeam().selectMatchStage().selectMatchGroup().selectMatchStatus().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TournamentMatchRequest<T> selectId(){
       selectProperty(TournamentMatch.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectId(){
       unselectProperty(TournamentMatch.ID_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchNumber(){
       selectProperty(TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }

    /**
     * fill the matchNumber with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  matchNumber) to fetch matchNumber property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the matchNumber with customized aggrFunction, TEAQL uses ({aggrFunction}(matchNumber) AS matchNumber to fetch matchNumber property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectMatchNumber(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.MATCH_NUMBER_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectMatchNumber(){
       unselectProperty(TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchDate(){
       selectProperty(TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the matchDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  matchDate) to fetch matchDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectMatchDate(){
       unselectProperty(TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectVenueName(){
       selectProperty(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the venueName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  venueName) to fetch venueName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectVenueName(){
       unselectProperty(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectVenueCity(){
       selectProperty(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }

    /**
     * fill the venueCity with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  venueCity) to fetch venueCity property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectVenueCity(){
       unselectProperty(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectVenueCountry(){
       selectProperty(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }

    /**
     * fill the venueCountry with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  venueCountry) to fetch venueCountry property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectVenueCountry(){
       unselectProperty(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectHomeScore(){
       selectProperty(TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }

    /**
     * fill the homeScore with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  homeScore) to fetch homeScore property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the homeScore with customized aggrFunction, TEAQL uses ({aggrFunction}(homeScore) AS homeScore to fetch homeScore property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectHomeScore(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.HOME_SCORE_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectHomeScore(){
       unselectProperty(TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectAwayScore(){
       selectProperty(TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }

    /**
     * fill the awayScore with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  awayScore) to fetch awayScore property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the awayScore with customized aggrFunction, TEAQL uses ({aggrFunction}(awayScore) AS awayScore to fetch awayScore property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectAwayScore(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.AWAY_SCORE_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectAwayScore(){
       unselectProperty(TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectExtraTimeHome(){
       selectProperty(TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }

    /**
     * fill the extraTimeHome with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  extraTimeHome) to fetch extraTimeHome property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the extraTimeHome with customized aggrFunction, TEAQL uses ({aggrFunction}(extraTimeHome) AS extraTimeHome to fetch extraTimeHome property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectExtraTimeHome(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.EXTRA_TIME_HOME_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectExtraTimeHome(){
       unselectProperty(TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectExtraTimeAway(){
       selectProperty(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }

    /**
     * fill the extraTimeAway with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  extraTimeAway) to fetch extraTimeAway property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the extraTimeAway with customized aggrFunction, TEAQL uses ({aggrFunction}(extraTimeAway) AS extraTimeAway to fetch extraTimeAway property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectExtraTimeAway(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectExtraTimeAway(){
       unselectProperty(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectPenaltyHome(){
       selectProperty(TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }

    /**
     * fill the penaltyHome with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  penaltyHome) to fetch penaltyHome property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the penaltyHome with customized aggrFunction, TEAQL uses ({aggrFunction}(penaltyHome) AS penaltyHome to fetch penaltyHome property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectPenaltyHome(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.PENALTY_HOME_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectPenaltyHome(){
       unselectProperty(TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectPenaltyAway(){
       selectProperty(TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }

    /**
     * fill the penaltyAway with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  penaltyAway) to fetch penaltyAway property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the penaltyAway with customized aggrFunction, TEAQL uses ({aggrFunction}(penaltyAway) AS penaltyAway to fetch penaltyAway property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentMatchRequest<T> selectPenaltyAway(AggrFunction aggrFunction){
       selectProperty(TournamentMatch.PENALTY_AWAY_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentMatchRequest<T> unselectPenaltyAway(){
       unselectProperty(TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectHomeTeamIdOnly(){
       selectProperty(TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectHomeTeam(){
        return selectHomeTeamWith(Q.tournamentTeams().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectHomeTeamWith(TournamentTeamRequest homeTeam){
       selectProperty(TournamentMatch.HOME_TEAM_PROPERTY);
       enhanceRelation(TournamentMatch.HOME_TEAM_PROPERTY, homeTeam);
       return this;
    }

    public TournamentMatchRequest<T> unselectHomeTeam(){
       unselectProperty(TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectAwayTeamIdOnly(){
       selectProperty(TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectAwayTeam(){
        return selectAwayTeamWith(Q.tournamentTeams().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectAwayTeamWith(TournamentTeamRequest awayTeam){
       selectProperty(TournamentMatch.AWAY_TEAM_PROPERTY);
       enhanceRelation(TournamentMatch.AWAY_TEAM_PROPERTY, awayTeam);
       return this;
    }

    public TournamentMatchRequest<T> unselectAwayTeam(){
       unselectProperty(TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchStageIdOnly(){
       selectProperty(TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectMatchStage(){
        return selectMatchStageWith(Q.matchStages().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectMatchStageWith(MatchStageRequest matchStage){
       selectProperty(TournamentMatch.MATCH_STAGE_PROPERTY);
       enhanceRelation(TournamentMatch.MATCH_STAGE_PROPERTY, matchStage);
       return this;
    }

    public TournamentMatchRequest<T> unselectMatchStage(){
       unselectProperty(TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchGroupIdOnly(){
       selectProperty(TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectMatchGroup(){
        return selectMatchGroupWith(Q.matchGroups().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectMatchGroupWith(MatchGroupRequest matchGroup){
       selectProperty(TournamentMatch.MATCH_GROUP_PROPERTY);
       enhanceRelation(TournamentMatch.MATCH_GROUP_PROPERTY, matchGroup);
       return this;
    }

    public TournamentMatchRequest<T> unselectMatchGroup(){
       unselectProperty(TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchStatusIdOnly(){
       selectProperty(TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectMatchStatus(){
        return selectMatchStatusWith(Q.matchStatuses().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectMatchStatusWith(MatchStatusRequest matchStatus){
       selectProperty(TournamentMatch.MATCH_STATUS_PROPERTY);
       enhanceRelation(TournamentMatch.MATCH_STATUS_PROPERTY, matchStatus);
       return this;
    }

    public TournamentMatchRequest<T> unselectMatchStatus(){
       unselectProperty(TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectTournamentIdOnly(){
       selectProperty(TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public TournamentMatchRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(TournamentMatch.TOURNAMENT_PROPERTY);
       enhanceRelation(TournamentMatch.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public TournamentMatchRequest<T> unselectTournament(){
       unselectProperty(TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectCreateTime(){
       selectProperty(TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectCreateTime(){
       unselectProperty(TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectUpdateTime(){
       selectProperty(TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectUpdateTime(){
       unselectProperty(TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectVersion(){
       selectProperty(TournamentMatch.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentMatchRequest<T> unselectVersion(){
       unselectProperty(TournamentMatch.VERSION_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchGoalList(){
       return selectMatchGoalListWith(Q.matchGoals().selectSelf());
    }

    public TournamentMatchRequest<T> selectMatchGoalListWith(MatchGoalRequest matchGoalList){
       enhanceRelation(TournamentMatch.MATCH_GOAL_LIST_PROPERTY, matchGoalList);
       return this;
    }
    public TournamentMatchRequest<T> selectMatchCardList(){
       return selectMatchCardListWith(Q.matchCards().selectSelf());
    }

    public TournamentMatchRequest<T> selectMatchCardListWith(MatchCardRequest matchCardList){
       enhanceRelation(TournamentMatch.MATCH_CARD_LIST_PROPERTY, matchCardList);
       return this;
    }

    public TournamentMatchRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.ID_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TournamentMatchRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TournamentMatchRequest<T> filterByMatchNumber(Integer... matchNumber){
      if (matchNumber == null || matchNumber.length == 0) {
        throw new IllegalArgumentException("filterByMatchNumber parameter matchNumber cannot be empty");
      }
      return appendSearchCriteria(createMatchNumberCriteria(Operator.EQUAL, (Object[])matchNumber));
    }

    public TournamentMatchRequest<T> withMatchNumber(Operator operator, Object... values){
       return appendSearchCriteria(createMatchNumberCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withMatchNumberIsUnknown(){
       return withMatchNumber(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withMatchNumberIsKnown(){
       return withMatchNumber(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchNumberCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.MATCH_NUMBER_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withMatchNumberGreaterThan(Integer matchNumber){
       return withMatchNumber(Operator.GREATER_THAN, matchNumber);
    }

    public TournamentMatchRequest<T> withMatchNumberGreaterThanOrEqualTo(Integer matchNumber){
       return withMatchNumber(Operator.GREATER_THAN_OR_EQUAL, matchNumber);
    }

    public TournamentMatchRequest<T> withMatchNumberLessThan(Integer matchNumber){
       return withMatchNumber(Operator.LESS_THAN, matchNumber);
    }

    public TournamentMatchRequest<T> withMatchNumberLessThanOrEqualTo(Integer matchNumber){
       return withMatchNumber(Operator.LESS_THAN_OR_EQUAL, matchNumber);
    }

    public TournamentMatchRequest<T> withMatchNumberBetween(Integer startOfMatchNumber, Integer endOfMatchNumber){
       return withMatchNumber(Operator.BETWEEN, startOfMatchNumber, endOfMatchNumber);
    }



    public TournamentMatchRequest<T> filterByMatchDate(LocalDate... matchDate){
      if (matchDate == null || matchDate.length == 0) {
        throw new IllegalArgumentException("filterByMatchDate parameter matchDate cannot be empty");
      }
      return appendSearchCriteria(createMatchDateCriteria(Operator.EQUAL, (Object[])matchDate));
    }

    public TournamentMatchRequest<T> withMatchDate(Operator operator, Object... values){
       return appendSearchCriteria(createMatchDateCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withMatchDateIsUnknown(){
       return withMatchDate(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withMatchDateIsKnown(){
       return withMatchDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.MATCH_DATE_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withMatchDateGreaterThan(LocalDate matchDate){
       return withMatchDate(Operator.GREATER_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateGreaterThanOrEqualTo(LocalDate matchDate){
       return withMatchDate(Operator.GREATER_THAN_OR_EQUAL, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateLessThan(LocalDate matchDate){
       return withMatchDate(Operator.LESS_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateLessThanOrEqualTo(LocalDate matchDate){
       return withMatchDate(Operator.LESS_THAN_OR_EQUAL, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateBetween(LocalDate startOfMatchDate, LocalDate endOfMatchDate){
       return withMatchDate(Operator.BETWEEN, startOfMatchDate, endOfMatchDate);
    }
    public TournamentMatchRequest<T> withMatchDateBefore(LocalDate matchDate){
       return withMatchDate(Operator.LESS_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateBefore(Date matchDate){
       return withMatchDate(Operator.LESS_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateAfter(LocalDate matchDate){
       return withMatchDate(Operator.GREATER_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateAfter(Date matchDate){
       return withMatchDate(Operator.GREATER_THAN, matchDate);
    }

    public TournamentMatchRequest<T> withMatchDateBetween(Date startOfMatchDate, Date endOfMatchDate){
       return withMatchDate(Operator.BETWEEN, startOfMatchDate, endOfMatchDate);
    }




    public TournamentMatchRequest<T> filterByVenueName(String... venueName){
      if (venueName == null || venueName.length == 0) {
        throw new IllegalArgumentException("filterByVenueName parameter venueName cannot be empty");
      }
      return appendSearchCriteria(createVenueNameCriteria(Operator.EQUAL, (Object[])venueName));
    }

    public TournamentMatchRequest<T> withVenueName(Operator operator, Object... values){
       return appendSearchCriteria(createVenueNameCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withVenueNameIsUnknown(){
       return withVenueName(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withVenueNameIsKnown(){
       return withVenueName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVenueNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.VENUE_NAME_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withVenueNameGreaterThan(String venueName){
       return withVenueName(Operator.GREATER_THAN, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameGreaterThanOrEqualTo(String venueName){
       return withVenueName(Operator.GREATER_THAN_OR_EQUAL, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameLessThan(String venueName){
       return withVenueName(Operator.LESS_THAN, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameLessThanOrEqualTo(String venueName){
       return withVenueName(Operator.LESS_THAN_OR_EQUAL, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameBetween(String startOfVenueName, String endOfVenueName){
       return withVenueName(Operator.BETWEEN, startOfVenueName, endOfVenueName);
    }
    public TournamentMatchRequest<T> withVenueNameStartingWith(String venueName){
       return withVenueName(Operator.BEGIN_WITH, venueName);
    }
    public TournamentMatchRequest<T> withVenueNameContaining(String venueName){
       return withVenueName(Operator.CONTAIN, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameEndingWith(String venueName){
       return withVenueName(Operator.END_WITH, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameIs(String venueName){
       return withVenueName(Operator.EQUAL, venueName);
    }

    public TournamentMatchRequest<T> withVenueNameSoundingLike(String venueName){
       return withVenueName(Operator.SOUNDS_LIKE, venueName);
    }



    public TournamentMatchRequest<T> filterByVenueCity(String... venueCity){
      if (venueCity == null || venueCity.length == 0) {
        throw new IllegalArgumentException("filterByVenueCity parameter venueCity cannot be empty");
      }
      return appendSearchCriteria(createVenueCityCriteria(Operator.EQUAL, (Object[])venueCity));
    }

    public TournamentMatchRequest<T> withVenueCity(Operator operator, Object... values){
       return appendSearchCriteria(createVenueCityCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withVenueCityIsUnknown(){
       return withVenueCity(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withVenueCityIsKnown(){
       return withVenueCity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVenueCityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.VENUE_CITY_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withVenueCityGreaterThan(String venueCity){
       return withVenueCity(Operator.GREATER_THAN, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityGreaterThanOrEqualTo(String venueCity){
       return withVenueCity(Operator.GREATER_THAN_OR_EQUAL, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityLessThan(String venueCity){
       return withVenueCity(Operator.LESS_THAN, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityLessThanOrEqualTo(String venueCity){
       return withVenueCity(Operator.LESS_THAN_OR_EQUAL, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityBetween(String startOfVenueCity, String endOfVenueCity){
       return withVenueCity(Operator.BETWEEN, startOfVenueCity, endOfVenueCity);
    }
    public TournamentMatchRequest<T> withVenueCityStartingWith(String venueCity){
       return withVenueCity(Operator.BEGIN_WITH, venueCity);
    }
    public TournamentMatchRequest<T> withVenueCityContaining(String venueCity){
       return withVenueCity(Operator.CONTAIN, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityEndingWith(String venueCity){
       return withVenueCity(Operator.END_WITH, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCityIs(String venueCity){
       return withVenueCity(Operator.EQUAL, venueCity);
    }

    public TournamentMatchRequest<T> withVenueCitySoundingLike(String venueCity){
       return withVenueCity(Operator.SOUNDS_LIKE, venueCity);
    }



    public TournamentMatchRequest<T> filterByVenueCountry(String... venueCountry){
      if (venueCountry == null || venueCountry.length == 0) {
        throw new IllegalArgumentException("filterByVenueCountry parameter venueCountry cannot be empty");
      }
      return appendSearchCriteria(createVenueCountryCriteria(Operator.EQUAL, (Object[])venueCountry));
    }

    public TournamentMatchRequest<T> withVenueCountry(Operator operator, Object... values){
       return appendSearchCriteria(createVenueCountryCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withVenueCountryIsUnknown(){
       return withVenueCountry(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withVenueCountryIsKnown(){
       return withVenueCountry(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVenueCountryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.VENUE_COUNTRY_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withVenueCountryGreaterThan(String venueCountry){
       return withVenueCountry(Operator.GREATER_THAN, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryGreaterThanOrEqualTo(String venueCountry){
       return withVenueCountry(Operator.GREATER_THAN_OR_EQUAL, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryLessThan(String venueCountry){
       return withVenueCountry(Operator.LESS_THAN, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryLessThanOrEqualTo(String venueCountry){
       return withVenueCountry(Operator.LESS_THAN_OR_EQUAL, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryBetween(String startOfVenueCountry, String endOfVenueCountry){
       return withVenueCountry(Operator.BETWEEN, startOfVenueCountry, endOfVenueCountry);
    }
    public TournamentMatchRequest<T> withVenueCountryStartingWith(String venueCountry){
       return withVenueCountry(Operator.BEGIN_WITH, venueCountry);
    }
    public TournamentMatchRequest<T> withVenueCountryContaining(String venueCountry){
       return withVenueCountry(Operator.CONTAIN, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryEndingWith(String venueCountry){
       return withVenueCountry(Operator.END_WITH, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountryIs(String venueCountry){
       return withVenueCountry(Operator.EQUAL, venueCountry);
    }

    public TournamentMatchRequest<T> withVenueCountrySoundingLike(String venueCountry){
       return withVenueCountry(Operator.SOUNDS_LIKE, venueCountry);
    }



    public TournamentMatchRequest<T> filterByHomeScore(Integer... homeScore){
      if (homeScore == null || homeScore.length == 0) {
        throw new IllegalArgumentException("filterByHomeScore parameter homeScore cannot be empty");
      }
      return appendSearchCriteria(createHomeScoreCriteria(Operator.EQUAL, (Object[])homeScore));
    }

    public TournamentMatchRequest<T> withHomeScore(Operator operator, Object... values){
       return appendSearchCriteria(createHomeScoreCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withHomeScoreIsUnknown(){
       return withHomeScore(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withHomeScoreIsKnown(){
       return withHomeScore(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createHomeScoreCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.HOME_SCORE_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withHomeScoreGreaterThan(Integer homeScore){
       return withHomeScore(Operator.GREATER_THAN, homeScore);
    }

    public TournamentMatchRequest<T> withHomeScoreGreaterThanOrEqualTo(Integer homeScore){
       return withHomeScore(Operator.GREATER_THAN_OR_EQUAL, homeScore);
    }

    public TournamentMatchRequest<T> withHomeScoreLessThan(Integer homeScore){
       return withHomeScore(Operator.LESS_THAN, homeScore);
    }

    public TournamentMatchRequest<T> withHomeScoreLessThanOrEqualTo(Integer homeScore){
       return withHomeScore(Operator.LESS_THAN_OR_EQUAL, homeScore);
    }

    public TournamentMatchRequest<T> withHomeScoreBetween(Integer startOfHomeScore, Integer endOfHomeScore){
       return withHomeScore(Operator.BETWEEN, startOfHomeScore, endOfHomeScore);
    }



    public TournamentMatchRequest<T> filterByAwayScore(Integer... awayScore){
      if (awayScore == null || awayScore.length == 0) {
        throw new IllegalArgumentException("filterByAwayScore parameter awayScore cannot be empty");
      }
      return appendSearchCriteria(createAwayScoreCriteria(Operator.EQUAL, (Object[])awayScore));
    }

    public TournamentMatchRequest<T> withAwayScore(Operator operator, Object... values){
       return appendSearchCriteria(createAwayScoreCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withAwayScoreIsUnknown(){
       return withAwayScore(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withAwayScoreIsKnown(){
       return withAwayScore(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAwayScoreCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.AWAY_SCORE_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withAwayScoreGreaterThan(Integer awayScore){
       return withAwayScore(Operator.GREATER_THAN, awayScore);
    }

    public TournamentMatchRequest<T> withAwayScoreGreaterThanOrEqualTo(Integer awayScore){
       return withAwayScore(Operator.GREATER_THAN_OR_EQUAL, awayScore);
    }

    public TournamentMatchRequest<T> withAwayScoreLessThan(Integer awayScore){
       return withAwayScore(Operator.LESS_THAN, awayScore);
    }

    public TournamentMatchRequest<T> withAwayScoreLessThanOrEqualTo(Integer awayScore){
       return withAwayScore(Operator.LESS_THAN_OR_EQUAL, awayScore);
    }

    public TournamentMatchRequest<T> withAwayScoreBetween(Integer startOfAwayScore, Integer endOfAwayScore){
       return withAwayScore(Operator.BETWEEN, startOfAwayScore, endOfAwayScore);
    }



    public TournamentMatchRequest<T> filterByExtraTimeHome(Integer... extraTimeHome){
      if (extraTimeHome == null || extraTimeHome.length == 0) {
        throw new IllegalArgumentException("filterByExtraTimeHome parameter extraTimeHome cannot be empty");
      }
      return appendSearchCriteria(createExtraTimeHomeCriteria(Operator.EQUAL, (Object[])extraTimeHome));
    }

    public TournamentMatchRequest<T> withExtraTimeHome(Operator operator, Object... values){
       return appendSearchCriteria(createExtraTimeHomeCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withExtraTimeHomeIsUnknown(){
       return withExtraTimeHome(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeIsKnown(){
       return withExtraTimeHome(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createExtraTimeHomeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.EXTRA_TIME_HOME_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeGreaterThan(Integer extraTimeHome){
       return withExtraTimeHome(Operator.GREATER_THAN, extraTimeHome);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeGreaterThanOrEqualTo(Integer extraTimeHome){
       return withExtraTimeHome(Operator.GREATER_THAN_OR_EQUAL, extraTimeHome);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeLessThan(Integer extraTimeHome){
       return withExtraTimeHome(Operator.LESS_THAN, extraTimeHome);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeLessThanOrEqualTo(Integer extraTimeHome){
       return withExtraTimeHome(Operator.LESS_THAN_OR_EQUAL, extraTimeHome);
    }

    public TournamentMatchRequest<T> withExtraTimeHomeBetween(Integer startOfExtraTimeHome, Integer endOfExtraTimeHome){
       return withExtraTimeHome(Operator.BETWEEN, startOfExtraTimeHome, endOfExtraTimeHome);
    }



    public TournamentMatchRequest<T> filterByExtraTimeAway(Integer... extraTimeAway){
      if (extraTimeAway == null || extraTimeAway.length == 0) {
        throw new IllegalArgumentException("filterByExtraTimeAway parameter extraTimeAway cannot be empty");
      }
      return appendSearchCriteria(createExtraTimeAwayCriteria(Operator.EQUAL, (Object[])extraTimeAway));
    }

    public TournamentMatchRequest<T> withExtraTimeAway(Operator operator, Object... values){
       return appendSearchCriteria(createExtraTimeAwayCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withExtraTimeAwayIsUnknown(){
       return withExtraTimeAway(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayIsKnown(){
       return withExtraTimeAway(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createExtraTimeAwayCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayGreaterThan(Integer extraTimeAway){
       return withExtraTimeAway(Operator.GREATER_THAN, extraTimeAway);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayGreaterThanOrEqualTo(Integer extraTimeAway){
       return withExtraTimeAway(Operator.GREATER_THAN_OR_EQUAL, extraTimeAway);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayLessThan(Integer extraTimeAway){
       return withExtraTimeAway(Operator.LESS_THAN, extraTimeAway);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayLessThanOrEqualTo(Integer extraTimeAway){
       return withExtraTimeAway(Operator.LESS_THAN_OR_EQUAL, extraTimeAway);
    }

    public TournamentMatchRequest<T> withExtraTimeAwayBetween(Integer startOfExtraTimeAway, Integer endOfExtraTimeAway){
       return withExtraTimeAway(Operator.BETWEEN, startOfExtraTimeAway, endOfExtraTimeAway);
    }



    public TournamentMatchRequest<T> filterByPenaltyHome(Integer... penaltyHome){
      if (penaltyHome == null || penaltyHome.length == 0) {
        throw new IllegalArgumentException("filterByPenaltyHome parameter penaltyHome cannot be empty");
      }
      return appendSearchCriteria(createPenaltyHomeCriteria(Operator.EQUAL, (Object[])penaltyHome));
    }

    public TournamentMatchRequest<T> withPenaltyHome(Operator operator, Object... values){
       return appendSearchCriteria(createPenaltyHomeCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withPenaltyHomeIsUnknown(){
       return withPenaltyHome(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withPenaltyHomeIsKnown(){
       return withPenaltyHome(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPenaltyHomeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.PENALTY_HOME_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withPenaltyHomeGreaterThan(Integer penaltyHome){
       return withPenaltyHome(Operator.GREATER_THAN, penaltyHome);
    }

    public TournamentMatchRequest<T> withPenaltyHomeGreaterThanOrEqualTo(Integer penaltyHome){
       return withPenaltyHome(Operator.GREATER_THAN_OR_EQUAL, penaltyHome);
    }

    public TournamentMatchRequest<T> withPenaltyHomeLessThan(Integer penaltyHome){
       return withPenaltyHome(Operator.LESS_THAN, penaltyHome);
    }

    public TournamentMatchRequest<T> withPenaltyHomeLessThanOrEqualTo(Integer penaltyHome){
       return withPenaltyHome(Operator.LESS_THAN_OR_EQUAL, penaltyHome);
    }

    public TournamentMatchRequest<T> withPenaltyHomeBetween(Integer startOfPenaltyHome, Integer endOfPenaltyHome){
       return withPenaltyHome(Operator.BETWEEN, startOfPenaltyHome, endOfPenaltyHome);
    }



    public TournamentMatchRequest<T> filterByPenaltyAway(Integer... penaltyAway){
      if (penaltyAway == null || penaltyAway.length == 0) {
        throw new IllegalArgumentException("filterByPenaltyAway parameter penaltyAway cannot be empty");
      }
      return appendSearchCriteria(createPenaltyAwayCriteria(Operator.EQUAL, (Object[])penaltyAway));
    }

    public TournamentMatchRequest<T> withPenaltyAway(Operator operator, Object... values){
       return appendSearchCriteria(createPenaltyAwayCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withPenaltyAwayIsUnknown(){
       return withPenaltyAway(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withPenaltyAwayIsKnown(){
       return withPenaltyAway(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPenaltyAwayCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.PENALTY_AWAY_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withPenaltyAwayGreaterThan(Integer penaltyAway){
       return withPenaltyAway(Operator.GREATER_THAN, penaltyAway);
    }

    public TournamentMatchRequest<T> withPenaltyAwayGreaterThanOrEqualTo(Integer penaltyAway){
       return withPenaltyAway(Operator.GREATER_THAN_OR_EQUAL, penaltyAway);
    }

    public TournamentMatchRequest<T> withPenaltyAwayLessThan(Integer penaltyAway){
       return withPenaltyAway(Operator.LESS_THAN, penaltyAway);
    }

    public TournamentMatchRequest<T> withPenaltyAwayLessThanOrEqualTo(Integer penaltyAway){
       return withPenaltyAway(Operator.LESS_THAN_OR_EQUAL, penaltyAway);
    }

    public TournamentMatchRequest<T> withPenaltyAwayBetween(Integer startOfPenaltyAway, Integer endOfPenaltyAway){
       return withPenaltyAway(Operator.BETWEEN, startOfPenaltyAway, endOfPenaltyAway);
    }



    public TournamentMatchRequest<T> filterByHomeTeam(TournamentTeam... homeTeam){
      if (homeTeam == null || homeTeam.length == 0) {
        throw new IllegalArgumentException("filterByHomeTeam parameter homeTeam cannot be empty");
      }
      return appendSearchCriteria(createHomeTeamCriteria(Operator.EQUAL, (Object[])homeTeam));
    }

    public TournamentMatchRequest<T> withHomeTeam(Operator operator, Object... values){
       return appendSearchCriteria(createHomeTeamCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withHomeTeamIsUnknown(){
       return withHomeTeam(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withHomeTeamIsKnown(){
       return withHomeTeam(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createHomeTeamCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.HOME_TEAM_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByHomeTeam(Long homeTeam){
      if(homeTeam == null){
         return this;
      }
      return withHomeTeam(Operator.EQUAL, homeTeam);
    }
    public TournamentMatchRequest<T> withHomeTeamMatching(TournamentTeamRequest homeTeam){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.HOME_TEAM_PROPERTY, homeTeam, TournamentTeam.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByAwayTeam(TournamentTeam... awayTeam){
      if (awayTeam == null || awayTeam.length == 0) {
        throw new IllegalArgumentException("filterByAwayTeam parameter awayTeam cannot be empty");
      }
      return appendSearchCriteria(createAwayTeamCriteria(Operator.EQUAL, (Object[])awayTeam));
    }

    public TournamentMatchRequest<T> withAwayTeam(Operator operator, Object... values){
       return appendSearchCriteria(createAwayTeamCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withAwayTeamIsUnknown(){
       return withAwayTeam(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withAwayTeamIsKnown(){
       return withAwayTeam(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAwayTeamCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.AWAY_TEAM_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByAwayTeam(Long awayTeam){
      if(awayTeam == null){
         return this;
      }
      return withAwayTeam(Operator.EQUAL, awayTeam);
    }
    public TournamentMatchRequest<T> withAwayTeamMatching(TournamentTeamRequest awayTeam){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.AWAY_TEAM_PROPERTY, awayTeam, TournamentTeam.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByMatchStage(MatchStage... matchStage){
      if (matchStage == null || matchStage.length == 0) {
        throw new IllegalArgumentException("filterByMatchStage parameter matchStage cannot be empty");
      }
      return appendSearchCriteria(createMatchStageCriteria(Operator.EQUAL, (Object[])matchStage));
    }

    public TournamentMatchRequest<T> withMatchStage(Operator operator, Object... values){
       return appendSearchCriteria(createMatchStageCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withMatchStageIsUnknown(){
       return withMatchStage(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withMatchStageIsKnown(){
       return withMatchStage(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchStageCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.MATCH_STAGE_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByMatchStage(Long matchStage){
      if(matchStage == null){
         return this;
      }
      return withMatchStage(Operator.EQUAL, matchStage);
    }
    public TournamentMatchRequest<T> withMatchStageMatching(MatchStageRequest matchStage){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.MATCH_STAGE_PROPERTY, matchStage, MatchStage.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByMatchGroup(MatchGroup... matchGroup){
      if (matchGroup == null || matchGroup.length == 0) {
        throw new IllegalArgumentException("filterByMatchGroup parameter matchGroup cannot be empty");
      }
      return appendSearchCriteria(createMatchGroupCriteria(Operator.EQUAL, (Object[])matchGroup));
    }

    public TournamentMatchRequest<T> withMatchGroup(Operator operator, Object... values){
       return appendSearchCriteria(createMatchGroupCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withMatchGroupIsUnknown(){
       return withMatchGroup(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withMatchGroupIsKnown(){
       return withMatchGroup(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchGroupCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.MATCH_GROUP_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByMatchGroup(Long matchGroup){
      if(matchGroup == null){
         return this;
      }
      return withMatchGroup(Operator.EQUAL, matchGroup);
    }
    public TournamentMatchRequest<T> withMatchGroupMatching(MatchGroupRequest matchGroup){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.MATCH_GROUP_PROPERTY, matchGroup, MatchGroup.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByMatchStatus(MatchStatus... matchStatus){
      if (matchStatus == null || matchStatus.length == 0) {
        throw new IllegalArgumentException("filterByMatchStatus parameter matchStatus cannot be empty");
      }
      return appendSearchCriteria(createMatchStatusCriteria(Operator.EQUAL, (Object[])matchStatus));
    }

    public TournamentMatchRequest<T> withMatchStatus(Operator operator, Object... values){
       return appendSearchCriteria(createMatchStatusCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withMatchStatusIsUnknown(){
       return withMatchStatus(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withMatchStatusIsKnown(){
       return withMatchStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMatchStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.MATCH_STATUS_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByMatchStatus(Long matchStatus){
      if(matchStatus == null){
         return this;
      }
      return withMatchStatus(Operator.EQUAL, matchStatus);
    }
    public TournamentMatchRequest<T> withMatchStatusMatching(MatchStatusRequest matchStatus){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.MATCH_STATUS_PROPERTY, matchStatus, MatchStatus.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public TournamentMatchRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.TOURNAMENT_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public TournamentMatchRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public TournamentMatchRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TournamentMatchRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.CREATE_TIME_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TournamentMatchRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentMatchRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TournamentMatchRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TournamentMatchRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TournamentMatchRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentMatchRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TournamentMatchRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TournamentMatchRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TournamentMatchRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TournamentMatchRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentMatch.VERSION_PROPERTY, operator, values);
    }

    public TournamentMatchRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TournamentMatchRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TournamentMatchRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TournamentMatchRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TournamentMatchRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TournamentMatchRequest<T> withMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_MATCH_PROPERTY));
    }

    public TournamentMatchRequest<T> withoutMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentMatch.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_MATCH_PROPERTY)));
    }

    public TournamentMatchRequest<T> haveMatchGoals(){
        return withMatchGoalListMatching(Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> haveNoMatchGoals(){
        return withoutMatchGoalListMatching(Q.matchGoals().unlimited());
    }
    public TournamentMatchRequest<T> withMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentMatch.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_MATCH_PROPERTY));
    }

    public TournamentMatchRequest<T> withoutMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentMatch.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_MATCH_PROPERTY)));
    }

    public TournamentMatchRequest<T> haveMatchCards(){
        return withMatchCardListMatching(Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> haveNoMatchCards(){
        return withoutMatchCardListMatching(Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> count(){
        super.count();
        return this;
    }
    public TournamentMatchRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TournamentMatchRequest minMatchNumber(){
        return minMatchNumberAs(prefix("minOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest minMatchNumberAs(String retName){
        super.min(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxMatchNumber(){
        return maxMatchNumberAs(prefix("maxOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest maxMatchNumberAs(String retName){
        super.max(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumMatchNumber(){
        return sumMatchNumberAs(prefix("sumOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest sumMatchNumberAs(String retName){
        super.sum(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgMatchNumber(){
        return avgMatchNumberAs(prefix("avgOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest avgMatchNumberAs(String retName){
        super.avg(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationMatchNumber(){
        return standardDeviationMatchNumberAs(prefix("standardDeviationOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationMatchNumberAs(String retName){
        super.standardDeviation(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationMatchNumber(){
        return squareRootOfPopulationStandardDeviationMatchNumberAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationMatchNumberAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVarianceMatchNumber(){
        return sampleVarianceMatchNumberAs(prefix("sampleVarianceOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest sampleVarianceMatchNumberAs(String retName){
        super.sampleVariance(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVarianceMatchNumber(){
        return samplePopulationVarianceMatchNumberAs(prefix("samplePopulationVarianceOf",TournamentMatch.MATCH_NUMBER_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVarianceMatchNumberAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minHomeScore(){
        return minHomeScoreAs(prefix("minOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest minHomeScoreAs(String retName){
        super.min(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxHomeScore(){
        return maxHomeScoreAs(prefix("maxOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest maxHomeScoreAs(String retName){
        super.max(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumHomeScore(){
        return sumHomeScoreAs(prefix("sumOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest sumHomeScoreAs(String retName){
        super.sum(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgHomeScore(){
        return avgHomeScoreAs(prefix("avgOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest avgHomeScoreAs(String retName){
        super.avg(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationHomeScore(){
        return standardDeviationHomeScoreAs(prefix("standardDeviationOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationHomeScoreAs(String retName){
        super.standardDeviation(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationHomeScore(){
        return squareRootOfPopulationStandardDeviationHomeScoreAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationHomeScoreAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVarianceHomeScore(){
        return sampleVarianceHomeScoreAs(prefix("sampleVarianceOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest sampleVarianceHomeScoreAs(String retName){
        super.sampleVariance(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVarianceHomeScore(){
        return samplePopulationVarianceHomeScoreAs(prefix("samplePopulationVarianceOf",TournamentMatch.HOME_SCORE_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVarianceHomeScoreAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.HOME_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minAwayScore(){
        return minAwayScoreAs(prefix("minOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest minAwayScoreAs(String retName){
        super.min(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxAwayScore(){
        return maxAwayScoreAs(prefix("maxOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest maxAwayScoreAs(String retName){
        super.max(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumAwayScore(){
        return sumAwayScoreAs(prefix("sumOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest sumAwayScoreAs(String retName){
        super.sum(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgAwayScore(){
        return avgAwayScoreAs(prefix("avgOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest avgAwayScoreAs(String retName){
        super.avg(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationAwayScore(){
        return standardDeviationAwayScoreAs(prefix("standardDeviationOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationAwayScoreAs(String retName){
        super.standardDeviation(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationAwayScore(){
        return squareRootOfPopulationStandardDeviationAwayScoreAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationAwayScoreAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVarianceAwayScore(){
        return sampleVarianceAwayScoreAs(prefix("sampleVarianceOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest sampleVarianceAwayScoreAs(String retName){
        super.sampleVariance(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVarianceAwayScore(){
        return samplePopulationVarianceAwayScoreAs(prefix("samplePopulationVarianceOf",TournamentMatch.AWAY_SCORE_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVarianceAwayScoreAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minExtraTimeHome(){
        return minExtraTimeHomeAs(prefix("minOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest minExtraTimeHomeAs(String retName){
        super.min(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxExtraTimeHome(){
        return maxExtraTimeHomeAs(prefix("maxOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest maxExtraTimeHomeAs(String retName){
        super.max(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumExtraTimeHome(){
        return sumExtraTimeHomeAs(prefix("sumOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest sumExtraTimeHomeAs(String retName){
        super.sum(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgExtraTimeHome(){
        return avgExtraTimeHomeAs(prefix("avgOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest avgExtraTimeHomeAs(String retName){
        super.avg(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationExtraTimeHome(){
        return standardDeviationExtraTimeHomeAs(prefix("standardDeviationOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationExtraTimeHomeAs(String retName){
        super.standardDeviation(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationExtraTimeHome(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationExtraTimeHomeAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVarianceExtraTimeHome(){
        return sampleVarianceExtraTimeHomeAs(prefix("sampleVarianceOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest sampleVarianceExtraTimeHomeAs(String retName){
        super.sampleVariance(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVarianceExtraTimeHome(){
        return samplePopulationVarianceExtraTimeHomeAs(prefix("samplePopulationVarianceOf",TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVarianceExtraTimeHomeAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minExtraTimeAway(){
        return minExtraTimeAwayAs(prefix("minOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest minExtraTimeAwayAs(String retName){
        super.min(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxExtraTimeAway(){
        return maxExtraTimeAwayAs(prefix("maxOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest maxExtraTimeAwayAs(String retName){
        super.max(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumExtraTimeAway(){
        return sumExtraTimeAwayAs(prefix("sumOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest sumExtraTimeAwayAs(String retName){
        super.sum(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgExtraTimeAway(){
        return avgExtraTimeAwayAs(prefix("avgOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest avgExtraTimeAwayAs(String retName){
        super.avg(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationExtraTimeAway(){
        return standardDeviationExtraTimeAwayAs(prefix("standardDeviationOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationExtraTimeAwayAs(String retName){
        super.standardDeviation(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationExtraTimeAway(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationExtraTimeAwayAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVarianceExtraTimeAway(){
        return sampleVarianceExtraTimeAwayAs(prefix("sampleVarianceOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest sampleVarianceExtraTimeAwayAs(String retName){
        super.sampleVariance(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVarianceExtraTimeAway(){
        return samplePopulationVarianceExtraTimeAwayAs(prefix("samplePopulationVarianceOf",TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVarianceExtraTimeAwayAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minPenaltyHome(){
        return minPenaltyHomeAs(prefix("minOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest minPenaltyHomeAs(String retName){
        super.min(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxPenaltyHome(){
        return maxPenaltyHomeAs(prefix("maxOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest maxPenaltyHomeAs(String retName){
        super.max(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumPenaltyHome(){
        return sumPenaltyHomeAs(prefix("sumOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest sumPenaltyHomeAs(String retName){
        super.sum(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgPenaltyHome(){
        return avgPenaltyHomeAs(prefix("avgOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest avgPenaltyHomeAs(String retName){
        super.avg(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationPenaltyHome(){
        return standardDeviationPenaltyHomeAs(prefix("standardDeviationOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationPenaltyHomeAs(String retName){
        super.standardDeviation(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationPenaltyHome(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationPenaltyHomeAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVariancePenaltyHome(){
        return sampleVariancePenaltyHomeAs(prefix("sampleVarianceOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest sampleVariancePenaltyHomeAs(String retName){
        super.sampleVariance(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVariancePenaltyHome(){
        return samplePopulationVariancePenaltyHomeAs(prefix("samplePopulationVarianceOf",TournamentMatch.PENALTY_HOME_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVariancePenaltyHomeAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
        return this;
    }
    public TournamentMatchRequest minPenaltyAway(){
        return minPenaltyAwayAs(prefix("minOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest minPenaltyAwayAs(String retName){
        super.min(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest maxPenaltyAway(){
        return maxPenaltyAwayAs(prefix("maxOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest maxPenaltyAwayAs(String retName){
        super.max(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sumPenaltyAway(){
        return sumPenaltyAwayAs(prefix("sumOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest sumPenaltyAwayAs(String retName){
        super.sum(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest avgPenaltyAway(){
        return avgPenaltyAwayAs(prefix("avgOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest avgPenaltyAwayAs(String retName){
        super.avg(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest standardDeviationPenaltyAway(){
        return standardDeviationPenaltyAwayAs(prefix("standardDeviationOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest standardDeviationPenaltyAwayAs(String retName){
        super.standardDeviation(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest squareRootOfPopulationStandardDeviationPenaltyAway(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest squareRootOfPopulationStandardDeviationPenaltyAwayAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest sampleVariancePenaltyAway(){
        return sampleVariancePenaltyAwayAs(prefix("sampleVarianceOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest sampleVariancePenaltyAwayAs(String retName){
        super.sampleVariance(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest samplePopulationVariancePenaltyAway(){
        return samplePopulationVariancePenaltyAwayAs(prefix("samplePopulationVarianceOf",TournamentMatch.PENALTY_AWAY_PROPERTY));
    }

    public TournamentMatchRequest samplePopulationVariancePenaltyAwayAs(String retName){
        super.samplePopulationVariance(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
        return this;
    }
    public TournamentMatchRequest<T> groupByHomeTeamWithDetails(){
       return groupByHomeTeamWithDetails(Q.tournamentTeams().unlimited());
    }

    public TournamentMatchRequest<T> groupByHomeTeamWithDetails(TournamentTeamRequest subRequest){
       aggregate(TournamentMatch.HOME_TEAM_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayTeamWithDetails(){
       return groupByAwayTeamWithDetails(Q.tournamentTeams().unlimited());
    }

    public TournamentMatchRequest<T> groupByAwayTeamWithDetails(TournamentTeamRequest subRequest){
       aggregate(TournamentMatch.AWAY_TEAM_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStageWithDetails(){
       return groupByMatchStageWithDetails(Q.matchStages().unlimited());
    }

    public TournamentMatchRequest<T> groupByMatchStageWithDetails(MatchStageRequest subRequest){
       aggregate(TournamentMatch.MATCH_STAGE_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchGroupWithDetails(){
       return groupByMatchGroupWithDetails(Q.matchGroups().unlimited());
    }

    public TournamentMatchRequest<T> groupByMatchGroupWithDetails(MatchGroupRequest subRequest){
       aggregate(TournamentMatch.MATCH_GROUP_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStatusWithDetails(){
       return groupByMatchStatusWithDetails(Q.matchStatuses().unlimited());
    }

    public TournamentMatchRequest<T> groupByMatchStatusWithDetails(MatchStatusRequest subRequest){
       aggregate(TournamentMatch.MATCH_STATUS_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public TournamentMatchRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(TournamentMatch.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }




    public TournamentMatchRequest<T> groupByMatchGoalsWithDetails(MatchGoalRequest subRequest){
       aggregate(TournamentMatch.MATCH_GOAL_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchCardsWithDetails(MatchCardRequest subRequest){
       aggregate(TournamentMatch.MATCH_CARD_LIST_PROPERTY, subRequest);
       return this;
    }

    public TournamentMatchRequest<T> groupById(){
       groupBy(TournamentMatch.ID_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByIdAs(String retName){
       groupBy(retName, TournamentMatch.ID_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.ID_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchNumber(){
       groupBy(TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchNumberAs(String retName){
       groupBy(retName, TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchNumberWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.MATCH_NUMBER_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchDate(){
       groupBy(TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchDateAs(String retName){
       groupBy(retName, TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.MATCH_DATE_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueName(){
       groupBy(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueNameAs(String retName){
       groupBy(retName, TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.VENUE_NAME_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCity(){
       groupBy(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCityAs(String retName){
       groupBy(retName, TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCityWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.VENUE_CITY_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCountry(){
       groupBy(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCountryAs(String retName){
       groupBy(retName, TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVenueCountryWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.VENUE_COUNTRY_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByHomeScore(){
       groupBy(TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByHomeScoreAs(String retName){
       groupBy(retName, TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByHomeScoreWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.HOME_SCORE_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayScore(){
       groupBy(TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayScoreAs(String retName){
       groupBy(retName, TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayScoreWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.AWAY_SCORE_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeHome(){
       groupBy(TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeHomeAs(String retName){
       groupBy(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeHomeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.EXTRA_TIME_HOME_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeAway(){
       groupBy(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeAwayAs(String retName){
       groupBy(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByExtraTimeAwayWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyHome(){
       groupBy(TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyHomeAs(String retName){
       groupBy(retName, TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyHomeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.PENALTY_HOME_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyAway(){
       groupBy(TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyAwayAs(String retName){
       groupBy(retName, TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByPenaltyAwayWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.PENALTY_AWAY_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByHomeTeamWith(TournamentTeamRequest subRequest){
       groupBy(TournamentMatch.HOME_TEAM_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByHomeTeam(){
       groupBy(TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByHomeTeamAs(String retName){
       groupBy(retName, TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByHomeTeamWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.HOME_TEAM_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByAwayTeamWith(TournamentTeamRequest subRequest){
       groupBy(TournamentMatch.AWAY_TEAM_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByAwayTeam(){
       groupBy(TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayTeamAs(String retName){
       groupBy(retName, TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByAwayTeamWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.AWAY_TEAM_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchStageWith(MatchStageRequest subRequest){
       groupBy(TournamentMatch.MATCH_STAGE_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchStage(){
       groupBy(TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStageAs(String retName){
       groupBy(retName, TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStageWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.MATCH_STAGE_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchGroupWith(MatchGroupRequest subRequest){
       groupBy(TournamentMatch.MATCH_GROUP_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchGroup(){
       groupBy(TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchGroupAs(String retName){
       groupBy(retName, TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchGroupWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.MATCH_GROUP_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchStatusWith(MatchStatusRequest subRequest){
       groupBy(TournamentMatch.MATCH_STATUS_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByMatchStatus(){
       groupBy(TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStatusAs(String retName){
       groupBy(retName, TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByMatchStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.MATCH_STATUS_PROPERTY, function);
       return this;
    }
    public TournamentMatchRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(TournamentMatch.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public TournamentMatchRequest<T> groupByTournament(){
       groupBy(TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByCreateTime(){
       groupBy(TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByUpdateTime(){
       groupBy(TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> groupByVersion(){
       groupBy(TournamentMatch.VERSION_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TournamentMatch.VERSION_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentMatch.VERSION_PROPERTY, function);
       return this;
    }

    public TournamentMatchRequest<T> withMatchStageIsGroup(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_GROUP);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsRoundOf32(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_ROUND_OF_32);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsRoundOf16(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_ROUND_OF_16);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsQuarterFinal(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_QUARTER_FINAL);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsSemiFinal(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_SEMI_FINAL);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsThirdPlace(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_THIRD_PLACE);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStageIsFinal(){
       filterByMatchStage(com.example.fifaworldcupservice.Constants.MATCH_STAGE_FINAL);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStatusIsScheduled(){
       filterByMatchStatus(com.example.fifaworldcupservice.Constants.MATCH_STATUS_SCHEDULED);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStatusIsLive(){
       filterByMatchStatus(com.example.fifaworldcupservice.Constants.MATCH_STATUS_LIVE);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStatusIsFinished(){
       filterByMatchStatus(com.example.fifaworldcupservice.Constants.MATCH_STATUS_FINISHED);
       return this;
    }


    public TournamentMatchRequest<T> withMatchStatusIsPostponed(){
       filterByMatchStatus(com.example.fifaworldcupservice.Constants.MATCH_STATUS_POSTPONED);
       return this;
    }




    public TournamentMatchRequest<T> orderByIdAscending(){
       addOrderByAscending(TournamentMatch.ID_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByIdDescending(){
       addOrderByDescending(TournamentMatch.ID_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchNumberAscending(){
       addOrderByAscending(TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchNumberDescending(){
       addOrderByDescending(TournamentMatch.MATCH_NUMBER_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchDateAscending(){
       addOrderByAscending(TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchDateDescending(){
       addOrderByDescending(TournamentMatch.MATCH_DATE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueNameAscending(){
       addOrderByAscending(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueNameDescending(){
       addOrderByDescending(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByVenueNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentMatch.VENUE_NAME_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByVenueCityAscending(){
       addOrderByAscending(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueCityDescending(){
       addOrderByDescending(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByVenueCityAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueCityDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentMatch.VENUE_CITY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByVenueCountryAscending(){
       addOrderByAscending(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueCountryDescending(){
       addOrderByDescending(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByVenueCountryAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVenueCountryDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentMatch.VENUE_COUNTRY_PROPERTY);
       return this;
    }
    public TournamentMatchRequest<T> orderByHomeScoreAscending(){
       addOrderByAscending(TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByHomeScoreDescending(){
       addOrderByDescending(TournamentMatch.HOME_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByAwayScoreAscending(){
       addOrderByAscending(TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByAwayScoreDescending(){
       addOrderByDescending(TournamentMatch.AWAY_SCORE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByExtraTimeHomeAscending(){
       addOrderByAscending(TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByExtraTimeHomeDescending(){
       addOrderByDescending(TournamentMatch.EXTRA_TIME_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByExtraTimeAwayAscending(){
       addOrderByAscending(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByExtraTimeAwayDescending(){
       addOrderByDescending(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByPenaltyHomeAscending(){
       addOrderByAscending(TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByPenaltyHomeDescending(){
       addOrderByDescending(TournamentMatch.PENALTY_HOME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByPenaltyAwayAscending(){
       addOrderByAscending(TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByPenaltyAwayDescending(){
       addOrderByDescending(TournamentMatch.PENALTY_AWAY_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByHomeTeamAscending(){
       addOrderByAscending(TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByHomeTeamDescending(){
       addOrderByDescending(TournamentMatch.HOME_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByAwayTeamAscending(){
       addOrderByAscending(TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByAwayTeamDescending(){
       addOrderByDescending(TournamentMatch.AWAY_TEAM_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchStageAscending(){
       addOrderByAscending(TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchStageDescending(){
       addOrderByDescending(TournamentMatch.MATCH_STAGE_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchGroupAscending(){
       addOrderByAscending(TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchGroupDescending(){
       addOrderByDescending(TournamentMatch.MATCH_GROUP_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchStatusAscending(){
       addOrderByAscending(TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByMatchStatusDescending(){
       addOrderByDescending(TournamentMatch.MATCH_STATUS_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByTournamentAscending(){
       addOrderByAscending(TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByTournamentDescending(){
       addOrderByDescending(TournamentMatch.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(TournamentMatch.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(TournamentMatch.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVersionAscending(){
       addOrderByAscending(TournamentMatch.VERSION_PROPERTY);
       return this;
    }

    public TournamentMatchRequest<T> orderByVersionDescending(){
       addOrderByDescending(TournamentMatch.VERSION_PROPERTY);
       return this;
    }


    public TournamentMatchRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(name, subRequest, false);
    }

    public TournamentMatchRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchGoal.TOURNAMENT_MATCH_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentMatchRequest<T> statsFromMatchGoals(MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(REFINEMENTS, subRequest);
    }
    public TournamentMatchRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest){
       return statsFromMatchCardsAs(name, subRequest, false);
    }

    public TournamentMatchRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentMatchRequest<T> statsFromMatchCards(MatchCardRequest subRequest){
       return statsFromMatchCardsAs(REFINEMENTS, subRequest);
    }
    public TournamentTeamRequest rollUpToHomeTeam(){
       TournamentTeamRequest homeTeam = Q.tournamentTeams().unlimited();
       this.withHomeTeamMatching(homeTeam)
           .groupByHomeTeamWith(homeTeam);
       return homeTeam;
    }

    public TournamentTeamRequest rollUpToAwayTeam(){
       TournamentTeamRequest awayTeam = Q.tournamentTeams().unlimited();
       this.withAwayTeamMatching(awayTeam)
           .groupByAwayTeamWith(awayTeam);
       return awayTeam;
    }

    public MatchStageRequest rollUpToMatchStage(){
       MatchStageRequest matchStage = Q.matchStages().unlimited();
       this.withMatchStageMatching(matchStage)
           .groupByMatchStageWith(matchStage);
       return matchStage;
    }

    public MatchGroupRequest rollUpToMatchGroup(){
       MatchGroupRequest matchGroup = Q.matchGroups().unlimited();
       this.withMatchGroupMatching(matchGroup)
           .groupByMatchGroupWith(matchGroup);
       return matchGroup;
    }

    public MatchStatusRequest rollUpToMatchStatus(){
       MatchStatusRequest matchStatus = Q.matchStatuses().unlimited();
       this.withMatchStatusMatching(matchStatus)
           .groupByMatchStatusWith(matchStatus);
       return matchStatus;
    }

    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }




    public TournamentMatchRequest<T> countMatchGoals(){
        return countMatchGoalsAs("Count");
    }

    public TournamentMatchRequest<T> countMatchGoalsAs(String name){
        return countMatchGoalsWith(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> countMatchGoalsWith(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.count(), true);
    }
    public TournamentMatchRequest<T> countMatchCards(){
        return countMatchCardsAs("Count");
    }

    public TournamentMatchRequest<T> countMatchCardsAs(String name){
        return countMatchCardsWith(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> countMatchCardsWith(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.count(), true);
    }
    public TournamentMatchRequest<T> minMinuteScoredOfMatchGoals(){
        return minMinuteScoredOfMatchGoalsAs("minMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> minMinuteScoredOfMatchGoalsAs(String name){
        return minMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> minMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.minMinuteScored(), true);
    }
    public TournamentMatchRequest<T> maxMinuteScoredOfMatchGoals(){
        return maxMinuteScoredOfMatchGoalsAs("maxMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> maxMinuteScoredOfMatchGoalsAs(String name){
        return maxMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> maxMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.maxMinuteScored(), true);
    }
    public TournamentMatchRequest<T> sumMinuteScoredOfMatchGoals(){
        return sumMinuteScoredOfMatchGoalsAs("sumMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> sumMinuteScoredOfMatchGoalsAs(String name){
        return sumMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> sumMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sumMinuteScored(), true);
    }
    public TournamentMatchRequest<T> avgMinuteScoredOfMatchGoals(){
        return avgMinuteScoredOfMatchGoalsAs("avgMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> avgMinuteScoredOfMatchGoalsAs(String name){
        return avgMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> avgMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.avgMinuteScored(), true);
    }
    public TournamentMatchRequest<T> standardDeviationMinuteScoredOfMatchGoals(){
        return standardDeviationMinuteScoredOfMatchGoalsAs("stdDevMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return standardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.standardDeviationMinuteScored(), true);
    }
    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoals(){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs("stdDevPopMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteScored(), true);
    }
    public TournamentMatchRequest<T> sampleVarianceMinuteScoredOfMatchGoals(){
        return sampleVarianceMinuteScoredOfMatchGoalsAs("varSampMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name){
        return sampleVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sampleVarianceMinuteScored(), true);
    }
    public TournamentMatchRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoals(){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs("varPopMinuteScoredOfMatchGoals");
    }

    public TournamentMatchRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentMatchRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.samplePopulationVarianceMinuteScored(), true);
    }
    public TournamentMatchRequest<T> minMinuteIssuedOfMatchCards(){
        return minMinuteIssuedOfMatchCardsAs("minMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> minMinuteIssuedOfMatchCardsAs(String name){
        return minMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> minMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.minMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> maxMinuteIssuedOfMatchCards(){
        return maxMinuteIssuedOfMatchCardsAs("maxMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> maxMinuteIssuedOfMatchCardsAs(String name){
        return maxMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> maxMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.maxMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> sumMinuteIssuedOfMatchCards(){
        return sumMinuteIssuedOfMatchCardsAs("sumMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> sumMinuteIssuedOfMatchCardsAs(String name){
        return sumMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> sumMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sumMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> avgMinuteIssuedOfMatchCards(){
        return avgMinuteIssuedOfMatchCardsAs("avgMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> avgMinuteIssuedOfMatchCardsAs(String name){
        return avgMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> avgMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.avgMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> standardDeviationMinuteIssuedOfMatchCards(){
        return standardDeviationMinuteIssuedOfMatchCardsAs("stdDevMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return standardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.standardDeviationMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCards(){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs("stdDevPopMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> sampleVarianceMinuteIssuedOfMatchCards(){
        return sampleVarianceMinuteIssuedOfMatchCardsAs("varSampMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name){
        return sampleVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sampleVarianceMinuteIssued(), true);
    }
    public TournamentMatchRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCards(){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs("varPopMinuteIssuedOfMatchCards");
    }

    public TournamentMatchRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentMatchRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.samplePopulationVarianceMinuteIssued(), true);
    }

   public TournamentMatchRequest<T> facetByHomeTeamAs(String facetName, TournamentTeamRequest homeTeam){
       return facetByHomeTeamAs(facetName, homeTeam, true);
   }

   public TournamentMatchRequest<T> facetByHomeTeamAs(String facetName, TournamentTeamRequest homeTeam, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.HOME_TEAM_PROPERTY, homeTeam, includeAllFacets);
       return this;
   }
   public TournamentMatchRequest<T> facetByAwayTeamAs(String facetName, TournamentTeamRequest awayTeam){
       return facetByAwayTeamAs(facetName, awayTeam, true);
   }

   public TournamentMatchRequest<T> facetByAwayTeamAs(String facetName, TournamentTeamRequest awayTeam, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.AWAY_TEAM_PROPERTY, awayTeam, includeAllFacets);
       return this;
   }
   public TournamentMatchRequest<T> facetByMatchStageAs(String facetName, MatchStageRequest matchStage){
       return facetByMatchStageAs(facetName, matchStage, true);
   }

   public TournamentMatchRequest<T> facetByMatchStageAs(String facetName, MatchStageRequest matchStage, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.MATCH_STAGE_PROPERTY, matchStage, includeAllFacets);
       return this;
   }
   public TournamentMatchRequest<T> facetByMatchGroupAs(String facetName, MatchGroupRequest matchGroup){
       return facetByMatchGroupAs(facetName, matchGroup, true);
   }

   public TournamentMatchRequest<T> facetByMatchGroupAs(String facetName, MatchGroupRequest matchGroup, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.MATCH_GROUP_PROPERTY, matchGroup, includeAllFacets);
       return this;
   }
   public TournamentMatchRequest<T> facetByMatchStatusAs(String facetName, MatchStatusRequest matchStatus){
       return facetByMatchStatusAs(facetName, matchStatus, true);
   }

   public TournamentMatchRequest<T> facetByMatchStatusAs(String facetName, MatchStatusRequest matchStatus, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.MATCH_STATUS_PROPERTY, matchStatus, includeAllFacets);
       return this;
   }
   public TournamentMatchRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public TournamentMatchRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, TournamentMatch.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TournamentMatchRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TournamentMatchRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TournamentMatchRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TournamentMatchRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TournamentMatchRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}