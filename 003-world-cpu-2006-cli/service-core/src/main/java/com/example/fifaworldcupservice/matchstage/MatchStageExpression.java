package com.example.fifaworldcupservice.matchstage;

import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class MatchStageExpression<T, E, U extends MatchStage> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MatchStageExpression(Expression<T, U> expression){
        super(expression);
    }

    public MatchStageExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MatchStageExpression<T, U, U> updateId(Long id){
        return new MatchStageExpression(this, $it -> {((MatchStage)$it).internalSet("id", id); return this;});
     }

     public MatchStageExpression<T, U, U> save(UserContext userContext){
        return new MatchStageExpression(this, $it -> ((MatchStage)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MatchStageExpression<T, U, U> save(String intent, UserContext userContext){
        return new MatchStageExpression(this, $it -> ((MatchStage)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(MatchStage::getName);
    }
    public MatchStageExpression<T, U, U> updateName(String name){
       return new MatchStageExpression(this, $it ->  ((MatchStage)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(MatchStage::getCode);
    }
    public MatchStageExpression<T, U, U> updateCode(String code){
       return new MatchStageExpression(this, $it ->  ((MatchStage)$it).updateCode(code));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((MatchStage)$it).getTournament());
    }

    public MatchStageExpression<T, U, U> updateTournament(Tournament tournament){
       return new MatchStageExpression(this, $it ->  ((MatchStage)$it).updateTournament(tournament));
    }

    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchList(){
        return new TournamentMatchListExpression(this, $it ->  ((MatchStage)$it).getTournamentMatchList());
    }
    public MatchStageExpression<T, U, U> addTournamentMatch(TournamentMatch tournamentMatch){
       return new MatchStageExpression(this, $it ->  ((MatchStage)$it).addTournamentMatch(tournamentMatch));
    }
}