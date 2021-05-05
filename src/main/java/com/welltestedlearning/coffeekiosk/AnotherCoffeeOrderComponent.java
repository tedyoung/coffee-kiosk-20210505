package com.welltestedlearning.coffeekiosk;

import org.springframework.stereotype.Component;

@Component
public class AnotherCoffeeOrderComponent {

    public AnotherCoffeeOrderComponent() {
        System.out.println("AnotherCoffeeOrderComponent with @Component has been instantiated.");
    }

}
