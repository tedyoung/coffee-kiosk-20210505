package com.welltestedlearning.coffeekiosk.adapter.out.currency;

import com.welltestedlearning.coffeekiosk.domain.CurrencyConversion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Profile("prod")
@Service
public class HttpCurrencyConversionService implements CurrencyConversion {

  // URI with TEMPLATE VARIABLES
  private static final String uriTemplate ="http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

  private RestTemplate restTemplate = new RestTemplate();

  @Override
  public int convertToBritishPound(int amount) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", "USD");
    uriVariables.put("to", "GBP");
    uriVariables.put("amount", String.valueOf(amount));

    ConvertedCurrency converted = restTemplate.getForObject(uriTemplate, ConvertedCurrency.class, uriVariables);

    return converted.getConverted().intValue();
  }

}
