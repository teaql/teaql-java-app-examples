package com.example.vendingmachineservice;

import com.example.vendingmachineservice.dataservice.DataService;
import com.example.vendingmachineservice.orderstatus.OrderStatus;
import com.example.vendingmachineservice.paymentmethod.PaymentMethod;
import com.example.vendingmachineservice.paymentstatus.PaymentStatus;
import com.example.vendingmachineservice.vendingmachine.VendingMachine;

public interface Constants  {
  public static final long VENDING_MACHINE_ID = 1l;
  public static final VendingMachine VENDING_MACHINE = VendingMachine.refer(VENDING_MACHINE_ID);
  public static final long DATA_SERVICE_ID = 1l;
  public static final DataService DATA_SERVICE = DataService.refer(DATA_SERVICE_ID);
  public static final long ORDER_STATUS_PENDING_ID = 1001l ;
  public static final OrderStatus ORDER_STATUS_PENDING = OrderStatus.refer(ORDER_STATUS_PENDING_ID);public static final long ORDER_STATUS_PAID_ID = 1002l ;
  public static final OrderStatus ORDER_STATUS_PAID = OrderStatus.refer(ORDER_STATUS_PAID_ID);public static final long ORDER_STATUS_DISPENSING_ID = 1003l ;
  public static final OrderStatus ORDER_STATUS_DISPENSING = OrderStatus.refer(ORDER_STATUS_DISPENSING_ID);public static final long ORDER_STATUS_COMPLETED_ID = 1004l ;
  public static final OrderStatus ORDER_STATUS_COMPLETED = OrderStatus.refer(ORDER_STATUS_COMPLETED_ID);
  public static final long PAYMENT_METHOD_GOOGLE_PAY_ID = 2001l ;
  public static final PaymentMethod PAYMENT_METHOD_GOOGLE_PAY = PaymentMethod.refer(PAYMENT_METHOD_GOOGLE_PAY_ID);public static final long PAYMENT_METHOD_APPLE_PAY_ID = 2002l ;
  public static final PaymentMethod PAYMENT_METHOD_APPLE_PAY = PaymentMethod.refer(PAYMENT_METHOD_APPLE_PAY_ID);public static final long PAYMENT_METHOD_PAYPAL_ID = 2003l ;
  public static final PaymentMethod PAYMENT_METHOD_PAYPAL = PaymentMethod.refer(PAYMENT_METHOD_PAYPAL_ID);public static final long PAYMENT_METHOD_CREDIT_CARD_ID = 2004l ;
  public static final PaymentMethod PAYMENT_METHOD_CREDIT_CARD = PaymentMethod.refer(PAYMENT_METHOD_CREDIT_CARD_ID);
  public static final long PAYMENT_STATUS_PENDING_ID = 3001l ;
  public static final PaymentStatus PAYMENT_STATUS_PENDING = PaymentStatus.refer(PAYMENT_STATUS_PENDING_ID);public static final long PAYMENT_STATUS_SUCCESS_ID = 3002l ;
  public static final PaymentStatus PAYMENT_STATUS_SUCCESS = PaymentStatus.refer(PAYMENT_STATUS_SUCCESS_ID);public static final long PAYMENT_STATUS_FAILED_ID = 3003l ;
  public static final PaymentStatus PAYMENT_STATUS_FAILED = PaymentStatus.refer(PAYMENT_STATUS_FAILED_ID);
}