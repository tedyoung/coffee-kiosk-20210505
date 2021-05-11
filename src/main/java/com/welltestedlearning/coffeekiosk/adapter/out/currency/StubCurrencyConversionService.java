package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.domain.CurrencyConversion;
import org.springframework.stereotype.Service;

@Service
public class StubCurrencyConversionService implements CurrencyConversion {
  @Override
  public int convertToBritishPound(int amount) {
    return 1234;
  }
}
