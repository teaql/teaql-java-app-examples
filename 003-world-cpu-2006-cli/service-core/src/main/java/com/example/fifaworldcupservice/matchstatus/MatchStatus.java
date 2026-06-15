package com.example.fifaworldcupservice.matchstatus;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentmatch.TournamentMatch;
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
public class MatchStatus extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "MatchStatus";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String TOURNAMENT_MATCH_LIST_PROPERTY = "tournamentMatchList";
    private String name;
    private String code;
    private Tournament tournament;
    private SmartList<TournamentMatch> tournamentMatchList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Tournament getTournament(){
        return this.tournament;
    }
    public SmartList<TournamentMatch> getTournamentMatchList(){
        return this.tournamentMatchList;
    }
    public MatchStatus updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public MatchStatus updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public MatchStatus updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public MatchStatus addTournamentMatch(TournamentMatch tournamentMatch){
        if (tournamentMatch == null){
            return this;
        }

        if(null == this.tournamentMatchList){
            this.tournamentMatchList = new SmartList<>();
        }

        this.tournamentMatchList.add(tournamentMatch);
        tournamentMatch.cacheRelation(TournamentMatch.MATCH_STATUS_PROPERTY, this);
        return this;
    }

    public static MatchStatus refer(Long id){
        MatchStatus refer = new MatchStatus();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public MatchStatus comment(String comment){
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

            case "tournamentMatchList": this.tournamentMatchList = (SmartList<TournamentMatch>) value; break;
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
            case "tournamentMatchList": return this.tournamentMatchList;
            default: return super.internalGet(property);
        }
    }

}