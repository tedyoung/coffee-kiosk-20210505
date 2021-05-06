package com.welltestedlearning.coffeekiosk.domain;

import java.util.List;
import java.util.Optional;

// DOMAIN REPOSITORY
public interface CoffeeOrderRepository {

  Optional<CoffeeOrder> findById(Long id);

  CoffeeOrder save(CoffeeOrder coffeeOrder);

  List<CoffeeOrder> findAll();

}
