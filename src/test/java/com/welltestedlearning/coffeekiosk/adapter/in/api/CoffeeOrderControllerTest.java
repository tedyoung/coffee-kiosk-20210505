package com.welltestedlearning.coffeekiosk.adapter.in.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CoffeeOrderControllerTest {

  @Test
  public void getOfCoffeeOrderReturnsResponse() throws Exception {
    CoffeeOrderController coffeeOrderController = new CoffeeOrderController();
    CoffeeOrderResponse coffeeOrderResponse = coffeeOrderController.coffeeOrder(10L);

    assertThat(coffeeOrderResponse.getId())
        .isEqualTo(10L);
    assertThat(coffeeOrderResponse.getCoffeeItems())
        .hasSize(1);
  }

}