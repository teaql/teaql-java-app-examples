package com.example.fifaworldcupservice.cardcategory;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.tournament.Tournament;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class CardCategory extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "CardCategory";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String MATCH_CARD_LIST_PROPERTY = "matchCardList";
    private String name;
    private String code;
    private Tournament tournament;
    private SmartList<MatchCard> matchCardList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Tournament getTournament(){
        return this.tournament;
    }
    public SmartList<MatchCard> getMatchCardList(){
        return this.matchCardList;
    }
    public CardCategory updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public CardCategory updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public CardCategory updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public CardCategory addMatchCard(MatchCard matchCard){
        if (matchCard == null){
            return this;
        }

        if(null == this.matchCardList){
            this.matchCardList = new SmartList<>();
        }

        this.matchCardList.add(matchCard);
        matchCard.cacheRelation(MatchCard.CARD_CATEGORY_PROPERTY, this);
        return this;
    }

    public static CardCategory refer(Long id){
        CardCategory refer = new CardCategory();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public CardCategory comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = StrUtil.trim((String) value); break;

            case "code": this.code = StrUtil.trim((String) value); break;

            case "tournament": this.tournament = (Tournament) value; break;

            case "matchCardList": this.matchCardList = (SmartList<MatchCard>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "code": return this.code;
            case "tournament": return this.tournament;
            case "matchCardList": return this.matchCardList;
            default: return super.internalGet(property);
        }
    }

}