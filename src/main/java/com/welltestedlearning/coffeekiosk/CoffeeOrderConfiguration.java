package com.welltestedlearning.coffeekiosk;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeOrderConfiguration {

    public CoffeeOrderConfiguration() {
        System.out.println("CoffeeOrderConfiguration with @Configuration has been instantiated.");
    }

}
