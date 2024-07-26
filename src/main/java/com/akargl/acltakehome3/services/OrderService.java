package com.akargl.acltakehome3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.akargl.acltakehome3.entities.Order;
import com.akargl.acltakehome3.repositories.OrderRepository;

@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  public Order getOrder(long id) {
    Optional<Order> order = orderRepository.findById(id);
    if (order.isPresent()) {
      return order.get();
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
    }
  }

  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order updateOrder(Order order, long id) {
    if (order.getId() == null) {
      order.setId(id);
    }

    if (id != order.getId()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Order id mismatch in body and query path");
    }

    return orderRepository.save(order);
  }
}
