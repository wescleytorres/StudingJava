package com.wt.rentalcar.services.exception;

import java.util.UUID;

public class ObjectNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ObjectNotFoundException(UUID id) {
    super(("Resource not found. Id " + id));
  }
}
