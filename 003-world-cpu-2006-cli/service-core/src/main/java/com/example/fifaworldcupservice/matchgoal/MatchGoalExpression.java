package com.example.fifaworldcupservice.matchgoal;

import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class MatchGoalExpression<T, E, U extends MatchGoal> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MatchGoalExpression(Expression<T, U> expression){
        super(expression);
    }

    public MatchGoalExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MatchGoalExpression<T, U, U> updateId(Long id){
        return new MatchGoalExpression(this, $it -> {((MatchGoal)$it).internalSet("id", id); return this;});
     }

     public MatchGoalExpression<T, U, U> save(UserContext userContext){
        return new MatchGoalExpression(this, $it -> ((MatchGoal)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MatchGoalExpression<T, U, U> save(String intent, UserContext userContext){
        return new MatchGoalExpression(this, $it -> ((MatchGoal)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getPlayerName(){
       return apply(MatchGoal::getPlayerName);
    }
    public MatchGoalExpression<T, U, U> updatePlayerName(String playerName){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updatePlayerName(playerName));
    }

    public Expression<T, Integer> getMinuteScored(){
       return apply(MatchGoal::getMinuteScored);
    }
    public MatchGoalExpression<T, U, U> updateMinuteScored(Integer minuteScored){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateMinuteScored(minuteScored));
    }

    public TournamentMatchExpression<T, U, TournamentMatch> getTournamentMatch(){
       return new TournamentMatchExpression(this, $it ->  ((MatchGoal)$it).getTournamentMatch());
    }

    public MatchGoalExpression<T, U, U> updateTournamentMatch(TournamentMatch tournamentMatch){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateTournamentMatch(tournamentMatch));
    }

    public TournamentTeamExpression<T, U, TournamentTeam> getTournamentTeam(){
       return new TournamentTeamExpression(this, $it ->  ((MatchGoal)$it).getTournamentTeam());
    }

    public MatchGoalExpression<T, U, U> updateTournamentTeam(TournamentTeam tournamentTeam){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateTournamentTeam(tournamentTeam));
    }

    public GoalCategoryExpression<T, U, GoalCategory> getGoalCategory(){
       return new GoalCategoryExpression(this, $it ->  ((MatchGoal)$it).getGoalCategory());
    }

    public MatchGoalExpression<T, U, U> updateGoalCategoryToNormal(){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateGoalCategoryToNormal());
    }
    public MatchGoalExpression<T, U, U> updateGoalCategoryToPenalty(){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateGoalCategoryToPenalty());
    }
    public MatchGoalExpression<T, U, U> updateGoalCategoryToOwnGoal(){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateGoalCategoryToOwnGoal());
    }
    public MatchGoalExpression<T, U, U> updateGoalCategoryToFreeKick(){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateGoalCategoryToFreeKick());
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((MatchGoal)$it).getTournament());
    }

    public MatchGoalExpression<T, U, U> updateTournament(Tournament tournament){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(MatchGoal::getCreateTime);
    }
    public MatchGoalExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(MatchGoal::getUpdateTime);
    }
    public MatchGoalExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new MatchGoalExpression(this, $it ->  ((MatchGoal)$it).updateUpdateTime(updateTime));
    }

}