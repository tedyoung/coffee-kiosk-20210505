package com.welltestedlearning.coffeekiosk.adapter.in.api;

public class ErrorResponse {
  private final int statusCode;
  private final String message;

  public ErrorResponse(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getMessage() {
    return message;
  }
}
