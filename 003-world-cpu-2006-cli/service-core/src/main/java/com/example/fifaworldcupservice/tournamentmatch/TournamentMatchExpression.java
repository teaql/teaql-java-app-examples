package com.example.fifaworldcupservice.tournamentmatch;

import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardListExpression;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalListExpression;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupExpression;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstage.MatchStageExpression;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.matchstatus.MatchStatusExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TournamentMatchExpression<T, E, U extends TournamentMatch> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TournamentMatchExpression(Expression<T, U> expression){
        super(expression);
    }

    public TournamentMatchExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TournamentMatchExpression<T, U, U> updateId(Long id){
        return new TournamentMatchExpression(this, $it -> {((TournamentMatch)$it).internalSet("id", id); return this;});
     }

     public TournamentMatchExpression<T, U, U> save(UserContext userContext){
        return new TournamentMatchExpression(this, $it -> ((TournamentMatch)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TournamentMatchExpression<T, U, U> save(String intent, UserContext userContext){
        return new TournamentMatchExpression(this, $it -> ((TournamentMatch)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, Integer> getMatchNumber(){
       return apply(TournamentMatch::getMatchNumber);
    }
    public TournamentMatchExpression<T, U, U> updateMatchNumber(Integer matchNumber){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchNumber(matchNumber));
    }

    public Expression<T, LocalDate> getMatchDate(){
       return apply(TournamentMatch::getMatchDate);
    }
    public TournamentMatchExpression<T, U, U> updateMatchDate(LocalDate matchDate){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchDate(matchDate));
    }

    public Expression<T, String> getVenueName(){
       return apply(TournamentMatch::getVenueName);
    }
    public TournamentMatchExpression<T, U, U> updateVenueName(String venueName){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateVenueName(venueName));
    }

    public Expression<T, String> getVenueCity(){
       return apply(TournamentMatch::getVenueCity);
    }
    public TournamentMatchExpression<T, U, U> updateVenueCity(String venueCity){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateVenueCity(venueCity));
    }

    public Expression<T, String> getVenueCountry(){
       return apply(TournamentMatch::getVenueCountry);
    }
    public TournamentMatchExpression<T, U, U> updateVenueCountry(String venueCountry){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateVenueCountry(venueCountry));
    }

    public Expression<T, Integer> getHomeScore(){
       return apply(TournamentMatch::getHomeScore);
    }
    public TournamentMatchExpression<T, U, U> updateHomeScore(Integer homeScore){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateHomeScore(homeScore));
    }

    public Expression<T, Integer> getAwayScore(){
       return apply(TournamentMatch::getAwayScore);
    }
    public TournamentMatchExpression<T, U, U> updateAwayScore(Integer awayScore){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateAwayScore(awayScore));
    }

    public Expression<T, Integer> getExtraTimeHome(){
       return apply(TournamentMatch::getExtraTimeHome);
    }
    public TournamentMatchExpression<T, U, U> updateExtraTimeHome(Integer extraTimeHome){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateExtraTimeHome(extraTimeHome));
    }

    public Expression<T, Integer> getExtraTimeAway(){
       return apply(TournamentMatch::getExtraTimeAway);
    }
    public TournamentMatchExpression<T, U, U> updateExtraTimeAway(Integer extraTimeAway){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateExtraTimeAway(extraTimeAway));
    }

    public Expression<T, Integer> getPenaltyHome(){
       return apply(TournamentMatch::getPenaltyHome);
    }
    public TournamentMatchExpression<T, U, U> updatePenaltyHome(Integer penaltyHome){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updatePenaltyHome(penaltyHome));
    }

    public Expression<T, Integer> getPenaltyAway(){
       return apply(TournamentMatch::getPenaltyAway);
    }
    public TournamentMatchExpression<T, U, U> updatePenaltyAway(Integer penaltyAway){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updatePenaltyAway(penaltyAway));
    }

    public TournamentTeamExpression<T, U, TournamentTeam> getHomeTeam(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentMatch)$it).getHomeTeam());
    }

    public TournamentMatchExpression<T, U, U> updateHomeTeam(TournamentTeam homeTeam){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateHomeTeam(homeTeam));
    }

    public TournamentTeamExpression<T, U, TournamentTeam> getAwayTeam(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentMatch)$it).getAwayTeam());
    }

    public TournamentMatchExpression<T, U, U> updateAwayTeam(TournamentTeam awayTeam){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateAwayTeam(awayTeam));
    }

    public MatchStageExpression<T, U, MatchStage> getMatchStage(){
       return new MatchStageExpression(this, $it ->  ((TournamentMatch)$it).getMatchStage());
    }

    public TournamentMatchExpression<T, U, U> updateMatchStageToGroup(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToGroup());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToRoundOf32(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToRoundOf32());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToRoundOf16(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToRoundOf16());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToQuarterFinal(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToQuarterFinal());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToSemiFinal(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToSemiFinal());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToThirdPlace(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToThirdPlace());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStageToFinal(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStageToFinal());
    }

    public MatchGroupExpression<T, U, MatchGroup> getMatchGroup(){
       return new MatchGroupExpression(this, $it ->  ((TournamentMatch)$it).getMatchGroup());
    }

    public TournamentMatchExpression<T, U, U> updateMatchGroup(MatchGroup matchGroup){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchGroup(matchGroup));
    }

    public MatchStatusExpression<T, U, MatchStatus> getMatchStatus(){
       return new MatchStatusExpression(this, $it ->  ((TournamentMatch)$it).getMatchStatus());
    }

    public TournamentMatchExpression<T, U, U> updateMatchStatusToScheduled(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStatusToScheduled());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStatusToLive(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStatusToLive());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStatusToFinished(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStatusToFinished());
    }
    public TournamentMatchExpression<T, U, U> updateMatchStatusToPostponed(){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateMatchStatusToPostponed());
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((TournamentMatch)$it).getTournament());
    }

    public TournamentMatchExpression<T, U, U> updateTournament(Tournament tournament){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(TournamentMatch::getCreateTime);
    }
    public TournamentMatchExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(TournamentMatch::getUpdateTime);
    }
    public TournamentMatchExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).updateUpdateTime(updateTime));
    }

    public MatchGoalListExpression<T, U, MatchGoal> getMatchGoalList(){
        return new MatchGoalListExpression(this, $it ->  ((TournamentMatch)$it).getMatchGoalList());
    }
    public MatchCardListExpression<T, U, MatchCard> getMatchCardList(){
        return new MatchCardListExpression(this, $it ->  ((TournamentMatch)$it).getMatchCardList());
    }
    public TournamentMatchExpression<T, U, U> addMatchGoal(MatchGoal matchGoal){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).addMatchGoal(matchGoal));
    }
    public TournamentMatchExpression<T, U, U> addMatchCard(MatchCard matchCard){
       return new TournamentMatchExpression(this, $it ->  ((TournamentMatch)$it).addMatchCard(matchCard));
    }
}