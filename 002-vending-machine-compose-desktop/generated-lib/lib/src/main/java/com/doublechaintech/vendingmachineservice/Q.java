package com.doublechaintech.vendingmachineservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest<com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine> vendingMachines(){
      return new com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest<com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine> vendingMachinesWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineRequest(com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusRequest<com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus> orderStatuses(){
      return new com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusRequest(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusRequest<com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus> orderStatusesWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusRequest(com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodRequest<com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod> paymentMethods(){
      return new com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodRequest(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodRequest<com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod> paymentMethodsWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodRequest(com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.product.ProductRequest<com.doublechaintech.vendingmachineservice.product.Product> products(){
      return new com.doublechaintech.vendingmachineservice.product.ProductRequest(com.doublechaintech.vendingmachineservice.product.Product.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.product.ProductRequest<com.doublechaintech.vendingmachineservice.product.Product> productsWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.product.ProductRequest(com.doublechaintech.vendingmachineservice.product.Product.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest<com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder> vendingOrders(){
      return new com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest<com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder> vendingOrdersWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderRequest(com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentRequest<com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment> orderPayments(){
      return new com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentRequest(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentRequest<com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment> orderPaymentsWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.orderpayment.OrderPaymentRequest(com.doublechaintech.vendingmachineservice.orderpayment.OrderPayment.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemRequest<com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem> vendingOrderItems(){
      return new com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemRequest(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemRequest<com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem> vendingOrderItemsWithMinimalFields(){
      return new com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItemRequest(com.doublechaintech.vendingmachineservice.vendingorderitem.VendingOrderItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}