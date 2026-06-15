package com.example.fifaworldcupservice.tournamentmatch;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
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
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TournamentMatchChecker implements Checker<TournamentMatch>{

    public String type(){
        return TournamentMatch.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TournamentMatch tournamentMatch, ObjectLocation _parentLocation){
        if(needCheck(_ctx, tournamentMatch)){
            markAsChecked(_ctx, tournamentMatch);
            doCheck(_ctx, tournamentMatch, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TournamentMatch tournamentMatch, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(tournamentMatch)){
         return;
      }
      if(tournamentMatch.newItem()){
        if(tournamentMatch.getCreateTime() == null){
           tournamentMatch.updateCreateTime(ReflectUtil.invoke(_ctx, "now"));
        }if(tournamentMatch.getUpdateTime() == null){
           tournamentMatch.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
        }
      }else if(tournamentMatch.updateItem()){
        tournamentMatch.updateUpdateTime(ReflectUtil.invoke(_ctx, "now"));
      }
      checkMatchNumber(_ctx, tournamentMatch.getProperty(TournamentMatch.MATCH_NUMBER_PROPERTY), newLocation(_parentLocation, TournamentMatch.MATCH_NUMBER_PROPERTY));
      checkMatchDate(_ctx, tournamentMatch.getProperty(TournamentMatch.MATCH_DATE_PROPERTY), newLocation(_parentLocation, TournamentMatch.MATCH_DATE_PROPERTY));
      checkVenueName(_ctx, tournamentMatch.getProperty(TournamentMatch.VENUE_NAME_PROPERTY), newLocation(_parentLocation, TournamentMatch.VENUE_NAME_PROPERTY));
      checkVenueCity(_ctx, tournamentMatch.getProperty(TournamentMatch.VENUE_CITY_PROPERTY), newLocation(_parentLocation, TournamentMatch.VENUE_CITY_PROPERTY));
      checkVenueCountry(_ctx, tournamentMatch.getProperty(TournamentMatch.VENUE_COUNTRY_PROPERTY), newLocation(_parentLocation, TournamentMatch.VENUE_COUNTRY_PROPERTY));
      checkHomeScore(_ctx, tournamentMatch.getProperty(TournamentMatch.HOME_SCORE_PROPERTY), newLocation(_parentLocation, TournamentMatch.HOME_SCORE_PROPERTY));
      checkAwayScore(_ctx, tournamentMatch.getProperty(TournamentMatch.AWAY_SCORE_PROPERTY), newLocation(_parentLocation, TournamentMatch.AWAY_SCORE_PROPERTY));
      checkExtraTimeHome(_ctx, tournamentMatch.getProperty(TournamentMatch.EXTRA_TIME_HOME_PROPERTY), newLocation(_parentLocation, TournamentMatch.EXTRA_TIME_HOME_PROPERTY));
      checkExtraTimeAway(_ctx, tournamentMatch.getProperty(TournamentMatch.EXTRA_TIME_AWAY_PROPERTY), newLocation(_parentLocation, TournamentMatch.EXTRA_TIME_AWAY_PROPERTY));
      checkPenaltyHome(_ctx, tournamentMatch.getProperty(TournamentMatch.PENALTY_HOME_PROPERTY), newLocation(_parentLocation, TournamentMatch.PENALTY_HOME_PROPERTY));
      checkPenaltyAway(_ctx, tournamentMatch.getProperty(TournamentMatch.PENALTY_AWAY_PROPERTY), newLocation(_parentLocation, TournamentMatch.PENALTY_AWAY_PROPERTY));
      checkHomeTeam(_ctx, tournamentMatch.getProperty(TournamentMatch.HOME_TEAM_PROPERTY), newLocation(_parentLocation, TournamentMatch.HOME_TEAM_PROPERTY));
      checkAwayTeam(_ctx, tournamentMatch.getProperty(TournamentMatch.AWAY_TEAM_PROPERTY), newLocation(_parentLocation, TournamentMatch.AWAY_TEAM_PROPERTY));
      checkMatchStage(_ctx, tournamentMatch.getProperty(TournamentMatch.MATCH_STAGE_PROPERTY), newLocation(_parentLocation, TournamentMatch.MATCH_STAGE_PROPERTY));
      checkMatchGroup(_ctx, tournamentMatch.getProperty(TournamentMatch.MATCH_GROUP_PROPERTY), newLocation(_parentLocation, TournamentMatch.MATCH_GROUP_PROPERTY));
      checkMatchStatus(_ctx, tournamentMatch.getProperty(TournamentMatch.MATCH_STATUS_PROPERTY), newLocation(_parentLocation, TournamentMatch.MATCH_STATUS_PROPERTY));
      checkTournament(_ctx, tournamentMatch.getProperty(TournamentMatch.TOURNAMENT_PROPERTY), newLocation(_parentLocation, TournamentMatch.TOURNAMENT_PROPERTY));
      checkCreateTime(_ctx, tournamentMatch.getProperty(TournamentMatch.CREATE_TIME_PROPERTY), newLocation(_parentLocation, TournamentMatch.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, tournamentMatch.getProperty(TournamentMatch.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, TournamentMatch.UPDATE_TIME_PROPERTY));
      for(int i = 0; tournamentMatch.getMatchGoalList() != null && i < tournamentMatch.getMatchGoalList().size(); i++){
         MatchGoal matchGoal = tournamentMatch.getMatchGoalList().get(i);
         new MatchGoalChecker().checkAndFix(_ctx, matchGoal, newLocation(_parentLocation, TournamentMatch.MATCH_GOAL_LIST_PROPERTY, i));
      }
      for(int i = 0; tournamentMatch.getMatchCardList() != null && i < tournamentMatch.getMatchCardList().size(); i++){
         MatchCard matchCard = tournamentMatch.getMatchCardList().get(i);
         new MatchCardChecker().checkAndFix(_ctx, matchCard, newLocation(_parentLocation, TournamentMatch.MATCH_CARD_LIST_PROPERTY, i));
      }
    }

    public void checkMatchNumber(UserContext _ctx, Integer matchNumber, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchNumber);
    if(ObjectUtil.isNull(matchNumber)){
        return;
    }
    }
    public void checkMatchDate(UserContext _ctx, LocalDate matchDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchDate);
    if(ObjectUtil.isNull(matchDate)){
        return;
    }
    }
    public void checkVenueName(UserContext _ctx, String venueName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, venueName);
    if(ObjectUtil.isNull(venueName)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, venueName);

    }
    public void checkVenueCity(UserContext _ctx, String venueCity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, venueCity);
    if(ObjectUtil.isNull(venueCity)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, venueCity);

    }
    public void checkVenueCountry(UserContext _ctx, String venueCountry, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, venueCountry);
    if(ObjectUtil.isNull(venueCountry)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, venueCountry);

    }
    public void checkHomeScore(UserContext _ctx, Integer homeScore, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, homeScore);
    if(ObjectUtil.isNull(homeScore)){
        return;
    }
    }
    public void checkAwayScore(UserContext _ctx, Integer awayScore, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, awayScore);
    if(ObjectUtil.isNull(awayScore)){
        return;
    }
    }
    public void checkExtraTimeHome(UserContext _ctx, Integer extraTimeHome, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, extraTimeHome);
    if(ObjectUtil.isNull(extraTimeHome)){
        return;
    }
    }
    public void checkExtraTimeAway(UserContext _ctx, Integer extraTimeAway, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, extraTimeAway);
    if(ObjectUtil.isNull(extraTimeAway)){
        return;
    }
    }
    public void checkPenaltyHome(UserContext _ctx, Integer penaltyHome, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, penaltyHome);
    if(ObjectUtil.isNull(penaltyHome)){
        return;
    }
    }
    public void checkPenaltyAway(UserContext _ctx, Integer penaltyAway, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, penaltyAway);
    if(ObjectUtil.isNull(penaltyAway)){
        return;
    }
    }
    public void checkHomeTeam(UserContext _ctx, TournamentTeam homeTeam, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, homeTeam);
    if(ObjectUtil.isNull(homeTeam)){
        return;
    }
    new TournamentTeamChecker().checkAndFix(_ctx, homeTeam, _parentLocation);
    }
    public void checkAwayTeam(UserContext _ctx, TournamentTeam awayTeam, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, awayTeam);
    if(ObjectUtil.isNull(awayTeam)){
        return;
    }
    new TournamentTeamChecker().checkAndFix(_ctx, awayTeam, _parentLocation);
    }
    public void checkMatchStage(UserContext _ctx, MatchStage matchStage, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchStage);
    if(ObjectUtil.isNull(matchStage)){
        return;
    }
    new MatchStageChecker().checkAndFix(_ctx, matchStage, _parentLocation);
    }
    public void checkMatchGroup(UserContext _ctx, MatchGroup matchGroup, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchGroup);
    if(ObjectUtil.isNull(matchGroup)){
        return;
    }
    new MatchGroupChecker().checkAndFix(_ctx, matchGroup, _parentLocation);
    }
    public void checkMatchStatus(UserContext _ctx, MatchStatus matchStatus, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, matchStatus);
    if(ObjectUtil.isNull(matchStatus)){
        return;
    }
    new MatchStatusChecker().checkAndFix(_ctx, matchStatus, _parentLocation);
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