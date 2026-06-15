package com.example.fifaworldcupservice.matchstatus;

import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class MatchStatusExpression<T, E, U extends MatchStatus> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MatchStatusExpression(Expression<T, U> expression){
        super(expression);
    }

    public MatchStatusExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MatchStatusExpression<T, U, U> updateId(Long id){
        return new MatchStatusExpression(this, $it -> {((MatchStatus)$it).internalSet("id", id); return this;});
     }

     public MatchStatusExpression<T, U, U> save(UserContext userContext){
        return new MatchStatusExpression(this, $it -> ((MatchStatus)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MatchStatusExpression<T, U, U> save(String intent, UserContext userContext){
        return new MatchStatusExpression(this, $it -> ((MatchStatus)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(MatchStatus::getName);
    }
    public MatchStatusExpression<T, U, U> updateName(String name){
       return new MatchStatusExpression(this, $it ->  ((MatchStatus)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(MatchStatus::getCode);
    }
    public MatchStatusExpression<T, U, U> updateCode(String code){
       return new MatchStatusExpression(this, $it ->  ((MatchStatus)$it).updateCode(code));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((MatchStatus)$it).getTournament());
    }

    public MatchStatusExpression<T, U, U> updateTournament(Tournament tournament){
       return new MatchStatusExpression(this, $it ->  ((MatchStatus)$it).updateTournament(tournament));
    }

    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchList(){
        return new TournamentMatchListExpression(this, $it ->  ((MatchStatus)$it).getTournamentMatchList());
    }
    public MatchStatusExpression<T, U, U> addTournamentMatch(TournamentMatch tournamentMatch){
       return new MatchStatusExpression(this, $it ->  ((MatchStatus)$it).addTournamentMatch(tournamentMatch));
    }
}