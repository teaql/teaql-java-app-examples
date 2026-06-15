package com.example.fifaworldcupservice.matchcard;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryRequest;
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

public class MatchCardRequest<T extends MatchCard> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public MatchCardRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public MatchCardRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public MatchCardRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public MatchCardRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public MatchCardRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public MatchCardRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public MatchCardRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (MatchCardRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public MatchCardRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public MatchCardRequest<T> matchingAnyOf(MatchCardRequest matchCard){
        super.internalMatchAny(matchCard);
        return this;
    }

    public MatchCardRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public MatchCardRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public MatchCardRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public MatchCardRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectPlayerName().selectMinuteIssued().selectTournamentMatchIdOnly().selectTournamentTeamIdOnly().selectCardCategoryIdOnly().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchCardRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public MatchCardRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectPlayerName().selectMinuteIssued().selectTournamentMatch().selectTournamentTeam().selectCardCategory().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public MatchCardRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectPlayerName().selectMinuteIssued().selectTournamentMatch().selectTournamentTeam().selectCardCategory().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public MatchCardRequest<T> selectId(){
       selectProperty(MatchCard.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchCardRequest<T> unselectId(){
       unselectProperty(MatchCard.ID_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectPlayerName(){
       selectProperty(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the playerName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  playerName) to fetch playerName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchCardRequest<T> unselectPlayerName(){
       unselectProperty(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectMinuteIssued(){
       selectProperty(MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }

    /**
     * fill the minuteIssued with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  minuteIssued) to fetch minuteIssued property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the minuteIssued with customized aggrFunction, TEAQL uses ({aggrFunction}(minuteIssued) AS minuteIssued to fetch minuteIssued property.
     * @param aggrFunction  aggrFunction
     */
    public MatchCardRequest<T> selectMinuteIssued(AggrFunction aggrFunction){
       selectProperty(MatchCard.MINUTE_ISSUED_PROPERTY, aggrFunction);
       return this;
    }


    public MatchCardRequest<T> unselectMinuteIssued(){
       unselectProperty(MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectTournamentMatchIdOnly(){
       selectProperty(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> selectTournamentMatch(){
        return selectTournamentMatchWith(Q.tournamentMatches().unlimited().selectSelf());
    }

    public MatchCardRequest<T> selectTournamentMatchWith(TournamentMatchRequest tournamentMatch){
       selectProperty(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       enhanceRelation(MatchCard.TOURNAMENT_MATCH_PROPERTY, tournamentMatch);
       return this;
    }

    public MatchCardRequest<T> unselectTournamentMatch(){
       unselectProperty(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectTournamentTeamIdOnly(){
       selectProperty(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> selectTournamentTeam(){
        return selectTournamentTeamWith(Q.tournamentTeams().unlimited().selectSelf());
    }

    public MatchCardRequest<T> selectTournamentTeamWith(TournamentTeamRequest tournamentTeam){
       selectProperty(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       enhanceRelation(MatchCard.TOURNAMENT_TEAM_PROPERTY, tournamentTeam);
       return this;
    }

    public MatchCardRequest<T> unselectTournamentTeam(){
       unselectProperty(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectCardCategoryIdOnly(){
       selectProperty(MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> selectCardCategory(){
        return selectCardCategoryWith(Q.cardCategories().unlimited().selectSelf());
    }

    public MatchCardRequest<T> selectCardCategoryWith(CardCategoryRequest cardCategory){
       selectProperty(MatchCard.CARD_CATEGORY_PROPERTY);
       enhanceRelation(MatchCard.CARD_CATEGORY_PROPERTY, cardCategory);
       return this;
    }

    public MatchCardRequest<T> unselectCardCategory(){
       unselectProperty(MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectTournamentIdOnly(){
       selectProperty(MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public MatchCardRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(MatchCard.TOURNAMENT_PROPERTY);
       enhanceRelation(MatchCard.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public MatchCardRequest<T> unselectTournament(){
       unselectProperty(MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectCreateTime(){
       selectProperty(MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchCardRequest<T> unselectCreateTime(){
       unselectProperty(MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectUpdateTime(){
       selectProperty(MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchCardRequest<T> unselectUpdateTime(){
       unselectProperty(MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> selectVersion(){
       selectProperty(MatchCard.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public MatchCardRequest<T> unselectVersion(){
       unselectProperty(MatchCard.VERSION_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.ID_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public MatchCardRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public MatchCardRequest<T> filterByPlayerName(String... playerName){
      if (playerName == null || playerName.length == 0) {
        throw new IllegalArgumentException("filterByPlayerName parameter playerName cannot be empty");
      }
      return appendSearchCriteria(createPlayerNameCriteria(Operator.EQUAL, (Object[])playerName));
    }

    public MatchCardRequest<T> withPlayerName(Operator operator, Object... values){
       return appendSearchCriteria(createPlayerNameCriteria(operator, values));
    }

    public MatchCardRequest<T> withPlayerNameIsUnknown(){
       return withPlayerName(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withPlayerNameIsKnown(){
       return withPlayerName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlayerNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.PLAYER_NAME_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withPlayerNameGreaterThan(String playerName){
       return withPlayerName(Operator.GREATER_THAN, playerName);
    }

    public MatchCardRequest<T> withPlayerNameGreaterThanOrEqualTo(String playerName){
       return withPlayerName(Operator.GREATER_THAN_OR_EQUAL, playerName);
    }

    public MatchCardRequest<T> withPlayerNameLessThan(String playerName){
       return withPlayerName(Operator.LESS_THAN, playerName);
    }

    public MatchCardRequest<T> withPlayerNameLessThanOrEqualTo(String playerName){
       return withPlayerName(Operator.LESS_THAN_OR_EQUAL, playerName);
    }

    public MatchCardRequest<T> withPlayerNameBetween(String startOfPlayerName, String endOfPlayerName){
       return withPlayerName(Operator.BETWEEN, startOfPlayerName, endOfPlayerName);
    }
    public MatchCardRequest<T> withPlayerNameStartingWith(String playerName){
       return withPlayerName(Operator.BEGIN_WITH, playerName);
    }
    public MatchCardRequest<T> withPlayerNameContaining(String playerName){
       return withPlayerName(Operator.CONTAIN, playerName);
    }

    public MatchCardRequest<T> withPlayerNameEndingWith(String playerName){
       return withPlayerName(Operator.END_WITH, playerName);
    }

    public MatchCardRequest<T> withPlayerNameIs(String playerName){
       return withPlayerName(Operator.EQUAL, playerName);
    }

    public MatchCardRequest<T> withPlayerNameSoundingLike(String playerName){
       return withPlayerName(Operator.SOUNDS_LIKE, playerName);
    }



    public MatchCardRequest<T> filterByMinuteIssued(Integer... minuteIssued){
      if (minuteIssued == null || minuteIssued.length == 0) {
        throw new IllegalArgumentException("filterByMinuteIssued parameter minuteIssued cannot be empty");
      }
      return appendSearchCriteria(createMinuteIssuedCriteria(Operator.EQUAL, (Object[])minuteIssued));
    }

    public MatchCardRequest<T> withMinuteIssued(Operator operator, Object... values){
       return appendSearchCriteria(createMinuteIssuedCriteria(operator, values));
    }

    public MatchCardRequest<T> withMinuteIssuedIsUnknown(){
       return withMinuteIssued(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withMinuteIssuedIsKnown(){
       return withMinuteIssued(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMinuteIssuedCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.MINUTE_ISSUED_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withMinuteIssuedGreaterThan(Integer minuteIssued){
       return withMinuteIssued(Operator.GREATER_THAN, minuteIssued);
    }

    public MatchCardRequest<T> withMinuteIssuedGreaterThanOrEqualTo(Integer minuteIssued){
       return withMinuteIssued(Operator.GREATER_THAN_OR_EQUAL, minuteIssued);
    }

    public MatchCardRequest<T> withMinuteIssuedLessThan(Integer minuteIssued){
       return withMinuteIssued(Operator.LESS_THAN, minuteIssued);
    }

    public MatchCardRequest<T> withMinuteIssuedLessThanOrEqualTo(Integer minuteIssued){
       return withMinuteIssued(Operator.LESS_THAN_OR_EQUAL, minuteIssued);
    }

    public MatchCardRequest<T> withMinuteIssuedBetween(Integer startOfMinuteIssued, Integer endOfMinuteIssued){
       return withMinuteIssued(Operator.BETWEEN, startOfMinuteIssued, endOfMinuteIssued);
    }



    public MatchCardRequest<T> filterByTournamentMatch(TournamentMatch... tournamentMatch){
      if (tournamentMatch == null || tournamentMatch.length == 0) {
        throw new IllegalArgumentException("filterByTournamentMatch parameter tournamentMatch cannot be empty");
      }
      return appendSearchCriteria(createTournamentMatchCriteria(Operator.EQUAL, (Object[])tournamentMatch));
    }

    public MatchCardRequest<T> withTournamentMatch(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentMatchCriteria(operator, values));
    }

    public MatchCardRequest<T> withTournamentMatchIsUnknown(){
       return withTournamentMatch(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withTournamentMatchIsKnown(){
       return withTournamentMatch(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentMatchCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.TOURNAMENT_MATCH_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> filterByTournamentMatch(Long tournamentMatch){
      if(tournamentMatch == null){
         return this;
      }
      return withTournamentMatch(Operator.EQUAL, tournamentMatch);
    }
    public MatchCardRequest<T> withTournamentMatchMatching(TournamentMatchRequest tournamentMatch){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchCard.TOURNAMENT_MATCH_PROPERTY, tournamentMatch, TournamentMatch.ID_PROPERTY));
    }

    public MatchCardRequest<T> filterByTournamentTeam(TournamentTeam... tournamentTeam){
      if (tournamentTeam == null || tournamentTeam.length == 0) {
        throw new IllegalArgumentException("filterByTournamentTeam parameter tournamentTeam cannot be empty");
      }
      return appendSearchCriteria(createTournamentTeamCriteria(Operator.EQUAL, (Object[])tournamentTeam));
    }

    public MatchCardRequest<T> withTournamentTeam(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentTeamCriteria(operator, values));
    }

    public MatchCardRequest<T> withTournamentTeamIsUnknown(){
       return withTournamentTeam(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withTournamentTeamIsKnown(){
       return withTournamentTeam(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentTeamCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.TOURNAMENT_TEAM_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> filterByTournamentTeam(Long tournamentTeam){
      if(tournamentTeam == null){
         return this;
      }
      return withTournamentTeam(Operator.EQUAL, tournamentTeam);
    }
    public MatchCardRequest<T> withTournamentTeamMatching(TournamentTeamRequest tournamentTeam){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchCard.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, TournamentTeam.ID_PROPERTY));
    }

    public MatchCardRequest<T> filterByCardCategory(CardCategory... cardCategory){
      if (cardCategory == null || cardCategory.length == 0) {
        throw new IllegalArgumentException("filterByCardCategory parameter cardCategory cannot be empty");
      }
      return appendSearchCriteria(createCardCategoryCriteria(Operator.EQUAL, (Object[])cardCategory));
    }

    public MatchCardRequest<T> withCardCategory(Operator operator, Object... values){
       return appendSearchCriteria(createCardCategoryCriteria(operator, values));
    }

    public MatchCardRequest<T> withCardCategoryIsUnknown(){
       return withCardCategory(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withCardCategoryIsKnown(){
       return withCardCategory(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCardCategoryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.CARD_CATEGORY_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> filterByCardCategory(Long cardCategory){
      if(cardCategory == null){
         return this;
      }
      return withCardCategory(Operator.EQUAL, cardCategory);
    }
    public MatchCardRequest<T> withCardCategoryMatching(CardCategoryRequest cardCategory){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchCard.CARD_CATEGORY_PROPERTY, cardCategory, CardCategory.ID_PROPERTY));
    }

    public MatchCardRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public MatchCardRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public MatchCardRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.TOURNAMENT_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public MatchCardRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(MatchCard.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public MatchCardRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public MatchCardRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public MatchCardRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.CREATE_TIME_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public MatchCardRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public MatchCardRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public MatchCardRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public MatchCardRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public MatchCardRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public MatchCardRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public MatchCardRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.UPDATE_TIME_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public MatchCardRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public MatchCardRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public MatchCardRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public MatchCardRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public MatchCardRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public MatchCardRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(MatchCard.VERSION_PROPERTY, operator, values);
    }

    public MatchCardRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public MatchCardRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public MatchCardRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public MatchCardRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public MatchCardRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public MatchCardRequest<T> count(){
        super.count();
        return this;
    }
    public MatchCardRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public MatchCardRequest minMinuteIssued(){
        return minMinuteIssuedAs(prefix("minOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest minMinuteIssuedAs(String retName){
        super.min(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest maxMinuteIssued(){
        return maxMinuteIssuedAs(prefix("maxOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest maxMinuteIssuedAs(String retName){
        super.max(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest sumMinuteIssued(){
        return sumMinuteIssuedAs(prefix("sumOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest sumMinuteIssuedAs(String retName){
        super.sum(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest avgMinuteIssued(){
        return avgMinuteIssuedAs(prefix("avgOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest avgMinuteIssuedAs(String retName){
        super.avg(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest standardDeviationMinuteIssued(){
        return standardDeviationMinuteIssuedAs(prefix("standardDeviationOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest standardDeviationMinuteIssuedAs(String retName){
        super.standardDeviation(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest squareRootOfPopulationStandardDeviationMinuteIssued(){
        return squareRootOfPopulationStandardDeviationMinuteIssuedAs(prefix("squareRootOfPopulationStandardDeviationOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest squareRootOfPopulationStandardDeviationMinuteIssuedAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest sampleVarianceMinuteIssued(){
        return sampleVarianceMinuteIssuedAs(prefix("sampleVarianceOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest sampleVarianceMinuteIssuedAs(String retName){
        super.sampleVariance(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest samplePopulationVarianceMinuteIssued(){
        return samplePopulationVarianceMinuteIssuedAs(prefix("samplePopulationVarianceOf",MatchCard.MINUTE_ISSUED_PROPERTY));
    }

    public MatchCardRequest samplePopulationVarianceMinuteIssuedAs(String retName){
        super.samplePopulationVariance(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
        return this;
    }
    public MatchCardRequest<T> groupByTournamentMatchWithDetails(){
       return groupByTournamentMatchWithDetails(Q.tournamentMatches().unlimited());
    }

    public MatchCardRequest<T> groupByTournamentMatchWithDetails(TournamentMatchRequest subRequest){
       aggregate(MatchCard.TOURNAMENT_MATCH_PROPERTY, subRequest);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentTeamWithDetails(){
       return groupByTournamentTeamWithDetails(Q.tournamentTeams().unlimited());
    }

    public MatchCardRequest<T> groupByTournamentTeamWithDetails(TournamentTeamRequest subRequest){
       aggregate(MatchCard.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }

    public MatchCardRequest<T> groupByCardCategoryWithDetails(){
       return groupByCardCategoryWithDetails(Q.cardCategories().unlimited());
    }

    public MatchCardRequest<T> groupByCardCategoryWithDetails(CardCategoryRequest subRequest){
       aggregate(MatchCard.CARD_CATEGORY_PROPERTY, subRequest);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public MatchCardRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(MatchCard.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }





    public MatchCardRequest<T> groupById(){
       groupBy(MatchCard.ID_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByIdAs(String retName){
       groupBy(retName, MatchCard.ID_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.ID_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> groupByPlayerName(){
       groupBy(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByPlayerNameAs(String retName){
       groupBy(retName, MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByPlayerNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.PLAYER_NAME_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> groupByMinuteIssued(){
       groupBy(MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByMinuteIssuedAs(String retName){
       groupBy(retName, MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByMinuteIssuedWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.MINUTE_ISSUED_PROPERTY, function);
       return this;
    }
    public MatchCardRequest<T> groupByTournamentMatchWith(TournamentMatchRequest subRequest){
       groupBy(MatchCard.TOURNAMENT_MATCH_PROPERTY, subRequest);
       return this;
    }
    public MatchCardRequest<T> groupByTournamentMatch(){
       groupBy(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentMatchAs(String retName){
       groupBy(retName, MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentMatchWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.TOURNAMENT_MATCH_PROPERTY, function);
       return this;
    }
    public MatchCardRequest<T> groupByTournamentTeamWith(TournamentTeamRequest subRequest){
       groupBy(MatchCard.TOURNAMENT_TEAM_PROPERTY, subRequest);
       return this;
    }
    public MatchCardRequest<T> groupByTournamentTeam(){
       groupBy(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentTeamAs(String retName){
       groupBy(retName, MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentTeamWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.TOURNAMENT_TEAM_PROPERTY, function);
       return this;
    }
    public MatchCardRequest<T> groupByCardCategoryWith(CardCategoryRequest subRequest){
       groupBy(MatchCard.CARD_CATEGORY_PROPERTY, subRequest);
       return this;
    }
    public MatchCardRequest<T> groupByCardCategory(){
       groupBy(MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByCardCategoryAs(String retName){
       groupBy(retName, MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByCardCategoryWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.CARD_CATEGORY_PROPERTY, function);
       return this;
    }
    public MatchCardRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(MatchCard.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public MatchCardRequest<T> groupByTournament(){
       groupBy(MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> groupByCreateTime(){
       groupBy(MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> groupByUpdateTime(){
       groupBy(MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> groupByVersion(){
       groupBy(MatchCard.VERSION_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByVersionAs(String retName){
       groupBy(retName, MatchCard.VERSION_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, MatchCard.VERSION_PROPERTY, function);
       return this;
    }

    public MatchCardRequest<T> withCardCategoryIsYellow(){
       filterByCardCategory(com.example.fifaworldcupservice.Constants.CARD_CATEGORY_YELLOW);
       return this;
    }


    public MatchCardRequest<T> withCardCategoryIsRed(){
       filterByCardCategory(com.example.fifaworldcupservice.Constants.CARD_CATEGORY_RED);
       return this;
    }


    public MatchCardRequest<T> withCardCategoryIsSecondYellow(){
       filterByCardCategory(com.example.fifaworldcupservice.Constants.CARD_CATEGORY_SECOND_YELLOW);
       return this;
    }




    public MatchCardRequest<T> orderByIdAscending(){
       addOrderByAscending(MatchCard.ID_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByIdDescending(){
       addOrderByDescending(MatchCard.ID_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByPlayerNameAscending(){
       addOrderByAscending(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByPlayerNameDescending(){
       addOrderByDescending(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> orderByPlayerNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByPlayerNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(MatchCard.PLAYER_NAME_PROPERTY);
       return this;
    }
    public MatchCardRequest<T> orderByMinuteIssuedAscending(){
       addOrderByAscending(MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByMinuteIssuedDescending(){
       addOrderByDescending(MatchCard.MINUTE_ISSUED_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentMatchAscending(){
       addOrderByAscending(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentMatchDescending(){
       addOrderByDescending(MatchCard.TOURNAMENT_MATCH_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentTeamAscending(){
       addOrderByAscending(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentTeamDescending(){
       addOrderByDescending(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByCardCategoryAscending(){
       addOrderByAscending(MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByCardCategoryDescending(){
       addOrderByDescending(MatchCard.CARD_CATEGORY_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentAscending(){
       addOrderByAscending(MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByTournamentDescending(){
       addOrderByDescending(MatchCard.TOURNAMENT_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(MatchCard.CREATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(MatchCard.UPDATE_TIME_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByVersionAscending(){
       addOrderByAscending(MatchCard.VERSION_PROPERTY);
       return this;
    }

    public MatchCardRequest<T> orderByVersionDescending(){
       addOrderByDescending(MatchCard.VERSION_PROPERTY);
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

    public CardCategoryRequest rollUpToCardCategory(){
       CardCategoryRequest cardCategory = Q.cardCategories().unlimited();
       this.withCardCategoryMatching(cardCategory)
           .groupByCardCategoryWith(cardCategory);
       return cardCategory;
    }

    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }





   public MatchCardRequest<T> facetByTournamentMatchAs(String facetName, TournamentMatchRequest tournamentMatch){
       return facetByTournamentMatchAs(facetName, tournamentMatch, true);
   }

   public MatchCardRequest<T> facetByTournamentMatchAs(String facetName, TournamentMatchRequest tournamentMatch, boolean includeAllFacets){
       addFacet(facetName, MatchCard.TOURNAMENT_MATCH_PROPERTY, tournamentMatch, includeAllFacets);
       return this;
   }
   public MatchCardRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam){
       return facetByTournamentTeamAs(facetName, tournamentTeam, true);
   }

   public MatchCardRequest<T> facetByTournamentTeamAs(String facetName, TournamentTeamRequest tournamentTeam, boolean includeAllFacets){
       addFacet(facetName, MatchCard.TOURNAMENT_TEAM_PROPERTY, tournamentTeam, includeAllFacets);
       return this;
   }
   public MatchCardRequest<T> facetByCardCategoryAs(String facetName, CardCategoryRequest cardCategory){
       return facetByCardCategoryAs(facetName, cardCategory, true);
   }

   public MatchCardRequest<T> facetByCardCategoryAs(String facetName, CardCategoryRequest cardCategory, boolean includeAllFacets){
       addFacet(facetName, MatchCard.CARD_CATEGORY_PROPERTY, cardCategory, includeAllFacets);
       return this;
   }
   public MatchCardRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public MatchCardRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, MatchCard.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public MatchCardRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public MatchCardRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public MatchCardRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public MatchCardRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public MatchCardRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}