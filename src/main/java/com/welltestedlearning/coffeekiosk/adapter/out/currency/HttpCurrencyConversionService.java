package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.CurrencyConfig;
import com.welltestedlearning.coffeekiosk.domain.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Profile("prod")
@Service
public class HttpCurrencyConversionService implements CurrencyConversion {

  private RestTemplate restTemplate = new RestTemplate();

  private final CurrencyConfig currencyConfig;

  @Autowired
  public HttpCurrencyConversionService(CurrencyConfig currencyConfig) {
    this.currencyConfig = currencyConfig;
  }

  @Override
  public int convertToBritishPound(int amount) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", "USD");
    uriVariables.put("to", "GBP");
    uriVariables.put("amount", String.valueOf(amount));

    ConvertedCurrency converted = restTemplate.getForObject(currencyConfig.getUriTemplate(),
                                                            ConvertedCurrency.class, uriVariables);

    return converted.getConverted().intValue();
  }

}
