package com.example.fifaworldcupservice.matchcard;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.Constants;
import com.example.fifaworldcupservice.cardcategory.CardCategory;
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
public class MatchCard extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MatchCard";

    public static final String PLAYER_NAME_PROPERTY = "playerName";
    public static final String MINUTE_ISSUED_PROPERTY = "minuteIssued";
    public static final String TOURNAMENT_MATCH_PROPERTY = "tournamentMatch";
    public static final String TOURNAMENT_TEAM_PROPERTY = "tournamentTeam";
    public static final String CARD_CATEGORY_PROPERTY = "cardCategory";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String playerName;
    private Integer minuteIssued;
    private TournamentMatch tournamentMatch;
    private TournamentTeam tournamentTeam;
    private CardCategory cardCategory;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getPlayerName(){
        return this.playerName;
    }
    public Integer getMinuteIssued(){
        return this.minuteIssued;
    }
    public TournamentMatch getTournamentMatch(){
        return this.tournamentMatch;
    }
    public TournamentTeam getTournamentTeam(){
        return this.tournamentTeam;
    }
    public CardCategory getCardCategory(){
        return this.cardCategory;
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
    public MatchCard updatePlayerName(String playerName){
        playerName = StrUtil.trim(playerName);
        if(ObjectUtil.equal(this.playerName, playerName)){
            return this;
        }
        handleUpdate(PLAYER_NAME_PROPERTY, getPlayerName(), playerName);
        this.playerName = playerName;
        return this;
    }
    public MatchCard updateMinuteIssued(Integer minuteIssued){
        if(ObjectUtil.equal(this.minuteIssued, minuteIssued)){
            return this;
        }
        handleUpdate(MINUTE_ISSUED_PROPERTY, getMinuteIssued(), minuteIssued);
        this.minuteIssued = minuteIssued;
        return this;
    }
    public MatchCard updateTournamentMatch(TournamentMatch tournamentMatch){
        if(ObjectUtil.equal(this.tournamentMatch, tournamentMatch)){
            return this;
        }
        handleUpdate(TOURNAMENT_MATCH_PROPERTY, getTournamentMatch(), tournamentMatch);
        this.tournamentMatch = tournamentMatch;
        return this;
    }
    public MatchCard updateTournamentTeam(TournamentTeam tournamentTeam){
        if(ObjectUtil.equal(this.tournamentTeam, tournamentTeam)){
            return this;
        }
        handleUpdate(TOURNAMENT_TEAM_PROPERTY, getTournamentTeam(), tournamentTeam);
        this.tournamentTeam = tournamentTeam;
        return this;
    }
    protected MatchCard updateCardCategory(CardCategory cardCategory){
        if(ObjectUtil.equal(this.cardCategory, cardCategory)){
            return this;
        }
        handleUpdate(CARD_CATEGORY_PROPERTY, getCardCategory(), cardCategory);
        this.cardCategory = cardCategory;
        return this;
    }
    public MatchCard updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public MatchCard updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public MatchCard updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public boolean isCardCategoryYellow(){
        return ObjectUtil.equals(getCardCategory(), Constants.CARD_CATEGORY_YELLOW);
    }

    public MatchCard updateCardCategoryToYellow(){
        return updateCardCategory(Constants.CARD_CATEGORY_YELLOW);
    }
    public boolean isCardCategoryRed(){
        return ObjectUtil.equals(getCardCategory(), Constants.CARD_CATEGORY_RED);
    }

    public MatchCard updateCardCategoryToRed(){
        return updateCardCategory(Constants.CARD_CATEGORY_RED);
    }
    public boolean isCardCategorySecondYellow(){
        return ObjectUtil.equals(getCardCategory(), Constants.CARD_CATEGORY_SECOND_YELLOW);
    }

    public MatchCard updateCardCategoryToSecondYellow(){
        return updateCardCategory(Constants.CARD_CATEGORY_SECOND_YELLOW);
    }

    public static MatchCard refer(Long id){
        MatchCard refer = new MatchCard();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MatchCard comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "playerName": this.playerName = StrUtil.trim((String) value); break;

            case "minuteIssued": this.minuteIssued = (Integer) value; break;

            case "tournamentMatch": this.tournamentMatch = (TournamentMatch) value; break;

            case "tournamentTeam": this.tournamentTeam = (TournamentTeam) value; break;

            case "cardCategory": this.cardCategory = (CardCategory) value; break;

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
            case "minuteIssued": return this.minuteIssued;
            case "tournamentMatch": return this.tournamentMatch;
            case "tournamentTeam": return this.tournamentTeam;
            case "cardCategory": return this.cardCategory;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.internalGet(property);
        }
    }

}