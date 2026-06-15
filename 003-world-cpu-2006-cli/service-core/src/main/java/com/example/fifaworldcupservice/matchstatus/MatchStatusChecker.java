package com.example.fifaworldcupservice.matchstatus;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class MatchStatusChecker implements Checker<MatchStatus>{

    public String type(){
        return MatchStatus.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MatchStatus matchStatus, ObjectLocation _parentLocation){
        if(needCheck(_ctx, matchStatus)){
            markAsChecked(_ctx, matchStatus);
            doCheck(_ctx, matchStatus, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MatchStatus matchStatus, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(matchStatus)){
         return;
      }
      if(matchStatus.newItem()){
      }else if(matchStatus.updateItem()){
      }
      checkName(_ctx, matchStatus.getProperty(MatchStatus.NAME_PROPERTY), newLocation(_parentLocation, MatchStatus.NAME_PROPERTY));
      checkCode(_ctx, matchStatus.getProperty(MatchStatus.CODE_PROPERTY), newLocation(_parentLocation, MatchStatus.CODE_PROPERTY));
      checkTournament(_ctx, matchStatus.getProperty(MatchStatus.TOURNAMENT_PROPERTY), newLocation(_parentLocation, MatchStatus.TOURNAMENT_PROPERTY));
      for(int i = 0; matchStatus.getTournamentMatchList() != null && i < matchStatus.getTournamentMatchList().size(); i++){
         TournamentMatch tournamentMatch = matchStatus.getTournamentMatchList().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatch, newLocation(_parentLocation, MatchStatus.TOURNAMENT_MATCH_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if(ObjectUtil.isNull(name)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkCode(UserContext _ctx, String code, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, code);
    if(ObjectUtil.isNull(code)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, code);

    }
    public void checkTournament(UserContext _ctx, Tournament tournament, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournament);
    if(ObjectUtil.isNull(tournament)){
        return;
    }
    new TournamentChecker().checkAndFix(_ctx, tournament, _parentLocation);
    }
}