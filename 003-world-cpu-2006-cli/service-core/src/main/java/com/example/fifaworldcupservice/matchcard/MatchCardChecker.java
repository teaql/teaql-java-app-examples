package com.example.fifaworldcupservice.matchcard;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class MatchCardChecker implements Checker<MatchCard>{

    public String type(){
        return MatchCard.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MatchCard matchCard, ObjectLocation _parentLocation){
        if(needCheck(_ctx, matchCard)){
            markAsChecked(_ctx, matchCard);
            doCheck(_ctx, matchCard, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MatchCard matchCard, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(matchCard)){
         return;
      }
      if(matchCard.newItem()){
        if(matchCard.getCreateTime() == null){
           matchCard.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(matchCard.getUpdateTime() == null){
           matchCard.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(matchCard.updateItem()){
        matchCard.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkPlayerName(_ctx, matchCard.getProperty(MatchCard.PLAYER_NAME_PROPERTY), newLocation(_parentLocation, MatchCard.PLAYER_NAME_PROPERTY));
      checkMinuteIssued(_ctx, matchCard.getProperty(MatchCard.MINUTE_ISSUED_PROPERTY), newLocation(_parentLocation, MatchCard.MINUTE_ISSUED_PROPERTY));
      checkTournamentMatch(_ctx, matchCard.getProperty(MatchCard.TOURNAMENT_MATCH_PROPERTY), newLocation(_parentLocation, MatchCard.TOURNAMENT_MATCH_PROPERTY));
      checkTournamentTeam(_ctx, matchCard.getProperty(MatchCard.TOURNAMENT_TEAM_PROPERTY), newLocation(_parentLocation, MatchCard.TOURNAMENT_TEAM_PROPERTY));
      checkCardCategory(_ctx, matchCard.getProperty(MatchCard.CARD_CATEGORY_PROPERTY), newLocation(_parentLocation, MatchCard.CARD_CATEGORY_PROPERTY));
      checkTournament(_ctx, matchCard.getProperty(MatchCard.TOURNAMENT_PROPERTY), newLocation(_parentLocation, MatchCard.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, matchCard.getProperty(MatchCard.CREATE_TIME_PROPERTY), newLocation(_parentLocation, MatchCard.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, matchCard.getProperty(MatchCard.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, MatchCard.UPDATE_TIME_PROPERTY));
    }

    public void checkPlayerName(UserContext _ctx, String playerName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, playerName);
    if(ObjectUtil.isNull(playerName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, playerName);

    }
    public void checkMinuteIssued(UserContext _ctx, Integer minuteIssued, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, minuteIssued);
    if(ObjectUtil.isNull(minuteIssued)){
        return;
    }
    }
    public void checkTournamentMatch(UserContext _ctx, TournamentMatch tournamentMatch, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournamentMatch);
    if(ObjectUtil.isNull(tournamentMatch)){
        return;
    }
    new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatch, _parentLocation);
    }
    public void checkTournamentTeam(UserContext _ctx, TournamentTeam tournamentTeam, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournamentTeam);
    if(ObjectUtil.isNull(tournamentTeam)){
        return;
    }
    new TournamentTeamChecker().checkAndFix(_ctx, tournamentTeam, _parentLocation);
    }
    public void checkCardCategory(UserContext _ctx, CardCategory cardCategory, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, cardCategory);
    if(ObjectUtil.isNull(cardCategory)){
        return;
    }
    new CardCategoryChecker().checkAndFix(_ctx, cardCategory, _parentLocation);
    }
    public void checkTournament(UserContext _ctx, Tournament tournament, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournament);
    if(ObjectUtil.isNull(tournament)){
        return;
    }
    new TournamentChecker().checkAndFix(_ctx, tournament, _parentLocation);
    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if(ObjectUtil.isNull(createTime)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if(ObjectUtil.isNull(updateTime)){
        return;
    }
    }
}