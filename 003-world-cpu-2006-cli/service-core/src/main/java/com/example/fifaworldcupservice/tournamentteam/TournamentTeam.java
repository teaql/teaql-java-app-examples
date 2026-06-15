package com.example.fifaworldcupservice.tournamentteam;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.Constants;
import com.example.fifaworldcupservice.confederation.Confederation;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
import com.example.fifaworldcupservice.matchcard.MatchCard;
import com.example.fifaworldcupservice.matchgoal.MatchGoal;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDateTime;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class TournamentTeam extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TournamentTeam";

    public static final String TEAM_NAME_PROPERTY = "teamName";
    public static final String TEAM_CODE_PROPERTY = "teamCode";
    public static final String EMOJI_FLAG_PROPERTY = "emojiFlag";
    public static final String FIFA_RANKING_PROPERTY = "fifaRanking";
    public static final String MANAGER_NAME_PROPERTY = "managerName";
    public static final String CONFEDERATION_PROPERTY = "confederation";
    public static final String GROUP_LETTER_PROPERTY = "groupLetter";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TOURNAMENT_MATCH_LIST_AS_HOME_TEAM_PROPERTY = "tournamentMatchListAsHomeTeam";
    public static final String TOURNAMENT_MATCH_LIST_AS_AWAY_TEAM_PROPERTY = "tournamentMatchListAsAwayTeam";
    public static final String MATCH_GOAL_LIST_PROPERTY = "matchGoalList";
    public static final String MATCH_CARD_LIST_PROPERTY = "matchCardList";
    public static final String GROUP_STANDING_LIST_PROPERTY = "groupStandingList";
    private String teamName;
    private String teamCode;
    private String emojiFlag;
    private Integer fifaRanking;
    private String managerName;
    private Confederation confederation;
    private String groupLetter;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<TournamentMatch> tournamentMatchListAsHomeTeam;
    private SmartList<TournamentMatch> tournamentMatchListAsAwayTeam;
    private SmartList<MatchGoal> matchGoalList;
    private SmartList<MatchCard> matchCardList;
    private SmartList<GroupStanding> groupStandingList;

    public String getTeamName(){
        return this.teamName;
    }
    public String getTeamCode(){
        return this.teamCode;
    }
    public String getEmojiFlag(){
        return this.emojiFlag;
    }
    public Integer getFifaRanking(){
        return this.fifaRanking;
    }
    public String getManagerName(){
        return this.managerName;
    }
    public Confederation getConfederation(){
        return this.confederation;
    }
    public String getGroupLetter(){
        return this.groupLetter;
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
    public SmartList<TournamentMatch> getTournamentMatchListAsHomeTeam(){
        return this.tournamentMatchListAsHomeTeam;
    }
    public SmartList<TournamentMatch> getTournamentMatchListAsAwayTeam(){
        return this.tournamentMatchListAsAwayTeam;
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
    public TournamentTeam updateTeamName(String teamName){
        teamName = StrUtil.trim(teamName);
        if(ObjectUtil.equal(this.teamName, teamName)){
            return this;
        }
        handleUpdate(TEAM_NAME_PROPERTY, getTeamName(), teamName);
        this.teamName = teamName;
        return this;
    }
    public TournamentTeam updateTeamCode(String teamCode){
        teamCode = StrUtil.trim(teamCode);
        if(ObjectUtil.equal(this.teamCode, teamCode)){
            return this;
        }
        handleUpdate(TEAM_CODE_PROPERTY, getTeamCode(), teamCode);
        this.teamCode = teamCode;
        return this;
    }
    public TournamentTeam updateEmojiFlag(String emojiFlag){
        emojiFlag = StrUtil.trim(emojiFlag);
        if(ObjectUtil.equal(this.emojiFlag, emojiFlag)){
            return this;
        }
        handleUpdate(EMOJI_FLAG_PROPERTY, getEmojiFlag(), emojiFlag);
        this.emojiFlag = emojiFlag;
        return this;
    }
    public TournamentTeam updateFifaRanking(Integer fifaRanking){
        if(ObjectUtil.equal(this.fifaRanking, fifaRanking)){
            return this;
        }
        handleUpdate(FIFA_RANKING_PROPERTY, getFifaRanking(), fifaRanking);
        this.fifaRanking = fifaRanking;
        return this;
    }
    public TournamentTeam updateManagerName(String managerName){
        managerName = StrUtil.trim(managerName);
        if(ObjectUtil.equal(this.managerName, managerName)){
            return this;
        }
        handleUpdate(MANAGER_NAME_PROPERTY, getManagerName(), managerName);
        this.managerName = managerName;
        return this;
    }
    protected TournamentTeam updateConfederation(Confederation confederation){
        if(ObjectUtil.equal(this.confederation, confederation)){
            return this;
        }
        handleUpdate(CONFEDERATION_PROPERTY, getConfederation(), confederation);
        this.confederation = confederation;
        return this;
    }
    public TournamentTeam updateGroupLetter(String groupLetter){
        groupLetter = StrUtil.trim(groupLetter);
        if(ObjectUtil.equal(this.groupLetter, groupLetter)){
            return this;
        }
        handleUpdate(GROUP_LETTER_PROPERTY, getGroupLetter(), groupLetter);
        this.groupLetter = groupLetter;
        return this;
    }
    public TournamentTeam updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public TournamentTeam updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public TournamentTeam updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public TournamentTeam addTournamentMatchAsHomeTeam(TournamentMatch tournamentMatch){
        if (tournamentMatch == null){
            return this;
        }

        if(null == this.tournamentMatchListAsHomeTeam){
            this.tournamentMatchListAsHomeTeam = new SmartList<>();
        }

        this.tournamentMatchListAsHomeTeam.add(tournamentMatch);
        tournamentMatch.cacheRelation(TournamentMatch.HOME_TEAM_PROPERTY, this);
        return this;
    }
    public TournamentTeam addTournamentMatchAsAwayTeam(TournamentMatch tournamentMatch){
        if (tournamentMatch == null){
            return this;
        }

        if(null == this.tournamentMatchListAsAwayTeam){
            this.tournamentMatchListAsAwayTeam = new SmartList<>();
        }

        this.tournamentMatchListAsAwayTeam.add(tournamentMatch);
        tournamentMatch.cacheRelation(TournamentMatch.AWAY_TEAM_PROPERTY, this);
        return this;
    }
    public TournamentTeam addMatchGoal(MatchGoal matchGoal){
        if (matchGoal == null){
            return this;
        }

        if(null == this.matchGoalList){
            this.matchGoalList = new SmartList<>();
        }

        this.matchGoalList.add(matchGoal);
        matchGoal.cacheRelation(MatchGoal.TOURNAMENT_TEAM_PROPERTY, this);
        return this;
    }
    public TournamentTeam addMatchCard(MatchCard matchCard){
        if (matchCard == null){
            return this;
        }

        if(null == this.matchCardList){
            this.matchCardList = new SmartList<>();
        }

        this.matchCardList.add(matchCard);
        matchCard.cacheRelation(MatchCard.TOURNAMENT_TEAM_PROPERTY, this);
        return this;
    }
    public TournamentTeam addGroupStanding(GroupStanding groupStanding){
        if (groupStanding == null){
            return this;
        }

        if(null == this.groupStandingList){
            this.groupStandingList = new SmartList<>();
        }

        this.groupStandingList.add(groupStanding);
        groupStanding.cacheRelation(GroupStanding.TOURNAMENT_TEAM_PROPERTY, this);
        return this;
    }
    public boolean isConfederationAfc(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_AFC);
    }

    public TournamentTeam updateConfederationToAfc(){
        return updateConfederation(Constants.CONFEDERATION_AFC);
    }
    public boolean isConfederationCaf(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_CAF);
    }

    public TournamentTeam updateConfederationToCaf(){
        return updateConfederation(Constants.CONFEDERATION_CAF);
    }
    public boolean isConfederationConcacaf(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_CONCACAF);
    }

    public TournamentTeam updateConfederationToConcacaf(){
        return updateConfederation(Constants.CONFEDERATION_CONCACAF);
    }
    public boolean isConfederationConmebol(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_CONMEBOL);
    }

    public TournamentTeam updateConfederationToConmebol(){
        return updateConfederation(Constants.CONFEDERATION_CONMEBOL);
    }
    public boolean isConfederationOfc(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_OFC);
    }

    public TournamentTeam updateConfederationToOfc(){
        return updateConfederation(Constants.CONFEDERATION_OFC);
    }
    public boolean isConfederationUefa(){
        return ObjectUtil.equals(getConfederation(), Constants.CONFEDERATION_UEFA);
    }

    public TournamentTeam updateConfederationToUefa(){
        return updateConfederation(Constants.CONFEDERATION_UEFA);
    }

    public static TournamentTeam refer(Long id){
        TournamentTeam refer = new TournamentTeam();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TournamentTeam comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "teamName": this.teamName = StrUtil.trim((String) value); break;

            case "teamCode": this.teamCode = StrUtil.trim((String) value); break;

            case "emojiFlag": this.emojiFlag = StrUtil.trim((String) value); break;

            case "fifaRanking": this.fifaRanking = (Integer) value; break;

            case "managerName": this.managerName = StrUtil.trim((String) value); break;

            case "confederation": this.confederation = (Confederation) value; break;

            case "groupLetter": this.groupLetter = StrUtil.trim((String) value); break;

            case "tournament": this.tournament = (Tournament) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "tournamentMatchListAsHomeTeam": this.tournamentMatchListAsHomeTeam = (SmartList<TournamentMatch>) value; break;
            case "tournamentMatchListAsAwayTeam": this.tournamentMatchListAsAwayTeam = (SmartList<TournamentMatch>) value; break;
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
            case "teamName": return this.teamName;
            case "teamCode": return this.teamCode;
            case "emojiFlag": return this.emojiFlag;
            case "fifaRanking": return this.fifaRanking;
            case "managerName": return this.managerName;
            case "confederation": return this.confederation;
            case "groupLetter": return this.groupLetter;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "tournamentMatchListAsHomeTeam": return this.tournamentMatchListAsHomeTeam;
            case "tournamentMatchListAsAwayTeam": return this.tournamentMatchListAsAwayTeam;
            case "matchGoalList": return this.matchGoalList;
            case "matchCardList": return this.matchCardList;
            case "groupStandingList": return this.groupStandingList;
            default: return super.internalGet(property);
        }
    }

}