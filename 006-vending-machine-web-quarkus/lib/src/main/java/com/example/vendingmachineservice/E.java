package com.example.vendingmachineservice;

import com.example.vendingmachineservice.dataservice.DataService;
import com.example.vendingmachineservice.dataservice.DataServiceExpression;
import com.example.vendingmachineservice.orderpayment.OrderPayment;
import com.example.vendingmachineservice.orderpayment.OrderPaymentExpression;
import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.orderstatus.OrderStatusExpression;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentmethod.PaymentMethodExpression;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.paymentstatus.PaymentStatusExpression;
import com.example.vendingmachineservice.product.Product;
import com.example.vendingmachineservice.product.ProductExpression;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;
import com.example.vendingmachineservice.vendingmachine.VendingMachineExpression;
import com.example.vendingmachineservice.vendingorder.VendingOrder;
import com.example.vendingmachineservice.vendingorder.VendingOrderExpression;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItem;
import com.example.vendingmachineservice.vendingorderitem.VendingOrderItemExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static VendingMachineExpression<VendingMachine, VendingMachine, VendingMachine> vendingMachine(VendingMachine vendingMachine){
      return new VendingMachineExpression(new ValueExpression(vendingMachine));
  }
  public static OrderStatusExpression<OrderStatus, OrderStatus, OrderStatus> orderStatus(OrderStatus orderStatus){
      return new OrderStatusExpression(new ValueExpression(orderStatus));
  }
  public static PaymentMethodExpression<PaymentMethod, PaymentMethod, PaymentMethod> paymentMethod(PaymentMethod paymentMethod){
      return new PaymentMethodExpression(new ValueExpression(paymentMethod));
  }
  public static PaymentStatusExpression<PaymentStatus, PaymentStatus, PaymentStatus> paymentStatus(PaymentStatus paymentStatus){
      return new PaymentStatusExpression(new ValueExpression(paymentStatus));
  }
  public static ProductExpression<Product, Product, Product> product(Product product){
      return new ProductExpression(new ValueExpression(product));
  }
  public static VendingOrderExpression<VendingOrder, VendingOrder, VendingOrder> vendingOrder(VendingOrder vendingOrder){
      return new VendingOrderExpression(new ValueExpression(vendingOrder));
  }
  public static OrderPaymentExpression<OrderPayment, OrderPayment, OrderPayment> orderPayment(OrderPayment orderPayment){
      return new OrderPaymentExpression(new ValueExpression(orderPayment));
  }
  public static VendingOrderItemExpression<VendingOrderItem, VendingOrderItem, VendingOrderItem> vendingOrderItem(VendingOrderItem vendingOrderItem){
      return new VendingOrderItemExpression(new ValueExpression(vendingOrderItem));
  }
  public static DataServiceExpression<DataService, DataService, DataService> dataService(DataService dataService){
      return new DataServiceExpression(new ValueExpression(dataService));
  }
}