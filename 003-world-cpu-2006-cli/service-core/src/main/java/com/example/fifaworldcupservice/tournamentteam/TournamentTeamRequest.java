package com.example.fifaworldcupservice.tournamentteam;

import com.example.fifaworldcupservice.Q;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationRequest;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingRequest;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardRequest;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalRequest;
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

public class TournamentTeamRequest<T extends TournamentTeam> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TournamentTeamRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TournamentTeamRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TournamentTeamRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TournamentTeamRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TournamentTeamRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TournamentTeamRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TournamentTeamRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TournamentTeamRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TournamentTeamRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TournamentTeamRequest<T> matchingAnyOf(TournamentTeamRequest tournamentTeam){
        super.internalMatchAny(tournamentTeam);
        return this;
    }

    public TournamentTeamRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TournamentTeamRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TournamentTeamRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TournamentTeamRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectTeamName().selectTeamCode().selectEmojiFlag().selectFifaRanking().selectManagerName().selectConfederationIdOnly().selectGroupLetter().selectTournamentIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentTeamRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TournamentTeamRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTeamName().selectTeamCode().selectEmojiFlag().selectFifaRanking().selectManagerName().selectConfederation().selectGroupLetter().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TournamentTeamRequest<T> selectChildren(){
        super.selectAny();
        selectTournamentMatchListAsHomeTeam().selectTournamentMatchListAsAwayTeam().selectMatchGoalList().selectMatchCardList().selectGroupStandingList();
        return selectId().selectTeamName().selectTeamCode().selectEmojiFlag().selectFifaRanking().selectManagerName().selectConfederation().selectGroupLetter().selectTournament().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TournamentTeamRequest<T> selectId(){
       selectProperty(TournamentTeam.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectId(){
       unselectProperty(TournamentTeam.ID_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectTeamName(){
       selectProperty(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the teamName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  teamName) to fetch teamName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectTeamName(){
       unselectProperty(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectTeamCode(){
       selectProperty(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }

    /**
     * fill the teamCode with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  teamCode) to fetch teamCode property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectTeamCode(){
       unselectProperty(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectEmojiFlag(){
       selectProperty(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }

    /**
     * fill the emojiFlag with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  emojiFlag) to fetch emojiFlag property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectEmojiFlag(){
       unselectProperty(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectFifaRanking(){
       selectProperty(TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }

    /**
     * fill the fifaRanking with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  fifaRanking) to fetch fifaRanking property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the fifaRanking with customized aggrFunction, TEAQL uses ({aggrFunction}(fifaRanking) AS fifaRanking to fetch fifaRanking property.
     * @param aggrFunction  aggrFunction
     */
    public TournamentTeamRequest<T> selectFifaRanking(AggrFunction aggrFunction){
       selectProperty(TournamentTeam.FIFA_RANKING_PROPERTY, aggrFunction);
       return this;
    }


    public TournamentTeamRequest<T> unselectFifaRanking(){
       unselectProperty(TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectManagerName(){
       selectProperty(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the managerName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  managerName) to fetch managerName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectManagerName(){
       unselectProperty(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectConfederationIdOnly(){
       selectProperty(TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> selectConfederation(){
        return selectConfederationWith(Q.confederations().unlimited().selectSelf());
    }

    public TournamentTeamRequest<T> selectConfederationWith(ConfederationRequest confederation){
       selectProperty(TournamentTeam.CONFEDERATION_PROPERTY);
       enhanceRelation(TournamentTeam.CONFEDERATION_PROPERTY, confederation);
       return this;
    }

    public TournamentTeamRequest<T> unselectConfederation(){
       unselectProperty(TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectGroupLetter(){
       selectProperty(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }

    /**
     * fill the groupLetter with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  groupLetter) to fetch groupLetter property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectGroupLetter(){
       unselectProperty(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectTournamentIdOnly(){
       selectProperty(TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> selectTournament(){
        return selectTournamentWith(Q.tournaments().unlimited().selectSelf());
    }

    public TournamentTeamRequest<T> selectTournamentWith(TournamentRequest tournament){
       selectProperty(TournamentTeam.TOURNAMENT_PROPERTY);
       enhanceRelation(TournamentTeam.TOURNAMENT_PROPERTY, tournament);
       return this;
    }

    public TournamentTeamRequest<T> unselectTournament(){
       unselectProperty(TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectCreateTime(){
       selectProperty(TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectCreateTime(){
       unselectProperty(TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectUpdateTime(){
       selectProperty(TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectUpdateTime(){
       unselectProperty(TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectVersion(){
       selectProperty(TournamentTeam.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TournamentTeamRequest<T> unselectVersion(){
       unselectProperty(TournamentTeam.VERSION_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> selectTournamentMatchListAsHomeTeam(){
       return selectTournamentMatchListAsHomeTeamWith(Q.tournamentMatches().selectSelf());
    }

    public TournamentTeamRequest<T> selectTournamentMatchListAsHomeTeamWith(TournamentMatchRequest tournamentMatchListAsHomeTeam){
       enhanceRelation(TournamentTeam.TOURNAMENT_MATCH_LIST_AS_HOME_TEAM_PROPERTY, tournamentMatchListAsHomeTeam);
       return this;
    }
    public TournamentTeamRequest<T> selectTournamentMatchListAsAwayTeam(){
       return selectTournamentMatchListAsAwayTeamWith(Q.tournamentMatches().selectSelf());
    }

    public TournamentTeamRequest<T> selectTournamentMatchListAsAwayTeamWith(TournamentMatchRequest tournamentMatchListAsAwayTeam){
       enhanceRelation(TournamentTeam.TOURNAMENT_MATCH_LIST_AS_AWAY_TEAM_PROPERTY, tournamentMatchListAsAwayTeam);
       return this;
    }
    public TournamentTeamRequest<T> selectMatchGoalList(){
       return selectMatchGoalListWith(Q.matchGoals().selectSelf());
    }

    public TournamentTeamRequest<T> selectMatchGoalListWith(MatchGoalRequest matchGoalList){
       enhanceRelation(TournamentTeam.MATCH_GOAL_LIST_PROPERTY, matchGoalList);
       return this;
    }
    public TournamentTeamRequest<T> selectMatchCardList(){
       return selectMatchCardListWith(Q.matchCards().selectSelf());
    }

    public TournamentTeamRequest<T> selectMatchCardListWith(MatchCardRequest matchCardList){
       enhanceRelation(TournamentTeam.MATCH_CARD_LIST_PROPERTY, matchCardList);
       return this;
    }
    public TournamentTeamRequest<T> selectGroupStandingList(){
       return selectGroupStandingListWith(Q.groupStandings().selectSelf());
    }

    public TournamentTeamRequest<T> selectGroupStandingListWith(GroupStandingRequest groupStandingList){
       enhanceRelation(TournamentTeam.GROUP_STANDING_LIST_PROPERTY, groupStandingList);
       return this;
    }

    public TournamentTeamRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.ID_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TournamentTeamRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TournamentTeamRequest<T> filterByTeamName(String... teamName){
      if (teamName == null || teamName.length == 0) {
        throw new IllegalArgumentException("filterByTeamName parameter teamName cannot be empty");
      }
      return appendSearchCriteria(createTeamNameCriteria(Operator.EQUAL, (Object[])teamName));
    }

    public TournamentTeamRequest<T> withTeamName(Operator operator, Object... values){
       return appendSearchCriteria(createTeamNameCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withTeamNameIsUnknown(){
       return withTeamName(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withTeamNameIsKnown(){
       return withTeamName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTeamNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.TEAM_NAME_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withTeamNameGreaterThan(String teamName){
       return withTeamName(Operator.GREATER_THAN, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameGreaterThanOrEqualTo(String teamName){
       return withTeamName(Operator.GREATER_THAN_OR_EQUAL, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameLessThan(String teamName){
       return withTeamName(Operator.LESS_THAN, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameLessThanOrEqualTo(String teamName){
       return withTeamName(Operator.LESS_THAN_OR_EQUAL, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameBetween(String startOfTeamName, String endOfTeamName){
       return withTeamName(Operator.BETWEEN, startOfTeamName, endOfTeamName);
    }
    public TournamentTeamRequest<T> withTeamNameStartingWith(String teamName){
       return withTeamName(Operator.BEGIN_WITH, teamName);
    }
    public TournamentTeamRequest<T> withTeamNameContaining(String teamName){
       return withTeamName(Operator.CONTAIN, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameEndingWith(String teamName){
       return withTeamName(Operator.END_WITH, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameIs(String teamName){
       return withTeamName(Operator.EQUAL, teamName);
    }

    public TournamentTeamRequest<T> withTeamNameSoundingLike(String teamName){
       return withTeamName(Operator.SOUNDS_LIKE, teamName);
    }



    public TournamentTeamRequest<T> filterByTeamCode(String... teamCode){
      if (teamCode == null || teamCode.length == 0) {
        throw new IllegalArgumentException("filterByTeamCode parameter teamCode cannot be empty");
      }
      return appendSearchCriteria(createTeamCodeCriteria(Operator.EQUAL, (Object[])teamCode));
    }

    public TournamentTeamRequest<T> withTeamCode(Operator operator, Object... values){
       return appendSearchCriteria(createTeamCodeCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withTeamCodeIsUnknown(){
       return withTeamCode(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withTeamCodeIsKnown(){
       return withTeamCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTeamCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.TEAM_CODE_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withTeamCodeGreaterThan(String teamCode){
       return withTeamCode(Operator.GREATER_THAN, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeGreaterThanOrEqualTo(String teamCode){
       return withTeamCode(Operator.GREATER_THAN_OR_EQUAL, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeLessThan(String teamCode){
       return withTeamCode(Operator.LESS_THAN, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeLessThanOrEqualTo(String teamCode){
       return withTeamCode(Operator.LESS_THAN_OR_EQUAL, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeBetween(String startOfTeamCode, String endOfTeamCode){
       return withTeamCode(Operator.BETWEEN, startOfTeamCode, endOfTeamCode);
    }
    public TournamentTeamRequest<T> withTeamCodeStartingWith(String teamCode){
       return withTeamCode(Operator.BEGIN_WITH, teamCode);
    }
    public TournamentTeamRequest<T> withTeamCodeContaining(String teamCode){
       return withTeamCode(Operator.CONTAIN, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeEndingWith(String teamCode){
       return withTeamCode(Operator.END_WITH, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeIs(String teamCode){
       return withTeamCode(Operator.EQUAL, teamCode);
    }

    public TournamentTeamRequest<T> withTeamCodeSoundingLike(String teamCode){
       return withTeamCode(Operator.SOUNDS_LIKE, teamCode);
    }



    public TournamentTeamRequest<T> filterByEmojiFlag(String... emojiFlag){
      if (emojiFlag == null || emojiFlag.length == 0) {
        throw new IllegalArgumentException("filterByEmojiFlag parameter emojiFlag cannot be empty");
      }
      return appendSearchCriteria(createEmojiFlagCriteria(Operator.EQUAL, (Object[])emojiFlag));
    }

    public TournamentTeamRequest<T> withEmojiFlag(Operator operator, Object... values){
       return appendSearchCriteria(createEmojiFlagCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withEmojiFlagIsUnknown(){
       return withEmojiFlag(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withEmojiFlagIsKnown(){
       return withEmojiFlag(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmojiFlagCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.EMOJI_FLAG_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withEmojiFlagGreaterThan(String emojiFlag){
       return withEmojiFlag(Operator.GREATER_THAN, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagGreaterThanOrEqualTo(String emojiFlag){
       return withEmojiFlag(Operator.GREATER_THAN_OR_EQUAL, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagLessThan(String emojiFlag){
       return withEmojiFlag(Operator.LESS_THAN, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagLessThanOrEqualTo(String emojiFlag){
       return withEmojiFlag(Operator.LESS_THAN_OR_EQUAL, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagBetween(String startOfEmojiFlag, String endOfEmojiFlag){
       return withEmojiFlag(Operator.BETWEEN, startOfEmojiFlag, endOfEmojiFlag);
    }
    public TournamentTeamRequest<T> withEmojiFlagStartingWith(String emojiFlag){
       return withEmojiFlag(Operator.BEGIN_WITH, emojiFlag);
    }
    public TournamentTeamRequest<T> withEmojiFlagContaining(String emojiFlag){
       return withEmojiFlag(Operator.CONTAIN, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagEndingWith(String emojiFlag){
       return withEmojiFlag(Operator.END_WITH, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagIs(String emojiFlag){
       return withEmojiFlag(Operator.EQUAL, emojiFlag);
    }

    public TournamentTeamRequest<T> withEmojiFlagSoundingLike(String emojiFlag){
       return withEmojiFlag(Operator.SOUNDS_LIKE, emojiFlag);
    }



    public TournamentTeamRequest<T> filterByFifaRanking(Integer... fifaRanking){
      if (fifaRanking == null || fifaRanking.length == 0) {
        throw new IllegalArgumentException("filterByFifaRanking parameter fifaRanking cannot be empty");
      }
      return appendSearchCriteria(createFifaRankingCriteria(Operator.EQUAL, (Object[])fifaRanking));
    }

    public TournamentTeamRequest<T> withFifaRanking(Operator operator, Object... values){
       return appendSearchCriteria(createFifaRankingCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withFifaRankingIsUnknown(){
       return withFifaRanking(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withFifaRankingIsKnown(){
       return withFifaRanking(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createFifaRankingCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.FIFA_RANKING_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withFifaRankingGreaterThan(Integer fifaRanking){
       return withFifaRanking(Operator.GREATER_THAN, fifaRanking);
    }

    public TournamentTeamRequest<T> withFifaRankingGreaterThanOrEqualTo(Integer fifaRanking){
       return withFifaRanking(Operator.GREATER_THAN_OR_EQUAL, fifaRanking);
    }

    public TournamentTeamRequest<T> withFifaRankingLessThan(Integer fifaRanking){
       return withFifaRanking(Operator.LESS_THAN, fifaRanking);
    }

    public TournamentTeamRequest<T> withFifaRankingLessThanOrEqualTo(Integer fifaRanking){
       return withFifaRanking(Operator.LESS_THAN_OR_EQUAL, fifaRanking);
    }

    public TournamentTeamRequest<T> withFifaRankingBetween(Integer startOfFifaRanking, Integer endOfFifaRanking){
       return withFifaRanking(Operator.BETWEEN, startOfFifaRanking, endOfFifaRanking);
    }



    public TournamentTeamRequest<T> filterByManagerName(String... managerName){
      if (managerName == null || managerName.length == 0) {
        throw new IllegalArgumentException("filterByManagerName parameter managerName cannot be empty");
      }
      return appendSearchCriteria(createManagerNameCriteria(Operator.EQUAL, (Object[])managerName));
    }

    public TournamentTeamRequest<T> withManagerName(Operator operator, Object... values){
       return appendSearchCriteria(createManagerNameCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withManagerNameIsUnknown(){
       return withManagerName(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withManagerNameIsKnown(){
       return withManagerName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createManagerNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.MANAGER_NAME_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withManagerNameGreaterThan(String managerName){
       return withManagerName(Operator.GREATER_THAN, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameGreaterThanOrEqualTo(String managerName){
       return withManagerName(Operator.GREATER_THAN_OR_EQUAL, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameLessThan(String managerName){
       return withManagerName(Operator.LESS_THAN, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameLessThanOrEqualTo(String managerName){
       return withManagerName(Operator.LESS_THAN_OR_EQUAL, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameBetween(String startOfManagerName, String endOfManagerName){
       return withManagerName(Operator.BETWEEN, startOfManagerName, endOfManagerName);
    }
    public TournamentTeamRequest<T> withManagerNameStartingWith(String managerName){
       return withManagerName(Operator.BEGIN_WITH, managerName);
    }
    public TournamentTeamRequest<T> withManagerNameContaining(String managerName){
       return withManagerName(Operator.CONTAIN, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameEndingWith(String managerName){
       return withManagerName(Operator.END_WITH, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameIs(String managerName){
       return withManagerName(Operator.EQUAL, managerName);
    }

    public TournamentTeamRequest<T> withManagerNameSoundingLike(String managerName){
       return withManagerName(Operator.SOUNDS_LIKE, managerName);
    }



    public TournamentTeamRequest<T> filterByConfederation(Confederation... confederation){
      if (confederation == null || confederation.length == 0) {
        throw new IllegalArgumentException("filterByConfederation parameter confederation cannot be empty");
      }
      return appendSearchCriteria(createConfederationCriteria(Operator.EQUAL, (Object[])confederation));
    }

    public TournamentTeamRequest<T> withConfederation(Operator operator, Object... values){
       return appendSearchCriteria(createConfederationCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withConfederationIsUnknown(){
       return withConfederation(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withConfederationIsKnown(){
       return withConfederation(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createConfederationCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.CONFEDERATION_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> filterByConfederation(Long confederation){
      if(confederation == null){
         return this;
      }
      return withConfederation(Operator.EQUAL, confederation);
    }
    public TournamentTeamRequest<T> withConfederationMatching(ConfederationRequest confederation){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.CONFEDERATION_PROPERTY, confederation, Confederation.ID_PROPERTY));
    }

    public TournamentTeamRequest<T> filterByGroupLetter(String... groupLetter){
      if (groupLetter == null || groupLetter.length == 0) {
        throw new IllegalArgumentException("filterByGroupLetter parameter groupLetter cannot be empty");
      }
      return appendSearchCriteria(createGroupLetterCriteria(Operator.EQUAL, (Object[])groupLetter));
    }

    public TournamentTeamRequest<T> withGroupLetter(Operator operator, Object... values){
       return appendSearchCriteria(createGroupLetterCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withGroupLetterIsUnknown(){
       return withGroupLetter(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withGroupLetterIsKnown(){
       return withGroupLetter(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGroupLetterCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.GROUP_LETTER_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withGroupLetterGreaterThan(String groupLetter){
       return withGroupLetter(Operator.GREATER_THAN, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterGreaterThanOrEqualTo(String groupLetter){
       return withGroupLetter(Operator.GREATER_THAN_OR_EQUAL, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterLessThan(String groupLetter){
       return withGroupLetter(Operator.LESS_THAN, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterLessThanOrEqualTo(String groupLetter){
       return withGroupLetter(Operator.LESS_THAN_OR_EQUAL, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterBetween(String startOfGroupLetter, String endOfGroupLetter){
       return withGroupLetter(Operator.BETWEEN, startOfGroupLetter, endOfGroupLetter);
    }
    public TournamentTeamRequest<T> withGroupLetterStartingWith(String groupLetter){
       return withGroupLetter(Operator.BEGIN_WITH, groupLetter);
    }
    public TournamentTeamRequest<T> withGroupLetterContaining(String groupLetter){
       return withGroupLetter(Operator.CONTAIN, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterEndingWith(String groupLetter){
       return withGroupLetter(Operator.END_WITH, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterIs(String groupLetter){
       return withGroupLetter(Operator.EQUAL, groupLetter);
    }

    public TournamentTeamRequest<T> withGroupLetterSoundingLike(String groupLetter){
       return withGroupLetter(Operator.SOUNDS_LIKE, groupLetter);
    }



    public TournamentTeamRequest<T> filterByTournament(Tournament... tournament){
      if (tournament == null || tournament.length == 0) {
        throw new IllegalArgumentException("filterByTournament parameter tournament cannot be empty");
      }
      return appendSearchCriteria(createTournamentCriteria(Operator.EQUAL, (Object[])tournament));
    }

    public TournamentTeamRequest<T> withTournament(Operator operator, Object... values){
       return appendSearchCriteria(createTournamentCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withTournamentIsUnknown(){
       return withTournament(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withTournamentIsKnown(){
       return withTournament(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTournamentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.TOURNAMENT_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> filterByTournament(Long tournament){
      if(tournament == null){
         return this;
      }
      return withTournament(Operator.EQUAL, tournament);
    }
    public TournamentTeamRequest<T> withTournamentMatching(TournamentRequest tournament){
       return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.TOURNAMENT_PROPERTY, tournament, Tournament.ID_PROPERTY));
    }

    public TournamentTeamRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TournamentTeamRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.CREATE_TIME_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TournamentTeamRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TournamentTeamRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TournamentTeamRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TournamentTeamRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TournamentTeamRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TournamentTeamRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TournamentTeamRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TournamentTeamRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TournamentTeamRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TournamentTeamRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TournamentTeam.VERSION_PROPERTY, operator, values);
    }

    public TournamentTeamRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TournamentTeamRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TournamentTeamRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TournamentTeamRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TournamentTeamRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TournamentTeamRequest<T> withTournamentMatchListAsHomeTeamMatching(TournamentMatchRequest tournamentMatchAsHomeTeamRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, tournamentMatchAsHomeTeamRequest, TournamentMatch.HOME_TEAM_PROPERTY));
    }

    public TournamentTeamRequest<T> withoutTournamentMatchListAsHomeTeamMatching(TournamentMatchRequest tournamentMatchAsHomeTeamRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, tournamentMatchAsHomeTeamRequest, TournamentMatch.HOME_TEAM_PROPERTY)));
    }

    public TournamentTeamRequest<T> haveTournamentMatchesAsHomeTeam(){
        return withTournamentMatchListAsHomeTeamMatching(Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> haveNoTournamentMatchesAsHomeTeam(){
        return withoutTournamentMatchListAsHomeTeamMatching(Q.tournamentMatches().unlimited());
    }
    public TournamentTeamRequest<T> withTournamentMatchListAsAwayTeamMatching(TournamentMatchRequest tournamentMatchAsAwayTeamRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, tournamentMatchAsAwayTeamRequest, TournamentMatch.AWAY_TEAM_PROPERTY));
    }

    public TournamentTeamRequest<T> withoutTournamentMatchListAsAwayTeamMatching(TournamentMatchRequest tournamentMatchAsAwayTeamRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, tournamentMatchAsAwayTeamRequest, TournamentMatch.AWAY_TEAM_PROPERTY)));
    }

    public TournamentTeamRequest<T> haveTournamentMatchesAsAwayTeam(){
        return withTournamentMatchListAsAwayTeamMatching(Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> haveNoTournamentMatchesAsAwayTeam(){
        return withoutTournamentMatchListAsAwayTeamMatching(Q.tournamentMatches().unlimited());
    }
    public TournamentTeamRequest<T> withMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_TEAM_PROPERTY));
    }

    public TournamentTeamRequest<T> withoutMatchGoalListMatching(MatchGoalRequest matchGoalRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, matchGoalRequest, MatchGoal.TOURNAMENT_TEAM_PROPERTY)));
    }

    public TournamentTeamRequest<T> haveMatchGoals(){
        return withMatchGoalListMatching(Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> haveNoMatchGoals(){
        return withoutMatchGoalListMatching(Q.matchGoals().unlimited());
    }
    public TournamentTeamRequest<T> withMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_TEAM_PROPERTY));
    }

    public TournamentTeamRequest<T> withoutMatchCardListMatching(MatchCardRequest matchCardRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, matchCardRequest, MatchCard.TOURNAMENT_TEAM_PROPERTY)));
    }

    public TournamentTeamRequest<T> haveMatchCards(){
        return withMatchCardListMatching(Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> haveNoMatchCards(){
        return withoutMatchCardListMatching(Q.matchCards().unlimited());
    }
    public TournamentTeamRequest<T> withGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, groupStandingRequest, GroupStanding.TOURNAMENT_TEAM_PROPERTY));
    }

    public TournamentTeamRequest<T> withoutGroupStandingListMatching(GroupStandingRequest groupStandingRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(TournamentTeam.ID_PROPERTY, groupStandingRequest, GroupStanding.TOURNAMENT_TEAM_PROPERTY)));
    }

    public TournamentTeamRequest<T> haveGroupStandings(){
        return withGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> haveNoGroupStandings(){
        return withoutGroupStandingListMatching(Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> count(){
        super.count();
        return this;
    }
    public TournamentTeamRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TournamentTeamRequest minFifaRanking(){
        return minFifaRankingAs(prefix("minOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest minFifaRankingAs(String retName){
        super.min(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest maxFifaRanking(){
        return maxFifaRankingAs(prefix("maxOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest maxFifaRankingAs(String retName){
        super.max(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest sumFifaRanking(){
        return sumFifaRankingAs(prefix("sumOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest sumFifaRankingAs(String retName){
        super.sum(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest avgFifaRanking(){
        return avgFifaRankingAs(prefix("avgOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest avgFifaRankingAs(String retName){
        super.avg(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest standardDeviationFifaRanking(){
        return standardDeviationFifaRankingAs(prefix("standardDeviationOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest standardDeviationFifaRankingAs(String retName){
        super.standardDeviation(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest squareRootOfPopulationStandardDeviationFifaRanking(){
        return squareRootOfPopulationStandardDeviationFifaRankingAs(prefix("squareRootOfPopulationStandardDeviationOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest squareRootOfPopulationStandardDeviationFifaRankingAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest sampleVarianceFifaRanking(){
        return sampleVarianceFifaRankingAs(prefix("sampleVarianceOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest sampleVarianceFifaRankingAs(String retName){
        super.sampleVariance(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest samplePopulationVarianceFifaRanking(){
        return samplePopulationVarianceFifaRankingAs(prefix("samplePopulationVarianceOf",TournamentTeam.FIFA_RANKING_PROPERTY));
    }

    public TournamentTeamRequest samplePopulationVarianceFifaRankingAs(String retName){
        super.samplePopulationVariance(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
        return this;
    }
    public TournamentTeamRequest<T> groupByConfederationWithDetails(){
       return groupByConfederationWithDetails(Q.confederations().unlimited());
    }

    public TournamentTeamRequest<T> groupByConfederationWithDetails(ConfederationRequest subRequest){
       aggregate(TournamentTeam.CONFEDERATION_PROPERTY, subRequest);
       return this;
    }


    public TournamentTeamRequest<T> groupByTournamentWithDetails(){
       return groupByTournamentWithDetails(Q.tournaments().unlimited());
    }

    public TournamentTeamRequest<T> groupByTournamentWithDetails(TournamentRequest subRequest){
       aggregate(TournamentTeam.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }




    public TournamentTeamRequest<T> groupByTournamentMatchesAsHomeTeamWithDetails(TournamentMatchRequest subRequest){
       aggregate(TournamentTeam.TOURNAMENT_MATCH_LIST_AS_HOME_TEAM_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByTournamentMatchesAsAwayTeamWithDetails(TournamentMatchRequest subRequest){
       aggregate(TournamentTeam.TOURNAMENT_MATCH_LIST_AS_AWAY_TEAM_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByMatchGoalsWithDetails(MatchGoalRequest subRequest){
       aggregate(TournamentTeam.MATCH_GOAL_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByMatchCardsWithDetails(MatchCardRequest subRequest){
       aggregate(TournamentTeam.MATCH_CARD_LIST_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByGroupStandingsWithDetails(GroupStandingRequest subRequest){
       aggregate(TournamentTeam.GROUP_STANDING_LIST_PROPERTY, subRequest);
       return this;
    }

    public TournamentTeamRequest<T> groupById(){
       groupBy(TournamentTeam.ID_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByIdAs(String retName){
       groupBy(retName, TournamentTeam.ID_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.ID_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamName(){
       groupBy(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamNameAs(String retName){
       groupBy(retName, TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.TEAM_NAME_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamCode(){
       groupBy(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamCodeAs(String retName){
       groupBy(retName, TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTeamCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.TEAM_CODE_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByEmojiFlag(){
       groupBy(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByEmojiFlagAs(String retName){
       groupBy(retName, TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByEmojiFlagWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.EMOJI_FLAG_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByFifaRanking(){
       groupBy(TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByFifaRankingAs(String retName){
       groupBy(retName, TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByFifaRankingWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.FIFA_RANKING_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByManagerName(){
       groupBy(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByManagerNameAs(String retName){
       groupBy(retName, TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByManagerNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.MANAGER_NAME_PROPERTY, function);
       return this;
    }
    public TournamentTeamRequest<T> groupByConfederationWith(ConfederationRequest subRequest){
       groupBy(TournamentTeam.CONFEDERATION_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByConfederation(){
       groupBy(TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByConfederationAs(String retName){
       groupBy(retName, TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByConfederationWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.CONFEDERATION_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByGroupLetter(){
       groupBy(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByGroupLetterAs(String retName){
       groupBy(retName, TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByGroupLetterWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.GROUP_LETTER_PROPERTY, function);
       return this;
    }
    public TournamentTeamRequest<T> groupByTournamentWith(TournamentRequest subRequest){
       groupBy(TournamentTeam.TOURNAMENT_PROPERTY, subRequest);
       return this;
    }
    public TournamentTeamRequest<T> groupByTournament(){
       groupBy(TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTournamentAs(String retName){
       groupBy(retName, TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByTournamentWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.TOURNAMENT_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByCreateTime(){
       groupBy(TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByUpdateTime(){
       groupBy(TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> groupByVersion(){
       groupBy(TournamentTeam.VERSION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TournamentTeam.VERSION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TournamentTeam.VERSION_PROPERTY, function);
       return this;
    }

    public TournamentTeamRequest<T> withConfederationIsAfc(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_AFC);
       return this;
    }


    public TournamentTeamRequest<T> withConfederationIsCaf(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_CAF);
       return this;
    }


    public TournamentTeamRequest<T> withConfederationIsConcacaf(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_CONCACAF);
       return this;
    }


    public TournamentTeamRequest<T> withConfederationIsConmebol(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_CONMEBOL);
       return this;
    }


    public TournamentTeamRequest<T> withConfederationIsOfc(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_OFC);
       return this;
    }


    public TournamentTeamRequest<T> withConfederationIsUefa(){
       filterByConfederation(com.example.fifaworldcupservice.Constants.CONFEDERATION_UEFA);
       return this;
    }




    public TournamentTeamRequest<T> orderByIdAscending(){
       addOrderByAscending(TournamentTeam.ID_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByIdDescending(){
       addOrderByDescending(TournamentTeam.ID_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTeamNameAscending(){
       addOrderByAscending(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTeamNameDescending(){
       addOrderByDescending(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByTeamNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTeamNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentTeam.TEAM_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByTeamCodeAscending(){
       addOrderByAscending(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTeamCodeDescending(){
       addOrderByDescending(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByTeamCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTeamCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentTeam.TEAM_CODE_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByEmojiFlagAscending(){
       addOrderByAscending(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByEmojiFlagDescending(){
       addOrderByDescending(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByEmojiFlagAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByEmojiFlagDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentTeam.EMOJI_FLAG_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByFifaRankingAscending(){
       addOrderByAscending(TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByFifaRankingDescending(){
       addOrderByDescending(TournamentTeam.FIFA_RANKING_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByManagerNameAscending(){
       addOrderByAscending(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByManagerNameDescending(){
       addOrderByDescending(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByManagerNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByManagerNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentTeam.MANAGER_NAME_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByConfederationAscending(){
       addOrderByAscending(TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByConfederationDescending(){
       addOrderByDescending(TournamentTeam.CONFEDERATION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByGroupLetterAscending(){
       addOrderByAscending(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByGroupLetterDescending(){
       addOrderByDescending(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByGroupLetterAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByGroupLetterDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TournamentTeam.GROUP_LETTER_PROPERTY);
       return this;
    }
    public TournamentTeamRequest<T> orderByTournamentAscending(){
       addOrderByAscending(TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByTournamentDescending(){
       addOrderByDescending(TournamentTeam.TOURNAMENT_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(TournamentTeam.CREATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(TournamentTeam.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByVersionAscending(){
       addOrderByAscending(TournamentTeam.VERSION_PROPERTY);
       return this;
    }

    public TournamentTeamRequest<T> orderByVersionDescending(){
       addOrderByDescending(TournamentTeam.VERSION_PROPERTY);
       return this;
    }


    public TournamentTeamRequest<T> statsFromTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest, false);
    }

    public TournamentTeamRequest<T> statsFromTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.HOME_TEAM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentTeamRequest<T> statsFromTournamentMatchesAsHomeTeam(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAsHomeTeamAs(REFINEMENTS, subRequest);
    }
    public TournamentTeamRequest<T> statsFromTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest, false);
    }

    public TournamentTeamRequest<T> statsFromTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TournamentMatch.AWAY_TEAM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentTeamRequest<T> statsFromTournamentMatchesAsAwayTeam(TournamentMatchRequest subRequest){
       return statsFromTournamentMatchesAsAwayTeamAs(REFINEMENTS, subRequest);
    }
    public TournamentTeamRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(name, subRequest, false);
    }

    public TournamentTeamRequest<T> statsFromMatchGoalsAs(String name, MatchGoalRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchGoal.TOURNAMENT_TEAM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentTeamRequest<T> statsFromMatchGoals(MatchGoalRequest subRequest){
       return statsFromMatchGoalsAs(REFINEMENTS, subRequest);
    }
    public TournamentTeamRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest){
       return statsFromMatchCardsAs(name, subRequest, false);
    }

    public TournamentTeamRequest<T> statsFromMatchCardsAs(String name, MatchCardRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(MatchCard.TOURNAMENT_TEAM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentTeamRequest<T> statsFromMatchCards(MatchCardRequest subRequest){
       return statsFromMatchCardsAs(REFINEMENTS, subRequest);
    }
    public TournamentTeamRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(name, subRequest, false);
    }

    public TournamentTeamRequest<T> statsFromGroupStandingsAs(String name, GroupStandingRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(GroupStanding.TOURNAMENT_TEAM_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TournamentTeamRequest<T> statsFromGroupStandings(GroupStandingRequest subRequest){
       return statsFromGroupStandingsAs(REFINEMENTS, subRequest);
    }
    public ConfederationRequest rollUpToConfederation(){
       ConfederationRequest confederation = Q.confederations().unlimited();
       this.withConfederationMatching(confederation)
           .groupByConfederationWith(confederation);
       return confederation;
    }


    public TournamentRequest rollUpToTournament(){
       TournamentRequest tournament = Q.tournaments().unlimited();
       this.withTournamentMatching(tournament)
           .groupByTournamentWith(tournament);
       return tournament;
    }




    public TournamentTeamRequest<T> countTournamentMatchesAsHomeTeam(){
        return countTournamentMatchesAsHomeTeamAs("Count");
    }

    public TournamentTeamRequest<T> countTournamentMatchesAsHomeTeamAs(String name){
        return countTournamentMatchesAsHomeTeamWith(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> countTournamentMatchesAsHomeTeamWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.count(), true);
    }
    public TournamentTeamRequest<T> countTournamentMatchesAsAwayTeam(){
        return countTournamentMatchesAsAwayTeamAs("Count");
    }

    public TournamentTeamRequest<T> countTournamentMatchesAsAwayTeamAs(String name){
        return countTournamentMatchesAsAwayTeamWith(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> countTournamentMatchesAsAwayTeamWith(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.count(), true);
    }
    public TournamentTeamRequest<T> countMatchGoals(){
        return countMatchGoalsAs("Count");
    }

    public TournamentTeamRequest<T> countMatchGoalsAs(String name){
        return countMatchGoalsWith(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> countMatchGoalsWith(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.count(), true);
    }
    public TournamentTeamRequest<T> countMatchCards(){
        return countMatchCardsAs("Count");
    }

    public TournamentTeamRequest<T> countMatchCardsAs(String name){
        return countMatchCardsWith(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> countMatchCardsWith(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.count(), true);
    }
    public TournamentTeamRequest<T> countGroupStandings(){
        return countGroupStandingsAs("Count");
    }

    public TournamentTeamRequest<T> countGroupStandingsAs(String name){
        return countGroupStandingsWith(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> countGroupStandingsWith(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.count(), true);
    }
    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsHomeTeam(){
        return minMatchNumberOfTournamentMatchesAsHomeTeamAs("minMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return minMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minMatchNumber(), true);
    }
    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsHomeTeam(){
        return maxMatchNumberOfTournamentMatchesAsHomeTeamAs("maxMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return maxMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxMatchNumber(), true);
    }
    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsHomeTeam(){
        return sumMatchNumberOfTournamentMatchesAsHomeTeamAs("sumMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return sumMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumMatchNumber(), true);
    }
    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsHomeTeam(){
        return avgMatchNumberOfTournamentMatchesAsHomeTeamAs("avgMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return avgMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgMatchNumber(), true);
    }
    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsHomeTeam(){
        return standardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs("stdDevMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs("stdDevPopMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsHomeTeam(){
        return sampleVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs("varSampMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs("varPopMatchNumberOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsHomeTeam(){
        return minHomeScoreOfTournamentMatchesAsHomeTeamAs("minHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return minHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minHomeScore(), true);
    }
    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsHomeTeam(){
        return maxHomeScoreOfTournamentMatchesAsHomeTeamAs("maxHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return maxHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxHomeScore(), true);
    }
    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsHomeTeam(){
        return sumHomeScoreOfTournamentMatchesAsHomeTeamAs("sumHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return sumHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumHomeScore(), true);
    }
    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsHomeTeam(){
        return avgHomeScoreOfTournamentMatchesAsHomeTeamAs("avgHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return avgHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgHomeScore(), true);
    }
    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsHomeTeam(){
        return standardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs("stdDevHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs("stdDevPopHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsHomeTeam(){
        return sampleVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs("varSampHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs("varPopHomeScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsHomeTeam(){
        return minAwayScoreOfTournamentMatchesAsHomeTeamAs("minAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return minAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minAwayScore(), true);
    }
    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsHomeTeam(){
        return maxAwayScoreOfTournamentMatchesAsHomeTeamAs("maxAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return maxAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxAwayScore(), true);
    }
    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsHomeTeam(){
        return sumAwayScoreOfTournamentMatchesAsHomeTeamAs("sumAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return sumAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumAwayScore(), true);
    }
    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsHomeTeam(){
        return avgAwayScoreOfTournamentMatchesAsHomeTeamAs("avgAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return avgAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgAwayScore(), true);
    }
    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsHomeTeam(){
        return standardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs("stdDevAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs("stdDevPopAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsHomeTeam(){
        return sampleVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs("varSampAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs("varPopAwayScoreOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return minExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("minExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return maxExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("maxExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return sumExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("sumExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return avgExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("avgExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("stdDevExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("stdDevPopExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("varSampExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs("varPopExtraTimeHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return minExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("minExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return maxExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("maxExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return sumExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("sumExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return avgExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("avgExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("stdDevExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("stdDevPopExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("varSampExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs("varPopExtraTimeAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return minPenaltyHomeOfTournamentMatchesAsHomeTeamAs("minPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return minPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return maxPenaltyHomeOfTournamentMatchesAsHomeTeamAs("maxPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return sumPenaltyHomeOfTournamentMatchesAsHomeTeamAs("sumPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return avgPenaltyHomeOfTournamentMatchesAsHomeTeamAs("avgPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs("stdDevPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs("stdDevPopPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs("varSampPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs("varPopPenaltyHomeOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return minPenaltyAwayOfTournamentMatchesAsHomeTeamAs("minPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return minPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.minPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return maxPenaltyAwayOfTournamentMatchesAsHomeTeamAs("maxPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.maxPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return sumPenaltyAwayOfTournamentMatchesAsHomeTeamAs("sumPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sumPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return avgPenaltyAwayOfTournamentMatchesAsHomeTeamAs("avgPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.avgPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs("stdDevPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs("stdDevPopPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs("varSampPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsHomeTeam(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs("varPopPenaltyAwayOfTournamentMatchesAsHomeTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsHomeTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsHomeTeamAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }
    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsAwayTeam(){
        return minMatchNumberOfTournamentMatchesAsAwayTeamAs("minMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return minMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minMatchNumber(), true);
    }
    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsAwayTeam(){
        return maxMatchNumberOfTournamentMatchesAsAwayTeamAs("maxMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return maxMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxMatchNumber(), true);
    }
    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsAwayTeam(){
        return sumMatchNumberOfTournamentMatchesAsAwayTeamAs("sumMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return sumMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumMatchNumber(), true);
    }
    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsAwayTeam(){
        return avgMatchNumberOfTournamentMatchesAsAwayTeamAs("avgMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return avgMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgMatchNumber(), true);
    }
    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsAwayTeam(){
        return standardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs("stdDevMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationMatchNumber(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs("stdDevPopMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationMatchNumber(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsAwayTeam(){
        return sampleVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs("varSampMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVarianceMatchNumber(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs("varPopMatchNumberOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMatchNumberOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVarianceMatchNumber(), true);
    }
    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsAwayTeam(){
        return minHomeScoreOfTournamentMatchesAsAwayTeamAs("minHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return minHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minHomeScore(), true);
    }
    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsAwayTeam(){
        return maxHomeScoreOfTournamentMatchesAsAwayTeamAs("maxHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return maxHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxHomeScore(), true);
    }
    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsAwayTeam(){
        return sumHomeScoreOfTournamentMatchesAsAwayTeamAs("sumHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return sumHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumHomeScore(), true);
    }
    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsAwayTeam(){
        return avgHomeScoreOfTournamentMatchesAsAwayTeamAs("avgHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return avgHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgHomeScore(), true);
    }
    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsAwayTeam(){
        return standardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs("stdDevHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationHomeScore(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs("stdDevPopHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationHomeScore(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsAwayTeam(){
        return sampleVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs("varSampHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVarianceHomeScore(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs("varPopHomeScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceHomeScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVarianceHomeScore(), true);
    }
    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsAwayTeam(){
        return minAwayScoreOfTournamentMatchesAsAwayTeamAs("minAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return minAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minAwayScore(), true);
    }
    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsAwayTeam(){
        return maxAwayScoreOfTournamentMatchesAsAwayTeamAs("maxAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return maxAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxAwayScore(), true);
    }
    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsAwayTeam(){
        return sumAwayScoreOfTournamentMatchesAsAwayTeamAs("sumAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return sumAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumAwayScore(), true);
    }
    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsAwayTeam(){
        return avgAwayScoreOfTournamentMatchesAsAwayTeamAs("avgAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return avgAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgAwayScore(), true);
    }
    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsAwayTeam(){
        return standardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs("stdDevAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationAwayScore(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs("stdDevPopAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationAwayScore(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsAwayTeam(){
        return sampleVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs("varSampAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVarianceAwayScore(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs("varPopAwayScoreOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceAwayScoreOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVarianceAwayScore(), true);
    }
    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return minExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("minExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return minExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return maxExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("maxExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return maxExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return sumExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("sumExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return sumExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return avgExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("avgExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return avgExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("stdDevExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("stdDevPopExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("varSampExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVarianceExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs("varPopExtraTimeHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVarianceExtraTimeHome(), true);
    }
    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return minExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("minExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return minExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return maxExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("maxExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return maxExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return sumExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("sumExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return sumExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return avgExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("avgExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return avgExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("stdDevExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("stdDevPopExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("varSampExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVarianceExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs("varPopExtraTimeAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceExtraTimeAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVarianceExtraTimeAway(), true);
    }
    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return minPenaltyHomeOfTournamentMatchesAsAwayTeamAs("minPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return minPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return maxPenaltyHomeOfTournamentMatchesAsAwayTeamAs("maxPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return maxPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return sumPenaltyHomeOfTournamentMatchesAsAwayTeamAs("sumPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return sumPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return avgPenaltyHomeOfTournamentMatchesAsAwayTeamAs("avgPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return avgPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return standardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs("stdDevPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs("stdDevPopPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyHome(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return sampleVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs("varSampPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVariancePenaltyHome(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs("varPopPenaltyHomeOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyHomeOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVariancePenaltyHome(), true);
    }
    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return minPenaltyAwayOfTournamentMatchesAsAwayTeamAs("minPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return minPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> minPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.minPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return maxPenaltyAwayOfTournamentMatchesAsAwayTeamAs("maxPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return maxPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> maxPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.maxPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return sumPenaltyAwayOfTournamentMatchesAsAwayTeamAs("sumPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return sumPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sumPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sumPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return avgPenaltyAwayOfTournamentMatchesAsAwayTeamAs("avgPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return avgPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> avgPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.avgPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return standardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs("stdDevPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return standardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.standardDeviationPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs("stdDevPopPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.squareRootOfPopulationStandardDeviationPenaltyAway(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return sampleVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs("varSampPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return sampleVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.sampleVariancePenaltyAway(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsAwayTeam(){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs("varPopPenaltyAwayOfTournamentMatchesAsAwayTeam");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name){
        return samplePopulationVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(name, Q.tournamentMatches().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePenaltyAwayOfTournamentMatchesAsAwayTeamAs(String name, TournamentMatchRequest subRequest){
        return statsFromTournamentMatchesAsAwayTeamAs(name, subRequest.samplePopulationVariancePenaltyAway(), true);
    }
    public TournamentTeamRequest<T> minMinuteScoredOfMatchGoals(){
        return minMinuteScoredOfMatchGoalsAs("minMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> minMinuteScoredOfMatchGoalsAs(String name){
        return minMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> minMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.minMinuteScored(), true);
    }
    public TournamentTeamRequest<T> maxMinuteScoredOfMatchGoals(){
        return maxMinuteScoredOfMatchGoalsAs("maxMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> maxMinuteScoredOfMatchGoalsAs(String name){
        return maxMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> maxMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.maxMinuteScored(), true);
    }
    public TournamentTeamRequest<T> sumMinuteScoredOfMatchGoals(){
        return sumMinuteScoredOfMatchGoalsAs("sumMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> sumMinuteScoredOfMatchGoalsAs(String name){
        return sumMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> sumMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sumMinuteScored(), true);
    }
    public TournamentTeamRequest<T> avgMinuteScoredOfMatchGoals(){
        return avgMinuteScoredOfMatchGoalsAs("avgMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> avgMinuteScoredOfMatchGoalsAs(String name){
        return avgMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> avgMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.avgMinuteScored(), true);
    }
    public TournamentTeamRequest<T> standardDeviationMinuteScoredOfMatchGoals(){
        return standardDeviationMinuteScoredOfMatchGoalsAs("stdDevMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return standardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.standardDeviationMinuteScored(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoals(){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs("stdDevPopMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteScored(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceMinuteScoredOfMatchGoals(){
        return sampleVarianceMinuteScoredOfMatchGoalsAs("varSampMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name){
        return sampleVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.sampleVarianceMinuteScored(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoals(){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs("varPopMinuteScoredOfMatchGoals");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name){
        return samplePopulationVarianceMinuteScoredOfMatchGoalsAs(name, Q.matchGoals().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMinuteScoredOfMatchGoalsAs(String name, MatchGoalRequest subRequest){
        return statsFromMatchGoalsAs(name, subRequest.samplePopulationVarianceMinuteScored(), true);
    }
    public TournamentTeamRequest<T> minMinuteIssuedOfMatchCards(){
        return minMinuteIssuedOfMatchCardsAs("minMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> minMinuteIssuedOfMatchCardsAs(String name){
        return minMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> minMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.minMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> maxMinuteIssuedOfMatchCards(){
        return maxMinuteIssuedOfMatchCardsAs("maxMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> maxMinuteIssuedOfMatchCardsAs(String name){
        return maxMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> maxMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.maxMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> sumMinuteIssuedOfMatchCards(){
        return sumMinuteIssuedOfMatchCardsAs("sumMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> sumMinuteIssuedOfMatchCardsAs(String name){
        return sumMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> sumMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sumMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> avgMinuteIssuedOfMatchCards(){
        return avgMinuteIssuedOfMatchCardsAs("avgMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> avgMinuteIssuedOfMatchCardsAs(String name){
        return avgMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> avgMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.avgMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> standardDeviationMinuteIssuedOfMatchCards(){
        return standardDeviationMinuteIssuedOfMatchCardsAs("stdDevMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return standardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.standardDeviationMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCards(){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs("stdDevPopMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name){
        return squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.squareRootOfPopulationStandardDeviationMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceMinuteIssuedOfMatchCards(){
        return sampleVarianceMinuteIssuedOfMatchCardsAs("varSampMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name){
        return sampleVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.sampleVarianceMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCards(){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs("varPopMinuteIssuedOfMatchCards");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name){
        return samplePopulationVarianceMinuteIssuedOfMatchCardsAs(name, Q.matchCards().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceMinuteIssuedOfMatchCardsAs(String name, MatchCardRequest subRequest){
        return statsFromMatchCardsAs(name, subRequest.samplePopulationVarianceMinuteIssued(), true);
    }
    public TournamentTeamRequest<T> minPlayedOfGroupStandings(){
        return minPlayedOfGroupStandingsAs("minPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> minPlayedOfGroupStandingsAs(String name){
        return minPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPlayed(), true);
    }
    public TournamentTeamRequest<T> maxPlayedOfGroupStandings(){
        return maxPlayedOfGroupStandingsAs("maxPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxPlayedOfGroupStandingsAs(String name){
        return maxPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPlayed(), true);
    }
    public TournamentTeamRequest<T> sumPlayedOfGroupStandings(){
        return sumPlayedOfGroupStandingsAs("sumPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumPlayedOfGroupStandingsAs(String name){
        return sumPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPlayed(), true);
    }
    public TournamentTeamRequest<T> avgPlayedOfGroupStandings(){
        return avgPlayedOfGroupStandingsAs("avgPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgPlayedOfGroupStandingsAs(String name){
        return avgPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPlayed(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPlayedOfGroupStandings(){
        return standardDeviationPlayedOfGroupStandingsAs("stdDevPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name){
        return standardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPlayed(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs("stdDevPopPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPlayed(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePlayedOfGroupStandings(){
        return sampleVariancePlayedOfGroupStandingsAs("varSampPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name){
        return sampleVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePlayed(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePlayedOfGroupStandings(){
        return samplePopulationVariancePlayedOfGroupStandingsAs("varPopPlayedOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name){
        return samplePopulationVariancePlayedOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePlayedOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePlayed(), true);
    }
    public TournamentTeamRequest<T> minWonOfGroupStandings(){
        return minWonOfGroupStandingsAs("minWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> minWonOfGroupStandingsAs(String name){
        return minWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minWon(), true);
    }
    public TournamentTeamRequest<T> maxWonOfGroupStandings(){
        return maxWonOfGroupStandingsAs("maxWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxWonOfGroupStandingsAs(String name){
        return maxWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxWon(), true);
    }
    public TournamentTeamRequest<T> sumWonOfGroupStandings(){
        return sumWonOfGroupStandingsAs("sumWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumWonOfGroupStandingsAs(String name){
        return sumWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumWon(), true);
    }
    public TournamentTeamRequest<T> avgWonOfGroupStandings(){
        return avgWonOfGroupStandingsAs("avgWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgWonOfGroupStandingsAs(String name){
        return avgWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgWon(), true);
    }
    public TournamentTeamRequest<T> standardDeviationWonOfGroupStandings(){
        return standardDeviationWonOfGroupStandingsAs("stdDevWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationWonOfGroupStandingsAs(String name){
        return standardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationWon(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs("stdDevPopWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationWon(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceWonOfGroupStandings(){
        return sampleVarianceWonOfGroupStandingsAs("varSampWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceWonOfGroupStandingsAs(String name){
        return sampleVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceWon(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceWonOfGroupStandings(){
        return samplePopulationVarianceWonOfGroupStandingsAs("varPopWonOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name){
        return samplePopulationVarianceWonOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceWonOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceWon(), true);
    }
    public TournamentTeamRequest<T> minDrawnOfGroupStandings(){
        return minDrawnOfGroupStandingsAs("minDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> minDrawnOfGroupStandingsAs(String name){
        return minDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minDrawn(), true);
    }
    public TournamentTeamRequest<T> maxDrawnOfGroupStandings(){
        return maxDrawnOfGroupStandingsAs("maxDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxDrawnOfGroupStandingsAs(String name){
        return maxDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxDrawn(), true);
    }
    public TournamentTeamRequest<T> sumDrawnOfGroupStandings(){
        return sumDrawnOfGroupStandingsAs("sumDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumDrawnOfGroupStandingsAs(String name){
        return sumDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumDrawn(), true);
    }
    public TournamentTeamRequest<T> avgDrawnOfGroupStandings(){
        return avgDrawnOfGroupStandingsAs("avgDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgDrawnOfGroupStandingsAs(String name){
        return avgDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgDrawn(), true);
    }
    public TournamentTeamRequest<T> standardDeviationDrawnOfGroupStandings(){
        return standardDeviationDrawnOfGroupStandingsAs("stdDevDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name){
        return standardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationDrawn(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs("stdDevPopDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationDrawn(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceDrawnOfGroupStandings(){
        return sampleVarianceDrawnOfGroupStandingsAs("varSampDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name){
        return sampleVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceDrawn(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceDrawnOfGroupStandings(){
        return samplePopulationVarianceDrawnOfGroupStandingsAs("varPopDrawnOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name){
        return samplePopulationVarianceDrawnOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceDrawnOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceDrawn(), true);
    }
    public TournamentTeamRequest<T> minLostOfGroupStandings(){
        return minLostOfGroupStandingsAs("minLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> minLostOfGroupStandingsAs(String name){
        return minLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minLost(), true);
    }
    public TournamentTeamRequest<T> maxLostOfGroupStandings(){
        return maxLostOfGroupStandingsAs("maxLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxLostOfGroupStandingsAs(String name){
        return maxLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxLost(), true);
    }
    public TournamentTeamRequest<T> sumLostOfGroupStandings(){
        return sumLostOfGroupStandingsAs("sumLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumLostOfGroupStandingsAs(String name){
        return sumLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumLost(), true);
    }
    public TournamentTeamRequest<T> avgLostOfGroupStandings(){
        return avgLostOfGroupStandingsAs("avgLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgLostOfGroupStandingsAs(String name){
        return avgLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgLost(), true);
    }
    public TournamentTeamRequest<T> standardDeviationLostOfGroupStandings(){
        return standardDeviationLostOfGroupStandingsAs("stdDevLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationLostOfGroupStandingsAs(String name){
        return standardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationLost(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs("stdDevPopLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationLost(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceLostOfGroupStandings(){
        return sampleVarianceLostOfGroupStandingsAs("varSampLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceLostOfGroupStandingsAs(String name){
        return sampleVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceLost(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceLostOfGroupStandings(){
        return samplePopulationVarianceLostOfGroupStandingsAs("varPopLostOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name){
        return samplePopulationVarianceLostOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceLostOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceLost(), true);
    }
    public TournamentTeamRequest<T> minGoalsForOfGroupStandings(){
        return minGoalsForOfGroupStandingsAs("minGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> minGoalsForOfGroupStandingsAs(String name){
        return minGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsFor(), true);
    }
    public TournamentTeamRequest<T> maxGoalsForOfGroupStandings(){
        return maxGoalsForOfGroupStandingsAs("maxGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxGoalsForOfGroupStandingsAs(String name){
        return maxGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsFor(), true);
    }
    public TournamentTeamRequest<T> sumGoalsForOfGroupStandings(){
        return sumGoalsForOfGroupStandingsAs("sumGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumGoalsForOfGroupStandingsAs(String name){
        return sumGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsFor(), true);
    }
    public TournamentTeamRequest<T> avgGoalsForOfGroupStandings(){
        return avgGoalsForOfGroupStandingsAs("avgGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgGoalsForOfGroupStandingsAs(String name){
        return avgGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsFor(), true);
    }
    public TournamentTeamRequest<T> standardDeviationGoalsForOfGroupStandings(){
        return standardDeviationGoalsForOfGroupStandingsAs("stdDevGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name){
        return standardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsFor(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs("stdDevPopGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsFor(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceGoalsForOfGroupStandings(){
        return sampleVarianceGoalsForOfGroupStandingsAs("varSampGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name){
        return sampleVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsFor(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceGoalsForOfGroupStandings(){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs("varPopGoalsForOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsForOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalsForOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsFor(), true);
    }
    public TournamentTeamRequest<T> minGoalsAgainstOfGroupStandings(){
        return minGoalsAgainstOfGroupStandingsAs("minGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> minGoalsAgainstOfGroupStandingsAs(String name){
        return minGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> maxGoalsAgainstOfGroupStandings(){
        return maxGoalsAgainstOfGroupStandingsAs("maxGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name){
        return maxGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> sumGoalsAgainstOfGroupStandings(){
        return sumGoalsAgainstOfGroupStandingsAs("sumGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name){
        return sumGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> avgGoalsAgainstOfGroupStandings(){
        return avgGoalsAgainstOfGroupStandingsAs("avgGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name){
        return avgGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> standardDeviationGoalsAgainstOfGroupStandings(){
        return standardDeviationGoalsAgainstOfGroupStandingsAs("stdDevGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return standardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs("stdDevPopGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceGoalsAgainstOfGroupStandings(){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs("varSampGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return sampleVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandings(){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs("varPopGoalsAgainstOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalsAgainstOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalsAgainst(), true);
    }
    public TournamentTeamRequest<T> minGoalDifferenceOfGroupStandings(){
        return minGoalDifferenceOfGroupStandingsAs("minGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> minGoalDifferenceOfGroupStandingsAs(String name){
        return minGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minGoalDifference(), true);
    }
    public TournamentTeamRequest<T> maxGoalDifferenceOfGroupStandings(){
        return maxGoalDifferenceOfGroupStandingsAs("maxGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name){
        return maxGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxGoalDifference(), true);
    }
    public TournamentTeamRequest<T> sumGoalDifferenceOfGroupStandings(){
        return sumGoalDifferenceOfGroupStandingsAs("sumGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name){
        return sumGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumGoalDifference(), true);
    }
    public TournamentTeamRequest<T> avgGoalDifferenceOfGroupStandings(){
        return avgGoalDifferenceOfGroupStandingsAs("avgGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name){
        return avgGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgGoalDifference(), true);
    }
    public TournamentTeamRequest<T> standardDeviationGoalDifferenceOfGroupStandings(){
        return standardDeviationGoalDifferenceOfGroupStandingsAs("stdDevGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return standardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationGoalDifference(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs("stdDevPopGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationGoalDifference(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceGoalDifferenceOfGroupStandings(){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs("varSampGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return sampleVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceGoalDifference(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandings(){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs("varPopGoalDifferenceOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name){
        return samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceGoalDifferenceOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceGoalDifference(), true);
    }
    public TournamentTeamRequest<T> minPointsOfGroupStandings(){
        return minPointsOfGroupStandingsAs("minPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> minPointsOfGroupStandingsAs(String name){
        return minPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minPoints(), true);
    }
    public TournamentTeamRequest<T> maxPointsOfGroupStandings(){
        return maxPointsOfGroupStandingsAs("maxPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxPointsOfGroupStandingsAs(String name){
        return maxPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxPoints(), true);
    }
    public TournamentTeamRequest<T> sumPointsOfGroupStandings(){
        return sumPointsOfGroupStandingsAs("sumPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumPointsOfGroupStandingsAs(String name){
        return sumPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumPoints(), true);
    }
    public TournamentTeamRequest<T> avgPointsOfGroupStandings(){
        return avgPointsOfGroupStandingsAs("avgPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgPointsOfGroupStandingsAs(String name){
        return avgPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgPoints(), true);
    }
    public TournamentTeamRequest<T> standardDeviationPointsOfGroupStandings(){
        return standardDeviationPointsOfGroupStandingsAs("stdDevPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationPointsOfGroupStandingsAs(String name){
        return standardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationPoints(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs("stdDevPopPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationPointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationPoints(), true);
    }
    public TournamentTeamRequest<T> sampleVariancePointsOfGroupStandings(){
        return sampleVariancePointsOfGroupStandingsAs("varSampPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVariancePointsOfGroupStandingsAs(String name){
        return sampleVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVariancePoints(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVariancePointsOfGroupStandings(){
        return samplePopulationVariancePointsOfGroupStandingsAs("varPopPointsOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name){
        return samplePopulationVariancePointsOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVariancePointsOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVariancePoints(), true);
    }
    public TournamentTeamRequest<T> minStandingRankOfGroupStandings(){
        return minStandingRankOfGroupStandingsAs("minStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> minStandingRankOfGroupStandingsAs(String name){
        return minStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> minStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.minStandingRank(), true);
    }
    public TournamentTeamRequest<T> maxStandingRankOfGroupStandings(){
        return maxStandingRankOfGroupStandingsAs("maxStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> maxStandingRankOfGroupStandingsAs(String name){
        return maxStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> maxStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.maxStandingRank(), true);
    }
    public TournamentTeamRequest<T> sumStandingRankOfGroupStandings(){
        return sumStandingRankOfGroupStandingsAs("sumStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> sumStandingRankOfGroupStandingsAs(String name){
        return sumStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sumStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sumStandingRank(), true);
    }
    public TournamentTeamRequest<T> avgStandingRankOfGroupStandings(){
        return avgStandingRankOfGroupStandingsAs("avgStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> avgStandingRankOfGroupStandingsAs(String name){
        return avgStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> avgStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.avgStandingRank(), true);
    }
    public TournamentTeamRequest<T> standardDeviationStandingRankOfGroupStandings(){
        return standardDeviationStandingRankOfGroupStandingsAs("stdDevStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name){
        return standardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> standardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.standardDeviationStandingRank(), true);
    }
    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandings(){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs("stdDevPopStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name){
        return squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> squareRootOfPopulationStandardDeviationStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.squareRootOfPopulationStandardDeviationStandingRank(), true);
    }
    public TournamentTeamRequest<T> sampleVarianceStandingRankOfGroupStandings(){
        return sampleVarianceStandingRankOfGroupStandingsAs("varSampStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name){
        return sampleVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> sampleVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.sampleVarianceStandingRank(), true);
    }
    public TournamentTeamRequest<T> samplePopulationVarianceStandingRankOfGroupStandings(){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs("varPopStandingRankOfGroupStandings");
    }

    public TournamentTeamRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name){
        return samplePopulationVarianceStandingRankOfGroupStandingsAs(name, Q.groupStandings().unlimited());
    }

    public TournamentTeamRequest<T> samplePopulationVarianceStandingRankOfGroupStandingsAs(String name, GroupStandingRequest subRequest){
        return statsFromGroupStandingsAs(name, subRequest.samplePopulationVarianceStandingRank(), true);
    }

   public TournamentTeamRequest<T> facetByConfederationAs(String facetName, ConfederationRequest confederation){
       return facetByConfederationAs(facetName, confederation, true);
   }

   public TournamentTeamRequest<T> facetByConfederationAs(String facetName, ConfederationRequest confederation, boolean includeAllFacets){
       addFacet(facetName, TournamentTeam.CONFEDERATION_PROPERTY, confederation, includeAllFacets);
       return this;
   }
   public TournamentTeamRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament){
       return facetByTournamentAs(facetName, tournament, true);
   }

   public TournamentTeamRequest<T> facetByTournamentAs(String facetName, TournamentRequest tournament, boolean includeAllFacets){
       addFacet(facetName, TournamentTeam.TOURNAMENT_PROPERTY, tournament, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TournamentTeamRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TournamentTeamRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TournamentTeamRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TournamentTeamRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TournamentTeamRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}