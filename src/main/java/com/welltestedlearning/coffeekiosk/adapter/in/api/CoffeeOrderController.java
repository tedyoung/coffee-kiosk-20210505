package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController // Spring-Managed Bean
public class CoffeeOrderController {

  private final CoffeeOrderRepository coffeeOrderRepository;
  private final CurrencyConversion currencyConversion;

  @Value("${order.price.currency.prefix}")
  private String currencyPrefix = "$";

  @Autowired
  public CoffeeOrderController(CoffeeOrderRepository coffeeOrderRepository,
                               CurrencyConversion currencyConversion) {
    this.coffeeOrderRepository = coffeeOrderRepository;
    this.currencyConversion = currencyConversion;
  }

  @GetMapping("/api/coffee/orders/{id}")
  public ResponseEntity<CoffeeOrderResponse> coffeeOrder(
      @PathVariable("id") long orderId,
      @RequestParam(value = "currency", defaultValue = "usd") String currency) {

    requireValidOrderId(orderId);

    Optional<CoffeeOrder> order = coffeeOrderRepository.findById(orderId);
    if (order.isPresent()) {
      int totalPrice = convertToRequestedCurrency(currency, order.get());
      return orderResponseEntity(order, totalPrice);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  private int convertToRequestedCurrency(String currency, CoffeeOrder coffeeOrder) {
    int totalPrice = coffeeOrder.totalPrice();
    if (currency.equalsIgnoreCase("gbp")) {
      totalPrice = currencyConversion.convertToBritishPound(totalPrice);
    }
    return totalPrice;
  }

  private ResponseEntity<CoffeeOrderResponse> orderResponseEntity(Optional<CoffeeOrder> order, int totalPrice) {
    CoffeeOrderResponse response = CoffeeOrderResponse.from(
        order.get(), currencyPrefix, totalPrice);
    return ResponseEntity.ok(response);
  }

  private void requireValidOrderId(long orderId) {
    if (orderId < 0) {
      throw new IllegalArgumentException("Invalid Order ID");
    }
  }

  @PostMapping("/api/coffee/orders")
  public ResponseEntity createCoffeeOrder(
      @RequestBody CoffeeOrderRequest coffeeOrderRequest) {
    CoffeeOrder coffeeOrder = new CoffeeOrder(
        coffeeOrderRequest.getCustomerName(), LocalDateTime.now());
    CoffeeItem coffeeItem = new CoffeeItem(coffeeOrderRequest.getSize(), coffeeOrderRequest.getKind(),
                                           coffeeOrderRequest.getCreamer());
    coffeeOrder.add(coffeeItem);

    CoffeeOrder savedCoffeeOrder = coffeeOrderRepository.save(coffeeOrder);

    return ResponseEntity.created(
        URI.create("/api/coffee/orders/" + savedCoffeeOrder.getId())
    ).build();
  }

}
