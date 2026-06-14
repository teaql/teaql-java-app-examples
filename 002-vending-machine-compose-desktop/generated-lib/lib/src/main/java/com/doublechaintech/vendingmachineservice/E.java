package com.doublechaintech.vendingmachineservice;

import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatusExpression;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethodExpression;
import com.doublechaintech.vendingmachineservice.product.Product;
import com.doublechaintech.vendingmachineservice.product.ProductExpression;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachineExpression;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrder;
import com.doublechaintech.vendingmachineservice.vendingorder.VendingOrderExpression;
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
  public static ProductExpression<Product, Product, Product> product(Product product){
      return new ProductExpression(new ValueExpression(product));
  }
  public static VendingOrderExpression<VendingOrder, VendingOrder, VendingOrder> vendingOrder(VendingOrder vendingOrder){
      return new VendingOrderExpression(new ValueExpression(vendingOrder));
  }
}