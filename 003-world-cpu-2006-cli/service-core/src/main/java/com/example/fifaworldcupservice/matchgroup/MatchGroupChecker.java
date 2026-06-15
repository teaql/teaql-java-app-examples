package com.example.fifaworldcupservice.matchgroup;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class MatchGroupChecker implements Checker<MatchGroup>{

    public String type(){
        return MatchGroup.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MatchGroup matchGroup, ObjectLocation _parentLocation){
        if(needCheck(_ctx, matchGroup)){
            markAsChecked(_ctx, matchGroup);
            doCheck(_ctx, matchGroup, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MatchGroup matchGroup, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(matchGroup)){
         return;
      }
      if(matchGroup.newItem()){
        if(matchGroup.getCreateTime() == null){
           matchGroup.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(matchGroup.getUpdateTime() == null){
           matchGroup.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(matchGroup.updateItem()){
        matchGroup.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkGroupLetter(_ctx, matchGroup.getProperty(MatchGroup.GROUP_LETTER_PROPERTY), newLocation(_parentLocation, MatchGroup.GROUP_LETTER_PROPERTY));
      checkTournament(_ctx, matchGroup.getProperty(MatchGroup.TOURNAMENT_PROPERTY), newLocation(_parentLocation, MatchGroup.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, matchGroup.getProperty(MatchGroup.CREATE_TIME_PROPERTY), newLocation(_parentLocation, MatchGroup.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, matchGroup.getProperty(MatchGroup.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, MatchGroup.UPDATE_TIME_PROPERTY));
      for(int i = 0; matchGroup.getTournamentMatchList() != null && i < matchGroup.getTournamentMatchList().size(); i++){
         TournamentMatch tournamentMatch = matchGroup.getTournamentMatchList().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatch, newLocation(_parentLocation, MatchGroup.TOURNAMENT_MATCH_LIST_PROPERTY, i));
      }
      for(int i = 0; matchGroup.getGroupStandingList() != null && i < matchGroup.getGroupStandingList().size(); i++){
         GroupStanding groupStanding = matchGroup.getGroupStandingList().get(i);
         new GroupStandingChecker().checkAndFix(_ctx, groupStanding, newLocation(_parentLocation, MatchGroup.GROUP_STANDING_LIST_PROPERTY, i));
      }
    }

    public void checkGroupLetter(UserContext _ctx, String groupLetter, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, groupLetter);
    if(ObjectUtil.isNull(groupLetter)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, groupLetter);

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