package com.welltestedlearning.coffeekiosk.adapter.in.api;

public class CoffeeOrderRequest {
  private String customerName;
  private String size;
  private String creamer;
  private String kind;

  public CoffeeOrderRequest() {
  }

  public CoffeeOrderRequest(String customerName, String size, String creamer, String kind) {
    this.customerName = customerName;
    this.size = size;
    this.creamer = creamer;
    this.kind = kind;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getCreamer() {
    return creamer;
  }

  public void setCreamer(String creamer) {
    this.creamer = creamer;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }
}
