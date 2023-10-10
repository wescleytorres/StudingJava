package com.wt.rentalcar.controllers.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wt.rentalcar.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), "Not Found", e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<InsertError> argumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {

    List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();

    List<ErrorHandler> list = new ArrayList<>();

    fieldErrorList.forEach(error -> list.add(new ErrorHandler(error.getField(), error.getDefaultMessage())));

    HttpStatus status = HttpStatus.BAD_REQUEST;
    InsertError err = new InsertError(Instant.now(), status.value(), "Bad Request", list,
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<StandardError> handleDatabaseException(DataIntegrityViolationException e,
      HttpServletRequest request) {

    HttpStatus status = HttpStatus.CONFLICT;
    StandardError err = new StandardError(Instant.now(), status.value(), "Unique index or primary key violation",
        e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}
