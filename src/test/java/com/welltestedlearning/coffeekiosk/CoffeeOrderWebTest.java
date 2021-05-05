package com.welltestedlearning.coffeekiosk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeOrderController.class)
class CoffeeOrderWebTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void getFromCoffeeOrderEndpointIs200Ok() throws Exception {
    mockMvc.perform(get("/api/coffee/order")
                        .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk());
  }

}