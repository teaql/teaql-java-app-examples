package com.example.fifaworldcupservice.groupstanding;

import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class GroupStandingExpression<T, E, U extends GroupStanding> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public GroupStandingExpression(Expression<T, U> expression){
        super(expression);
    }

    public GroupStandingExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public GroupStandingExpression<T, U, U> updateId(Long id){
        return new GroupStandingExpression(this, $it -> {((GroupStanding)$it).internalSet("id", id); return this;});
     }

     public GroupStandingExpression<T, U, U> save(UserContext userContext){
        return new GroupStandingExpression(this, $it -> ((GroupStanding)$it).auditAs("Saved by Expression").save(userContext));
     }

     public GroupStandingExpression<T, U, U> save(String intent, UserContext userContext){
        return new GroupStandingExpression(this, $it -> ((GroupStanding)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, Integer> getPlayed(){
       return apply(GroupStanding::getPlayed);
    }
    public GroupStandingExpression<T, U, U> updatePlayed(Integer played){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updatePlayed(played));
    }

    public Expression<T, Integer> getWon(){
       return apply(GroupStanding::getWon);
    }
    public GroupStandingExpression<T, U, U> updateWon(Integer won){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateWon(won));
    }

    public Expression<T, Integer> getDrawn(){
       return apply(GroupStanding::getDrawn);
    }
    public GroupStandingExpression<T, U, U> updateDrawn(Integer drawn){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateDrawn(drawn));
    }

    public Expression<T, Integer> getLost(){
       return apply(GroupStanding::getLost);
    }
    public GroupStandingExpression<T, U, U> updateLost(Integer lost){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateLost(lost));
    }

    public Expression<T, Integer> getGoalsFor(){
       return apply(GroupStanding::getGoalsFor);
    }
    public GroupStandingExpression<T, U, U> updateGoalsFor(Integer goalsFor){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateGoalsFor(goalsFor));
    }

    public Expression<T, Integer> getGoalsAgainst(){
       return apply(GroupStanding::getGoalsAgainst);
    }
    public GroupStandingExpression<T, U, U> updateGoalsAgainst(Integer goalsAgainst){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateGoalsAgainst(goalsAgainst));
    }

    public Expression<T, Integer> getGoalDifference(){
       return apply(GroupStanding::getGoalDifference);
    }
    public GroupStandingExpression<T, U, U> updateGoalDifference(Integer goalDifference){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateGoalDifference(goalDifference));
    }

    public Expression<T, Integer> getPoints(){
       return apply(GroupStanding::getPoints);
    }
    public GroupStandingExpression<T, U, U> updatePoints(Integer points){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updatePoints(points));
    }

    public Expression<T, Integer> getStandingRank(){
       return apply(GroupStanding::getStandingRank);
    }
    public GroupStandingExpression<T, U, U> updateStandingRank(Integer standingRank){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateStandingRank(standingRank));
    }

    public TournamentTeamExpression<T, U, TournamentTeam> getTournamentTeam(){
       return new TournamentTeamExpression(this, $it ->  ((GroupStanding)$it).getTournamentTeam());
    }

    public GroupStandingExpression<T, U, U> updateTournamentTeam(TournamentTeam tournamentTeam){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateTournamentTeam(tournamentTeam));
    }

    public MatchGroupExpression<T, U, MatchGroup> getMatchGroup(){
       return new MatchGroupExpression(this, $it ->  ((GroupStanding)$it).getMatchGroup());
    }

    public GroupStandingExpression<T, U, U> updateMatchGroup(MatchGroup matchGroup){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateMatchGroup(matchGroup));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((GroupStanding)$it).getTournament());
    }

    public GroupStandingExpression<T, U, U> updateTournament(Tournament tournament){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(GroupStanding::getCreateTime);
    }
    public GroupStandingExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(GroupStanding::getUpdateTime);
    }
    public GroupStandingExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new GroupStandingExpression(this, $it ->  ((GroupStanding)$it).updateUpdateTime(updateTime));
    }

}