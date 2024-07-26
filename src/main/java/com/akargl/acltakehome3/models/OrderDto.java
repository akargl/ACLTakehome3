package com.akargl.acltakehome3.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link com.akargl.acltakehome3.entities.Order}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {
  private Long id;
  private String product;
  private Long quantity;
  private Double price;
}