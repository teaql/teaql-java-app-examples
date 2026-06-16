package com.example.vendingmachineservice;

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
    registerDataService();
  }
  private void registerVendingMachine() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.vendingmachine.VendingMachine.class);
      entityDescriptor.with("name", "Vending Machine")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingmachine.VendingMachine.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.orderstatus.OrderStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.orderstatus.OrderStatus.class);
      entityDescriptor.with("name", "Order Status")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.orderstatus.OrderStatus.VENDING_MACHINE_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.example.vendingmachineservice.vendingmachine.VendingMachine.ORDER_STATUS_LIST_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.CODE_PROPERTY).with("identifier", "true")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderstatus.OrderStatus.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.paymentmethod.PaymentMethod.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.paymentmethod.PaymentMethod.class);
      entityDescriptor.with("name", "Payment Method")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.paymentmethod.PaymentMethod.VENDING_MACHINE_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.example.vendingmachineservice.vendingmachine.VendingMachine.PAYMENT_METHOD_LIST_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("candidates", "2001,2002,2003,2004")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "Google Pay,Apple Pay,PayPal,Credit Card")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.CODE_PROPERTY).with("identifier", "true")
      .with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "GOOGLE_PAY,APPLE_PAY,PAYPAL,CREDIT_CARD")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentmethod.PaymentMethod.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.paymentstatus.PaymentStatus.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.paymentstatus.PaymentStatus.class);
      entityDescriptor.with("name", "Payment Status")
      .with("module", "Core")
      .with("module_key", "core")
      .with("constant", "true")
      .with("identifier", "code")
      .with("audit_mask_fields", "name");

      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.paymentstatus.PaymentStatus.VENDING_MACHINE_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.example.vendingmachineservice.vendingmachine.VendingMachine.PAYMENT_STATUS_LIST_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.VENDING_MACHINE_PROPERTY).with("candidates", "vending_machine()");

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.CODE_PROPERTY).with("identifier", "true")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.paymentstatus.PaymentStatus.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.product.Product.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.product.Product.class);
      entityDescriptor.with("name", "Product")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor price = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.PRICE_PROPERTY, Integer.class)
      ;
      PropertyDescriptor stock = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.STOCK_PROPERTY, Integer.class)
      ;
      PropertyDescriptor imageUrl = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.IMAGE_URL_PROPERTY, String.class)
      ;
      PropertyDescriptor vendingMachine = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.product.Product.VENDING_MACHINE_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.INTERNAL_TYPE, com.example.vendingmachineservice.vendingmachine.VendingMachine.PRODUCT_LIST_PROPERTY, com.example.vendingmachineservice.vendingmachine.VendingMachine.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.product.Product.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.PRICE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.STOCK_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.IMAGE_URL_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.product.Product.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.vendingorder.VendingOrder.class);
      entityDescriptor.with("name", "Vending Order")
      .with("module", "Core")
      .with("module_key", "core");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor title = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.TITLE_PROPERTY, String.class)
      ;
      PropertyDescriptor totalAmount = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.TOTAL_AMOUNT_PROPERTY, Integer.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.vendingorder.VendingOrder.STATUS_PROPERTY, com.example.vendingmachineservice.orderstatus.OrderStatus.INTERNAL_TYPE, com.example.vendingmachineservice.orderstatus.OrderStatus.VENDING_ORDER_LIST_PROPERTY, com.example.vendingmachineservice.orderstatus.OrderStatus.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.TITLE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.TOTAL_AMOUNT_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorder.VendingOrder.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.orderpayment.OrderPayment.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.orderpayment.OrderPayment.class);
      entityDescriptor.with("name", "Order Payment")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor vendingOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.orderpayment.OrderPayment.VENDING_ORDER_PROPERTY, com.example.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE, com.example.vendingmachineservice.vendingorder.VendingOrder.ORDER_PAYMENT_LIST_PROPERTY, com.example.vendingmachineservice.vendingorder.VendingOrder.class)
      ;
      PropertyDescriptor paymentMethod = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_METHOD_PROPERTY, com.example.vendingmachineservice.paymentmethod.PaymentMethod.INTERNAL_TYPE, com.example.vendingmachineservice.paymentmethod.PaymentMethod.ORDER_PAYMENT_LIST_PROPERTY, com.example.vendingmachineservice.paymentmethod.PaymentMethod.class)
      ;
      PropertyDescriptor paymentStatus = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_STATUS_PROPERTY, com.example.vendingmachineservice.paymentstatus.PaymentStatus.INTERNAL_TYPE, com.example.vendingmachineservice.paymentstatus.PaymentStatus.ORDER_PAYMENT_LIST_PROPERTY, com.example.vendingmachineservice.paymentstatus.PaymentStatus.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.AMOUNT_PROPERTY, Integer.class)
      ;
      PropertyDescriptor paymentTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor transactionId = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.TRANSACTION_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.NAME_PROPERTY).with("isPassword", "false")
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




      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.AMOUNT_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.PAYMENT_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.TRANSACTION_ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.orderpayment.OrderPayment.VERSION_PROPERTY).with("isPassword", "false")
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
      entityDescriptor.setType(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.class);
      entityDescriptor.with("name", "Vending Order Item")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor vendingOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.VENDING_ORDER_PROPERTY, com.example.vendingmachineservice.vendingorder.VendingOrder.INTERNAL_TYPE, com.example.vendingmachineservice.vendingorder.VendingOrder.VENDING_ORDER_ITEM_LIST_PROPERTY, com.example.vendingmachineservice.vendingorder.VendingOrder.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.PRODUCT_PROPERTY, com.example.vendingmachineservice.product.Product.INTERNAL_TYPE, com.example.vendingmachineservice.product.Product.VENDING_ORDER_ITEM_LIST_PROPERTY, com.example.vendingmachineservice.product.Product.class)
      ;
      PropertyDescriptor quantity = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.QUANTITY_PROPERTY, Integer.class)
      ;
      PropertyDescriptor price = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.PRICE_PROPERTY, Integer.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.AMOUNT_PROPERTY, Integer.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.NAME_PROPERTY).with("isPassword", "false")
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



      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.QUANTITY_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.PRICE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.AMOUNT_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerDataService() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.vendingmachineservice.dataservice.DataService.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.vendingmachineservice.dataservice.DataService.class);
      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.dataservice.DataService.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.dataservice.DataService.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor jdbcInfo = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.dataservice.DataService.JDBC_INFO_PROPERTY, String.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.vendingmachineservice.dataservice.DataService.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.vendingmachineservice.dataservice.DataService.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.dataservice.DataService.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "postgres")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.dataservice.DataService.JDBC_INFO_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "org.postgresql,postgresql,org.postgresql.Driver")
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

      entityDescriptor.findProperty(com.example.vendingmachineservice.dataservice.DataService.VERSION_PROPERTY).with("isPassword", "false")
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