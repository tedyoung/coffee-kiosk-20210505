package com.welltestedlearning.coffeekiosk;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeOrderController {

    public CoffeeOrderController() {
        System.out.println("CoffeeOrderController with @RestController has been instantiated.");
    }

}
