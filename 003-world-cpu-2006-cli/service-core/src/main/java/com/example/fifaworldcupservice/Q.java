package com.example.fifaworldcupservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.fifaworldcupservice.matchstage.MatchStageRequest<com.example.fifaworldcupservice.matchstage.MatchStage> matchStages(){
      return new com.example.fifaworldcupservice.matchstage.MatchStageRequest(com.example.fifaworldcupservice.matchstage.MatchStage.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.matchstage.MatchStageRequest<com.example.fifaworldcupservice.matchstage.MatchStage> matchStagesWithMinimalFields(){
      return new com.example.fifaworldcupservice.matchstage.MatchStageRequest(com.example.fifaworldcupservice.matchstage.MatchStage.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.matchstatus.MatchStatusRequest<com.example.fifaworldcupservice.matchstatus.MatchStatus> matchStatuses(){
      return new com.example.fifaworldcupservice.matchstatus.MatchStatusRequest(com.example.fifaworldcupservice.matchstatus.MatchStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.matchstatus.MatchStatusRequest<com.example.fifaworldcupservice.matchstatus.MatchStatus> matchStatusesWithMinimalFields(){
      return new com.example.fifaworldcupservice.matchstatus.MatchStatusRequest(com.example.fifaworldcupservice.matchstatus.MatchStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest<com.example.fifaworldcupservice.goalcategory.GoalCategory> goalCategories(){
      return new com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest(com.example.fifaworldcupservice.goalcategory.GoalCategory.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest<com.example.fifaworldcupservice.goalcategory.GoalCategory> goalCategoriesWithMinimalFields(){
      return new com.example.fifaworldcupservice.goalcategory.GoalCategoryRequest(com.example.fifaworldcupservice.goalcategory.GoalCategory.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.cardcategory.CardCategoryRequest<com.example.fifaworldcupservice.cardcategory.CardCategory> cardCategories(){
      return new com.example.fifaworldcupservice.cardcategory.CardCategoryRequest(com.example.fifaworldcupservice.cardcategory.CardCategory.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.cardcategory.CardCategoryRequest<com.example.fifaworldcupservice.cardcategory.CardCategory> cardCategoriesWithMinimalFields(){
      return new com.example.fifaworldcupservice.cardcategory.CardCategoryRequest(com.example.fifaworldcupservice.cardcategory.CardCategory.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.confederation.ConfederationRequest<com.example.fifaworldcupservice.confederation.Confederation> confederations(){
      return new com.example.fifaworldcupservice.confederation.ConfederationRequest(com.example.fifaworldcupservice.confederation.Confederation.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.confederation.ConfederationRequest<com.example.fifaworldcupservice.confederation.Confederation> confederationsWithMinimalFields(){
      return new com.example.fifaworldcupservice.confederation.ConfederationRequest(com.example.fifaworldcupservice.confederation.Confederation.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.tournament.TournamentRequest<com.example.fifaworldcupservice.tournament.Tournament> tournaments(){
      return new com.example.fifaworldcupservice.tournament.TournamentRequest(com.example.fifaworldcupservice.tournament.Tournament.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.tournament.TournamentRequest<com.example.fifaworldcupservice.tournament.Tournament> tournamentsWithMinimalFields(){
      return new com.example.fifaworldcupservice.tournament.TournamentRequest(com.example.fifaworldcupservice.tournament.Tournament.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest<com.example.fifaworldcupservice.tournamentteam.TournamentTeam> tournamentTeams(){
      return new com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest<com.example.fifaworldcupservice.tournamentteam.TournamentTeam> tournamentTeamsWithMinimalFields(){
      return new com.example.fifaworldcupservice.tournamentteam.TournamentTeamRequest(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.matchgroup.MatchGroupRequest<com.example.fifaworldcupservice.matchgroup.MatchGroup> matchGroups(){
      return new com.example.fifaworldcupservice.matchgroup.MatchGroupRequest(com.example.fifaworldcupservice.matchgroup.MatchGroup.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.matchgroup.MatchGroupRequest<com.example.fifaworldcupservice.matchgroup.MatchGroup> matchGroupsWithMinimalFields(){
      return new com.example.fifaworldcupservice.matchgroup.MatchGroupRequest(com.example.fifaworldcupservice.matchgroup.MatchGroup.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest<com.example.fifaworldcupservice.tournamentmatch.TournamentMatch> tournamentMatches(){
      return new com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest<com.example.fifaworldcupservice.tournamentmatch.TournamentMatch> tournamentMatchesWithMinimalFields(){
      return new com.example.fifaworldcupservice.tournamentmatch.TournamentMatchRequest(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.matchgoal.MatchGoalRequest<com.example.fifaworldcupservice.matchgoal.MatchGoal> matchGoals(){
      return new com.example.fifaworldcupservice.matchgoal.MatchGoalRequest(com.example.fifaworldcupservice.matchgoal.MatchGoal.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.matchgoal.MatchGoalRequest<com.example.fifaworldcupservice.matchgoal.MatchGoal> matchGoalsWithMinimalFields(){
      return new com.example.fifaworldcupservice.matchgoal.MatchGoalRequest(com.example.fifaworldcupservice.matchgoal.MatchGoal.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.matchcard.MatchCardRequest<com.example.fifaworldcupservice.matchcard.MatchCard> matchCards(){
      return new com.example.fifaworldcupservice.matchcard.MatchCardRequest(com.example.fifaworldcupservice.matchcard.MatchCard.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.matchcard.MatchCardRequest<com.example.fifaworldcupservice.matchcard.MatchCard> matchCardsWithMinimalFields(){
      return new com.example.fifaworldcupservice.matchcard.MatchCardRequest(com.example.fifaworldcupservice.matchcard.MatchCard.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.fifaworldcupservice.groupstanding.GroupStandingRequest<com.example.fifaworldcupservice.groupstanding.GroupStanding> groupStandings(){
      return new com.example.fifaworldcupservice.groupstanding.GroupStandingRequest(com.example.fifaworldcupservice.groupstanding.GroupStanding.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.fifaworldcupservice.groupstanding.GroupStandingRequest<com.example.fifaworldcupservice.groupstanding.GroupStanding> groupStandingsWithMinimalFields(){
      return new com.example.fifaworldcupservice.groupstanding.GroupStandingRequest(com.example.fifaworldcupservice.groupstanding.GroupStanding.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}