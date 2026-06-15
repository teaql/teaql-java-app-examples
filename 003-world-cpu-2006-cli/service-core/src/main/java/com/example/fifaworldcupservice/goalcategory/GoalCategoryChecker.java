package com.example.fifaworldcupservice.goalcategory;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgoal.MatchGoalChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class GoalCategoryChecker implements Checker<GoalCategory>{

    public String type(){
        return GoalCategory.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, GoalCategory goalCategory, ObjectLocation _parentLocation){
        if(needCheck(_ctx, goalCategory)){
            markAsChecked(_ctx, goalCategory);
            doCheck(_ctx, goalCategory, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, GoalCategory goalCategory, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(goalCategory)){
         return;
      }
      if(goalCategory.newItem()){
      }else if(goalCategory.updateItem()){
      }
      checkName(_ctx, goalCategory.getProperty(GoalCategory.NAME_PROPERTY), newLocation(_parentLocation, GoalCategory.NAME_PROPERTY));
      checkCode(_ctx, goalCategory.getProperty(GoalCategory.CODE_PROPERTY), newLocation(_parentLocation, GoalCategory.CODE_PROPERTY));
      checkTournament(_ctx, goalCategory.getProperty(GoalCategory.TOURNAMENT_PROPERTY), newLocation(_parentLocation, GoalCategory.TOURNAMENT_PROPERTY));
      for(int i = 0; goalCategory.getMatchGoalList() != null && i < goalCategory.getMatchGoalList().size(); i++){
         MatchGoal matchGoal = goalCategory.getMatchGoalList().get(i);
         new MatchGoalChecker().checkAndFix(_ctx, matchGoal, newLocation(_parentLocation, GoalCategory.MATCH_GOAL_LIST_PROPERTY, i));
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