package com.example.fifaworldcupservice.matchgroup;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.groupstanding.GroupStanding;
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
public class MatchGroup extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MatchGroup";

    public static final String GROUP_LETTER_PROPERTY = "groupLetter";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TOURNAMENT_MATCH_LIST_PROPERTY = "tournamentMatchList";
    public static final String GROUP_STANDING_LIST_PROPERTY = "groupStandingList";
    private String groupLetter;
    private Tournament tournament;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<TournamentMatch> tournamentMatchList;
    private SmartList<GroupStanding> groupStandingList;

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
    public SmartList<TournamentMatch> getTournamentMatchList(){
        return this.tournamentMatchList;
    }
    public SmartList<GroupStanding> getGroupStandingList(){
        return this.groupStandingList;
    }
    public MatchGroup updateGroupLetter(String groupLetter){
        groupLetter = StrUtil.trim(groupLetter);
        if(ObjectUtil.equal(this.groupLetter, groupLetter)){
            return this;
        }
        handleUpdate(GROUP_LETTER_PROPERTY, getGroupLetter(), groupLetter);
        this.groupLetter = groupLetter;
        return this;
    }
    public MatchGroup updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public MatchGroup updateCreateTime(LocalDateTime createTime){
        if(ObjectUtil.equal(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public MatchGroup updateUpdateTime(LocalDateTime updateTime){
        if(ObjectUtil.equal(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public MatchGroup addTournamentMatch(TournamentMatch tournamentMatch){
        if (tournamentMatch == null){
            return this;
        }

        if(null == this.tournamentMatchList){
            this.tournamentMatchList = new SmartList<>();
        }

        this.tournamentMatchList.add(tournamentMatch);
        tournamentMatch.cacheRelation(TournamentMatch.MATCH_GROUP_PROPERTY, this);
        return this;
    }
    public MatchGroup addGroupStanding(GroupStanding groupStanding){
        if (groupStanding == null){
            return this;
        }

        if(null == this.groupStandingList){
            this.groupStandingList = new SmartList<>();
        }

        this.groupStandingList.add(groupStanding);
        groupStanding.cacheRelation(GroupStanding.MATCH_GROUP_PROPERTY, this);
        return this;
    }

    public static MatchGroup refer(Long id){
        MatchGroup refer = new MatchGroup();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MatchGroup comment(String comment){
        this.setComment(comment);
        return this;
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "groupLetter": this.groupLetter = StrUtil.trim((String) value); break;

            case "tournament": this.tournament = (Tournament) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "tournamentMatchList": this.tournamentMatchList = (SmartList<TournamentMatch>) value; break;
            case "groupStandingList": this.groupStandingList = (SmartList<GroupStanding>) value; break;
            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "groupLetter": return this.groupLetter;
            case "tournament": return this.tournament;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "tournamentMatchList": return this.tournamentMatchList;
            case "groupStandingList": return this.groupStandingList;
            default: return super.internalGet(property);
        }
    }

}