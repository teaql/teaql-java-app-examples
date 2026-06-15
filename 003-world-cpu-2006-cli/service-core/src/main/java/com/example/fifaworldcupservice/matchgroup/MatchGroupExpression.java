package com.example.fifaworldcupservice.matchgroup;

import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingListExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class MatchGroupExpression<T, E, U extends MatchGroup> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public MatchGroupExpression(Expression<T, U> expression){
        super(expression);
    }

    public MatchGroupExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public MatchGroupExpression<T, U, U> updateId(Long id){
        return new MatchGroupExpression(this, $it -> {((MatchGroup)$it).internalSet("id", id); return this;});
     }

     public MatchGroupExpression<T, U, U> save(UserContext userContext){
        return new MatchGroupExpression(this, $it -> ((MatchGroup)$it).auditAs("Saved by Expression").save(userContext));
     }

     public MatchGroupExpression<T, U, U> save(String intent, UserContext userContext){
        return new MatchGroupExpression(this, $it -> ((MatchGroup)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getGroupLetter(){
       return apply(MatchGroup::getGroupLetter);
    }
    public MatchGroupExpression<T, U, U> updateGroupLetter(String groupLetter){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).updateGroupLetter(groupLetter));
    }

    public TournamentExpression<T, U, Tournament> getTournament(){
       return new TournamentExpression(this, $it ->  ((MatchGroup)$it).getTournament());
    }

    public MatchGroupExpression<T, U, U> updateTournament(Tournament tournament){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).updateTournament(tournament));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(MatchGroup::getCreateTime);
    }
    public MatchGroupExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(MatchGroup::getUpdateTime);
    }
    public MatchGroupExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).updateUpdateTime(updateTime));
    }

    public TournamentMatchListExpression<T, U, TournamentMatch> getTournamentMatchList(){
        return new TournamentMatchListExpression(this, $it ->  ((MatchGroup)$it).getTournamentMatchList());
    }
    public GroupStandingListExpression<T, U, GroupStanding> getGroupStandingList(){
        return new GroupStandingListExpression(this, $it ->  ((MatchGroup)$it).getGroupStandingList());
    }
    public MatchGroupExpression<T, U, U> addTournamentMatch(TournamentMatch tournamentMatch){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).addTournamentMatch(tournamentMatch));
    }
    public MatchGroupExpression<T, U, U> addGroupStanding(GroupStanding groupStanding){
       return new MatchGroupExpression(this, $it ->  ((MatchGroup)$it).addGroupStanding(groupStanding));
    }
}