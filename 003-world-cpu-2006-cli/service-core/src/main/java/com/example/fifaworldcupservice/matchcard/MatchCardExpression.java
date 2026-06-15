package com.example.fifaworldcupservice.matchcard;

import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryExpression;
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

public class MatchCardExpression<T, E, U extends MatchCard> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MatchCardExpression(Expression<T, U> expression){
        super(expression);
    }

    public MatchCardExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MatchCardExpression<T, U, U> updateId(Long id){
        return new MatchCardExpression(this, $it -> {((MatchCard)$it).internalSet("id", id); return this;});
     }

     public MatchCardExpression<T, U, U> save(UserContext userContext){
        return new MatchCardExpression(this, $it -> ((MatchCard)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MatchCardExpression<T, U, U> save(String intent, UserContext userContext){
        return new MatchCardExpression(this, $it -> ((MatchCard)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getPlayerName(){
       return apply(MatchCard::getPlayerName);
    }
    public MatchCardExpression<T, U, U> updatePlayerName(String playerName){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updatePlayerName(playerName));
    }

    public Expression<T, Integer> getMinuteIssued(){
       return apply(MatchCard::getMinuteIssued);
    }
    public MatchCardExpression<T, U, U> updateMinuteIssued(Integer minuteIssued){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateMinuteIssued(minuteIssued));
    }

    public TournamentMatchExpression<T, U, TournamentMatch> getTournamentMatch(){
       return new TournamentMatchExpression(this, $it ->  ((MatchCard)$it).getTournamentMatch());
    }

    public MatchCardExpression<T, U, U> updateTournamentMatch(TournamentMatch tournamentMatch){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateTournamentMatch(tournamentMatch));
    }

    public TournamentTeamExpression<T, U, TournamentTeam> getTournamentTeam(){
       return new TournamentTeamExpression(this, $it ->  ((MatchCard)$it).getTournamentTeam());
    }

    public MatchCardExpression<T, U, U> updateTournamentTeam(TournamentTeam tournamentTeam){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateTournamentTeam(tournamentTeam));
    }

    public CardCategoryExpression<T, U, CardCategory> getCardCategory(){
       return new CardCategoryExpression(this, $it ->  ((MatchCard)$it).getCardCategory());
    }

    public MatchCardExpression<T, U, U> updateCardCategoryToYellow(){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateCardCategoryToYellow());
    }
    public MatchCardExpression<T, U, U> updateCardCategoryToRed(){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateCardCategoryToRed());
    }
    public MatchCardExpression<T, U, U> updateCardCategoryToSecondYellow(){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateCardCategoryToSecondYellow());
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((MatchCard)$it).getTournament());
    }

    public MatchCardExpression<T, U, U> updateTournament(Tournament tournament){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(MatchCard::getCreateTime);
    }
    public MatchCardExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(MatchCard::getUpdateTime);
    }
    public MatchCardExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new MatchCardExpression(this, $it ->  ((MatchCard)$it).updateUpdateTime(updateTime));
    }

}