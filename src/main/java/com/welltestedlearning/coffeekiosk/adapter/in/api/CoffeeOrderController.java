package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // Spring-Managed Bean
public class CoffeeOrderController {

  private final CoffeeOrderRepository coffeeOrderRepository;

  @Autowired
  public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository) {
    this.coffeeOrderRepository = coffeeOrderRepository;
  }

  @GetMapping("/api/coffee/orders/{id}")
  public CoffeeOrderResponse coffeeOrder(@PathVariable("id") long orderId) {
    Optional<CoffeeOrder> order = coffeeOrderRepository.findById(orderId);
    return CoffeeOrderResponse.from(order.get());
  }

}
