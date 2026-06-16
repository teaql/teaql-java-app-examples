package com.doublechaintech.vendingmachineservice.dataservice;

import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class DataService extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "DataService";

    public static final String NAME_PROPERTY = "name";
    public static final String JDBC_INFO_PROPERTY = "jdbcInfo";
    private String name;
    private String jdbcInfo;

    public String getName(){
        return this.name;
    }
    public String getJdbcInfo(){
        return this.jdbcInfo;
    }
    public DataService updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public DataService updateJdbcInfo(String jdbcInfo){
        jdbcInfo = (jdbcInfo == null ? null : jdbcInfo.trim());
        if(Objects.equals(this.jdbcInfo, jdbcInfo)){
            return this;
        }
        handleUpdate(JDBC_INFO_PROPERTY, getJdbcInfo(), jdbcInfo);
        this.jdbcInfo = jdbcInfo;
        return this;
    }

    public static DataService refer(Long id){
        DataService refer = new DataService();
        refer.internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public DataService comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<DataService> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "jdbcInfo": this.jdbcInfo = (value == null ? null : ((String)value).trim()); break;

            default: super.internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "jdbcInfo": return this.jdbcInfo;
            default: return super.internalGet(property);
        }
    }

}