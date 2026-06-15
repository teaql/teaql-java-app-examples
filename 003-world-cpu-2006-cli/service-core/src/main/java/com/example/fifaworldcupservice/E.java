package com.example.fifaworldcupservice;

import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.cardcategory.CardCategoryExpression;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.confederation.ConfederationExpression;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.goalcategory.GoalCategoryExpression;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.groupstanding.GroupStandingExpression;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardExpression;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalExpression;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchgroup.MatchGroupExpression;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstage.MatchStageExpression;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.matchstatus.MatchStatusExpression;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentExpression;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatchExpression;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeamExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static MatchStageExpression<MatchStage, MatchStage, MatchStage> matchStage(MatchStage matchStage){
      return new MatchStageExpression(new ValueExpression(matchStage));
  }
  public static MatchStatusExpression<MatchStatus, MatchStatus, MatchStatus> matchStatus(MatchStatus matchStatus){
      return new MatchStatusExpression(new ValueExpression(matchStatus));
  }
  public static GoalCategoryExpression<GoalCategory, GoalCategory, GoalCategory> goalCategory(GoalCategory goalCategory){
      return new GoalCategoryExpression(new ValueExpression(goalCategory));
  }
  public static CardCategoryExpression<CardCategory, CardCategory, CardCategory> cardCategory(CardCategory cardCategory){
      return new CardCategoryExpression(new ValueExpression(cardCategory));
  }
  public static ConfederationExpression<Confederation, Confederation, Confederation> confederation(Confederation confederation){
      return new ConfederationExpression(new ValueExpression(confederation));
  }
  public static TournamentExpression<Tournament, Tournament, Tournament> tournament(Tournament tournament){
      return new TournamentExpression(new ValueExpression(tournament));
  }
  public static TournamentTeamExpression<TournamentTeam, TournamentTeam, TournamentTeam> tournamentTeam(TournamentTeam tournamentTeam){
      return new TournamentTeamExpression(new ValueExpression(tournamentTeam));
  }
  public static MatchGroupExpression<MatchGroup, MatchGroup, MatchGroup> matchGroup(MatchGroup matchGroup){
      return new MatchGroupExpression(new ValueExpression(matchGroup));
  }
  public static TournamentMatchExpression<TournamentMatch, TournamentMatch, TournamentMatch> tournamentMatch(TournamentMatch tournamentMatch){
      return new TournamentMatchExpression(new ValueExpression(tournamentMatch));
  }
  public static MatchGoalExpression<MatchGoal, MatchGoal, MatchGoal> matchGoal(MatchGoal matchGoal){
      return new MatchGoalExpression(new ValueExpression(matchGoal));
  }
  public static MatchCardExpression<MatchCard, MatchCard, MatchCard> matchCard(MatchCard matchCard){
      return new MatchCardExpression(new ValueExpression(matchCard));
  }
  public static GroupStandingExpression<GroupStanding, GroupStanding, GroupStanding> groupStanding(GroupStanding groupStanding){
      return new GroupStandingExpression(new ValueExpression(groupStanding));
  }
}