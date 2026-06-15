package com.example.fifaworldcupservice.tournament;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryChecker;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationChecker;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryChecker;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingChecker;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardChecker;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalChecker;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupChecker;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstage.MatchStageChecker;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.matchstatus.MatchStatusChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TournamentChecker implements Checker<Tournament>{

    public String type(){
        return Tournament.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Tournament tournament, ObjectLocation _parentLocation){
        if(needCheck(_ctx, tournament)){
            markAsChecked(_ctx, tournament);
            doCheck(_ctx, tournament, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Tournament tournament, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(tournament)){
         return;
      }
      if(tournament.newItem()){
        if(tournament.getCreateTime() == null){
           tournament.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(tournament.getUpdateTime() == null){
           tournament.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(tournament.updateItem()){
        tournament.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkTournamentName(_ctx, tournament.getProperty(Tournament.TOURNAMENT_NAME_PROPERTY), newLocation(_parentLocation, Tournament.TOURNAMENT_NAME_PROPERTY));
      checkHostCountries(_ctx, tournament.getProperty(Tournament.HOST_COUNTRIES_PROPERTY), newLocation(_parentLocation, Tournament.HOST_COUNTRIES_PROPERTY));
      checkStartDate(_ctx, tournament.getProperty(Tournament.START_DATE_PROPERTY), newLocation(_parentLocation, Tournament.START_DATE_PROPERTY));
      checkEndDate(_ctx, tournament.getProperty(Tournament.END_DATE_PROPERTY), newLocation(_parentLocation, Tournament.END_DATE_PROPERTY));
      checkTotalTeams(_ctx, tournament.getProperty(Tournament.TOTAL_TEAMS_PROPERTY), newLocation(_parentLocation, Tournament.TOTAL_TEAMS_PROPERTY));
      checkCreateTime(_ctx, tournament.getProperty(Tournament.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Tournament.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, tournament.getProperty(Tournament.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Tournament.UPDATE_TIME_PROPERTY));
      for(int i = 0; tournament.getMatchStageList() != null && i < tournament.getMatchStageList().size(); i++){
         MatchStage matchStage = tournament.getMatchStageList().get(i);
         new MatchStageChecker().checkAndFix(_ctx, matchStage, newLocation(_parentLocation, Tournament.MATCH_STAGE_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getMatchStatusList() != null && i < tournament.getMatchStatusList().size(); i++){
         MatchStatus matchStatus = tournament.getMatchStatusList().get(i);
         new MatchStatusChecker().checkAndFix(_ctx, matchStatus, newLocation(_parentLocation, Tournament.MATCH_STATUS_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getGoalCategoryList() != null && i < tournament.getGoalCategoryList().size(); i++){
         GoalCategory goalCategory = tournament.getGoalCategoryList().get(i);
         new GoalCategoryChecker().checkAndFix(_ctx, goalCategory, newLocation(_parentLocation, Tournament.GOAL_CATEGORY_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getCardCategoryList() != null && i < tournament.getCardCategoryList().size(); i++){
         CardCategory cardCategory = tournament.getCardCategoryList().get(i);
         new CardCategoryChecker().checkAndFix(_ctx, cardCategory, newLocation(_parentLocation, Tournament.CARD_CATEGORY_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getConfederationList() != null && i < tournament.getConfederationList().size(); i++){
         Confederation confederation = tournament.getConfederationList().get(i);
         new ConfederationChecker().checkAndFix(_ctx, confederation, newLocation(_parentLocation, Tournament.CONFEDERATION_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getTournamentTeamList() != null && i < tournament.getTournamentTeamList().size(); i++){
         TournamentTeam tournamentTeam = tournament.getTournamentTeamList().get(i);
         new TournamentTeamChecker().checkAndFix(_ctx, tournamentTeam, newLocation(_parentLocation, Tournament.TOURNAMENT_TEAM_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getMatchGroupList() != null && i < tournament.getMatchGroupList().size(); i++){
         MatchGroup matchGroup = tournament.getMatchGroupList().get(i);
         new MatchGroupChecker().checkAndFix(_ctx, matchGroup, newLocation(_parentLocation, Tournament.MATCH_GROUP_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getTournamentMatchList() != null && i < tournament.getTournamentMatchList().size(); i++){
         TournamentMatch tournamentMatch = tournament.getTournamentMatchList().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatch, newLocation(_parentLocation, Tournament.TOURNAMENT_MATCH_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getMatchGoalList() != null && i < tournament.getMatchGoalList().size(); i++){
         MatchGoal matchGoal = tournament.getMatchGoalList().get(i);
         new MatchGoalChecker().checkAndFix(_ctx, matchGoal, newLocation(_parentLocation, Tournament.MATCH_GOAL_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getMatchCardList() != null && i < tournament.getMatchCardList().size(); i++){
         MatchCard matchCard = tournament.getMatchCardList().get(i);
         new MatchCardChecker().checkAndFix(_ctx, matchCard, newLocation(_parentLocation, Tournament.MATCH_CARD_LIST_PROPERTY, i));
      }
      for(int i = 0; tournament.getGroupStandingList() != null && i < tournament.getGroupStandingList().size(); i++){
         GroupStanding groupStanding = tournament.getGroupStandingList().get(i);
         new GroupStandingChecker().checkAndFix(_ctx, groupStanding, newLocation(_parentLocation, Tournament.GROUP_STANDING_LIST_PROPERTY, i));
      }
    }

    public void checkTournamentName(UserContext _ctx, String tournamentName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tournamentName);
    if(ObjectUtil.isNull(tournamentName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, tournamentName);

    }
    public void checkHostCountries(UserContext _ctx, String hostCountries, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, hostCountries);
    if(ObjectUtil.isNull(hostCountries)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, hostCountries);

    }
    public void checkStartDate(UserContext _ctx, LocalDate startDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, startDate);
    if(ObjectUtil.isNull(startDate)){
        return;
    }
    }
    public void checkEndDate(UserContext _ctx, LocalDate endDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, endDate);
    if(ObjectUtil.isNull(endDate)){
        return;
    }
    }
    public void checkTotalTeams(UserContext _ctx, Integer totalTeams, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, totalTeams);
    if(ObjectUtil.isNull(totalTeams)){
        return;
    }
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