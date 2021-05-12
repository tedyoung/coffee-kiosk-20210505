package com.welltestedlearning.coffeekiosk;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "currency")
@ConstructorBinding
@Validated
public class CurrencyConfig {

  @NotBlank
  private final String uriTemplate;

  public CurrencyConfig(String uriTemplate) {
    this.uriTemplate = uriTemplate;
  }

  public String getUriTemplate() {
    return uriTemplate;
  }
}
