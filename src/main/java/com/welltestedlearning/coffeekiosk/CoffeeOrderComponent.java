package com.welltestedlearning.coffeekiosk;

import org.springframework.stereotype.Component;

@Component
public class CoffeeOrderComponent {

    public CoffeeOrderComponent() {
        System.out.println("CoffeeOrderComponent with @Component has been instantiated.");
    }

}
