package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.domain.CurrencyConversion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class StubCurrencyConversionService implements CurrencyConversion {
  @Override
  public int convertToBritishPound(int amount) {
    return 1234;
  }
}
