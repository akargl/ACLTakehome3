package com.akargl.acltakehome3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String product;
  private Long quantity;
  private Double price;
  private String deliveryAddress;
  private String status;

  public Order(String product, Long quantity, Double price, String deliveryAddress, String status) {
    this.product = product;
    this.quantity = quantity;
    this.price = price;
    this.deliveryAddress = deliveryAddress;
    this.status = status;
  }

  public Order() {

  }
}
