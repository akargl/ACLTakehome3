package com.akargl.acltakehome3.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.akargl.acltakehome3.TestConfig;
import com.akargl.acltakehome3.entities.Order;
import com.akargl.acltakehome3.services.OrderService;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@WebMvcTest
@Import(TestConfig.class)
class OrderControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OrderService orderService;

  @Test
  public void givenOrders_whenGetAllOrders_thenCorrectResponse() throws Exception {
    List<Order> orders = new ArrayList<>();
    orders.add(new Order("p1", 2L, 1.23, "test street 123", "pending"));
    orders.add(new Order("p2", 1L, 4.44, null, null));

    Mockito.when(this.orderService.getOrders())
        .thenReturn(orders);

    this.mockMvc.perform(MockMvcRequestBuilders.get("/orders"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].product").value("p1"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].product").value("p2"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").doesNotExist());

    Mockito.verify(this.orderService, Mockito.times(1)).getOrders();
  }

}