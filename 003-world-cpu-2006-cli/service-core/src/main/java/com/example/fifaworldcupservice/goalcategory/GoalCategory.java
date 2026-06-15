package com.example.fifaworldcupservice.goalcategory;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
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
public class GoalCategory extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "GoalCategory";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String MATCH_GOAL_LIST_PROPERTY = "matchGoalList";
    private String name;
    private String code;
    private Tournament tournament;
    private SmartList<MatchGoal> matchGoalList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Tournament getTournament(){
        return this.tournament;
    }
    public SmartList<MatchGoal> getMatchGoalList(){
        return this.matchGoalList;
    }
    public GoalCategory updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public GoalCategory updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public GoalCategory updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public GoalCategory addMatchGoal(MatchGoal matchGoal){
        if (matchGoal == null){
            return this;
        }

        if(null == this.matchGoalList){
            this.matchGoalList = new SmartList<>();
        }

        this.matchGoalList.add(matchGoal);
        matchGoal.cacheRelation(MatchGoal.GOAL_CATEGORY_PROPERTY, this);
        return this;
    }

    public static GoalCategory refer(Long id){
        GoalCategory refer = new GoalCategory();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public GoalCategory comment(String comment){
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

            case "matchGoalList": this.matchGoalList = (SmartList<MatchGoal>) value; break;
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
            case "matchGoalList": return this.matchGoalList;
            default: return super.internalGet(property);
        }
    }

}