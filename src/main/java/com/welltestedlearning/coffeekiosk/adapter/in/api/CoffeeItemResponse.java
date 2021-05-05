package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;

public class CoffeeItemResponse {
  private long id;
  private String size;
  private String kind;
  private String creamer;
  private String price;

  public static CoffeeItemResponse from(CoffeeItem coffeeItem) {
    CoffeeItemResponse coffeeItemResponse = new CoffeeItemResponse();
    if (coffeeItem.getId() != null) {
      coffeeItemResponse.setId(coffeeItem.getId());
    }
    coffeeItemResponse.setCreamer(coffeeItem.creamer());
    coffeeItemResponse.setSize(coffeeItem.size());
    coffeeItemResponse.setKind(coffeeItem.kind());
    coffeeItemResponse.setPrice(String.valueOf(coffeeItem.price()));
    return coffeeItemResponse;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getCreamer() {
    return creamer;
  }

  public void setCreamer(String creamer) {
    this.creamer = creamer;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}
