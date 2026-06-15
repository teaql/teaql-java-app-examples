package com.example.fifaworldcupservice.tournament;

import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryListExpression;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationListExpression;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryListExpression;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingListExpression;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardListExpression;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalListExpression;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupListExpression;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstage.MatchStageListExpression;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.matchstatus.MatchStatusListExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchListExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TournamentExpression<T, E, U extends Tournament> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TournamentExpression(Expression<T, U> expression){
        super(expression);
    }

    public TournamentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TournamentExpression<T, U, U> updateId(Long id){
        return new TournamentExpression(this, $it -> {((Tournament)$it).internalSet("id", id); return this;});
     }

     public TournamentExpression<T, U, U> save(UserContext userContext){
        return new TournamentExpression(this, $it -> ((Tournament)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TournamentExpression<T, U, U> save(String intent, UserContext userContext){
        return new TournamentExpression(this, $it -> ((Tournament)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getTournamentName(){
       return apply(Tournament::getTournamentName);
    }
    public TournamentExpression<T, U, U> updateTournamentName(String tournamentName){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateTournamentName(tournamentName));
    }

    public Expression<T, String> getHostCountries(){
       return apply(Tournament::getHostCountries);
    }
    public TournamentExpression<T, U, U> updateHostCountries(String hostCountries){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateHostCountries(hostCountries));
    }

    public Expression<T, LocalDate> getStartDate(){
       return apply(Tournament::getStartDate);
    }
    public TournamentExpression<T, U, U> updateStartDate(LocalDate startDate){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateStartDate(startDate));
    }

    public Expression<T, LocalDate> getEndDate(){
       return apply(Tournament::getEndDate);
    }
    public TournamentExpression<T, U, U> updateEndDate(LocalDate endDate){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateEndDate(endDate));
    }

    public Expression<T, Integer> getTotalTeams(){
       return apply(Tournament::getTotalTeams);
    }
    public TournamentExpression<T, U, U> updateTotalTeams(Integer totalTeams){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateTotalTeams(totalTeams));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Tournament::getCreateTime);
    }
    public TournamentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Tournament::getUpdateTime);
    }
    public TournamentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).updateUpdateTime(updateTime));
    }

    public MatchStageListExpression<T, U, MatchStage> getMatchStageList(){
        return new MatchStageListExpression(this, $it ->  ((Tournament)$it).getMatchStageList());
    }
    public MatchStatusListExpression<T, U, MatchStatus> getMatchStatusList(){
        return new MatchStatusListExpression(this, $it ->  ((Tournament)$it).getMatchStatusList());
    }
    public GoalCategoryListExpression<T, U, GoalCategory> getGoalCategoryList(){
        return new GoalCategoryListExpression(this, $it ->  ((Tournament)$it).getGoalCategoryList());
    }
    public CardCategoryListExpression<T, U, CardCategory> getCardCategoryList(){
        return new CardCategoryListExpression(this, $it ->  ((Tournament)$it).getCardCategoryList());
    }
    public ConfederationListExpression<T, U, Confederation> getConfederationList(){
        return new ConfederationListExpression(this, $it ->  ((Tournament)$it).getConfederationList());
    }
    public TournamentTeamListExpression<T, U, TournamentTeam> getTournamentTeamList(){
        return new TournamentTeamListExpression(this, $it ->  ((Tournament)$it).getTournamentTeamList());
    }
    public MatchGroupListExpression<T, U, MatchGroup> getMatchGroupList(){
        return new MatchGroupListExpression(this, $it ->  ((Tournament)$it).getMatchGroupList());
    }
    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchList(){
        return new TournamentMatchListExpression(this, $it ->  ((Tournament)$it).getTournamentMatchList());
    }
    public MatchGoalListExpression<T, U, MatchGoal> getMatchGoalList(){
        return new MatchGoalListExpression(this, $it ->  ((Tournament)$it).getMatchGoalList());
    }
    public MatchCardListExpression<T, U, MatchCard> getMatchCardList(){
        return new MatchCardListExpression(this, $it ->  ((Tournament)$it).getMatchCardList());
    }
    public GroupStandingListExpression<T, U, GroupStanding> getGroupStandingList(){
        return new GroupStandingListExpression(this, $it ->  ((Tournament)$it).getGroupStandingList());
    }
    public TournamentExpression<T, U, U> addMatchStage(MatchStage matchStage){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addMatchStage(matchStage));
    }
    public TournamentExpression<T, U, U> addMatchStatus(MatchStatus matchStatus){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addMatchStatus(matchStatus));
    }
    public TournamentExpression<T, U, U> addGoalCategory(GoalCategory goalCategory){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addGoalCategory(goalCategory));
    }
    public TournamentExpression<T, U, U> addCardCategory(CardCategory cardCategory){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addCardCategory(cardCategory));
    }
    public TournamentExpression<T, U, U> addConfederation(Confederation confederation){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addConfederation(confederation));
    }
    public TournamentExpression<T, U, U> addTournamentTeam(TournamentTeam tournamentTeam){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addTournamentTeam(tournamentTeam));
    }
    public TournamentExpression<T, U, U> addMatchGroup(MatchGroup matchGroup){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addMatchGroup(matchGroup));
    }
    public TournamentExpression<T, U, U> addTournamentMatch(TournamentMatch tournamentMatch){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addTournamentMatch(tournamentMatch));
    }
    public TournamentExpression<T, U, U> addMatchGoal(MatchGoal matchGoal){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addMatchGoal(matchGoal));
    }
    public TournamentExpression<T, U, U> addMatchCard(MatchCard matchCard){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addMatchCard(matchCard));
    }
    public TournamentExpression<T, U, U> addGroupStanding(GroupStanding groupStanding){
       return new TournamentExpression(this, $it ->  ((Tournament)$it).addGroupStanding(groupStanding));
    }
}