package com.example.fifaworldcupservice.cardcategory;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchcard.MatchCardChecker;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournament.TournamentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;

public class CardCategoryChecker implements Checker<CardCategory>{

    public String type(){
        return CardCategory.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, CardCategory cardCategory, ObjectLocation _parentLocation){
        if(needCheck(_ctx, cardCategory)){
            markAsChecked(_ctx, cardCategory);
            doCheck(_ctx, cardCategory, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, CardCategory cardCategory, ObjectLocation _parentLocation){
      if(ObjectUtil.isNull(cardCategory)){
         return;
      }
      if(cardCategory.newItem()){
      }else if(cardCategory.updateItem()){
      }
      checkName(_ctx, cardCategory.getProperty(CardCategory.NAME_PROPERTY), newLocation(_parentLocation, CardCategory.NAME_PROPERTY));
      checkCode(_ctx, cardCategory.getProperty(CardCategory.CODE_PROPERTY), newLocation(_parentLocation, CardCategory.CODE_PROPERTY));
      checkTournament(_ctx, cardCategory.getProperty(CardCategory.TOURNAMENT_PROPERTY), newLocation(_parentLocation, CardCategory.TOURNAMENT_PROPERTY));
      for(int i = 0; cardCategory.getMatchCardList() != null && i < cardCategory.getMatchCardList().size(); i++){
         MatchCard matchCard = cardCategory.getMatchCardList().get(i);
         new MatchCardChecker().checkAndFix(_ctx, matchCard, newLocation(_parentLocation, CardCategory.MATCH_CARD_LIST_PROPERTY, i));
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