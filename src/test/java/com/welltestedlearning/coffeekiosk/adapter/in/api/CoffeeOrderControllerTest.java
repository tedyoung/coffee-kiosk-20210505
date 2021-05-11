package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.InMemoryCoffeeOrderRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CoffeeOrderControllerTest {

  @Test
  public void getOfCoffeeOrderReturnsResponse() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new InMemoryCoffeeOrderRepository();
    CoffeeOrderController coffeeOrderController = new CoffeeOrderController(coffeeOrderRepository);
    CoffeeOrderResponse coffeeOrderResponse = coffeeOrderController.coffeeOrder(10L);

    assertThat(coffeeOrderResponse.getId())
        .isEqualTo(10L);
    assertThat(coffeeOrderResponse.getCoffeeItems())
        .hasSize(1);
  }

}