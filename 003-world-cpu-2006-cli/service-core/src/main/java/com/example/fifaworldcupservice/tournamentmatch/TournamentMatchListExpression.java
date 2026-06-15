package com.example.fifaworldcupservice.tournamentmatch;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TournamentMatchListExpression<T, E, U extends TournamentMatch> extends SmartListExpression<T, E, U> {
    public TournamentMatchListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TournamentMatchListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TournamentMatchExpression<T, U, U> first() {
       return new TournamentMatchExpression(super.first());
    }

    public TournamentMatchExpression<T, U, U> get(int index) {
      return new TournamentMatchExpression(super.get(index));
    }
}