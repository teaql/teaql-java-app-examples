package com.example.fifaworldcupservice.confederation;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.fifaworldcupservice.tournament.Tournament;
import com.example.fifaworldcupservice.tournamentteam.TournamentTeam;
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
public class Confederation extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Confederation";

    public static final String NAME_PROPERTY = "name";
    public static final String CODE_PROPERTY = "code";
    public static final String TOURNAMENT_PROPERTY = "tournament";
    public static final String TOURNAMENT_TEAM_LIST_PROPERTY = "tournamentTeamList";
    private String name;
    private String code;
    private Tournament tournament;
    private SmartList<TournamentTeam> tournamentTeamList;

    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public Tournament getTournament(){
        return this.tournament;
    }
    public SmartList<TournamentTeam> getTournamentTeamList(){
        return this.tournamentTeamList;
    }
    public Confederation updateName(String name){
        name = StrUtil.trim(name);
        if(ObjectUtil.equal(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Confederation updateCode(String code){
        code = StrUtil.trim(code);
        if(ObjectUtil.equal(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public Confederation updateTournament(Tournament tournament){
        if(ObjectUtil.equal(this.tournament, tournament)){
            return this;
        }
        handleUpdate(TOURNAMENT_PROPERTY, getTournament(), tournament);
        this.tournament = tournament;
        return this;
    }
    public Confederation addTournamentTeam(TournamentTeam tournamentTeam){
        if (tournamentTeam == null){
            return this;
        }

        if(null == this.tournamentTeamList){
            this.tournamentTeamList = new SmartList<>();
        }

        this.tournamentTeamList.add(tournamentTeam);
        tournamentTeam.cacheRelation(TournamentTeam.CONFEDERATION_PROPERTY, this);
        return this;
    }

    public static Confederation refer(Long id){
        Confederation refer = new Confederation();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Confederation comment(String comment){
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

            case "tournamentTeamList": this.tournamentTeamList = (SmartList<TournamentTeam>) value; break;
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
            case "tournamentTeamList": return this.tournamentTeamList;
            default: return super.internalGet(property);
        }
    }

}