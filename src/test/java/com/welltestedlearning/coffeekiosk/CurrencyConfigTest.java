package com.welltestedlearning.coffeekiosk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CurrencyConfigTest {

  @Autowired
  private CurrencyConfig currencyConfig;

  @Test
  void configLoadedWithTemplate() {
    assertThat(currencyConfig.getUriTemplate())
        .isNotBlank()
        .contains("{from}");
  }
}
