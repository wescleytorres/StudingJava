package com.wt.rentalcar.controllers.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsertError {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant timestamp;
  private Integer status;
  private String message;
  private List<ErrorHandler> errors = new ArrayList<>();
  private String path;

  public InsertError() {
  }

  public InsertError(Instant timestamp, Integer status, String message, List<ErrorHandler> errors, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.message = message;
    this.errors = errors;
    this.path = path;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public List<ErrorHandler> getErrors() {
    return errors;
  }

}
