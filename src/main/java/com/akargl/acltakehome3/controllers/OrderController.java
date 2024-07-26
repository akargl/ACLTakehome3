package com.akargl.acltakehome3.controllers;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akargl.acltakehome3.entities.Order;
import com.akargl.acltakehome3.models.OrderDto;

@RestController
public class OrderController extends AbstractOrderController<OrderDto> {

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/orders")
  @Override
  public ResponseEntity<List<OrderDto>> getOrders() {
    return super.getOrders();
  }

  @GetMapping("/orders/{id}")
  @Override
  public ResponseEntity<OrderDto> getOrder(long id) {
    return super.getOrder(id);
  }

  @PostMapping("/orders")
  @Override
  public ResponseEntity<OrderDto> createOrder(OrderDto order) {
    return super.createOrder(order);
  }

  @PutMapping("/orders/{id}")
  @Override
  public ResponseEntity<OrderDto> updateOrder(OrderDto order, long id) {
    return super.updateOrder(order, id);
  }

  @Override
  protected OrderDto convertToDto(Order orderEntity) {
    return modelMapper.map(orderEntity, OrderDto.class);
  }

  @Override
  protected Order convertToEntity(OrderDto orderDto) {
    return modelMapper.map(orderDto, Order.class);
  }
}
