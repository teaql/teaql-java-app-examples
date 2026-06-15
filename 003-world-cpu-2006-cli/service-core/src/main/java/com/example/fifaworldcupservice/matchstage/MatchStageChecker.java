package com.example.fifaworldcupservice.matchstage;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class MatchStageChecker implements Checker<MatchStage>{

    public String type(){
        return MatchStage.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MatchStage matchStage, ObjectLocation _parentLocation){
        if(needCheck(_ctx, matchStage)){
            markAsChecked(_ctx, matchStage);
            doCheck(_ctx, matchStage, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MatchStage matchStage, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(matchStage)){
         return;
      }
      if(matchStage.newItem()){
      }else if(matchStage.updateItem()){
      }
      checkName(_ctx, matchStage.getProperty(MatchStage.NAME_PROPERTY), newLocation(_parentLocation, MatchStage.NAME_PROPERTY));
      checkCode(_ctx, matchStage.getProperty(MatchStage.CODE_PROPERTY), newLocation(_parentLocation, MatchStage.CODE_PROPERTY));
      checkTournament(_ctx, matchStage.getProperty(MatchStage.TOURNAMENT_PROPERTY), newLocation(_parentLocation, MatchStage.TOURNAMENT_PROPERTY));
      for(int i = 0; matchStage.getTournamentMatchList() != null && i < matchStage.getTournamentMatchList().size(); i++){
         TournamentMatch tournamentMatch = matchStage.getTournamentMatchList().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatch, newLocation(_parentLocation, MatchStage.TOURNAMENT_MATCH_LIST_PROPERTY, i));
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