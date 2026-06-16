package com.example.vendingmachineservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.vendingmachineservice.vendingmachine.VendingMachineRequest<com.example.vendingmachineservice.vendingmachine.VendingMachine> vendingMachines(){
      return new com.example.vendingmachineservice.vendingmachine.VendingMachineRequest(com.example.vendingmachineservice.vendingmachine.VendingMachine.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.vendingmachine.VendingMachineRequest<com.example.vendingmachineservice.vendingmachine.VendingMachine> vendingMachinesWithMinimalFields(){
      return new com.example.vendingmachineservice.vendingmachine.VendingMachineRequest(com.example.vendingmachineservice.vendingmachine.VendingMachine.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.orderstatus.OrderStatusRequest<com.example.vendingmachineservice.orderstatus.OrderStatus> orderStatuses(){
      return new com.example.vendingmachineservice.orderstatus.OrderStatusRequest(com.example.vendingmachineservice.orderstatus.OrderStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.orderstatus.OrderStatusRequest<com.example.vendingmachineservice.orderstatus.OrderStatus> orderStatusesWithMinimalFields(){
      return new com.example.vendingmachineservice.orderstatus.OrderStatusRequest(com.example.vendingmachineservice.orderstatus.OrderStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest<com.example.vendingmachineservice.paymentmethod.PaymentMethod> paymentMethods(){
      return new com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest(com.example.vendingmachineservice.paymentmethod.PaymentMethod.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest<com.example.vendingmachineservice.paymentmethod.PaymentMethod> paymentMethodsWithMinimalFields(){
      return new com.example.vendingmachineservice.paymentmethod.PaymentMethodRequest(com.example.vendingmachineservice.paymentmethod.PaymentMethod.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest<com.example.vendingmachineservice.paymentstatus.PaymentStatus> paymentStatuses(){
      return new com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest(com.example.vendingmachineservice.paymentstatus.PaymentStatus.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest<com.example.vendingmachineservice.paymentstatus.PaymentStatus> paymentStatusesWithMinimalFields(){
      return new com.example.vendingmachineservice.paymentstatus.PaymentStatusRequest(com.example.vendingmachineservice.paymentstatus.PaymentStatus.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.product.ProductRequest<com.example.vendingmachineservice.product.Product> products(){
      return new com.example.vendingmachineservice.product.ProductRequest(com.example.vendingmachineservice.product.Product.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.product.ProductRequest<com.example.vendingmachineservice.product.Product> productsWithMinimalFields(){
      return new com.example.vendingmachineservice.product.ProductRequest(com.example.vendingmachineservice.product.Product.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.vendingorder.VendingOrderRequest<com.example.vendingmachineservice.vendingorder.VendingOrder> vendingOrders(){
      return new com.example.vendingmachineservice.vendingorder.VendingOrderRequest(com.example.vendingmachineservice.vendingorder.VendingOrder.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.vendingorder.VendingOrderRequest<com.example.vendingmachineservice.vendingorder.VendingOrder> vendingOrdersWithMinimalFields(){
      return new com.example.vendingmachineservice.vendingorder.VendingOrderRequest(com.example.vendingmachineservice.vendingorder.VendingOrder.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.orderpayment.OrderPaymentRequest<com.example.vendingmachineservice.orderpayment.OrderPayment> orderPayments(){
      return new com.example.vendingmachineservice.orderpayment.OrderPaymentRequest(com.example.vendingmachineservice.orderpayment.OrderPayment.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.orderpayment.OrderPaymentRequest<com.example.vendingmachineservice.orderpayment.OrderPayment> orderPaymentsWithMinimalFields(){
      return new com.example.vendingmachineservice.orderpayment.OrderPaymentRequest(com.example.vendingmachineservice.orderpayment.OrderPayment.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.vendingmachineservice.vendingorderitem.VendingOrderItemRequest<com.example.vendingmachineservice.vendingorderitem.VendingOrderItem> vendingOrderItems(){
      return new com.example.vendingmachineservice.vendingorderitem.VendingOrderItemRequest(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.vendingmachineservice.vendingorderitem.VendingOrderItemRequest<com.example.vendingmachineservice.vendingorderitem.VendingOrderItem> vendingOrderItemsWithMinimalFields(){
      return new com.example.vendingmachineservice.vendingorderitem.VendingOrderItemRequest(com.example.vendingmachineservice.vendingorderitem.VendingOrderItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}