package com.example.fifaworldcupservice.tournamentmatch;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.Constants;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class TournamentMatch extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TournamentMatch";

    public static final String MATCH_NUMBER_PROPERTY = "matchNumber";
    public static final String MATCH_DATE_PROPERTY = "matchDate";
    public static final String VENUE_NAME_PROPERTY = "venueName";
    public static final String VENUE_CITY_PROPERTY = "venueCity";
    public static final String VENUE_COUNTRY_PROPERTY = "venueCountry";
    public static final String HOME_SCORE_PROPERTY = "homeScore";
    public static final String AWAY_SCORE_PROPERTY = "awayScore";
    public static final String EXTRA_TIME_HOME_PROPERTY = "extraTimeHome";
    public static final String EXTRA_TIME_AWAY_PROPERTY = "extraTimeAway";
    public static final String PENALTY_HOME_PROPERTY = "penaltyHome";
    public static final String PENALTY_AWAY_PROPERTY = "penaltyAway";
    public static final String HOME_TEAM_PROPERTY = "homeTeam";
    public static final String AWAY_TEAM_PROPERTY = "awayTeam";
    public static final String MATCH_STAGE_PROPERTY = "matchStage";
    public static final String MATCH_GROUP_PROPERTY = "matchGroup";
    public static final String MATCH_STATUS_PROPERTY = "matchStatus";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String MATCH_GOAL_LIST_PROPERTY = "matchGoalList";
    public static final String MATCH_CARD_LIST_PROPERTY = "matchCardList";
    private Integer matchNumber;
    private LocalDate matchDate;
    private String venueName;
    private String venueCity;
    private String venueCountry;
    private Integer homeScore;
    private Integer awayScore;
    private Integer extraTimeHome;
    private Integer extraTimeAway;
    private Integer penaltyHome;
    private Integer penaltyAway;
    private TournamentTeam homeTeam;
    private TournamentTeam awayTeam;
    private MatchStage matchStage;
    private MatchGroup matchGroup;
    private MatchStatus matchStatus;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<MatchGoal> matchGoalList;
    private SmartList<MatchCard> matchCardList;

    public Integer getMatchNumber(){
        return this.matchNumber;
    }
    public LocalDate getMatchDate(){
        return this.matchDate;
    }
    public String getVenueName(){
        return this.venueName;
    }
    public String getVenueCity(){
        return this.venueCity;
    }
    public String getVenueCountry(){
        return this.venueCountry;
    }
    public Integer getHomeScore(){
        return this.homeScore;
    }
    public Integer getAwayScore(){
        return this.awayScore;
    }
    public Integer getExtraTimeHome(){
        return this.extraTimeHome;
    }
    public Integer getExtraTimeAway(){
        return this.extraTimeAway;
    }
    public Integer getPenaltyHome(){
        return this.penaltyHome;
    }
    public Integer getPenaltyAway(){
        return this.penaltyAway;
    }
    public TournamentTeam getHomeTeam(){
        return this.homeTeam;
    }
    public TournamentTeam getAwayTeam(){
        return this.awayTeam;
    }
    public MatchStage getMatchStage(){
        return this.matchStage;
    }
    public MatchGroup getMatchGroup(){
        return this.matchGroup;
    }
    public MatchStatus getMatchStatus(){
        return this.matchStatus;
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
    public SmartList<MatchGoal> getMatchGoalList(){
        return this.matchGoalList;
    }
    public SmartList<MatchCard> getMatchCardList(){
        return this.matchCardList;
    }
    public TournamentMatch updateMatchNumber(Integer matchNumber){
        if(ObjectUtil.equal(this.matchNumber, matchNumber)){
            return this;
        }
        handleUpdate(MATCH_NUMBER_PROPERTY, getMatchNumber(), matchNumber);
        this.matchNumber = matchNumber;
        return this;
    }
    public TournamentMatch updateMatchDate(LocalDate matchDate){
        if(ObjectUtil.equal(this.matchDate, matchDate)){
            return this;
        }
        handleUpdate(MATCH_DATE_PROPERTY, getMatchDate(), matchDate);
        this.matchDate = matchDate;
        return this;
    }
    public TournamentMatch updateVenueName(String venueName){
        venueName = StrUtil.trim(venueName);
        if(ObjectUtil.equal(this.venueName, venueName)){
            return this;
        }
        handleUpdate(VENUE_NAME_PROPERTY, getVenueName(), venueName);
        this.venueName = venueName;
        return this;
    }
    public TournamentMatch updateVenueCity(String venueCity){
        venueCity = StrUtil.trim(venueCity);
        if(ObjectUtil.equal(this.venueCity, venueCity)){
            return this;
        }
        handleUpdate(VENUE_CITY_PROPERTY, getVenueCity(), venueCity);
        this.venueCity = venueCity;
        return this;
    }
    public TournamentMatch updateVenueCountry(String venueCountry){
        venueCountry = StrUtil.trim(venueCountry);
        if(ObjectUtil.equal(this.venueCountry, venueCountry)){
            return this;
        }
        handleUpdate(VENUE_COUNTRY_PROPERTY, getVenueCountry(), venueCountry);
        this.venueCountry = venueCountry;
        return this;
    }
    public TournamentMatch updateHomeScore(Integer homeScore){
        if(ObjectUtil.equal(this.homeScore, homeScore)){
            return this;
        }
        handleUpdate(HOME_SCORE_PROPERTY, getHomeScore(), homeScore);
        this.homeScore = homeScore;
        return this;
    }
    public TournamentMatch updateAwayScore(Integer awayScore){
        if(ObjectUtil.equal(this.awayScore, awayScore)){
            return this;
        }
        handleUpdate(AWAY_SCORE_PROPERTY, getAwayScore(), awayScore);
        this.awayScore = awayScore;
        return this;
    }
    public TournamentMatch updateExtraTimeHome(Integer extraTimeHome){
        if(ObjectUtil.equal(this.extraTimeHome, extraTimeHome)){
            return this;
        }
        handleUpdate(EXTRA_TIME_HOME_PROPERTY, getExtraTimeHome(), extraTimeHome);
        this.extraTimeHome = extraTimeHome;
        return this;
    }
    public TournamentMatch updateExtraTimeAway(Integer extraTimeAway){
        if(ObjectUtil.equal(this.extraTimeAway, extraTimeAway)){
            return this;
        }
        handleUpdate(EXTRA_TIME_AWAY_PROPERTY, getExtraTimeAway(), extraTimeAway);
        this.extraTimeAway = extraTimeAway;
        return this;
    }
    public TournamentMatch updatePenaltyHome(Integer penaltyHome){
        if(ObjectUtil.equal(this.penaltyHome, penaltyHome)){
            return this;
        }
        handleUpdate(PENALTY_HOME_PROPERTY, getPenaltyHome(), penaltyHome);
        this.penaltyHome = penaltyHome;
        return this;
    }
    public TournamentMatch updatePenaltyAway(Integer penaltyAway){
        if(ObjectUtil.equal(this.penaltyAway, penaltyAway)){
            return this;
        }
        handleUpdate(PENALTY_AWAY_PROPERTY, getPenaltyAway(), penaltyAway);
        this.penaltyAway = penaltyAway;
        return this;
    }
    public TournamentMatch updateHomeTeam(TournamentTeam homeTeam){
        if(ObjectUtil.equal(this.homeTeam, homeTeam)){
            return this;
        }
        handleUpdate(HOME_TEAM_PROPERTY, getHomeTeam(), homeTeam);
        this.homeTeam = homeTeam;
        return this;
    }
    public TournamentMatch updateAwayTeam(TournamentTeam awayTeam){
        if(ObjectUtil.equal(this.awayTeam, awayTeam)){
            return this;
        }
        handleUpdate(AWAY_TEAM_PROPERTY, getAwayTeam(), awayTeam);
        this.awayTeam = awayTeam;
        return this;
    }
    protected TournamentMatch updateMatchStage(MatchStage matchStage){
        if(ObjectUtil.equal(this.matchStage, matchStage)){
            return this;
        }
        handleUpdate(MATCH_STAGE_PROPERTY, getMatchStage(), matchStage);
        this.matchStage = matchStage;
        return this;
    }
    public TournamentMatch updateMatchGroup(MatchGroup matchGroup){
        if(ObjectUtil.equal(this.matchGroup, matchGroup)){
            return this;
        }
        handleUpdate(MATCH_GROUP_PROPERTY, getMatchGroup(), matchGroup);
        this.matchGroup = matchGroup;
        return this;
    }
    protected TournamentMatch updateMatchStatus(MatchStatus matchStatus){
        if(ObjectUtil.equal(this.matchStatus, matchStatus)){
            return this;
        }
        handleUpdate(MATCH_STATUS_PROPERTY, getMatchStatus(), matchStatus);
        this.matchStatus = matchStatus;
        return this;
    }
    public TournamentMatch updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public TournamentMatch updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public TournamentMatch updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public TournamentMatch addMatchGoal(MatchGoal matchGoal){
        if (matchGoal == null){
            return this;
        }

        if(null == this.matchGoalList){
            this.matchGoalList = new SmartList<>();
        }

        this.matchGoalList.add(matchGoal);
        matchGoal.cacheRelation(MatchGoal.TOURNAMENT_MATCH_PROPERTY, this);
        return this;
    }
    public TournamentMatch addMatchCard(MatchCard matchCard){
        if (matchCard == null){
            return this;
        }

        if(null == this.matchCardList){
            this.matchCardList = new SmartList<>();
        }

        this.matchCardList.add(matchCard);
        matchCard.cacheRelation(MatchCard.TOURNAMENT_MATCH_PROPERTY, this);
        return this;
    }
    public boolean isMatchStageGroup(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_GROUP);
    }

    public TournamentMatch updateMatchStageToGroup(){
        return updateMatchStage(Constants.MATCH_STAGE_GROUP);
    }
    public boolean isMatchStageRoundOf32(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_ROUND_OF_32);
    }

    public TournamentMatch updateMatchStageToRoundOf32(){
        return updateMatchStage(Constants.MATCH_STAGE_ROUND_OF_32);
    }
    public boolean isMatchStageRoundOf16(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_ROUND_OF_16);
    }

    public TournamentMatch updateMatchStageToRoundOf16(){
        return updateMatchStage(Constants.MATCH_STAGE_ROUND_OF_16);
    }
    public boolean isMatchStageQuarterFinal(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_QUARTER_FINAL);
    }

    public TournamentMatch updateMatchStageToQuarterFinal(){
        return updateMatchStage(Constants.MATCH_STAGE_QUARTER_FINAL);
    }
    public boolean isMatchStageSemiFinal(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_SEMI_FINAL);
    }

    public TournamentMatch updateMatchStageToSemiFinal(){
        return updateMatchStage(Constants.MATCH_STAGE_SEMI_FINAL);
    }
    public boolean isMatchStageThirdPlace(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_THIRD_PLACE);
    }

    public TournamentMatch updateMatchStageToThirdPlace(){
        return updateMatchStage(Constants.MATCH_STAGE_THIRD_PLACE);
    }
    public boolean isMatchStageFinal(){
        return ObjectUtil.equals(getMatchStage(), Constants.MATCH_STAGE_FINAL);
    }

    public TournamentMatch updateMatchStageToFinal(){
        return updateMatchStage(Constants.MATCH_STAGE_FINAL);
    }
    public boolean isMatchStatusScheduled(){
        return ObjectUtil.equals(getMatchStatus(), Constants.MATCH_STATUS_SCHEDULED);
    }

    public TournamentMatch updateMatchStatusToScheduled(){
        return updateMatchStatus(Constants.MATCH_STATUS_SCHEDULED);
    }
    public boolean isMatchStatusLive(){
        return ObjectUtil.equals(getMatchStatus(), Constants.MATCH_STATUS_LIVE);
    }

    public TournamentMatch updateMatchStatusToLive(){
        return updateMatchStatus(Constants.MATCH_STATUS_LIVE);
    }
    public boolean isMatchStatusFinished(){
        return ObjectUtil.equals(getMatchStatus(), Constants.MATCH_STATUS_FINISHED);
    }

    public TournamentMatch updateMatchStatusToFinished(){
        return updateMatchStatus(Constants.MATCH_STATUS_FINISHED);
    }
    public boolean isMatchStatusPostponed(){
        return ObjectUtil.equals(getMatchStatus(), Constants.MATCH_STATUS_POSTPONED);
    }

    public TournamentMatch updateMatchStatusToPostponed(){
        return updateMatchStatus(Constants.MATCH_STATUS_POSTPONED);
    }

    public static TournamentMatch refer(Long id){
        TournamentMatch refer = new TournamentMatch();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TournamentMatch comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "matchNumber": this.matchNumber = (Integer) value; break;

            case "matchDate": this.matchDate = (LocalDate) value; break;

            case "venueName": this.venueName = StrUtil.trim((String) value); break;

            case "venueCity": this.venueCity = StrUtil.trim((String) value); break;

            case "venueCountry": this.venueCountry = StrUtil.trim((String) value); break;

            case "homeScore": this.homeScore = (Integer) value; break;

            case "awayScore": this.awayScore = (Integer) value; break;

            case "extraTimeHome": this.extraTimeHome = (Integer) value; break;

            case "extraTimeAway": this.extraTimeAway = (Integer) value; break;

            case "penaltyHome": this.penaltyHome = (Integer) value; break;

            case "penaltyAway": this.penaltyAway = (Integer) value; break;

            case "homeTeam": this.homeTeam = (TournamentTeam) value; break;

            case "awayTeam": this.awayTeam = (TournamentTeam) value; break;

            case "matchStage": this.matchStage = (MatchStage) value; break;

            case "matchGroup": this.matchGroup = (MatchGroup) value; break;

            case "matchStatus": this.matchStatus = (MatchStatus) value; break;

            case "tournament": this.tournament = (Tournament) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "matchGoalList": this.matchGoalList = (SmartList<MatchGoal>) value; break;
            case "matchCardList": this.matchCardList = (SmartList<MatchCard>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "matchNumber": return this.matchNumber;
            case "matchDate": return this.matchDate;
            case "venueName": return this.venueName;
            case "venueCity": return this.venueCity;
            case "venueCountry": return this.venueCountry;
            case "homeScore": return this.homeScore;
            case "awayScore": return this.awayScore;
            case "extraTimeHome": return this.extraTimeHome;
            case "extraTimeAway": return this.extraTimeAway;
            case "penaltyHome": return this.penaltyHome;
            case "penaltyAway": return this.penaltyAway;
            case "homeTeam": return this.homeTeam;
            case "awayTeam": return this.awayTeam;
            case "matchStage": return this.matchStage;
            case "matchGroup": return this.matchGroup;
            case "matchStatus": return this.matchStatus;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "matchGoalList": return this.matchGoalList;
            case "matchCardList": return this.matchCardList;
            default: return super.internalGet(property);
        }
    }

}