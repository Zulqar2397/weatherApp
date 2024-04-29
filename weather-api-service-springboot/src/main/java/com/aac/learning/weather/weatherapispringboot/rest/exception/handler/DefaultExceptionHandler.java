package com.aac.learning.weather.weatherapispringboot.rest.exception.handler;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Order
public class DefaultExceptionHandler {

  Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
  private final HttpServletRequest httpServletRequest;

  public DefaultExceptionHandler(HttpServletRequest httpServletRequest) {
    this.httpServletRequest = httpServletRequest;
  }
  //    @ExceptionHandler({Throwable.class})
  //    public ResponseEntity<String> handleThrowableException(Throwable ex){
  //        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  //    }
  @ExceptionHandler({HttpClientErrorException.class})
  public ResponseEntity<String> handleThrowableException(HttpClientErrorException ex) {
    return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
  }

  @ExceptionHandler({HttpMessageNotReadableException.class})
  public ResponseEntity<String> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
