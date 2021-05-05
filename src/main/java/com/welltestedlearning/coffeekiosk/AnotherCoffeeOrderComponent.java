package com.welltestedlearning.coffeekiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnotherCoffeeOrderComponent {

    @Autowired
    public AnotherCoffeeOrderComponent(CoffeeOrderComponent coffeeOrderComponent) {
        System.out.println("AnotherCoffeeOrderComponent with @Component has been instantiated.");
    }

}
