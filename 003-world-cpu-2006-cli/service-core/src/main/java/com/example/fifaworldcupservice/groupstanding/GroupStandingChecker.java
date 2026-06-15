package com.example.fifaworldcupservice.groupstanding;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class GroupStandingChecker implements Checker<GroupStanding>{

    public String type(){
        return GroupStanding.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, GroupStanding groupStanding, ObjectLocation _parentLocation){
        if(needCheck(_ctx, groupStanding)){
            markAsChecked(_ctx, groupStanding);
            doCheck(_ctx, groupStanding, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, GroupStanding groupStanding, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(groupStanding)){
         return;
      }
      if(groupStanding.newItem()){
        if(groupStanding.getCreateTime() == null){
           groupStanding.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(groupStanding.getUpdateTime() == null){
           groupStanding.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(groupStanding.updateItem()){
        groupStanding.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkPlayed(_ctx, groupStanding.getProperty(GroupStanding.PLAYED_PROPERTY), newLocation(_parentLocation, GroupStanding.PLAYED_PROPERTY));
      checkWon(_ctx, groupStanding.getProperty(GroupStanding.WON_PROPERTY), newLocation(_parentLocation, GroupStanding.WON_PROPERTY));
      checkDrawn(_ctx, groupStanding.getProperty(GroupStanding.DRAWN_PROPERTY), newLocation(_parentLocation, GroupStanding.DRAWN_PROPERTY));
      checkLost(_ctx, groupStanding.getProperty(GroupStanding.LOST_PROPERTY), newLocation(_parentLocation, GroupStanding.LOST_PROPERTY));
      checkGoalsFor(_ctx, groupStanding.getProperty(GroupStanding.GOALS_FOR_PROPERTY), newLocation(_parentLocation, GroupStanding.GOALS_FOR_PROPERTY));
      checkGoalsAgainst(_ctx, groupStanding.getProperty(GroupStanding.GOALS_AGAINST_PROPERTY), newLocation(_parentLocation, GroupStanding.GOALS_AGAINST_PROPERTY));
      checkGoalDifference(_ctx, groupStanding.getProperty(GroupStanding.GOAL_DIFFERENCE_PROPERTY), newLocation(_parentLocation, GroupStanding.GOAL_DIFFERENCE_PROPERTY));
      checkPoints(_ctx, groupStanding.getProperty(GroupStanding.POINTS_PROPERTY), newLocation(_parentLocation, GroupStanding.POINTS_PROPERTY));
      checkStandingRank(_ctx, groupStanding.getProperty(GroupStanding.STANDING_RANK_PROPERTY), newLocation(_parentLocation, GroupStanding.STANDING_RANK_PROPERTY));
      checkTournamentTeam(_ctx, groupStanding.getProperty(GroupStanding.TOURNAMENT_TEAM_PROPERTY), newLocation(_parentLocation, GroupStanding.TOURNAMENT_TEAM_PROPERTY));
      checkMatchGroup(_ctx, groupStanding.getProperty(GroupStanding.MATCH_GROUP_PROPERTY), newLocation(_parentLocation, GroupStanding.MATCH_GROUP_PROPERTY));
      checkTournament(_ctx, groupStanding.getProperty(GroupStanding.TOURNAMENT_PROPERTY), newLocation(_parentLocation, GroupStanding.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, groupStanding.getProperty(GroupStanding.CREATE_TIME_PROPERTY), newLocation(_parentLocation, GroupStanding.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, groupStanding.getProperty(GroupStanding.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, GroupStanding.UPDATE_TIME_PROPERTY));
    }

    public void checkPlayed(UserContext _ctx, Integer played, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, played);
    if(ObjectUtil.isNull(played)){
        return;
    }
    }
    public void checkWon(UserContext _ctx, Integer won, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, won);
    if(ObjectUtil.isNull(won)){
        return;
    }
    }
    public void checkDrawn(UserContext _ctx, Integer drawn, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, drawn);
    if(ObjectUtil.isNull(drawn)){
        return;
    }
    }
    public void checkLost(UserContext _ctx, Integer lost, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, lost);
    if(ObjectUtil.isNull(lost)){
        return;
    }
    }
    public void checkGoalsFor(UserContext _ctx, Integer goalsFor, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, goalsFor);
    if(ObjectUtil.isNull(goalsFor)){
        return;
    }
    }
    public void checkGoalsAgainst(UserContext _ctx, Integer goalsAgainst, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, goalsAgainst);
    if(ObjectUtil.isNull(goalsAgainst)){
        return;
    }
    }
    public void checkGoalDifference(UserContext _ctx, Integer goalDifference, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, goalDifference);
    if(ObjectUtil.isNull(goalDifference)){
        return;
    }
    }
    public void checkPoints(UserContext _ctx, Integer points, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, points);
    if(ObjectUtil.isNull(points)){
        return;
    }
    }
    public void checkStandingRank(UserContext _ctx, Integer standingRank, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, standingRank);
    if(ObjectUtil.isNull(standingRank)){
        return;
    }
    }
    public void checkTournamentTeam(UserContext _ctx, TournamentTeam tournamentTeam, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournamentTeam);
    if(ObjectUtil.isNull(tournamentTeam)){
        return;
    }
    new TournamentTeamChecker().checkAndFix(_ctx, tournamentTeam, _parentLocation);
    }
    public void checkMatchGroup(UserContext _ctx, MatchGroup matchGroup, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchGroup);
    if(ObjectUtil.isNull(matchGroup)){
        return;
    }
    new MatchGroupChecker().checkAndFix(_ctx, matchGroup, _parentLocation);
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