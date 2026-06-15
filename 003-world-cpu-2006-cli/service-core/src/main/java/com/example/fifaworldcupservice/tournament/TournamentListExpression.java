package com.example.fifaworldcupservice.tournament;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TournamentListExpression<T, E, U extends Tournament> extends SmartListExpression<T, E, U> {
    public TournamentListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TournamentListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TournamentExpression<T, U, U> first() {
       return new TournamentExpression(super.first());
    }

    public TournamentExpression<T, U, U> get(int index) {
      return new TournamentExpression(super.get(index));
    }
}