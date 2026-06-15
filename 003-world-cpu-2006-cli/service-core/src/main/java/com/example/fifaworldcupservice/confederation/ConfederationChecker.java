package com.example.fifaworldcupservice.confederation;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class ConfederationChecker implements Checker<Confederation>{

    public String type(){
        return Confederation.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Confederation confederation, ObjectLocation _parentLocation){
        if(needCheck(_ctx, confederation)){
            markAsChecked(_ctx, confederation);
            doCheck(_ctx, confederation, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Confederation confederation, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(confederation)){
         return;
      }
      if(confederation.newItem()){
      }else if(confederation.updateItem()){
      }
      checkName(_ctx, confederation.getProperty(Confederation.NAME_PROPERTY), newLocation(_parentLocation, Confederation.NAME_PROPERTY));
      checkCode(_ctx, confederation.getProperty(Confederation.CODE_PROPERTY), newLocation(_parentLocation, Confederation.CODE_PROPERTY));
      checkTournament(_ctx, confederation.getProperty(Confederation.TOURNAMENT_PROPERTY), newLocation(_parentLocation, Confederation.TOURNAMENT_PROPERTY));
      for(int i = 0; confederation.getTournamentTeamList() != null && i < confederation.getTournamentTeamList().size(); i++){
         TournamentTeam tournamentTeam = confederation.getTournamentTeamList().get(i);
         new TournamentTeamChecker().checkAndFix(_ctx, tournamentTeam, newLocation(_parentLocation, Confederation.TOURNAMENT_TEAM_LIST_PROPERTY, i));
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