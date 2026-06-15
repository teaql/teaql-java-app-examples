package com.example.fifaworldcupservice;

import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.tournament.Tournament;

public interface Constants  {
  public static final long TOURNAMENT_ID = 1l;
  public static final Tournament TOURNAMENT = Tournament.refer(TOURNAMENT_ID);
  public static final long MATCH_STAGE_GROUP_ID = 1001l ;
  public static final MatchStage MATCH_STAGE_GROUP = MatchStage.refer(MATCH_STAGE_GROUP_ID);public static final long MATCH_STAGE_ROUND_OF_32_ID = 1002l ;
  public static final MatchStage MATCH_STAGE_ROUND_OF_32 = MatchStage.refer(MATCH_STAGE_ROUND_OF_32_ID);public static final long MATCH_STAGE_ROUND_OF_16_ID = 1003l ;
  public static final MatchStage MATCH_STAGE_ROUND_OF_16 = MatchStage.refer(MATCH_STAGE_ROUND_OF_16_ID);public static final long MATCH_STAGE_QUARTER_FINAL_ID = 1004l ;
  public static final MatchStage MATCH_STAGE_QUARTER_FINAL = MatchStage.refer(MATCH_STAGE_QUARTER_FINAL_ID);public static final long MATCH_STAGE_SEMI_FINAL_ID = 1005l ;
  public static final MatchStage MATCH_STAGE_SEMI_FINAL = MatchStage.refer(MATCH_STAGE_SEMI_FINAL_ID);public static final long MATCH_STAGE_THIRD_PLACE_ID = 1006l ;
  public static final MatchStage MATCH_STAGE_THIRD_PLACE = MatchStage.refer(MATCH_STAGE_THIRD_PLACE_ID);public static final long MATCH_STAGE_FINAL_ID = 1007l ;
  public static final MatchStage MATCH_STAGE_FINAL = MatchStage.refer(MATCH_STAGE_FINAL_ID);
  public static final long MATCH_STATUS_SCHEDULED_ID = 1001l ;
  public static final MatchStatus MATCH_STATUS_SCHEDULED = MatchStatus.refer(MATCH_STATUS_SCHEDULED_ID);public static final long MATCH_STATUS_LIVE_ID = 1002l ;
  public static final MatchStatus MATCH_STATUS_LIVE = MatchStatus.refer(MATCH_STATUS_LIVE_ID);public static final long MATCH_STATUS_FINISHED_ID = 1003l ;
  public static final MatchStatus MATCH_STATUS_FINISHED = MatchStatus.refer(MATCH_STATUS_FINISHED_ID);public static final long MATCH_STATUS_POSTPONED_ID = 1004l ;
  public static final MatchStatus MATCH_STATUS_POSTPONED = MatchStatus.refer(MATCH_STATUS_POSTPONED_ID);
  public static final long GOAL_CATEGORY_NORMAL_ID = 1001l ;
  public static final GoalCategory GOAL_CATEGORY_NORMAL = GoalCategory.refer(GOAL_CATEGORY_NORMAL_ID);public static final long GOAL_CATEGORY_PENALTY_ID = 1002l ;
  public static final GoalCategory GOAL_CATEGORY_PENALTY = GoalCategory.refer(GOAL_CATEGORY_PENALTY_ID);public static final long GOAL_CATEGORY_OWN_GOAL_ID = 1003l ;
  public static final GoalCategory GOAL_CATEGORY_OWN_GOAL = GoalCategory.refer(GOAL_CATEGORY_OWN_GOAL_ID);public static final long GOAL_CATEGORY_FREE_KICK_ID = 1004l ;
  public static final GoalCategory GOAL_CATEGORY_FREE_KICK = GoalCategory.refer(GOAL_CATEGORY_FREE_KICK_ID);
  public static final long CARD_CATEGORY_YELLOW_ID = 1001l ;
  public static final CardCategory CARD_CATEGORY_YELLOW = CardCategory.refer(CARD_CATEGORY_YELLOW_ID);public static final long CARD_CATEGORY_RED_ID = 1002l ;
  public static final CardCategory CARD_CATEGORY_RED = CardCategory.refer(CARD_CATEGORY_RED_ID);public static final long CARD_CATEGORY_SECOND_YELLOW_ID = 1003l ;
  public static final CardCategory CARD_CATEGORY_SECOND_YELLOW = CardCategory.refer(CARD_CATEGORY_SECOND_YELLOW_ID);
  public static final long CONFEDERATION_AFC_ID = 1001l ;
  public static final Confederation CONFEDERATION_AFC = Confederation.refer(CONFEDERATION_AFC_ID);public static final long CONFEDERATION_CAF_ID = 1002l ;
  public static final Confederation CONFEDERATION_CAF = Confederation.refer(CONFEDERATION_CAF_ID);public static final long CONFEDERATION_CONCACAF_ID = 1003l ;
  public static final Confederation CONFEDERATION_CONCACAF = Confederation.refer(CONFEDERATION_CONCACAF_ID);public static final long CONFEDERATION_CONMEBOL_ID = 1004l ;
  public static final Confederation CONFEDERATION_CONMEBOL = Confederation.refer(CONFEDERATION_CONMEBOL_ID);public static final long CONFEDERATION_OFC_ID = 1005l ;
  public static final Confederation CONFEDERATION_OFC = Confederation.refer(CONFEDERATION_OFC_ID);public static final long CONFEDERATION_UEFA_ID = 1006l ;
  public static final Confederation CONFEDERATION_UEFA = Confederation.refer(CONFEDERATION_UEFA_ID);
}