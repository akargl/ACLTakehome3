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
import com.akargl.acltakehome3.models.OrderV2Dto;

@RestController
public class OrderControllerV2 extends AbstractOrderController<OrderV2Dto> {

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/v2/orders")
  @Override
  public ResponseEntity<List<OrderV2Dto>> getOrders() {
    return super.getOrders();
  }

  @GetMapping("/v2/orders/{id}")
  @Override
  public ResponseEntity<OrderV2Dto> getOrder(long id) {
    return super.getOrder(id);
  }

  @PostMapping("/v2/orders")
  @Override
  public ResponseEntity<OrderV2Dto> createOrder(OrderV2Dto order) {
    return super.createOrder(order);
  }

  @PutMapping("/v2/orders/{id}")
  @Override
  public ResponseEntity<OrderV2Dto> updateOrder(OrderV2Dto order, long id) {
    return super.updateOrder(order, id);
  }

  @Override
  protected OrderV2Dto convertToDto(Order orderEntity) {
    return modelMapper.map(orderEntity, OrderV2Dto.class);
  }

  @Override
  protected Order convertToEntity(OrderV2Dto orderDto) {
    return modelMapper.map(orderDto, Order.class);
  }
}
