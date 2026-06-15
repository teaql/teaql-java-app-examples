package com.example.fifaworldcupservice;

import cn.hutool.core.util.ReflectUtil;
import io.teaql.core.meta.EntityDescriptor;
import io.teaql.core.meta.EntityMetaAssembler;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.PropertyDescriptor;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EntityMetaRegistry implements EntityMetaAssembler {
  private EntityMetaFactory $factory;

  @Override
  public void assemble(EntityMetaFactory factory) {
    this.$factory = factory;
    registerTournament();
    registerMatchStage();
    registerMatchStatus();
    registerGoalCategory();
    registerCardCategory();
    registerConfederation();
    registerTournamentTeam();
    registerMatchGroup();
    registerTournamentMatch();
    registerMatchGoal();
    registerMatchCard();
    registerGroupStanding();
  }
  private void registerMatchStage() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.matchstage.MatchStage.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.matchstage.MatchStage.class);
      entityDescriptor.with("constant", "true")
      .with("identifier", "code")
      .with("name", "Match Stage")
      .with("module", "Basic Data")
      .with("module_key", "basic-data");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstage.MatchStage.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "match_stage_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstage.MatchStage.NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "match_stage_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstage.MatchStage.CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "match_stage_data", "code", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchstage.MatchStage.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.MATCH_STAGE_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "match_stage_data", "tournament", "BIGINT");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstage.MatchStage.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "match_stage_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstage.MatchStage.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003,1004,1005,1006,1007")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstage.MatchStage.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Group,Round of 32,Round of 16,Quarter Final,Semi Final,Third Place,Final")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstage.MatchStage.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "GROUP,ROUND_OF_32,ROUND_OF_16,QUARTER_FINAL,SEMI_FINAL,THIRD_PLACE,FINAL")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstage.MatchStage.TOURNAMENT_PROPERTY).with("candidates", "tournament()");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstage.MatchStage.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMatchStatus() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.matchstatus.MatchStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.matchstatus.MatchStatus.class);
      entityDescriptor.with("constant", "true")
      .with("identifier", "code")
      .with("name", "Match Status")
      .with("module", "Basic Data")
      .with("module_key", "basic-data");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "match_status_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "match_status_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "match_status_data", "code", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchstatus.MatchStatus.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.MATCH_STATUS_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "match_status_data", "tournament", "BIGINT");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "match_status_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003,1004")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Scheduled,Live,Finished,Postponed")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "SCHEDULED,LIVE,FINISHED,POSTPONED")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.TOURNAMENT_PROPERTY).with("candidates", "tournament()");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchstatus.MatchStatus.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerGoalCategory() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.goalcategory.GoalCategory.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.goalcategory.GoalCategory.class);
      entityDescriptor.with("constant", "true")
      .with("identifier", "code")
      .with("name", "Goal Category")
      .with("module", "Basic Data")
      .with("module_key", "basic-data");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "goal_category_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "goal_category_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "goal_category_data", "code", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.goalcategory.GoalCategory.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.GOAL_CATEGORY_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "goal_category_data", "tournament", "BIGINT");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "goal_category_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003,1004")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Normal,Penalty,Own Goal,Free Kick")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "NORMAL,PENALTY,OWN_GOAL,FREE_KICK")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.TOURNAMENT_PROPERTY).with("candidates", "tournament()");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.goalcategory.GoalCategory.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCardCategory() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.cardcategory.CardCategory.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.cardcategory.CardCategory.class);
      entityDescriptor.with("constant", "true")
      .with("identifier", "code")
      .with("name", "Card Category")
      .with("module", "Basic Data")
      .with("module_key", "basic-data");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "card_category_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "card_category_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "card_category_data", "code", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.cardcategory.CardCategory.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.CARD_CATEGORY_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "card_category_data", "tournament", "BIGINT");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "card_category_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Yellow,Red,Second Yellow")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "YELLOW,RED,SECOND_YELLOW")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.TOURNAMENT_PROPERTY).with("candidates", "tournament()");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.cardcategory.CardCategory.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerConfederation() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.confederation.Confederation.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.confederation.Confederation.class);
      entityDescriptor.with("constant", "true")
      .with("identifier", "code")
      .with("name", "Confederation")
      .with("module", "Basic Data")
      .with("module_key", "basic-data");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.confederation.Confederation.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "confederation_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.confederation.Confederation.NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "confederation_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.confederation.Confederation.CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "confederation_data", "code", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.confederation.Confederation.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.CONFEDERATION_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "confederation_data", "tournament", "BIGINT");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.confederation.Confederation.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "confederation_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.confederation.Confederation.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "1001,1002,1003,1004,1005,1006")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.confederation.Confederation.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "AFC,CAF,CONCACAF,CONMEBOL,OFC,UEFA")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.confederation.Confederation.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "AFC,CAF,CONCACAF,CONMEBOL,OFC,UEFA")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.confederation.Confederation.TOURNAMENT_PROPERTY).with("candidates", "tournament()");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.confederation.Confederation.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTournament() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.tournament.Tournament.class);
      entityDescriptor.with("name", "Tournament")
      .with("module", "Tournament Management")
      .with("module_key", "tournament-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "tournament_data", "id", "BIGINT");

      PropertyDescriptor tournamentName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.TOURNAMENT_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentName, "tournament_data", "tournament_name", "VARCHAR(100)");

      PropertyDescriptor hostCountries = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.HOST_COUNTRIES_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", hostCountries, "tournament_data", "host_countries", "VARCHAR(100)");

      PropertyDescriptor startDate = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.START_DATE_PROPERTY, LocalDate.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", startDate, "tournament_data", "start_date", "DATE");

      PropertyDescriptor endDate = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.END_DATE_PROPERTY, LocalDate.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", endDate, "tournament_data", "end_date", "DATE");

      PropertyDescriptor totalTeams = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.TOTAL_TEAMS_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", totalTeams, "tournament_data", "total_teams", "INTEGER");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "tournament_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "tournament_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournament.Tournament.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "tournament_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.TOURNAMENT_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "FIFA World Cup 2026")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.HOST_COUNTRIES_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "United States, Mexico, Canada")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.START_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDate")
      .with("candidates", "2026-06-11")
      .with("sqlType", "DATE")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "Date")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.END_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDate")
      .with("candidates", "2026-07-19")
      .with("sqlType", "DATE")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "Date")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.TOTAL_TEAMS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("candidates", "48")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournament.Tournament.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTournamentTeam() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class);
      entityDescriptor.with("name", "Tournament Team")
      .with("module", "Tournament Management")
      .with("module_key", "tournament-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "tournament_team_data", "id", "BIGINT");

      PropertyDescriptor teamName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TEAM_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", teamName, "tournament_team_data", "team_name", "VARCHAR(100)");

      PropertyDescriptor teamCode = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TEAM_CODE_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", teamCode, "tournament_team_data", "team_code", "VARCHAR(100)");

      PropertyDescriptor emojiFlag = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.EMOJI_FLAG_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", emojiFlag, "tournament_team_data", "emoji_flag", "VARCHAR(100)");

      PropertyDescriptor fifaRanking = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.FIFA_RANKING_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", fifaRanking, "tournament_team_data", "fifa_ranking", "INTEGER");

      PropertyDescriptor managerName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.MANAGER_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", managerName, "tournament_team_data", "manager_name", "VARCHAR(100)");

      PropertyDescriptor confederation = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.CONFEDERATION_PROPERTY, com.example.fifaworldcupservice.confederation.Confederation.INTERNAL_TYPE, com.example.fifaworldcupservice.confederation.Confederation.TOURNAMENT_TEAM_LIST_PROPERTY, com.example.fifaworldcupservice.confederation.Confederation.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", confederation, "tournament_team_data", "confederation", "BIGINT");

      PropertyDescriptor groupLetter = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.GROUP_LETTER_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", groupLetter, "tournament_team_data", "group_letter", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.TOURNAMENT_TEAM_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "tournament_team_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "tournament_team_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "tournament_team_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "tournament_team_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TEAM_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TEAM_CODE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.EMOJI_FLAG_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.FIFA_RANKING_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.MANAGER_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.GROUP_LETTER_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentteam.TournamentTeam.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMatchGroup() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.matchgroup.MatchGroup.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.matchgroup.MatchGroup.class);
      entityDescriptor.with("name", "Match Group")
      .with("module", "Tournament Management")
      .with("module_key", "tournament-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "match_group_data", "id", "BIGINT");

      PropertyDescriptor groupLetter = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.GROUP_LETTER_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", groupLetter, "match_group_data", "group_letter", "VARCHAR(100)");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchgroup.MatchGroup.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.MATCH_GROUP_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "match_group_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "match_group_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "match_group_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "match_group_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.GROUP_LETTER_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgroup.MatchGroup.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTournamentMatch() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.class);
      entityDescriptor.with("name", "Tournament Match")
      .with("module", "Match Management")
      .with("module_key", "match-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "tournament_match_data", "id", "BIGINT");

      PropertyDescriptor matchNumber = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_NUMBER_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchNumber, "tournament_match_data", "match_number", "INTEGER");

      PropertyDescriptor matchDate = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_DATE_PROPERTY, LocalDate.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchDate, "tournament_match_data", "match_date", "DATE");

      PropertyDescriptor venueName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", venueName, "tournament_match_data", "venue_name", "VARCHAR(100)");

      PropertyDescriptor venueCity = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_CITY_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", venueCity, "tournament_match_data", "venue_city", "VARCHAR(100)");

      PropertyDescriptor venueCountry = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_COUNTRY_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", venueCountry, "tournament_match_data", "venue_country", "VARCHAR(100)");

      PropertyDescriptor homeScore = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.HOME_SCORE_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", homeScore, "tournament_match_data", "home_score", "INTEGER");

      PropertyDescriptor awayScore = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.AWAY_SCORE_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", awayScore, "tournament_match_data", "away_score", "INTEGER");

      PropertyDescriptor extraTimeHome = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.EXTRA_TIME_HOME_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", extraTimeHome, "tournament_match_data", "extra_time_home", "INTEGER");

      PropertyDescriptor extraTimeAway = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.EXTRA_TIME_AWAY_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", extraTimeAway, "tournament_match_data", "extra_time_away", "INTEGER");

      PropertyDescriptor penaltyHome = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.PENALTY_HOME_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", penaltyHome, "tournament_match_data", "penalty_home", "INTEGER");

      PropertyDescriptor penaltyAway = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.PENALTY_AWAY_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", penaltyAway, "tournament_match_data", "penalty_away", "INTEGER");

      PropertyDescriptor homeTeam = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.HOME_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TOURNAMENT_MATCH_LIST_AS_HOME_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", homeTeam, "tournament_match_data", "home_team", "BIGINT");

      PropertyDescriptor awayTeam = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.AWAY_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.TOURNAMENT_MATCH_LIST_AS_AWAY_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", awayTeam, "tournament_match_data", "away_team", "BIGINT");

      PropertyDescriptor matchStage = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_STAGE_PROPERTY, com.example.fifaworldcupservice.matchstage.MatchStage.INTERNAL_TYPE, com.example.fifaworldcupservice.matchstage.MatchStage.TOURNAMENT_MATCH_LIST_PROPERTY, com.example.fifaworldcupservice.matchstage.MatchStage.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchStage, "tournament_match_data", "match_stage", "BIGINT");

      PropertyDescriptor matchGroup = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_GROUP_PROPERTY, com.example.fifaworldcupservice.matchgroup.MatchGroup.INTERNAL_TYPE, com.example.fifaworldcupservice.matchgroup.MatchGroup.TOURNAMENT_MATCH_LIST_PROPERTY, com.example.fifaworldcupservice.matchgroup.MatchGroup.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchGroup, "tournament_match_data", "match_group", "BIGINT");

      PropertyDescriptor matchStatus = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_STATUS_PROPERTY, com.example.fifaworldcupservice.matchstatus.MatchStatus.INTERNAL_TYPE, com.example.fifaworldcupservice.matchstatus.MatchStatus.TOURNAMENT_MATCH_LIST_PROPERTY, com.example.fifaworldcupservice.matchstatus.MatchStatus.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchStatus, "tournament_match_data", "match_status", "BIGINT");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.TOURNAMENT_MATCH_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "tournament_match_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "tournament_match_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "tournament_match_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "tournament_match_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_NUMBER_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDate")
      .with("sqlType", "DATE")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "Date")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_CITY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VENUE_COUNTRY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.HOME_SCORE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.AWAY_SCORE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.EXTRA_TIME_HOME_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.EXTRA_TIME_AWAY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.PENALTY_HOME_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.PENALTY_AWAY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");







      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMatchGoal() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.matchgoal.MatchGoal.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.matchgoal.MatchGoal.class);
      entityDescriptor.with("name", "Match Goal")
      .with("module", "Match Management")
      .with("module_key", "match-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "match_goal_data", "id", "BIGINT");

      PropertyDescriptor playerName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.PLAYER_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", playerName, "match_goal_data", "player_name", "VARCHAR(100)");

      PropertyDescriptor minuteScored = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.MINUTE_SCORED_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", minuteScored, "match_goal_data", "minute_scored", "INTEGER");

      PropertyDescriptor tournamentMatch = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchgoal.MatchGoal.TOURNAMENT_MATCH_PROPERTY, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_GOAL_LIST_PROPERTY, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentMatch, "match_goal_data", "tournament_match", "BIGINT");

      PropertyDescriptor tournamentTeam = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchgoal.MatchGoal.TOURNAMENT_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.MATCH_GOAL_LIST_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentTeam, "match_goal_data", "tournament_team", "BIGINT");

      PropertyDescriptor goalCategory = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchgoal.MatchGoal.GOAL_CATEGORY_PROPERTY, com.example.fifaworldcupservice.goalcategory.GoalCategory.INTERNAL_TYPE, com.example.fifaworldcupservice.goalcategory.GoalCategory.MATCH_GOAL_LIST_PROPERTY, com.example.fifaworldcupservice.goalcategory.GoalCategory.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", goalCategory, "match_goal_data", "goal_category", "BIGINT");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchgoal.MatchGoal.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.MATCH_GOAL_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "match_goal_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "match_goal_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "match_goal_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "match_goal_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.PLAYER_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.MINUTE_SCORED_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");





      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchgoal.MatchGoal.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerMatchCard() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.matchcard.MatchCard.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.matchcard.MatchCard.class);
      entityDescriptor.with("name", "Match Card")
      .with("module", "Match Management")
      .with("module_key", "match-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "match_card_data", "id", "BIGINT");

      PropertyDescriptor playerName = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.PLAYER_NAME_PROPERTY, String.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", playerName, "match_card_data", "player_name", "VARCHAR(100)");

      PropertyDescriptor minuteIssued = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.MINUTE_ISSUED_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", minuteIssued, "match_card_data", "minute_issued", "INTEGER");

      PropertyDescriptor tournamentMatch = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchcard.MatchCard.TOURNAMENT_MATCH_PROPERTY, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.MATCH_CARD_LIST_PROPERTY, com.example.fifaworldcupservice.tournamentmatch.TournamentMatch.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentMatch, "match_card_data", "tournament_match", "BIGINT");

      PropertyDescriptor tournamentTeam = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchcard.MatchCard.TOURNAMENT_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.MATCH_CARD_LIST_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentTeam, "match_card_data", "tournament_team", "BIGINT");

      PropertyDescriptor cardCategory = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchcard.MatchCard.CARD_CATEGORY_PROPERTY, com.example.fifaworldcupservice.cardcategory.CardCategory.INTERNAL_TYPE, com.example.fifaworldcupservice.cardcategory.CardCategory.MATCH_CARD_LIST_PROPERTY, com.example.fifaworldcupservice.cardcategory.CardCategory.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", cardCategory, "match_card_data", "card_category", "BIGINT");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.matchcard.MatchCard.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.MATCH_CARD_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "match_card_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "match_card_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "match_card_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.matchcard.MatchCard.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "match_card_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.PLAYER_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.MINUTE_ISSUED_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");





      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.matchcard.MatchCard.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerGroupStanding() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.fifaworldcupservice.groupstanding.GroupStanding.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.fifaworldcupservice.groupstanding.GroupStanding.class);
      entityDescriptor.with("name", "Group Standing")
      .with("module", "Standings")
      .with("module_key", "standings");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.ID_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "group_standing_data", "id", "BIGINT");

      PropertyDescriptor played = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.PLAYED_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", played, "group_standing_data", "played", "INTEGER");

      PropertyDescriptor won = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.WON_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", won, "group_standing_data", "won", "INTEGER");

      PropertyDescriptor drawn = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.DRAWN_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", drawn, "group_standing_data", "drawn", "INTEGER");

      PropertyDescriptor lost = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.LOST_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", lost, "group_standing_data", "lost", "INTEGER");

      PropertyDescriptor goalsFor = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOALS_FOR_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", goalsFor, "group_standing_data", "goals_for", "INTEGER");

      PropertyDescriptor goalsAgainst = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOALS_AGAINST_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", goalsAgainst, "group_standing_data", "goals_against", "INTEGER");

      PropertyDescriptor goalDifference = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOAL_DIFFERENCE_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", goalDifference, "group_standing_data", "goal_difference", "INTEGER");

      PropertyDescriptor points = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.POINTS_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", points, "group_standing_data", "points", "INTEGER");

      PropertyDescriptor standingRank = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.STANDING_RANK_PROPERTY, Integer.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", standingRank, "group_standing_data", "standing_rank", "INTEGER");

      PropertyDescriptor tournamentTeam = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.groupstanding.GroupStanding.TOURNAMENT_TEAM_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.INTERNAL_TYPE, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.GROUP_STANDING_LIST_PROPERTY, com.example.fifaworldcupservice.tournamentteam.TournamentTeam.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournamentTeam, "group_standing_data", "tournament_team", "BIGINT");

      PropertyDescriptor matchGroup = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.groupstanding.GroupStanding.MATCH_GROUP_PROPERTY, com.example.fifaworldcupservice.matchgroup.MatchGroup.INTERNAL_TYPE, com.example.fifaworldcupservice.matchgroup.MatchGroup.GROUP_STANDING_LIST_PROPERTY, com.example.fifaworldcupservice.matchgroup.MatchGroup.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", matchGroup, "group_standing_data", "match_group", "BIGINT");

      PropertyDescriptor tournament = 
      entityDescriptor.addObjectProperty($factory, com.example.fifaworldcupservice.groupstanding.GroupStanding.TOURNAMENT_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.INTERNAL_TYPE, com.example.fifaworldcupservice.tournament.Tournament.GROUP_STANDING_LIST_PROPERTY, com.example.fifaworldcupservice.tournament.Tournament.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", tournament, "group_standing_data", "tournament", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "group_standing_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "group_standing_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.VERSION_PROPERTY, Long.class)
      ;
          // ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "group_standing_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.PLAYED_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.WON_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.DRAWN_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.LOST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOALS_FOR_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOALS_AGAINST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.GOAL_DIFFERENCE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.POINTS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.STANDING_RANK_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");




      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.fifaworldcupservice.groupstanding.GroupStanding.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
}