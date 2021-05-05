package com.welltestedlearning.coffeekiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeOrderService {

    @Autowired
    public CoffeeOrderService(CoffeeOrderComponent coffeeOrderComponent,
                              AnotherCoffeeOrderComponent anotherCoffeeOrderComponent) {
        System.out.println();
        System.out.println(this.getClass().getName() + " has been instantiated. ");
        System.out.println("  --> Was passed a reference to two dependencies: " + coffeeOrderComponent);
        System.out.println("  -->                                        and: " + anotherCoffeeOrderComponent);
        System.out.println();
    }

    public String name() {
        return "I'm Coffee Central Service";
    }

}
