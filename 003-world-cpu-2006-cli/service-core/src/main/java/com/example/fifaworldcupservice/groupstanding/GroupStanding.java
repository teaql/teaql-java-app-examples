package com.example.fifaworldcupservice.groupstanding;

import cn.hutool.core.util.ObjectUtil;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.tournament.Tournament;
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
public class GroupStanding extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "GroupStanding";

    public static final String PLAYED_PROPERTY = "played";
    public static final String WON_PROPERTY = "won";
    public static final String DRAWN_PROPERTY = "drawn";
    public static final String LOST_PROPERTY = "lost";
    public static final String GOALS_FOR_PROPERTY = "goalsFor";
    public static final String GOALS_AGAINST_PROPERTY = "goalsAgainst";
    public static final String GOAL_DIFFERENCE_PROPERTY = "goalDifference";
    public static final String POINTS_PROPERTY = "points";
    public static final String STANDING_RANK_PROPERTY = "standingRank";
    public static final String TOURNAMENT_TEAM_PROPERTY = "tournamentTeam";
    public static final String MATCH_GROUP_PROPERTY = "matchGroup";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Integer played;
    private Integer won;
    private Integer drawn;
    private Integer lost;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalDifference;
    private Integer points;
    private Integer standingRank;
    private TournamentTeam tournamentTeam;
    private MatchGroup matchGroup;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Integer getPlayed(){
        return this.played;
    }
    public Integer getWon(){
        return this.won;
    }
    public Integer getDrawn(){
        return this.drawn;
    }
    public Integer getLost(){
        return this.lost;
    }
    public Integer getGoalsFor(){
        return this.goalsFor;
    }
    public Integer getGoalsAgainst(){
        return this.goalsAgainst;
    }
    public Integer getGoalDifference(){
        return this.goalDifference;
    }
    public Integer getPoints(){
        return this.points;
    }
    public Integer getStandingRank(){
        return this.standingRank;
    }
    public TournamentTeam getTournamentTeam(){
        return this.tournamentTeam;
    }
    public MatchGroup getMatchGroup(){
        return this.matchGroup;
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
    public GroupStanding updatePlayed(Integer played){
        if(ObjectUtil.equal(this.played, played)){
            return this;
        }
        handleUpdate(PLAYED_PROPERTY, getPlayed(), played);
        this.played = played;
        return this;
    }
    public GroupStanding updateWon(Integer won){
        if(ObjectUtil.equal(this.won, won)){
            return this;
        }
        handleUpdate(WON_PROPERTY, getWon(), won);
        this.won = won;
        return this;
    }
    public GroupStanding updateDrawn(Integer drawn){
        if(ObjectUtil.equal(this.drawn, drawn)){
            return this;
        }
        handleUpdate(DRAWN_PROPERTY, getDrawn(), drawn);
        this.drawn = drawn;
        return this;
    }
    public GroupStanding updateLost(Integer lost){
        if(ObjectUtil.equal(this.lost, lost)){
            return this;
        }
        handleUpdate(LOST_PROPERTY, getLost(), lost);
        this.lost = lost;
        return this;
    }
    public GroupStanding updateGoalsFor(Integer goalsFor){
        if(ObjectUtil.equal(this.goalsFor, goalsFor)){
            return this;
        }
        handleUpdate(GOALS_FOR_PROPERTY, getGoalsFor(), goalsFor);
        this.goalsFor = goalsFor;
        return this;
    }
    public GroupStanding updateGoalsAgainst(Integer goalsAgainst){
        if(ObjectUtil.equal(this.goalsAgainst, goalsAgainst)){
            return this;
        }
        handleUpdate(GOALS_AGAINST_PROPERTY, getGoalsAgainst(), goalsAgainst);
        this.goalsAgainst = goalsAgainst;
        return this;
    }
    public GroupStanding updateGoalDifference(Integer goalDifference){
        if(ObjectUtil.equal(this.goalDifference, goalDifference)){
            return this;
        }
        handleUpdate(GOAL_DIFFERENCE_PROPERTY, getGoalDifference(), goalDifference);
        this.goalDifference = goalDifference;
        return this;
    }
    public GroupStanding updatePoints(Integer points){
        if(ObjectUtil.equal(this.points, points)){
            return this;
        }
        handleUpdate(POINTS_PROPERTY, getPoints(), points);
        this.points = points;
        return this;
    }
    public GroupStanding updateStandingRank(Integer standingRank){
        if(ObjectUtil.equal(this.standingRank, standingRank)){
            return this;
        }
        handleUpdate(STANDING_RANK_PROPERTY, getStandingRank(), standingRank);
        this.standingRank = standingRank;
        return this;
    }
    public GroupStanding updateTournamentTeam(TournamentTeam tournamentTeam){
        if(ObjectUtil.equal(this.tournamentTeam, tournamentTeam)){
            return this;
        }
        handleUpdate(TOURNAMENT_TEAM_PROPERTY, getTournamentTeam(), tournamentTeam);
        this.tournamentTeam = tournamentTeam;
        return this;
    }
    public GroupStanding updateMatchGroup(MatchGroup matchGroup){
        if(ObjectUtil.equal(this.matchGroup, matchGroup)){
            return this;
        }
        handleUpdate(MATCH_GROUP_PROPERTY, getMatchGroup(), matchGroup);
        this.matchGroup = matchGroup;
        return this;
    }
    public GroupStanding updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public GroupStanding updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public GroupStanding updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static GroupStanding refer(Long id){
        GroupStanding refer = new GroupStanding();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public GroupStanding comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "played": this.played = (Integer) value; break;

            case "won": this.won = (Integer) value; break;

            case "drawn": this.drawn = (Integer) value; break;

            case "lost": this.lost = (Integer) value; break;

            case "goalsFor": this.goalsFor = (Integer) value; break;

            case "goalsAgainst": this.goalsAgainst = (Integer) value; break;

            case "goalDifference": this.goalDifference = (Integer) value; break;

            case "points": this.points = (Integer) value; break;

            case "standingRank": this.standingRank = (Integer) value; break;

            case "tournamentTeam": this.tournamentTeam = (TournamentTeam) value; break;

            case "matchGroup": this.matchGroup = (MatchGroup) value; break;

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
            case "played": return this.played;
            case "won": return this.won;
            case "drawn": return this.drawn;
            case "lost": return this.lost;
            case "goalsFor": return this.goalsFor;
            case "goalsAgainst": return this.goalsAgainst;
            case "goalDifference": return this.goalDifference;
            case "points": return this.points;
            case "standingRank": return this.standingRank;
            case "tournamentTeam": return this.tournamentTeam;
            case "matchGroup": return this.matchGroup;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.internalGet(property);
        }
    }

}