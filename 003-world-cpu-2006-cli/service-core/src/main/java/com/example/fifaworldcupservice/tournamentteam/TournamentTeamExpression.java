package com.example.fifaworldcupservice.tournamentteam;

import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationExpression;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingListExpression;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardListExpression;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalListExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TournamentTeamExpression<T, E, U extends TournamentTeam> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TournamentTeamExpression(Expression<T, U> expression){
        super(expression);
    }

    public TournamentTeamExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TournamentTeamExpression<T, U, U> updateId(Long id){
        return new TournamentTeamExpression(this, $it -> {((TournamentTeam)$it).internalSet("id", id); return this;});
     }

     public TournamentTeamExpression<T, U, U> save(UserContext userContext){
        return new TournamentTeamExpression(this, $it -> ((TournamentTeam)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TournamentTeamExpression<T, U, U> save(String intent, UserContext userContext){
        return new TournamentTeamExpression(this, $it -> ((TournamentTeam)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getTeamName(){
       return apply(TournamentTeam::getTeamName);
    }
    public TournamentTeamExpression<T, U, U> updateTeamName(String teamName){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateTeamName(teamName));
    }

    public Expression<T, String> getTeamCode(){
       return apply(TournamentTeam::getTeamCode);
    }
    public TournamentTeamExpression<T, U, U> updateTeamCode(String teamCode){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateTeamCode(teamCode));
    }

    public Expression<T, String> getEmojiFlag(){
       return apply(TournamentTeam::getEmojiFlag);
    }
    public TournamentTeamExpression<T, U, U> updateEmojiFlag(String emojiFlag){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateEmojiFlag(emojiFlag));
    }

    public Expression<T, Integer> getFifaRanking(){
       return apply(TournamentTeam::getFifaRanking);
    }
    public TournamentTeamExpression<T, U, U> updateFifaRanking(Integer fifaRanking){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateFifaRanking(fifaRanking));
    }

    public Expression<T, String> getManagerName(){
       return apply(TournamentTeam::getManagerName);
    }
    public TournamentTeamExpression<T, U, U> updateManagerName(String managerName){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateManagerName(managerName));
    }

    public ConfederationExpression<T, U, Confederation> getConfederation(){
       return new ConfederationExpression(this, $it ->  ((TournamentTeam)$it).getConfederation());
    }

    public TournamentTeamExpression<T, U, U> updateConfederationToAfc(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToAfc());
    }
    public TournamentTeamExpression<T, U, U> updateConfederationToCaf(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToCaf());
    }
    public TournamentTeamExpression<T, U, U> updateConfederationToConcacaf(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToConcacaf());
    }
    public TournamentTeamExpression<T, U, U> updateConfederationToConmebol(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToConmebol());
    }
    public TournamentTeamExpression<T, U, U> updateConfederationToOfc(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToOfc());
    }
    public TournamentTeamExpression<T, U, U> updateConfederationToUefa(){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateConfederationToUefa());
    }

    public Expression<T, String> getGroupLetter(){
       return apply(TournamentTeam::getGroupLetter);
    }
    public TournamentTeamExpression<T, U, U> updateGroupLetter(String groupLetter){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateGroupLetter(groupLetter));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((TournamentTeam)$it).getTournament());
    }

    public TournamentTeamExpression<T, U, U> updateTournament(Tournament tournament){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(TournamentTeam::getCreateTime);
    }
    public TournamentTeamExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(TournamentTeam::getUpdateTime);
    }
    public TournamentTeamExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).updateUpdateTime(updateTime));
    }

    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchListAsHomeTeam(){
        return new TournamentMatchListExpression(this, $it ->  ((TournamentTeam)$it).getTournamentMatchListAsHomeTeam());
    }
    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchListAsAwayTeam(){
        return new TournamentMatchListExpression(this, $it ->  ((TournamentTeam)$it).getTournamentMatchListAsAwayTeam());
    }
    public MatchGoalListExpression<T, U, MatchGoal> getMatchGoalList(){
        return new MatchGoalListExpression(this, $it ->  ((TournamentTeam)$it).getMatchGoalList());
    }
    public MatchCardListExpression<T, U, MatchCard> getMatchCardList(){
        return new MatchCardListExpression(this, $it ->  ((TournamentTeam)$it).getMatchCardList());
    }
    public GroupStandingListExpression<T, U, GroupStanding> getGroupStandingList(){
        return new GroupStandingListExpression(this, $it ->  ((TournamentTeam)$it).getGroupStandingList());
    }
    public TournamentTeamExpression<T, U, U> addTournamentMatchAsHomeTeam(TournamentMatch tournamentMatch){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).addTournamentMatchAsHomeTeam(tournamentMatch));
    }
    public TournamentTeamExpression<T, U, U> addTournamentMatchAsAwayTeam(TournamentMatch tournamentMatch){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).addTournamentMatchAsAwayTeam(tournamentMatch));
    }
    public TournamentTeamExpression<T, U, U> addMatchGoal(MatchGoal matchGoal){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).addMatchGoal(matchGoal));
    }
    public TournamentTeamExpression<T, U, U> addMatchCard(MatchCard matchCard){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).addMatchCard(matchCard));
    }
    public TournamentTeamExpression<T, U, U> addGroupStanding(GroupStanding groupStanding){
       return new TournamentTeamExpression(this, $it ->  ((TournamentTeam)$it).addGroupStanding(groupStanding));
    }
}