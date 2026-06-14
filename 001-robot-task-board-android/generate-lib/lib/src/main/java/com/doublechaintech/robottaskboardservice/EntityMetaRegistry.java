package com.doublechaintech.robottaskboardservice;

import cn.hutool.core.util.ReflectUtil;
import io.teaql.core.meta.EntityDescriptor;
import io.teaql.core.meta.EntityMetaAssembler;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.PropertyDescriptor;
import java.time.LocalDateTime;

public class EntityMetaRegistry implements EntityMetaAssembler {
  private EntityMetaFactory $factory;

  @Override
  public void assemble(EntityMetaFactory factory) {
    this.$factory = factory;
    registerPlatform();
    registerTaskStatus();
    registerTask();
    registerTaskLog();
  }
  private void registerTaskStatus() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.class);
      entityDescriptor.with("name", "Task Status")
      .with("module", "Task Management")
      .with("module_key", "task-management")
      .with("constant", "true")
      .with("identifier", "code");

      PropertyDescriptor platform = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.PLATFORM_PROPERTY, com.doublechaintech.robottaskboardservice.platform.Platform.INTERNAL_TYPE, com.doublechaintech.robottaskboardservice.platform.Platform.TASK_STATUS_LIST_PROPERTY, com.doublechaintech.robottaskboardservice.platform.Platform.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", platform, "task_status_data", "platform", "BIGINT");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "task_status_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "task_status_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.CODE_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "task_status_data", "code", "VARCHAR(100)");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "task_status_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.PLATFORM_PROPERTY).with("candidates", "platform()");

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "TODO,In Progress,Done")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "TODO,IN_PROGRESS,DONE")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPlatform() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.robottaskboardservice.platform.Platform.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.robottaskboardservice.platform.Platform.class);
      entityDescriptor.with("name", "Platform")
      .with("module", "Task Management")
      .with("module_key", "task-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.platform.Platform.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "platform_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.platform.Platform.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "platform_data", "name", "VARCHAR(100)");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.platform.Platform.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "platform_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.platform.Platform.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "platform_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.platform.Platform.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "platform_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.platform.Platform.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.platform.Platform.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Task Board Platform")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.platform.Platform.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.platform.Platform.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.platform.Platform.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerTask() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.robottaskboardservice.task.Task.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.robottaskboardservice.task.Task.class);
      entityDescriptor.with("name", "Task")
      .with("module", "Task Management")
      .with("module_key", "task-management");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.task.Task.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "task_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.task.Task.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "task_data", "name", "VARCHAR(100)");

      PropertyDescriptor platform = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.robottaskboardservice.task.Task.PLATFORM_PROPERTY, com.doublechaintech.robottaskboardservice.platform.Platform.INTERNAL_TYPE, com.doublechaintech.robottaskboardservice.platform.Platform.TASK_LIST_PROPERTY, com.doublechaintech.robottaskboardservice.platform.Platform.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", platform, "task_data", "platform", "BIGINT");

      PropertyDescriptor status = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.robottaskboardservice.task.Task.STATUS_PROPERTY, com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.INTERNAL_TYPE, com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.TASK_LIST_PROPERTY, com.doublechaintech.robottaskboardservice.taskstatus.TaskStatus.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", status, "task_data", "status", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.task.Task.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "task_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.task.Task.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "task_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.task.Task.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "task_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.task.Task.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.task.Task.NAME_PROPERTY).with("isPassword", "false")
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



      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.task.Task.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.task.Task.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.task.Task.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerTaskLog() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.class);
      entityDescriptor.with("name", "Task Log")
      .with("module", "Task Management")
      .with("module_key", "task-management")
      .with("log", "true");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "task_log_data", "id", "BIGINT");

      PropertyDescriptor query = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.QUERY_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", query, "task_log_data", "query", "VARCHAR(100)");

      PropertyDescriptor createdBy = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.CREATED_BY_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createdBy, "task_log_data", "created_by", "VARCHAR(100)");

      PropertyDescriptor task = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.robottaskboardservice.tasklog.TaskLog.TASK_PROPERTY, com.doublechaintech.robottaskboardservice.task.Task.INTERNAL_TYPE, com.doublechaintech.robottaskboardservice.task.Task.TASK_LOG_LIST_PROPERTY, com.doublechaintech.robottaskboardservice.task.Task.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", task, "task_log_data", "task", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "task_log_data", "create_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "task_log_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.QUERY_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.CREATED_BY_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.robottaskboardservice.tasklog.TaskLog.VERSION_PROPERTY).with("isPassword", "false")
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