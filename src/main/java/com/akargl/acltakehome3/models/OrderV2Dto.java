package com.akargl.acltakehome3.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link com.akargl.acltakehome3.entities.Order}
 */

@Setter
@Getter
@NoArgsConstructor
public class OrderV2Dto extends OrderDto {
  private String deliveryAddress = null;
  private String status = null;

  public OrderV2Dto(Long id, String product, Long quantity, Double price, String deliveryAddress, String status) {
    super(id, product, quantity, price);
    this.deliveryAddress = deliveryAddress;
    this.status = status;
  }
}
