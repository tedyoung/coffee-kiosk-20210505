package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController // Spring-Managed Bean
public class CoffeeOrderController {

  @GetMapping("/api/coffee/orders/{id}")
  public CoffeeOrderResponse coffeeOrder(@PathVariable("id") long orderId) {
    CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
    coffeeItem.setId(99L);
    CoffeeOrder coffeeOrder = new CoffeeOrder("Ted", LocalDateTime.of(2020, 10, 11, 12, 13));
    coffeeOrder.add(coffeeItem);
    coffeeOrder.setId(orderId);
    return CoffeeOrderResponse.from(coffeeOrder);
  }

}
