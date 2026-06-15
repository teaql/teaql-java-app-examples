package com.example.fifaworldcupservice.cardcategory;

import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardListExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.util.function.Function;

public class CardCategoryExpression<T, E, U extends CardCategory> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CardCategoryExpression(Expression<T, U> expression){
        super(expression);
    }

    public CardCategoryExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CardCategoryExpression<T, U, U> updateId(Long id){
        return new CardCategoryExpression(this, $it -> {((CardCategory)$it).internalSet("id", id); return this;});
     }

     public CardCategoryExpression<T, U, U> save(UserContext userContext){
        return new CardCategoryExpression(this, $it -> ((CardCategory)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CardCategoryExpression<T, U, U> save(String intent, UserContext userContext){
        return new CardCategoryExpression(this, $it -> ((CardCategory)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(CardCategory::getName);
    }
    public CardCategoryExpression<T, U, U> updateName(String name){
       return new CardCategoryExpression(this, $it ->  ((CardCategory)$it).updateName(name));
    }

    public Expression<T, String> getCode(){
       return apply(CardCategory::getCode);
    }
    public CardCategoryExpression<T, U, U> updateCode(String code){
       return new CardCategoryExpression(this, $it ->  ((CardCategory)$it).updateCode(code));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((CardCategory)$it).getTournament());
    }

    public CardCategoryExpression<T, U, U> updateTournament(Tournament tournament){
       return new CardCategoryExpression(this, $it ->  ((CardCategory)$it).updateTournament(tournament));
    }

    public MatchCardListExpression<T, U, MatchCard> getMatchCardList(){
        return new MatchCardListExpression(this, $it ->  ((CardCategory)$it).getMatchCardList());
    }
    public CardCategoryExpression<T, U, U> addMatchCard(MatchCard matchCard){
       return new CardCategoryExpression(this, $it ->  ((CardCategory)$it).addMatchCard(matchCard));
    }
}