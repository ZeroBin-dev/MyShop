package com.cyb.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

  private Long id;
  private String name;
  private String description;
  private double price;
  private double stock;
  private String created_at;

}
