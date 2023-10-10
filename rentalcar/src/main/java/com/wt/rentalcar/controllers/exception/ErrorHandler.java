package com.wt.rentalcar.controllers.exception;

public class ErrorHandler {
  private String filed;
  private String message;

  public ErrorHandler() {
  }

  public ErrorHandler(String filed, String message) {
    this.filed = filed;
    this.message = message;
  }

  public String getField() {
    return filed;
  }

  public void setField(String filed) {
    this.filed = filed;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
