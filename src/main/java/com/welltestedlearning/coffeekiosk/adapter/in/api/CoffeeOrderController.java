package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController // Spring-Managed Bean
public class CoffeeOrderController {

  private final CoffeeOrderRepository coffeeOrderRepository;

  @Value("${order.price.currency.prefix}")
  private String currencyPrefix;

  @Autowired
  public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository) {
    this.coffeeOrderRepository = coffeeOrderRepository;
  }

  @GetMapping("/api/coffee/orders/{id}")
  public ResponseEntity<CoffeeOrderResponse> coffeeOrder(@PathVariable("id") long orderId) {
    if (orderId < 0) {
      throw new IllegalArgumentException("Invalid Order ID");
    }
    Optional<CoffeeOrder> order = coffeeOrderRepository.findById(orderId);
    if (order.isPresent()) {
      CoffeeOrderResponse response = CoffeeOrderResponse.from(order.get(), currencyPrefix);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
