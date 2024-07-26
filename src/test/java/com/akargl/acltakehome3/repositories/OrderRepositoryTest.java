package com.akargl.acltakehome3.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.akargl.acltakehome3.entities.Order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void whenFindyAll_thenReturnOrder() {
    Order newOrder = new Order("p1", 2L, 1.23, "test street 123", "pending");
    entityManager.persist(newOrder);
    entityManager.flush();

    List<Order> orderList = orderRepository.findAll();
    assertNotNull(orderList);
    assertFalse(orderList.isEmpty());
  }
}