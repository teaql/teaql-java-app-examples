package com.example.vendingmachineservice;

import org.slf4j.MDC;

public class CustomUserContext extends VendingMachineServiceUserContext {
  public static final String USER_CONTEXT = "User-Context";
  public static final String ID_SPACE = "ID_SPACE";
  public static final String MERCHANT = "merchant";
  public static final String JOB = "job";

  @Override
  public void init(Object request) {
    super.init(request);
    String idSpace = getIdSpace();
    if (idSpace != null) {
      MDC.put(ID_SPACE, idSpace);
    }
  }

  public String getIdSpace() {
    return getHeader(ID_SPACE);
  }
}