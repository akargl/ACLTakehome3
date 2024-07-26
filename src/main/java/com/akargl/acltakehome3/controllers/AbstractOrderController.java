package com.akargl.acltakehome3.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.akargl.acltakehome3.entities.Order;
import com.akargl.acltakehome3.models.OrderDto;
import com.akargl.acltakehome3.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public abstract class AbstractOrderController<T> {

  @Autowired
  private OrderService orderService;

  @Operation(summary = "Get all orders")
  public ResponseEntity<List<T>> getOrders() {
    List<T> orderDtos = orderService.getOrders().stream()
        .map(this::convertToDto).toList();

    return ResponseEntity.ok(orderDtos);
  }

  @Operation(summary = "Get one order by id")
  public ResponseEntity<T> getOrder(@PathVariable long id) {
    Order orderEntity = orderService.getOrder(id);
    return ResponseEntity.ok(convertToDto(orderEntity));
  }

  @Operation(summary = "Create new order")
  public ResponseEntity<T> createOrder(@RequestBody T order) {
    Order orderEntity = convertToEntity(order);
    T createdOrder = convertToDto(orderService.createOrder(orderEntity));
    return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
  }

  @Operation(summary = "Update existing order")
  public ResponseEntity<T> updateOrder(@RequestBody T order, @PathVariable long id) {
    Order orderEntity = convertToEntity(order);
    T updatedOrder = convertToDto(orderService.updateOrder(orderEntity, id));
    return ResponseEntity.ok(updatedOrder);
  }

  protected abstract T convertToDto(Order orderEntity);

  protected abstract Order convertToEntity(T orderDto);
}
