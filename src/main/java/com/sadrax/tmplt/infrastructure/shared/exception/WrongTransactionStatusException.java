package com.sadrax.tmplt.infrastructure.shared.exception;

public class WrongTransactionStatusException extends RuntimeException {

  public WrongTransactionStatusException() {
    super();
  }

  public WrongTransactionStatusException(String message) {
    super(message);
  }

  public WrongTransactionStatusException(String message, Throwable cause) {
    super(message, cause);
  }
}
