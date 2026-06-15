package com.example.fifaworldcupservice.matchgoal;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryChecker;
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

public class MatchGoalChecker implements Checker<MatchGoal>{

    public String type(){
        return MatchGoal.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, MatchGoal matchGoal, ObjectLocation _parentLocation){
        if(needCheck(_ctx, matchGoal)){
            markAsChecked(_ctx, matchGoal);
            doCheck(_ctx, matchGoal, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, MatchGoal matchGoal, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(matchGoal)){
         return;
      }
      if(matchGoal.newItem()){
        if(matchGoal.getCreateTime() == null){
           matchGoal.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(matchGoal.getUpdateTime() == null){
           matchGoal.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(matchGoal.updateItem()){
        matchGoal.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkPlayerName(_ctx, matchGoal.getProperty(MatchGoal.PLAYER_NAME_PROPERTY), newLocation(_parentLocation, MatchGoal.PLAYER_NAME_PROPERTY));
      checkMinuteScored(_ctx, matchGoal.getProperty(MatchGoal.MINUTE_SCORED_PROPERTY), newLocation(_parentLocation, MatchGoal.MINUTE_SCORED_PROPERTY));
      checkTournamentMatch(_ctx, matchGoal.getProperty(MatchGoal.TOURNAMENT_MATCH_PROPERTY), newLocation(_parentLocation, MatchGoal.TOURNAMENT_MATCH_PROPERTY));
      checkTournamentTeam(_ctx, matchGoal.getProperty(MatchGoal.TOURNAMENT_TEAM_PROPERTY), newLocation(_parentLocation, MatchGoal.TOURNAMENT_TEAM_PROPERTY));
      checkGoalCategory(_ctx, matchGoal.getProperty(MatchGoal.GOAL_CATEGORY_PROPERTY), newLocation(_parentLocation, MatchGoal.GOAL_CATEGORY_PROPERTY));
      checkTournament(_ctx, matchGoal.getProperty(MatchGoal.TOURNAMENT_PROPERTY), newLocation(_parentLocation, MatchGoal.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, matchGoal.getProperty(MatchGoal.CREATE_TIME_PROPERTY), newLocation(_parentLocation, MatchGoal.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, matchGoal.getProperty(MatchGoal.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, MatchGoal.UPDATE_TIME_PROPERTY));
    }

    public void checkPlayerName(UserContext _ctx, String playerName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, playerName);
    if(ObjectUtil.isNull(playerName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, playerName);

    }
    public void checkMinuteScored(UserContext _ctx, Integer minuteScored, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, minuteScored);
    if(ObjectUtil.isNull(minuteScored)){
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
    public void checkGoalCategory(UserContext _ctx, GoalCategory goalCategory, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, goalCategory);
    if(ObjectUtil.isNull(goalCategory)){
        return;
    }
    new GoalCategoryChecker().checkAndFix(_ctx, goalCategory, _parentLocation);
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