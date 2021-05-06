package com.welltestedlearning.coffeekiosk;

import com.welltestedlearning.coffeekiosk.domain.CoffeeOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CoffeeKioskApplicationTests {

    @Autowired
    CoffeeOrderRepository coffeeOrderRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void sampleDataWasLoaded() throws Exception {
        assertThat(coffeeOrderRepository.findAll())
            .hasSize(1);
    }

}
