package com.example.fifaworldcupservice.confederation;

import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class ConfederationExpression<T, E, U extends Confederation> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ConfederationExpression(Expression<T, U> expression){
        super(expression);
    }

    public ConfederationExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ConfederationExpression<T, U, U> updateId(Long id){
        return new ConfederationExpression(this, $it -> {((Confederation)$it).internalSet("id", id); return this;});
     }

     public ConfederationExpression<T, U, U> save(UserContext userContext){
        return new ConfederationExpression(this, $it -> ((Confederation)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ConfederationExpression<T, U, U> save(String intent, UserContext userContext){
        return new ConfederationExpression(this, $it -> ((Confederation)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Confederation::getName);
    }
    public ConfederationExpression<T, U, U> updateName(String name){
       return new ConfederationExpression(this, $it ->  ((Confederation)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(Confederation::getCode);
    }
    public ConfederationExpression<T, U, U> updateCode(String code){
       return new ConfederationExpression(this, $it ->  ((Confederation)$it).updateCode(code));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((Confederation)$it).getTournament());
    }

    public ConfederationExpression<T, U, U> updateTournament(Tournament tournament){
       return new ConfederationExpression(this, $it ->  ((Confederation)$it).updateTournament(tournament));
    }

    public TournamentTeamListExpression<T, U, TournamentTeam> getTournamentTeamList(){
        return new TournamentTeamListExpression(this, $it ->  ((Confederation)$it).getTournamentTeamList());
    }
    public ConfederationExpression<T, U, U> addTournamentTeam(TournamentTeam tournamentTeam){
       return new ConfederationExpression(this, $it ->  ((Confederation)$it).addTournamentTeam(tournamentTeam));
    }
}