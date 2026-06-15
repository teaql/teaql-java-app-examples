package com.example.fifaworldcupservice.tournamentteam;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationChecker;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingChecker;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardChecker;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class TournamentTeamChecker implements Checker<TournamentTeam>{

    public String type(){
        return TournamentTeam.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TournamentTeam tournamentTeam, ObjectLocation _parentLocation){
        if(needCheck(_ctx, tournamentTeam)){
            markAsChecked(_ctx, tournamentTeam);
            doCheck(_ctx, tournamentTeam, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TournamentTeam tournamentTeam, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(tournamentTeam)){
         return;
      }
      if(tournamentTeam.newItem()){
        if(tournamentTeam.getCreateTime() == null){
           tournamentTeam.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(tournamentTeam.getUpdateTime() == null){
           tournamentTeam.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(tournamentTeam.updateItem()){
        tournamentTeam.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkTeamName(_ctx, tournamentTeam.getProperty(TournamentTeam.TEAM_NAME_PROPERTY), newLocation(_parentLocation, TournamentTeam.TEAM_NAME_PROPERTY));
      checkTeamCode(_ctx, tournamentTeam.getProperty(TournamentTeam.TEAM_CODE_PROPERTY), newLocation(_parentLocation, TournamentTeam.TEAM_CODE_PROPERTY));
      checkEmojiFlag(_ctx, tournamentTeam.getProperty(TournamentTeam.EMOJI_FLAG_PROPERTY), newLocation(_parentLocation, TournamentTeam.EMOJI_FLAG_PROPERTY));
      checkFifaRanking(_ctx, tournamentTeam.getProperty(TournamentTeam.FIFA_RANKING_PROPERTY), newLocation(_parentLocation, TournamentTeam.FIFA_RANKING_PROPERTY));
      checkManagerName(_ctx, tournamentTeam.getProperty(TournamentTeam.MANAGER_NAME_PROPERTY), newLocation(_parentLocation, TournamentTeam.MANAGER_NAME_PROPERTY));
      checkConfederation(_ctx, tournamentTeam.getProperty(TournamentTeam.CONFEDERATION_PROPERTY), newLocation(_parentLocation, TournamentTeam.CONFEDERATION_PROPERTY));
      checkGroupLetter(_ctx, tournamentTeam.getProperty(TournamentTeam.GROUP_LETTER_PROPERTY), newLocation(_parentLocation, TournamentTeam.GROUP_LETTER_PROPERTY));
      checkTournament(_ctx, tournamentTeam.getProperty(TournamentTeam.TOURNAMENT_PROPERTY), newLocation(_parentLocation, TournamentTeam.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, tournamentTeam.getProperty(TournamentTeam.CREATE_TIME_PROPERTY), newLocation(_parentLocation, TournamentTeam.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, tournamentTeam.getProperty(TournamentTeam.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, TournamentTeam.UPDATE_TIME_PROPERTY));
      for(int i = 0; tournamentTeam.getTournamentMatchListAsHomeTeam() != null && i < tournamentTeam.getTournamentMatchListAsHomeTeam().size(); i++){
         TournamentMatch tournamentMatchAsHomeTeam = tournamentTeam.getTournamentMatchListAsHomeTeam().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatchAsHomeTeam, newLocation(_parentLocation, TournamentTeam.TOURNAMENT_MATCH_LIST_AS_HOME_TEAM_PROPERTY, i));
      }
      for(int i = 0; tournamentTeam.getTournamentMatchListAsAwayTeam() != null && i < tournamentTeam.getTournamentMatchListAsAwayTeam().size(); i++){
         TournamentMatch tournamentMatchAsAwayTeam = tournamentTeam.getTournamentMatchListAsAwayTeam().get(i);
         new TournamentMatchChecker().checkAndFix(_ctx, tournamentMatchAsAwayTeam, newLocation(_parentLocation, TournamentTeam.TOURNAMENT_MATCH_LIST_AS_AWAY_TEAM_PROPERTY, i));
      }
      for(int i = 0; tournamentTeam.getMatchGoalList() != null && i < tournamentTeam.getMatchGoalList().size(); i++){
         MatchGoal matchGoal = tournamentTeam.getMatchGoalList().get(i);
         new MatchGoalChecker().checkAndFix(_ctx, matchGoal, newLocation(_parentLocation, TournamentTeam.MATCH_GOAL_LIST_PROPERTY, i));
      }
      for(int i = 0; tournamentTeam.getMatchCardList() != null && i < tournamentTeam.getMatchCardList().size(); i++){
         MatchCard matchCard = tournamentTeam.getMatchCardList().get(i);
         new MatchCardChecker().checkAndFix(_ctx, matchCard, newLocation(_parentLocation, TournamentTeam.MATCH_CARD_LIST_PROPERTY, i));
      }
      for(int i = 0; tournamentTeam.getGroupStandingList() != null && i < tournamentTeam.getGroupStandingList().size(); i++){
         GroupStanding groupStanding = tournamentTeam.getGroupStandingList().get(i);
         new GroupStandingChecker().checkAndFix(_ctx, groupStanding, newLocation(_parentLocation, TournamentTeam.GROUP_STANDING_LIST_PROPERTY, i));
      }
    }

    public void checkTeamName(UserContext _ctx, String teamName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, teamName);
    if(ObjectUtil.isNull(teamName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, teamName);

    }
    public void checkTeamCode(UserContext _ctx, String teamCode, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, teamCode);
    if(ObjectUtil.isNull(teamCode)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, teamCode);

    }
    public void checkEmojiFlag(UserContext _ctx, String emojiFlag, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, emojiFlag);
    if(ObjectUtil.isNull(emojiFlag)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, emojiFlag);

    }
    public void checkFifaRanking(UserContext _ctx, Integer fifaRanking, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, fifaRanking);
    if(ObjectUtil.isNull(fifaRanking)){
        return;
    }
    }
    public void checkManagerName(UserContext _ctx, String managerName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, managerName);
    if(ObjectUtil.isNull(managerName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, managerName);

    }
    public void checkConfederation(UserContext _ctx, Confederation confederation, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, confederation);
    if(ObjectUtil.isNull(confederation)){
        return;
    }
    new ConfederationChecker().checkAndFix(_ctx, confederation, _parentLocation);
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