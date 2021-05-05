package com.welltestedlearning.coffeekiosk;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeOrderConfiguration {

    public CoffeeOrderConfiguration(CoffeeOrderService coffeeOrderService) {
        System.out.println();
        System.out.println(this.getClass().getName() + " has been instantiated.");
        System.out.println("  --> Was passed a reference to a dependency: " + coffeeOrderService);
        System.out.println();
    }

}
