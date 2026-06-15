package com.example.fifaworldcupservice.matchgoal;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.Constants;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class MatchGoal extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MatchGoal";

    public static final String PLAYER_NAME_PROPERTY = "playerName";
    public static final String MINUTE_SCORED_PROPERTY = "minuteScored";
    public static final String TOURNAMENT_MATCH_PROPERTY = "tournamentMatch";
    public static final String TOURNAMENT_TEAM_PROPERTY = "tournamentTeam";
    public static final String GOAL_CATEGORY_PROPERTY = "goalCategory";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String playerName;
    private Integer minuteScored;
    private TournamentMatch tournamentMatch;
    private TournamentTeam tournamentTeam;
    private GoalCategory goalCategory;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getPlayerName(){
        return this.playerName;
    }
    public Integer getMinuteScored(){
        return this.minuteScored;
    }
    public TournamentMatch getTournamentMatch(){
        return this.tournamentMatch;
    }
    public TournamentTeam getTournamentTeam(){
        return this.tournamentTeam;
    }
    public GoalCategory getGoalCategory(){
        return this.goalCategory;
    }
    public Tournament getTournament(){
        return this.tournament;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public MatchGoal updatePlayerName(String playerName){
        playerName = StrUtil.trim(playerName);
        if(ObjectUtil.equal(this.playerName, playerName)){
            return this;
        }
        handleUpdate(PLAYER_NAME_PROPERTY, getPlayerName(), playerName);
        this.playerName = playerName;
        return this;
    }
    public MatchGoal updateMinuteScored(Integer minuteScored){
        if(ObjectUtil.equal(this.minuteScored, minuteScored)){
            return this;
        }
        handleUpdate(MINUTE_SCORED_PROPERTY, getMinuteScored(), minuteScored);
        this.minuteScored = minuteScored;
        return this;
    }
    public MatchGoal updateTournamentMatch(TournamentMatch tournamentMatch){
        if(ObjectUtil.equal(this.tournamentMatch, tournamentMatch)){
            return this;
        }
        handleUpdate(TOURNAMENT_MATCH_PROPERTY, getTournamentMatch(), tournamentMatch);
        this.tournamentMatch = tournamentMatch;
        return this;
    }
    public MatchGoal updateTournamentTeam(TournamentTeam tournamentTeam){
        if(ObjectUtil.equal(this.tournamentTeam, tournamentTeam)){
            return this;
        }
        handleUpdate(TOURNAMENT_TEAM_PROPERTY, getTournamentTeam(), tournamentTeam);
        this.tournamentTeam = tournamentTeam;
        return this;
    }
    protected MatchGoal updateGoalCategory(GoalCategory goalCategory){
        if(ObjectUtil.equal(this.goalCategory, goalCategory)){
            return this;
        }
        handleUpdate(GOAL_CATEGORY_PROPERTY, getGoalCategory(), goalCategory);
        this.goalCategory = goalCategory;
        return this;
    }
    public MatchGoal updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public MatchGoal updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public MatchGoal updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public boolean isGoalCategoryNormal(){
        return ObjectUtil.equals(getGoalCategory(), Constants.GOAL_CATEGORY_NORMAL);
    }

    public MatchGoal updateGoalCategoryToNormal(){
        return updateGoalCategory(Constants.GOAL_CATEGORY_NORMAL);
    }
    public boolean isGoalCategoryPenalty(){
        return ObjectUtil.equals(getGoalCategory(), Constants.GOAL_CATEGORY_PENALTY);
    }

    public MatchGoal updateGoalCategoryToPenalty(){
        return updateGoalCategory(Constants.GOAL_CATEGORY_PENALTY);
    }
    public boolean isGoalCategoryOwnGoal(){
        return ObjectUtil.equals(getGoalCategory(), Constants.GOAL_CATEGORY_OWN_GOAL);
    }

    public MatchGoal updateGoalCategoryToOwnGoal(){
        return updateGoalCategory(Constants.GOAL_CATEGORY_OWN_GOAL);
    }
    public boolean isGoalCategoryFreeKick(){
        return ObjectUtil.equals(getGoalCategory(), Constants.GOAL_CATEGORY_FREE_KICK);
    }

    public MatchGoal updateGoalCategoryToFreeKick(){
        return updateGoalCategory(Constants.GOAL_CATEGORY_FREE_KICK);
    }

    public static MatchGoal refer(Long id){
        MatchGoal refer = new MatchGoal();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MatchGoal comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "playerName": this.playerName = StrUtil.trim((String) value); break;

            case "minuteScored": this.minuteScored = (Integer) value; break;

            case "tournamentMatch": this.tournamentMatch = (TournamentMatch) value; break;

            case "tournamentTeam": this.tournamentTeam = (TournamentTeam) value; break;

            case "goalCategory": this.goalCategory = (GoalCategory) value; break;

            case "tournament": this.tournament = (Tournament) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "playerName": return this.playerName;
            case "minuteScored": return this.minuteScored;
            case "tournamentMatch": return this.tournamentMatch;
            case "tournamentTeam": return this.tournamentTeam;
            case "goalCategory": return this.goalCategory;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.internalGet(property);
        }
    }

}