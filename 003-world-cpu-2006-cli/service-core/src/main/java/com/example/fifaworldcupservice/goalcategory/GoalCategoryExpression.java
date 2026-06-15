package com.example.fifaworldcupservice.goalcategory;

import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalListExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class GoalCategoryExpression<T, E, U extends GoalCategory> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public GoalCategoryExpression(Expression<T, U> expression){
        super(expression);
    }

    public GoalCategoryExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public GoalCategoryExpression<T, U, U> updateId(Long id){
        return new GoalCategoryExpression(this, $it -> {((GoalCategory)$it).internalSet("id", id); return this;});
     }

     public GoalCategoryExpression<T, U, U> save(UserContext userContext){
        return new GoalCategoryExpression(this, $it -> ((GoalCategory)$it).auditAs("Saved by Expression").save(userContext));
     }

     public GoalCategoryExpression<T, U, U> save(String intent, UserContext userContext){
        return new GoalCategoryExpression(this, $it -> ((GoalCategory)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(GoalCategory::getName);
    }
    public GoalCategoryExpression<T, U, U> updateName(String name){
       return new GoalCategoryExpression(this, $it ->  ((GoalCategory)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(GoalCategory::getCode);
    }
    public GoalCategoryExpression<T, U, U> updateCode(String code){
       return new GoalCategoryExpression(this, $it ->  ((GoalCategory)$it).updateCode(code));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((GoalCategory)$it).getTournament());
    }

    public GoalCategoryExpression<T, U, U> updateTournament(Tournament tournament){
       return new GoalCategoryExpression(this, $it ->  ((GoalCategory)$it).updateTournament(tournament));
    }

    public MatchGoalListExpression<T, U, MatchGoal> getMatchGoalList(){
        return new MatchGoalListExpression(this, $it ->  ((GoalCategory)$it).getMatchGoalList());
    }
    public GoalCategoryExpression<T, U, U> addMatchGoal(MatchGoal matchGoal){
       return new GoalCategoryExpression(this, $it ->  ((GoalCategory)$it).addMatchGoal(matchGoal));
    }
}