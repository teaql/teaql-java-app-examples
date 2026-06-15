package com.example.fifaworldcupservice.tournament;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryRequest;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationRequest;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingRequest;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TournamentRequest<T extends Tournament> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TournamentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TournamentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TournamentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TournamentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TournamentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TournamentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TournamentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TournamentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TournamentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TournamentRequest<T> matchingAnyOf(TournamentRequest tournament){
        super.internalMatchAny(tournament);
        return this;
    }

    public TournamentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TournamentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TournamentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TournamentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectTournamentName().selectHostCountries().selectStartDate().selectEndDate().selectTotalTeams().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TournamentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTournamentName().selectHostCountries().selectStartDate().selectEndDate().selectTotalTeams().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentRequest<T> selectChildren(){
        super.selectAny();
        selectMatchStageList().selectMatchStatusList().selectGoalCategoryList().selectCardCategoryList().selectConfederationList().selectTournamentTeamList().selectMatchGroupList().selectTournamentMatchList().selectMatchGoalList().selectMatchCardList().selectGroupStandingList();
        return selectId().selectTournamentName().selectHostCountries().selectStartDate().selectEndDate().selectTotalTeams().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TournamentRequest<T> selectId(){
       selectProperty(Tournament.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectId(){
       unselectProperty(Tournament.ID_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectTournamentName(){
       selectProperty(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the tournamentName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  tournamentName) to fetch tournamentName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectTournamentName(){
       unselectProperty(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectHostCountries(){
       selectProperty(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }

    /**
     * fill the hostCountries with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  hostCountries) to fetch hostCountries property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectHostCountries(){
       unselectProperty(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectStartDate(){
       selectProperty(Tournament.START_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the startDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  startDate) to fetch startDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectStartDate(){
       unselectProperty(Tournament.START_DATE_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectEndDate(){
       selectProperty(Tournament.END_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the endDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  endDate) to fetch endDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectEndDate(){
       unselectProperty(Tournament.END_DATE_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectTotalTeams(){
       selectProperty(Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }

    /**
     * fill the totalTeams with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  totalTeams) to fetch totalTeams property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the totalTeams with customized aggrFunction, TEAQL uses ({aggrFunction}(totalTeams) AS totalTeams to fetch totalTeams property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentRequest<T> selectTotalTeams(AggrFunction aggrFunction){
       selectProperty(Tournament.TOTAL_TEAMS_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentRequest<T> unselectTotalTeams(){
       unselectProperty(Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectCreateTime(){
       selectProperty(Tournament.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectCreateTime(){
       unselectProperty(Tournament.CREATE_TIME_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectUpdateTime(){
       selectProperty(Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectUpdateTime(){
       unselectProperty(Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectVersion(){
       selectProperty(Tournament.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentRequest<T> unselectVersion(){
       unselectProperty(Tournament.VERSION_PROPERTY);
       return this;
    }
    public TournamentRequest<T> selectMatchStageList(){
       return selectMatchStageListWith(Q.matchStages().selectSelf());
    }

    public TournamentRequest<T> selectMatchStageListWith(MatchStageRequest matchStageList){
       enhanceRelation(Tournament.MATCH_STAGE_LIST_PROPERTY, matchStageList);
       return this;
    }
    public TournamentRequest<T> selectMatchStatusList(){
       return selectMatchStatusListWith(Q.matchStatuses().selectSelf());
    }

    public TournamentRequest<T> selectMatchStatusListWith(MatchStatusRequest matchStatusList){
       enhanceRelation(Tournament.MATCH_STATUS_LIST_PROPERTY, matchStatusList);
       return this;
    }
    public TournamentRequest<T> selectGoalCategoryList(){
       return selectGoalCategoryListWith(Q.goalCategories().selectSelf());
    }

    public TournamentRequest<T> selectGoalCategoryListWith(GoalCategoryRequest goalCategoryList){
       enhanceRelation(Tournament.GOAL_CATEGORY_LIST_PROPERTY, goalCategoryList);
       return this;
    }
    public TournamentRequest<T> selectCardCategoryList(){
       return selectCardCategoryListWith(Q.cardCategories().selectSelf());
    }

    public TournamentRequest<T> selectCardCategoryListWith(CardCategoryRequest cardCategoryList){
       enhanceRelation(Tournament.CARD_CATEGORY_LIST_PROPERTY, cardCategoryList);
       return this;
    }
    public TournamentRequest<T> selectConfederationList(){
       return selectConfederationListWith(Q.confederations().selectSelf());
    }

    public TournamentRequest<T> selectConfederationListWith(ConfederationRequest confederationList){
       enhanceRelation(Tournament.CONFEDERATION_LIST_PROPERTY, confederationList);
       return this;
    }
    public TournamentRequest<T> selectTournamentTeamList(){
       return selectTournamentTeamListWith(Q.tournamentTeams().selectSelf());
    }

    public TournamentRequest<T> selectTournamentTeamListWith(TournamentTeamRequest tournamentTeamList){
       enhanceRelation(Tournament.TOURNAMENT_TEAM_LIST_PROPERTY, tournamentTeamList);
       return this;
    }
    public TournamentRequest<T> selectMatchGroupList(){
       return selectMatchGroupListWith(Q.matchGroups().selectSelf());
    }

    public TournamentRequest<T> selectMatchGroupListWith(MatchGroupRequest matchGroupList){
       enhanceRelation(Tournament.MATCH_GROUP_LIST_PROPERTY, matchGroupList);
       return this;
    }
    public TournamentRequest<T> selectTournamentMatchList(){
       return selectTournamentMatchListWith(Q.tournamentMatches().selectSelf());
    }

    public TournamentRequest<T> selectTournamentMatchListWith(TournamentMatchRequest tournamentMatchList){
       enhanceRelation(Tournament.TOURNAMENT_MATCH_LIST_PROPERTY, tournamentMatchList);
       return this;
    }
    public TournamentRequest<T> selectMatchGoalList(){
       return selectMatchGoalListWith(Q.matchGoals().selectSelf());
    }

    public TournamentRequest<T> selectMatchGoalListWith(MatchGoalRequest matchGoalList){
       enhanceRelation(Tournament.MATCH_GOAL_LIST_PROPERTY, matchGoalList);
       return this;
    }
    public TournamentRequest<T> selectMatchCardList(){
       return selectMatchCardListWith(Q.matchCards().selectSelf());
    }

    public TournamentRequest<T> selectMatchCardListWith(MatchCardRequest matchCardList){
       enhanceRelation(Tournament.MATCH_CARD_LIST_PROPERTY, matchCardList);
       return this;
    }
    public TournamentRequest<T> selectGroupStandingList(){
       return selectGroupStandingListWith(Q.groupStandings().selectSelf());
    }

    public TournamentRequest<T> selectGroupStandingListWith(GroupStandingRequest groupStandingList){
       enhanceRelation(Tournament.GROUP_STANDING_LIST_PROPERTY, groupStandingList);
       return this;
    }

    public TournamentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.ID_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TournamentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TournamentRequest<T> filterByTournamentName(String... tournamentName){
      if (tournamentName == null || tournamentName.length == 0) {
        throw new IllegalArgumentException("filterByTournamentName parameter tournamentName cannot be empty");
      }
      return appendSearchCriteria(createTournamentNameCriteria(Operator.EQUAL, (Object[])tournamentName));
    }

    public TournamentRequest<T> withTournamentName(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentNameCriteria(operator, values));
    }

    public TournamentRequest<T> withTournamentNameIsUnknown(){
       return withTournamentName(Operator.IS_NULL);
    }

    public TournamentRequest<T> withTournamentNameIsKnown(){
       return withTournamentName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.TOURNAMENT_NAME_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withTournamentNameGreaterThan(String tournamentName){
       return withTournamentName(Operator.GREATER_THAN, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameGreaterThanOrEqualTo(String tournamentName){
       return withTournamentName(Operator.GREATER_THAN_OR_EQUAL, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameLessThan(String tournamentName){
       return withTournamentName(Operator.LESS_THAN, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameLessThanOrEqualTo(String tournamentName){
       return withTournamentName(Operator.LESS_THAN_OR_EQUAL, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameBetween(String startOfTournamentName, String endOfTournamentName){
       return withTournamentName(Operator.BETWEEN, startOfTournamentName, endOfTournamentName);
    }
    public TournamentRequest<T> withTournamentNameStartingWith(String tournamentName){
       return withTournamentName(Operator.BEGIN_WITH, tournamentName);
    }
    public TournamentRequest<T> withTournamentNameContaining(String tournamentName){
       return withTournamentName(Operator.CONTAIN, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameEndingWith(String tournamentName){
       return withTournamentName(Operator.END_WITH, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameIs(String tournamentName){
       return withTournamentName(Operator.EQUAL, tournamentName);
    }

    public TournamentRequest<T> withTournamentNameSoundingLike(String tournamentName){
       return withTournamentName(Operator.SOUNDS_LIKE, tournamentName);
    }



    public TournamentRequest<T> filterByHostCountries(String... hostCountries){
      if (hostCountries == null || hostCountries.length == 0) {
        throw new IllegalArgumentException("filterByHostCountries parameter hostCountries cannot be empty");
      }
      return appendSearchCriteria(createHostCountriesCriteria(Operator.EQUAL, (Object[])hostCountries));
    }

    public TournamentRequest<T> withHostCountries(Operator operator, Object... values){
       return appendSearchCriteria(createHostCountriesCriteria(operator, values));
    }

    public TournamentRequest<T> withHostCountriesIsUnknown(){
       return withHostCountries(Operator.IS_NULL);
    }

    public TournamentRequest<T> withHostCountriesIsKnown(){
       return withHostCountries(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createHostCountriesCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.HOST_COUNTRIES_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withHostCountriesGreaterThan(String hostCountries){
       return withHostCountries(Operator.GREATER_THAN, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesGreaterThanOrEqualTo(String hostCountries){
       return withHostCountries(Operator.GREATER_THAN_OR_EQUAL, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesLessThan(String hostCountries){
       return withHostCountries(Operator.LESS_THAN, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesLessThanOrEqualTo(String hostCountries){
       return withHostCountries(Operator.LESS_THAN_OR_EQUAL, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesBetween(String startOfHostCountries, String endOfHostCountries){
       return withHostCountries(Operator.BETWEEN, startOfHostCountries, endOfHostCountries);
    }
    public TournamentRequest<T> withHostCountriesStartingWith(String hostCountries){
       return withHostCountries(Operator.BEGIN_WITH, hostCountries);
    }
    public TournamentRequest<T> withHostCountriesContaining(String hostCountries){
       return withHostCountries(Operator.CONTAIN, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesEndingWith(String hostCountries){
       return withHostCountries(Operator.END_WITH, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesIs(String hostCountries){
       return withHostCountries(Operator.EQUAL, hostCountries);
    }

    public TournamentRequest<T> withHostCountriesSoundingLike(String hostCountries){
       return withHostCountries(Operator.SOUNDS_LIKE, hostCountries);
    }



    public TournamentRequest<T> filterByStartDate(LocalDate... startDate){
      if (startDate == null || startDate.length == 0) {
        throw new IllegalArgumentException("filterByStartDate parameter startDate cannot be empty");
      }
      return appendSearchCriteria(createStartDateCriteria(Operator.EQUAL, (Object[])startDate));
    }

    public TournamentRequest<T> withStartDate(Operator operator, Object... values){
       return appendSearchCriteria(createStartDateCriteria(operator, values));
    }

    public TournamentRequest<T> withStartDateIsUnknown(){
       return withStartDate(Operator.IS_NULL);
    }

    public TournamentRequest<T> withStartDateIsKnown(){
       return withStartDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStartDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.START_DATE_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withStartDateGreaterThan(LocalDate startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateGreaterThanOrEqualTo(LocalDate startDate){
       return withStartDate(Operator.GREATER_THAN_OR_EQUAL, startDate);
    }

    public TournamentRequest<T> withStartDateLessThan(LocalDate startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateLessThanOrEqualTo(LocalDate startDate){
       return withStartDate(Operator.LESS_THAN_OR_EQUAL, startDate);
    }

    public TournamentRequest<T> withStartDateBetween(LocalDate startOfStartDate, LocalDate endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }
    public TournamentRequest<T> withStartDateBefore(LocalDate startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateBefore(Date startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateAfter(LocalDate startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateAfter(Date startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public TournamentRequest<T> withStartDateBetween(Date startOfStartDate, Date endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }




    public TournamentRequest<T> filterByEndDate(LocalDate... endDate){
      if (endDate == null || endDate.length == 0) {
        throw new IllegalArgumentException("filterByEndDate parameter endDate cannot be empty");
      }
      return appendSearchCriteria(createEndDateCriteria(Operator.EQUAL, (Object[])endDate));
    }

    public TournamentRequest<T> withEndDate(Operator operator, Object... values){
       return appendSearchCriteria(createEndDateCriteria(operator, values));
    }

    public TournamentRequest<T> withEndDateIsUnknown(){
       return withEndDate(Operator.IS_NULL);
    }

    public TournamentRequest<T> withEndDateIsKnown(){
       return withEndDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEndDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.END_DATE_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withEndDateGreaterThan(LocalDate endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateGreaterThanOrEqualTo(LocalDate endDate){
       return withEndDate(Operator.GREATER_THAN_OR_EQUAL, endDate);
    }

    public TournamentRequest<T> withEndDateLessThan(LocalDate endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateLessThanOrEqualTo(LocalDate endDate){
       return withEndDate(Operator.LESS_THAN_OR_EQUAL, endDate);
    }

    public TournamentRequest<T> withEndDateBetween(LocalDate startOfEndDate, LocalDate endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }
    public TournamentRequest<T> withEndDateBefore(LocalDate endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateBefore(Date endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateAfter(LocalDate endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateAfter(Date endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public TournamentRequest<T> withEndDateBetween(Date startOfEndDate, Date endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }




    public TournamentRequest<T> filterByTotalTeams(Integer... totalTeams){
      if (totalTeams == null || totalTeams.length == 0) {
        throw new IllegalArgumentException("filterByTotalTeams parameter totalTeams cannot be empty");
      }
      return appendSearchCriteria(createTotalTeamsCriteria(Operator.EQUAL, (Object[])totalTeams));
    }

    public TournamentRequest<T> withTotalTeams(Operator operator, Object... values){
       return appendSearchCriteria(createTotalTeamsCriteria(operator, values));
    }

    public TournamentRequest<T> withTotalTeamsIsUnknown(){
       return withTotalTeams(Operator.IS_NULL);
    }

    public TournamentRequest<T> withTotalTeamsIsKnown(){
       return withTotalTeams(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTotalTeamsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.TOTAL_TEAMS_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withTotalTeamsGreaterThan(Integer totalTeams){
       return withTotalTeams(Operator.GREATER_THAN, totalTeams);
    }

    public TournamentRequest<T> withTotalTeamsGreaterThanOrEqualTo(Integer totalTeams){
       return withTotalTeams(Operator.GREATER_THAN_OR_EQUAL, totalTeams);
    }

    public TournamentRequest<T> withTotalTeamsLessThan(Integer totalTeams){
       return withTotalTeams(Operator.LESS_THAN, totalTeams);
    }

    public TournamentRequest<T> withTotalTeamsLessThanOrEqualTo(Integer totalTeams){
       return withTotalTeams(Operator.LESS_THAN_OR_EQUAL, totalTeams);
    }

    public TournamentRequest<T> withTotalTeamsBetween(Integer startOfTotalTeams, Integer endOfTotalTeams){
       return withTotalTeams(Operator.BETWEEN, startOfTotalTeams, endOfTotalTeams);
    }



    public TournamentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TournamentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TournamentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TournamentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.CREATE_TIME_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TournamentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TournamentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TournamentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TournamentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TournamentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TournamentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TournamentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TournamentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TournamentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TournamentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TournamentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TournamentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Tournament.VERSION_PROPERTY, operator, values);
    }

    public TournamentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TournamentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TournamentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TournamentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TournamentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TournamentRequest<T> withMatchStageListMatching(MatchStageRequest matchStageRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchStageRequest, MatchStage.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutMatchStageListMatching(MatchStageRequest matchStageRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchStageRequest, MatchStage.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveMatchStages(){
        return withMatchStageListMatching(Q.matchStages().unlimited());
    }

    public TournamentRequest<T> haveNoMatchStages(){
        return withoutMatchStageListMatching(Q.matchStages().unlimited());
    }
    public TournamentRequest<T> withMatchStatusListMatching(MatchStatusRequest matchStatusRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchStatusRequest, MatchStatus.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutMatchStatusListMatching(MatchStatusRequest matchStatusRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchStatusRequest, MatchStatus.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveMatchStatuses(){
        return withMatchStatusListMatching(Q.matchStatuses().unlimited());
    }

    public TournamentRequest<T> haveNoMatchStatuses(){
        return withoutMatchStatusListMatching(Q.matchStatuses().unlimited());
    }
    public TournamentRequest<T> withGoalCategoryListMatching(GoalCategoryRequest goalCategoryRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, goalCategoryRequest, GoalCategory.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutGoalCategoryListMatching(GoalCategoryRequest goalCategoryRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, goalCategoryRequest, GoalCategory.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveGoalCategories(){
        return withGoalCategoryListMatching(Q.goalCategories().unlimited());
    }

    public TournamentRequest<T> haveNoGoalCategories(){
        return withoutGoalCategoryListMatching(Q.goalCategories().unlimited());
    }
    public TournamentRequest<T> withCardCategoryListMatching(CardCategoryRequest cardCategoryRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, cardCategoryRequest, CardCategory.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutCardCategoryListMatching(CardCategoryRequest cardCategoryRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, cardCategoryRequest, CardCategory.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveCardCategories(){
        return withCardCategoryListMatching(Q.cardCategories().unlimited());
    }

    public TournamentRequest<T> haveNoCardCategories(){
        return withoutCardCategoryListMatching(Q.cardCategories().unlimited());
    }
    public TournamentRequest<T> withConfederationListMatching(ConfederationRequest confederationRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, confederationRequest, Confederation.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutConfederationListMatching(ConfederationRequest confederationRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, confederationRequest, Confederation.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveConfederations(){
        return withConfederationListMatching(Q.confederations().unlimited());
    }

    public TournamentRequest<T> haveNoConfederations(){
        return withoutConfederationListMatching(Q.confederations().unlimited());
    }
    public TournamentRequest<T> withTournamentTeamListMatching(TournamentTeamRequest tournamentTeamRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, tournamentTeamRequest, TournamentTeam.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutTournamentTeamListMatching(TournamentTeamRequest tournamentTeamRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, tournamentTeamRequest, TournamentTeam.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveTournamentTeams(){
        return withTournamentTeamListMatching(Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> haveNoTournamentTeams(){
        return withoutTournamentTeamListMatching(Q.tournamentTeams().unlimited());
    }
    public TournamentRequest<T> withMatchGroupListMatching(MatchGroupRequest matchGroupRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchGroupRequest, MatchGroup.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutMatchGroupListMatching(MatchGroupRequest matchGroupRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchGroupRequest, MatchGroup.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveMatchGroups(){
        return withMatchGroupListMatching(Q.matchGroups().unlimited());
    }

    public TournamentRequest<T> haveNoMatchGroups(){
        return withoutMatchGroupListMatching(Q.matchGroups().unlimited());
    }
    public TournamentRequest<T> withTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutTournamentMatchListMatching(TournamentMatchRequest tournamentMatchRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, tournamentMatchRequest, TournamentMatch.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveTournamentMatches(){
        return withTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> haveNoTournamentMatches(){
        return withoutTournamentMatchListMatching(Q.tournamentMatches().unlimited());
    }
    public TournamentRequest<T> withMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveMatchGoals(){
        return withMatchGoalListMatching(Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> haveNoMatchGoals(){
        return withoutMatchGoalListMatching(Q.matchGoals().unlimited());
    }
    public TournamentRequest<T> withMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveMatchCards(){
        return withMatchCardListMatching(Q.matchCards().unlimited());
    }

    public TournamentRequest<T> haveNoMatchCards(){
        return withoutMatchCardListMatching(Q.matchCards().unlimited());
    }
    public TournamentRequest<T> withGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, groupStandingRequest, GroupStanding.TOURNAMENT_PROPERTY));
    }

    public TournamentRequest<T> withoutGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Tournament.ID_PROPERTY, groupStandingRequest, GroupStanding.TOURNAMENT_PROPERTY)));
    }

    public TournamentRequest<T> haveGroupStandings(){
        return withGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> haveNoGroupStandings(){
        return withoutGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> count(){
        super.count();
        return this;
    }
    public TournamentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TournamentRequest minTotalTeams(){
        return minTotalTeamsAs(prefix("minOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest minTotalTeamsAs(String retName){
        super.min(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest maxTotalTeams(){
        return maxTotalTeamsAs(prefix("maxOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest maxTotalTeamsAs(String retName){
        super.max(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest sumTotalTeams(){
        return sumTotalTeamsAs(prefix("sumOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest sumTotalTeamsAs(String retName){
        super.sum(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest avgTotalTeams(){
        return avgTotalTeamsAs(prefix("avgOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest avgTotalTeamsAs(String retName){
        super.avg(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest standardDeviationTotalTeams(){
        return standardDeviationTotalTeamsAs(prefix("standardDeviationOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest standardDeviationTotalTeamsAs(String retName){
        super.standardDeviation(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest squareRootOfPopulationStandardDeviationTotalTeams(){
        return squareRootOfPopulationStandardDeviationTotalTeamsAs(prefix("squareRootOfPopulationStandardDeviationOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest squareRootOfPopulationStandardDeviationTotalTeamsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest sampleVarianceTotalTeams(){
        return sampleVarianceTotalTeamsAs(prefix("sampleVarianceOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest sampleVarianceTotalTeamsAs(String retName){
        super.sampleVariance(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest samplePopulationVarianceTotalTeams(){
        return samplePopulationVarianceTotalTeamsAs(prefix("samplePopulationVarianceOf",Tournament.TOTAL_TEAMS_PROPERTY));
    }

    public TournamentRequest samplePopulationVarianceTotalTeamsAs(String retName){
        super.samplePopulationVariance(retName, Tournament.TOTAL_TEAMS_PROPERTY);
        return this;
    }
    public TournamentRequest<T> groupByMatchStagesWithDetails(MatchStageRequest subRequest){
       aggregate(Tournament.MATCH_STAGE_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByMatchStatusesWithDetails(MatchStatusRequest subRequest){
       aggregate(Tournament.MATCH_STATUS_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByGoalCategoriesWithDetails(GoalCategoryRequest subRequest){
       aggregate(Tournament.GOAL_CATEGORY_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByCardCategoriesWithDetails(CardCategoryRequest subRequest){
       aggregate(Tournament.CARD_CATEGORY_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByConfederationsWithDetails(ConfederationRequest subRequest){
       aggregate(Tournament.CONFEDERATION_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByTournamentTeamsWithDetails(TournamentTeamRequest subRequest){
       aggregate(Tournament.TOURNAMENT_TEAM_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByMatchGroupsWithDetails(MatchGroupRequest subRequest){
       aggregate(Tournament.MATCH_GROUP_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByTournamentMatchesWithDetails(TournamentMatchRequest subRequest){
       aggregate(Tournament.TOURNAMENT_MATCH_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByMatchGoalsWithDetails(MatchGoalRequest subRequest){
       aggregate(Tournament.MATCH_GOAL_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByMatchCardsWithDetails(MatchCardRequest subRequest){
       aggregate(Tournament.MATCH_CARD_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentRequest<T> groupByGroupStandingsWithDetails(GroupStandingRequest subRequest){
       aggregate(Tournament.GROUP_STANDING_LIST_PROPERTY, subRequest);
       return this;
    }

    public TournamentRequest<T> groupById(){
       groupBy(Tournament.ID_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByIdAs(String retName){
       groupBy(retName, Tournament.ID_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.ID_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByTournamentName(){
       groupBy(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByTournamentNameAs(String retName){
       groupBy(retName, Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByTournamentNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.TOURNAMENT_NAME_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByHostCountries(){
       groupBy(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByHostCountriesAs(String retName){
       groupBy(retName, Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByHostCountriesWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.HOST_COUNTRIES_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByStartDate(){
       groupBy(Tournament.START_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByStartDateAs(String retName){
       groupBy(retName, Tournament.START_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByStartDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.START_DATE_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByEndDate(){
       groupBy(Tournament.END_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByEndDateAs(String retName){
       groupBy(retName, Tournament.END_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByEndDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.END_DATE_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByTotalTeams(){
       groupBy(Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByTotalTeamsAs(String retName){
       groupBy(retName, Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByTotalTeamsWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.TOTAL_TEAMS_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByCreateTime(){
       groupBy(Tournament.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Tournament.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByUpdateTime(){
       groupBy(Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentRequest<T> groupByVersion(){
       groupBy(Tournament.VERSION_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Tournament.VERSION_PROPERTY);
       return this;
    }

    public TournamentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Tournament.VERSION_PROPERTY, function);
       return this;
    }



    public TournamentRequest<T> orderByIdAscending(){
       addOrderByAscending(Tournament.ID_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByIdDescending(){
       addOrderByDescending(Tournament.ID_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByTournamentNameAscending(){
       addOrderByAscending(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByTournamentNameDescending(){
       addOrderByDescending(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }
    public TournamentRequest<T> orderByTournamentNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByTournamentNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Tournament.TOURNAMENT_NAME_PROPERTY);
       return this;
    }
    public TournamentRequest<T> orderByHostCountriesAscending(){
       addOrderByAscending(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByHostCountriesDescending(){
       addOrderByDescending(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }
    public TournamentRequest<T> orderByHostCountriesAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByHostCountriesDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Tournament.HOST_COUNTRIES_PROPERTY);
       return this;
    }
    public TournamentRequest<T> orderByStartDateAscending(){
       addOrderByAscending(Tournament.START_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByStartDateDescending(){
       addOrderByDescending(Tournament.START_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByEndDateAscending(){
       addOrderByAscending(Tournament.END_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByEndDateDescending(){
       addOrderByDescending(Tournament.END_DATE_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByTotalTeamsAscending(){
       addOrderByAscending(Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByTotalTeamsDescending(){
       addOrderByDescending(Tournament.TOTAL_TEAMS_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Tournament.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Tournament.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Tournament.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByVersionAscending(){
       addOrderByAscending(Tournament.VERSION_PROPERTY);
       return this;
    }

    public TournamentRequest<T> orderByVersionDescending(){
       addOrderByDescending(Tournament.VERSION_PROPERTY);
       return this;
    }


    public TournamentRequest<T> statsFromMatchStagesAs(String name, MatchStageRequest subRequest){
       return statsFromMatchStagesAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromMatchStagesAs(String name, MatchStageRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchStage.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromMatchStages(MatchStageRequest subRequest){
       return statsFromMatchStagesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromMatchStatusesAs(String name, MatchStatusRequest subRequest){
       return statsFromMatchStatusesAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromMatchStatusesAs(String name, MatchStatusRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchStatus.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromMatchStatuses(MatchStatusRequest subRequest){
       return statsFromMatchStatusesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromGoalCategoriesAs(String name, GoalCategoryRequest subRequest){
       return statsFromGoalCategoriesAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromGoalCategoriesAs(String name, GoalCategoryRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(GoalCategory.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromGoalCategories(GoalCategoryRequest subRequest){
       return statsFromGoalCategoriesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromCardCategoriesAs(String name, CardCategoryRequest subRequest){
       return statsFromCardCategoriesAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromCardCategoriesAs(String name, CardCategoryRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(CardCategory.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromCardCategories(CardCategoryRequest subRequest){
       return statsFromCardCategoriesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromConfederationsAs(String name, ConfederationRequest subRequest){
       return statsFromConfederationsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromConfederationsAs(String name, ConfederationRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Confederation.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromConfederations(ConfederationRequest subRequest){
       return statsFromConfederationsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
       return statsFromTournamentTeamsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromTournamentTeamsAs(String name, TournamentTeamRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentTeam.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromTournamentTeams(TournamentTeamRequest subRequest){
       return statsFromTournamentTeamsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromMatchGroupsAs(String name, MatchGroupRequest subRequest){
       return statsFromMatchGroupsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromMatchGroupsAs(String name, MatchGroupRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchGroup.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromMatchGroups(MatchGroupRequest subRequest){
       return statsFromMatchGroupsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromTournamentMatchesAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromTournamentMatches(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchGoal.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromMatchGoals(MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest){
       return statsFromMatchCardsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchCard.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromMatchCards(MatchCardRequest subRequest){
       return statsFromMatchCardsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(name, subRequest, false);
    }

    public TournamentRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(GroupStanding.TOURNAMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentRequest<T> statsFromGroupStandings(GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(REFINEMENTS, subRequest);
    }
    public TournamentRequest<T> countMatchStages(){
        return countMatchStagesAs("Count");
    }

    public TournamentRequest<T> countMatchStagesAs(String name){
        return countMatchStagesWith(name, Q.matchStages().unlimited());
    }

    public TournamentRequest<T> countMatchStagesWith(String name, MatchStageRequest subRequest){
        return statsFromMatchStagesAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countMatchStatuses(){
        return countMatchStatusesAs("Count");
    }

    public TournamentRequest<T> countMatchStatusesAs(String name){
        return countMatchStatusesWith(name, Q.matchStatuses().unlimited());
    }

    public TournamentRequest<T> countMatchStatusesWith(String name, MatchStatusRequest subRequest){
        return statsFromMatchStatusesAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countGoalCategories(){
        return countGoalCategoriesAs("Count");
    }

    public TournamentRequest<T> countGoalCategoriesAs(String name){
        return countGoalCategoriesWith(name, Q.goalCategories().unlimited());
    }

    public TournamentRequest<T> countGoalCategoriesWith(String name, GoalCategoryRequest subRequest){
        return statsFromGoalCategoriesAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countCardCategories(){
        return countCardCategoriesAs("Count");
    }

    public TournamentRequest<T> countCardCategoriesAs(String name){
        return countCardCategoriesWith(name, Q.cardCategories().unlimited());
    }

    public TournamentRequest<T> countCardCategoriesWith(String name, CardCategoryRequest subRequest){
        return statsFromCardCategoriesAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countConfederations(){
        return countConfederationsAs("Count");
    }

    public TournamentRequest<T> countConfederationsAs(String name){
        return countConfederationsWith(name, Q.confederations().unlimited());
    }

    public TournamentRequest<T> countConfederationsWith(String name, ConfederationRequest subRequest){
        return statsFromConfederationsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countTournamentTeams(){
        return countTournamentTeamsAs("Count");
    }

    public TournamentRequest<T> countTournamentTeamsAs(String name){
        return countTournamentTeamsWith(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> countTournamentTeamsWith(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countMatchGroups(){
        return countMatchGroupsAs("Count");
    }

    public TournamentRequest<T> countMatchGroupsAs(String name){
        return countMatchGroupsWith(name, Q.matchGroups().unlimited());
    }

    public TournamentRequest<T> countMatchGroupsWith(String name, MatchGroupRequest subRequest){
        return statsFromMatchGroupsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countTournamentMatches(){
        return countTournamentMatchesAs("Count");
    }

    public TournamentRequest<T> countTournamentMatchesAs(String name){
        return countTournamentMatchesWith(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> countTournamentMatchesWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countMatchGoals(){
        return countMatchGoalsAs("Count");
    }

    public TournamentRequest<T> countMatchGoalsAs(String name){
        return countMatchGoalsWith(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> countMatchGoalsWith(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countMatchCards(){
        return countMatchCardsAs("Count");
    }

    public TournamentRequest<T> countMatchCardsAs(String name){
        return countMatchCardsWith(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> countMatchCardsWith(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> countGroupStandings(){
        return countGroupStandingsAs("Count");
    }

    public TournamentRequest<T> countGroupStandingsAs(String name){
        return countGroupStandingsWith(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> countGroupStandingsWith(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.count(), true);
    }
    public TournamentRequest<T> minFifaRankingOfTournamentTeams(){
        return minFifaRankingOfTournamentTeamsAs("minFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> minFifaRankingOfTournamentTeamsAs(String name){
        return minFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> minFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.minFifaRanking(), true);
    }
    public TournamentRequest<T> maxFifaRankingOfTournamentTeams(){
        return maxFifaRankingOfTournamentTeamsAs("maxFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> maxFifaRankingOfTournamentTeamsAs(String name){
        return maxFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> maxFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.maxFifaRanking(), true);
    }
    public TournamentRequest<T> sumFifaRankingOfTournamentTeams(){
        return sumFifaRankingOfTournamentTeamsAs("sumFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> sumFifaRankingOfTournamentTeamsAs(String name){
        return sumFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> sumFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.sumFifaRanking(), true);
    }
    public TournamentRequest<T> avgFifaRankingOfTournamentTeams(){
        return avgFifaRankingOfTournamentTeamsAs("avgFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> avgFifaRankingOfTournamentTeamsAs(String name){
        return avgFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> avgFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.avgFifaRanking(), true);
    }
    public TournamentRequest<T> standardDeviationFifaRankingOfTournamentTeams(){
        return standardDeviationFifaRankingOfTournamentTeamsAs("stdDevFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> standardDeviationFifaRankingOfTournamentTeamsAs(String name){
        return standardDeviationFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> standardDeviationFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.standardDeviationFifaRanking(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeams(){
        return squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs("stdDevPopFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(String name){
        return squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.squareRootOfPopulationStandardDeviationFifaRanking(), true);
    }
    public TournamentRequest<T> sampleVarianceFifaRankingOfTournamentTeams(){
        return sampleVarianceFifaRankingOfTournamentTeamsAs("varSampFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> sampleVarianceFifaRankingOfTournamentTeamsAs(String name){
        return sampleVarianceFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> sampleVarianceFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.sampleVarianceFifaRanking(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeams(){
        return samplePopulationVarianceFifaRankingOfTournamentTeamsAs("varPopFifaRankingOfTournamentTeams");
    }

    public TournamentRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeamsAs(String name){
        return samplePopulationVarianceFifaRankingOfTournamentTeamsAs(name, Q.tournamentTeams().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceFifaRankingOfTournamentTeamsAs(String name, TournamentTeamRequest subRequest){
        return statsFromTournamentTeamsAs(name, subRequest.samplePopulationVarianceFifaRanking(), true);
    }
    public TournamentRequest<T> minMatchNumberOfTournamentMatches(){
        return minMatchNumberOfTournamentMatchesAs("minMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> minMatchNumberOfTournamentMatchesAs(String name){
        return minMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minMatchNumber(), true);
    }
    public TournamentRequest<T> maxMatchNumberOfTournamentMatches(){
        return maxMatchNumberOfTournamentMatchesAs("maxMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> maxMatchNumberOfTournamentMatchesAs(String name){
        return maxMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxMatchNumber(), true);
    }
    public TournamentRequest<T> sumMatchNumberOfTournamentMatches(){
        return sumMatchNumberOfTournamentMatchesAs("sumMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> sumMatchNumberOfTournamentMatchesAs(String name){
        return sumMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumMatchNumber(), true);
    }
    public TournamentRequest<T> avgMatchNumberOfTournamentMatches(){
        return avgMatchNumberOfTournamentMatchesAs("avgMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> avgMatchNumberOfTournamentMatchesAs(String name){
        return avgMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgMatchNumber(), true);
    }
    public TournamentRequest<T> standardDeviationMatchNumberOfTournamentMatches(){
        return standardDeviationMatchNumberOfTournamentMatchesAs("stdDevMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs("stdDevPopMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public TournamentRequest<T> sampleVarianceMatchNumberOfTournamentMatches(){
        return sampleVarianceMatchNumberOfTournamentMatchesAs("varSampMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatches(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs("varPopMatchNumberOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public TournamentRequest<T> minHomeScoreOfTournamentMatches(){
        return minHomeScoreOfTournamentMatchesAs("minHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> minHomeScoreOfTournamentMatchesAs(String name){
        return minHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minHomeScore(), true);
    }
    public TournamentRequest<T> maxHomeScoreOfTournamentMatches(){
        return maxHomeScoreOfTournamentMatchesAs("maxHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> maxHomeScoreOfTournamentMatchesAs(String name){
        return maxHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxHomeScore(), true);
    }
    public TournamentRequest<T> sumHomeScoreOfTournamentMatches(){
        return sumHomeScoreOfTournamentMatchesAs("sumHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> sumHomeScoreOfTournamentMatchesAs(String name){
        return sumHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumHomeScore(), true);
    }
    public TournamentRequest<T> avgHomeScoreOfTournamentMatches(){
        return avgHomeScoreOfTournamentMatchesAs("avgHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> avgHomeScoreOfTournamentMatchesAs(String name){
        return avgHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgHomeScore(), true);
    }
    public TournamentRequest<T> standardDeviationHomeScoreOfTournamentMatches(){
        return standardDeviationHomeScoreOfTournamentMatchesAs("stdDevHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs("stdDevPopHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public TournamentRequest<T> sampleVarianceHomeScoreOfTournamentMatches(){
        return sampleVarianceHomeScoreOfTournamentMatchesAs("varSampHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatches(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs("varPopHomeScoreOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public TournamentRequest<T> minAwayScoreOfTournamentMatches(){
        return minAwayScoreOfTournamentMatchesAs("minAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> minAwayScoreOfTournamentMatchesAs(String name){
        return minAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minAwayScore(), true);
    }
    public TournamentRequest<T> maxAwayScoreOfTournamentMatches(){
        return maxAwayScoreOfTournamentMatchesAs("maxAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> maxAwayScoreOfTournamentMatchesAs(String name){
        return maxAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxAwayScore(), true);
    }
    public TournamentRequest<T> sumAwayScoreOfTournamentMatches(){
        return sumAwayScoreOfTournamentMatchesAs("sumAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> sumAwayScoreOfTournamentMatchesAs(String name){
        return sumAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumAwayScore(), true);
    }
    public TournamentRequest<T> avgAwayScoreOfTournamentMatches(){
        return avgAwayScoreOfTournamentMatchesAs("avgAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> avgAwayScoreOfTournamentMatchesAs(String name){
        return avgAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgAwayScore(), true);
    }
    public TournamentRequest<T> standardDeviationAwayScoreOfTournamentMatches(){
        return standardDeviationAwayScoreOfTournamentMatchesAs("stdDevAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs("stdDevPopAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public TournamentRequest<T> sampleVarianceAwayScoreOfTournamentMatches(){
        return sampleVarianceAwayScoreOfTournamentMatchesAs("varSampAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatches(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs("varPopAwayScoreOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public TournamentRequest<T> minExtraTimeHomeOfTournamentMatches(){
        return minExtraTimeHomeOfTournamentMatchesAs("minExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeHome(), true);
    }
    public TournamentRequest<T> maxExtraTimeHomeOfTournamentMatches(){
        return maxExtraTimeHomeOfTournamentMatchesAs("maxExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public TournamentRequest<T> sumExtraTimeHomeOfTournamentMatches(){
        return sumExtraTimeHomeOfTournamentMatchesAs("sumExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public TournamentRequest<T> avgExtraTimeHomeOfTournamentMatches(){
        return avgExtraTimeHomeOfTournamentMatchesAs("avgExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public TournamentRequest<T> standardDeviationExtraTimeHomeOfTournamentMatches(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs("stdDevPopExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public TournamentRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatches(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs("varSampExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs("varPopExtraTimeHomeOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public TournamentRequest<T> minExtraTimeAwayOfTournamentMatches(){
        return minExtraTimeAwayOfTournamentMatchesAs("minExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minExtraTimeAway(), true);
    }
    public TournamentRequest<T> maxExtraTimeAwayOfTournamentMatches(){
        return maxExtraTimeAwayOfTournamentMatchesAs("maxExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public TournamentRequest<T> sumExtraTimeAwayOfTournamentMatches(){
        return sumExtraTimeAwayOfTournamentMatchesAs("sumExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public TournamentRequest<T> avgExtraTimeAwayOfTournamentMatches(){
        return avgExtraTimeAwayOfTournamentMatchesAs("avgExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public TournamentRequest<T> standardDeviationExtraTimeAwayOfTournamentMatches(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs("stdDevPopExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public TournamentRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatches(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs("varSampExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatches(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs("varPopExtraTimeAwayOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public TournamentRequest<T> minPenaltyHomeOfTournamentMatches(){
        return minPenaltyHomeOfTournamentMatchesAs("minPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name){
        return minPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyHome(), true);
    }
    public TournamentRequest<T> maxPenaltyHomeOfTournamentMatches(){
        return maxPenaltyHomeOfTournamentMatchesAs("maxPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyHome(), true);
    }
    public TournamentRequest<T> sumPenaltyHomeOfTournamentMatches(){
        return sumPenaltyHomeOfTournamentMatchesAs("sumPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyHome(), true);
    }
    public TournamentRequest<T> avgPenaltyHomeOfTournamentMatches(){
        return avgPenaltyHomeOfTournamentMatchesAs("avgPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyHome(), true);
    }
    public TournamentRequest<T> standardDeviationPenaltyHomeOfTournamentMatches(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs("stdDevPopPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public TournamentRequest<T> sampleVariancePenaltyHomeOfTournamentMatches(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs("varSampPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public TournamentRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatches(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs("varPopPenaltyHomeOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public TournamentRequest<T> minPenaltyAwayOfTournamentMatches(){
        return minPenaltyAwayOfTournamentMatchesAs("minPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name){
        return minPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> minPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.minPenaltyAway(), true);
    }
    public TournamentRequest<T> maxPenaltyAwayOfTournamentMatches(){
        return maxPenaltyAwayOfTournamentMatchesAs("maxPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> maxPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.maxPenaltyAway(), true);
    }
    public TournamentRequest<T> sumPenaltyAwayOfTournamentMatches(){
        return sumPenaltyAwayOfTournamentMatchesAs("sumPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sumPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sumPenaltyAway(), true);
    }
    public TournamentRequest<T> avgPenaltyAwayOfTournamentMatches(){
        return avgPenaltyAwayOfTournamentMatchesAs("avgPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> avgPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.avgPenaltyAway(), true);
    }
    public TournamentRequest<T> standardDeviationPenaltyAwayOfTournamentMatches(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatches(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs("stdDevPopPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public TournamentRequest<T> sampleVariancePenaltyAwayOfTournamentMatches(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs("varSampPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public TournamentRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatches(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs("varPopPenaltyAwayOfTournamentMatches");
    }

    public TournamentRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }
    public TournamentRequest<T> minMinuteScoredOfMatchGoals(){
        return minMinuteScoredOfMatchGoalsAs("minMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> minMinuteScoredOfMatchGoalsAs(String name){
        return minMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> minMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.minMinuteScored(), true);
    }
    public TournamentRequest<T> maxMinuteScoredOfMatchGoals(){
        return maxMinuteScoredOfMatchGoalsAs("maxMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> maxMinuteScoredOfMatchGoalsAs(String name){
        return maxMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> maxMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.maxMinuteScored(), true);
    }
    public TournamentRequest<T> sumMinuteScoredOfMatchGoals(){
        return sumMinuteScoredOfMatchGoalsAs("sumMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> sumMinuteScoredOfMatchGoalsAs(String name){
        return sumMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> sumMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sumMinuteScored(), true);
    }
    public TournamentRequest<T> avgMinuteScoredOfMatchGoals(){
        return avgMinuteScoredOfMatchGoalsAs("avgMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> avgMinuteScoredOfMatchGoalsAs(String name){
        return avgMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> avgMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.avgMinuteScored(), true);
    }
    public TournamentRequest<T> standardDeviationMinuteScoredOfMatchGoals(){
        return standardDeviationMinuteScoredOfMatchGoalsAs("stdDevMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return standardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.standardDeviationMinuteScored(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoals(){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs("stdDevPopMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteScored(), true);
    }
    public TournamentRequest<T> sampleVarianceMinuteScoredOfMatchGoals(){
        return sampleVarianceMinuteScoredOfMatchGoalsAs("varSampMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name){
        return sampleVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sampleVarianceMinuteScored(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoals(){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs("varPopMinuteScoredOfMatchGoals");
    }

    public TournamentRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.samplePopulationVarianceMinuteScored(), true);
    }
    public TournamentRequest<T> minMinuteIssuedOfMatchCards(){
        return minMinuteIssuedOfMatchCardsAs("minMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> minMinuteIssuedOfMatchCardsAs(String name){
        return minMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> minMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.minMinuteIssued(), true);
    }
    public TournamentRequest<T> maxMinuteIssuedOfMatchCards(){
        return maxMinuteIssuedOfMatchCardsAs("maxMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> maxMinuteIssuedOfMatchCardsAs(String name){
        return maxMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> maxMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.maxMinuteIssued(), true);
    }
    public TournamentRequest<T> sumMinuteIssuedOfMatchCards(){
        return sumMinuteIssuedOfMatchCardsAs("sumMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> sumMinuteIssuedOfMatchCardsAs(String name){
        return sumMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> sumMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sumMinuteIssued(), true);
    }
    public TournamentRequest<T> avgMinuteIssuedOfMatchCards(){
        return avgMinuteIssuedOfMatchCardsAs("avgMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> avgMinuteIssuedOfMatchCardsAs(String name){
        return avgMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> avgMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.avgMinuteIssued(), true);
    }
    public TournamentRequest<T> standardDeviationMinuteIssuedOfMatchCards(){
        return standardDeviationMinuteIssuedOfMatchCardsAs("stdDevMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return standardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.standardDeviationMinuteIssued(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCards(){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs("stdDevPopMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteIssued(), true);
    }
    public TournamentRequest<T> sampleVarianceMinuteIssuedOfMatchCards(){
        return sampleVarianceMinuteIssuedOfMatchCardsAs("varSampMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name){
        return sampleVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sampleVarianceMinuteIssued(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCards(){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs("varPopMinuteIssuedOfMatchCards");
    }

    public TournamentRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.samplePopulationVarianceMinuteIssued(), true);
    }
    public TournamentRequest<T> minPlayedOfGroupStandings(){
        return minPlayedOfGroupStandingsAs("minPlayedOfGroupStandings");
    }

    public TournamentRequest<T> minPlayedOfGroupStandingsAs(String name){
        return minPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPlayed(), true);
    }
    public TournamentRequest<T> maxPlayedOfGroupStandings(){
        return maxPlayedOfGroupStandingsAs("maxPlayedOfGroupStandings");
    }

    public TournamentRequest<T> maxPlayedOfGroupStandingsAs(String name){
        return maxPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPlayed(), true);
    }
    public TournamentRequest<T> sumPlayedOfGroupStandings(){
        return sumPlayedOfGroupStandingsAs("sumPlayedOfGroupStandings");
    }

    public TournamentRequest<T> sumPlayedOfGroupStandingsAs(String name){
        return sumPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPlayed(), true);
    }
    public TournamentRequest<T> avgPlayedOfGroupStandings(){
        return avgPlayedOfGroupStandingsAs("avgPlayedOfGroupStandings");
    }

    public TournamentRequest<T> avgPlayedOfGroupStandingsAs(String name){
        return avgPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPlayed(), true);
    }
    public TournamentRequest<T> standardDeviationPlayedOfGroupStandings(){
        return standardDeviationPlayedOfGroupStandingsAs("stdDevPlayedOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name){
        return standardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPlayed(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs("stdDevPopPlayedOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPlayed(), true);
    }
    public TournamentRequest<T> sampleVariancePlayedOfGroupStandings(){
        return sampleVariancePlayedOfGroupStandingsAs("varSampPlayedOfGroupStandings");
    }

    public TournamentRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name){
        return sampleVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePlayed(), true);
    }
    public TournamentRequest<T> samplePopulationVariancePlayedOfGroupStandings(){
        return samplePopulationVariancePlayedOfGroupStandingsAs("varPopPlayedOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name){
        return samplePopulationVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePlayed(), true);
    }
    public TournamentRequest<T> minWonOfGroupStandings(){
        return minWonOfGroupStandingsAs("minWonOfGroupStandings");
    }

    public TournamentRequest<T> minWonOfGroupStandingsAs(String name){
        return minWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minWon(), true);
    }
    public TournamentRequest<T> maxWonOfGroupStandings(){
        return maxWonOfGroupStandingsAs("maxWonOfGroupStandings");
    }

    public TournamentRequest<T> maxWonOfGroupStandingsAs(String name){
        return maxWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxWon(), true);
    }
    public TournamentRequest<T> sumWonOfGroupStandings(){
        return sumWonOfGroupStandingsAs("sumWonOfGroupStandings");
    }

    public TournamentRequest<T> sumWonOfGroupStandingsAs(String name){
        return sumWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumWon(), true);
    }
    public TournamentRequest<T> avgWonOfGroupStandings(){
        return avgWonOfGroupStandingsAs("avgWonOfGroupStandings");
    }

    public TournamentRequest<T> avgWonOfGroupStandingsAs(String name){
        return avgWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgWon(), true);
    }
    public TournamentRequest<T> standardDeviationWonOfGroupStandings(){
        return standardDeviationWonOfGroupStandingsAs("stdDevWonOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationWonOfGroupStandingsAs(String name){
        return standardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationWon(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs("stdDevPopWonOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationWon(), true);
    }
    public TournamentRequest<T> sampleVarianceWonOfGroupStandings(){
        return sampleVarianceWonOfGroupStandingsAs("varSampWonOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceWonOfGroupStandingsAs(String name){
        return sampleVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceWon(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceWonOfGroupStandings(){
        return samplePopulationVarianceWonOfGroupStandingsAs("varPopWonOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name){
        return samplePopulationVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceWon(), true);
    }
    public TournamentRequest<T> minDrawnOfGroupStandings(){
        return minDrawnOfGroupStandingsAs("minDrawnOfGroupStandings");
    }

    public TournamentRequest<T> minDrawnOfGroupStandingsAs(String name){
        return minDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minDrawn(), true);
    }
    public TournamentRequest<T> maxDrawnOfGroupStandings(){
        return maxDrawnOfGroupStandingsAs("maxDrawnOfGroupStandings");
    }

    public TournamentRequest<T> maxDrawnOfGroupStandingsAs(String name){
        return maxDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxDrawn(), true);
    }
    public TournamentRequest<T> sumDrawnOfGroupStandings(){
        return sumDrawnOfGroupStandingsAs("sumDrawnOfGroupStandings");
    }

    public TournamentRequest<T> sumDrawnOfGroupStandingsAs(String name){
        return sumDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumDrawn(), true);
    }
    public TournamentRequest<T> avgDrawnOfGroupStandings(){
        return avgDrawnOfGroupStandingsAs("avgDrawnOfGroupStandings");
    }

    public TournamentRequest<T> avgDrawnOfGroupStandingsAs(String name){
        return avgDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgDrawn(), true);
    }
    public TournamentRequest<T> standardDeviationDrawnOfGroupStandings(){
        return standardDeviationDrawnOfGroupStandingsAs("stdDevDrawnOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name){
        return standardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationDrawn(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs("stdDevPopDrawnOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationDrawn(), true);
    }
    public TournamentRequest<T> sampleVarianceDrawnOfGroupStandings(){
        return sampleVarianceDrawnOfGroupStandingsAs("varSampDrawnOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name){
        return sampleVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceDrawn(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceDrawnOfGroupStandings(){
        return samplePopulationVarianceDrawnOfGroupStandingsAs("varPopDrawnOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name){
        return samplePopulationVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceDrawn(), true);
    }
    public TournamentRequest<T> minLostOfGroupStandings(){
        return minLostOfGroupStandingsAs("minLostOfGroupStandings");
    }

    public TournamentRequest<T> minLostOfGroupStandingsAs(String name){
        return minLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minLost(), true);
    }
    public TournamentRequest<T> maxLostOfGroupStandings(){
        return maxLostOfGroupStandingsAs("maxLostOfGroupStandings");
    }

    public TournamentRequest<T> maxLostOfGroupStandingsAs(String name){
        return maxLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxLost(), true);
    }
    public TournamentRequest<T> sumLostOfGroupStandings(){
        return sumLostOfGroupStandingsAs("sumLostOfGroupStandings");
    }

    public TournamentRequest<T> sumLostOfGroupStandingsAs(String name){
        return sumLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumLost(), true);
    }
    public TournamentRequest<T> avgLostOfGroupStandings(){
        return avgLostOfGroupStandingsAs("avgLostOfGroupStandings");
    }

    public TournamentRequest<T> avgLostOfGroupStandingsAs(String name){
        return avgLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgLost(), true);
    }
    public TournamentRequest<T> standardDeviationLostOfGroupStandings(){
        return standardDeviationLostOfGroupStandingsAs("stdDevLostOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationLostOfGroupStandingsAs(String name){
        return standardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationLost(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs("stdDevPopLostOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationLost(), true);
    }
    public TournamentRequest<T> sampleVarianceLostOfGroupStandings(){
        return sampleVarianceLostOfGroupStandingsAs("varSampLostOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceLostOfGroupStandingsAs(String name){
        return sampleVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceLost(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceLostOfGroupStandings(){
        return samplePopulationVarianceLostOfGroupStandingsAs("varPopLostOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name){
        return samplePopulationVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceLost(), true);
    }
    public TournamentRequest<T> minGoalsForOfGroupStandings(){
        return minGoalsForOfGroupStandingsAs("minGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> minGoalsForOfGroupStandingsAs(String name){
        return minGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsFor(), true);
    }
    public TournamentRequest<T> maxGoalsForOfGroupStandings(){
        return maxGoalsForOfGroupStandingsAs("maxGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> maxGoalsForOfGroupStandingsAs(String name){
        return maxGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsFor(), true);
    }
    public TournamentRequest<T> sumGoalsForOfGroupStandings(){
        return sumGoalsForOfGroupStandingsAs("sumGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> sumGoalsForOfGroupStandingsAs(String name){
        return sumGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsFor(), true);
    }
    public TournamentRequest<T> avgGoalsForOfGroupStandings(){
        return avgGoalsForOfGroupStandingsAs("avgGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> avgGoalsForOfGroupStandingsAs(String name){
        return avgGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsFor(), true);
    }
    public TournamentRequest<T> standardDeviationGoalsForOfGroupStandings(){
        return standardDeviationGoalsForOfGroupStandingsAs("stdDevGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name){
        return standardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsFor(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs("stdDevPopGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsFor(), true);
    }
    public TournamentRequest<T> sampleVarianceGoalsForOfGroupStandings(){
        return sampleVarianceGoalsForOfGroupStandingsAs("varSampGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name){
        return sampleVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsFor(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceGoalsForOfGroupStandings(){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs("varPopGoalsForOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsFor(), true);
    }
    public TournamentRequest<T> minGoalsAgainstOfGroupStandings(){
        return minGoalsAgainstOfGroupStandingsAs("minGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> minGoalsAgainstOfGroupStandingsAs(String name){
        return minGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsAgainst(), true);
    }
    public TournamentRequest<T> maxGoalsAgainstOfGroupStandings(){
        return maxGoalsAgainstOfGroupStandingsAs("maxGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name){
        return maxGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsAgainst(), true);
    }
    public TournamentRequest<T> sumGoalsAgainstOfGroupStandings(){
        return sumGoalsAgainstOfGroupStandingsAs("sumGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name){
        return sumGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsAgainst(), true);
    }
    public TournamentRequest<T> avgGoalsAgainstOfGroupStandings(){
        return avgGoalsAgainstOfGroupStandingsAs("avgGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name){
        return avgGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsAgainst(), true);
    }
    public TournamentRequest<T> standardDeviationGoalsAgainstOfGroupStandings(){
        return standardDeviationGoalsAgainstOfGroupStandingsAs("stdDevGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return standardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsAgainst(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs("stdDevPopGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsAgainst(), true);
    }
    public TournamentRequest<T> sampleVarianceGoalsAgainstOfGroupStandings(){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs("varSampGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsAgainst(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandings(){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs("varPopGoalsAgainstOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsAgainst(), true);
    }
    public TournamentRequest<T> minGoalDifferenceOfGroupStandings(){
        return minGoalDifferenceOfGroupStandingsAs("minGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> minGoalDifferenceOfGroupStandingsAs(String name){
        return minGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalDifference(), true);
    }
    public TournamentRequest<T> maxGoalDifferenceOfGroupStandings(){
        return maxGoalDifferenceOfGroupStandingsAs("maxGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name){
        return maxGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalDifference(), true);
    }
    public TournamentRequest<T> sumGoalDifferenceOfGroupStandings(){
        return sumGoalDifferenceOfGroupStandingsAs("sumGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name){
        return sumGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalDifference(), true);
    }
    public TournamentRequest<T> avgGoalDifferenceOfGroupStandings(){
        return avgGoalDifferenceOfGroupStandingsAs("avgGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name){
        return avgGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalDifference(), true);
    }
    public TournamentRequest<T> standardDeviationGoalDifferenceOfGroupStandings(){
        return standardDeviationGoalDifferenceOfGroupStandingsAs("stdDevGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return standardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalDifference(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs("stdDevPopGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalDifference(), true);
    }
    public TournamentRequest<T> sampleVarianceGoalDifferenceOfGroupStandings(){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs("varSampGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalDifference(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandings(){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs("varPopGoalDifferenceOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalDifference(), true);
    }
    public TournamentRequest<T> minPointsOfGroupStandings(){
        return minPointsOfGroupStandingsAs("minPointsOfGroupStandings");
    }

    public TournamentRequest<T> minPointsOfGroupStandingsAs(String name){
        return minPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPoints(), true);
    }
    public TournamentRequest<T> maxPointsOfGroupStandings(){
        return maxPointsOfGroupStandingsAs("maxPointsOfGroupStandings");
    }

    public TournamentRequest<T> maxPointsOfGroupStandingsAs(String name){
        return maxPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPoints(), true);
    }
    public TournamentRequest<T> sumPointsOfGroupStandings(){
        return sumPointsOfGroupStandingsAs("sumPointsOfGroupStandings");
    }

    public TournamentRequest<T> sumPointsOfGroupStandingsAs(String name){
        return sumPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPoints(), true);
    }
    public TournamentRequest<T> avgPointsOfGroupStandings(){
        return avgPointsOfGroupStandingsAs("avgPointsOfGroupStandings");
    }

    public TournamentRequest<T> avgPointsOfGroupStandingsAs(String name){
        return avgPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPoints(), true);
    }
    public TournamentRequest<T> standardDeviationPointsOfGroupStandings(){
        return standardDeviationPointsOfGroupStandingsAs("stdDevPointsOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationPointsOfGroupStandingsAs(String name){
        return standardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPoints(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs("stdDevPopPointsOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPoints(), true);
    }
    public TournamentRequest<T> sampleVariancePointsOfGroupStandings(){
        return sampleVariancePointsOfGroupStandingsAs("varSampPointsOfGroupStandings");
    }

    public TournamentRequest<T> sampleVariancePointsOfGroupStandingsAs(String name){
        return sampleVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePoints(), true);
    }
    public TournamentRequest<T> samplePopulationVariancePointsOfGroupStandings(){
        return samplePopulationVariancePointsOfGroupStandingsAs("varPopPointsOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name){
        return samplePopulationVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePoints(), true);
    }
    public TournamentRequest<T> minStandingRankOfGroupStandings(){
        return minStandingRankOfGroupStandingsAs("minStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> minStandingRankOfGroupStandingsAs(String name){
        return minStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> minStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minStandingRank(), true);
    }
    public TournamentRequest<T> maxStandingRankOfGroupStandings(){
        return maxStandingRankOfGroupStandingsAs("maxStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> maxStandingRankOfGroupStandingsAs(String name){
        return maxStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> maxStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxStandingRank(), true);
    }
    public TournamentRequest<T> sumStandingRankOfGroupStandings(){
        return sumStandingRankOfGroupStandingsAs("sumStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> sumStandingRankOfGroupStandingsAs(String name){
        return sumStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sumStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumStandingRank(), true);
    }
    public TournamentRequest<T> avgStandingRankOfGroupStandings(){
        return avgStandingRankOfGroupStandingsAs("avgStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> avgStandingRankOfGroupStandingsAs(String name){
        return avgStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> avgStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgStandingRank(), true);
    }
    public TournamentRequest<T> standardDeviationStandingRankOfGroupStandings(){
        return standardDeviationStandingRankOfGroupStandingsAs("stdDevStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name){
        return standardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationStandingRank(), true);
    }
    public TournamentRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs("stdDevPopStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationStandingRank(), true);
    }
    public TournamentRequest<T> sampleVarianceStandingRankOfGroupStandings(){
        return sampleVarianceStandingRankOfGroupStandingsAs("varSampStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name){
        return sampleVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceStandingRank(), true);
    }
    public TournamentRequest<T> samplePopulationVarianceStandingRankOfGroupStandings(){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs("varPopStandingRankOfGroupStandings");
    }

    public TournamentRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceStandingRank(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public TournamentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TournamentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TournamentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TournamentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TournamentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}