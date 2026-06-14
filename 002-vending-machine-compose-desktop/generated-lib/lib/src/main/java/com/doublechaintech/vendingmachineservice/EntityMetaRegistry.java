package com.doublechaintech.vendingmachineservice;

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
    registerVendingMachine();
    registerOrderStatus();
    registerPaymentMethod();
    registerPaymentStatus();
    registerProduct();
    registerVendingOrder();
    registerOrderPayment();
    registerVendingOrderItem();
  }
  private void registerVendingMachine() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class);
      entityDescriptor.with("name", "Vending Machine")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "vending_machine_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "vending_machine_data", "name", "VARCHAR(100)");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "vending_machine_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "vending_machine_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "vending_machine_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Main Machine")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerOrderStatus() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.class);
      entityDescriptor.with("name", "Order Status")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.VENDING_MACHINE_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.ORDER_STATUS_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingMachine, "order_status_data", "vending_machine", "BIGINT");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "order_status_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "order_status_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.CODE_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "order_status_data", "code", "VARCHAR(100)");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "order_status_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Pending,Paid,Dispensing,Completed")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "PENDING,PAID,DISPENSING,COMPLETED")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPaymentMethod() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.class);
      entityDescriptor.with("name", "Payment Method")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.VENDING_MACHINE_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.PAYMENT_METHOD_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingMachine, "payment_method_data", "vending_machine", "BIGINT");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "payment_method_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "payment_method_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.CODE_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "payment_method_data", "code", "VARCHAR(100)");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "payment_method_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "2001,2002,2003")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "WeChat Pay,AliPay,Credit Card")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "WECHAT,ALIPAY,CREDIT_CARD")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPaymentStatus() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.class);
      entityDescriptor.with("name", "Payment Status")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.VENDING_MACHINE_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.PAYMENT_STATUS_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingMachine, "payment_status_data", "vending_machine", "BIGINT");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "payment_status_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "payment_status_data", "name", "VARCHAR(100)");

      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.CODE_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", code, "payment_status_data", "code", "VARCHAR(100)");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "payment_status_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "3001,3002,3003")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Pending,Success,Failed")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "PENDING,SUCCESS,FAILED")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerProduct() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.product.Product.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.product.Product.class);
      entityDescriptor.with("name", "Product")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "product_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "product_data", "name", "VARCHAR(100)");

      PropertyDescriptor price = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.PRICE_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", price, "product_data", "price", "INTEGER");

      PropertyDescriptor stock = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.STOCK_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", stock, "product_data", "stock", "INTEGER");

      PropertyDescriptor imageUrl = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.IMAGE_URL_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", imageUrl, "product_data", "image_url", "VARCHAR(100)");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.product.Product.VENDING_MACHINE_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.PRODUCT_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingMachine, "product_data", "vending_machine", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "product_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "product_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.product.Product.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "product_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.PRICE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.STOCK_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.IMAGE_URL_PROPERTY).with("isPassword", "false")
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
      .with("zh_CN", "https")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.product.Product.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerVendingOrder() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.class);
      entityDescriptor.with("name", "Vending Order")
      .with("module", "Core")
      .with("module_key", "core");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "vending_order_data", "id", "BIGINT");

      PropertyDescriptor title = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.TITLE_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", title, "vending_order_data", "title", "VARCHAR(100)");

      PropertyDescriptor totalAmount = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.TOTAL_AMOUNT_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", totalAmount, "vending_order_data", "total_amount", "INTEGER");

      PropertyDescriptor status = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.STATUS_PROPERTY, com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.VENDING_ORDER_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", status, "vending_order_data", "status", "BIGINT");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "vending_order_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "vending_order_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "vending_order_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.TITLE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.TOTAL_AMOUNT_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerOrderPayment() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.class);
      entityDescriptor.with("name", "Order Payment")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "order_payment_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "order_payment_data", "name", "VARCHAR(100)");

      PropertyDescriptor vendingOrder = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.VENDING_ORDER_PROPERTY, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.ORDER_PAYMENT_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingOrder, "order_payment_data", "vending_order", "BIGINT");

      PropertyDescriptor paymentMethod = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_METHOD_PROPERTY, com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.ORDER_PAYMENT_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", paymentMethod, "order_payment_data", "payment_method", "BIGINT");

      PropertyDescriptor paymentStatus = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_STATUS_PROPERTY, com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.ORDER_PAYMENT_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.paymentstatus.PaymentStatus.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", paymentStatus, "order_payment_data", "payment_status", "BIGINT");

      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.AMOUNT_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", amount, "order_payment_data", "amount", "INTEGER");

      PropertyDescriptor paymentTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", paymentTime, "order_payment_data", "payment_time", "TIMESTAMP");

      PropertyDescriptor transactionId = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.TRANSACTION_ID_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", transactionId, "order_payment_data", "transaction_id", "VARCHAR(100)");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "order_payment_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "order_payment_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "order_payment_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.NAME_PROPERTY).with("isPassword", "false")
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




      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.AMOUNT_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.TRANSACTION_ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerVendingOrderItem() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.class);
      entityDescriptor.with("name", "Vending Order Item")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.ID_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", id, "vending_order_item_data", "id", "BIGINT");

      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.NAME_PROPERTY, String.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", name, "vending_order_item_data", "name", "VARCHAR(100)");

      PropertyDescriptor vendingOrder = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.VENDING_ORDER_PROPERTY, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.VENDING_ORDER_ITEM_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", vendingOrder, "vending_order_item_data", "vending_order", "BIGINT");

      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.PRODUCT_PROPERTY, com.doublechaintech.vendingmachineservice.product.Product.INTERNAL_TYPE, com.doublechaintech.vendingmachineservice.product.Product.VENDING_ORDER_ITEM_LIST_PROPERTY, com.doublechaintech.vendingmachineservice.product.Product.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", product, "vending_order_item_data", "product", "BIGINT");

      PropertyDescriptor quantity = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.QUANTITY_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", quantity, "vending_order_item_data", "quantity", "INTEGER");

      PropertyDescriptor price = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.PRICE_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", price, "vending_order_item_data", "price", "INTEGER");

      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.AMOUNT_PROPERTY, Integer.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", amount, "vending_order_item_data", "amount", "INTEGER");

      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", createTime, "vending_order_item_data", "create_time", "TIMESTAMP");

      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", updateTime, "vending_order_item_data", "update_time", "TIMESTAMP");

      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.VERSION_PROPERTY, Long.class)
      ;
          ReflectUtil.invoke(entityDescriptor, "prepareSQLMeta", version, "vending_order_item_data", "version", "BIGINT");

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.NAME_PROPERTY).with("isPassword", "false")
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



      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.QUANTITY_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.PRICE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.AMOUNT_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.VERSION_PROPERTY).with("isPassword", "false")
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