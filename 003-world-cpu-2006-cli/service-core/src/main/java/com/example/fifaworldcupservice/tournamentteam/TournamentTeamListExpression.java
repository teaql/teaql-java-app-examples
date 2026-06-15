package com.example.fifaworldcupservice.tournamentteam;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TournamentTeamListExpression<T, E, U extends TournamentTeam> extends SmartListExpression<T, E, U> {
    public TournamentTeamListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TournamentTeamListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TournamentTeamExpression<T, U, U> first() {
       return new TournamentTeamExpression(super.first());
    }

    public TournamentTeamExpression<T, U, U> get(int index) {
      return new TournamentTeamExpression(super.get(index));
    }
}