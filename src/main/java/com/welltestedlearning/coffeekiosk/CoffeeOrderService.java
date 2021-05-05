package com.welltestedlearning.coffeekiosk;

import org.springframework.stereotype.Service;

@Service
public class CoffeeOrderService {

    public CoffeeOrderService() {
        System.out.println("CoffeeOrderService with @Service has been instantiated.");
    }

    public String name() {
        return "I'm Coffee Central Service";
    }

}
