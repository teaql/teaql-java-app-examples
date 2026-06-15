package com.example.fifaworldcupservice.tournament;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.goalcategory.GoalCategory;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.matchgroup.MatchGroup;
import com.example.fifaworldcupservice.matchstage.MatchStage;
import com.example.fifaworldcupservice.matchstatus.MatchStatus;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
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
public class Tournament extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Tournament";

    public static final String TOURNAMENT_NAME_PROPERTY = "tournamentName";
    public static final String HOST_COUNTRIES_PROPERTY = "hostCountries";
    public static final String START_DATE_PROPERTY = "startDate";
    public static final String END_DATE_PROPERTY = "endDate";
    public static final String TOTAL_TEAMS_PROPERTY = "totalTeams";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String MATCH_STAGE_LIST_PROPERTY = "matchStageList";
    public static final String MATCH_STATUS_LIST_PROPERTY = "matchStatusList";
    public static final String GOAL_CATEGORY_LIST_PROPERTY = "goalCategoryList";
    public static final String CARD_CATEGORY_LIST_PROPERTY = "cardCategoryList";
    public static final String CONFEDERATION_LIST_PROPERTY = "confederationList";
    public static final String TOURNAMENT_TEAM_LIST_PROPERTY = "tournamentTeamList";
    public static final String MATCH_GROUP_LIST_PROPERTY = "matchGroupList";
    public static final String TOURNAMENT_MATCH_LIST_PROPERTY = "tournamentMatchList";
    public static final String MATCH_GOAL_LIST_PROPERTY = "matchGoalList";
    public static final String MATCH_CARD_LIST_PROPERTY = "matchCardList";
    public static final String GROUP_STANDING_LIST_PROPERTY = "groupStandingList";
    private String tournamentName;
    private String hostCountries;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalTeams;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<MatchStage> matchStageList;
    private SmartList<MatchStatus> matchStatusList;
    private SmartList<GoalCategory> goalCategoryList;
    private SmartList<CardCategory> cardCategoryList;
    private SmartList<Confederation> confederationList;
    private SmartList<TournamentTeam> tournamentTeamList;
    private SmartList<MatchGroup> matchGroupList;
    private SmartList<TournamentMatch> tournamentMatchList;
    private SmartList<MatchGoal> matchGoalList;
    private SmartList<MatchCard> matchCardList;
    private SmartList<GroupStanding> groupStandingList;

    public String getTournamentName(){
        return this.tournamentName;
    }
    public String getHostCountries(){
        return this.hostCountries;
    }
    public LocalDate getStartDate(){
        return this.startDate;
    }
    public LocalDate getEndDate(){
        return this.endDate;
    }
    public Integer getTotalTeams(){
        return this.totalTeams;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<MatchStage> getMatchStageList(){
        return this.matchStageList;
    }
    public SmartList<MatchStatus> getMatchStatusList(){
        return this.matchStatusList;
    }
    public SmartList<GoalCategory> getGoalCategoryList(){
        return this.goalCategoryList;
    }
    public SmartList<CardCategory> getCardCategoryList(){
        return this.cardCategoryList;
    }
    public SmartList<Confederation> getConfederationList(){
        return this.confederationList;
    }
    public SmartList<TournamentTeam> getTournamentTeamList(){
        return this.tournamentTeamList;
    }
    public SmartList<MatchGroup> getMatchGroupList(){
        return this.matchGroupList;
    }
    public SmartList<TournamentMatch> getTournamentMatchList(){
        return this.tournamentMatchList;
    }
    public SmartList<MatchGoal> getMatchGoalList(){
        return this.matchGoalList;
    }
    public SmartList<MatchCard> getMatchCardList(){
        return this.matchCardList;
    }
    public SmartList<GroupStanding> getGroupStandingList(){
        return this.groupStandingList;
    }
    public Tournament updateTournamentName(String tournamentName){
        tournamentName = StrUtil.trim(tournamentName);
        if(ObjectUtil.equal(this.tournamentName, tournamentName)){
            return this;
        }
        handleUpdate(TOURNAMENT_NAME_PROPERTY, getTournamentName(), tournamentName);
        this.tournamentName = tournamentName;
        return this;
    }
    public Tournament updateHostCountries(String hostCountries){
        hostCountries = StrUtil.trim(hostCountries);
        if(ObjectUtil.equal(this.hostCountries, hostCountries)){
            return this;
        }
        handleUpdate(HOST_COUNTRIES_PROPERTY, getHostCountries(), hostCountries);
        this.hostCountries = hostCountries;
        return this;
    }
    public Tournament updateStartDate(LocalDate startDate){
        if(ObjectUtil.equal(this.startDate, startDate)){
            return this;
        }
        handleUpdate(START_DATE_PROPERTY, getStartDate(), startDate);
        this.startDate = startDate;
        return this;
    }
    public Tournament updateEndDate(LocalDate endDate){
        if(ObjectUtil.equal(this.endDate, endDate)){
            return this;
        }
        handleUpdate(END_DATE_PROPERTY, getEndDate(), endDate);
        this.endDate = endDate;
        return this;
    }
    public Tournament updateTotalTeams(Integer totalTeams){
        if(ObjectUtil.equal(this.totalTeams, totalTeams)){
            return this;
        }
        handleUpdate(TOTAL_TEAMS_PROPERTY, getTotalTeams(), totalTeams);
        this.totalTeams = totalTeams;
        return this;
    }
    public Tournament updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Tournament updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Tournament addMatchStage(MatchStage matchStage){
        if (matchStage == null){
            return this;
        }

        if(null == this.matchStageList){
            this.matchStageList = new SmartList<>();
        }

        this.matchStageList.add(matchStage);
        matchStage.cacheRelation(MatchStage.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addMatchStatus(MatchStatus matchStatus){
        if (matchStatus == null){
            return this;
        }

        if(null == this.matchStatusList){
            this.matchStatusList = new SmartList<>();
        }

        this.matchStatusList.add(matchStatus);
        matchStatus.cacheRelation(MatchStatus.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addGoalCategory(GoalCategory goalCategory){
        if (goalCategory == null){
            return this;
        }

        if(null == this.goalCategoryList){
            this.goalCategoryList = new SmartList<>();
        }

        this.goalCategoryList.add(goalCategory);
        goalCategory.cacheRelation(GoalCategory.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addCardCategory(CardCategory cardCategory){
        if (cardCategory == null){
            return this;
        }

        if(null == this.cardCategoryList){
            this.cardCategoryList = new SmartList<>();
        }

        this.cardCategoryList.add(cardCategory);
        cardCategory.cacheRelation(CardCategory.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addConfederation(Confederation confederation){
        if (confederation == null){
            return this;
        }

        if(null == this.confederationList){
            this.confederationList = new SmartList<>();
        }

        this.confederationList.add(confederation);
        confederation.cacheRelation(Confederation.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addTournamentTeam(TournamentTeam tournamentTeam){
        if (tournamentTeam == null){
            return this;
        }

        if(null == this.tournamentTeamList){
            this.tournamentTeamList = new SmartList<>();
        }

        this.tournamentTeamList.add(tournamentTeam);
        tournamentTeam.cacheRelation(TournamentTeam.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addMatchGroup(MatchGroup matchGroup){
        if (matchGroup == null){
            return this;
        }

        if(null == this.matchGroupList){
            this.matchGroupList = new SmartList<>();
        }

        this.matchGroupList.add(matchGroup);
        matchGroup.cacheRelation(MatchGroup.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addTournamentMatch(TournamentMatch tournamentMatch){
        if (tournamentMatch == null){
            return this;
        }

        if(null == this.tournamentMatchList){
            this.tournamentMatchList = new SmartList<>();
        }

        this.tournamentMatchList.add(tournamentMatch);
        tournamentMatch.cacheRelation(TournamentMatch.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addMatchGoal(MatchGoal matchGoal){
        if (matchGoal == null){
            return this;
        }

        if(null == this.matchGoalList){
            this.matchGoalList = new SmartList<>();
        }

        this.matchGoalList.add(matchGoal);
        matchGoal.cacheRelation(MatchGoal.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addMatchCard(MatchCard matchCard){
        if (matchCard == null){
            return this;
        }

        if(null == this.matchCardList){
            this.matchCardList = new SmartList<>();
        }

        this.matchCardList.add(matchCard);
        matchCard.cacheRelation(MatchCard.TOURNAMENT_PROPERTY, this);
        return this;
    }
    public Tournament addGroupStanding(GroupStanding groupStanding){
        if (groupStanding == null){
            return this;
        }

        if(null == this.groupStandingList){
            this.groupStandingList = new SmartList<>();
        }

        this.groupStandingList.add(groupStanding);
        groupStanding.cacheRelation(GroupStanding.TOURNAMENT_PROPERTY, this);
        return this;
    }

    public static Tournament refer(Long id){
        Tournament refer = new Tournament();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Tournament comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "tournamentName": this.tournamentName = StrUtil.trim((String) value); break;

            case "hostCountries": this.hostCountries = StrUtil.trim((String) value); break;

            case "startDate": this.startDate = (LocalDate) value; break;

            case "endDate": this.endDate = (LocalDate) value; break;

            case "totalTeams": this.totalTeams = (Integer) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "matchStageList": this.matchStageList = (SmartList<MatchStage>) value; break;
            case "matchStatusList": this.matchStatusList = (SmartList<MatchStatus>) value; break;
            case "goalCategoryList": this.goalCategoryList = (SmartList<GoalCategory>) value; break;
            case "cardCategoryList": this.cardCategoryList = (SmartList<CardCategory>) value; break;
            case "confederationList": this.confederationList = (SmartList<Confederation>) value; break;
            case "tournamentTeamList": this.tournamentTeamList = (SmartList<TournamentTeam>) value; break;
            case "matchGroupList": this.matchGroupList = (SmartList<MatchGroup>) value; break;
            case "tournamentMatchList": this.tournamentMatchList = (SmartList<TournamentMatch>) value; break;
            case "matchGoalList": this.matchGoalList = (SmartList<MatchGoal>) value; break;
            case "matchCardList": this.matchCardList = (SmartList<MatchCard>) value; break;
            case "groupStandingList": this.groupStandingList = (SmartList<GroupStanding>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "tournamentName": return this.tournamentName;
            case "hostCountries": return this.hostCountries;
            case "startDate": return this.startDate;
            case "endDate": return this.endDate;
            case "totalTeams": return this.totalTeams;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "matchStageList": return this.matchStageList;
            case "matchStatusList": return this.matchStatusList;
            case "goalCategoryList": return this.goalCategoryList;
            case "cardCategoryList": return this.cardCategoryList;
            case "confederationList": return this.confederationList;
            case "tournamentTeamList": return this.tournamentTeamList;
            case "matchGroupList": return this.matchGroupList;
            case "tournamentMatchList": return this.tournamentMatchList;
            case "matchGoalList": return this.matchGoalList;
            case "matchCardList": return this.matchCardList;
            case "groupStandingList": return this.groupStandingList;
            default: return super.internalGet(property);
        }
    }

}