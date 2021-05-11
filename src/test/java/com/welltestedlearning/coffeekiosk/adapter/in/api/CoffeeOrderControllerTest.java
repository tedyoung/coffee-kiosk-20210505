package com.welltestedlearning.coffeekiosk.adapter.in.api;

import com.welltestedlearning.coffeekiosk.domain.CoffeeItem;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrder;
import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import com.welltestedlearning.coffeekiosk.domain.InMemoryCoffeeOrderRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class CoffeeOrderControllerTest {

  @Test
  public void getOfCoffeeOrderReturnsResponse() throws Exception {
    CoffeeOrderRepository coffeeOrderRepository = new InMemoryCoffeeOrderRepository();
    CoffeeOrder order = createCoffeeOrderWithOneItemAndIdOf(10L, 21L);
    coffeeOrderRepository.save(order);
    CoffeeOrderController coffeeOrderController =
        new CoffeeOrderController(coffeeOrderRepository);

    CoffeeOrderResponse coffeeOrderResponse =
        coffeeOrderController.coffeeOrder(10L).getBody();

    assertThat(coffeeOrderResponse.getId())
        .isEqualTo(10L);
    assertThat(coffeeOrderResponse.getCoffeeItems())
        .hasSize(1);
    assertThat(coffeeOrderResponse.getCoffeeItems().get(0).getId())
        .isEqualTo(21L);
  }

  private CoffeeOrder createCoffeeOrderWithOneItemAndIdOf(long coffeeOrderId,
                                                          long coffeeItemId) {
    CoffeeItem coffeeItem = new CoffeeItem("small", "latte", "milk");
    coffeeItem.setId(coffeeItemId);
    CoffeeOrder coffeeOrder = new CoffeeOrder("test name", LocalDateTime.of(2020, 10, 11, 12, 13));
    coffeeOrder.add(coffeeItem);
    coffeeOrder.setId(coffeeOrderId);
    return coffeeOrder;
  }

}