package com.welltestedlearning.coffeekiosk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderController {

  @GetMapping("/api/coffee/order")
  public CoffeeItemResponse coffeeItem() {
    CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
    return CoffeeItemResponse.from(coffeeItem);
  }

}
