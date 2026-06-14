package com.doublechaintech.vendingmachineservice;

import com.doublechaintech.vendingmachineservice.orderstatus.OrderStatus;
import com.doublechaintech.vendingmachineservice.paymentmethod.PaymentMethod;
import com.doublechaintech.vendingmachineservice.vendingmachine.VendingMachine;

public interface Constants  {
  public static final long VENDING_MACHINE_ID = 1l;
  public static final VendingMachine VENDING_MACHINE = VendingMachine.refer(VENDING_MACHINE_ID);
  public static final long ORDER_STATUS_PENDING_ID = 1001l ;
  public static final OrderStatus ORDER_STATUS_PENDING = OrderStatus.refer(ORDER_STATUS_PENDING_ID);public static final long ORDER_STATUS_PAID_ID = 1002l ;
  public static final OrderStatus ORDER_STATUS_PAID = OrderStatus.refer(ORDER_STATUS_PAID_ID);public static final long ORDER_STATUS_DISPENSING_ID = 1003l ;
  public static final OrderStatus ORDER_STATUS_DISPENSING = OrderStatus.refer(ORDER_STATUS_DISPENSING_ID);public static final long ORDER_STATUS_COMPLETED_ID = 1004l ;
  public static final OrderStatus ORDER_STATUS_COMPLETED = OrderStatus.refer(ORDER_STATUS_COMPLETED_ID);
  public static final long PAYMENT_METHOD_WECHAT_ID = 2001l ;
  public static final PaymentMethod PAYMENT_METHOD_WECHAT = PaymentMethod.refer(PAYMENT_METHOD_WECHAT_ID);public static final long PAYMENT_METHOD_ALIPAY_ID = 2002l ;
  public static final PaymentMethod PAYMENT_METHOD_ALIPAY = PaymentMethod.refer(PAYMENT_METHOD_ALIPAY_ID);public static final long PAYMENT_METHOD_CREDIT_CARD_ID = 2003l ;
  public static final PaymentMethod PAYMENT_METHOD_CREDIT_CARD = PaymentMethod.refer(PAYMENT_METHOD_CREDIT_CARD_ID);
}