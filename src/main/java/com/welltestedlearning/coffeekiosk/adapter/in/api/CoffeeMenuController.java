package com.welltestedlearning.coffeekiosk.adapter.in.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMenuController {

  @GetMapping("/api/coffee/menu/sizes")
//  @RequestMapping(value = "/api/coffee/menu/sizes", method = RequestMethod.GET)
  public String getCoffeeSizes() {
    return "small";
  }

}
